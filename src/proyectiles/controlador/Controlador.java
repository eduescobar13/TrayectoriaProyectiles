/**
 * Clase para la implementación del controlador del programa.
 * @author: Eduardo Escobar Alberto
 * @version: 1.0 19/04/2017
 * Correo electrónico: eduescal13@gmail.com.
 * Asignatura: Programación de Aplicaciones Interactivas.
 * Centro: Universidad de La Laguna.
*/

package proyectiles.controlador;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import proyectiles.modelo.Punto;
import proyectiles.vista.Vista;

public class Controlador {

	// DECLARACIÓN DE CONSTANTES.
	final static Color COLOR_INICIAL_CAMINO = new Color(245, 101, 101);
	final static int BOTON_REANUDAR = 0;
	final static int BOTON_PAUSAR = 1;
	final static int TIEMPO_POR_DEFECTO = 1;
	final static int MARGEN_CRECIMIENTO = 80;
	final static double ACELERACION_GRAVEDAD = 9.8;
	final static double FACTOR_CONVERSION_RADIANES = 57.296;
	final static int ANCHURA_MAXIMA_INICIAL = 500;
	final static int ALTURA_MAXIMA_INICIAL = 250;
	
	// DECLARACIÓN DE ATRIBUTOS.
	private Vista vista;
	private ArrayList<HiloTrayectoria> movimientosProyectiles;
	private int botonPausarReanudar;
	private double alturaMaxima;
	private boolean mostrarCamino;
	private boolean mostrarVector;
	
	/**
	 * Constructor.
	 */
	public Controlador() {
		vista = new Vista();
		movimientosProyectiles = new ArrayList<HiloTrayectoria>();
		botonPausarReanudar = BOTON_PAUSAR; // Inicialmente se muestra el boton de pausar.
		alturaMaxima = 0;
		mostrarCamino = true;
		mostrarVector = false;
		gestionarActionListeiner();
	}
	
	/**
	 * Método para la encapsulación del método mostrarVista de la clase Vista.
	 * @param mostrar. Boolena para indicar si se muestra la vista.
	 */
	public void mostrarVista(boolean mostrar) {
		getVista().mostrarVista(mostrar);
	}
	
	/**
	 * Método para añadir y gestionar los accionListeiner de los botones.
	 */
	public void gestionarActionListeiner() {
		vista.getPanelBotones().getBotonera().getBotonLanzar().addActionListener(new Oyente());
		vista.getPanelBotones().getBotonera().getBotonPausarReanudar().addActionListener(new Oyente());
		vista.getPanelBotones().getBotonera().getBotonBorrar().addActionListener(new Oyente());
		vista.getPanelBotones().getBotonera().getSliderVelocidadInicial().addChangeListener(new OyenteSlider());
		vista.getPanelBotones().getBotonera().getSliderAnguloInicial().addChangeListener(new OyenteSlider());
		vista.getPanelBotones().getBotonera().getSliderAlturaInicial().addChangeListener(new OyenteSlider());
	}
	
	/**
	 * Método que corrige la precisión en los decimales redondeando el tiempo a una cifra.
	 * @param tiempo. Tiempo a corregir.
	 * @return Tiempo corregido.
	 */
	public double corregirPrecisionDecimal(double tiempo) {
		return Math.rint(tiempo * 10) / 10;
	}
	
	public void actualizarPanelInformacion(double tiempoTranscurrido, double distanciaHorizontal, double alturaActual) {
		if (alturaActual > getAlturaMaxima()) {
			setAlturaMaxima(alturaActual);
		}	
		if (alturaActual < 0) {
			alturaActual = 0;
		}
		getVista().getPanelBotones().getPanelInformacion().getTextTiempoTranscurrido().setText(tiempoTranscurrido + " s");
		getVista().getPanelBotones().getPanelInformacion().getTextDistanciaHorizontal().setText(Math.rint(distanciaHorizontal * 1000) / 1000 + " m");
		getVista().getPanelBotones().getPanelInformacion().getTextAlturaActual().setText(Math.rint(alturaActual * 1000) / 1000 + " m");
		getVista().getPanelBotones().getPanelInformacion().getTextAlturaMaxima().setText(Math.rint(getAlturaMaxima() * 1000) / 1000 + " m");
	}
	
	/**
	 * Función getter del atributo vista.
	 * @return Valor del atributo vista.
	 */
	public Vista getVista() {
		return vista;
	}

	/**
	 * Método setter del atributo vista.
	 * @param vista. Nuevo valor del atributo vista.
	 */
	public void setVista(Vista vista) {
		this.vista = vista;
	}

	public ArrayList<HiloTrayectoria> getMovimientosProyectiles() {
		return movimientosProyectiles;
	}

	public void setMovimientosProyectiles(ArrayList<HiloTrayectoria> movimientosProyectiles) {
		this.movimientosProyectiles = movimientosProyectiles;
	}

	public int getBotonPausarReanudar() {
		return botonPausarReanudar;
	}

