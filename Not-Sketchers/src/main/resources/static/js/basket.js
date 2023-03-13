if (document.readyState == 'loading' ){
    document.addEventListener('DOMContentLoaded',ready)
}else{
    ready()
}

function ready(){

    var removeCartItemButton = document.getElementsByClassName('buttonsContainer')
    console.log(removeCartItemButton)
    for (var i = 0; i < removeCartItemButton.length; i++){
        var button = removeCartItemButton[i]
        button.addEventListener('click',function(event){
            var buttonClicked = event.target
            buttonClicked.parentElement.parentElement.remove()
        })
    }

}