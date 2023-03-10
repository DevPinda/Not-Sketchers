let loginButton = document.getElementById('loginButton');
let logoutButton = document.getElementById('logoutButton');
let logoutImage = document.getElementById('logoutImage');

fetch('/checklogin')
  .then(response => {
    if (response.status === 200) {
        logoutButton.style.display = 'flex';
        logoutImage.style.display = 'flex';
        loginButton.style.display = 'none';
    } else if (response.status === 401) {
        logoutButton.style.display = 'none';
        logoutImage.style.display = 'none';
        loginButton.style.display = 'flex';
    }
  })
  .catch(error => console.error(error));
