const STORAGE_KEY = 'conectaPlusNotices';
let isEditMode = false;

// 1. Abre o modal e configura para criação ou edição.
function openNoticeModal(notice = null) {
    const modal = document.getElementById('notice-modal');
    const form = document.getElementById('notice-form');
    const idInput = document.getElementById('notice-id');
    const modalTitle = document.getElementById('modal-title');
    const submitButton = document.getElementById('submit-button');
    
    // Limpa o formulário e o ID oculto.
    form.reset();
    idInput.value = '';

    if (notice) {
        // MODO EDIÇÃO
        isEditMode = true;
        modalTitle.textContent = 'Editar Comunicado';
        submitButton.textContent = 'Salvar Alterações';
        
        document.getElementById('notice-title').value = notice.title;
        document.getElementById('notice-category').value = notice.category;
        document.getElementById('notice-priority').value = notice.priority;
        document.getElementById('notice-content').value = notice.content;
        document.getElementById('notice-author').value = notice.author;
        idInput.value = notice.id;

    } else {
        // MODO CRIAÇÃO
        isEditMode = false;
        modalTitle.textContent = 'Novo Comunicado';
        submitButton.textContent = 'Criar Aviso';
    }

    modal.style.display = 'block';
}

// 2. Fecha o modal.
function closeNoticeModal() {
    document.getElementById('notice-modal').style.display = 'none';
    document.getElementById('notice-form').reset();
}

// 3. READ (Lê os dados do localStorage).
function getNotices() {
    const notices = localStorage.getItem(STORAGE_KEY);
    return notices ? JSON.parse(notices) : [];
}

// 4. CREATE/UPDATE (Salva ou Atualiza um comunicado).
function saveNotice(notice) {
    const notices = getNotices();
    
    if (isEditMode) {
        // Lógica de UPDATE
        const index = notices.findIndex(n => n.id === notice.id);
        if (index > -1) {
            // Preserva a data original
            notice.date = notices[index].date; 
            notices[index] = notice;
        }
    } else {
        // Lógica de CREATE
        notice.id = Date.now().toString(); 
        notice.date = new Date().toLocaleDateString('pt-BR'); 
        notices.push(notice);
    }
    
    localStorage.setItem(STORAGE_KEY, JSON.stringify(notices));
    renderNoticesTable();
    closeNoticeModal();
    // Notifica outras abas (comu.html) sobre a mudança.
    window.dispatchEvent(new Event('storage')); 
}

// 5. DELETE (Remove um comunicado).
function deleteNotice(id) {
    if (confirm('Tem certeza que deseja excluir este comunicado? Esta ação é irreversível.')) {
        let notices = getNotices();
        notices = notices.filter(n => n.id !== id);
        localStorage.setItem(STORAGE_KEY, JSON.stringify(notices));
        renderNoticesTable();
        window.dispatchEvent(new Event('storage'));
    }
}

// 6. Renderiza a tabela de avisos na página de gerenciamento.
function renderNoticesTable() {
    const notices = getNotices();
    const tbody = document.getElementById('notices-table-body');
    tbody.innerHTML = ''; 

    if (notices.length === 0) {
        // Colspan de 5 para cobrir todas as colunas
        tbody.innerHTML = '<tr><td colspan="5" style="text-align: center;">Nenhum comunicado publicado ainda.</td></tr>';
        return;
    }

    // Ordena por ID (mais recente primeiro).
    notices.sort((a, b) => parseInt(b.id) - parseInt(a.id));

    notices.forEach(notice => {
        const row = tbody.insertRow();
        
        // Coluna Título (e Prioridade)
        const priorityText = notice.priority.charAt(0).toUpperCase() + notice.priority.slice(1);
        row.insertCell().innerHTML = `<strong>${notice.title}</strong><br><span style="color:#555; font-size:0.8em;">(${priorityText})</span>`;
        
        // Coluna Autor/Fonte
        row.insertCell().textContent = notice.author; 
        
        // Coluna Categoria
        row.insertCell().textContent = notice.category;
        
        // Coluna Data
        row.insertCell().textContent = notice.date;
        
        // Coluna Ações (Botões Editar e Excluir)
        // CORRIGIDO: Adição do texto "Editar" e "Excluir"
        row.insertCell().innerHTML = `
            <div class="action-buttons">
                <button title="Editar" onclick="openNoticeModal(${JSON.stringify(notice).replace(/"/g, '&quot;')})">
                    <i class="fas fa-edit"></i> Editar
                </button>
                <button class="delete-btn" title="Excluir" onclick="deleteNotice('${notice.id}')">
                    <i class="fas fa-trash"></i> Excluir
                </button>
            </div>
        `;
    });
}

// Inicialização e Event Listeners.
document.addEventListener('DOMContentLoaded', () => {
    renderNoticesTable(); 

    // Listener para o formulário de criação/edição.
    document.getElementById('notice-form').addEventListener('submit', (e) => {
        e.preventDefault();
        
        const notice = {
            id: document.getElementById('notice-id').value,
            title: document.getElementById('notice-title').value,
            category: document.getElementById('notice-category').value,
            priority: document.getElementById('notice-priority').value,
            content: document.getElementById('notice-content').value,
            author: document.getElementById('notice-author').value, 
        };
        
        saveNotice(notice);
    });

    // Fechar modal ao clicar fora dele.
    window.onclick = function(event) {
        const modal = document.getElementById('notice-modal');
        if (event.target === modal) {
            closeNoticeModal();
        }
    };
});