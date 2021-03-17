import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Timer;

import javax.swing.ImageIcon;

public class Menu extends Canvas{
	private MainJuego mainJuego;
	private EventosMenu eventosMenu;
	private Timer reloj;
	private double rotacion = 0;
	private Image fondo, buffer, titulo, btnComenzar, btnAyuda, btnSalir, enemigo;
	private int random;
	private Graphics pantallaVirtual;


	public Menu(MainJuego mainJuego) {
		this.mainJuego = mainJuego;
		//CARGAR FONDO
		fondo = new ImageIcon(getClass().getResource("Fondo.jpg")).getImage();
		random = (int) (Math.random()*3+1);
		setBackground(Color.white);
		//CARGAR BOTONES


		titulo = new ImageIcon(getClass().getResource("Botones/Titulo.png")).getImage();
		btnComenzar = new ImageIcon(getClass().getResource("Botones/Comenzar.png")).getImage();
		btnAyuda = new ImageIcon(getClass().getResource("Botones/Ayuda.png")).getImage();
		btnSalir = new ImageIcon(getClass().getResource("Botones/Salir.png")).getImage();
		enemigo = new ImageIcon(getClass().getResource("Enemigos/Bola"+random+".png")).getImage();

		//CARGAR EVENTOS
		eventosMenu = new EventosMenu(this, this.mainJuego);


		reloj = new Timer(30, new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				repaint();
			}
		});
		reloj.start();

	}


	public void paint(Graphics g) {
		super.paint(g);
		//g.drawImage(imagen, posX, posY, ancho, alto, NULL);
		g.drawImage(fondo, 0, 0, 700, 515, null);
		g.drawImage(titulo, 335-250, 25, 500, 70, null);

		g.drawImage(btnComenzar, 50, 140, 175, 50, null);
		g.drawImage(btnAyuda, 50, 250, 175, 50, null);
		g.drawImage(btnSalir, 50, 360, 175, 50, null);


		Graphics2D gr2=(Graphics2D) g;
		gr2.translate(500, 260);
		gr2.rotate(rotacion);
		gr2.drawImage(enemigo, -100, -95, 200, 200, this);
		rotacion = rotacion + 0.01;

	}

	public void update(Graphics g) {		//DOBLE BUFFER
		buffer = createImage(this.getWidth(), this.getHeight());
		pantallaVirtual = buffer.getGraphics();
		paint(pantallaVirtual);
		g.drawImage(buffer, 0, 0, this.getWidth(), this.getHeight(), null);
	}
	
	
	
	
	
	
	
	//GETTERS Y SETTERS
	public Rectangle getBoundsbtnComenzar() {
		return new Rectangle(50, 140, 175, 50);
		
	}
	public Rectangle getBoundsbtnControles() {
		return new Rectangle(50, 250, 175, 50);
		
	}
	public Rectangle getBoundsbtnSalir() {
		return new Rectangle(50, 360, 175, 50);
		
	}
	
	public Image getBtnComenzar() {
		return btnComenzar;
	}


	public void setBtnComenzar(Image btnComenzar) {
		this.btnComenzar = btnComenzar;
	}


	public Image getbtnAyuda() {
		return btnAyuda;
	}


	public void setbtnAyuda(Image btnAyuda) {
		this.btnAyuda = btnAyuda;
	}


	public Image getBtnSalir() {
		return btnSalir;
	}


	public void setBtnSalir(Image btnSalir) {
		this.btnSalir = btnSalir;
	}


	public Timer getReloj() {
		return reloj;
	}


	public void setReloj(Timer reloj) {
		this.reloj = reloj;
	}
}
