import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.FileDialog;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JButton;

import java.awt.GridLayout;
import java.awt.Image;
import java.awt.FlowLayout;
import javax.swing.SwingConstants;

public class Xagu extends JFrame {
	public static final int FILAS=10;
	public static final int COLUMNAS=10;
	public static final String MURO="piedraTextura.jpg";
	public static final String XAGU="xagu.png";
	public static final String HIERBA="hierbaTextura.jpg";
	public static final String HIERBA2="hierbaTextura2.jpg";
	public static final String FIN="win.png";
	public static boolean salidaEncontrada=false;


	private JPanel contentPane;
	private JLabel [][] laberinto;
	private JPanel panelLaberinto;
	private JPanel panel;
	private JButton btnCargarMapa;
	private JButton btnBuscarSalida;
	private int filaXagu, colXagu;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Xagu frame = new Xagu();
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
	public Xagu() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 500, 500);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));

		panelLaberinto = new JPanel();
		contentPane.add(panelLaberinto, BorderLayout.CENTER);
		panelLaberinto.setLayout(new GridLayout(FILAS, COLUMNAS, 0, 0));

		panel = new JPanel();
		contentPane.add(panel, BorderLayout.SOUTH);
		panel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));

		btnCargarMapa = new JButton("Cargar Mapa");
		panel.add(btnCargarMapa);

		btnBuscarSalida = new JButton("Buscar Salida");
		panel.add(btnBuscarSalida);

		crearGrid();
		registrarEventos();
	}

	private void registrarEventos() {
		//CLICK EN EL BOTON PARA CARGAR UN MAPA
		btnCargarMapa.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				Scanner scFich;
				String strFich = "mapa1.txt", strLinea;
				int contLinea=0;

				ImageIcon imagen=new ImageIcon(MURO);
				ImageIcon imagen2=new ImageIcon(XAGU);
				ImageIcon imagen3=new ImageIcon(HIERBA);


				//ELEGIR EL ARCHIVO
				FileDialog dlgAbrir;
				dlgAbrir=new FileDialog(Xagu.this, "Cargar Mapa", FileDialog.LOAD);
				dlgAbrir.setVisible(true);

				//LEER CADA LINEA DEL FICHERO
				try {
					scFich=new Scanner(new File(strFich));
					do {
						strLinea=scFich.nextLine();
						for (int i = 0; i < COLUMNAS; i++) {
							if (strLinea.charAt(i)=='#') {
								laberinto[contLinea][i].setText("#");
								laberinto[contLinea][i].setIcon(imagen);
							}else if (strLinea.charAt(i)=='x') {
								laberinto[contLinea][i].setText("x");
								laberinto[contLinea][i].setIcon(imagen2);

								//POSICION INICIAL XAGU
								filaXagu=contLinea;
								colXagu=i;
							}else	{
								laberinto[contLinea][i].setText("");
								laberinto[contLinea][i].setIcon(imagen3);
							}

						}
						contLinea++;
					} while (scFich.hasNext());
				} catch (FileNotFoundException e) {
					e.printStackTrace();
				}
				//EN LA POSICION CORRESPONDIENTE A CADA CARACTER DE LA LINEA EN EL JLabel CORRESPONDIENTE DEL ARRAY PONDREMOS UNA IMAGEN O DEJAREMOS VACIO
			}
		});

		btnBuscarSalida.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				buscarSalida(laberinto, filaXagu, colXagu);
			}
		});
	}

	protected void buscarSalida(JLabel[][] laberinto, int filaXagu, int colXagu) {
		ImageIcon imagen=new ImageIcon(FIN);
		ImageIcon imagen2=new ImageIcon(HIERBA2);

			if (filaXagu==0 || filaXagu==FILAS-1 || colXagu==0 || colXagu==COLUMNAS-1) {
				laberinto[filaXagu][colXagu].setIcon(imagen);

				salidaEncontrada=true;
				return;
			}else {
				laberinto[filaXagu][colXagu].setText("-");
				//MOVER AL NORTE
				if (!salidaEncontrada && laberinto[filaXagu-1][colXagu].getText().equals("")) {
					buscarSalida(laberinto, filaXagu-1, colXagu);

				}	
				//MOVER AL SUR
				if (!salidaEncontrada && laberinto[filaXagu+1][colXagu].getText().equals("")) {
					buscarSalida(laberinto, filaXagu+1, colXagu);

				}
				//MOVER AL ESTE
				if (!salidaEncontrada && laberinto[filaXagu][colXagu+1].getText().equals("")) {
					buscarSalida(laberinto, filaXagu, colXagu+1);

				}
				//MOVER AL OESTE
				if (!salidaEncontrada && laberinto[filaXagu][colXagu-1].getText().equals("")) {
					buscarSalida(laberinto, filaXagu, colXagu-1);
				}
				//MARCAR CAMINO BUENO
				if (salidaEncontrada) {
					laberinto[filaXagu][colXagu].setText(":)");
					laberinto[filaXagu][colXagu].setIcon(imagen2);

				}
			}
		}
	

	public void crearGrid(){
		//CREAR 100 LABELS EN EJECUCION AÑADIENDOLOS AL ARRAYLABERINTO Y AL PANELLABERINTO
		JLabel lblAux;
		laberinto=new JLabel[FILAS][COLUMNAS];
		for (int i = 0; i < FILAS; i++) {
			for (int j = 0; j < COLUMNAS; j++) {
				lblAux = new JLabel("OwO");
				lblAux.setHorizontalAlignment(SwingConstants.CENTER);
				panelLaberinto.add(lblAux);
				laberinto [i][j]=lblAux;
			}
		}
	}

}
