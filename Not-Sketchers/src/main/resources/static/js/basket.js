// this if statement only loads this page if the html doc has loaded otherwise there would be an error
if (document.readyState == 'loading' ){
    document.addEventListener('DOMContentLoaded',ready)
}else{
    ready()
}
// function ready only activates once the html doc has loaded
function ready(){
// finds the remove button
    var removeCartItemButton = document.getElementsByClassName('buttonsContainer')
    // prints remove button onto log, so it shows if it's the correct one
    console.log(removeCartItemButton)

    // for each remove button has an event listener so if button is pressed then it removes product
    for (var i = 0; i < removeCartItemButton.length; i++){
        var button = removeCartItemButton[i]
        button.addEventListener('click',removeCartItem)
    }

}

function removeCartItem(event){
// function removes cart item
    var buttonClicked = event.target
    buttonClicked.parentElement.parentElement.remove()
    updateCartTotal()
}

function updateCartTotal(){
    // function updates the cart total price once item is removed
    //variable below is the products container
    var cartItemContainer = document.getElementsByClassName('productContainer')[0]
    cartItemContainer.getElementsByClassName('wrapperContainer')
    var total = 0
    for (var i = 0; i < wrapperContainer.length; i++){
        var wrapperContainer = wrapperContainer[i]
        var priceElement = wrapperContainer.getElementsByClassName('priceResult.resultContainer')[0]
        var quantityElement = wrapperContainer.getElementsByClassName('quantityResult.resultContainer')[0]

        var price = parseFloat(priceElement.innerText.replace('£', ' '))
        var quantity = quantityElement.value
        total = total + (price * quantity)
    }
    document.getElementsByClassName('h1.totalContainer')[0].innerText = '£' + total

}