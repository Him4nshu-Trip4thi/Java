class CodeEditor {
    constructor() {
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
    }

    async setupMonacoEditor() {
        await new Promise(resolve => require(['vs/editor/editor.main'], resolve));

        // Define custom theme
        monaco.editor.defineTheme('customDark', {
            base: 'vs-dark',
            inherit: true,
            rules: [],
            colors: {
                'editor.background': '#1e1e1e',
            }
        });

        monaco.editor.defineTheme('customLight', {
            base: 'vs',
            inherit: true,
            rules: [],
            colors: {
                'editor.background': '#ffffff',
            }
        });
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
            scrollbar: {
                vertical: 'visible',
                horizontal: 'visible',
            }
        });
    }

    async loadPrograms() {
        try {
            const response = await fetch('https://api.github.com/repos/Him4nshu-Trip4thi/Java/contents/programs');
            if (!response.ok) throw new Error('Failed to fetch programs');

            const data = await response.json();
            this.renderPrograms(data);
        } catch (error) {
            console.error('Error loading programs:', error);
            this.showToast('Error loading programs', 'error');
        }
    }

    renderPrograms(programs) {
        this.programsContainer.innerHTML = '';
        
        programs
            .filter(file => file.name.endsWith('.java'))
            .forEach(file => {
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
        `;
        
        card.addEventListener('click', () => this.openEditor(file));
        return card;
    }

    async openEditor(file) {
        try {
            const response = await fetch(file.download_url);
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

            // Setup cursor position tracking
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
            <i class="fas fa-${type === 'success' ? 'check-circle' : 'exclamation-circle'}"></i>
            <span>${message}</span>
        `;

        const container = document.getElementById('toast-container');
        container.appendChild(toast);

        setTimeout(() => {
            toast.remove();
        }, 3000);
    }
}

// Initialize theme from localStorage
document.documentElement.setAttribute('data-theme', 
    localStorage.getItem('theme') || 'dark');

// Initialize the app
document.addEventListener('DOMContentLoaded', () => {
    new CodeEditor();
});