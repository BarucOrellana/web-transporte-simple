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

![Captura de pantalla 2024-09-25 220825](https://github.com/user-attachments/assets/dab2697c-320d-4fd4-88a0-d50f9caee95a)


Ademas de los fletes que ya se encuentra publicados y de manera activa buscan transporte.

![Captura de pantalla 2024-09-25 221013](https://github.com/user-attachments/assets/445f2264-3a6f-421e-8131-a704c5129cc7)


## Ingreso a la aplicación
En la parte superior de la pagina principal, podemos encontrar un menú desplegable que contiene las distintas formas que existen para creación de cuentas e inicios de sesión.

Inicio de sesión: 

![Captura de pantalla 2024-09-25 221138](https://github.com/user-attachments/assets/63fa0336-c13c-4b76-970e-e1994c4ad182)

Creación de cuenta:

![Captura de pantalla 2024-09-25 221146](https://github.com/user-attachments/assets/1f4e67d3-47bf-42e9-b24b-5b62e8095639)

Se inicia sesión con el nombre de usuario y contraseña con el que se creo la cuenta, el proceso de autorización se realiza mediante JWT, el cual es generado al momento de iniciar sesión y tiene una vigencia de 15 días.

Una vez creada la cuenta e iniciado sesión, según tu rol dentro de la aplicación, podras visualizar una pagina de cliente o de proveedor.

### Pagina principal de los clientes:
![Captura de pantalla 2024-09-26 150816](https://github.com/user-attachments/assets/ffc9ba06-a1be-49db-b6a5-f46416af947f)


### Pagina de principal de los proveedores:
![Captura de pantalla 2024-09-26 152017](https://github.com/user-attachments/assets/d664b754-0e2c-4dd2-9d93-b41022b6059b)

## Principales funcionalidades

Tanto los clientes como los proveedores tienen a su disponibilidad algunas herramientas que ayudan a crear la primera conexión entre uno y otro, la principal herramienta de los usuarios con rol de cliente, es poder crear nuevos fletes con algunos detalles, tal como se mostro en la pagina principal, ademas de esto, pueden actualizar sus datos personales:
![Captura de pantalla 2024-09-26 150933](https://github.com/user-attachments/assets/e348c8b0-5d13-47de-bd70-50ed34b88a56)

Asi como editar y eliminar los viajes que han publicado:
![Captura de pantalla 2024-09-26 150949](https://github.com/user-attachments/assets/56d4ba29-7fbf-4446-946d-5f1b7aad96f8)

*Formulario de edición de los fletes publicados*
![Captura de pantalla 2024-09-26 151002](https://github.com/user-attachments/assets/18e26a9f-919f-4876-9b5b-1ae12fcf9421)


Por su parte, los proveedores pueden visualizar los viajes publicados como se mostro en su pagina princial, ademas de poder visualizar los datos del cliente al dar clic en el nombre que aparece en cada viaje:
![Captura de pantalla 2024-09-26 155620](https://github.com/user-attachments/assets/f480cbca-a378-456b-9008-56ccbe7eb099)

*Información del cliente vista desde la pantalla del proveedor:*
![Captura de pantalla 2024-09-26 155627](https://github.com/user-attachments/assets/725f691f-378d-4f53-b860-d50afb90d9e3)

Los proveedores tambien son libres de actualizar su información personal, para garantizar que todos los datos esten actualizados:
![Captura de pantalla 2024-09-26 152041](https://github.com/user-attachments/assets/b810cada-2e2f-4195-b656-a9f41ca553a7)

