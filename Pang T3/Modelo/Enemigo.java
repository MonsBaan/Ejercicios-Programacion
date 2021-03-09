import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;

public class Enemigo extends Thread{

	private ZonaJuego zonaJuego;
	private Image imgEnemigo;
	private int posX, alto, ancho, velocidad, dirH, dirY;
	private double rebote, posY;
	private boolean intersectado;
	
	public Enemigo(ZonaJuego zonaJuego) {
		this.zonaJuego = zonaJuego;
		//CARGAR IMAGEN
		imgEnemigo = new ImageIcon(getClass().getResource("Enemigos/Bola1.png")).getImage();
		//CARGAR DATOS
		posX = 350;
		posY = 50;
		alto = 100;
		ancho = 100;
		velocidad = 2;
		intersectado = false;
		dirH = 1;
		rebote = 10;
	}
	
	public void run() {
		super.run();
		while(true) {
			//COLISION LATERAL
			posX = posX + velocidad * dirH;
			if (posX+ancho >= zonaJuego.getWidth()) {
				dirH = -1;
			}else if (posX <= 0) {
				dirH = 1;
			}
				
			//SISTEMA DE REBOTE
			posY =  posY - velocidad - rebote/10;	
				
			if (rebote <= 0) {
				if (posY+alto >= zonaJuego.getHeight()) {
					rebote = 55;
				}

			}
				rebote--;

			zonaJuego.repaint();
			
			try {
				Thread.sleep(10);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	public void dibujar(Graphics g) {
		g.drawImage(imgEnemigo, posX, (int) posY, ancho, alto, null);

	}

}
