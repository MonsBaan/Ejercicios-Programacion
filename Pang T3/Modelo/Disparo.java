import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;

/*
 * SUBE DESDE LA ALTURA DEL JUGADOR HASTA EL MAXIMO, LUEGO DESAPARECE
 */
public class Disparo {
	private ZonaJuego zonaJuego;
	private Image imgDisparo;
	private int posX, posY, alto, ancho, velocidad;
	private boolean intersectado;

	public Disparo(ZonaJuego zonaJuego) {
		this.zonaJuego = zonaJuego;
		//CARGAR IMAGEN
		imgDisparo = new ImageIcon(getClass().getResource("Disparo/Disparo.png")).getImage();
		posX = 0;
		posY = zonaJuego.getHeight();
		alto = 770;
		ancho = 10;
		velocidad = 5;
		intersectado = false;
	}
	public void dibujar(Graphics g) {
		g.drawImage(imgDisparo, posX, posY, ancho, alto, null);

	}
	public void movimiento() {
		if (posY <= 0) {
			posY = zonaJuego.getHeight();
		}else {
			posY -= velocidad;
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

}
