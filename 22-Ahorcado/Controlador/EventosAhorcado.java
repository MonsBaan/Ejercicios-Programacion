import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

public class EventosAhorcado {
	private Ahorcado ahorcado;
	private Fichero fichero;
	private TecladoVirtual teclado;
	
	public EventosAhorcado(Ahorcado ahorcado, TecladoVirtual teclado) {
		this.ahorcado=ahorcado;
		this.teclado=teclado;
		
		ahorcado.getBtnSiguientePalabra().addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				String palabra;
				palabra = ahorcado.getFichero().obtenerPalabra();
				if (palabra==null) {
					JOptionPane.showMessageDialog(ahorcado, "No quedan palabras");
					ahorcado.getBtnSiguientePalabra().setEnabled(false);
				}else {
					teclado.estadoBotones(true);
					ahorcado.getBtnSiguientePalabra().setEnabled(false);
					ahorcado.getTeclado().setPalabra(palabra);
					ahorcado.getTeclado().ponerGuiones();
				}

			}
		});
	}
}