	public void setBotonPausarReanudar(int botonPausarReanudar) {
		this.botonPausarReanudar = botonPausarReanudar;
	}

	public double getAlturaMaxima() {
		return alturaMaxima;
	}

	public void setAlturaMaxima(double alturaMaxima) {
		this.alturaMaxima = alturaMaxima;
	}

	public boolean getMostrarCamino() {
		return mostrarCamino;
	}

	public void setMostrarCamino(boolean mostrarCamino) {
		this.mostrarCamino = mostrarCamino;
	}

	public boolean getMostrarVector() {
		return mostrarVector;
	}

	public void setMostrarVector(boolean mostrarVector) {
		this.mostrarVector = mostrarVector;
	}

	/**
	 * Clase interna que implementa actionListeiner y gestiona la acción a realizar cuando se pulsa cada botón.
	 * @author: Eduardo Escobar Alberto
	 * @version: 1.0 19/04/2017
	 * Correo electrónico: eduescal13@gmail.com.
	 * Asignatura: Programación de Aplicaciones Interactivas.
	 * Centro: Universidad de La Laguna.
	 */
	class Oyente implements ActionListener {
		public void actionPerformed(ActionEvent event) {
			if (event.getSource() == getVista().getPanelBotones().getBotonera().getBotonLanzar()) {
				getMovimientosProyectiles().add(new HiloTrayectoria());
				getMovimientosProyectiles().get(getMovimientosProyectiles().size() - 1).start();
			}
			if (event.getSource() == getVista().getPanelBotones().getBotonera().getBotonPausarReanudar()) {
				if (getBotonPausarReanudar() == BOTON_PAUSAR) {
					setBotonPausarReanudar(BOTON_REANUDAR);
					getVista().getPanelBotones().getBotonera().cambiarPausarReanudar(BOTON_PAUSAR);
				}
				else if (getBotonPausarReanudar() == BOTON_REANUDAR) {
					setBotonPausarReanudar(BOTON_PAUSAR);
					getVista().getPanelBotones().getBotonera().cambiarPausarReanudar(BOTON_REANUDAR);
					for (int i = 0; i < getMovimientosProyectiles().size(); i++) {
						getMovimientosProyectiles().get(i).setTiempo(100);
					}
				}
			}
			if (event.getSource() == getVista().getPanelBotones().getBotonera().getBotonBorrar()) {
				for (int i = 0; i < getMovimientosProyectiles().size(); i++) {
					getMovimientosProyectiles().get(i).pararHilo();
				}
				setMovimientosProyectiles(new ArrayList<HiloTrayectoria>());
				getVista().getPanelGrafico().setConjuntoPuntos(new ArrayList<Punto>());
				setAlturaMaxima(0);
				actualizarPanelInformacion(0, 0, 0);
				getVista().getPanelGrafico().setAnchuraMaxima(ALTURA_MAXIMA_INICIAL);
				getVista().getPanelGrafico().setAnchuraMaxima(ANCHURA_MAXIMA_INICIAL);
				getVista().getPanelGrafico().repaint();
			}
		}
	}
	
	/**
	 * Clase interna que implementa ChangeListeiner y gestiona la acción a realizar cuando cambian los valores de los slider.
	 * @author: Eduardo Escobar Alberto
	 * @version: 1.0 03/05/2017
	 * Correo electrónico: eduescal13@gmail.com.
	 * Asignatura: Programación de Aplicaciones Interactivas.
	 * Centro: Universidad de La Laguna.
	 */
	class OyenteSlider implements ChangeListener {
		@Override
		public void stateChanged(ChangeEvent event) {
			if (event.getSource() == getVista().getPanelBotones().getBotonera().getSliderVelocidadInicial()) {
				int valor = getVista().getPanelBotones().getBotonera().getSliderVelocidadInicial().getValue();
				getVista().getPanelBotones().getBotonera().getTextVelocidadInicial().setText(valor + " m/s");
			}
			if (event.getSource() == getVista().getPanelBotones().getBotonera().getSliderAnguloInicial()) {
				int valor = getVista().getPanelBotones().getBotonera().getSliderAnguloInicial().getValue();
				getVista().getPanelBotones().getBotonera().getTextAnguloInicial().setText(valor + " grados");
				getVista().getPanelGrafico().getFlecha().setGrados(valor);
				getVista().getPanelGrafico().repaint();
			}
			if (event.getSource() == getVista().getPanelBotones().getBotonera().getSliderAlturaInicial()) {
				int valor = getVista().getPanelBotones().getBotonera().getSliderAlturaInicial().getValue();
				getVista().getPanelBotones().getBotonera().getTextAlturaInicial().setText(valor + " metros");
				getVista().getPanelGrafico().getFlecha().setAlturaInicial(valor);
				getVista().getPanelGrafico().repaint();
			}
		}
	}
	
