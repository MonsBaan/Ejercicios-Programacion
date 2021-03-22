import java.awt.Rectangle;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import javax.swing.JOptionPane;

public class EventosMenu {
	private Rectangle rMouse, rBoton1, rBoton2, rBoton3, rBoton4;
	private String p = "";
	private String puntuacionesTotal = "";

	public EventosMenu(Menu menu, MainJuego mainJuego) {
		
		menu.addMouseListener(new MouseListener() {

			@Override
			public void mouseReleased(MouseEvent e) {
				rMouse = new Rectangle(e.getX(), e.getY(), 1, 1);
				rBoton1 = new Rectangle(menu.getBoundsbtnComenzar());
				rBoton2 = new Rectangle(menu.getBoundsbtnControles());
				rBoton3 = new Rectangle(menu.getBoundsbtnSalir());
				rBoton4 = new Rectangle(menu.getBoundsbtnPuntuaciones());

				if (rMouse.intersects(rBoton1)) {
					mainJuego.estadoJuego(1);
				}
				if (rMouse.intersects(rBoton2)) {					
					if (menu.getEstadoAyuda() == 0) {
						menu.setEstadoAyuda(1);
					}else if (menu.getEstadoAyuda() == 1) {
						menu.setEstadoAyuda(0);
					}
				}
				if (rMouse.intersects(rBoton3)) {
					System.exit(1);
				}
				if (rMouse.intersects(rBoton4)) {
					
				    FileReader f;
					try {
						f = new FileReader("puntuaciones.txt");
					      BufferedReader b = new BufferedReader(f);
					      while((p = b.readLine())!=null) {
					    	if (p.equals("null")) {
								
							}else {
								puntuacionesTotal = puntuacionesTotal + p +" \n";		
							}
					      }
					      b.close();
						
					} catch (FileNotFoundException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}


					
					JOptionPane.showMessageDialog(mainJuego, puntuacionesTotal);
					puntuacionesTotal = "";
				}
				
			}

			public void mousePressed(MouseEvent e) {
			}
			public void mouseExited(MouseEvent e) {
			}
			public void mouseEntered(MouseEvent e) {
			}
			public void mouseClicked(MouseEvent e) {

			}
		});
	}



}
