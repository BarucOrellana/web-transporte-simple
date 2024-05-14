window.onload = async () => {
    let id_seller = localStorage.getItem('idSeller');
    const jwt = localStorage.getItem("jwt");

    if (id_seller){
        try {
            const response = await fetch(`http://localhost:8090/transporte_simple/seller/account/${id_seller}`, {
                method: 'GET',
                headers: {
                    'Accept': 'application/json',
                    'Content-Type': 'application/json',
                    'Authorization': 'Bearer ' + jwt
                }
            });

            if (response.ok) {
                var seller = await response.json();
                let sellerContainer = document.querySelector('.data-seller');
                const { name, rfc, email, phoneNumber } = seller;

                let sellerElement = document.createElement('div');
                sellerElement.classList.add('seller');
                sellerElement.innerHTML = `
                    <h3>${name}</h3>
                    <p>RFC: ${rfc}</p>
                    <p>Email: ${email}</p>
                    <p>Teléfono: ${phoneNumber}</p>
                `;
                sellerContainer.appendChild(sellerElement);
                fillForm(seller);
            } else {
                console.error('No se pudo obtener los datos del cliente');
            }
        } catch (error) {
            console.error('Ocurrió un error al realizar la solicitud:', error);
        }
    } else {
        console.error('No se encontró el id_seller en el localStorage');
    }
};

document.getElementById("backButton").addEventListener("click", () => {
    window.history.back();
});


/*Formulario para editar los datos del usuario*/

let btn = document.getElementById("edit");
btn.addEventListener("click", editDataSeller);


const idSeller = localStorage.getItem("idSeller")
const jwt = localStorage.getItem("jwt")

async function editDataSeller(event) {
    event.preventDefault();
    let campos = {
        name: document.getElementById("name").value,
        rfc: document.getElementById("rfc").value,
        email: document.getElementById("email").value,
        phoneNumber: document.getElementById("phoneNumber").value,
        idSeller: parseInt(idSeller)
    };

    const request = await fetch("http://localhost:8090/transporte_simple/seller/update-seller", {
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
        window.location.href = "http://localhost:5500/HTML/account-seller.html";
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
function fillForm(seller) {
    document.getElementById("name").value = seller.name;
    document.getElementById("rfc").value = seller.rfc;
    document.getElementById("email").value = seller.email;
    document.getElementById("phoneNumber").value = seller.phoneNumber;
}


