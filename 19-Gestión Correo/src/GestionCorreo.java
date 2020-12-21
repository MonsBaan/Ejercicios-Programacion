import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.FileDialog;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JScrollPane;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.DefaultListModel;
import javax.swing.JButton;

public class GestionCorreo extends JFrame {

	private JPanel contentPane;
	private JTextField txtNombre;
	private JTextField txtMail;
	public JList getLstMails;
	private JTextField txtWeb;
	private JList lstNombres;
	private JList lstMails;
	private JList lstWebs;
	private JButton btnCargar;
	private JButton btnGuardar;
	private JButton btnSalir;
	private JButton btnAdd;
	private ArrayList<Persona> arrayPersonas;
	private DefaultListModel<String> modelo1, modelo2, modelo3;
	private Correo correo;
	private JButton btnEnviar;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GestionCorreo frame = new GestionCorreo();
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
	public GestionCorreo() {
		setTitle("Gesti\u00F3n Correo");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 714, 574);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Nombre:");
		lblNewLabel.setBounds(55, 56, 46, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Correo:");
		lblNewLabel_1.setBounds(55, 80, 46, 14);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Web:");
		lblNewLabel_2.setBounds(55, 105, 46, 14);
		contentPane.add(lblNewLabel_2);
		
		txtNombre = new JTextField();
		txtNombre.setBounds(112, 53, 104, 20);
		contentPane.add(txtNombre);
		txtNombre.setColumns(10);
		
		txtMail = new JTextField();
		txtMail.setBounds(111, 77, 187, 20);
		contentPane.add(txtMail);
		txtMail.setColumns(10);
		
		txtWeb = new JTextField();
		txtWeb.setBounds(111, 102, 187, 20);
		contentPane.add(txtWeb);
		txtWeb.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("Nombres:");
		lblNewLabel_3.setBounds(55, 168, 46, 14);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Direcciones de Correo:");
		lblNewLabel_4.setBounds(180, 168, 128, 14);
		contentPane.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("Direcciones Web");
		lblNewLabel_5.setBounds(334, 168, 97, 14);
		contentPane.add(lblNewLabel_5);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(55, 193, 104, 191);
		contentPane.add(scrollPane);
		
		lstNombres = new JList();
		scrollPane.setViewportView(lstNombres);
		//MODELO ASOCIADO
		modelo1=new DefaultListModel<>();
		lstNombres.setModel(modelo1);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(180, 193, 118, 191);
		contentPane.add(scrollPane_1);
		
		lstMails = new JList();
		scrollPane_1.setViewportView(lstMails);
		modelo2=new DefaultListModel<>();
		lstMails.setModel(modelo2);
		
		JScrollPane scrollPane_2 = new JScrollPane();
		scrollPane_2.setBounds(334, 193, 141, 194);
		contentPane.add(scrollPane_2);
		
		lstWebs = new JList();
		scrollPane_2.setViewportView(lstWebs);
		modelo3=new DefaultListModel<>();
		lstWebs.setModel(modelo3);
		
		btnAdd = new JButton("A\u00F1adir");
		btnAdd.setBounds(334, 101, 89, 23);
		contentPane.add(btnAdd);
		
		btnCargar = new JButton("CargarDatos");
		btnCargar.setBounds(65, 452, 112, 23);
		contentPane.add(btnCargar);
		
		btnGuardar = new JButton("Guardar Datos");
		btnGuardar.setBounds(242, 452, 128, 23);
		contentPane.add(btnGuardar);
		
		btnSalir = new JButton("Salir");
		btnSalir.setBounds(498, 452, 89, 23);
		contentPane.add(btnSalir);
		
		btnEnviar = new JButton("Enviar Mail");
		btnEnviar.setBounds(533, 244, 89, 23);
		contentPane.add(btnEnviar);
		
		arrayPersonas=new ArrayList<Persona>();
		registrarEventos();
		
	}//FIN DEL CONSTRUCTOR

	public ArrayList<Persona> getArrayPersonas() {
		return arrayPersonas;
	}

	public void setArrayPersonas(ArrayList<Persona> arrayPersonas) {
		this.arrayPersonas = arrayPersonas;
	}

