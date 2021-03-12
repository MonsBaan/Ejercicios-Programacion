import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Toolkit;

public class MainJuego extends JFrame {

	private JPanel contentPane;
	private ZonaJuego zonaJuego;
	private Menu menu;
	private int estadoJuego;//0 - Menu, 1 - Juego

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainJuego frame = new MainJuego();
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
	public MainJuego() {
		setTitle("Chaka-Pang");
		setIconImage(Toolkit.getDefaultToolkit().getImage(MainJuego.class.getResource("/Enemigos/Bola3.png")));
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 700, 515);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		estadoJuego = 1;
		
		switch (estadoJuego) {
		case 0:
			menu = new Menu();
			contentPane.add(menu);
			menu.setFocusable(true);
			break;
		case 1:
			zonaJuego = new ZonaJuego();
			contentPane.add(zonaJuego);
			zonaJuego.setFocusable(true);
			zonaJuego.requestFocus();
			break;

		default:
			break;
		}
		

		
		
		
	}

}
