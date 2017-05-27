package proyectiles.principal;
/**
 * Clase para la implementación de un camino aleatorio.
 * @author: Eduardo Escobar Alberto
 * @version: 1.0 19/04/2017
 * Correo electrónico: eduescal13@gmail.com.
 * Asignatura: Programación de Aplicaciones Interactivas.
 * Centro: Universidad de La Laguna.
 */

import proyectiles.controlador.Controlador;

public class Proyectiles {
	
	// DECLARACIÓN DE ATRIBUTOS.
	private Controlador controlador;
	
	/**
	 * Constructor.
	 */
	public Proyectiles() {
		controlador = new Controlador();
	}
	
	/**
	 * Método que encapsula mostrarVista de las clases instanciadas.
	 * @param mostrar. Variable booleana para mostrar la vista.
	 */
	public void mostrarVista(boolean mostrar) {
		getControlador().mostrarVista(mostrar);
	}

	/**
	 * Función getter del atributo controlador.
	 * @return Valor del atributo controlador.
	 */
	public Controlador getControlador() {
		return controlador;
	}

	/**
	 * Método setter del atributo controlador.
	 * @param controlador. Nuevo valor del atributo controlador.
	 */
	public void setControlador(Controlador controlador) {
		this.controlador = controlador;
	}
}
