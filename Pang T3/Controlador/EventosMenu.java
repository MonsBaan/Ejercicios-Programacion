import java.awt.Rectangle;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class EventosMenu {
	public EventosMenu(Menu menu, MainJuego mainJuego) {
		menu.addMouseListener(new MouseListener() {

			@Override
			public void mouseReleased(MouseEvent e) {
				Rectangle rMouse, rBoton1, rBoton2, rBoton3;
				rMouse = new Rectangle(e.getX(), e.getY(), 1, 1);
				rBoton1 = new Rectangle(menu.getBoundsbtnComenzar());
				rBoton2 = new Rectangle(menu.getBoundsbtnControles());
				rBoton3 = new Rectangle(menu.getBoundsbtnSalir());
				
				if (rMouse.intersects(rBoton1)) {
					mainJuego.estadoJuego(1);
				}else if (rMouse.intersects(rBoton2)) {
					System.out.println("Controles");
					
					if (menu.getEstadoAyuda() == 0) {
						menu.setEstadoAyuda(1);

					}else if (menu.getEstadoAyuda() == 1) {
						menu.setEstadoAyuda(0);

					}
				}else if (rMouse.intersects(rBoton3)) {
					System.exit(1);
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
