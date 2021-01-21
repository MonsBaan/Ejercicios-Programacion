import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

public class EventosTeclado {

	private TecladoVirtual teclado;
	private Ahorcado ahorcado;
	private static final int maxFallos=7;
	private static int contFallos=0;
	private static int cont=0;
	
	public EventosTeclado(TecladoVirtual teclado) {
		this.teclado=teclado;
		JButton[] tecladoButtons = teclado.getArrayTeclado();



		/*
		 * REGISTRAR EVENTOS PARA LOS 27 BOTONES
		 * PARA CADA BOTON:
		 * 		REGISTRAR EVENTO
		 * 			DESACTIVAR BOTON
		 * 			SI LA LETRA ESTA:
		 * 				PONER BOTON VERDE
		 * 				SUSTITUIR EN EL JLABEL CADA APARICION DE LA LETRA
		 * 				COMPROBAR SI LA PALABRA ESTA COMPLETADA
		 * 			SI LA LETRA NO ESTÁ:
		 * 				PONER BOTON ROJO
		 * 				INCREMENTAR NUMERO DE FALLOS
		 * 				ACTUALIZAR CANVAS
		 * 				COMPROBAR SI MAX FALLOS ALCANZADO
		 */
		for (JButton boton : tecladoButtons) {
			boton.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent arg0) {
					boton.setEnabled(false);

					if (!teclado.getPalabra().toUpperCase().contains(boton.getText())) {//FALLAR LETRA
						boton.setBackground(Color.red);
						contFallos++;

						switch (contFallos) {
						case maxFallos:
							teclado.estadoBotones(false);
							teclado.getAhorcado().getBtnSiguientePalabra().setEnabled(true);
							teclado.getLblPalabra().setText(teclado.getPalabra());
							contFallos=0;
							break;

						default:
							break;
						}

					}else {//ACERTAR LETRA
						char letraBoton;
						char[] lblPalabraArray = teclado.getLblPalabra().getText().replaceAll(" ", "").toCharArray();

						int contLetrasPalabra = 0;
						for (int i = 0; i < teclado.getPalabra().length(); i++) {
							contLetrasPalabra++;
						}
						
						boton.setBackground(Color.green);
						boton.getText();
						letraBoton=boton.getText().charAt(0);
						
						
						for (int i = 0; i < teclado.getPalabra().length(); i++) {
							for (int j = 0; j < lblPalabraArray.length; j++) {
								if (teclado.getPalabra().charAt(i)==letraBoton) {
									lblPalabraArray[i]=letraBoton;
								}
							}
						}

						String palabraAdivinar = String.valueOf(lblPalabraArray);
						teclado.getLblPalabra().setText(palabraAdivinar);
						
						if (teclado.getLblPalabra().getText().toUpperCase().equals(teclado.getPalabra().toUpperCase())) {
							teclado.estadoBotones(false);
							teclado.getAhorcado().getBtnSiguientePalabra().setEnabled(true);
						}


					}





				}
			});
		}

	}
}
