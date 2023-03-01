window.onload = function () {
    let product_name = document.getElementById('product-name').textContent;
    let gender = document.getElementById('gender').textContent;
    let colour = document.getElementById('colour').textContent;
    let shoe_size = document.getElementById('shoe-size').textContent;
    let product_price = document.getElementById('product-price').textContent;
    basket_btn = document.getElementById('basket-button');
    
    var basketItemsAmount = 0;

    basket_btn.addEventListener("click", function () {
        basketItemsAmount += 1;
        console.log(basketItemsAmount);
    });
}
