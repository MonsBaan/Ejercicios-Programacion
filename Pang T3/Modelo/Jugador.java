import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;

/*
 * ---ACCIONES BASICAS---
 * MOVIMIENTO LATERAL
 * 
 * ---ACCION DIFICIL---
 * ESCALERA
 */
public class Jugador {
	private static final int SUELO = 400;
	//DATOS
	private Image[] imgD;
	private Image[] imgI;
	private Image imgDIdle, imgIIdle;
	private int estado, imgActual;
	private int posX, posY, alto, ancho, dirH;
	
	private ZonaJuego zonaJuego;
	
	public Jugador(ZonaJuego zonaJuego) {
		this.zonaJuego = zonaJuego;
		//CARGAR IMAGENES
		imgD = new Image [8];
		imgI = new Image [8];
		imgActual = 0;
		alto = 50;
		ancho = 63;
		posX = 97;
		posY = SUELO;
		estado = 0; //0- SIN MOVIMIENTO, 1- MOVIENDOSE
		dirH = 1;
		
		//CARGAR IMAGENES DE MOVIMIENTO
		for (int i = 0; i < imgD.length; i++) {
			imgD[i]= new ImageIcon(getClass().getResource("Bob/D"+(i+1)+".png")).getImage();
			imgI[i]= new ImageIcon(getClass().getResource("Bob/I"+(i+1)+".png")).getImage();
		}
		//CARGAR IMAGENES IDLE
		imgDIdle = new ImageIcon(getClass().getResource("Bob/D0.png")).getImage();
		imgIIdle = new ImageIcon(getClass().getResource("Bob/I0.png")).getImage();

	}
	
	public void dibujar(Graphics g) {
		switch (estado) {
		case 0: //SIN MOVIMIENTO
			if (dirH == 1) {
				g.drawImage(imgDIdle, posX, posY, ancho, alto, null);

			}else if(dirH == -1){
				g.drawImage(imgIIdle, posX, posY, ancho, alto, null);

			}
			break;
		case 1: //CON MOVIMIENTO
			if (dirH == 1) {
				g.drawImage(imgD[imgActual], posX, posY, ancho, alto, null);
			}else if (dirH == -1) {
				g.drawImage(imgI[imgActual], posX, posY, ancho, alto, null);

			}
			break;

		default:
			break;
		}


	}
	
	public void mover() {
		posX += 10*dirH;
		//ANIMACION
		imgActual=(imgActual+1)%imgD.length;
	}

	
	//GETTERS Y SETTERS
	public Image[] getImgD() {
		return imgD;
	}
	public void setImgD(Image[] imgD) {
		this.imgD = imgD;
	}
	public Image[] getImgI() {
		return imgI;
	}
	public void setImgI(Image[] imgI) {
		this.imgI = imgI;
	}
	public int getEstado() {
		return estado;
	}
	public void setEstado(int estado) {
		this.estado = estado;
	}
	public int getImgActual() {
		return imgActual;
	}
	public void setImgActual(int imgActual) {
		this.imgActual = imgActual;
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
	public int getDirH() {
		return dirH;
	}
	public void setDirH(int dirH) {
		this.dirH = dirH;
	}
	public ZonaJuego getZonaJuego() {
		return zonaJuego;
	}
	public void setZonaJuego(ZonaJuego zonaJuego) {
		this.zonaJuego = zonaJuego;
	}

}
