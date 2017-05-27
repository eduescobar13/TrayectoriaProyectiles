/**
 * Clase para la implementación de un panel que contendrá la cuadrícula. Extiende de JPanel.
 * @author: Eduardo Escobar Alberto
 * @version: 1.0 19/04/2017
 * Correo electrónico: eduescal13@gmail.com.
 * Asignatura: Programación de Aplicaciones Interactivas.
 * Centro: Universidad de La Laguna.
 */

package proyectiles.vista;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.ArrayList;

import javax.swing.JPanel;

import proyectiles.modelo.Flecha;
import proyectiles.modelo.Punto;

public class PanelGrafico extends JPanel {
	private static final long serialVersionUID = 1L;
	
	// DECLARACIÓN DE CONSTANTES.
	final static Color COLOR_LINEA_CUADRICULA = new Color(212, 208, 208);
	final static int MOVIMIENTO_ARRIBA = 0;
	final static int MOVIMIENTO_ABAJO = 1;
	final static int MOVIMIENTO_DERECHA = 2;
	final static int MOVIMIENTO_IZQUIERDA = 3;
	final static Color COLOR_EJES_CUADRICULA = Color.BLACK;
	final static Color COLOR_CUADRICULA = new Color(237, 235, 235);
	final static Color COLOR_FLECHA = Color.RED;
	final static int MARGEN_IZQUIERDO = 40;
	final static int MARGEN_INFERIOR = 40;
	final static int LINEA_UNIDAD = 5;
	final static int LINEA_DECENA = 10;
	final static int ESCALA = 10;
	final static int DECENA = 10;
	final static int GRADOS_CENTRO = 45;
	final static int GROSOR_PUNTO = 6;
	final static int GROSOR_PROYECTIL = 8;
	final static int ANCHURA_MAXIMA_INICIAL = 500;
	final static int ALTURA_MAXIMA_INICIAL = 250;
	
	// DECLARACIÓN DE ATRIBUTOS.
	private int anchoPanel;
	private int altoPanel;
	private Flecha flecha;
	private ArrayList<Punto> conjuntoPuntos;
	private int escalaAnchura;
	private int escalaAltura;
	private int alturaMaxima;
	private int anchuraMaxima;
	private Color colorFondo;

	/**
	 * Constructor.
	 * @param colorFondo. Color de fondo del panel.
	 */
	public PanelGrafico(int gradosIniciales, int alturaInicial, Color colorFondo) {
		anchoPanel = 0;
		altoPanel = 0;
		flecha = new Flecha(gradosIniciales, alturaInicial, COLOR_FLECHA);
		conjuntoPuntos = new ArrayList<Punto>();
		escalaAnchura = 0;
		escalaAltura = 0;
		alturaMaxima = ALTURA_MAXIMA_INICIAL;
		anchuraMaxima = ANCHURA_MAXIMA_INICIAL;
		this.colorFondo = colorFondo;
		setBackground(colorFondo);
	}
	
	/**
	 * Método que inicializa los atributos graficos de la clase.
	 * @param anchoPanel. Ancho del panel gráfico.
	 * @param altoPanel. Alto del panel gráfico.
	 */
	public void inicializarAtributosGraficos(int anchoPanel, int altoPanel) {
		setAnchoPanel(anchoPanel);
		setAltoPanel(altoPanel);
	}
	
