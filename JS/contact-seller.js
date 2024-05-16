window.onload = async () => {
    let id_seller = localStorage.getItem('id_seller');
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
                const seller = await response.json();
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

document.getElementById("log-out").addEventListener("click", function() {
    localStorage.clear();
    window.location.href = "../HTML/index.html";
});