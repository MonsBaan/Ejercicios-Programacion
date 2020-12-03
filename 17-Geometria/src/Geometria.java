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

public class Geometria extends JFrame {

	private JPanel contentPane;
	private Punto p1;
	private Punto p2;
	private Circulo p3;
	private JScrollPane scrollPane2;
	private JList lstPuntos1;
	private JList lstPuntos2;
	private JLabel lblPuntoInicial;
	private JScrollPane scrollPane;
	private JLabel lblPuntoFinal;
	private JLabel lblDistancia;
	private JButton btnCalcular;
	private JTextField textDistancia;
	private ArrayList<Punto> arrayPuntos1, arrayPuntos2;
	private DefaultListModel<String> modelo1, modelo2;


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
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		scrollPane2 = new JScrollPane();
		scrollPane2.setBounds(10, 46, 117, 204);
		contentPane.add(scrollPane2);

		lstPuntos1 = new JList();

		scrollPane2.setViewportView(lstPuntos1);
		modelo1=new DefaultListModel<String>();
		lstPuntos1.setModel(modelo1);

		lblPuntoInicial = new JLabel("Puntos Iniciales");
		scrollPane2.setColumnHeaderView(lblPuntoInicial);

		scrollPane = new JScrollPane();
		scrollPane.setBounds(164, 46, 117, 204);
		contentPane.add(scrollPane);

		lstPuntos2 = new JList();
		scrollPane.setViewportView(lstPuntos2);
		modelo2=new DefaultListModel<String>();
		lstPuntos2.setModel(modelo2);


		lblPuntoFinal = new JLabel("Puntos Finales");
		scrollPane.setColumnHeaderView(lblPuntoFinal);

		textDistancia = new JTextField();
		textDistancia.setBounds(291, 71, 86, 20);
		contentPane.add(textDistancia);
		textDistancia.setColumns(10);

		lblDistancia = new JLabel("Distancia");
		lblDistancia.setBounds(291, 46, 46, 14);
		contentPane.add(lblDistancia);

		btnCalcular = new JButton("Calcular");
		btnCalcular.setEnabled(false);
		btnCalcular.setBounds(291, 102, 89, 23);
		contentPane.add(btnCalcular);


		crearPuntos();
		registrarEventos();
	}

	private void registrarEventos() {
		lstPuntos1.addListSelectionListener(new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent arg0) {
				if (lstPuntos1.getSelectedIndex()!=-1 && lstPuntos2.getSelectedIndex()!=-1) {
					btnCalcular.setEnabled(true);
				} 

			}
		});
		lstPuntos2.addListSelectionListener(new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent arg0) {
				if (lstPuntos1.getSelectedIndex()!=-1 && lstPuntos2.getSelectedIndex()!=-1) {
					btnCalcular.setEnabled(true);
				}
			}
		});
		btnCalcular.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				Punto punto1, punto2;
				punto1=arrayPuntos1.get(lstPuntos1.getSelectedIndex());
				punto2=arrayPuntos2.get(lstPuntos2.getSelectedIndex());
				
				textDistancia.setText(String.format("%.2f", punto1.distancia(punto2)));

			}
		});
	}

	private void crearPuntos() {
		Punto p;
		Random r;
		// Crear 5 Puntos Aleatorios y Añadir a lista
		arrayPuntos1=new ArrayList<Punto>();
		arrayPuntos2=new ArrayList<Punto>();

		//CADA PUNTO SE AÑADE A:
		//ARRAYLIST CORRESPONDIENTE Y AL MODELO
		r=new Random();
		for (int i = 0; i < 5; i++) {
			p=new Punto(r.nextDouble()*10, r.nextDouble()*8);
			arrayPuntos1.add(p);
			modelo1.addElement(p.getStr());

			p=new Punto(r.nextDouble()*10, -r.nextDouble()*8);
			arrayPuntos2.add(p);
			modelo2.addElement(p.getStr());
		}
	}
	
	
}
