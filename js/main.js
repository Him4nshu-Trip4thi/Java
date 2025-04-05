// Theme Toggle
const themeToggle = document.getElementById('theme-toggle');
let isDark = true;

themeToggle.addEventListener('click', () => {
    isDark = !isDark;
    document.body.classList.toggle('light-theme');
    themeToggle.innerHTML = isDark ? '<i class="fas fa-moon"></i>' : '<i class="fas fa-sun"></i>';
});

// Load Programs
async function loadPrograms() {
    try {
        const response = await fetch('https://api.github.com/repos/Him4nshu-Trip4thi/Java/contents/programs');
        const data = await response.json();
        
        const programsGrid = document.querySelector('.programs-grid');
        
        data.forEach(file => {
            if (file.name.endsWith('.java')) {
                const card = createProgramCard(file);
                programsGrid.appendChild(card);
            }
        });
    } catch (error) {
        console.error('Error loading programs:', error);
    }
}

function createProgramCard(file) {
    const card = document.createElement('div');
    card.className = 'program-card';
    card.innerHTML = `
        <h3>${file.name}</h3>
        <p>Click to view code</p>
    `;
    
    card.addEventListener('click', () => openModal(file));
    return card;
}

// Modal Functionality
const modal = document.getElementById('program-modal');
const closeBtn = document.querySelector('.close');

closeBtn.onclick = () => modal.style.display = 'none';
window.onclick = (event) => {
    if (event.target === modal) {
        modal.style.display = 'none';
    }
}

async function openModal(file) {
    try {
        const response = await fetch(file.download_url);
        const code = await response.text();
        
        document.getElementById('modal-title').textContent = file.name;
        document.getElementById('code-block').textContent = code;
        Prism.highlightAll();
        
        modal.style.display = 'block';
    } catch (error) {
        console.error('Error loading code:', error);
    }
}

// Copy Code Functionality
document.querySelector('.copy-btn').addEventListener('click', () => {
    const code = document.getElementById('code-block').textContent;
    navigator.clipboard.writeText(code);
    
    const copyBtn = document.querySelector('.copy-btn');
    copyBtn.innerHTML = '<i class="fas fa-check"></i>';
    setTimeout(() => {
        copyBtn.innerHTML = '<i class="fas fa-copy"></i>';
    }, 2000);
});

// Initialize
loadPrograms();