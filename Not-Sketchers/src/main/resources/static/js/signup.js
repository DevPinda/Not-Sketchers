function showError(errorElement, errorMessage) {
    document.querySelector("."+errorElement).classList.add("display-error");
    document.querySelector("."+errorElement).innerHTML = errorMessage;
}

function clearError() {
    let errors = document.querySelectorAll(".error");
    for(let error of errors) {
        error.classList.remove("display-error")
    }
}


let form = document.forms['register-form'];
form.onsubmit = function(event) {

    clearError();


    if (form.firstName.value === "") {
        showError ("email-error", "You have to enter your email");
        return false;
    }



    event.preventDefault();
}