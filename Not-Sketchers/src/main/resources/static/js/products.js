window.onload = function () {
    var currentUrl = window.location.href;
    if (currentUrl.indexOf("products.html") !== -1 || currentUrl.indexOf("products") !== -1  ) {
        onLoadFunction1();
    } else if (currentUrl.indexOf("basket.html") !== -1 || currentUrl.indexOf("basket") !== -1 ) {
        onLoadFunction2();
    } else {
        window.alert('Failed to find URL to HTML file');
    }

    // Products Page onload
    function onLoadFunction1() {
        basket_btn = document.getElementsByClassName('basket-button');

        var basketItemsAmount = 0;
        var products_list = [];

        // Functionality to click the 'Add To Basket' button from the products page
        for (let i = 0; i < basket_btn.length; i++) {
            basket_btn[i].addEventListener("click", function (e) {
                basketItemsAmount += 1;
                console.log(basketItemsAmount);
                
                // Using JSON and local storage to store the product in local storage
                if (typeof(Storage) !== 'undefined') {
                    let shoe_item = {
                        id: i + 1,
                        title: e.target.parentElement.parentElement.children[0].textContent,
                        gender_style: e.target.parentElement.parentElement.children[1].textContent,
                        shoe_colour: e.target.parentElement.parentElement.children[2].textContent,
                        size: e.target.parentElement.parentElement.children[3].textContent,
                        price: e.target.parentElement.parentElement.children[5].textContent,
                        image: e.target.parentElement.parentElement.parentElement.children[0].children[0].src,
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

    // Basket page onload
    function onLoadFunction2() {        
        let basket_data = localStorage.getItem("shoe_items");
        let parsedData = JSON.parse(basket_data);
        let stringJSON = JSON.stringify(parsedData);
        
        const json = JSON.parse(stringJSON);
        const ids = json.map(item => item.id);

        const productContainer = document.getElementById("productContainer");
        
        // Displays the products on the console
        json.forEach((item) => {
            for (const key in item) {
              if (key !== 'id') {
                console.log(key + ': ' + item[key]);
              }
            }
        });

        // Displays the products on the basket page
        ids.forEach((id) => {
            const item = json.find((item) => item.id === id);

            // Product heading container
            const productHeadingContainer = document.createElement("div");
            productHeadingContainer.id = "productHeadingContainer";
            productContainer.appendChild(productHeadingContainer);

            // Product name heading
            const productHeading = document.createElement("h1");
            productHeading.id = "productHeading";
            productHeading.textContent = item.title;
            productHeadingContainer.appendChild(productHeading);

            // Wrapper container
            const wrapperContainer = document.createElement("div");
            wrapperContainer.id = "wrapperContainer";
            productContainer.appendChild(wrapperContainer);

            // Title container
            const titleContainer = document.createElement("div");
            titleContainer.classList.add("titleContainer");
            titleContainer.id = "titleContainer";
            wrapperContainer.appendChild(titleContainer);

            // Product Name
            const itemTitle = document.createElement("p");
            itemTitle.classList.add("titleContainer");
            itemTitle.textContent = item.gender_style;
            itemTitle.id = "itemTitle";
            titleContainer.appendChild(itemTitle);

            // Size
            const sizeTitle = document.createElement("p");
            sizeTitle.classList.add("titleContainer");
            sizeTitle.textContent = "Size";
            sizeTitle.id = "sizeTitle";
            titleContainer.appendChild(sizeTitle);

            // Quantity
            const quantityTitle = document.createElement("p");
            quantityTitle.classList.add("titleContainer");
            quantityTitle.textContent = "Quantity";
            quantityTitle.id = "quantityTitle";
            titleContainer.appendChild(quantityTitle);
    

            // Result container
            const resultContainer = document.createElement("div");
            resultContainer.classList.add("resultContainer");
            resultContainer.id = "resultContainer";
            wrapperContainer.appendChild(resultContainer);

            // Price Result
            const priceResult = document.createElement("p");
            priceResult.classList.add("resultContainer");
            priceResult.textContent = item.price;
            priceResult.id = "priceResult";
            resultContainer.appendChild(priceResult);

            // Size Result
            const sizeResult = document.createElement("p");
            sizeResult.classList.add("resultContainer");
            sizeResult.textContent = item.size;
            sizeResult.id = "sizeResult";
            resultContainer.appendChild(sizeResult);

            // Quantity Result
            const quantityResult = document.createElement("p");
            quantityResult.classList.add("resultContainer");
            quantityResult.textContent = item.number_of_items;
            quantityResult.id = "quantityResult";
            resultContainer.appendChild(quantityResult);

            // Buttons Container
            const buttonsContainer = document.createElement("div");
            buttonsContainer.classList.add("buttonsContainer");
            wrapperContainer.appendChild(buttonsContainer);

            const button = document.createElement("button");
            button.classList.add("buttonsContainer");
            buttonsContainer.appendChild(button);
        });
    }
}