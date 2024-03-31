let freightsList = async () => {
    const request = await fetch("http://localhost:8090/transporte_simple/freights/all", {
        method: 'GET',
        headers: {
            'Accept': 'application/json',
            'Content-Type': 'application/json'
        }
    });
    const freights = await request.json();
    let viajesContainer = document.querySelector('.viajes');

    for (let freight of freights) {
        const name = freight.name;
        const date = new Date(freight.date).toLocaleDateString();
        const description = freight.description;
        const destination = freight.destination;
        const capacity = freight.capacity;
        const product = freight.product;

        let viajeElement = document.createElement('div');
        viajeElement.classList.add('viaje');
        viajeElement.innerHTML = `
            <h3>${name}</h3>
            <p>Fecha: ${date}</p>
            <p>Destino: ${destination}</p>
            <p>Descripción: ${description}</p>
            <p>Capacidad: ${capacity}</p>
            <p>Producto: ${product}</p>
        `;
        viajesContainer.appendChild(viajeElement);
    }
}
window.onload = freightsList;
