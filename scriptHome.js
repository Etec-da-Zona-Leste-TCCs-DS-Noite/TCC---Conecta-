const chave = 'conectaPlusAvisos';
const comunicados_urgentes = 3; // só exibe os 3 avisos mais recentes na home

// busca todos os avisos do localStorage
function getNotices() {
    const notices = localStorage.getItem(chave); //retorna o valor dsa chave
    return notices ? JSON.parse(notices) : []; //converte de json para objeto
}

// joga os avisos para a home
function renderRecentNotices() {
    const notices = getNotices();
    const container = document.getElementById('recent-notices-container');
    container.innerHTML = ''; // dá uma varrida no container

    if (!container) return; // ve se o container existe

    if (notices.length === 0) {
        container.innerHTML = '<p>Nenhum comunicado recente publicado.</p>';
        return;
    }

    // ordena por ID (mais recente primeiro)
    notices.sort((a, b) => parseInt(b.id) - parseInt(a.id));

    // limita máximo para a home
    const recentNotices = notices.slice(0, comunicados_urgentes);

    recentNotices.forEach(notice => { //tem como argumento o callback do array, acessa o indice do array ou o array inrteiro
        
        let tagClass = 'normal-tag'; 
        let borderColor = '#ccc'; 
        let priorityDisplay = notice.category; 

        // ajuda da ia (valeu gemini)
        if (notice.priority === 'urgente') {
            tagClass = 'urgent-tag';
            borderColor = '#d93025';
            priorityDisplay = 'URGENTE';
        } else if (notice.priority === 'importante') {
            tagClass = 'important-tag';
            borderColor = '#f9ab00'; 
            priorityDisplay = 'IMPORTANTE';
        }

        // mais coisa com ia
        const noticeHTML = `
            <div class="notice-card" style="border-left-color: ${borderColor};">
                <div class="card-content">
                    <h3>
                        ${notice.title} 
                        <span class="tag ${tagClass}">${priorityDisplay}</span>
                    </h3>
                    <p>${notice.content.substring(0, 150)}${notice.content.length > 150 ? '...' : ''}</p> 
                </div>
                <div class="card-footer">
                    <span class="source"><i class="fas fa-user"></i> ${notice.author || 'Administração'}</span>
                    <span class="date"><i class="fas fa-calendar-alt"></i> ${notice.date}</span>
                    </div>
            </div>
        `;
        
        container.innerHTML += noticeHTML;
    });
}


document.addEventListener('DOMContentLoaded', renderRecentNotices);

// ouve o evento storage para atualizar se o crud mudar em outra aba
window.addEventListener('storage', renderRecentNotices);