import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.geom.Rectangle2D;

public class Circulo {
	
	//DATOS
	private int posX, posY;//posicion
	private int ancho, alto;//tamaño
	private String letra;
	private Color color;
	//PARA OBJETOS QUE SE MUEVEN SOLOS
	private int dirH, dirV, velocidad;
	
	//PARA GESTIONAR EMPAREJAMIENTOS
	private boolean emparejado;
	private Cuadrado pareja;
	
	public Circulo() {
		posX=0;
		posY=0;
		ancho=10;
		alto=10;
		letra="A";
		color=Color.ORANGE;
		emparejado=false;
		pareja=null;
	}
	
	public Circulo(int posX, int posY, int ancho, int alto) {
		this.posX=posX;
		this.posY=posY;
		this.ancho=ancho;
		this.alto=alto;
		this.color=Color.ORANGE;
		this.letra="";
		emparejado=false;
		pareja=null;
	}

	public int getDirH() {
		return dirH;
	}

	public void setDirH(int dirH) {
		this.dirH = dirH;
	}

	public int getDirV() {
		return dirV;
	}

	public void setDirV(int dirV) {
		this.dirV = dirV;
	}

	public int getVelocidad() {
		return velocidad;
	}

	public void setVelocidad(int velocidad) {
		this.velocidad = velocidad;
	}

	public boolean isEmparejado() {
		return emparejado;
	}

	public void setEmparejado(boolean emparejado) {
		this.emparejado = emparejado;
	}

	public Cuadrado getPareja() {
		return pareja;
	}

	public void setPareja(Cuadrado pareja) {
		this.pareja = pareja;
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

	public String getLetra() {
		return letra;
	}

	public void setLetra(String letra) {
		this.letra = letra;
	}

	public Color getColor() {
		return color;
	}

	public void setColor(Color color) {
		this.color = color;
	}
	
	public void dibujar(Graphics g) {
		g.setColor(color);
		//dibjar el relleno con el color de fondo
		g.fillOval(posX, posY, ancho, alto);
		//dibujar el contorno en color NEGRO
		g.setColor(Color.BLACK);
		g.drawOval(posX, posY, ancho, alto);
		//DIBUJAR LA LETRA
		g.setFont(new Font("Arial", Font.PLAIN, 20));
		FontMetrics fm=g.getFontMetrics();
		Rectangle2D r;
		r=fm.getStringBounds(letra, g);
		
		g.drawString(letra, (int)(posX+ancho/2-r.getWidth()/2), 
							(int)(posY+alto/2+r.getHeight()/2-2));
	}
	
	public Rectangle getRect() {
		Rectangle r;
		r=new Rectangle(getPosX(), getPosY(), getAncho(), getAlto());
		return r;
	}
	
	public void mover() {
		//CALCULA LAS NUEVAS COORDENADAS A LAS QUE SE VA A MOVER
		setPosX(getPosX()+getDirH()*getVelocidad());
		setPosY(getPosY()+getDirV()*getVelocidad());
	}
}











