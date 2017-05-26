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
	
La interfaz de usuario dispondra ́ de campos de texto (en P2) en los que el usuario puedeintroducirvelocidadinicialya ́nguloinicial.Estosvaloressepuedenintroducir tanto en el campo de texto como usando un control deslizante (como en [3]).
    2
La interfaz dispondra ́ tambie ́n en P2 de una checkbox en la que el usuario elige si se dibuja o no la trayectoria del proyectil. Las trayectorias se dibujara ́n con diferentes colores, que se superpondra ́n en la pantalla entre diferentes disparos (como en [3]).
En el panel P3, la informacio ́n que se mostrara ́ conforme el proyectil describe su trayectoria sera ́: tiempo transcurrido (t) en segundos, distancia recorrida horizontalmente (x) en metros, altura del proyectil (y) en metros, altura ma ́xima alcanzada (y max) tambie ́n en metros.
En el origen de coordenadas, se representara ́ el can ̃o ́n que efectu ́a el disparo mediante una flecha (vector) cuyo a ́ngulo con el eje de abcisas coincida con el a ́ngulo del disparo (la flecha se orienta en funcio ́n del valor del a ́ngulo introducido).
Para el primer proyectil lanzado, la escala de distancia (eje X) se configurara ́ dina ́micamente de modo que ese primer lanzamiento “no se salga de la escala”.
Siempre que la apliacio ́n cumpla con las especificaciones anteriores, todo lo dema ́s (colores, disposicio ́n de los paneles, escalas, etc.) queda a eleccio ́n del desarrollador. Asimismo, cada desarrollo puede incluir, de forma opcional y segu ́n el criterio de su autor/a, aquellos elementos gra ́ficos que contribuyan a una mayor calidad del disen ̃o final.
El programa desarrollado podra ́ ejecutarse como un applet (habra ́ que desarrollar tambie ́n una pa ́gina en formato HTML con el applet incrustado) y tambie ́n como aplicacio ́n auto ́noma.

* **NIVEL DE DIFICULTAD:** Seleccionando desde el NIVEL 1 - FÁCIL (menos cantidad de obstáculos) hasta NIVEL 4 - EXTREMO (obstáculos insuperables).
* **TAMAÑO:** Tamaño del tablero de obstáculos. Indicado en número de celdas (10 x 10, 30 x 30, etc.).
* **MAPA DE JUEGO:** Cambia el fondo del tablero y las imágenes que representan a cada obstáculo. Simple cambio visual.  

![](interfaz_grafica/panel_configuracion.png) ![](interfaz_grafica/ejemplo_ejecucion.png)
