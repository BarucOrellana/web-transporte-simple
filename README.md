# Transporte Simple

## Idea principal del proyecto
Transporte Simple es un proyecto que fue diseñado para conectar a empresas de transporte terrestre con empresas que necesiten un servicio de transporte seguro que mueva sus productos a cualquier parte de México.
Proveedores de transporte y clientes potenciales podrán crear una cuenta con sus datos de contacto e iniciar sesión de forma segura cuando quieran. Los proveedores de transporte podrán visualizar en tiempo real todos los viajes que sean publicados y acceder a la información del cliente para poder contactarlo y concretar un acuerdo comercial.
Los potenciales clientes subirán sus rutas con la información para realizar el pedido, como, por ejemplo: destino, producto, peso y fecha. Así los proveedores de transporte interesados los contactarán y podrán concretar un acuerdo comercial entre ambas partes.

## Caracteristicas tecnicas

<h3>Backend </h3>
<li>Java: 17</li>
<li>Spring Boot: 3.2.2</li>
<li>Java-JWT: 4.4.0</li>

<h3>Frontend</h3>
<li>HTML5</li>
<li>CSS</li>
<li>JavaScript</li>
<li>Moment.js: 2.30.1</li>

## Pagina principal
Al ingresar a Transporte Simple, podemos apreciar sus principales ventajas
![image](https://github.com/user-attachments/assets/1643c8e0-ab46-4e56-803e-818396bb77fd)

Ademas de los fletes que ya se encuentra publicados y de manera activa buscan transporte.
![image](https://github.com/user-attachments/assets/42ca1ef0-ea6d-440f-94ae-7add5fa71c8e)

## Ingreso a la aplicación
En la parte superior de la pagina principal, podemos encontrar un menú desplegable que contiene las distintas formas que existen para creación de cuentas e inicios de sesión.

Inicio de sesión: 
![Captura de pantalla 2024-09-25 221138](https://github.com/user-attachments/assets/63fa0336-c13c-4b76-970e-e1994c4ad182)

Creación de cuenta:
![Captura de pantalla 2024-09-25 221146](https://github.com/user-attachments/assets/1f4e67d3-47bf-42e9-b24b-5b62e8095639)

Se inicia sesión con el nombre de usuario y contraseña con el que se creo la cuenta, el proceso de autorización se realiza mediante JWT, el cual es generado al momento de iniciar sesión y tiene una vigencia de 15 días.

Una vez creada la cuenta e iniciado sesión, según tu rol dentro de la aplicación, podras visualizar una pagina de cliente o de proveedor.

### Pagina de cliente:

### Pagina de Proveedor:

