import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.Timer;

public class EventosJuego {
	private ZonaJuego zonaJuego;
	private int[] arrayTeclas; //0 - Disparar, 1 - Izquierda, 2 - Derecha, 3 - Arriba, 4 - Abajo
	private boolean intersectado = false;
	private boolean invulnerable = false;
	private int parpadeo = 0;//0 - Escondido, 1 - Dibujado
	private int contInvulnerable = 0;


	private Timer timerPersonaje;
	private Timer timerInvulnerable;

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
		for (int i = 0; i < zonaJuego.getNivel(); i++) {
			Enemigo bola;
			bola = new Enemigo(zonaJuego);
			bola.setTipo(3);
			if (i%2==0) {
				bola.setDirH(1);
			}else {
				bola.setDirH(-1);

			}
			zonaJuego.getArrayEnemigo1().add(bola);
			bola.start();
		}


		//TIMER PERSONAJE
		timerPersonaje = new Timer(15, new ActionListener() {
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

						if (intersectado) {
							timerInvulnerable.start();
							intersectado = false;
						}



					}
				}
				
				switch (checkFinJuego()) {
				case 1:
					System.out.println("Derrota");
					zonaJuego.getArrayJugador().clear();
					zonaJuego.getArrayDisparo().clear();
					zonaJuego.getArrayEnemigo1().clear();
					zonaJuego.getArrayEnemigo2().clear();
					zonaJuego.getArrayEnemigo3().clear();
					
					zonaJuego.getMainJuego().estadoJuego(0);
					
					timerPersonaje.stop();
					timerInvulnerable.stop();
					

					break;
				case 2:
					System.out.println("Victoria");
					zonaJuego.getArrayJugador().clear();
					zonaJuego.getArrayDisparo().clear();
					zonaJuego.getArrayEnemigo1().clear();
					zonaJuego.getArrayEnemigo2().clear();
					zonaJuego.getArrayEnemigo3().clear();

					zonaJuego.getMainJuego().estadoJuego(0);

					timerPersonaje.stop();
					timerInvulnerable.stop();
					break;

				default:
					break;
				}
				

				zonaJuego.repaint();
			}
		});

		//TIMER INVULNERABILIDAD
		timerInvulnerable = new Timer(200, new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				if (zonaJuego.getArrayJugador().size() != 0) {
					for (int i = 0; i < zonaJuego.getArrayJugador().size(); i++) {
						if (parpadeo == 1) {
							parpadeo = 0;
						}else if (parpadeo == 0){
							parpadeo = 1;
						}

					}
				}
				invulnerable = true;
				contInvulnerable++;
				if (contInvulnerable >= 8) {
					timerInvulnerable.stop();
					contInvulnerable = 0;
					parpadeo = 0;
					invulnerable = false;
					zonaJuego.repaint();
				}
			}
		});


		
		
		timerPersonaje.start();
		
		//EVENTOS DE TECLAS
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

	//COMPROBAR COLISION DE UNA PELOTA CON EL JUGADOR
	public void checkColisionJugador() {
		if (zonaJuego.getArrayJugador().size() != 0) {
			for (int i = 0; i < zonaJuego.getArrayJugador().size(); i++) {
				Rectangle Rjugador = zonaJuego.getArrayJugador().get(i).getBounds();//SE CREA UN RECTANGULO ALREDEDOR DEL PERSONAJE

				if (zonaJuego.getArrayEnemigo1().size() != 0) {
					for (int enemigoAct = 0; enemigoAct < zonaJuego.getArrayEnemigo1().size(); enemigoAct++) {
						Rectangle Rbola = zonaJuego.getArrayEnemigo1().get(enemigoAct).getBounds();//SE CREA UN RECTANGULO EN CADA BOLA EXISTENTE EN EL ARRAYLIST
						if (Rbola.intersects(Rjugador)) {
							intersectado = true;
						}
					}
				}//FINAL DE CHECK COLISION EN ARRAY 1
				if (zonaJuego.getArrayEnemigo2().size() != 0) {
					for (int enemigoAct = 0; enemigoAct < zonaJuego.getArrayEnemigo2().size(); enemigoAct++) {
						Rectangle Rbola = zonaJuego.getArrayEnemigo2().get(enemigoAct).getBounds();//SE CREA UN RECTANGULO EN CADA BOLA EXISTENTE EN EL ARRAYLIST
						if (Rbola.intersects(Rjugador)) {
							intersectado = true;
						}
					}
				}//FINAL DE CHECK COLISION EN ARRAY 2

				if (zonaJuego.getArrayEnemigo3().size() != 0) {
					for (int enemigoAct = 0; enemigoAct < zonaJuego.getArrayEnemigo3().size(); enemigoAct++) {
						Rectangle Rbola = zonaJuego.getArrayEnemigo3().get(enemigoAct).getBounds();//SE CREA UN RECTANGULO EN CADA BOLA EXISTENTE EN EL ARRAYLIST
						if (Rbola.intersects(Rjugador)) {
							intersectado = true;
						}
					}
				}//FINAL DE CHECK COLISION EN ARRAY 3
			}
		}
		
		
		
		//System.out.println(zonaJuego.getVidas());

		//EN CASO DE SER GOLPEADO TENER 3 SEGUNDOS DE INMUNIDAD
		if (intersectado) {
			if (invulnerable == false) {
				invulnerable = true;
				zonaJuego.setVidas(zonaJuego.getVidas()-1);

				
			}
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
								zonaJuego.getSe().setFile(zonaJuego.getPop3());
								zonaJuego.getSe().play();
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
								zonaJuego.getSe().setFile(zonaJuego.getPop2());
								zonaJuego.getSe().play();
								zonaJuego.getArrayEnemigo2().remove(enemigoAct);//SE ELIMINA EL ENEMIGO INTERSECTADO
							}
						}//FINAL DE CHECK COLISION EN ARRAY 2
					}
					if (zonaJuego.getArrayDisparo().size()!=0) {
						for (int enemigoAct = 0; enemigoAct < zonaJuego.getArrayEnemigo3().size(); enemigoAct++) {
							Rectangle Rbola = zonaJuego.getArrayEnemigo3().get(enemigoAct).getBounds();//SE CREA UN RECTANGULO EN CADA BOLA EXISTENTE EN EL ARRAYLIST
							if (Rdisparo.intersects(Rbola)) {
								zonaJuego.getArrayDisparo().remove(disparoAct);//SE ELIMINA EL DISPARO EN CASO DE SER INTERSECTADO
								zonaJuego.getSe().setFile(zonaJuego.getPop1());
								zonaJuego.getSe().play();
								zonaJuego.getArrayEnemigo3().remove(enemigoAct);//SE ELIMINA EL ENEMIGO INTERSECTADO
							}
						}//FINAL DE CHECK COLISION EN ARRAY 3
					}
				}
			}
		}		
	}//FIN DE CHECK DE COLISIONES DE DISPAROS

	
	public int checkFinJuego() {
		int vidas = zonaJuego.getVidas();
		int enemigos1 = zonaJuego.getArrayEnemigo1().size();
		int enemigos2 = zonaJuego.getArrayEnemigo2().size();
		int enemigos3 = zonaJuego.getArrayEnemigo3().size();
		
		if (vidas <= 0) {
			return 1;
		}
		
		if (enemigos1 == 0 && enemigos2 == 0 && enemigos3 == 0) {
			
			return 2;
		}
		
		return 0;
	}
	//GETTERS Y SETTERS
	public int getInvulnerable() {
		return parpadeo;
	}

	public void setInvulnerable(int invulnerable) {
		this.parpadeo = invulnerable;
	}









}
