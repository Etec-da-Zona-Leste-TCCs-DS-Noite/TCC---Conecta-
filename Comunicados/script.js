document.addEventListener('DOMContentLoaded', () => {
    // 1. Funcionalidade de Filtro de Tipo (opcional, para interatividade)
    const typeButtons = document.querySelectorAll('.type-button');

    typeButtons.forEach(button => {
        button.addEventListener('click', function() {
            // Remove 'active' de todos os botões
            typeButtons.forEach(btn => btn.classList.remove('active'));
            
            // Adiciona 'active' ao botão clicado
            this.classList.add('active');

            // Aqui entraria a lógica real para filtrar a lista de comunicados
            // Ex: const filterType = this.textContent;
        });
    });

    // 2. Funcionalidade de Fechar Mensagens de Rodapé (Simulada, como na imagem)
    // Se quiser simular a caixa "Altere seu idioma..." que aparece na imagem:
    const mainLayout = document.querySelector('.main-layout');
    
    // Adicionar um elemento de notificação ao final do main-layout
    const notificationBox = document.createElement('div');
    notificationBox.className = 'footer-notification';
    notificationBox.innerHTML = `
        <span>Altere seu idioma a qualquer momento no menu de ajuda</span>
        <i class="fas fa-times close-icon"></i>
    `;
    mainLayout.appendChild(notificationBox);

    // Estilo básico para o JS simulado
    const style = document.createElement('style');
    style.innerHTML = `
        .footer-notification {
            position: fixed;
            bottom: 20px;
            right: 20px;
            background-color: #333;
            color: white;
            padding: 10px 15px;
            border-radius: 4px;
            font-size: 12px;
            display: flex;
            align-items: center;
            gap: 10px;
            box-shadow: 0 4px 8px rgba(0, 0, 0, 0.2);
        }
        .footer-notification .close-icon {
            cursor: pointer;
            font-size: 14px;
        }
    `;
    document.head.appendChild(style);

    // Lógica para fechar
    notificationBox.querySelector('.close-icon').addEventListener('click', () => {
        notificationBox.style.display = 'none';
    });
});