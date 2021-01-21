import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.GridLayout;
import java.awt.Font;

public class Ahorcado extends JFrame {
	private Fichero fichero;
	private TecladoVirtual teclado;
	private JButton btnSiguientePalabra;
	private JPanel panelJuego;
	private JPanel panel2;
	private EventosAhorcado eventosAhorcado;
	private AreaDibujo areaDibujo;
	private JPanel contentPane;
	private JLabel lblTitulo;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Ahorcado frame = new Ahorcado();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Ahorcado() {
		setTitle("El Ahorcado");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1230, 620);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		lblTitulo = new JLabel("El Ahorcado");
		lblTitulo.setFont(new Font("SansSerif", Font.BOLD | Font.ITALIC, 24));
		lblTitulo.setHorizontalAlignment(SwingConstants.CENTER);
		contentPane.add(lblTitulo, BorderLayout.NORTH);
		
		btnSiguientePalabra = new JButton("Siguiente Palabra");
		btnSiguientePalabra.setFocusable(false);
		btnSiguientePalabra.setEnabled(false);
		btnSiguientePalabra.setFont(new Font("SansSerif", Font.BOLD | Font.ITALIC, 16));
		contentPane.add(btnSiguientePalabra, BorderLayout.SOUTH);
		
		panelJuego = new JPanel();
		contentPane.add(panelJuego, BorderLayout.CENTER);
		panelJuego.setLayout(new GridLayout(0, 2, 0, 0));
		
		teclado = new TecladoVirtual(this);
		panelJuego.add(teclado);

		
		areaDibujo = new AreaDibujo();
		panelJuego.add(areaDibujo);
		areaDibujo.setBackground(Color.blue);
		
		fichero=new Fichero();		
		teclado.setPalabra(fichero.obtenerPalabra());
		teclado.ponerGuiones();
		
		eventosAhorcado = new EventosAhorcado(this, teclado);
	}

	public EventosAhorcado getEventosAhorcado() {
		return eventosAhorcado;
	}

	public void setEventosAhorcado(EventosAhorcado eventosAhorcado) {
		this.eventosAhorcado = eventosAhorcado;
	}

	public AreaDibujo getAreaDibujo() {
		return areaDibujo;
	}

	public void setAreaDibujo(AreaDibujo areaDibujo) {
		this.areaDibujo = areaDibujo;
	}

	public TecladoVirtual getTeclado() {
		return teclado;
	}

	public void setTeclado(TecladoVirtual teclado) {
		this.teclado = teclado;
	}

	public JButton getBtnSiguientePalabra() {
		return btnSiguientePalabra;
	}

	public void setBtnSiguientePalabra(JButton btnSiguientePalabra) {
		this.btnSiguientePalabra = btnSiguientePalabra;
	}

	public Fichero getFichero() {
		return fichero;
	}

	public void setFichero(Fichero fichero) {
		this.fichero = fichero;
	}

}
