/**
 * Clase para la implementación de una ventana.
 * @author: Eduardo Escobar Alberto
 * @version: 1.0 05/04/2017
 * Correo electrónico: eduescal13@gmail.com.
 * Asignatura: Programación de Aplicaciones Interactivas.
 * Centro: Universidad de La Laguna.
 */

package proyectiles.vista;

import java.awt.Component;

import javax.swing.JFrame;

public class Ventana {
	
	// DECLARACIÓN DE CONSTANTES.
	final static int ANCHO_FRAME_DEFECTO = 500;
	final static int ALTO_FRAME_DEFECTO = 500;
	final static String NOMBRE_POR_DEFECTO = "Ventana";
	
	// DECLARACIÓN DE ATRIBUTOS.
	private int altura;
	private int anchura;
	private JFrame ventanaPrincipal;
	
	/**
	 * Constructor por defecto.
	 */
	public Ventana() {
		ventanaPrincipal = new JFrame();
		ventanaPrincipal.setTitle(NOMBRE_POR_DEFECTO);
		ventanaPrincipal.setSize(ANCHO_FRAME_DEFECTO, ALTO_FRAME_DEFECTO);
		ventanaPrincipal.setLocationRelativeTo(null); 
		ventanaPrincipal.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	/**
	 * Constructor. 
	 * @param nombreVentana. Nombre de la ventana.
	 */
	public Ventana(String nombreVentana, int anchura, int altura) {
		ventanaPrincipal = new JFrame();
		ventanaPrincipal.setTitle(nombreVentana);
		ventanaPrincipal.setSize(anchura, altura);
		ventanaPrincipal.setLocationRelativeTo(null); 
		ventanaPrincipal.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	/**
	 * Método para añadir un componente a la ventena.
	 * @param component. Componente a añadir.
	 */
	public void anadirComponente(Component component) {
		getVentanaPrincipal().add(component);
	}
	
	/**
	 * Método para añadir un componente a la ventana.
	 * @param component. Componente a añadir.
	 * @param posicion. Posicion en la que se situa el componente.
	 */
	public void anadirComponente(Component component, Object posicion) {
		getVentanaPrincipal().add(component, posicion);
	}
	
	/**
	 * Método de interfaz para el setVisible de JFrame.
	 * @param mostrar. Valor booleano para indicar si se muestra la ventana.
	 */
	public void mostrarVentana(boolean mostrar) {
		getVentanaPrincipal().setVisible(mostrar);
	}

	/**
	 * Función getter del atributo altura.
	 * @return. Atributo altura.
	 */
	public int getAltura() {
		return altura;
	}

	/**
	 * Método setter del atributo altura.
	 * @param altura. Nuevo valor del atributo altura.
	 */
	public void setAltura(int altura) {
		this.altura = altura;
	}

	/**
	 * Función getter del atributo anchura.
	 * @return. Atributo anchura.
	 */
	public int getAnchura() {
		return anchura;
	}

	/**
	 * Método setter del atributo anchura.
	 * @param anchura. Nuevo valor del atributo anchura.
	 */
	public void setAnchura(int anchura) {
		this.anchura = anchura;
	}

	/**
	 * Función getter del atributo ventanaPrincipal. 
	 * @return Objeto de la clase JFrame.
	 */
	public JFrame getVentanaPrincipal() {
		return ventanaPrincipal;
	}

	/**
	 * Método setter del atributo ventanaPrincipal. 
	 * @param ventanaPrincipal. Nuevo valor para el atributo ventanaPrincipal.
	 */
	public void setVentanaPrincipal(JFrame ventanaPrincipal) {
		this.ventanaPrincipal = ventanaPrincipal;
	}
}
