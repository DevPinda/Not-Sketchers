window.onload = function () {
    let product_name = document.getElementById('product-name').textContent;
    let gender = document.getElementById('gender').textContent;
    let colour = document.getElementById('colour').textContent;
    let shoe_size = document.getElementById('shoe-size').textContent;
    let product_price = document.getElementById('product-price').textContent;
    basket_btn = document.getElementsByClassName('basket-button');
    
    var basketItemsAmount = 0;
    var products_list = []

    // Functionality to click the 'Add To Basket' button from the products page
    for (let i = 0; i < basket_btn.length; i++) {
        basket_btn[i].addEventListener("click", function () {
            basketItemsAmount += 1;
            console.log(basketItemsAmount);

            // Using JSON and local storage to store the product in local storage
            if (typeof(Storage) !== 'undefined') {
                let shoe_item = {
                    id: i + 1,
                    title: product_name,
                    gender_style: gender,
                    shoe_colour: colour,
                    size: shoe_size,
                    price: product_price,
                    number_of_items: 1
                };

                // If the product is not in the local storage, add it to the list
                // Otherwise if the product is already in the local storage, increment the quantity of item
                if (JSON.parse(localStorage.getItem("shoe_items")) === null) {
                    products_list.push(shoe_item);
                    localStorage.setItem("shoe_items", JSON.stringify(products_list));
                    window.location.reload();
                } else {
                    const local_items = JSON.parse(localStorage.getItem("shoe_items"));
                    local_items.map(data => {
                        if (shoe_item.id == data.id) {
                            shoe_item.number_of_items = data.number_of_items + 1;
                        } else {
                            products_list.push(data);
                        }
                    });
                    products_list.push(shoe_item);
                    localStorage.setItem("shoe_items", JSON.stringify(products_list));
                    window.location.reload();
                }
            } 
        });
    }
}
