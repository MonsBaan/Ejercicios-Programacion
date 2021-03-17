import java.awt.Canvas;
import java.awt.Graphics;
import java.awt.Image;
import java.net.URL;
import java.util.ArrayList;

import javax.swing.ImageIcon;

public class ZonaJuego extends Canvas {
	//DATOS
	private Image fondo;
	private EventosJuego eventosJuego;
	private MainJuego mainJuego;
	private Image buffer;
	private Graphics pantallaVirtual;
	private int vidas;
	private int nivel;
	private SoundEffect se;
	private ArrayList<Jugador> arrayJugador;
	private ArrayList<Enemigo> arrayEnemigo1;
	private ArrayList<Enemigo> arrayEnemigo2;
	private ArrayList<Enemigo> arrayEnemigo3;
	private ArrayList<Disparo> arrayDisparo;
	private URL pop1, pop2, pop3;
	
	//CONSTRUCTORES
	public ZonaJuego(MainJuego mainJuego){
		this.mainJuego = mainJuego;
		//CARGAR FONDO
		fondo = new ImageIcon(getClass().getResource("Fondo.jpg")).getImage();


		//CARGAR JUGADOR Y DISPARO
		vidas = 3;
		nivel = 1;
		arrayJugador = new ArrayList<Jugador>();
		arrayDisparo = new ArrayList<Disparo>();
		
		//CARGAR ENEMIGOS
		arrayEnemigo1 = new ArrayList<Enemigo>();
		arrayEnemigo2 = new ArrayList<Enemigo>();
		arrayEnemigo3 = new ArrayList<Enemigo>();

		se = new SoundEffect(this);
		pop1 = getClass().getResource("Sonidos/Pop1.wav");
		pop2 = getClass().getResource("Sonidos/Pop2.wav");
		pop3 = getClass().getResource("Sonidos/Pop3.wav");

		//CARGAR EVENTOS
		eventosJuego = new EventosJuego(this);
	}

	//PAINT Y DOBLE BUFFER
	public void paint(Graphics g) {
		super.paint(g);
		g.drawImage(fondo, 0, 0, this.getWidth(), this.getHeight(), null);
		if (arrayJugador.size()!=0) {
			for (Jugador jugador : arrayJugador) {
				if (eventosJuego.getInvulnerable()!=1) {
					jugador.dibujar(g);
				}
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
	public void update(Graphics g) {		//DOBLE BUFFER
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

	public int getNivel() {
		return nivel;
	}

	public void setNivel(int nivel) {
		this.nivel = nivel;
	}

	public SoundEffect getSe() {
		return se;
	}

	public void setSe(SoundEffect se) {
		this.se = se;
	}

	public URL getPop1() {
		return pop1;
	}

	public void setPop1(URL pop1) {
		this.pop1 = pop1;
	}

	public URL getPop2() {
		return pop2;
	}

	public void setPop2(URL pop2) {
		this.pop2 = pop2;
	}

	public URL getPop3() {
		return pop3;
	}

	public void setPop3(URL pop3) {
		this.pop3 = pop3;
	}
	public MainJuego getMainJuego() {
		return mainJuego;
	}

	public void setMainJuego(MainJuego mainJuego) {
		this.mainJuego = mainJuego;
	}

}
