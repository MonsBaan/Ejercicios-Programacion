import java.awt.Color;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionAdapter;
import java.awt.event.MouseMotionListener;

import javax.swing.Timer;

public class EventosAreaDibujo {

	private AreaDibujo areaDibujo;
	private Cuadrado cuadSeleccionado;
	private Circulo circColisionado;
	private int despX, despY;
	
	public EventosAreaDibujo(AreaDibujo areaDibujo) {
		this.areaDibujo=areaDibujo;
		cuadSeleccionado=null;
		
		areaDibujo.setReloj(new Timer(40, new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				Circulo circ=areaDibujo.getCirc();
				Cuadrado cuad=areaDibujo.getCuad();
				//MOVER EL CIRCULO Y EL CUADRADO
				circ.mover();
				cuad.mover();
				
				//COMPROBAR COLISIONES CON LOS LATERALES PARA CAMBIAR SU DIRECCIÓN
				/*SI DIRV==1
						SI LA POSICION "Y" MAS LA "ALTURA" ES MAYOR QUE EL TAMAÑO DEL CANVAS
				*/
				//ABAJO
				if(circ.getPosY()+circ.getAlto()>=areaDibujo.getHeight()) {
					circ.setDirV(-1);
				}
				if(cuad.getPosY()+cuad.getAlto()>=areaDibujo.getHeight()) {
					cuad.setDirV(-1);
				}
				//DERECHA
				if(circ.getPosX()+circ.getAncho()>=areaDibujo.getWidth()) {
					circ.setDirH(-1);
				}
				if(cuad.getPosX()+cuad.getAncho()>=areaDibujo.getWidth()) {
					cuad.setDirH(-1);
				}
				//IZQUIERDA
				if(circ.getPosX()<=0) {
					circ.setDirH(1);
				}
				if(cuad.getPosX()<=0) {
					cuad.setDirH(1);
				}
				//ARRIBA
				if(circ.getPosY()<=0) {
					circ.setDirV(1);
				}
				if(cuad.getPosY()<=0) {
					cuad.setDirV(1);
				}
				//COMPROBAR COLISIONES ENTRE LAS LETRAS PARA FINALIZAR LA ANIMACIÓN
				if(circ.getRect().intersects(cuad.getRect())) {
					circ.setDirH(0);
					circ.setDirV(0);
					cuad.setDirH(0);
					cuad.setDirV(0);
					circ.setAlto(circ.getAlto()+5);
					circ.setAncho(circ.getAncho()+5);
					cuad.setAlto(cuad.getAlto()+5);
					cuad.setAncho(cuad.getAncho()+5);
					if(circ.getAlto()>=120) {
						areaDibujo.getReloj().stop();
					}
				}
				
				areaDibujo.repaint();
			}
		}));
		areaDibujo.getReloj().start();
				
		areaDibujo.addMouseListener(new MouseAdapter() {
			
			@Override
			public void mouseReleased(MouseEvent e) {
				if(cuadSeleccionado!=null) {
					//SI EL CUADRADO SELECCIONADO NO COLISIONA CON NINGÚN CIRCULO -> VOLVER A POS INICIAL
					if(circColisionado==null) {
						cuadSeleccionado.setPosX(cuadSeleccionado.getPosXInicial());
						cuadSeleccionado.setPosY(cuadSeleccionado.getPosYInicial());
					}else {//SI EL CUADRADO SELECCIONADO SI COLISIONA CON UN CIRCULO ->
						//emparejados el circulo y el cuadrado
						circColisionado.setEmparejado(true);
						cuadSeleccionado.setEmparejado(true);
						//asignar a la pareja del circulo ese cuadrado
						circColisionado.setPareja(cuadSeleccionado);
						//COLOCAR EL CUADRADO 
						cuadSeleccionado.setPosX(circColisionado.getPosX());
						cuadSeleccionado.setPosY(circColisionado.getPosY()+AreaDibujo.SEP*3/4);
						//SI ESTÁN TODOS EMPAREJADOS, ACTIVAR EL BOTON COMPROBAR (FINAL)
						boolean todosEmparejados=true;
						for(Circulo circ:areaDibujo.getArrayCirculos()) {
							if(!circ.isEmparejado()) {
								todosEmparejados=false;
								break;
							}
						}

						if(todosEmparejados) {
							areaDibujo.getJuegoLetras().getBtnComprobar().setEnabled(true);
						}
					}
					//FINAL
					cuadSeleccionado=null;
					areaDibujo.repaint();
				}
			}
			
			@Override
			public void mousePressed(MouseEvent e) {
				//PARA COGER UN CUADRADO
				Rectangle rMouse, rCuad;
				rMouse=new Rectangle(e.getX(), e.getY(), 1, 1);
				if(areaDibujo.getArrayCuadrados()!=null) {
					for (Cuadrado c : areaDibujo.getArrayCuadrados()) {
						rCuad=c.getRect();
						//si colisiona con el cuadrado actual, guardarlo en una variable
						if(rMouse.intersects(rCuad) && !c.isEmparejado()) {
							cuadSeleccionado=c;
							//OBTENER EL DESPLAZ. EN x Y EN y DEL RATÓN RESPECTO AL COMIENZO 
							//DEL CUADRADO
							despX=e.getX()-c.getPosX();
							despY=e.getY()-c.getPosY();
							break;
						}
					}
				}
			}
		});
		
		areaDibujo.addMouseMotionListener(new MouseMotionAdapter() {
	
			@Override
			public void mouseDragged(MouseEvent e) {
				if(cuadSeleccionado!=null) {
					Rectangle rCuad, rCirc;
					cuadSeleccionado.setPosX(e.getX()-despX);
					cuadSeleccionado.setPosY(e.getY()-despY);
					rCuad=cuadSeleccionado.getRect();
					//SI COLISIONA CON UN CIRCULO -> DESTACAR ESE CIRCULO (cambiar de color)
					//SI DEJA DE COLISIONAR CON UN CIRCULO -> DEJAR DE DESTACAR ESE CIRCULO
					circColisionado=null;
					for (Circulo c: areaDibujo.getArrayCirculos()) {
						rCirc=c.getRect();
						if(rCuad.intersects(rCirc) && !c.isEmparejado()) {
							c.setColor(Color.pink);
							circColisionado=c;
						}else {
							if(!c.isEmparejado()) {
								c.setColor(Color.orange);
							}
						}
					}
	
					areaDibujo.repaint();
				}
			}
		});
	}
}










