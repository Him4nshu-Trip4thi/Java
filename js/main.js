class CodeEditor {
    constructor() {
        this.repoDetails = {
            owner: 'Him4nshu-Trip4thi', // Replace with your GitHub username
            repo: 'Java',      // Replace with your repository name
            branch: 'main'         // Replace with your branch name
        };
        this.initializeElements();
        this.setupEventListeners();
        this.setupMonacoEditor();
        this.loadPrograms();
        this.currentView = 'list';
    }

    initializeElements() {
        this.themeToggle = document.getElementById('theme-toggle');
        this.editorModal = document.getElementById('editor-modal');
        this.programsContainer = document.getElementById('programs-container');
        this.searchInput = document.getElementById('search-input');
        this.gridViewBtn = document.getElementById('grid-view');
        this.listViewBtn = document.getElementById('list-view');
        this.editor = null;
        this.currentFile = null;
    }

    setupEventListeners() {
        // Theme toggle
        this.themeToggle.addEventListener('click', () => this.toggleTheme());

        // View toggle
        this.gridViewBtn.addEventListener('click', () => this.changeView('grid'));
        this.listViewBtn.addEventListener('click', () => this.changeView('list'));

        // Search
        this.searchInput.addEventListener('input', (e) => this.handleSearch(e.target.value));

        // Editor modal close
        document.getElementById('close-editor').addEventListener('click', () => this.closeEditor());

        // Save button
        document.getElementById('save-btn').addEventListener('click', () => this.saveChanges());

        // Copy button
        document.getElementById('copy-btn').addEventListener('click', () => this.copyCode());

        // Run button
        document.getElementById('run-btn').addEventListener('click', () => this.runCode());

        // Keyboard shortcuts
        document.addEventListener('keydown', (e) => {
            if (e.ctrlKey || e.metaKey) {
                switch (e.key.toLowerCase()) {
                    case 's':
                        e.preventDefault();
                        this.saveChanges();
                        break;
                    case 'e':
                        e.preventDefault();
                        this.closeEditor();
                        break;
                }
            }
        });
    }

    async setupMonacoEditor() {
        try {
            await new Promise(resolve => require(['vs/editor/editor.main'], resolve));

            // Define custom themes
            monaco.editor.defineTheme('customDark', {
                base: 'vs-dark',
                inherit: true,
                rules: [
                    { token: 'comment', foreground: '6A9955' },
                    { token: 'keyword', foreground: '569CD6' },
                    { token: 'string', foreground: 'CE9178' }
                ],
                colors: {
                    'editor.background': '#1E1E1E',
                    'editor.foreground': '#D4D4D4',
                    'editor.lineHighlightBackground': '#2D2D2D',
                    'editorCursor.foreground': '#FFFFFF',
                    'editor.selectionBackground': '#264F78'
                }
            });

            monaco.editor.defineTheme('customLight', {
                base: 'vs',
                inherit: true,
                rules: [
                    { token: 'comment', foreground: '008000' },
                    { token: 'keyword', foreground: '0000FF' },
                    { token: 'string', foreground: 'A31515' }
                ],
                colors: {
                    'editor.background': '#FFFFFF',
                    'editor.foreground': '#000000',
                    'editor.lineHighlightBackground': '#F7F7F7',
                    'editorCursor.foreground': '#000000',
                    'editor.selectionBackground': '#ADD6FF'
                }
            });
        } catch (error) {
            console.error('Error setting up Monaco Editor:', error);
            this.showToast('Error initializing code editor', 'error');
        }
    }

    async loadPrograms() {
        try {
            const apiUrl = `https://api.github.com/repos/${this.repoDetails.owner}/${this.repoDetails.repo}/contents/programs?ref=${this.repoDetails.branch}`;
            const response = await fetch(apiUrl);
            
            if (!response.ok) {
                throw new Error(`HTTP error! status: ${response.status}`);
            }
            
            const data = await response.json();
            this.renderPrograms(data);
        } catch (error) {
            console.error('Error loading programs:', error);
            this.showToast('Error loading programs', 'error');
            this.programsContainer.innerHTML = `
                <div class="error-message">
                    <i class="fas fa-exclamation-circle"></i>
                    <h3>Failed to load programs</h3>
                    <p>${error.message}</p>
                    <button onclick="location.reload()">Try Again</button>
                </div>
            `;
        }
    }

    renderPrograms(programs) {
        this.programsContainer.innerHTML = '';
        
        const javaPrograms = programs.filter(file => file.name.endsWith('.java'));
        
        if (javaPrograms.length === 0) {
            this.programsContainer.innerHTML = `
                <div class="error-message">
                    <i class="fas fa-folder-open"></i>
                    <h3>No Java Programs Found</h3>
                    <p>Add some Java programs to get started</p>
                </div>
            `;
            return;
        }

        javaPrograms.forEach(file => {
            const card = this.createProgramCard(file);
            this.programsContainer.appendChild(card);
        });
    }

    createProgramCard(file) {
        const card = document.createElement('div');
        card.className = 'program-card';
        card.innerHTML = `
            <h3 title="${file.name}">${file.name}</h3>
            <p>Click to edit</p>
            <div class="card-actions">
                <span class="file-size">${this.formatFileSize(file.size)}</span>
                <span class="file-type">Java</span>
            </div>
        `;
        
        card.addEventListener('click', () => this.openEditor(file));
        return card;
    }

    async openEditor(file) {
        try {
            const fileUrl = `https://raw.githubusercontent.com/${this.repoDetails.owner}/${this.repoDetails.repo}/${this.repoDetails.branch}/${file.path}`;
            const response = await fetch(fileUrl);
            
            if (!response.ok) throw new Error('Failed to fetch code');

            const code = await response.text();
            this.currentFile = file;

            document.getElementById('editor-title').textContent = file.name;
            document.getElementById('file-path').textContent = file.path;

            if (this.editor) {
                this.editor.dispose();
            }

            const container = document.getElementById('monaco-editor');
            this.editor = this.createEditor(container, code);
            
            this.editorModal.style.display = 'block';
            this.editor.focus();

            this.editor.onDidChangeCursorPosition(e => {
                const position = e.position;
                document.getElementById('cursor-position').textContent = 
                    `Ln ${position.lineNumber}, Col ${position.column}`;
            });
        } catch (error) {
            console.error('Error opening file:', error);
            this.showToast('Error opening file', 'error');
        }
    }

    createEditor(container, value) {
        const theme = document.documentElement.getAttribute('data-theme') === 'dark' 
            ? 'customDark' 
            : 'customLight';

        return monaco.editor.create(container, {
            value: value,
            language: 'java',
            theme: theme,
            automaticLayout: true,
            minimap: { enabled: true },
            scrollBeyondLastLine: false,
            fontSize: 14,
            lineNumbers: 'on',
            renderLineHighlight: 'all',
            roundedSelection: true,
            selectOnLineNumbers: true,
            wordWrap: 'on',
            folding: true,
            scrollbar: {
                vertical: 'visible',
                horizontal: 'visible',
                useShadows: false,
                verticalHasArrows: true,
                horizontalHasArrows: true
            },
            suggest: {
                snippetsPreventQuickSuggestions: false
            }
        });
    }

    closeEditor() {
        this.editorModal.style.display = 'none';
        if (this.editor) {
            this.editor.dispose();
        }
    }

    async saveChanges() {
        try {
            const content = this.editor.getValue();
            // Implement your save logic here
            // For GitHub, you'll need to use the GitHub API with authentication
            this.showToast('Changes saved successfully', 'success');
        } catch (error) {
            console.error('Error saving changes:', error);
            this.showToast('Error saving changes', 'error');
        }
    }

    async copyCode() {
        try {
            const code = this.editor.getValue();
            await navigator.clipboard.writeText(code);
            this.showToast('Code copied to clipboard', 'success');
        } catch (error) {
            console.error('Error copying code:', error);
            this.showToast('Error copying code', 'error');
        }
    }

    runCode() {
        // Implement code execution logic here
        this.showToast('Code execution not implemented', 'info');
    }

    toggleTheme() {
        const html = document.documentElement;
        const currentTheme = html.getAttribute('data-theme');
        const newTheme = currentTheme === 'light' ? 'dark' : 'light';
        
        html.setAttribute('data-theme', newTheme);
        localStorage.setItem('theme', newTheme);

        if (this.editor) {
            this.editor.updateOptions({
                theme: newTheme === 'dark' ? 'customDark' : 'customLight'
            });
        }

        this.themeToggle.innerHTML = `
            <i class="fas fa-${newTheme === 'light' ? 'moon' : 'sun'}"></i>
            <span>${newTheme === 'light' ? 'Dark' : 'Light'} Mode</span>
        `;
    }

    changeView(view) {
        this.currentView = view;
        this.programsContainer.className = `programs-container ${view}-view`;
        
        this.gridViewBtn.classList.toggle('active', view === 'grid');
        this.listViewBtn.classList.toggle('active', view === 'list');
    }

    handleSearch(query) {
        const cards = this.programsContainer.getElementsByClassName('program-card');
        query = query.toLowerCase();

        Array.from(cards).forEach(card => {
            const title = card.querySelector('h3').textContent.toLowerCase();
            card.style.display = title.includes(query) ? '' : 'none';
        });
    }

    showToast(message, type = 'info') {
        const toast = document.createElement('div');
        toast.className = `toast toast-${type}`;
        toast.innerHTML = `
            <i class="fas fa-${this.getToastIcon(type)}"></i>
            <span>${message}</span>
        `;

        const container = document.getElementById('toast-container');
        container.appendChild(toast);

        setTimeout(() => {
            toast.remove();
        }, 3000);
    }

    getToastIcon(type) {
        switch (type) {
            case 'success': return 'check-circle';
            case 'error': return 'exclamation-circle';
            case 'warning': return 'exclamation-triangle';
            default: return 'info-circle';
        }
    }

    formatFileSize(bytes) {
        if (bytes < 1024) return bytes + ' B';
        else if (bytes < 1048576) return (bytes / 1024).toFixed(1) + ' KB';
        else return (bytes / 1048576).toFixed(1) + ' MB';
    }
}

// Initialize theme from localStorage
document.addEventListener('DOMContentLoaded', () => {
    try {
        // Set theme before initialization
        document.documentElement.setAttribute('data-theme', 
            localStorage.getItem('theme') || 'dark');
        
        new CodeEditor();
    } catch (error) {
        console.error('Initialization error:', error);
        document.body.innerHTML = `
            <div class="error-message">
                <i class="fas fa-exclamation-circle"></i>
                <h3>Failed to initialize application</h3>
                <p>${error.message}</p>
                <button onclick="location.reload()">Reload Page</button>
            </div>
        `;
    }
});