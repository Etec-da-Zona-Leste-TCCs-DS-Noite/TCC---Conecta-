document.addEventListener('DOMContentLoaded', () => {
    // 1. Funcionalidade de Abas (showSolicitacaoTab)
    window.showSolicitacaoTab = function(tabId) {
        // Remove a classe 'active' de todos os botões de aba
        document.querySelectorAll('.tabs .tab-button').forEach(btn => {
            btn.classList.remove('active');
        });

        // Remove a classe 'active' de todo o conteúdo de aba
        document.querySelectorAll('.tab-content').forEach(content => {
            content.classList.remove('active');
        });

        // Adiciona a classe 'active' ao botão e ao conteúdo da aba clicada
        document.querySelector(`.tab-button[onclick="showSolicitacaoTab('${tabId}')"]`).classList.add('active');
        document.getElementById(tabId).classList.add('active');
    }

    // 2. Funcionalidade de Upload de Arquivo (para exibir o nome)
    const fileInput = document.getElementById('arquivo');
    const fileNameDisplay = document.getElementById('file-name');
    
    if (fileInput) {
        fileInput.addEventListener('change', function() {
            if (this.files && this.files.length > 0) {
                fileNameDisplay.textContent = this.files[0].name;
            } else {
                fileNameDisplay.textContent = 'Nenhum arquivo escolhido';
            }
        });
    }

    // 3. Funcionalidade de Limpar Formulário
    window.clearForm = function() {
        const form = document.querySelector('.solicitacao-form');
        if (form) {
            form.reset();
            // Garante que o texto do arquivo seja resetado
            if (fileNameDisplay) {
                fileNameDisplay.textContent = 'Nenhum arquivo escolhido';
            }
        }
    }
});