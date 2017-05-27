/**
 * Clase para la implementación de una botonera para los botones de acción. Extiende de JPanel.
 * @author: Eduardo Escobar Alberto
 * @version: 1.0 26/04/2017
 * Correo electrónico: eduescal13@gmail.com.
 * Asignatura: Programación de Aplicaciones Interactivas.
 * Centro: Universidad de La Laguna.
 */

package proyectiles.vista;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class Botonera extends JPanel {
	private static final long serialVersionUID = 1L;
	
	// DECLARACIÓN DE CONSTANTES.
	final static int VELOCIDAD_INICIAL_MINIMA = 1;
	final static int VELOCIDAD_INICIAL_MAXIMA = 100;
	final static int ANGULO_INICIAL_MINIMO = 0;
	final static int ANGULO_INICIAL_MAXIMO = 90;
	final static int ALTURA_INICIAL_MINIMA = 0;
	final static int ALTURA_INICIAL_MAXIMA = 100;
	final static int VELOCIDAD_INICIAL_INICIAL = 50;
	final static int ANGULO_INICIAL_INICIAL = 45;
	final static int ALTURA_INICIAL_INICIAL = 0;
	final static int BOTON_REANUDAR = 0;
	final static int BOTON_PAUSAR = 1;

	// DECLARACIÓN DE ATRIBUTOS.
	private JButton botonLanzar;
	private JButton botonPausarReanudar;
	private JButton botonBorrar;
	private JSlider sliderVelocidadInicial;
	private JSlider sliderAnguloInicial;
	private JSlider sliderAlturaInicial;
	private JTextField textVelocidadInicial;
	private JTextField textAnguloInicial;
	private JTextField textAlturaInicial;
	private JTextField textColorTrayectoria;
	private JCheckBox checkboxMostrarCamino;
	private JCheckBox checkboxMostrarVector;
	private Color colorFondo;
	
	/**
	 * Constructor
	 * @param colorFondo. Color de fondo del panel.
	 */
	public Botonera(Color colorFondo) {
		botonLanzar = new JButton("<html><b>LANZAR</b></html>", new ImageIcon("images/ejecutar.png"));
		botonPausarReanudar = new JButton("<html><b>PAUSAR</b></html>", new ImageIcon("images/pausar.png"));
		botonBorrar = new JButton("<html><b>BORRAR</b></html>", new ImageIcon("images/borrar.png"));
		sliderVelocidadInicial = new JSlider(SwingConstants.HORIZONTAL, VELOCIDAD_INICIAL_MINIMA, VELOCIDAD_INICIAL_MAXIMA, 1);
		sliderAnguloInicial = new JSlider(SwingConstants.HORIZONTAL, ANGULO_INICIAL_MINIMO, ANGULO_INICIAL_MAXIMO, 1);
		sliderAlturaInicial = new JSlider(SwingConstants.HORIZONTAL, ALTURA_INICIAL_MINIMA, ALTURA_INICIAL_MAXIMA, 1);
		textVelocidadInicial = new JTextField(5);
		textAnguloInicial = new JTextField(7);
		textColorTrayectoria = new JTextField(6);
		textAlturaInicial = new JTextField(7);
		checkboxMostrarCamino = new JCheckBox();
		checkboxMostrarVector = new JCheckBox();
		this.colorFondo = colorFondo;
		setBackground(colorFondo);
		inicializarBotonera();
		gestionarLayout();
	}
	
	public void inicializarBotonera() {
		sliderVelocidadInicial.setValue(VELOCIDAD_INICIAL_INICIAL);
		sliderAnguloInicial.setValue(ANGULO_INICIAL_INICIAL);
		sliderAlturaInicial.setValue(ALTURA_INICIAL_INICIAL);
		textVelocidadInicial.setEditable(false);
		textVelocidadInicial.setText(sliderVelocidadInicial.getValue() + " m/s");
		textAnguloInicial.setEditable(false);
		textAnguloInicial.setText(sliderAnguloInicial.getValue() + " grados");
		textAlturaInicial.setEditable(false);
		textAlturaInicial.setText(sliderAlturaInicial.getValue() + " metros");
		textColorTrayectoria.setEditable(false);
		checkboxMostrarCamino.setSelected(true);
	}
	
	/**
	 * Método para gestionar el layout del panel.
	 */
	public void gestionarLayout() {
		setLayout(new BorderLayout());
		JPanel panelBotonesSlider = new JPanel();
		JPanel panelCheckBox = new JPanel();
		panelBotonesSlider.setLayout(new GridLayout(3, 2));
		panelBotonesSlider.setBackground(getColorFondo());
		panelCheckBox.setBackground(getColorFondo());
		panelCheckBox.setLayout(new GridLayout(1, 1));
		JPanel panelSliderVelocidadInicial = new JPanel();
		panelSliderVelocidadInicial.setLayout(new FlowLayout());
		panelSliderVelocidadInicial.setBackground(getColorFondo());
		JPanel panelSliderAnguloInicial = new JPanel();
		panelSliderAnguloInicial.setLayout(new FlowLayout());
		panelSliderAnguloInicial.setBackground(getColorFondo());
		JPanel panelSliderAlturaInicial = new JPanel();
		panelSliderAlturaInicial.setLayout(new FlowLayout());
		panelSliderAlturaInicial.setBackground(getColorFondo());
		JPanel panelCheckBoxCamino = new JPanel();
		panelCheckBoxCamino.setLayout(new GridLayout(3, 1));
		JPanel checkbox1 = new JPanel(new FlowLayout());
		checkbox1.setBackground(getColorFondo());
		JPanel checkbox2 = new JPanel(new FlowLayout());
		checkbox2.setBackground(getColorFondo());
		JPanel color = new JPanel(new FlowLayout());
		color.setBackground(getColorFondo());
		panelCheckBoxCamino.setBackground(getColorFondo());
		JLabel etiquetaVelocidadInicial = new JLabel("<html><b>Velocidad inicial: </b></html>");
		JLabel etiquetaAnguloInicial = new JLabel("<html><b>Ángulo inicial: </b></html>");
		JLabel etiquetaAlturaInicial = new JLabel("<html><b>Altura inicial: </b></html>");
		JLabel etiquetaMostrarCamino = new JLabel("<html><b>Mostrar camino</b></html>");
		JLabel etiquetaMostrarVector = new JLabel("<html><b>Mostrar vector</b></html>");
		JLabel etiquetaColorCamino = new JLabel("<html><b>Color camino</b></html>");
		panelSliderVelocidadInicial.add(etiquetaVelocidadInicial);
		panelSliderVelocidadInicial.add(sliderVelocidadInicial);
		panelSliderVelocidadInicial.add(textVelocidadInicial);
		panelSliderAnguloInicial.add(etiquetaAnguloInicial);
		panelSliderAnguloInicial.add(sliderAnguloInicial);
		panelSliderAnguloInicial.add(textAnguloInicial);
		panelSliderAlturaInicial.add(etiquetaAlturaInicial);
		panelSliderAlturaInicial.add(sliderAlturaInicial);
		panelSliderAlturaInicial.add(textAlturaInicial);
		checkbox1.add(etiquetaMostrarCamino);
		checkbox1.add(checkboxMostrarCamino);
		checkbox2.add(etiquetaMostrarVector);
		checkbox2.add(checkboxMostrarVector);
		color.add(etiquetaColorCamino);
		color.add(textColorTrayectoria);
		panelCheckBoxCamino.add(checkbox1);
		panelCheckBoxCamino.add(checkbox2);
		panelCheckBoxCamino.add(color);
		panelBotonesSlider.add(botonLanzar);
		panelBotonesSlider.add(panelSliderVelocidadInicial);
		panelCheckBox.add(panelCheckBoxCamino);
		panelBotonesSlider.add(botonPausarReanudar);
		panelBotonesSlider.add(panelSliderAnguloInicial);
		panelBotonesSlider.add(botonBorrar);
		panelBotonesSlider.add(panelSliderAlturaInicial);
		add(panelBotonesSlider, BorderLayout.CENTER);
		add(panelCheckBox, BorderLayout.EAST);
	}
	
	/**
	 * Método para cambiar el tipo de botón al realizar la pulsación.
	 * @param tipoBoton. Tipo de botón actual.
	 */
	public void cambiarPausarReanudar(int tipoBoton) {
		if (tipoBoton == BOTON_REANUDAR) {
			getBotonPausarReanudar().setText("<html><b>PAUSAR</b></html>");
			getBotonPausarReanudar().setIcon(new ImageIcon("images/pausar.png"));
		}
		if (tipoBoton == BOTON_PAUSAR) {
			getBotonPausarReanudar().setText("<html><b>REANUDAR</b></html>");
			getBotonPausarReanudar().setIcon(new ImageIcon("images/reanudar.png"));
		}
	}

	public JButton getBotonLanzar() {
		return botonLanzar;
	}

	public void setBotonLanzar(JButton botonLanzar) {
		this.botonLanzar = botonLanzar;
	}

	public JButton getBotonPausarReanudar() {
		return botonPausarReanudar;
	}

	public void setBotonPausarReanudar(JButton botonPausarReanudar) {
		this.botonPausarReanudar = botonPausarReanudar;
	}

	public JButton getBotonBorrar() {
		return botonBorrar;
	}

	public void setBotonBorrar(JButton botonBorrar) {
		this.botonBorrar = botonBorrar;
	}

	public JSlider getSliderVelocidadInicial() {
		return sliderVelocidadInicial;
	}

	public void setSliderVelocidadInicial(JSlider sliderVelocidadInicial) {
		this.sliderVelocidadInicial = sliderVelocidadInicial;
	}

	public JSlider getSliderAnguloInicial() {
		return sliderAnguloInicial;
	}

	public void setSliderAnguloInicial(JSlider sliderAnguloInicial) {
		this.sliderAnguloInicial = sliderAnguloInicial;
	}

	public JTextField getTextVelocidadInicial() {
		return textVelocidadInicial;
	}

	public void setTextVelocidadInicial(JTextField textVelocidadInicial) {
		this.textVelocidadInicial = textVelocidadInicial;
	}

	public JTextField getTextAnguloInicial() {
		return textAnguloInicial;
	}

	public void setTextAnguloInicial(JTextField textAnguloInicial) {
		this.textAnguloInicial = textAnguloInicial;
	}

	public JCheckBox getCheckboxMostrarCamino() {
		return checkboxMostrarCamino;
	}

	public void setCheckboxMostrarCamino(JCheckBox checkboxMostrarCamino) {
		this.checkboxMostrarCamino = checkboxMostrarCamino;
	}

	public Color getColorFondo() {
		return colorFondo;
	}

	public void setColorFondo(Color colorFondo) {
		this.colorFondo = colorFondo;
	}

	public JSlider getSliderAlturaInicial() {
		return sliderAlturaInicial;
	}

	public void setSliderAlturaInicial(JSlider sliderAlturaInicial) {
		this.sliderAlturaInicial = sliderAlturaInicial;
	}

	public JTextField getTextColorTrayectoria() {
		return textColorTrayectoria;
	}

	public void setTextColorTrayectoria(JTextField textColorTrayectoria) {
		this.textColorTrayectoria = textColorTrayectoria;
	}

	public JTextField getTextAlturaInicial() {
		return textAlturaInicial;
	}

	public void setTextAlturaInicial(JTextField textAlturaInicial) {
		this.textAlturaInicial = textAlturaInicial;
	}

	public JCheckBox getCheckboxMostrarVector() {
		return checkboxMostrarVector;
	}

	public void setCheckboxMostrarVector(JCheckBox checkboxMostrarVector) {
		this.checkboxMostrarVector = checkboxMostrarVector;
	}
}
