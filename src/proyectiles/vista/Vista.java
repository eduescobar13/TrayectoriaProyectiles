/**
 * Clase para la implementación de la vista del proyecto.
 * @author: Eduardo Escobar Alberto
 * @version: 1.0 19/04/2017
 * Correo electrónico: eduescal13@gmail.com.
 * Asignatura: Programación de Aplicaciones Interactivas.
 * Centro: Universidad de La Laguna.
*/

package proyectiles.vista;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;

public class Vista {
	
	// 	DECLARACIÓN DE VARIABLES GLOBALES.
	Dimension tamanoPantalla = Toolkit.getDefaultToolkit().getScreenSize();

	// DECLARACIÓN DE CONSTANTES.
	final static Color COLOR_PANEL_GRAFICO = Color.WHITE;
	final static Color COLOR_PANEL_BOTONES = new Color(217, 221, 227);
	final static int COLUMNAS_POR_DEFECTO = 6;
	final static int FILAS_POR_DEFECTO = 6;
	
	// DECLARACIÓN DE ATRIBUTOS.
	private Ventana ventana;
	private PanelBotones panelBotones;
	private PanelGrafico panelGrafico;
	
	/**
	 * Constructor.
	 */
	public Vista() {
		ventana = new Ventana("Trayectoria Proyectiles", tamanoPantalla.width, tamanoPantalla.height); // Creamos una ventana.
		panelBotones = new PanelBotones(COLOR_PANEL_BOTONES);
		panelGrafico = new PanelGrafico(panelBotones.getBotonera().getSliderAnguloInicial().getValue(), panelBotones.getBotonera().getSliderAlturaInicial().getValue(), COLOR_PANEL_GRAFICO);
		ventana.getVentanaPrincipal().setLayout(new BorderLayout());
		ventana.anadirComponente(panelGrafico, BorderLayout.CENTER);
		ventana.anadirComponente(panelBotones, BorderLayout.SOUTH);
	}
	
	/**
	 * Método para mostrar o no la vista, dependiendo del valor del parámetro.
	 * @param mostrar. Valor booleana para indicar si se muestra la vista.
	 */
	public void mostrarVista(boolean mostrar) {
		getVentana().mostrarVentana(mostrar);; // Hacemos visible la ventana.
	}

	/**
	 * Función getter del atributo ventana.
	 * @return. Atributo ventana.
	 */
	public Ventana getVentana() {
		return ventana;
	}

	/**
	 * Método setter del atributo ventana.
	 * @param ventana. Nuevo valor del atributo ventana.
	 */
	public void setVentana(Ventana ventana) {
		this.ventana = ventana;
	}

	public PanelBotones getPanelBotones() {
		return panelBotones;
	}

	public void setPanelBotones(PanelBotones panelBotones) {
		this.panelBotones = panelBotones;
	}

	public PanelGrafico getPanelGrafico() {
		return panelGrafico;
	}

	public void setPanelGrafico(PanelGrafico panelGrafico) {
		this.panelGrafico = panelGrafico;
	}
}
