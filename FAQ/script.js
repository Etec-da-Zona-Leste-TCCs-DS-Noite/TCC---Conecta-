document.addEventListener('DOMContentLoaded', () => {
    // 1. Funcionalidade do Acordeão (Abrir/Fechar Perguntas)
    const faqQuestions = document.querySelectorAll('.faq-question');

    faqQuestions.forEach(question => {
        question.addEventListener('click', () => {
            const parentItem = question.closest('.faq-item');
            
            // Fecha todos os itens, exceto o que foi clicado (se já estiver aberto)
            document.querySelectorAll('.faq-item.active').forEach(item => {
                if (item !== parentItem) {
                    item.classList.remove('active');
                }
            });

            // Alterna a classe 'active' no item clicado
            parentItem.classList.toggle('active');
        });
    });

    // 2. Funcionalidade de Filtro por Categoria
    const filterButtons = document.querySelectorAll('.filter-button');
    const faqItems = document.querySelectorAll('.faq-item');

    filterButtons.forEach(button => {
        button.addEventListener('click', () => {
            // Remove 'active' de todos os botões e adiciona ao clicado
            filterButtons.forEach(btn => btn.classList.remove('active'));
            button.classList.add('active');

            const filter = button.dataset.filter;

            faqItems.forEach(item => {
                const category = item.dataset.category;
                
                // Exibe se o filtro for 'all' ou corresponder à categoria
                if (filter === 'all' || category === filter) {
                    item.style.display = 'block';
                } else {
                    item.style.display = 'none';
                }
                
                // Garante que todos os itens estejam fechados ao mudar o filtro
                item.classList.remove('active');
            });
        });
    });
    
    // 3. Funcionalidade de Busca (Busca Dinâmica)
    const searchInput = document.getElementById('search-faq-input');
    
    searchInput.addEventListener('input', (e) => {
        const searchTerm = e.target.value.toLowerCase().trim();

        // Desativa o filtro de categoria ao começar a digitar
        filterButtons.forEach(btn => btn.classList.remove('active'));
        document.querySelector('.filter-button[data-filter="all"]').classList.add('active');


        faqItems.forEach(item => {
            const questionText = item.querySelector('.faq-question').textContent.toLowerCase();
            const answerText = item.querySelector('.faq-answer p').textContent.toLowerCase();

            // Verifica se o termo de busca está na pergunta ou resposta
            if (questionText.includes(searchTerm) || answerText.includes(searchTerm)) {
                item.style.display = 'block';
                // Mantém o item fechado na busca
                item.classList.remove('active'); 
            } else {
                item.style.display = 'none';
            }
        });
    });
});