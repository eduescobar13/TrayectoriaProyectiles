/**
 * Clase para la implementación de un panel donde se mostrarán los datos de la trayectoria. Extiende de JPanel.
 * @author: Eduardo Escobar Alberto
 * @version: 1.0 03/05/2017
 * Correo electrónico: eduescal13@gmail.com.
 * Asignatura: Programación de Aplicaciones Interactivas.
 * Centro: Universidad de La Laguna.
*/

package proyectiles.vista;

import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class PanelInformacion extends JPanel {
	private static final long serialVersionUID = 1L;
	
	// DECLARACIÓN DE ATRIBUTOS.
	JLabel etiquetaTiempoTranscurrido;
	JTextField textTiempoTranscurrido;
	JLabel etiquetaDistanciaHorizontal;
	JTextField textDistanciaHorizontal;
	JLabel etiquetaAlturaActual;
	JTextField textAlturaActual;
	JLabel etiquetaAlturaMaxima;
	JTextField textAlturaMaxima;
	Color colorFondo;
	
	public PanelInformacion(Color colorFondo) {
		etiquetaTiempoTranscurrido = new JLabel("Tiempo transcurrido: ");
		textTiempoTranscurrido = new JTextField();
		textTiempoTranscurrido.setEditable(false);
		textTiempoTranscurrido.setText("0 s");
		etiquetaDistanciaHorizontal = new JLabel("Distancia horizontal: ");
		textDistanciaHorizontal = new JTextField();
		textDistanciaHorizontal.setEditable(false);
		textDistanciaHorizontal.setText("0 m");
		etiquetaAlturaActual = new JLabel("Altura actual: ");
		textAlturaActual = new JTextField();
		textAlturaActual.setEditable(false);
		textAlturaActual.setText("0 m");
		etiquetaAlturaMaxima = new JLabel("Altura maxima: ");
		textAlturaMaxima = new JTextField();
		textAlturaMaxima.setEditable(false);
		textAlturaMaxima.setText("0 m");
		this.colorFondo = colorFondo;
		setBackground(colorFondo);
		setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(), "<html><b>Información</b></html>"));
		gestionarLayout();
	}
	
	public void gestionarLayout() {
		setLayout(new GridLayout(4, 2));
		add(etiquetaTiempoTranscurrido);
		add(textTiempoTranscurrido);
		add(etiquetaDistanciaHorizontal);
		add(textDistanciaHorizontal);
		add(etiquetaAlturaActual);
		add(textAlturaActual);
		add(etiquetaAlturaMaxima);
		add(textAlturaMaxima);
	}

	public JLabel getEtiquetaTiempoTranscurrido() {
		return etiquetaTiempoTranscurrido;
	}

	public void setEtiquetaTiempoTranscurrido(JLabel etiquetaTiempoTranscurrido) {
		this.etiquetaTiempoTranscurrido = etiquetaTiempoTranscurrido;
	}

	public JTextField getTextTiempoTranscurrido() {
		return textTiempoTranscurrido;
	}

	public void setTextTiempoTranscurrido(JTextField textTiempoTranscurrido) {
		this.textTiempoTranscurrido = textTiempoTranscurrido;
	}

	public JLabel getEtiquetaDistanciaHorizontal() {
		return etiquetaDistanciaHorizontal;
	}

	public void setEtiquetaDistanciaHorizontal(JLabel etiquetaDistanciaHorizontal) {
		this.etiquetaDistanciaHorizontal = etiquetaDistanciaHorizontal;
	}

	public JTextField getTextDistanciaHorizontal() {
		return textDistanciaHorizontal;
	}

	public void setTextDistanciaHorizontal(JTextField textDistanciaHorizontal) {
		this.textDistanciaHorizontal = textDistanciaHorizontal;
	}

	public JLabel getEtiquetaAlturaActual() {
		return etiquetaAlturaActual;
	}

	public void setEtiquetaAlturaActual(JLabel etiquetaAlturaActual) {
		this.etiquetaAlturaActual = etiquetaAlturaActual;
	}

	public JTextField getTextAlturaActual() {
		return textAlturaActual;
	}

	public void setTextAlturaActual(JTextField textAlturaActual) {
		this.textAlturaActual = textAlturaActual;
	}

	public JLabel getEtiquetaAlturaMaxima() {
		return etiquetaAlturaMaxima;
	}

	public void setEtiquetaAlturaMaxima(JLabel etiquetaAlturaMaxima) {
		this.etiquetaAlturaMaxima = etiquetaAlturaMaxima;
	}

	public JTextField getTextAlturaMaxima() {
		return textAlturaMaxima;
	}

	public void setTextAlturaMaxima(JTextField textAlturaMaxima) {
		this.textAlturaMaxima = textAlturaMaxima;
	}

	public Color getColorFondo() {
		return colorFondo;
	}

	public void setColorFondo(Color colorFondo) {
		this.colorFondo = colorFondo;
	}	
}
