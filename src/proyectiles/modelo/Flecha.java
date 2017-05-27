/**
 * Clase para la implementación de una flecha que servirá de referencia para el ángulo inicial de lanzamiento.
 * @author: Eduardo Escobar Alberto
 * @version: 1.0 26/04/2017
 * Correo electrónico: eduescal13@gmail.com.
 * Asignatura: Programación de Aplicaciones Interactivas.
 * Centro: Universidad de La Laguna.
 */

package proyectiles.modelo;

import java.awt.Color;

public class Flecha {
	
	// DECLARACIÓN DE ATRIBUTOS.
	private int grados;
	private int alturaInicial;
	private Color color;
	
	public Flecha(int grados, int alturaInicial, Color color) {
		this.grados = grados;
		this.alturaInicial = alturaInicial;
		this.color = color;
	}

	public int getGrados() {
		return grados;
	}

	public void setGrados(int grados) {
		this.grados = grados;
	}

	public int getAlturaInicial() {
		return alturaInicial;
	}

	public void setAlturaInicial(int alturaInicial) {
		this.alturaInicial = alturaInicial;
	}

	public Color getColor() {
		return color;
	}

	public void setColor(Color color) {
		this.color = color;
	}
}
