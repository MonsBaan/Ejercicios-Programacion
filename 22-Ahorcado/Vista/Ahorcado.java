import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import javax.swing.JSplitPane;
import java.awt.GridLayout;
import java.awt.Font;

public class Ahorcado extends JFrame {
	private TecladoVirtual teclado;
	private JPanel contentPane;
	private JLabel lblTitulo;
	private JButton btnSiguientePalabra;
	private JPanel panelJuego;
	private JPanel panel1;
	private JPanel panel2;

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
		setBounds(100, 100, 750, 550);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		lblTitulo = new JLabel("El Ahorcado");
		lblTitulo.setFont(new Font("Rockwell Condensed", Font.BOLD | Font.ITALIC, 26));
		lblTitulo.setHorizontalAlignment(SwingConstants.CENTER);
		contentPane.add(lblTitulo, BorderLayout.NORTH);
		
		btnSiguientePalabra = new JButton("Siguiente Palabra");
		btnSiguientePalabra.setFont(new Font("Rockwell Condensed", Font.BOLD | Font.ITALIC, 16));
		contentPane.add(btnSiguientePalabra, BorderLayout.SOUTH);
		
		panelJuego = new JPanel();
		contentPane.add(panelJuego, BorderLayout.CENTER);
		panelJuego.setLayout(new GridLayout(1, 0, 0, 0));
		
		panel1 = new JPanel();
		panelJuego.add(panel1);
		
		panel2 = new JPanel();
		panelJuego.add(panel2);
		
		teclado = new TecladoVirtual();
	}

}
