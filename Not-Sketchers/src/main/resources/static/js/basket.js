if (document.readyState == 'loading' ){
    document.addEventListener('DOMContentLoaded',ready)
}else{
    ready()
}

function ready(){

    var removeCartItemButton = document.getElementsByClassName('buttonsContainer')
    console.log(removeCartItemButton)

}