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
        const requestJson = await request.json();
        const idProvider = requestJson.idProvider;
        localStorage.setItem("idProvider", idProvider);
        if(idProvider != null){
            window.location.href = "../HTML/new-account-provider.html";
        }else{
            console.error("Failed to create profile");
        }
    } else {
        console.error("Failed to create profile");
    }
}