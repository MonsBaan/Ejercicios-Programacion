import java.awt.Canvas;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;

public class ZonaJuego extends Canvas {
	//DATOS
	private Image fondo;
	private Jugador jugador;
	private Disparo disparo;
	private EventosJuego eventosJuego;
	private Image buffer;
	private Graphics pantallaVirtual;
	
	//CONSTRUCTORES
	public ZonaJuego(){
		//CARGAR FONDO
		//fondo = new ImageIcon(getClass().getResource("montaña.jpg")).getImage();

		//CARGAR JUGADOR Y DISPARO
		jugador = new Jugador(this);
		disparo = new Disparo(this);
		
		//CARGAR EVENTOS
		eventosJuego = new EventosJuego(this);

		
	}
	
	//PAINT Y DOBLE BUFFER
	public void paint(Graphics g) {
		// TODO Auto-generated method stub
		super.paint(g);
		//g.drawImage(fondo, 0, 0, this.getWidth(), this.getHeight(), null);
		jugador.dibujar(g);
		disparo.dibujar(g);
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
}
