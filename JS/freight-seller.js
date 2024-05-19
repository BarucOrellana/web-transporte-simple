window.onload = async () => {
    const id_seller = localStorage.getItem("idSeller")
    const jwt = localStorage.getItem("jwt")
    if(id_seller){
        try{const requestFreight = await fetch(`http://localhost:8090/transporte_simple/freights/${id_seller}`, {
            method: 'GET',
            headers: {
                'Accept': 'application/json',
                'Content-Type': 'application/json',
                'Authorization': 'Bearer ' + jwt
            }
        });
            if(requestFreight.ok){
                const freight = await requestFreight.json();
                let freightContainer = document.querySelector('.viajes');

                for (let freightData of freight) {
                    const idFreight = freightData.idFreight;
                    const date = moment(freightData.date).format('YYYY-MM-DD');
                    const description = freightData.description;
                    const destination = freightData.destination;
                    const capacity = freightData.capacity;
                    const product = freightData.product;

                    let freightElement = document.createElement('div');
                    freightElement.classList.add('viaje');
                    freightElement.innerHTML = `
                        <table><tr>
                        <td>${idFreight}</td>
                        <td>${date}</td>
                        <td> ${destination}</td>
                        <td> ${description}</td>
                        <td> ${capacity}</td>
                        <td> ${product}</td>
                        <td><i onClick = showForm(${idFreight})>Editar</i></td>
                        <td><i class="delete" onClick = deleteFreight(${idFreight}) >Eliminar</i></td>
                        </tr></table>
                    `;
                    freightContainer.appendChild(freightElement);
                    fillForm(freightData)
                }
            }else{
                console.error('No se pudo obtener los fletes del cliente');
            }
        }catch(error){
            console.error('Ocurrió un error al realizar la solicitud:', error)
        }
    }else {
        console.error('No se encontró el id_seller en el localStorage');

    }
};


/*Formulario para editar los datos del usuario*/

let btn = document.getElementById("edit");
btn.addEventListener("click", editFreight);

async function editFreight(event) {
    event.preventDefault();

    const id_seller = localStorage.getItem("idSeller")
    const jwt = localStorage.getItem("jwt")
    const idFreight = localStorage.getItem("idFreight")

    let campos = {
        idFreight:parseInt(idFreight) ,
        destination: document.getElementById("destination").value,
        date: moment(document.getElementById("date").value).toDate(),
        description: document.getElementById("description").value,
        idCapacity: parseInt(document.getElementById("capacity").value),
        idProduct: parseInt(document.getElementById("product").value),
        idSeller: parseInt(id_seller)
    };

    if (!campos.idFreight || !campos.destination || !campos.date || !campos.description || !campos.idCapacity || !campos.idProduct || !campos.idSeller) {
        alert("Por favor llena todos los campos del formulario.");
        return;
    }

    const request = await fetch("http://localhost:8090/transporte_simple/freights/update-freight", {
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
        window.location.href = "../HTML/freight-seller.html";
        alert("Viaje modificado");
    } else {
        console.error("Error al editar");
    }
}

function showForm(idFreight){
    let form = document.getElementById("form");
    form.style.display = "block";
    localStorage.setItem("idFreight", idFreight);
}

function fillForm(freightData){
    document.getElementById("destination").value = freightData.destination;
    document.getElementById("description").value = freightData.description;
}

document.getElementById("backButton").addEventListener("click", () => {
    window.location.href = "../HTML/home-page-seller.html";
});

/*Función para eliminar un flete*/
async function deleteFreight(idFreight) {
    const jwt = localStorage.getItem("jwt")

    const request = await fetch(`http://localhost:8090/transporte_simple/freights/delete/${idFreight}`, {
        method: 'DELETE', 
        headers: {
            'Accept': 'application/json',
            'Content-Type': 'application/json',
            'Authorization': 'Bearer ' + jwt
        },
        credentials: 'same-origin'
    });
    if (request.ok) {
        window.location.href = "../HTML/freight-seller.html";
        alert("Viaje eliminado");
    } else {
        console.error("Error al eliminar");
    }
}

document.getElementById("log-out").addEventListener("click", function() {
    localStorage.clear();
    window.location.href = "../HTML/index.html";
});