import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.Timer;

public class EventosJuego {
	private ZonaJuego zonaJuego;
	private int[] arrayTeclas; //0 - Disparar, 1 - Izquierda, 2 - Derecha, 3 - Arriba, 4 - Abajo
	private int nivel, num;

	private Timer timerPersonaje;
	
	public EventosJuego(ZonaJuego zonaJuego) {
		this.zonaJuego = zonaJuego;
		Random r = new Random();
		
		//ARRAY TECLAS Y INICIALIZACION
		arrayTeclas = new int[5];
		for (int i : arrayTeclas) {
			i = 0;
		}
		nivel = 5;
		for (int i = 0; i < nivel; i++) {
			Enemigo bola;
			bola = new Enemigo(zonaJuego);
			zonaJuego.getArrayEnemigo1().add(bola);
			
			num = r.nextInt(2);
			if (num == 1) {
				bola.setDirH(-1);
			}else if (num == 0) {
				bola.setDirH(1);
			}
			bola.start();
		}

		
		//TIMER PERSONAJE
		timerPersonaje = new Timer(20, new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// SEGUN QUE TECLA SE PULSE SE ACTIVA UN MOVIMIENTO
				if (arrayTeclas[1]==1) {
					zonaJuego.getJugador().setDirH(-1);
					zonaJuego.getJugador().mover();
				}else if(arrayTeclas[2]==1){
					zonaJuego.getJugador().setDirH(1);
					zonaJuego.getJugador().mover();
				}
				
				
				checkColision();
				zonaJuego.repaint();

			}
		});
		timerPersonaje.start();
		
		zonaJuego.addKeyListener(new KeyListener() {
			
			@Override
			public void keyTyped(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void keyReleased(KeyEvent e) {
				if (arrayTeclas[0]!=1) {
					arrayTeclas[1]=0;
					arrayTeclas[2]=0;
					arrayTeclas[3]=0;
					arrayTeclas[4]=0;
					zonaJuego.repaint();
					zonaJuego.getJugador().setEstado(0);
				}
					arrayTeclas[0]=0;
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
					if (!zonaJuego.getDisparo().isDisparo()) {
						zonaJuego.getDisparo().setIntersectado(false);
						zonaJuego.getDisparo().setPosX(zonaJuego.getJugador().getPosX()+45);
						zonaJuego.getDisparo().setDisparo(true);
					}
					arrayTeclas[0]=1;

					break;

				default:
					break;
				}
			}
		});
		


	}
	
	public void checkColision() {
		Rectangle disparo = zonaJuego.getDisparo().getBounds();
		
		for (int i = 0; i < zonaJuego.getArrayEnemigo1().size(); i++) {
			Rectangle bola = zonaJuego.getArrayEnemigo1().get(i).getBounds();
			if (disparo.intersects(bola)) { //EN CASO DE SER INTERCEPTADO, LA BALA SE PONE A TRUE Y LA BOLA DESAPARECE
				zonaJuego.getDisparo().setIntersectado(true);
				zonaJuego.getArrayEnemigo1().remove(i);
				
				for (int j = 0; j < 2; j++) {
					Enemigo bola2;
					bola2 = new Enemigo(zonaJuego);
					bola2.setTipo(2);
					zonaJuego.getArrayEnemigo1().add(bola2);
					bola2.start();
				}

			}
		}
		
		for (int i = 0; i < zonaJuego.getArrayEnemigo2().size(); i++) {
			Rectangle bola = zonaJuego.getArrayEnemigo2().get(i).getBounds();
			if (disparo.intersects(bola)) { //EN CASO DE SER INTERCEPTADO, LA BALA SE PONE A TRUE Y LA BOLA DESAPARECE
				zonaJuego.getDisparo().setIntersectado(true);
				zonaJuego.getArrayEnemigo2().remove(i);

			}
		}
		
		for (int i = 0; i < zonaJuego.getArrayEnemigo3().size(); i++) {
			Rectangle bola = zonaJuego.getArrayEnemigo3().get(i).getBounds();
			if (disparo.intersects(bola)) { //EN CASO DE SER INTERCEPTADO, LA BALA SE PONE A TRUE Y LA BOLA DESAPARECE
				zonaJuego.getDisparo().setIntersectado(true);
				zonaJuego.getArrayEnemigo3().remove(i);

			}
		}
		

		


	}
	
	
	






}
