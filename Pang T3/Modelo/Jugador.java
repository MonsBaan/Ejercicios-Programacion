import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;

import javax.swing.ImageIcon;

/*
 * ---ACCIONES BASICAS---
 * MOVIMIENTO LATERAL
 * 
 * ---ACCION DIFICIL---
 * ESCALERA
 */
public class Jugador {
	private static final int SUELO = 390;
	//DATOS
	private Image[] imgD;
	private Image[] imgI;
	private Image imgDIdle, imgIIdle;
	private int estado, imgActual;
	private int posX, posY, alto, ancho, dirH, velocidad;
	private boolean pared;
	
	private ZonaJuego zonaJuego;
	
	public Jugador(ZonaJuego zonaJuego) {
		this.zonaJuego = zonaJuego;
		//CARGAR IMAGENES
		imgD = new Image [9];
		imgI = new Image [9];
		imgActual = 0;
		
		//VALORES
		alto = 70;
		ancho = 90;
		posX = 97;
		posY = SUELO;
		estado = 0; //0- SIN MOVIMIENTO, 1- MOVIENDOSE, 2 - GOLPEADO
		dirH = 1; //-1 IZQUIERDA, 1 DERECHA
		velocidad = 5;
		
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
				if (pared) {
					g.drawImage(imgDIdle, posX, posY, ancho, alto, null);
				}else {
					g.drawImage(imgD[imgActual], posX, posY, ancho, alto, null);

				}
			}else if (dirH == -1) {
				if (pared) {
					g.drawImage(imgIIdle, posX, posY, ancho, alto, null);

				}else {
					g.drawImage(imgI[imgActual], posX, posY, ancho, alto, null);

				}

			}
			break;

		default:
			break;
		}


	}
	
	public void mover() {
		if (posX+ancho >= zonaJuego.getWidth()-1) {
			pared = true;
			if (dirH == -1) {
				posX += velocidad*dirH;

			}
		}else if (posX <= 2) {
			pared = true;

			if (dirH == 1) {
				posX += velocidad*dirH;
			}
		}else {
			pared = false;
			posX += velocidad*dirH;
			//ANIMACION
			imgActual=(imgActual+1)%imgD.length;
		}

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
	public Rectangle getBounds() {
		return new Rectangle(posX, posY, ancho, alto);
		
	}

}
