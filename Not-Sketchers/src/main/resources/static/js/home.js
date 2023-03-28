window.onload = function() {
    document.getElementById("menb").addEventListener("click", function() {
      localStorage.setItem("selectedGender", "Male");
      window.location.href = "http://localhost:8080/products";
    });
  
    document.getElementById("womenb").addEventListener("click", function() {
      localStorage.setItem("selectedGender", "Female");
      window.location.href = "http://localhost:8080/products";
    });
  };