import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.FileDialog;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.JScrollPane;

public class GestionCorreo extends JFrame {
	private JTextField textCorreo;
	private JTextField textWeb;
	private JPanel contentPane;
	private JLabel lblNombre;
	private JLabel lblCorreo;
	private JLabel lblWeb;
	private JTextField textNombre;
	private JButton btnAñadir;
	private JLabel lblNombreLista;
	private JLabel lblCorreoLista;
	private JLabel lblWebLista;
	private JList listNombre;
	private JList listCorreo;
	private JList listWeb;
	private JScrollPane scrollPaneNombre;
	private JScrollPane scrollPaneCorreo;
	private JScrollPane scrollPaneWeb;
	private JButton btnEnviar;
	private JButton btnCargar;
	private JButton btnGuardar;
	private JButton btnSalir;
	private ArrayList<Persona> arrayPersonas;
	private DefaultListModel<String> modelo1, modelo2, modelo3;

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
		setTitle("Gestion Correo");
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 646, 509);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		lblNombre = new JLabel("Nombre: ");
		lblNombre.setBounds(39, 58, 69, 14);
		contentPane.add(lblNombre);
		
		lblCorreo = new JLabel("Correo: ");
		lblCorreo.setBounds(43, 83, 46, 14);
		contentPane.add(lblCorreo);
		
		lblWeb = new JLabel("Web: ");
		lblWeb.setBounds(53, 108, 46, 14);
		contentPane.add(lblWeb);
		
		textNombre = new JTextField();
		textNombre.setBounds(99, 55, 202, 20);
		contentPane.add(textNombre);
		textNombre.setColumns(10);
		
		textCorreo = new JTextField();
		textCorreo.setBounds(99, 80, 202, 20);
		contentPane.add(textCorreo);
		textCorreo.setColumns(10);
		
		textWeb = new JTextField();
		textWeb.setBounds(99, 105, 202, 20);
		contentPane.add(textWeb);
		textWeb.setColumns(10);
		
		btnAñadir = new JButton("A\u00F1adir");
		btnAñadir.setBounds(346, 104, 89, 23);
		contentPane.add(btnAñadir);
		
		scrollPaneNombre = new JScrollPane();
		scrollPaneNombre.setBounds(39, 183, 135, 181);
		contentPane.add(scrollPaneNombre);
		
		listNombre = new JList();
		scrollPaneNombre.setViewportView(listNombre);
		listNombre.setBorder(null);
		lblNombreLista = new JLabel("Nombres");
		scrollPaneNombre.setColumnHeaderView(lblNombreLista);
		modelo1=new DefaultListModel<>();
		listNombre.setModel(modelo1);
		
		scrollPaneCorreo = new JScrollPane();
		scrollPaneCorreo.setBounds(205, 183, 135, 181);
		contentPane.add(scrollPaneCorreo);
		
		lblCorreoLista = new JLabel("Direcciones de Correo");
		scrollPaneCorreo.setColumnHeaderView(lblCorreoLista);
		
		listCorreo = new JList();
		scrollPaneCorreo.setViewportView(listCorreo);
		listCorreo.setBorder(null);
		modelo2=new DefaultListModel<>();
		listCorreo.setModel(modelo2);
		
		scrollPaneWeb = new JScrollPane();
		scrollPaneWeb.setBounds(375, 183, 135, 181);
		contentPane.add(scrollPaneWeb);
		
		lblWebLista = new JLabel("Direcciones Web");
		scrollPaneWeb.setColumnHeaderView(lblWebLista);
		
		listWeb = new JList();
		scrollPaneWeb.setViewportView(listWeb);
		listWeb.setBorder(null);
		modelo3=new DefaultListModel<>();
		listWeb.setModel(modelo3);
		
		btnEnviar = new JButton("Enviar Mail");
		btnEnviar.setBounds(520, 263, 95, 23);
		contentPane.add(btnEnviar);
		
		btnCargar = new JButton("Cargar Datos");
		btnCargar.setBounds(89, 420, 126, 23);
		contentPane.add(btnCargar);
		
		btnGuardar = new JButton("Guardar Datos");
		btnGuardar.setBounds(225, 420, 127, 23);
		contentPane.add(btnGuardar);
		
		btnSalir = new JButton("Salir");
		btnSalir.setBounds(503, 420, 89, 23);
		contentPane.add(btnSalir);
		
		arrayPersonas=new ArrayList<Persona>();
		
		registrarEventos();
	}

	private void registrarEventos() {
		btnSalir.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				if (JOptionPane.showConfirmDialog(GestionCorreo.this,

						"¿Seguro que quieres salir?",
						"Salir",
						JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
					System.exit(0);
				}				
			}
		});
		
		btnAñadir.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				Persona p;
				p=new Persona(textNombre.getText(), textCorreo.getText(), textWeb.getText());
				
				if (p.esMailCorrecto(p.getMail())==true) {
					arrayPersonas.add(p);
					modelo1.addElement(p.getNombre());
					modelo2.addElement(p.getMail());
					modelo3.addElement(p.getWeb());
					
					textNombre.setText("");
					textCorreo.setText("");
					textWeb.setText("");
					
					textNombre.requestFocus();
				}else {
					JOptionPane.showMessageDialog(GestionCorreo.this, "CORREO NO VALIDO");
					textCorreo.requestFocus();
					textCorreo.selectAll();
				}
				//SI EL MAIL ES CORRECTO SE AÑADE A LA PERSONA A UN ARRAYLIST Y SUS DATOS A LOS JLIST

			}
		});
		btnGuardar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				FileDialog dlgGuardar;
				PrintWriter pw;
				dlgGuardar=new FileDialog(GestionCorreo.this, "Guardar", FileDialog.SAVE);
				dlgGuardar.setVisible(true);		
				
				try {
					pw=new PrintWriter(new File(dlgGuardar.getDirectory()+dlgGuardar.getFile()));
				
				
				for(Persona p:arrayPersonas) {
					p.guardar(pw);
				}
				pw.close();
				} catch (FileNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});

		
		btnCargar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				FileDialog dlgCargar;
				PrintWriter pw;
			}
		});
	}//REGISTRAR EVENTOS ABAJO
	
	
	
	
}