	/**
	 * Clase interna que implementa para la creación de hilos de ejecución. Extiende de Thread.
	 * @author: Eduardo Escobar Alberto
	 * @version: 1.0 19/04/2017
	 * Correo electrónico: eduescal13@gmail.com.
	 * Asignatura: Programación de Aplicaciones Interactivas.
	 * Centro: Universidad de La Laguna.
	 */
	class HiloTrayectoria extends Thread {
		
		// DECLARACIÓN DE ATRIBUTOS.
		private int tiempo = 100;
		private boolean detenerHilo = false; // Atributo booleano usada como flag para la detención del hilo.
		
		/**
		 * Sobrecarga del método run.
		 */
		@Override
		public void run() {
			Random random = new Random(); // Generamos un color RGB aleatorio, cambiando posteriormente los valores necesarios.
			int RAleatorio = (int)(random.nextDouble() * 256);
			int GAleatorio = (int)(random.nextDouble() * 256);
			int BAleatorio = (int)(random.nextDouble() * 256);
			Color colorAleatorio = new Color(RAleatorio, GAleatorio, BAleatorio);
			getVista().getPanelBotones().getBotonera().getTextColorTrayectoria().setBackground(colorAleatorio);
			double posicionXInicial = 0, posicionX = 0, posicionY = 0;
			double posicionYInicial = getVista().getPanelBotones().getBotonera().getSliderAlturaInicial().getValue();
			int anguloInicialGrados = getVista().getPanelBotones().getBotonera().getSliderAnguloInicial().getValue();
			double anguloInicialRadianes = anguloInicialGrados / FACTOR_CONVERSION_RADIANES;
			int velocidadInicial = getVista().getPanelBotones().getBotonera().getSliderVelocidadInicial().getValue();
			double velocidadXInicial = velocidadInicial * Math.cos(anguloInicialRadianes);
			double velocidadYInicial = velocidadInicial * Math.sin(anguloInicialRadianes);
			double aceleracionY = -1.0 * ACELERACION_GRAVEDAD;
			//------------- COMIENZO DE LA TRAYECTORIA -----------------
			double tiempo = 0.1;
			posicionX = posicionXInicial + (velocidadXInicial * tiempo);
			posicionY = posicionYInicial + (velocidadYInicial * tiempo) + (0.5 * aceleracionY * Math.pow(tiempo, 2));
			while ((posicionY > 0) && (getDetenerHilo() == false)) {
				posicionX = posicionXInicial + (velocidadXInicial * tiempo);
				posicionY = posicionYInicial + (velocidadYInicial * tiempo) + (0.5 * aceleracionY * Math.pow(tiempo, 2));
				if ((posicionX - MARGEN_CRECIMIENTO) > getVista().getPanelGrafico().getAnchuraMaxima()) {
					getVista().getPanelGrafico().setAnchuraMaxima((int)(posicionX + MARGEN_CRECIMIENTO));
					getVista().getPanelGrafico().repaint();
				}
				if ((posicionY - MARGEN_CRECIMIENTO) > getVista().getPanelGrafico().getAlturaMaxima()) {
					getVista().getPanelGrafico().setAlturaMaxima((int)(posicionY + MARGEN_CRECIMIENTO));
					getVista().getPanelGrafico().repaint();
				}
				if (getVista().getPanelBotones().getBotonera().getCheckboxMostrarCamino().isSelected()) {
					setMostrarCamino(true);
				}
				else {
					setMostrarCamino(false);
				}
				if (getVista().getPanelBotones().getBotonera().getCheckboxMostrarVector().isSelected()) {
					setMostrarVector(true);
				}
				else {
					setMostrarVector(false);
				}
				actualizarPanelInformacion(tiempo, posicionX, posicionY);
				getVista().getPanelGrafico().anadirPunto(new Punto(posicionX, posicionY, getMostrarCamino(), getMostrarVector(), colorAleatorio));
				esperarXMilisegundos(getTiempo());
				tiempo += 0.1;
				tiempo = corregirPrecisionDecimal(tiempo);
			};
		}
		
		/**
		 * Método para detener el hilo, cambiando el flag a true.
		 */
		public void pararHilo() {
			setDetenerHilo(true);
		}

		/**
		 * Método privado para realizar paradas.
		 * @param segundos. Número de segundos de la parada.
		 */
		private void esperarXMilisegundos(int milisegundos) {
			try {
				Thread.sleep(milisegundos);
			} catch (InterruptedException ex) {
				Thread.currentThread().interrupt();
			}
		}

		/**
		 * Función getter del atributo detenerHilo.
		 * @return Valor del atributo detenerHilo.
		 */
		public boolean getDetenerHilo() {
			return detenerHilo;
		}

		/**
		 * Método setter del atributo detenerHilo.
		 * @param detenerHilo. Nuevo valor del atributo detenerHilo.
		 */
		public void setDetenerHilo(boolean detenerHilo) {
			this.detenerHilo = detenerHilo;
		}

		public int getTiempo() {
			return tiempo;
		}

		public void setTiempo(int tiempo) {
			this.tiempo = tiempo;
		}
	}
}
