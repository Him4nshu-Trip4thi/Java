class CodeEditor {
    constructor() {
        this.repoDetails = {
            owner: 'Him4nshu-Trip4thi',
            repo: 'Java',
            branch: 'main'
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
                        if (this.editor) this.saveChanges();
                        break;
                    case 'e':
                        e.preventDefault();
                        this.closeEditor();
                        break;
                }
            } else if (e.key === 'Escape') {
                this.closeEditor();
            }
        });

        // Window resize handler for editor
        window.addEventListener('resize', () => {
            if (this.editor) {
                this.editor.layout();
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
            const apiUrl = `https://api.github.com/repos/${this.repoDetails.owner}/${this.repoDetails.repo}/contents?ref=${this.repoDetails.branch}`;
            
            console.log('Fetching from:', apiUrl);
            
            const response = await fetch(apiUrl);
            
            if (!response.ok) {
                throw new Error(`HTTP error! status: ${response.status}`);
            }
            
            const data = await response.json();
            console.log('Received data:', data);
            
            const javaFiles = await this.processFiles(data);
            console.log('Processed Java files:', javaFiles);
            
            this.renderPrograms(javaFiles);
        } catch (error) {
            console.error('Error loading programs:', error);
            this.programsContainer.innerHTML = `
                <div class="error-message">
                    <i class="fas fa-exclamation-circle"></i>
                    <h3>Failed to load programs</h3>
                    <p>Error: ${error.message}</p>
                    <div class="error-actions">
                        <button onclick="location.reload()" class="retry-btn">
                            <i class="fas fa-sync-alt"></i> Try Again
                        </button>
                        <a href="https://github.com/${this.repoDetails.owner}/${this.repoDetails.repo}" 
                           target="_blank" class="view-repo-btn">
                            <i class="fab fa-github"></i> View Repository
                        </a>
                    </div>
                </div>
            `;
        }
    }

    async processFiles(items, path = '') {
        let javaFiles = [];
        
        for (const item of items) {
            if (item.type === 'file' && item.name.endsWith('.java')) {
                javaFiles.push({
                    ...item,
                    fullPath: path + item.name
                });
            } else if (item.type === 'dir') {
                try {
                    const response = await fetch(item.url);
                    const dirContents = await response.json();
                    const subFiles = await this.processFiles(dirContents, `${path}${item.name}/`);
                    javaFiles = javaFiles.concat(subFiles);
                } catch (error) {
                    console.error(`Error processing directory ${item.name}:`, error);
                }
            }
        }
        
        return javaFiles;
    }

    renderPrograms(programs) {
        this.programsContainer.innerHTML = '';
        
        if (programs.length === 0) {
            this.programsContainer.innerHTML = `
                <div class="error-message">
                    <i class="fas fa-folder-open"></i>
                    <h3>No Java Programs Found</h3>
                    <p>Add some Java programs to get started</p>
                </div>
            `;
            return;
        }

        programs.forEach(file => {
            const card = this.createProgramCard(file);
            this.programsContainer.appendChild(card);
        });
    }

    createProgramCard(file) {
        const card = document.createElement('div');
        card.className = 'program-card';
        
        const pathParts = file.fullPath.split('/');
        const fileName = pathParts.pop();
        const folderPath = pathParts.join('/');
        
        card.innerHTML = `
            <div class="card-content">
                <h3 title="${fileName}">${fileName}</h3>
                ${folderPath ? `<p class="file-path"><i class="fas fa-folder"></i> ${folderPath}</p>` : ''}
                <div class="card-actions">
                    <span class="file-size">
                        <i class="fas fa-file-code"></i>
                        ${this.formatFileSize(file.size)}
                    </span>
                    <button class="view-btn">
                        <i class="fas fa-code"></i>
                        View Code
                    </button>
                </div>
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
            const path = card.querySelector('.file-path')?.textContent.toLowerCase() || '';
            card.style.display = title.includes(query) || path.includes(query) ? '' : 'none';
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

// Initialize theme from localStorage and start the app
document.addEventListener('DOMContentLoaded', () => {
    try {
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