	/**
	 * Método que dibuja una cuadrícula con los valores númericos en los lados izquierdo e inferior.
	 * @param graphics. Objeto de la clase Graphics.
	 */
	public void dibujarCuadricula(Graphics graphics) {
		// 1º Obtenemos el espacio disponible para la cuadrícula, Luego obtenemos los espacios entre líneas.
		int lineas_horizontales = getAlturaMaxima() / ESCALA;
		int lineas_verticales = getAnchuraMaxima() / ESCALA;
		int anchuraCuadricula = getAnchoPanel() - MARGEN_IZQUIERDO;
		int alturaCuadricula = getAltoPanel() - MARGEN_INFERIOR;
		int espacioAltura = alturaCuadricula / lineas_horizontales;
		int espacioAnchura = anchuraCuadricula / lineas_verticales;
		setEscalaAnchura(espacioAnchura);
		setEscalaAltura(espacioAltura);
		// 2º Dibujamos los ejes de un color más oscuro y un trazo más grueso.
		Graphics2D graphics2D = (Graphics2D) graphics;
		graphics2D.setStroke(new BasicStroke(3f));
		graphics2D.setColor(COLOR_EJES_CUADRICULA);
		graphics2D.drawLine(MARGEN_IZQUIERDO, 0, MARGEN_IZQUIERDO, getAltoPanel() - MARGEN_INFERIOR);
		graphics2D.drawLine(MARGEN_IZQUIERDO, (getAltoPanel() - MARGEN_INFERIOR), getAnchoPanel(), (getAltoPanel() - MARGEN_INFERIOR));
		graphics.drawString("0", MARGEN_IZQUIERDO - (espacioAnchura / 2), getAltoPanel() - (MARGEN_INFERIOR / 2) + 2);	
		graphics2D.setStroke(new BasicStroke(1f));
		// 3º Dibujamos toda la cuadrícula, haciendo también las lineas indicativas de distancia después de los ejes.
		for (int i = 1; i <= lineas_verticales + 1; i++) {
			if (i % DECENA == 0) {
				graphics.setColor(COLOR_EJES_CUADRICULA);
				graphics.drawLine(MARGEN_IZQUIERDO + (espacioAnchura * i), (getAltoPanel() - MARGEN_INFERIOR), MARGEN_IZQUIERDO + (espacioAnchura * i), (getAltoPanel() - MARGEN_INFERIOR) + LINEA_DECENA);
				graphics.drawString("" + (i * 10), MARGEN_IZQUIERDO + (espacioAnchura * i) - (espacioAnchura / 2), getAltoPanel() - (MARGEN_INFERIOR / 2) + 2);	
			}
			else {
				graphics.setColor(COLOR_EJES_CUADRICULA);
				graphics.drawLine(MARGEN_IZQUIERDO + (espacioAnchura * i), (getAltoPanel() - MARGEN_INFERIOR), MARGEN_IZQUIERDO + (espacioAnchura * i), (getAltoPanel() - MARGEN_INFERIOR) + LINEA_UNIDAD);
			}
			graphics.setColor(COLOR_CUADRICULA);
			graphics.drawLine(MARGEN_IZQUIERDO + (espacioAnchura * i), 0, MARGEN_IZQUIERDO + (espacioAnchura * i), getAltoPanel() - MARGEN_INFERIOR - 2);
		}
		for (int i = 1; i <= lineas_horizontales + 1; i++) {
			if (i % DECENA == 0) {
				graphics.setColor(COLOR_EJES_CUADRICULA);
				graphics.drawLine(MARGEN_IZQUIERDO - LINEA_DECENA, (getAltoPanel() - MARGEN_INFERIOR) - (espacioAltura * i), getAnchoPanel(), (getAltoPanel() - MARGEN_INFERIOR) - (espacioAltura * i));
				graphics.drawString("" + (i * 10), (MARGEN_IZQUIERDO / 5), (getAltoPanel() - MARGEN_INFERIOR) - (espacioAltura * i) + (espacioAltura / 4));	
			}
			else {
				graphics.setColor(COLOR_EJES_CUADRICULA);
				graphics.drawLine(MARGEN_IZQUIERDO - LINEA_UNIDAD, (getAltoPanel() - MARGEN_INFERIOR) - (espacioAltura * i), getAnchoPanel(), (getAltoPanel() - MARGEN_INFERIOR) - (espacioAltura * i));
			}
			graphics.setColor(COLOR_CUADRICULA);
			graphics.drawLine(MARGEN_IZQUIERDO + 2, (getAltoPanel() - MARGEN_INFERIOR) - (espacioAltura * i), getAnchoPanel(), (getAltoPanel() - MARGEN_INFERIOR) - (espacioAltura * i));
		}
	}
	
	/**
	 * Método que dibuja la flecha indicadora del ángulo inicial.
	 * @param graphics. Objeto de la clase Graphics.
	 */
	public void dibujarFlecha(Graphics graphics) {
		int puntoInicialX = MARGEN_IZQUIERDO;
		int puntoInicialY = getAltoPanel() - MARGEN_INFERIOR - (getFlecha().getAlturaInicial() * getEscalaAltura() / 10);
		int puntoFinalXMaximo = 0, puntoFinalXMinimo = 0, puntoFinalYMaximo = 0, puntoFinalYMinimo = 0, escalaGrado = 0;
		int diferenciaGrados = 0, diferenciaPuntoFinal = 0;
		int puntoFinalX = puntoInicialX + ((getAnchoPanel() - MARGEN_IZQUIERDO) / 10);
		int puntoFinalY = puntoInicialY - ((getAnchoPanel() - MARGEN_IZQUIERDO) / 10);
		if (getFlecha().getGrados() > GRADOS_CENTRO) {
			puntoFinalXMinimo = puntoInicialX;
			puntoFinalXMaximo = puntoFinalX;
			escalaGrado = (puntoFinalXMaximo - puntoFinalXMinimo) / GRADOS_CENTRO;
			diferenciaGrados = getFlecha().getGrados() - GRADOS_CENTRO;
			diferenciaPuntoFinal = escalaGrado * diferenciaGrados;
			puntoFinalX = puntoFinalX - diferenciaPuntoFinal;
		}
		else if (getFlecha().getGrados() < GRADOS_CENTRO) {
			puntoFinalYMinimo = puntoFinalY;
			puntoFinalYMaximo = (getAltoPanel() - MARGEN_INFERIOR);
			escalaGrado = (puntoFinalYMaximo - puntoFinalYMinimo) / GRADOS_CENTRO;
			diferenciaGrados = getFlecha().getGrados() - GRADOS_CENTRO;
			diferenciaPuntoFinal = escalaGrado * diferenciaGrados;
			puntoFinalY = puntoFinalY - diferenciaPuntoFinal;
		}
		Graphics2D graphics2D = (Graphics2D) graphics;
		graphics2D.setStroke(new BasicStroke(2f));
		graphics2D.setColor(getFlecha().getColor());
		//graphics2D.drawLine(puntoFinalX, puntoFinalY, puntoFinalX - getEscalaAnchura(), puntoFinalY + 3);
		graphics2D.drawLine(puntoInicialX, puntoInicialY, puntoFinalX, puntoFinalY);
	}
	
