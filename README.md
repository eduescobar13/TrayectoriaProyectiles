# ESIT ULL Grado de Informática
## PROGRAMACIÓN DE APLICACIONES INTERACTIVAS. Implementación y simulación visual de la trayectoria descrita por un proyectil.
#### Realizada por Eduardo Escobar Alberto.

##### Introducción
Se denomina movimiento parabólico al realizado por un objeto cuya trayectoria describe una parábola. Se corresponde con la trayectoria ideal de un proyectil que se mueve en un medio que no ofrece resistencia al avance y que está sujeto a un campo gravitatorio uniforme.
En este repositorio se ha desarrollado un programa en Java que simula el lanzamiento de un proyectil disparado desde un punto dado con una velocidad y ángulo de disparo iniciales.

##### Parámetros
* El programa dispone de botones para lanzar, pausar y borrar.
* La interfaz gráfica a diseñada cuenta con 3 partes diferenciadas:
	- **PANEL GRÁFICO:** Donde se dibuja la trayectoria del proyectil.
	- **PANEL DE BOTONES:** Donde figuran los botones y controles de parametros de entrada.
	- **PANEL DE INFORMACIÓN:** Donde se muestra la información (distancia recorrida, tiempo transcurrido, etc.).
	
* La interfaz de usuario dispone de deslizantes en el **panel de botones** en los que el usuario puede modificar la **velocidad inicial** y el **ángulo inicial**. En el mismo panel, también existe un checkbox en el que el usuario elige si se dibuja o no la trayectoria del proyectil. Las trayectorias se dibujarán con diferentes colores, que se superpondrán en la pantalla entre diferentes disparos.
* En el panel **panel de información**, se muestran (conforme el proyectil describe su trayectoria) los siguientes datos: 
	- **Tiempo transcurrido (t) en segundos.**
	- **Distancia recorrida horizontalmente (x) en metros.**
	- **Altura del proyectil (y) en metros.**
	- **Altura máxima alcanzada (y max) también en metros.**
En el origen de coordenadas, se representa el cañón que efectúa el disparo mediante una flecha (vector) cuyo ángulo con el eje de abcisas coincida con el ángulo del disparo (la flecha se orienta en función del valor del ángulo introducido).

##### Interfaz gráfica
![](interfaz_grafica/panel_configuracion.png) ![](interfaz_grafica/ejemplo_ejecucion.png)
