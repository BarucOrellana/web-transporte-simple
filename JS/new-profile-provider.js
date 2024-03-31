let btn = document.getElementById("login-btn");
btn.addEventListener("click", createProfile);

async function createProfile(event) {
    event.preventDefault();

    let campos = {
        name: document.getElementById("name").value,
        rfc: document.getElementById("rfc").value,
        email: document.getElementById("email").value,
        phoneNumber: document.getElementById("phone_number").value,
        idCapacity: parseInt(document.getElementById("capacity").value)
    };

    const request = await fetch("http://localhost:8090/transporte_simple/provider/new-provider", {
        method: 'POST', 
        headers: {
            'Accept': 'application/json',
            'Content-Type': 'application/json'
        },
        body: JSON.stringify(campos),
        credentials: 'same-origin'
    });
    if (request.ok) {
        window.location.href = "http://localhost:5500/HTML/login-provider.html";
        alert("Ya puedes iniciar sesión");
    } else {
        console.error("Failed to authenticate");
    }
}