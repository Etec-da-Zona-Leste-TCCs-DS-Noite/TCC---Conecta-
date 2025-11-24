const body = document.body;
const loginbox = document.querySelector(".login-box");
const h1 = document.getElementsByTagName("h1")[0];
const inputs = document.querySelectorAll("input");
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


/* // Import the functions you need from the SDKs you need
  import { initializeApp } from "https://www.gstatic.com/firebasejs/12.6.0/firebase-app.js";
  import { getAnalytics } from "https://www.gstatic.com/firebasejs/12.6.0/firebase-analytics.js";
  // TODO: Add SDKs for Firebase products that you want to use
  // https://firebase.google.com/docs/web/setup#available-libraries

  // Your web app's Firebase configuration
  // For Firebase JS SDK v7.20.0 and later, measurementId is optional
  const firebaseConfig = {
    apiKey: "AIzaSyDczdqi79RekkMpKq0pf8ALIEj88M8mLZg",
    authDomain: "teste1-b1c83.firebaseapp.com",
    projectId: "teste1-b1c83",
    storageBucket: "teste1-b1c83.firebasestorage.app",
    messagingSenderId: "641915295145",
    appId: "1:641915295145:web:b01f00c9583a6b8318e0b8",
    measurementId: "G-546EK764NS"
  };

  // Initialize Firebase
  const app = initializeApp(firebaseConfig);
  const analytics = getAnalytics(app);*/