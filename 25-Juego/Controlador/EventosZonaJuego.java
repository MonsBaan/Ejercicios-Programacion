import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.Timer;

public class EventosZonaJuego {
	private ZonaJuego zonaJuego;
	private int[] arrayTeclas;//0- Izquierda, 1- Derecha, 2- Salto
	private Timer reloj;


	public EventosZonaJuego(ZonaJuego zonaJuego) {
		this.zonaJuego = zonaJuego;
		arrayTeclas=new int [4];
		
		for (int i = 0; i < arrayTeclas.length; i++) {
			arrayTeclas[i]=0;
		}
		
		reloj = new Timer(40, new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// SEGUN EL ESTADO DE LAS TECLAS PULSADAS ESTABLECEMOS LA DIRECCION DEL CABALLO Y REDIBUJAMOS TODO				
				if(arrayTeclas[0]==1) {
					zonaJuego.getCaballo().setDirH(-1);
					zonaJuego.getCaballo().mover();
					zonaJuego.repaint();
				}
				if (arrayTeclas[1]==1) {
					zonaJuego.getCaballo().setDirH(1);
					zonaJuego.getCaballo().mover();
					zonaJuego.repaint();
				}
			}
		});
		reloj.start();
				
		zonaJuego.addKeyListener(new KeyListener() {
			//SEGUN LA TECLA PULSADA O LIBERADA SE MODIFICA EL ARRAY DE LAS TECLAS
			@Override
			public void keyTyped(KeyEvent e) {
				// TODO Auto-generated method stub							
			}
			
			@Override
			public void keyReleased(KeyEvent e) {
				// TODO Auto-generated method stub
				zonaJuego.getCaballo().setImgActual(6);
				zonaJuego.repaint();
				arrayTeclas[0]=0;
				arrayTeclas[1]=0;

			}
			
			
			@Override
			public void keyPressed(KeyEvent e) {				
				/*ANTIGUO SISTEMA DE MOVIMIENTO
				 * switch (e.getKeyCode()) {
				case KeyEvent.VK_A:
					zonaJuego.getCaballo().setDirH(-1);
					zonaJuego.getCaballo().mover();
					zonaJuego.repaint();
				break;
				
				case KeyEvent.VK_D:
					zonaJuego.getCaballo().setDirH(1);
					zonaJuego.getCaballo().mover();
					zonaJuego.repaint();
				break;
				
				default:
					break;
				}*/
				
				switch (e.getKeyCode()) {
				case KeyEvent.VK_A:
					arrayTeclas[1]=0;
					arrayTeclas[0]=1;
					break;
					
				case KeyEvent.VK_D:
					arrayTeclas[0]=0;
					arrayTeclas[1]=1;
					break;

				default:
					break;
				}

			}
		});
	}
	
}
