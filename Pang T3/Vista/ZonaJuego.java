import java.awt.Canvas;
import java.awt.Graphics;
import java.awt.Image;
import java.util.ArrayList;

import javax.swing.ImageIcon;

public class ZonaJuego extends Canvas {
	//DATOS
	private Image fondo;
	private Jugador jugador;
	private Disparo disparo;
	private Enemigo enemigo;
	private EventosJuego eventosJuego;
	private Image buffer;
	private Graphics pantallaVirtual;
	private ArrayList<Enemigo> arrayEnemigo1;
	private ArrayList<Enemigo> arrayEnemigo2;
	private ArrayList<Enemigo> arrayEnemigo3;
	
	//CONSTRUCTORES
	public ZonaJuego(){
		//CARGAR FONDO
		//fondo = new ImageIcon(getClass().getResource("montaña.jpg")).getImage();

		//CARGAR JUGADOR Y DISPARO
		jugador = new Jugador(this);
		disparo = new Disparo(this);
		disparo.start();
		
		//CARGAR ENEMIGOS
		arrayEnemigo1 = new ArrayList<Enemigo>();
		arrayEnemigo2 = new ArrayList<Enemigo>();
		arrayEnemigo3 = new ArrayList<Enemigo>();


		//CARGAR EVENTOS
		eventosJuego = new EventosJuego(this);
	}
	
	//PAINT Y DOBLE BUFFER
	public void paint(Graphics g) {
		super.paint(g);
		//g.drawImage(fondo, 0, 0, this.getWidth(), this.getHeight(), null);
		jugador.dibujar(g);
		disparo.dibujar(g);


		if (arrayEnemigo1.size()!=0) {
			for (Enemigo enemigo : arrayEnemigo1) {
				enemigo.dibujar(g);
			}
		}
		if (arrayEnemigo2.size()!=0) {
			for (Enemigo enemigo : arrayEnemigo2) {
				enemigo.dibujar(g);
			}
		}
		if (arrayEnemigo3.size()!=0) {
			for (Enemigo enemigo : arrayEnemigo3) {
				enemigo.dibujar(g);
			}
		}


	}
	public void update(Graphics g) {
		//DOBLE BUFFER
		buffer = createImage(this.getWidth(), this.getHeight());
		pantallaVirtual = buffer.getGraphics();
		paint(pantallaVirtual);
		g.drawImage(buffer, 0, 0, this.getWidth(), this.getHeight(), null);
	}

	
	
	//GETTERS Y SETTERS
	public Image getFondo() {
		return fondo;
	}

	public void setFondo(Image fondo) {
		this.fondo = fondo;
	}

	public Jugador getJugador() {
		return jugador;
	}

	public void setJugador(Jugador jugador) {
		this.jugador = jugador;
	}

	public EventosJuego getEventosJuego() {
		return eventosJuego;
	}

	public void setEventosJuego(EventosJuego eventosJuego) {
		this.eventosJuego = eventosJuego;
	}

	public Image getBuffer() {
		return buffer;
	}

	public void setBuffer(Image buffer) {
		this.buffer = buffer;
	}

	public Graphics getPantallaVirtual() {
		return pantallaVirtual;
	}

	public void setPantallaVirtual(Graphics pantallaVirtual) {
		this.pantallaVirtual = pantallaVirtual;
	}

	public Disparo getDisparo() {
		return disparo;
	}

	public void setDisparo(Disparo disparo) {
		this.disparo = disparo;
	}

	public Enemigo getEnemigo() {
		return enemigo;
	}

	public void setEnemigo(Enemigo enemigo) {
		this.enemigo = enemigo;
	}

	public ArrayList<Enemigo> getArrayEnemigo1() {
		return arrayEnemigo1;
	}

	public void setArrayEnemigo1(ArrayList<Enemigo> arrayEnemigo1) {
		this.arrayEnemigo1 = arrayEnemigo1;
	}

	public ArrayList<Enemigo> getArrayEnemigo2() {
		return arrayEnemigo2;
	}

	public void setArrayEnemigo2(ArrayList<Enemigo> arrayEnemigo2) {
		this.arrayEnemigo2 = arrayEnemigo2;
	}

	public ArrayList<Enemigo> getArrayEnemigo3() {
		return arrayEnemigo3;
	}

	public void setArrayEnemigo3(ArrayList<Enemigo> arrayEnemigo3) {
		this.arrayEnemigo3 = arrayEnemigo3;
	}
}
