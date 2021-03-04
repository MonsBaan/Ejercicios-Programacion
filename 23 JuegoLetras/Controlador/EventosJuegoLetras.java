import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class EventosJuegoLetras {

	private JuegoLetras juegoLetras;
	
	public EventosJuegoLetras(JuegoLetras juegoLetras) {
		this.juegoLetras=juegoLetras;
		
		this.juegoLetras.getBtnComenzar().addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				//PASAR EL NIVEL A AreaDibujo
				if(juegoLetras.getRbFacil().isSelected()) {
					juegoLetras.getAreaDibujo().setNivel(1);
				}else if(juegoLetras.getRbMedio().isSelected()) {
					juegoLetras.getAreaDibujo().setNivel(2);
				}else {
					juegoLetras.getAreaDibujo().setNivel(3);
				}
				
				//LLAMAR A CREAR LOS CIRCULOS
				juegoLetras.getAreaDibujo().crearCirculos();
				//LLAMAR A CREAR LOS CUADRADOS
				juegoLetras.getAreaDibujo().crearCuadrados();
				
				juegoLetras.getAreaDibujo().setAciertos(0);
				juegoLetras.getAreaDibujo().setFallos(0);
				
				juegoLetras.getAreaDibujo().repaint();
				
				juegoLetras.estadoBotones(false);
				
				juegoLetras.getAreaDibujo().getReloj().stop();//DETENER ANIMACION
			}
		});
		
		juegoLetras.getBtnComprobar().addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				int aciertos, fallos;
				aciertos=0;
				fallos=0;
				//RECORRER TODOS LOS CIRCULOS DEL ARRAY, Y PONER EN ROJO LOS CUADRADOS EMPAREJADOS CON
				//ESE CIRCULO QUE SEAN INCORRECTOS, Y EN VERDE LOS CORRECTOS
				for(Circulo circ:juegoLetras.getAreaDibujo().getArrayCirculos()) {
					if(circ.getLetra().equalsIgnoreCase(circ.getPareja().getLetra())) {
						circ.getPareja().setColor(Color.GREEN);
						aciertos++;
					}else {
						circ.getPareja().setColor(Color.RED);
						fallos++;
					}
				}
				
				//MENSAJE
				juegoLetras.getAreaDibujo().setAciertos(aciertos);
				juegoLetras.getAreaDibujo().setFallos(fallos);
				
				//REPINTAR EL CANVAS
				juegoLetras.getAreaDibujo().repaint();
				//activar controles del JFrame
				juegoLetras.estadoBotones(true);
				//desactiar el botón de comprobar
				juegoLetras.getBtnComprobar().setEnabled(false);
			}
		});
		
		
	}//FIN DEL CONSTRUCTOR
}







