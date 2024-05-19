window.onload = async () => {
    let id_provider = localStorage.getItem('idProvider');
    const jwt = localStorage.getItem("jwt");

    if (id_provider){
        try {
            const response = await fetch(`http://localhost:8090/transporte_simple/provider/account/${id_provider}`, {
                method: 'GET',
                headers: {
                    'Accept': 'application/json',
                    'Content-Type': 'application/json',
                    'Authorization': 'Bearer ' + jwt
                }
            });

            if (response.ok) {
                var provider = await response.json();
                let providerContainer = document.querySelector('.data-provider');
                const { name, rfc, email, phoneNumber, capacity } = provider;
                
                let providerElement = document.createElement('div');
                providerElement.classList.add('provider');
                providerElement.innerHTML = `
                    <h3>${name}</h3>
                    <p>RFC: ${rfc}</p>
                    <p>Email: ${email}</p>
                    <p>Teléfono: ${phoneNumber}</p>
                    <p>Capacidad: ${capacity.capacity}</p>
                `;
                providerContainer.appendChild(providerElement);
                fillForm(provider);
            } else {
                console.error('No se pudo obtener los datos del cliente');
            }
        } catch (error) {
            console.error('Ocurrió un error al realizar la solicitud:', error);
        }
    } else {
        console.error('No se encontró el id_provider en el localStorage');
    }
};

document.getElementById("backButton").addEventListener("click", () => {
    window.history.back();
});


/*Formulario para editar los datos del usuario*/

let btn = document.getElementById("edit");
btn.addEventListener("click", editDataProvider);


const idProvider = localStorage.getItem("idProvider")
const jwt = localStorage.getItem("jwt")

async function editDataProvider(event) {
    event.preventDefault();
    let campos = {
        name: document.getElementById("name").value,
        rfc: document.getElementById("rfc").value,
        email: document.getElementById("email").value,
        phoneNumber: document.getElementById("phoneNumber").value,
        idCapacity: parseInt(document.getElementById("capacity").value),
        idProvider: parseInt(idProvider)
    };

    if (!campos.name || !campos.rfc || !campos.email || !campos.phoneNumber || !campos.idCapacity) {
        alert("Por favor llena todos los campos del formulario.");
        return;
    }

    const request = await fetch("http://localhost:8090/transporte_simple/provider/update-provider", {
        method: 'PUT', 
        headers: {
            'Accept': 'application/json',
            'Content-Type': 'application/json',
            'Authorization': 'Bearer ' + jwt
        },
        body: JSON.stringify(campos),
        credentials: 'same-origin'
    });

    if (request.ok) {
        window.location.href = "../HTML/account-provider.html";
        alert("Su información fue editada");
    } else {
        console.error("Failed to authenticate");
    }
}

document.getElementById("editButton").addEventListener("click", () => {
    showForm();
});
function showForm(){
    let form = document.getElementById("form").style.visibility="visible";
    let button = document.getElementById("editButton").style.visibility="hidden";
};
function fillForm(provider) {
    document.getElementById("name").value = provider.name;
    document.getElementById("rfc").value = provider.rfc;
    document.getElementById("email").value = provider.email;
    document.getElementById("phoneNumber").value = provider.phoneNumber;
}

document.getElementById("log-out").addEventListener("click", function() {
    localStorage.clear();
    window.location.href = "../HTML/index.html";
});