import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import javax.swing.ImageIcon;

public class Menu extends Canvas{
	private MainJuego mainJuego;
	private EventosMenu eventosMenu;

	private Image fondo, buffer, titulo, btnComenzar, btnControles, btnSalir, enemigo;
	private int random;

	private Graphics pantallaVirtual;

	
	public Menu() {
		//CARGAR FONDO
		//fondo = new ImageIcon(getClass().getResource("montaña.jpg")).getImage();
		random = (int) (Math.random()*3+1);
		setBackground(Color.white);
		//CARGAR BOTONES
		titulo = new ImageIcon(getClass().getResource("Botones/Titulo.png")).getImage();
		/*btnComenzar = new ImageIcon(getClass().getResource("Botones/Comenzar.png")).getImage();
		btnControles = new ImageIcon(getClass().getResource("Botones/Controles.png")).getImage();
		btnSalir = new ImageIcon(getClass().getResource("Botones/Salir.png")).getImage();
		enemigo = new ImageIcon(getClass().getResource("Enemigos/Bola"+random+".png")).getImage();*/
		
		//CARGAR EVENTOS
		eventosMenu = new EventosMenu(this);

	}

	public void paint(Graphics g) {
		super.paint(g);
		//g.drawImage(imagen, posX, posY, alto, ancho, NULL);
		g.drawImage(titulo, 335-250, 25, 500, 70, null);
		
		g.drawImage(btnComenzar, 50, 140, 175, 50, null);
		g.drawImage(btnControles, 50, 250, 175, 50, null);
		g.drawImage(btnSalir, 50, 360, 175, 50, null);
		
		g.drawImage(enemigo, 350, 150, 250, 250, null);
		

	}
	
	public void update(Graphics g) {		//DOBLE BUFFER
		buffer = createImage(this.getWidth(), this.getHeight());
		pantallaVirtual = buffer.getGraphics();
		paint(pantallaVirtual);
		g.drawImage(buffer, 0, 0, this.getWidth(), this.getHeight(), null);
	}
}
