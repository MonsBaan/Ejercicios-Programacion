import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class TresEnRaya extends JFrame {

	private JPanel contentPane;
	private JButton btn1;
	private JButton btn2;
	private JButton btn3;
	private JLabel lblJ1;
	private JButton btnColor1;
	private JButton btn4;
	private JButton btn5;
	private JButton btn6;
	private JLabel lblJ2;
	private JButton btnColor2;
	private JButton btn7;
	private JButton btn8;
	private JButton btn9;
	private JButton btnNueva;
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
					TresEnRaya frame = new TresEnRaya();
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
	public TresEnRaya() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 730, 473);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		this.setContentPane(contentPane);
		contentPane.setLayout(new GridLayout(3, 5, 0, 0));
		
		btn1 = new JButton("");
		contentPane.add(btn1);
		
		btn2 = new JButton("");
		contentPane.add(btn2);
		
		btn3 = new JButton("");
		contentPane.add(btn3);
		
		lblJ1 = new JLabel("Jug1");
		lblJ1.setHorizontalAlignment(SwingConstants.CENTER);
		contentPane.add(lblJ1);
		
		btnColor1 = new JButton("");
		btnColor1.setBackground(Color.RED);
		contentPane.add(btnColor1);
		
		btn4 = new JButton("");
		contentPane.add(btn4);
		
		btn5 = new JButton("");
		contentPane.add(btn5);
		
		btn6 = new JButton("");
		contentPane.add(btn6);
		
		lblJ2 = new JLabel("Jug2");
		lblJ2.setHorizontalAlignment(SwingConstants.CENTER);
		contentPane.add(lblJ2);
		
		btnColor2 = new JButton("");
		btnColor2.setBackground(Color.BLUE);
		contentPane.add(btnColor2);
		
		btn7 = new JButton("");
		contentPane.add(btn7);
		
		btn8 = new JButton("");
		contentPane.add(btn8);
		
		btn9 = new JButton("");
		contentPane.add(btn9);
		
		btnNueva = new JButton("Nueva partida");
		contentPane.add(btnNueva);
		
		btnSalir = new JButton("Salir");
		contentPane.add(btnSalir);
		inicializar();
		registrarEventos();
	}//FIN DEL CONSTRUCTOR

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
		resaltarTextoJugador();
	}

	private void resaltarTextoJugador() {
		if(turno==1) {
			lblJ1.setFont(new Font("Arial", Font.BOLD | Font.ITALIC, 18));
			lblJ1.setForeground(btnColor1.getBackground());
			lblJ2.setFont(new Font("Arial", Font.PLAIN, 10));
			lblJ2.setForeground(Color.BLACK);
		}
	}

	private void registrarEventos() {
		//CLIK EN EL BOTON SALIR
		btnSalir.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if(JOptionPane.showConfirmDialog(TresEnRaya.this, 
								"Seguro que quieres salir?",
								"Salir",
								JOptionPane.YES_NO_OPTION)==JOptionPane.YES_OPTION) {
					System.exit(0);
				}
			}
		});
		
		//REGISTRAR EVENTOS CLICK EN CADA BOTON DE LAS FICHAS
		for (int i = 0; i < arrayBotones.length; i++) {
			arrayBotones[i].addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					/*PONER COLOR AL BOTÓN PULSADO SEGÚN EL TURNO
					 * DESCATIVAR EL BOTON PULSADO
					 * COMPROBAR SI LA PARTIDA HA FINALIZADO (FUNCIÓN)					 *
					 * SI HA FINALIZADO HACER ???????
					 * SI NO HA FINALIZADO --> CAMBIAR TURNO 
					 */
					JButton btn;
					btn=(JButton)e.getSource();
					if(turno==1) {
						btn.setBackground(btnColor1.getBackground());
					}else {
						btn.setBackground(btnColor2.getBackground());
					}
					numFichas++;
					btn.setEnabled(false);
					
					//COMPROBAR
					int res;
					res=comprobar();
					if(res==2) {
						JOptionPane.showMessageDialog(TresEnRaya.this, "TABLAS");
						
					}else if(res==1) {//HA GANADO UN JUGADOR
							//MENSAJE INDICANDO EL GANADOR
							//DESACTIVAR TOOOOOOODOS LOS BOTONES DE LAS FICHAS
							//ACTIVAR NUEVA PARTIDA y LOS LABEL
							if(turno==1) {
								JOptionPane.showMessageDialog(TresEnRaya.this, "Ganador: "+lblJ1.getText().toUpperCase(), 
																"Winner", JOptionPane.OK_OPTION);
							}else {
								JOptionPane.showMessageDialog(TresEnRaya.this, "Ganador: "+lblJ2.getText().toUpperCase(), 
										"Winner", JOptionPane.OK_OPTION);
							}
							estadoBotones(false);
							btnNueva.setEnabled(true);
							lblJ1.setEnabled(true);
							lblJ2.setEnabled(true);
					}
					turno=turno%2+1;
				}
			});
		}
		//PARA CAMBIAR NOMBRE DE LOS JUGADORES
		lblJ1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String nombre;
				if(!lblJ1.isEnabled()) {
					return;
				}
				do {
					//LO QUE DEVUELVA JOptionPane.showInputDialog
					nombre=JOptionPane.showInputDialog(null,"Introduce el nombre del J1:",
							"Nombre Jugador", JOptionPane.OK_CANCEL_OPTION);
					//si ese nombre no lo tiene el jugador 2 lo damos por bueno para el jug 1 y 
					//lo asignamos al label correspondiente
					if(nombre==null){
						break;
					}
				}while(nombre.trim().equalsIgnoreCase(lblJ2.getText()) || nombre.trim().equals(""));

				if(nombre!=null && !nombre.trim().equals("")) {
					lblJ1.setText(nombre.trim());
				}
			}
		});
		
		lblJ2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String nombre;
				if(!lblJ2.isEnabled()) {
					return;
				}
				do {
					//LO QUE DEVUELVA JOptionPane.showInputDialog
					nombre=JOptionPane.showInputDialog(null,"Introduce el nombre del J2:",
							"Nombre Jugador", JOptionPane.OK_CANCEL_OPTION);
					//si ese nombre no lo tiene el jugador 2 lo damos por bueno para el jug 1 y 
					//lo asignamos al label correspondiente
					if(nombre==null){
						break;
					}
				}while(nombre.trim().equalsIgnoreCase(lblJ1.getText()) || nombre.trim().equals(""));

				if(nombre!=null && !nombre.trim().equals("")) {
					lblJ2.setText(nombre.trim());
				}
			}
		});
		
		//CLICK BOTON NUEVA PARTIDA:
			//HABILITAR LOS 9 BOTONES
			//DESHABILITAR LOS Label DE LOS NOMBRES DE LOS JUGADORES
			//DESHABILITAR LOS DOS BOTONES DE LOS COLORES DE LAS FICHAS DE LOS JUGADORES
			//DESABILITAR EL PROPIO BOTON Nueva Partida
		btnNueva.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				inicializar();
				estadoBotones(true);
				lblJ1.setEnabled(false);
				lblJ2.setEnabled(false);
				btnColor1.setEnabled(false);
				btnColor2.setEnabled(false);
				btnNueva.setEnabled(false);
			}
		});
		
	}//FIN DE REGISTRAR EVENTOS
	
	//UNA SOLA FUNCION QUE HABILITE O DESHABILITE LOS 9 BOTONES
	public void estadoBotones(boolean estado) {
		for (int i = 0; i < arrayBotones.length; i++) {
			arrayBotones[i].setEnabled(estado);
		}
	}

	
	public int comprobar() {
		//DEVUELVE :
		//1 --> GANA UNO DE LOS DOS JUGADORES
		//2 --> HAY TABLAS
		//0 --> LA PARTIDA CONTINUA (NO HAY 3 EN RAYA Y EL TABLERO NO ESTA LLENO)
		//COMPROBAR FILAS
		for (int fila = 0; fila < 3; fila++) {	
			
			if(arrayBotones[(fila*3)+0].getBackground()==arrayBotones[(fila*3)+1].getBackground() &&
				arrayBotones[(fila*3)+0].getBackground()==arrayBotones[(fila*3)+2].getBackground() &&
				arrayBotones[(fila*3)+0].getBackground()!=btnSalir.getBackground()) {
				return 1;
			}
		}
		//COMPROBAR COLUMNAS
		for(int col=0;col<3;col++) {
			if(arrayBotones[0+col].getBackground()==arrayBotones[3+col].getBackground() &&
					arrayBotones[0+col].getBackground()==arrayBotones[6+col].getBackground() &&
					arrayBotones[0+col].getBackground()!=btnSalir.getBackground()) {
					return 1;
			}
		}
		//DIAGONAL 1
		if(arrayBotones[0].getBackground()==arrayBotones[4].getBackground() &&
				arrayBotones[0].getBackground()==arrayBotones[8].getBackground() &&
				arrayBotones[0].getBackground()!=btnSalir.getBackground()) {
				return 1;
		}
		//DIAGONAL 2
		if(arrayBotones[2].getBackground()==arrayBotones[4].getBackground() &&
				arrayBotones[2].getBackground()==arrayBotones[6].getBackground() &&
				arrayBotones[2].getBackground()!=btnSalir.getBackground()) {
				return 1;
		}
		
		//SI LLEGAMOS AQUI ES PORQUE NO HAY 3 EN RAYA
		//COMPROBAR TABLAS
		if(numFichas==9) {
			return 2;
		}
		
		return 0;
	}
}















