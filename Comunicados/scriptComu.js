const STORAGE_KEY = 'conectaPlusNotices';

// COMENTÁRIO: 1. READ (Lê os dados do localStorage).
function getNotices() {
    const notices = localStorage.getItem(STORAGE_KEY);
    return notices ? JSON.parse(notices) : [];
}

// COMENTÁRIO: 2. Função principal para renderizar os comunicados na tela.
function renderNotices() {
    const notices = getNotices();
    const container = document.getElementById('comunicados-container');
    container.innerHTML = ''; // Limpa o container
    
    if (notices.length === 0) {
        container.innerHTML = '<p>Nenhum comunicado disponível.</p>';
        return;
    }

    // COMENTÁRIO: Ordena por ID (mais recente primeiro).
    notices.sort((a, b) => parseInt(b.id) - parseInt(a.id));

    notices.forEach(notice => {
        // COMENTÁRIO: Define as classes e cores com base na prioridade.
        let tagClass = 'normal-tag';
        let borderColor = '#ccc';
        let priorityColor = '#333';
        
        if (notice.priority === 'urgente') {
            tagClass = 'urgent-tag';
            borderColor = '#d93025'; 
            priorityColor = '#d93025';
        } else if (notice.priority === 'importante') {
            tagClass = 'important-tag';
            borderColor = '#f9ab00';
            priorityColor = '#f9ab00';
        }

        const noticeHTML = `
            <div class="notice-card" style="border-left-color: ${borderColor};">
                <div class="card-content">
                    <h3>
                        ${notice.title} 
                        <span class="tag" style="background-color: ${borderColor}; color: white; border-radius: 4px; padding: 3px 6px;">${notice.category}</span>
                    </h3>
                    <p>${notice.content}</p>
                </div>
                <div class="card-footer">
                    <span class="source"><i class="fas fa-user"></i> ${notice.author}</span> 
                    <span class="date"><i class="fas fa-calendar-alt"></i> ${notice.date}</span>
                    <span class="priority-info" style="color:${priorityColor}; font-weight: 600;">Prioridade: ${notice.priority.toUpperCase()}</span>
                </div>
            </div>
        `;
        
        container.innerHTML += noticeHTML;
    });
}

// COMENTÁRIO: Executa a renderização quando a página carrega.
document.addEventListener('DOMContentLoaded', renderNotices);

// COMENTÁRIO: Ouve o evento 'storage' para atualizar a lista automaticamente se o CRUD for alterado em outra aba.
window.addEventListener('storage', renderNotices);