import java.awt.Canvas;
import java.awt.Graphics;
import java.awt.Image;
import java.util.ArrayList;

public class ZonaJuego extends Canvas {
	//DATOS
	private Image fondo;
	private EventosJuego eventosJuego;
	private Image buffer;
	private Graphics pantallaVirtual;
	private int vidas;
	private ArrayList<Jugador> arrayJugador;
	private ArrayList<Enemigo> arrayEnemigo1;
	private ArrayList<Enemigo> arrayEnemigo2;
	private ArrayList<Enemigo> arrayEnemigo3;
	private ArrayList<Disparo> arrayDisparo;
	
	//CONSTRUCTORES
	public ZonaJuego(){
		//CARGAR FONDO
		//fondo = new ImageIcon(getClass().getResource("montaña.jpg")).getImage();

		//CARGAR JUGADOR Y DISPARO
		vidas = 3;
		arrayJugador = new ArrayList<Jugador>();
		arrayDisparo = new ArrayList<Disparo>();
		
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
		if (arrayJugador.size()!=0) {
			for (Jugador jugador : arrayJugador) {
				jugador.dibujar(g);
			}
		}
		if (arrayDisparo.size()!=0) {
			for (Disparo disparo : arrayDisparo) {
				disparo.dibujar(g);
			}
		}
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

	public ArrayList<Disparo> getArrayDisparo() {
		return arrayDisparo;
	}

	public void setArrayDisparo(ArrayList<Disparo> arrayDisparo) {
		this.arrayDisparo = arrayDisparo;
	}
	
	public ArrayList<Jugador> getArrayJugador() {
		return arrayJugador;
	}

	public void setArrayJugador(ArrayList<Jugador> arrayJugador) {
		this.arrayJugador = arrayJugador;
	}

	public int getVidas() {
		return vidas;
	}

	public void setVidas(int vidas) {
		this.vidas = vidas;
	}
}
