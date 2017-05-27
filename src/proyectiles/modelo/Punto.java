/**
 * Clase para la implementación de puntos.
 * @author: Eduardo Escobar Alberto
 * @version: 1.0 03/05/2017
 * Correo electrónico: eduescal13@gmail.com.
 * Asignatura: Programación de Aplicaciones Interactivas.
 * Centro: Universidad de La Laguna.
 */

package proyectiles.modelo;

import java.awt.Color;

public class Punto {
	
	private double coordenadaX;
	private double coordenadaY;
	private boolean mostrarCamino;
	private boolean mostrarVector;
	private Color color;
	
	/**
	 * Constructor.
	 * @param coordenadaX. Coordenada X del punto.
	 * @param coordenadaY. Coordenada Y del punto.
	 * @param color. Color del punto.
	 */
	public Punto(double coordenadaX, double coordenadaY, boolean mostrarCamino, boolean mostrarVector, Color color) {
		this.coordenadaX = coordenadaX;
		this.coordenadaY = coordenadaY;
		this.mostrarCamino = mostrarCamino;
		this.mostrarVector = mostrarVector;
		this.color = color;
	}
	
	/**
	 * Constructor de copia.
	 * @param puntoCopia. Punto sobre el que se realiza la copia.
	 */
	public Punto(Punto puntoCopia) {
		coordenadaX = puntoCopia.getCoordenadaX();
		coordenadaY = puntoCopia.getCoordenadaY();
		color = puntoCopia.getColor();
	}
	
	/**
	 * Método toString de la clase.
	 */
	@Override
	public String toString() {
		return(getCoordenadaX() + " " + getCoordenadaY());
	}

	/**
	 * Función equals para la comparación de puntos. Sobreescribe de la clase padre.
	 */
	@Override
    public boolean equals (Object objeto) {
    	boolean equals = false;
        if (objeto instanceof Punto) {
        	Punto puntoComparar = (Punto) objeto;
            if ((getCoordenadaX() == puntoComparar.getCoordenadaX()) && (getCoordenadaY() == puntoComparar.getCoordenadaY())) {
            	equals = true;
            }
        }
		return equals;
    }
	
	public double getCoordenadaX() {
		return coordenadaX;
	}

	public void setCoordenadaX(double coordenadaX) {
		this.coordenadaX = coordenadaX;
	}

	public double getCoordenadaY() {
		return coordenadaY;
	}

	public void setCoordenadaY(double coordenadaY) {
		this.coordenadaY = coordenadaY;
	}

	public boolean getMostrarCamino() {
		return mostrarCamino;
	}

	public void setMostrar(boolean mostrarCamino) {
		this.mostrarCamino = mostrarCamino;
	}

	public boolean getMostrarVector() {
		return mostrarVector;
	}

	public void setMostrarVector(boolean mostrarVector) {
		this.mostrarVector = mostrarVector;
	}

	public Color getColor() {
		return color;
	}

	public void setColor(Color color) {
		this.color = color;
	}
}
