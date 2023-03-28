document.forms['register-form'].onsubmit = function(event){
   
    if(this.username.value.trim() === ""){
       document.querySelector(".firstName-error").innerHTML = "Please enter your firstName";
       document.querySelector(".firstName-error").style.display = "block";
       event.preventDefault();
       return false;
    }
}