import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;

public class TresEnRayaPanel extends JFrame {

	private JPanel contentPane;
	private JButton btn1;
	private JButton btn2;
	private JButton btn3;
	private JLabel lbl1;
	private JButton btnJug1;
	private JButton btn4;
	private JButton btn5;
	private JButton btn6;
	private JLabel lbl2;
	private JButton btnJug2;
	private JButton btn7;
	private JButton btn8;
	private JButton btn9;
	private JButton btnNuevaPartida;
	private JButton btnSalir;
	private JButton[] arrayBotones;
	private int turno; //1 juega J1, 2 juega J2
	private int numFichas;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TresEnRayaPanel frame = new TresEnRayaPanel();
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
	public TresEnRayaPanel() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 651, 437);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new GridLayout(3, 6, 0, 0));

		btn1 = new JButton("");
		contentPane.add(btn1);

		btn2 = new JButton("");
		contentPane.add(btn2);

		btn3 = new JButton("");
		contentPane.add(btn3);

		lbl1 = new JLabel("Jugador 1");
		lbl1.setHorizontalAlignment(SwingConstants.CENTER);
		contentPane.add(lbl1);

		btnJug1 = new JButton("");
		contentPane.add(btnJug1);

		btn4 = new JButton("");
		contentPane.add(btn4);

		btn5 = new JButton("");
		contentPane.add(btn5);

		btn6 = new JButton("");
		contentPane.add(btn6);

		lbl2 = new JLabel("Jugador 2");
		lbl2.setHorizontalAlignment(SwingConstants.CENTER);
		contentPane.add(lbl2);

		btnJug2 = new JButton("");
		contentPane.add(btnJug2);

		btn7 = new JButton("");
		contentPane.add(btn7);

		btn8 = new JButton("");
		contentPane.add(btn8);

		btn9 = new JButton("");
		contentPane.add(btn9);

		btnNuevaPartida = new JButton("Nueva Partida");
		contentPane.add(btnNuevaPartida);

		btnSalir = new JButton("Salir");
		contentPane.add(btnSalir);

		inicializar();
		registrarEventos();
	}//CONSTRUCTOR FIN

	private void inicializar() {
		Random r;
		//METER LOS 9 BOTONES EN EL ARRAY
		arrayBotones=new JButton[9];
		arrayBotones[0]=btn1;
		arrayBotones[1]=btn2;
		arrayBotones[2]=btn3;
		arrayBotones[3]=btn4;
		arrayBotones[4]=btn5;
		arrayBotones[5]=btn6;
		arrayBotones[6]=btn7;
		arrayBotones[7]=btn8;
		arrayBotones[8]=btn9;

		//RESTAURAR PARA TODOS LOS BOTONES EL COLOR O ASPECTO INICIAL
		for (int i = 0; i < arrayBotones.length; i++) {
			arrayBotones[i].setBackground(btnSalir.getBackground());
		}

		numFichas=0;
		r=new Random();
		turno=r.nextInt(2)+1;
		estadoBotones(false);
	}//INICIALIZAR FIN

	private void registrarEventos() {
		//CLICK EN EL BOTON SALIR
		btnSalir.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if(JOptionPane.showConfirmDialog(TresEnRayaPanel.this, 
						"Seguro que quieres salir?",
						"Salir",
						JOptionPane.YES_NO_OPTION)==JOptionPane.YES_OPTION) {
					System.exit(0);
				}
			}
		});	
		//CAMBIAR LABEL DE JUGADORES
		lbl1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String nombre;
				if (!lbl1.isEnabled()) {
					return;
				}
				nombre=JOptionPane.showInputDialog("Introduce el nombre");
				//--REPETIR EN CASO DE QUE EL CAMPO SEA NULO O IGUAL A JUGADOR 2
				do {
					if (nombre==null) {
						break;
					}
					nombre=JOptionPane.showInputDialog("Nombre de Jugador 1 y 2 son iguales");
				} while (nombre.trim().equalsIgnoreCase(lbl2.getText()) || nombre.trim().equals(""));
				lbl1.setText(nombre);
			}
		});
		lbl2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String nombre;
				if (!lbl2.isEnabled()) {
					return;
				}
				nombre=JOptionPane.showInputDialog("Introduce el nombre");
				//--REPETIR EN CASO DE QUE EL CAMPO SEA NULO O IGUAL A JUGADOR 2

				do {
					if (nombre==null) {
						break;
					}
					nombre=JOptionPane.showInputDialog("Nombre de Jugador 1 y 2 son iguales");
				} while (nombre.trim().equalsIgnoreCase(lbl1.getText()) || nombre.trim().equals(""));
				lbl2.setText(nombre);
			}
		});

		//CLICK BOTON NUEVA PARTIDA
		//--HABILITA LOS BOTONES DEL JUEGO Y DESHABILITA EL RESTO
		btnNuevaPartida.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				inicializar();
				estadoBotones(true);
				lbl1.setEnabled(false);
				lbl2.setEnabled(false);
				btnJug1.setEnabled(false);
				btnJug2.setEnabled(false);
				btnNuevaPartida.setEnabled(false);

			}
		});

	}//REGISTRAREVENTOS FIN

	//FUNCION QUE HABILITE TODOS LOS BOTONES (DE JUEGO)
	public void estadoBotones(boolean estado) {
		for (int i = 0; i < arrayBotones.length; i++) {
			arrayBotones[i].setEnabled(estado);
		}
	}
}
