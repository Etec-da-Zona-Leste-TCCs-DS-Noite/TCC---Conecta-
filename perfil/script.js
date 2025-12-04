document.addEventListener('DOMContentLoaded', () => {
    // Função para mostrar a aba selecionada (Perfil)
    window.showProfileTab = function(tabId) {
        // 1. Esconde todos os conteúdos de aba
        document.querySelectorAll('.tab-content').forEach(content => {
            content.classList.remove('active');
        });

        // 2. Desativa todos os botões de aba
        document.querySelectorAll('.tabs .tab-button').forEach(btn => {
            btn.classList.remove('active');
        });

        // 3. Mostra o conteúdo da aba clicada
        document.getElementById(tabId).classList.add('active');

        // 4. Ativa o botão correspondente
        document.querySelector(`.tab-button[onclick="showProfileTab('${tabId}')"]`).classList.add('active');
    }

    // Se estiver usando o mesmo script para Solicitações e Perfil, mantenha as outras funções:
    
    /*
    // Funcionalidade de Abas de Solicitações (MANTENHA se precisar)
    window.showSolicitacaoTab = function(tabId) { ... }
    
    // Funcionalidade de Arquivo e Limpar Formulário (MANTENHA se precisar)
    window.clearForm = function() { ... }
    const fileInput = document.getElementById('arquivo');
    // ... etc
    */
});