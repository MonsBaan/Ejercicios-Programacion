import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class TecladoVirtual extends JPanel {
	public static final int ANCHO=40;
	public static final int ALTO=40;
	public static final int SEP=15;

	private JButton[] arrayTeclado;
	private JLabel lblPalabra;
	private EventosTeclado eventosTeclado;

	/**
	 * Create the panel.
	 */
	public TecladoVirtual() {
		setLayout(null);
		this.setBounds(0, 0, 450, 600);
		JLabel lblPalabra = new JLabel("_ _ _ _ _ _ _ _ _ _");
		lblPalabra.setFont(new Font("Tahoma", Font.BOLD, 22));
		lblPalabra.setBounds(50, 50, 194, 67);
		this.add(lblPalabra);		
		
		
		
		crearTeclado();
		eventosTeclado=new EventosTeclado(this);
	}
	private void crearTeclado() {
		int inc = 0;
		arrayTeclado=new JButton[27];
		JButton btnAux;
		
		for (int i = 0; i < arrayTeclado.length; i++) {
			btnAux=new JButton();
			if (i==0) {
				btnAux.setBounds(80, 100, ANCHO, ALTO);
			}else if (i%5==0) {
				btnAux.setBounds(arrayTeclado[i-5].getX(), arrayTeclado[i-5].getY()+ALTO+SEP, ANCHO, ALTO);
			}else {
				btnAux.setBounds(arrayTeclado[i-1].getX()+ANCHO+SEP, arrayTeclado[i-1].getY(), ANCHO, ALTO);
			}
			if (i==14) {
				inc=1;
				btnAux.setText("Ñ");
			}else {
				btnAux.setText((char)('A'+i-inc)+"");
			}
			
			arrayTeclado[i]=btnAux;
			this.add(btnAux);
		}
		
	}
	
	public void estadoBotones(boolean estado) {
		JButton btnAux;
		for (int i = 0; i < arrayTeclado.length; i++) {
			
		}
	}


}
