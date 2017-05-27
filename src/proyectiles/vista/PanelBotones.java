/**
 * Clase para la implementación de un panel que contendrá los botones de información. Extiende de JPanel.
 * @author: Eduardo Escobar Alberto
 * @version: 1.0 03/05/2017
 * Correo electrónico: eduescal13@gmail.com.
 * Asignatura: Programación de Aplicaciones Interactivas.
 * Centro: Universidad de La Laguna.
*/

package proyectiles.vista;

import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.BorderFactory;
import javax.swing.JPanel;

public class PanelBotones extends JPanel {
	private static final long serialVersionUID = 1L;	
	
	// DECLARACIÓN DE ATRIBUTOS.
	private Botonera botonera;
	private PanelInformacion panelInformacion;
	private Color colorFondo;
	
	/**
	 * Constructor.
	 * @param colorFondo. Color de fondo del panel.
	 */
	public PanelBotones(Color colorFondo) {
		botonera = new Botonera(colorFondo);
		panelInformacion = new PanelInformacion(colorFondo);
		this.colorFondo = colorFondo;
		setBackground(colorFondo);
		setLayout(new BorderLayout());
		setBorder(BorderFactory.createLineBorder(Color.BLACK));
		add(botonera, BorderLayout.CENTER);
		add(panelInformacion, BorderLayout.EAST);
	}

	public Color getColorFondo() {
		return colorFondo;
	}

	public void setColorFondo(Color colorFondo) {
		this.colorFondo = colorFondo;
	}

	public Botonera getBotonera() {
		return botonera;
	}

	public void setBotonera(Botonera botonera) {
		this.botonera = botonera;
	}

	public PanelInformacion getPanelInformacion() {
		return panelInformacion;
	}

	public void setPanelInformacion(PanelInformacion panelInformacion) {
		this.panelInformacion = panelInformacion;
	}
}
