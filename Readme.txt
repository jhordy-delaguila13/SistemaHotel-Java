
-> Jhordy Del Aguila
--------------------

Proyecto - Sistema para Hotel
-------------------------------------------------
Herramientas: 
*Netbeasn 7.4
*Base de datos : mysql
*JasReportes
*Workbench para el diagrama de la bd
*Lenguaje de programacion: Java
*Arquitectura en Capas.
-------------------------------------------------
El proyecto consiste en un sistema de Hotel.
Para poder utilizar correctamente sin que aparesca errores, 
en el funcionamiento de la misma.Es necesario adjuntar primero
la base de datos. 
La base de datos se encuentra en la carpeta "2 - BaseDeDatos"
-------PASOS-------
Primero, visualizar el archivo Conexion.java
NOTA: esto se encuentra en la aplicacion: componenteDatos > Conexion.java

Segundo, crear una bd llamado: basehotel

Tercero, adjuntar el script SQL en cualquier gestor 
de base de datos MySQL: BaseTransporte_v16SQL.sql

Cuarto, por lo general el usario y contraseña de MySQl es: 
	Usuario: root
	Password: "" #No tiene password o vacio
	NOTA: si tiene un usario y password tendra que editar en
	el archivo Conexion.java
	Ejemplo:
	*Usario por defecto: 
	conexion = DriverManager.getConnection(url,"root",""); 
	*Usuario editado
	conexion = DriverManager.getConnection(url,"jhordy","delaguila");

Quinto, Listo. 


=>Contacto
jhordydelaguila@hotmail.com