import java.awt.Canvas;
import java.awt.Graphics;
import java.awt.Image;
import java.util.ArrayList;

import javax.swing.ImageIcon;

public class ZonaJuego extends Canvas {
	//DATOS
	private Image fondo;
	private Caballo caballo;
	private ArrayList<Jinete> arrayJinetes;
	private EventosZonaJuego eventosZonaJuego;
	private Image buffer;
	private Graphics pantVirtual;
	//CONSTRUCTORES, GETTERS, SETTERS
	public ZonaJuego() {
		//CARGAR FONDO
		fondo = new ImageIcon(getClass().getResource("montaña2.jpg")).getImage();

		//CARGAR CABALLO
		caballo = new Caballo(this);
		caballo.start();
		
		//DIMENSIONAR JINETES
		arrayJinetes = new ArrayList<Jinete>();
		
		
		eventosZonaJuego = new EventosZonaJuego(this);

	}
	@Override
	public void paint(Graphics g) {
		// TODO Auto-generated method stub
		super.paint(g);
		//DIBUJAR TODOS LOS ELEMENTOS DE ESTE CANVAS
		//FONDO
		g.drawImage(fondo, 0, 0, this.getWidth(), this.getHeight(), null);
		//CABALLO
		caballo.dibujar(g);
		//JINETES
		for (Jinete jinete : arrayJinetes) {
			jinete.dibujar(g);
		}
	}
	public void update (Graphics g) {
		//DOBLE BUFFER
		buffer = createImage(this.getWidth(), this.getHeight());
		pantVirtual = buffer.getGraphics();
		paint(pantVirtual);
		g.drawImage(buffer, 0, 0, this.getWidth(), this.getHeight(), null);
	}
	public Image getFondo() {
		return fondo;
	}
	public void setFondo(Image fondo) {
		this.fondo = fondo;
	}
	public Caballo getCaballo() {
		return caballo;
	}
	public void setCaballo(Caballo caballo) {
		this.caballo = caballo;
	}
	public EventosZonaJuego getEventosZonaJuego() {
		return eventosZonaJuego;
	}
	public void setEventosZonaJuego(EventosZonaJuego eventosZonaJuego) {
		this.eventosZonaJuego = eventosZonaJuego;
	}
}
