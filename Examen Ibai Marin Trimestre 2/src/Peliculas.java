import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import java.awt.Color;
import javax.swing.border.CompoundBorder;
import javax.swing.border.LineBorder;


import javax.swing.JComboBox;
import javax.swing.JList;
import javax.swing.JSpinner;
import javax.swing.JScrollPane;

public class Peliculas extends JFrame {

	private JPanel contentPane;
	private JButton btnTodos;
	private JButton btnA;
	private JButton btnE;
	private JButton btnI;
	private JButton btnO;
	private JButton btnU;
	private JComboBox <String> cbAño;
	private JButton btnPasar1;
	private JButton btnPasar2;
	private JButton btnGuardar;
	private JSpinner spinner;
	private JList listBBDD;
	private JList listGuardar;
	private BaseDatos bd;
	private ResultSet rs;
	private DefaultListModel<String> modelo1, modelo2;
	private JScrollPane spListBBDD;
	private JScrollPane spGuardar;
	private ArrayList<String> arrayList1, arrayList2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Peliculas frame = new Peliculas();
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
	public Peliculas() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 822, 524);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lbl1 = new JLabel("Cargar de la Base de Datos");
		lbl1.setBounds(40, 11, 160, 14);
		contentPane.add(lbl1);

		btnTodos = new JButton("Todos");

		btnTodos.setBounds(20, 36, 226, 23);
		contentPane.add(btnTodos);

		btnA = new JButton("A");

		btnA.setBounds(20, 59, 45, 23);
		contentPane.add(btnA);

		btnE = new JButton("E");
		btnE.setBounds(65, 59, 45, 23);
		contentPane.add(btnE);

		btnI = new JButton("I");
		btnI.setBounds(109, 59, 45, 23);
		contentPane.add(btnI);

		btnO = new JButton("O");
		btnO.setBounds(155, 59, 45, 23);
		contentPane.add(btnO);

		btnU = new JButton("U");
		btnU.setBounds(201, 59, 45, 23);
		contentPane.add(btnU);


		JLabel lblAño = new JLabel("A\u00F1o:");
		lblAño.setBounds(18, 440, 46, 14);
		contentPane.add(lblAño);

		cbAño = new JComboBox();
		cbAño.setBounds(51, 436, 137, 22);
		contentPane.add(cbAño);

		btnPasar1 = new JButton(">>");
		btnPasar1.setBounds(256, 231, 59, 23);
		contentPane.add(btnPasar1);

		btnPasar2 = new JButton(">>");
		btnPasar2.setBounds(524, 231, 59, 23);
		contentPane.add(btnPasar2);

		btnGuardar = new JButton("Guardar");
		btnGuardar.setBounds(365, 436, 89, 23);
		contentPane.add(btnGuardar);

		spinner = new JSpinner();
		spinner.setBounds(524, 200, 59, 20);
		contentPane.add(spinner);

		spListBBDD = new JScrollPane();
		spListBBDD.setBounds(20, 93, 226, 327);
		contentPane.add(spListBBDD);


		listBBDD = new JList();
		spListBBDD.setViewportView(listBBDD);
		modelo1=new DefaultListModel<String>();
		listBBDD.setModel(modelo1);

		spGuardar = new JScrollPane();
		spGuardar.setBounds(330, 93, 184, 332);
		contentPane.add(spGuardar);


		listGuardar = new JList();
		spGuardar.setViewportView(listGuardar);
		modelo2=new DefaultListModel<String>();
		listGuardar.setModel(modelo2);

		arrayList1=new ArrayList<String>();

		arrayList2=new ArrayList<String>();

		inicializar();
		registrarEventos();
	}

	private void inicializar() {
		cargarAños();
		bd=new BaseDatos();
		bd.conectar();
	}

	private void cargarAños() {
		cbAño.addItem("Desconocido");

		for (int i = 1930; i <= 2035; i++) {
			cbAño.addItem(i+"");
		}
		cbAño.setSelectedItem(2021+"");
	}

	private void cargarListBBDD() {
		rs=bd.obtenerDatos();
		try {


			rs.first();
			do {

				arrayList1.add(rs.getString("titulo"));
				modelo1.addElement(rs.getString("titulo"));

			} while (rs.next());





		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private void registrarEventos() {
		btnTodos.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				cargarListBBDD();
				btnTodos.setEnabled(false);
				btnA.setEnabled(false);
				btnE.setEnabled(false);
				btnI.setEnabled(false);
				btnO.setEnabled(false);
				btnU.setEnabled(false);
			}
		});//FIN btnTodos	
		btnA.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				btnA.setEnabled(false);
				rs=bd.obtenerDatosLetra(btnA.getText());
				try {
					rs.first();
					do {
						arrayList1.add(rs.getString("titulo"));
						modelo1.addElement(rs.getString("titulo"));
					} while (rs.next());
					rs.first();


				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}	
			}
		});
		btnE.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				btnE.setEnabled(false);
				rs=bd.obtenerDatosLetra(btnE.getText());
				try {
					rs.first();
					do {
						arrayList1.add(rs.getString("titulo"));
						modelo1.addElement(rs.getString("titulo"));
					} while (rs.next());
					rs.first();


				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}				
			}
		});
		btnI.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				btnI.setEnabled(false);
				rs=bd.obtenerDatosLetra(btnI.getText());
				try {
					rs.first();
					do {
						arrayList1.add(rs.getString("titulo"));
						modelo1.addElement(rs.getString("titulo"));
					} while (rs.next());
					rs.first();


				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}				}
		});
		btnO.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				btnO.setEnabled(false);
				rs=bd.obtenerDatosLetra(btnO.getText());
				try {
					rs.first();
					do {
						arrayList1.add(rs.getString("titulo"));
						modelo1.addElement(rs.getString("titulo"));
					} while (rs.next());
					rs.first();


				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}				}
		});
		btnU.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				btnU.setEnabled(false);
				rs=bd.obtenerDatosLetra(btnU.getText());
				try {
					rs.first();
					do {
						arrayList1.add(rs.getString("titulo"));
						modelo1.addElement(rs.getString("titulo"));
					} while (rs.next());
					rs.first();


				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}				}
		});
		btnPasar1.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				String titulo, año, peliculaAño;

				titulo=arrayList1.get(listBBDD.getSelectedIndex());
				año=(String) cbAño.getSelectedItem();
				if (año.equals("Desconocido")) {
					año = "????";
				}
				peliculaAño = año+" - "+ titulo;
				arrayList2.add(peliculaAño);
				System.out.println(peliculaAño);
				modelo2.addElement(peliculaAño);
			}
		});
		btnGuardar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				try {
					PrintWriter guardar = new PrintWriter("peliculas.txt");
					for (String string : arrayList2) {						
						guardar.println(string);
					}
					guardar.close();
				} catch (FileNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});






	}//FIN DE registrarEventos
}