	private void registrarEventos() {
		btnAdd.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				//Crear una persona con los datos de los JTextField
				Persona p;
				p=new Persona(txtNombre.getText(), txtMail.getText(), 
								txtWeb.getText());

				//si NO es correcto, le doy el foco al TextField correo
				//y seleccionamos el texto
				if(!p.esMailCorrecto()) {
					JOptionPane.showMessageDialog(GestionCorreo.this, 
													p.getStrError());
					txtMail.requestFocus();
					txtMail.selectAll();
				}else {//si el mail es correcto añado a la persona al ArrayList, los 
					//datos de la persona a los JList
					arrayPersonas.add(p);
					modelo1.addElement(p.getNombre()+" ");
					modelo2.addElement(p.getMail());
					modelo3.addElement(p.getWeb()+" ");
					//VACIAR LOS JTextField y dar el foco al nombre
					txtNombre.setText("");
					txtMail.setText("");
					txtWeb.setText("");
					txtNombre.requestFocus();
				}
			}
		});
		
		btnGuardar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				FileDialog dlgGuardar;
				PrintWriter pw;
				//ELEGIR EL ARCHIVO (FileDialog)
				dlgGuardar=new FileDialog(GestionCorreo.this, "Guardar", 
											FileDialog.SAVE);
				dlgGuardar.setVisible(true);
				if(dlgGuardar.getFile()==null) {//PULSAR CANCELAR
					return;
				}
				//ABRIR EL ARCHIVO PARA ESCRIBIR (PrintWriter)
				try {
					pw=new PrintWriter(new File(dlgGuardar.getDirectory()+
												dlgGuardar.getFile()));
					//recorrer el arrayList de personas y guardar cada persona
					//en el archivo mediante una llamada a guardar de la clase
					//Persona a la cual le pasamos el PrintWriter
					for(Persona p:arrayPersonas) {
						p.guardar(pw);
					}
					pw.close();
				} catch (FileNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		
		btnCargar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				Scanner sc;
				Persona p=new Persona();
				//ELEGIR EL ARCHIVO (FileDialog)
				FileDialog dlgCargar;
				dlgCargar=new FileDialog(GestionCorreo.this, "Cargar", 
											FileDialog.LOAD);
				dlgCargar.setVisible(true);
				if(dlgCargar.getFile()==null) {
					return;
				}
				//ABRIR EL ARCHIVO (Scanner o Bufferedreader)
				try {
					sc=new Scanner(new File(dlgCargar.getDirectory()+
											dlgCargar.getFile()));
					//VACIAR LOS 3 Jlist Y EL ArrayList de Personas????
					modelo1.clear();
					modelo2.clear();
					modelo3.clear();
					arrayPersonas.clear();
					//LEER TODOS LOS DATOS DEL ARCHIVO Y CARGARLOS EN:
						//ARRAYLIST de personas
						//CADA DATO EN SU JLIST
					while(sc.hasNextLine()) {
						p=p.cargar(sc);
						arrayPersonas.add(p);
						modelo1.addElement(p.getNombre());
						modelo2.addElement(p.getMail());
						modelo3.addElement(p.getWeb());
					}
					
					
					sc.close();
				} catch (FileNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
		});
		
		lstNombres.addListSelectionListener(new ListSelectionListener() {
			
			@Override
			public void valueChanged(ListSelectionEvent e) {
				lstMails.setSelectedIndex(lstNombres.getSelectedIndex());
				lstWebs.setSelectedIndex(lstNombres.getSelectedIndex());
			}
		});
		
		lstMails.addListSelectionListener(new ListSelectionListener() {
			
			@Override
			public void valueChanged(ListSelectionEvent e) {
				lstNombres.setSelectedIndex(lstMails.getSelectedIndex());
				lstWebs.setSelectedIndex(lstMails.getSelectedIndex());
			}
		});
		
		lstWebs.addListSelectionListener(new ListSelectionListener() {
			
			@Override	
			public void valueChanged(ListSelectionEvent e) {
				lstNombres.setSelectedIndex(lstWebs.getSelectedIndex());
				lstMails.setSelectedIndex(lstWebs.getSelectedIndex());
			}
		});
		
		btnEnviar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				correo=new Correo(GestionCorreo.this);
				correo.setVisible(true);
				GestionCorreo.this.setVisible(false);
				if(!lstMails.isSelectionEmpty()) {
					correo.getTxtPara().setText((String)lstMails.getSelectedValue());
				}
			}
		});
		
	}//FIN DE REGISTRAR EVENTOS
	
}




