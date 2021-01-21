import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class TecladoVirtual extends JPanel {
	public static final int ANCHO=50;
	public static final int ALTO=50;
	public static final int SEP=15;

	private JButton[] arrayTeclado;
	private JLabel lblPalabra;
	private EventosTeclado eventosTeclado;
	private String palabra;
	private Ahorcado ahorcado;
	
	/**
	 * Create the panel.
	 * @param ahorcado 
	 */
	public TecladoVirtual(Ahorcado ahorcado) {
		setLayout(null);
		this.setBounds(0, 0, 450, 600);
		lblPalabra = new JLabel("");
		lblPalabra.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblPalabra.setBounds(125, 25, 200, 70);
		this.add(lblPalabra);		
		
		this.ahorcado=ahorcado;
		crearTeclado();
		eventosTeclado=new EventosTeclado(this);
	}
		// TODO Auto-generated constructor stub
	
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
	
	public JButton[] getArrayTeclado() {
		return arrayTeclado;
	}
	public void setArrayTeclado(JButton[] arrayTeclado) {
		this.arrayTeclado = arrayTeclado;
	}
	public JLabel getLblPalabra() {
		return lblPalabra;
	}
	public void setLblPalabra(JLabel lblPalabra) {
		this.lblPalabra = lblPalabra;
	}
	public String getPalabra() {
		return palabra;
	}
	public void setPalabra(String palabra) {
		this.palabra = palabra;
	}
	public Ahorcado getAhorcado() {
		return ahorcado;
	}
	public void setAhorcado(Ahorcado ahorcado) {
		this.ahorcado = ahorcado;
	}
	
	public void ponerGuiones() {
		lblPalabra.setText("");
		for (int i = 0; i < palabra.length(); i++) {
			lblPalabra.setText(lblPalabra.getText()+"_ ");
		}
	}
	
	public void estadoBotones(boolean estado) {
		for (JButton jButton : arrayTeclado) {
			jButton.setEnabled(estado);
			
			if (estado) {
				jButton.setBackground(null);
			}
		}
		
	}


}
