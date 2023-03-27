// get men and women buttons and add event listener
const menbutton= document.getElementById("menb");
menbutton.addEventListener();
const  womenbutton= document.getElementById("womenb");
menbutton.addEventListener();



function genderButtonPressed(gender){
    if (gender == "Male"){
    document.getElementById("menb").addEventListener("click", function() {
        window.location.href = "http://localhost:8080/products";
        localStorage.setItem("selectedGender", gender);
        });

    }else{
        document.getElementById("womenb").addEventListener("click", function() {
            window.location.href = "http://localhost:8080/products";
            localStorage.setItem("selectedGender", gender);
            });
    }
    
    
}