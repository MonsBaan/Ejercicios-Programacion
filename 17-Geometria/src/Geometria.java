import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.event.ListSelectionListener;
import javax.swing.event.ListSelectionEvent;
import javax.swing.SwingConstants;

public class Geometria extends JFrame {

	private JPanel contentPane;
	private Punto p1;
	private Punto p2;
	private Circulo p3;
	private JScrollPane scrollPane2;
	private JList lstPuntos1;
	private JList lstPuntos2;
	private JLabel lblPuntoInicial;
	private JScrollPane scrollPane1;
	private JLabel lblPuntoFinal;
	private JLabel lblDistancia;
	private JButton btnCalcularDistancia;
	private JTextField textDistancia;
	private ArrayList<Punto> arrayPuntos1, arrayPuntos2;
	private ArrayList<Circulo> arrayCirculos;
	private DefaultListModel<String> modelo1, modelo2, modelo3;
	private JLabel lblCirculo;
	private JScrollPane scrollPane3;
	private JList lstCirculos;
	private JTextField textDistanciaCirculo;
	private JTextField textDistMax;
	private JButton btnCalcularDistMax;
	private JButton btnCalcularDistCirc;
	private JLabel lblDistanciaMax;
	private JLabel lblNewLabel;


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Geometria frame = new Geometria();
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
	public Geometria() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 698, 482);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		scrollPane2 = new JScrollPane();
		scrollPane2.setBounds(10, 11, 117, 204);
		contentPane.add(scrollPane2);

		lstPuntos1 = new JList();

		scrollPane2.setViewportView(lstPuntos1);
		modelo1=new DefaultListModel<String>();
		lstPuntos1.setModel(modelo1);

		lblPuntoInicial = new JLabel("Puntos Iniciales");
		lblPuntoInicial.setHorizontalAlignment(SwingConstants.CENTER);
		scrollPane2.setColumnHeaderView(lblPuntoInicial);

		scrollPane1 = new JScrollPane();
		scrollPane1.setBounds(10, 226, 117, 204);
		contentPane.add(scrollPane1);

		lstPuntos2 = new JList();
		scrollPane1.setViewportView(lstPuntos2);
		modelo2=new DefaultListModel<String>();
		lstPuntos2.setModel(modelo2);

		lblPuntoFinal = new JLabel("Puntos Finales");
		lblPuntoFinal.setHorizontalAlignment(SwingConstants.CENTER);
		scrollPane1.setColumnHeaderView(lblPuntoFinal);

		textDistancia = new JTextField();
		textDistancia.setBounds(173, 35, 86, 20);
		contentPane.add(textDistancia);
		textDistancia.setColumns(10);

		lblDistancia = new JLabel("Distancia");
		lblDistancia.setBounds(194, 11, 65, 14);
		contentPane.add(lblDistancia);

		btnCalcularDistancia = new JButton("Calcular");
		btnCalcularDistancia.setEnabled(false);
		btnCalcularDistancia.setBounds(173, 66, 86, 23);
		contentPane.add(btnCalcularDistancia);

		scrollPane3 = new JScrollPane();
		scrollPane3.setBounds(316, 11, 170, 194);
		contentPane.add(scrollPane3);

		lstCirculos = new JList();
		scrollPane3.setViewportView(lstCirculos);
		modelo3=new DefaultListModel<String>();
		lstCirculos.setModel(modelo3);

		lblCirculo = new JLabel("Circulos");
		lblCirculo.setHorizontalAlignment(SwingConstants.CENTER);
		scrollPane3.setColumnHeaderView(lblCirculo);

		textDistanciaCirculo = new JTextField();
		textDistanciaCirculo.setBounds(173, 169, 86, 20);
		contentPane.add(textDistanciaCirculo);
		textDistanciaCirculo.setColumns(10);

		lblNewLabel = new JLabel("Distancia del punto al circulo");
		lblNewLabel.setBounds(137, 144, 169, 14);
		contentPane.add(lblNewLabel);

		lblDistanciaMax = new JLabel("Distancia Max");
		lblDistanciaMax.setBounds(519, 11, 86, 14);
		contentPane.add(lblDistanciaMax);

		btnCalcularDistCirc = new JButton("Calcular");
		btnCalcularDistCirc.setEnabled(false);
		btnCalcularDistCirc.setBounds(170, 200, 89, 23);
		contentPane.add(btnCalcularDistCirc);

		textDistMax = new JTextField();
		textDistMax.setBounds(519, 34, 86, 20);
		contentPane.add(textDistMax);
		textDistMax.setColumns(10);

		btnCalcularDistMax = new JButton("Calcular");
		btnCalcularDistMax.setBounds(519, 65, 89, 23);
		contentPane.add(btnCalcularDistMax);


		crearObjetos();
		registrarEventos();
	}

	private void registrarEventos() {
		lstPuntos1.addListSelectionListener(new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent arg0) {
				if (lstPuntos1.getSelectedIndex()!=-1 && lstPuntos2.getSelectedIndex()!=-1) {
					btnCalcularDistancia.setEnabled(true);
				} 
				if (lstPuntos1.getSelectedIndex()!=-1 && lstCirculos.getSelectedIndex()!=-1) {
					btnCalcularDistCirc.setEnabled(true);
				} 

			}
		});
		lstPuntos2.addListSelectionListener(new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent arg0) {
				if (lstPuntos1.getSelectedIndex()!=-1 && lstPuntos2.getSelectedIndex()!=-1) {
					btnCalcularDistancia.setEnabled(true);
				}
			}
		});
		lstCirculos.addListSelectionListener(new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent arg0) {
				if (lstPuntos1.getSelectedIndex()!=-1 && lstCirculos.getSelectedIndex()!=-1) {
					btnCalcularDistCirc.setEnabled(true);
				} 
			}
		});
		btnCalcularDistancia.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				Punto punto1, punto2;
				punto1=arrayPuntos1.get(lstPuntos1.getSelectedIndex());
				punto2=arrayPuntos2.get(lstPuntos2.getSelectedIndex());

				textDistancia.setText(String.format("%.2f", punto1.distancia(punto2)));

			}
		});
		btnCalcularDistCirc.addActionListener(new ActionListener() {
			//CALCULA LA DISTANCIA DEL PUNTO SELECCIONADO EN PUNTOS1 AL CIRCULO SELECCIONADO
			@Override
			public void actionPerformed(ActionEvent arg0) {
				Punto punto1;
				Circulo punto2;
				punto1=arrayPuntos1.get(lstPuntos1.getSelectedIndex());
				punto2=arrayCirculos.get(lstCirculos.getSelectedIndex());
				textDistanciaCirculo.setText(String.format("%.2f", punto1.distancia(punto2.getCentro())));

			}
		});
		btnCalcularDistMax.addActionListener(new ActionListener() {
			//OBTIENE Y MUESTRA EN EL JTEXTFIELD LA DISTANCIA ENTRE EL CIRCULO SELECCIONADO Y EL PUNTO MAS LEJANO A ESE CIRCULO
			@Override
			public void actionPerformed(ActionEvent arg0) {
				
			}
		});
	}

	private void crearObjetos() {
		Punto p;
		Circulo c;
		Random r;
		// Crear 5 Puntos Aleatorios y Añadir a lista
		arrayPuntos1=new ArrayList<Punto>();
		arrayPuntos2=new ArrayList<Punto>();
		arrayCirculos=new ArrayList<Circulo>();

		//CADA PUNTO SE AÑADE A:
		//ARRAYLIST CORRESPONDIENTE Y AL MODELO
		r=new Random();
		for (int i = 0; i < 10; i++) {
			p=new Punto(r.nextDouble()*10, r.nextDouble()*8);
			arrayPuntos1.add(p);
			modelo1.addElement(p.getStr());

			p=new Punto(r.nextDouble()*10, -r.nextDouble()*8);
			arrayPuntos2.add(p);
			modelo2.addElement(p.getStr());
			
			c=new Circulo(r.nextDouble()*9+1, r.nextDouble()*10-5, r.nextDouble()*5);
			arrayCirculos.add(c);
			modelo3.addElement(c.toString());
		}
	}

}
