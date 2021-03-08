import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;

/* CORRER HACIA DERECHA E IZQUIERDA -> CON ANIMACION
 * SALTAR
 */
public class Caballo {
	public static final int PARADO = 1;
	public static final int SUBIENDO = 1;
	public static final int BAJANDO = 1;
	public static final int SUELO = 425;
	
	//DATOS
	private Image[] imgI;
	private Image[] imgD;
	private int estado, imgActual;
	private int posX, posY;
	private int dirH; // 1 - Derecha      -1 - Izquierda
	private int ancho, alto;
	
	private ZonaJuego zonaJuego;
	
	public Caballo(ZonaJuego zonaJuego) {
		this.zonaJuego = zonaJuego;
		estado=PARADO;
		//CARGAR IMAGENES
		imgI = new Image[8];
		imgD = new Image[8];
		imgActual = 4;
		dirH = 1;
		ancho = 100;
		alto = 70;
		posX = zonaJuego.getWidth()/2;
		posY = SUELO;
		for (int i = 0; i < imgD.length; i++) {
			imgI[i]= new ImageIcon(getClass().getResource("CaballoI"+(i+1)+".png")).getImage();
			imgD[i]= new ImageIcon(getClass().getResource("CaballoD"+(i+1)+".png")).getImage();
		}
	}
	
	public void dibujar (Graphics g) {
		if (dirH == 1) {
			g.drawImage(imgD[imgActual], posX, posY, ancho, alto, null);
		}else if (dirH == -1) {
			g.drawImage(imgI[imgActual], posX, posY, ancho, alto, null);

		}
	}
	public void mover () {
		if (posX>=zonaJuego.getWidth()) {
			posX = -ancho;
		}
		if (posX<-ancho) {
			posX = zonaJuego.getWidth();
		}
		//CAMBIAR DIRECCION
		posX+=10*dirH;
		//ANIMACION
		imgActual=(imgActual+1)%imgI.length;
	}

	
	
	
	
	public Image[] getImgI() {
		return imgI;
	}

	public void setImgI(Image[] imgI) {
		this.imgI = imgI;
	}

	public Image[] getImgD() {
		return imgD;
	}

	public void setImgD(Image[] imgD) {
		this.imgD = imgD;
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

	public int getDirH() {
		return dirH;
	}

	public void setDirH(int dirH) {
		this.dirH = dirH;
	}

	public int getAncho() {
		return ancho;
	}

	public void setAncho(int ancho) {
		this.ancho = ancho;
	}

	public int getAlto() {
		return alto;
	}

	public void setAlto(int alto) {
		this.alto = alto;
	}

	public ZonaJuego getZonaJuego() {
		return zonaJuego;
	}

	public void setZonaJuego(ZonaJuego zonaJuego) {
		this.zonaJuego = zonaJuego;
	}
}