	public void anadirPunto(Punto puntoAnadir) {
		if (puntoAnadir.getCoordenadaY() < 0) {
			getConjuntoPuntos().add(new Punto(puntoAnadir.getCoordenadaX(), 0, puntoAnadir.getMostrarCamino(), puntoAnadir.getMostrarVector(), puntoAnadir.getColor()));
		}
		else {
			getConjuntoPuntos().add(puntoAnadir);
		}
		repaint();
	}
	
	public void dibujarTrayectoria(Graphics graphics) {
		if (!getConjuntoPuntos().isEmpty()) {
			int xPunto = 0, yPunto = 0;
			double escalaXMetro = getEscalaAnchura() * 0.1;
			double escalaYMetro = getEscalaAltura() * 0.1;
			for (int i = 0; i < getConjuntoPuntos().size(); i++) {
				xPunto = (int)(getConjuntoPuntos().get(i).getCoordenadaX() * escalaXMetro) + MARGEN_IZQUIERDO;
				yPunto = (getAltoPanel() - MARGEN_INFERIOR) - (int)(getConjuntoPuntos().get(i).getCoordenadaY() * escalaYMetro);
				if (i == (getConjuntoPuntos().size() - 1)) {
					graphics.setColor(Color.BLACK);
					graphics.fillOval(xPunto - 3, yPunto - 3, GROSOR_PROYECTIL, GROSOR_PROYECTIL);
					if (getConjuntoPuntos().get(i).getMostrarVector()) {
						Graphics2D graphics2D = (Graphics2D) graphics;
						graphics2D.setStroke(new BasicStroke(1f));
						dibujarVectorPosicion(graphics, xPunto, yPunto);
					}
				}
				else if ((i != (getConjuntoPuntos().size() - 1)) && (getConjuntoPuntos().get(i).getMostrarCamino())) {
					graphics.setColor(getConjuntoPuntos().get(i).getColor());
					graphics.fillOval(xPunto - 3, yPunto - 3, GROSOR_PUNTO, GROSOR_PUNTO);
				}
			}
		}
	}
	
	public void dibujarVectorPosicion(Graphics graphics, int xPunto, int yPunto) {
		graphics.drawLine(MARGEN_IZQUIERDO, (getAltoPanel() - MARGEN_INFERIOR), xPunto, yPunto);
	}
	
	/**
	 * Sobreescritura del método paintComponent.
	 * @param graphics. Objeto del clase graphics.
	 */
	@Override
	public void paintComponent(Graphics graphics) {
		super.paintComponent(graphics); // Comportamiento normal. Uso del paintComponent del padre.
		inicializarAtributosGraficos(this.getWidth(), this.getHeight());
		dibujarCuadricula(graphics);
		dibujarFlecha(graphics);
		dibujarTrayectoria(graphics);
	}

	public Color getColorFondo() {
		return colorFondo;
	}

	public void setColorFondo(Color colorFondo) {
		this.colorFondo = colorFondo;
	}

	public ArrayList<Punto> getConjuntoPuntos() {
		return conjuntoPuntos;
	}

	public void setConjuntoPuntos(ArrayList<Punto> conjuntoPuntos) {
		this.conjuntoPuntos = conjuntoPuntos;
	}

	public int getEscalaAnchura() {
		return escalaAnchura;
	}

	public void setEscalaAnchura(int escalaAnchura) {
		this.escalaAnchura = escalaAnchura;
	}

	public int getEscalaAltura() {
		return escalaAltura;
	}

	public void setEscalaAltura(int escalaAltura) {
		this.escalaAltura = escalaAltura;
	}

	public int getAlturaMaxima() {
		return alturaMaxima;
	}

	public void setAlturaMaxima(int alturaMaxima) {
		this.alturaMaxima = alturaMaxima;
	}

	public int getAnchuraMaxima() {
		return anchuraMaxima;
	}

	public void setAnchuraMaxima(int anchuraMaxima) {
		this.anchuraMaxima = anchuraMaxima;
	}

	public int getAnchoPanel() {
		return anchoPanel;
	}

	public void setAnchoPanel(int anchoPanel) {
		this.anchoPanel = anchoPanel;
	}

	public int getAltoPanel() {
		return altoPanel;
	}

	public void setAltoPanel(int altoPanel) {
		this.altoPanel = altoPanel;
	}

	public Flecha getFlecha() {
		return flecha;
	}

	public void setFlecha(Flecha flecha) {
		this.flecha = flecha;
	}
}
