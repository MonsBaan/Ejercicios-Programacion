import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;

/*
 * SUBE DESDE LA ALTURA DEL JUGADOR HASTA EL MAXIMO, LUEGO DESAPARECE
 */
public class Disparo extends Thread {
	private ZonaJuego zonaJuego;
	private Image imgDisparo;
	private int posX, posY, alto, ancho, velocidad;
	private boolean intersectado, disparo;

	public Disparo(ZonaJuego zonaJuego) {
		this.zonaJuego = zonaJuego;
		//CARGAR IMAGEN
		imgDisparo = new ImageIcon(getClass().getResource("Disparo/Disparo.png")).getImage();
		posX = 0;
		posY = zonaJuego.getJugador().getPosY()+100;
		alto = 770;
		ancho = 10;
		velocidad = 5;
		intersectado = false;
		disparo = false;
	}
	public void dibujar(Graphics g) {
		g.drawImage(imgDisparo, posX, posY, ancho, alto, null);

	}
	
	
	@Override
	public void run() {
		super.run();
		while (true) { 	//SI SE DISPARA, LA BALA SE MUEVE HASTA ARRIBA

			if (disparo) {
				if (posY <= 0 || intersectado == true) {
					posY = zonaJuego.getHeight();
					disparo = false;

				}else {
					posY -= velocidad;

				}
			zonaJuego.repaint();	
			}
			
			try {
				Thread.sleep(10);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	
	
	

	//GETTERS Y SETTERS
	public ZonaJuego getZonaJuego() {
		return zonaJuego;
	}
	public void setZonaJuego(ZonaJuego zonaJuego) {
		this.zonaJuego = zonaJuego;
	}
	public Image getImgDisparo() {
		return imgDisparo;
	}
	public void setImgDisparo(Image imgDisparo) {
		this.imgDisparo = imgDisparo;
	}
	public int getPosX() {
		return posX;
	}
	public void setPosX(int posX) {
		this.posX = posX;
	}
	public int getPosY() {
		return posY;
	}
	public void setPosY(int posY) {
		this.posY = posY;
	}
	public int getAlto() {
		return alto;
	}
	public void setAlto(int alto) {
		this.alto = alto;
	}
	public int getAncho() {
		return ancho;
	}
	public void setAncho(int ancho) {
		this.ancho = ancho;
	}
	public int getVelocidad() {
		return velocidad;
	}
	public void setVelocidad(int velocidad) {
		this.velocidad = velocidad;
	}
	public boolean isIntersectado() {
		return intersectado;
	}
	public void setIntersectado(boolean intersectado) {
		this.intersectado = intersectado;
	}
	public boolean isDisparo() {
		return disparo;
	}
	public void setDisparo(boolean disparo) {
		this.disparo = disparo;
	}
}
