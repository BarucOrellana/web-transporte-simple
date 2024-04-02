let btn = document.getElementById("login-btn");
btn.addEventListener("click", createAccount);


async function createAccount(event) {
    event.preventDefault();
    
    const idSeller = localStorage.getItem("idSeller");

    let campos = {
        username: document.getElementById("username").value,
        password: document.getElementById("password").value,
        seller:{idSeller: idSeller}
    };

    const request = await fetch("http://localhost:8090/transporte_simple/new-account/seller", {
        method: 'POST', 
        headers: {
            'Accept': 'application/json',
            'Content-Type': 'application/json'
        },
        body: JSON.stringify(campos),
        credentials: 'same-origin'
    });

    if (request.ok) {
        window.location.href = "http://localhost:5500/HTML/login-seller.html";
        alert("Ya puedes iniciar sesión");
    } else {
        console.error("Failed to authenticate");
    }
}