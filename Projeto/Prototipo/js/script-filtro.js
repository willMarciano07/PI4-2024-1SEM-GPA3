document.addEventListener('DOMContentLoaded', (event) => {
    const checkboxes = document.querySelectorAll('.filter-checkbox');
    const allProductsCheckbox = document.getElementById('all-products');

    checkboxes.forEach(checkbox => {
        checkbox.addEventListener('change', filterProducts);
    });

    allProductsCheckbox.addEventListener('change', (event) => {
        if (allProductsCheckbox.checked) {
            checkboxes.forEach(checkbox => {
                if (checkbox !== allProductsCheckbox) {
                    checkbox.checked = false;
                }
            });
        }
        filterProducts();
    });
});

function filterProducts() {
    const allProductsCheckbox = document.getElementById('all-products');
    const checkboxes = document.querySelectorAll('.filter-checkbox:checked');
    const selectedCategories = Array.from(checkboxes).map(checkbox => checkbox.value);
    const cards = document.querySelectorAll('.card');

    if (allProductsCheckbox.checked) {
        cards.forEach(card => {
            card.style.display = 'flex';
        });
        return;
    }

    cards.forEach(card => {
        if (selectedCategories.length === 0) {
            card.style.display = 'flex';
        } else {
            if (selectedCategories.includes(card.getAttribute('data-category'))) {
                card.style.display = 'flex';
            } else {
                card.style.display = 'none';
            }
        }
    });
}