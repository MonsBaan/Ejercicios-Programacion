import java.awt.Graphics;
import java.awt.Image;
import java.util.Random;

public class Jinete extends Thread {
	
	private Image imagen;
	private int alto, ancho, posX, posY;
	private ZonaJuego zonaJuego;
	
	public Jinete(ZonaJuego zonaJuego) {
		Random r = new Random();
		this.zonaJuego = zonaJuego;
		alto = 90;
		ancho = 60;
		posX = r.nextInt(670);
		posY = -alto;
	}
	
	public void run() {
		super.run();
		Random r = new Random();
		while (true) {
			posY+=5;
			posX+=r.nextInt(10)-5;
			try {
				Thread.sleep(40);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	public void dibujar(Graphics g) {
		g.drawImage(imagen, posX, posY, ancho, alto, null);
	}
}
