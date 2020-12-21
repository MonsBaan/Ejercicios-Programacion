import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.util.ArrayList;
import java.util.Timer;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JList;

public class Correo extends JFrame {

	private JPanel contentPane;
	private JTextField txtPara;
	private JTextField txtCC;
	private JTextField txtASunto;
	private JTextArea txtMensaje;
	private JButton btnEnviar;
	private JButton btnVolver;
	private GestionCorreo gestionCorreo;
	private JButton btnPersonas;
	private JList lstNombres;
	private DefaultListModel<String> modelo;
	private ArrayList<Persona> arrayPersonas;

	/**
	 * Create the frame.
	 */
	public Correo(GestionCorreo gestionCorreo) {
		this.gestionCorreo=gestionCorreo;

		setTitle("Enviar Correo");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 992, 598);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNewLabel = new JLabel("Para:");
		lblNewLabel.setBounds(53, 42, 46, 14);
		contentPane.add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("CC:");
		lblNewLabel_1.setBounds(53, 74, 46, 14);
		contentPane.add(lblNewLabel_1);

		txtPara = new JTextField();
		txtPara.setBounds(109, 39, 557, 20);
		contentPane.add(txtPara);
		txtPara.setColumns(10);

		txtCC = new JTextField();
		txtCC.setBounds(109, 71, 557, 20);
		contentPane.add(txtCC);
		txtCC.setColumns(10);

		JLabel lblNewLabel_2 = new JLabel("Asunto:");
		lblNewLabel_2.setBounds(53, 120, 46, 14);
		contentPane.add(lblNewLabel_2);

		txtASunto = new JTextField();
		txtASunto.setBounds(113, 117, 553, 20);
		contentPane.add(txtASunto);
		txtASunto.setColumns(10);

		JLabel lblNewLabel_3 = new JLabel("Mensaje:");
		lblNewLabel_3.setBounds(53, 171, 46, 14);
		contentPane.add(lblNewLabel_3);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(109, 166, 557, 302);
		contentPane.add(scrollPane);

		txtMensaje = new JTextArea();
		txtMensaje.setLineWrap(true);
		txtMensaje.setWrapStyleWord(true);
		scrollPane.setViewportView(txtMensaje);

		btnEnviar = new JButton("Enviar");
		btnEnviar.setBounds(164, 505, 89, 23);
		contentPane.add(btnEnviar);

		btnVolver = new JButton("Volver");
		btnVolver.setBounds(728, 505, 89, 23);
		contentPane.add(btnVolver);

		btnPersonas = new JButton(">");
		btnPersonas.setBounds(676, 38, 41, 23);
		contentPane.add(btnPersonas);

		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(745, 41, 149, 192);
		contentPane.add(scrollPane_1);

		lstNombres = new JList();
		scrollPane_1.setViewportView(lstNombres);

		modelo=new DefaultListModel<>();
		lstNombres.setModel(modelo);

		registrarEventos();

	}//FIN DEL CONSTRUCTOR

	public JTextField getTxtPara() {
		return txtPara;
	}

	public void setTxtPara(JTextField txtPara) {
		this.txtPara = txtPara;
	}

	private void registrarEventos() {
		btnVolver.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				Correo.this.dispose();

				//NECESITO LA UNICA INSTANCIA DE GESTIONCORREO (se ha pasado y
				//asignado en el constructor)
				gestionCorreo.setVisible(true);
			}
		});

		btnPersonas.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				//CARGAR LOS DATOS DEL ARRAY DE PERSONAS DE GESTIONCORREO
				//EN ESTE JLIST. LUEGO DESACTIVAREMOS EL BOTÓN PARA NO CARGAR
				//LOS DATOS VARIAS VECES
				arrayPersonas=gestionCorreo.getArrayPersonas();
				for (Persona persona : arrayPersonas) {
					modelo.addElement(persona.getNombre());
				}
				btnPersonas.setEnabled(false);
			}
		});

		this.addWindowListener(new WindowAdapter() {

			@Override
			public void windowClosing(WindowEvent e) {
				// TODO Auto-generated method stub
				Correo.this.dispose();
				gestionCorreo.setVisible(true);
			}
		});

		lstNombres.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (e.getClickCount() == 2 && !lstNombres.isSelectionEmpty()) {
					if (!txtPara.getText().contains(arrayPersonas.get(lstNombres.getSelectedIndex()).getMail())) {
						if (!txtPara.getText().equals("")) {
							txtPara.setText(txtPara.getText()+", "+arrayPersonas.get(lstNombres.getSelectedIndex()).getMail());
						}else {
							txtPara.setText(arrayPersonas.get(lstNombres.getSelectedIndex()).getMail());

						}


					}
				}
			}
		});

	}
}







