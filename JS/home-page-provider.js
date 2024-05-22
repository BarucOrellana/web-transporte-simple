let freightsList = async () => {
    const requestFreight = await fetch("http://localhost:8090/transporte_simple/freights/all", {
        method: 'GET',
        headers: {
            'Accept': 'application/json',
            'Content-Type': 'application/json'
        }
    });
    const freights = await requestFreight.json();
    let freightContainer = document.querySelector('.viajes');

    for (let freight of freights) {
        const idSeller = freight.idSeller;
        const name = freight.name;
        const date = new Date(freight.date).toLocaleDateString();
        const description = freight.description;
        const destination = freight.destination;
        const capacity = freight.capacity;
        const product = freight.product;

        let freightElement = document.createElement('div');
        freightElement.classList.add('viaje');
        freightElement.innerHTML = `
            <h3 class="contact-seller">${name}</h3>
            <p>Fecha: ${date}</p>
            <p>Destino: ${destination}</p>
            <p>Descripción: ${description}</p>
            <p>Capacidad: ${capacity}</p>
            <p>Producto: ${product}</p>
        `;
        freightContainer.appendChild(freightElement);
        freightElement.querySelector('.contact-seller').addEventListener('click', () => {
            localStorage.setItem('id_seller', idSeller);
            window.location.href = '../HTML/contact-seller.html';
        });
    }
}
window.onload = freightsList;

document.getElementById("log-out").addEventListener("click", function() {
    localStorage.clear();
    window.location.href = "../HTML/index.html";
});