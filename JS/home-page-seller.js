let btn = document.getElementById("login-btn");
btn.addEventListener("click", login);


const idSeller = localStorage.getItem("idSeller")
const jwt = localStorage.getItem("jwt")

async function login(event) {
    event.preventDefault();

    let campos = {
        destination: document.getElementById("destination").value,
        date: document.getElementById("date").value,
        description: document.getElementById("description").value,
        idCapacity: parseInt(document.getElementById("capacity").value),
        idProduct: parseInt(document.getElementById("product").value),
        idSeller: parseInt(idSeller)
    };

    const request = await fetch("http://localhost:8090/transporte_simple/freights/new-freight", {
        method: 'POST', 
        headers: {
            'Accept': 'application/json',
            'Content-Type': 'application/json',
            'Authorization': 'Bearer ' + jwt
        },
        body: JSON.stringify(campos),
        credentials: 'same-origin'
    });
    if (request.ok) {
        window.location.href = "http://localhost:5500/HTML/home-page-seller.html";
        alert("Viaje agregado");
    } else {
        console.error("Failed to authenticate");
    }
}