import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.Timer;

public class EventosJuego {
	private ZonaJuego zonaJuego;
	private int[] arrayTeclas; //0 - Disparar, 1 - Izquierda, 2 - Derecha, 3 - Arriba, 4 - Abajo
	private Timer timer;
	
	public EventosJuego(ZonaJuego zonaJuego) {
		this.zonaJuego = zonaJuego;
		
		//ARRAY TECLAS Y INICIALIZACION
		arrayTeclas = new int[5];
		for (int i : arrayTeclas) {
			i = 0;
		}
		
		//TIMER Y CONTROL DE EVENTOS EN EJECUCION
		timer = new Timer(25, new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// SEGUN QUE TECLA SE PULSE SE ACTIVA UN MOVIMIENTO
				if (arrayTeclas[1]==1) {
					zonaJuego.getJugador().setDirH(-1);
					zonaJuego.getJugador().mover();
					zonaJuego.repaint();
				}else if(arrayTeclas[2]==1){
					zonaJuego.getJugador().setDirH(1);
					zonaJuego.getJugador().mover();
					zonaJuego.repaint();
				}
			}
		});
		timer.start();
		
		zonaJuego.addKeyListener(new KeyListener() {
			
			@Override
			public void keyTyped(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void keyReleased(KeyEvent e) {
				zonaJuego.repaint();
				zonaJuego.getJugador().setEstado(0);

				arrayTeclas[0]=0;
				arrayTeclas[1]=0;
				arrayTeclas[2]=0;
				arrayTeclas[3]=0;
				arrayTeclas[4]=0;
				
			}
			
			@Override
			public void keyPressed(KeyEvent e) {
				switch (e.getKeyCode()) {
				case KeyEvent.VK_A:
					zonaJuego.getJugador().setEstado(1);
					arrayTeclas[1]=1;
					arrayTeclas[2]=0;
					break;
				case KeyEvent.VK_LEFT:
					zonaJuego.getJugador().setEstado(1);
					arrayTeclas[1]=1;
					arrayTeclas[2]=0;
					break;
					
				case KeyEvent.VK_D:
					zonaJuego.getJugador().setEstado(1);
					arrayTeclas[1]=0;
					arrayTeclas[2]=1;
					break;
				case KeyEvent.VK_RIGHT:
					zonaJuego.getJugador().setEstado(1);
					arrayTeclas[1]=0;
					arrayTeclas[2]=1;
					break;
					
				case KeyEvent.VK_SPACE:
					

					break;

				default:
					break;
				}				
			}
		});
	}

}
