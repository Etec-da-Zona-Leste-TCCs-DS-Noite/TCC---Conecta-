const body = document.body;
const loginbox = document.querySelector(".login-box");
const h1 = document.getElementsByTagName("h1")[0];
let login_input = document.querySelectorAll("login-input");
let password_input = document.querySelectorAll("senha-input");
const loginbutton = document.getElementById("login-button");

function switchTheme (){
    loginbox.classList.toggle("dark-mode");
    body.classList.toggle("dark-mode");
    h1.classList.toggle("dark-mode");
    inputs.forEach( input =>{
        input.classList.toggle("dark-mode")
    });
    loginbutton.classList.toggle("dark-mode");
    h2.classList.toggle("dark-mode");
}

