let btn = document.getElementById("login-btn");
btn.addEventListener("click", login);

async function login(event) {
    event.preventDefault();

    let campos = {
        username: document.getElementById("username").value,
        password: document.getElementById("password").value
    };

    const request = await fetch("http://localhost:8090/transporte_simple/auth/login", {
        method: 'POST', 
        headers: {
            'Accept': 'application/json',
            'Content-Type': 'application/json'
        },
        body: JSON.stringify(campos)
    });

    if (request.ok) {
        const jwt = request.headers.get('Authorization');
        localStorage.setItem('jwt', jwt);

        const idSeller = request.headers.get('idSeller');
        localStorage.setItem('idSeller', idSeller);

        window.location.href = "http://localhost:5500/HTML/home-page-seller.html";
    } else {
        console.error("Failed to authenticate");
    }
}
