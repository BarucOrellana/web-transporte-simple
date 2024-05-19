let btn = document.getElementById("login-btn");
btn.addEventListener("click", createAccount);

async function createAccount(event) {
    event.preventDefault();
    const idProvider = localStorage.getItem("idProvider")

    let campos = {
        username: document.getElementById("username").value,
        password: document.getElementById("password").value,
        provider: {idProvider: idProvider}
    };

    const request = await fetch("http://localhost:8090/transporte_simple/new-account/provider", {
        method: 'POST', 
        headers: {
            'Accept': 'application/json',
            'Content-Type': 'application/json'
        },
        body: JSON.stringify(campos),
        credentials: 'same-origin'
    });

    if (request.ok) {
        window.location.href = "../HTML/login-provider.html";
        alert("Ya puedes iniciar sesión");
    } else {
        console.error("Failed to authenticate");
    }
}