import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.Timer;

public class EventosJuego {
	private ZonaJuego zonaJuego;
	private int[] arrayTeclas; //0 - Disparar, 1 - Izquierda, 2 - Derecha, 3 - Arriba, 4 - Abajo
	private int nivel;
	private Timer impactado;


	private Timer timerPersonaje;

	public EventosJuego(ZonaJuego zonaJuego) {
		this.zonaJuego = zonaJuego;

		//ARRAY TECLAS Y INICIALIZACION
		Jugador jugador;
		jugador = new Jugador(zonaJuego);
		zonaJuego.getArrayJugador().add(jugador);

		arrayTeclas = new int[5];
		for (int i : arrayTeclas) {
			i = 0;
		}
		nivel = 1;
		for (int i = 0; i < nivel; i++) {
			Enemigo bola;
			bola = new Enemigo(zonaJuego);
			zonaJuego.getArrayEnemigo1().add(bola);
			bola.start();
		}


		//TIMER PERSONAJE
		timerPersonaje = new Timer(20, new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				if (zonaJuego.getArrayJugador().size() != 0) {
					for (int i = 0; i < zonaJuego.getArrayJugador().size(); i++) {

						if (zonaJuego.getArrayEnemigo1().size() != 0 || zonaJuego.getArrayEnemigo2().size() != 0 || zonaJuego.getArrayEnemigo3().size() != 0 ) {
							checkColisionJugador();
						}
						// SEGUN QUE TECLA SE PULSE SE ACTIVA UN MOVIMIENTO
						if (arrayTeclas[1]==1) {
							zonaJuego.getArrayJugador().get(i).setDirH(-1);
							zonaJuego.getArrayJugador().get(i).mover();
						}else if(arrayTeclas[2]==1){
							zonaJuego.getArrayJugador().get(i).setDirH(1);
							zonaJuego.getArrayJugador().get(i).mover();
						}

						if (zonaJuego.getArrayDisparo().size()!=0) {
							checkColisionDisparo();
						}
					}

				}


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
				if (zonaJuego.getArrayJugador().size() != 0) {
					for (int i = 0; i < zonaJuego.getArrayJugador().size(); i++) {
						if (arrayTeclas[0]!=1) {
							arrayTeclas[1]=0;
							arrayTeclas[2]=0;
							arrayTeclas[3]=0;
							arrayTeclas[4]=0;
							zonaJuego.repaint();
							zonaJuego.getArrayJugador().get(i).setEstado(0);
						}
						arrayTeclas[0]=0;
					}
				}

			}

			@Override
			public void keyPressed(KeyEvent e) {
				switch (e.getKeyCode()) {
				case KeyEvent.VK_A:
					if (zonaJuego.getArrayJugador().size() != 0) {
						for (int i = 0; i < zonaJuego.getArrayJugador().size(); i++) {
							zonaJuego.getArrayJugador().get(i).setEstado(1);
							arrayTeclas[1]=1;
							arrayTeclas[2]=0;
						}
					}

					break;
				case KeyEvent.VK_LEFT:
					if (zonaJuego.getArrayJugador().size() != 0) {
						for (int i = 0; i < zonaJuego.getArrayJugador().size(); i++) {
							zonaJuego.getArrayJugador().get(i).setEstado(1);
							arrayTeclas[1]=1;
							arrayTeclas[2]=0;
						}
					}

					break;

				case KeyEvent.VK_D:
					if (zonaJuego.getArrayJugador().size() != 0) {
						for (int i = 0; i < zonaJuego.getArrayJugador().size(); i++) {
							zonaJuego.getArrayJugador().get(i).setEstado(1);
							arrayTeclas[1]=0;
							arrayTeclas[2]=1;	
						}
					}

					break;
				case KeyEvent.VK_RIGHT:
					if (zonaJuego.getArrayJugador().size() != 0) {
						for (int i = 0; i < zonaJuego.getArrayJugador().size(); i++) {
							zonaJuego.getArrayJugador().get(i).setEstado(1);
							arrayTeclas[1]=0;
							arrayTeclas[2]=1;
						}
					}

					break;

				case KeyEvent.VK_SPACE:
					if (zonaJuego.getArrayJugador().size() != 0) {
						for (int i = 0; i < zonaJuego.getArrayJugador().size(); i++) {
							if (zonaJuego.getArrayDisparo().size() == 0) {
								Disparo disparo;
								disparo = new Disparo(zonaJuego);
								disparo.setPosX(zonaJuego.getArrayJugador().get(i).getPosX()+45);
								disparo.setDisparo(true);
								disparo.start();
								zonaJuego.getArrayDisparo().add(disparo);
							}


							arrayTeclas[0]=1;
						}
					}


					break;

				default:
					break;
				}
			}
		});



	}

	public void checkColisionJugador() {
		boolean intesectado = false;
		if (zonaJuego.getArrayJugador().size() != 0) {
			for (int i = 0; i < zonaJuego.getArrayJugador().size(); i++) {
				Rectangle Rjugador = zonaJuego.getArrayJugador().get(i).getBounds();

				if (zonaJuego.getArrayEnemigo1().size() != 0) {
					for (int enemigoAct = 0; enemigoAct < zonaJuego.getArrayEnemigo1().size(); enemigoAct++) {
						Rectangle Rbola = zonaJuego.getArrayEnemigo1().get(enemigoAct).getBounds();//SE CREA UN RECTANGULO EN CADA BOLA EXISTENTE EN EL ARRAYLIST
						if (Rbola.intersects(Rjugador)) {
							intesectado = true;
						}
					}
				}//FINAL DE CHECK COLISION EN ARRAY 1

				if (zonaJuego.getArrayEnemigo2().size() != 0) {
					for (int enemigoAct = 0; enemigoAct < zonaJuego.getArrayEnemigo2().size(); enemigoAct++) {
						Rectangle Rbola = zonaJuego.getArrayEnemigo2().get(enemigoAct).getBounds();//SE CREA UN RECTANGULO EN CADA BOLA EXISTENTE EN EL ARRAYLIST
						if (Rbola.intersects(Rjugador)) {
							intesectado = true;
						}
					}
				}//FINAL DE CHECK COLISION EN ARRAY 2

				if (zonaJuego.getArrayEnemigo3().size() != 0) {
					for (int enemigoAct = 0; enemigoAct < zonaJuego.getArrayEnemigo3().size(); enemigoAct++) {
						Rectangle Rbola = zonaJuego.getArrayEnemigo3().get(enemigoAct).getBounds();//SE CREA UN RECTANGULO EN CADA BOLA EXISTENTE EN EL ARRAYLIST
						if (Rbola.intersects(Rjugador)) {
							intesectado = true;
						}
					}
				}//FINAL DE CHECK COLISION EN ARRAY 3
			}
		}

		if (intesectado) {
			zonaJuego.setVidas(zonaJuego.getVidas()-1);
			impactado = new Timer(500, new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent arg0) {
					if (zonaJuego.getArrayJugador().size() != 0) {
						for (int i = 0; i < zonaJuego.getArrayJugador().size(); i++) {
							zonaJuego.getArrayJugador().get(i).setEstado(true);
						}
					}
					
					impactado.stop();
				}
			});
		}
		
		if (zonaJuego.getVidas() <= 0) {
			System.out.println("ded");
			zonaJuego.getArrayJugador().clear();
			zonaJuego.getArrayDisparo().clear();
			zonaJuego.getArrayEnemigo1().clear();
			zonaJuego.getArrayEnemigo2().clear();
			zonaJuego.getArrayEnemigo3().clear();
		}
	}






	public void checkColisionDisparo() {
		if (zonaJuego.getArrayDisparo().size()!=0) {
			for (int disparoAct = 0; disparoAct < zonaJuego.getArrayDisparo().size(); disparoAct++) {
				if (zonaJuego.getArrayDisparo().get(disparoAct).getPosY() <= 0) {
					zonaJuego.getArrayDisparo().remove(disparoAct);
				}else {
					Rectangle Rdisparo = zonaJuego.getArrayDisparo().get(disparoAct).getBounds();//SE CREA UN RECTANGULO CON EL DISPARO ACTUAL
					if (zonaJuego.getArrayDisparo().size() != 0) {
						for (int enemigoAct = 0; enemigoAct < zonaJuego.getArrayEnemigo1().size(); enemigoAct++) {
							Rectangle Rbola = zonaJuego.getArrayEnemigo1().get(enemigoAct).getBounds();//SE CREA UN RECTANGULO EN CADA BOLA EXISTENTE EN EL ARRAYLIST
							if (Rdisparo.intersects(Rbola)) {
								zonaJuego.getArrayDisparo().remove(disparoAct);//SE ELIMINA EL DISPARO EN CASO DE SER INTERSECTADO

								for (int k = 0; k < 2; k++) {//SE GENERAN 2 BOLAS NUEVAS DE TIPO MENOR
									Enemigo bolaNew;
									bolaNew = new Enemigo(zonaJuego);
									if (k!=0) {
										bolaNew.setDirH(1);
									}else {
										bolaNew.setDirH(-1);
									}
									bolaNew.setTipo(zonaJuego.getArrayEnemigo1().get(enemigoAct).getTipo()-1);
									bolaNew.setPosX(zonaJuego.getArrayEnemigo1().get(enemigoAct).getPosX());
									bolaNew.setPosY((int) zonaJuego.getArrayEnemigo1().get(enemigoAct).getPosY());
									zonaJuego.getArrayEnemigo2().add(bolaNew);
									bolaNew.start();
								}
								zonaJuego.getArrayEnemigo1().remove(enemigoAct);//SE ELIMINA EL ENEMIGO INTERSECTADO
							}
						}//FINAL DE CHECK COLISION EN ARRAY 1
					}
					if (zonaJuego.getArrayDisparo().size()!=0) {
						for (int enemigoAct = 0; enemigoAct < zonaJuego.getArrayEnemigo2().size(); enemigoAct++) {
							Rectangle Rbola = zonaJuego.getArrayEnemigo2().get(enemigoAct).getBounds();//SE CREA UN RECTANGULO EN CADA BOLA EXISTENTE EN EL ARRAYLIST
							if (Rdisparo.intersects(Rbola)) {
								zonaJuego.getArrayDisparo().remove(disparoAct);//SE ELIMINA EL DISPARO EN CASO DE SER INTERSECTADO

								for (int k = 0; k < 2; k++) {//SE GENERAN 2 BOLAS NUEVAS DE TIPO MENOR
									Enemigo bolaNew;
									bolaNew = new Enemigo(zonaJuego);
									if (k!=0) {
										bolaNew.setDirH(1);
									}else {
										bolaNew.setDirH(-1);
									}
									bolaNew.setTipo(zonaJuego.getArrayEnemigo2().get(enemigoAct).getTipo()-1);
									bolaNew.setPosX(zonaJuego.getArrayEnemigo2().get(enemigoAct).getPosX());
									bolaNew.setPosY((int) zonaJuego.getArrayEnemigo2().get(enemigoAct).getPosY());
									zonaJuego.getArrayEnemigo3().add(bolaNew);
									bolaNew.start();
								}
								zonaJuego.getArrayEnemigo2().remove(enemigoAct);//SE ELIMINA EL ENEMIGO INTERSECTADO
							}
						}//FINAL DE CHECK COLISION EN ARRAY 2
					}
					if (zonaJuego.getArrayDisparo().size()!=0) {
						for (int enemigoAct = 0; enemigoAct < zonaJuego.getArrayEnemigo3().size(); enemigoAct++) {
							Rectangle Rbola = zonaJuego.getArrayEnemigo3().get(enemigoAct).getBounds();//SE CREA UN RECTANGULO EN CADA BOLA EXISTENTE EN EL ARRAYLIST
							if (Rdisparo.intersects(Rbola)) {
								zonaJuego.getArrayDisparo().remove(disparoAct);//SE ELIMINA EL DISPARO EN CASO DE SER INTERSECTADO
								zonaJuego.getArrayEnemigo3().remove(enemigoAct);//SE ELIMINA EL ENEMIGO INTERSECTADO
							}
						}//FINAL DE CHECK COLISION EN ARRAY 3
					}
				}
			}
		}		
	}//FIN DE CHECK DE COLISIONES DE DISPAROS









}
