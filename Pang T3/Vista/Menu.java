import java.awt.Canvas;
import java.awt.Graphics;
import java.awt.Image;
import java.util.ArrayList;

import javax.swing.ImageIcon;

public class Menu extends Canvas{
	
	private Image fondo;
	private Image buffer;
	private Graphics pantallaVirtual;

	
	public Menu() {
		//CARGAR FONDO
		//fondo = new ImageIcon(getClass().getResource("montaña.jpg")).getImage();
		
		


	}

	public void paint(Graphics g) {
		super.paint(g);
		g.drawImage(fondo, 100, 200, 200, 100, null);

	}
	
	public void update(Graphics g) {		//DOBLE BUFFER
		buffer = createImage(this.getWidth(), this.getHeight());
		pantallaVirtual = buffer.getGraphics();
		paint(pantallaVirtual);
		g.drawImage(buffer, 0, 0, this.getWidth(), this.getHeight(), null);
	}
}
