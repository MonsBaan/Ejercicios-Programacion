import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class Socios extends JFrame {
	public static final int ADD=1;
	public static final int EDIT=2;

	private JPanel contentPane;
	private JTextField txtNombre;
	private JTextField txtDir;
	private JTextField txtTlf;
	private JTextField txtRegistro;
	private JLabel lblNumSocio;
	private JLabel lblNombre;
	private JLabel lblDireccion;
	private JLabel lblTelefono;
	private JButton btnPrim;
	private JTextField txtNumSocio;
	private JButton btnAnt;
	private JButton btnSig;
	private JButton btnUlt;
	private JButton btnSalir;
	private BaseDatos bd;
	private ResultSet rs;
	private int numReg;
	private JButton btnNuevoSocio;
	private JButton btnConfirmar;
	private int accion;
	private JButton btnCancelar;
	private JButton btnModificar;
	private JButton btnEliminar;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Socios frame = new Socios();
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
	public Socios() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 460, 337);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		lblNumSocio = new JLabel("NumSocio:");
		lblNumSocio.setBounds(23, 14, 68, 14);
		contentPane.add(lblNumSocio);

		lblNombre = new JLabel("Nombre:");
		lblNombre.setBounds(23, 50, 68, 14);
		contentPane.add(lblNombre);

		lblDireccion = new JLabel("Direcci\u00F3n:");
		lblDireccion.setBounds(23, 86, 68, 14);
		contentPane.add(lblDireccion);

		lblTelefono = new JLabel("Telefono:");
		lblTelefono.setBounds(23, 125, 68, 14);
		contentPane.add(lblTelefono);

		btnPrim = new JButton("<<");
		btnPrim.setBounds(23, 264, 68, 23);
		contentPane.add(btnPrim);

		txtNumSocio = new JTextField();
		txtNumSocio.setEditable(false);
		txtNumSocio.setBounds(101, 11, 172, 20);
		contentPane.add(txtNumSocio);
		txtNumSocio.setColumns(10);

		txtNombre = new JTextField();
		txtNombre.setEditable(false);
		txtNombre.setBounds(101, 47, 172, 20);
		contentPane.add(txtNombre);
		txtNombre.setColumns(10);

		txtDir = new JTextField();
		txtDir.setEditable(false);
		txtDir.setBounds(101, 83, 172, 20);
		contentPane.add(txtDir);
		txtDir.setColumns(10);

		txtTlf = new JTextField();
		txtTlf.setEditable(false);
		txtTlf.setBounds(101, 122, 172, 20);
		contentPane.add(txtTlf);
		txtTlf.setColumns(10);

		btnAnt = new JButton("<");
		btnAnt.setBounds(101, 264, 68, 23);
		contentPane.add(btnAnt);

		btnSig = new JButton(">");
		btnSig.setBounds(273, 264, 68, 23);
		contentPane.add(btnSig);

		btnUlt = new JButton(">>");
		btnUlt.setBounds(351, 264, 68, 23);
		contentPane.add(btnUlt);

		txtRegistro = new JTextField();
		txtRegistro.setEditable(false);
		txtRegistro.setHorizontalAlignment(SwingConstants.CENTER);
		txtRegistro.setBounds(179, 265, 86, 20);
		contentPane.add(txtRegistro);
		txtRegistro.setColumns(10);

		btnSalir = new JButton("Salir");
		btnSalir.setBounds(351, 11, 68, 23);
		contentPane.add(btnSalir);

		btnNuevoSocio = new JButton("Nuevo Socio");
		btnNuevoSocio.setBounds(23, 230, 110, 23);
		contentPane.add(btnNuevoSocio);

		btnModificar = new JButton("Modificar Socio");
		btnModificar.setBounds(165, 230, 123, 23);
		contentPane.add(btnModificar);

		btnCancelar = new JButton("Cancelar");
		btnCancelar.setEnabled(false);
		btnCancelar.setBounds(250, 196, 104, 23);
		contentPane.add(btnCancelar);

		btnConfirmar = new JButton("Confirmar");
		btnConfirmar.setEnabled(false);
		btnConfirmar.setBounds(93, 197, 104, 23);
		contentPane.add(btnConfirmar);

		btnEliminar = new JButton("Eliminar");
		btnEliminar.setBounds(315, 230, 104, 23);
		contentPane.add(btnEliminar);

		inicializar();
		registrarEventos();
	}

	private void inicializar() {
		bd=new BaseDatos();
		bd.conectar();
		rs=bd.obtenerDatos();
		try {//MUESTRA EL PRIMER VALOR DE LA BASE DE DATOS
			if (rs.first()) {
				rs.last();
				numReg=rs.getRow();
				numReg=0;
				rs.first();
				mostrarDatos();


				txtRegistro.setText(rs.getRow()+"");

			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private void registrarEventos() {
		btnSalir.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if(JOptionPane.showConfirmDialog(Socios.this, 
						"Seguro que quieres salir?",
						"Salir",
						JOptionPane.YES_NO_OPTION)==JOptionPane.YES_OPTION) {
					System.exit(0);
				}
			}
		});

		btnSig.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				try {
					if (rs.next()) {
						mostrarDatos();
						txtRegistro.setText(rs.getRow()+"");
					}else {
						rs.last();
					}
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});

		btnAnt.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				try {
					if (rs.previous()) {
						mostrarDatos();
						txtRegistro.setText(rs.getRow()+"");
					}else {
						rs.first();
					}
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}				
			}
		});

		btnPrim.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				try {
					rs.first();
					txtRegistro.setText(rs.getRow()+"");
					mostrarDatos();

				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});

		btnUlt.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				try {
					rs.last();
					txtRegistro.setText(rs.getRow()+"");
					mostrarDatos();

				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});

		txtRegistro.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {	
				int reg;
				try {
					reg=Integer.parseInt(txtRegistro.getText());

					if (reg>numReg || reg<=0) {
						mostrarDatos();
					}else {
						rs.absolute(reg);
						mostrarDatos();
					}
				} catch (NumberFormatException e) {
					mostrarDatos();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});

		btnNuevoSocio.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				//EDITAR JTEXTFIELD, VACIARLOS, FOCO AL NOMBRE, NUMERO SOCIO (max +1), ACTIVAR OK y CANCELAR
				estadoTextDatos(true);

				txtNumSocio.setText(bd.obtenerMaxNumSocio()+1+"");
				txtNombre.setText("");
				txtDir.setText("");
				txtTlf.setText("");

				txtNombre.requestFocus();	

				accion=ADD;
			}
		});

		btnModificar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				estadoTextDatos(true);
				txtNombre.requestFocus();

				accion=EDIT;
			}
		});

		btnCancelar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				estadoTextDatos(false);
				mostrarDatos();

			}
		});

		btnConfirmar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				int regAct = 0;
				//COMPROBAR QUE LOS DATOS OBLIGATORIOS ESTEN RELLENOS "*"
				//SI ESTA VACIO -> JOPTIONPANE Y RETURN
				if (txtNombre.getText().isBlank() || txtNombre.getText().isEmpty()) {
					JOptionPane.showMessageDialog(Socios.this, "Faltan datos obligatorios");
					return;
				}

				try {
					regAct=rs.getRow();//GUARDAR REGISTRO ACTUAL
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

				switch (accion) {
				case ADD:
					if (bd.añadir(txtNombre.getText(), txtDir.getText(), txtTlf.getText())==0) {
						JOptionPane.showMessageDialog(Socios.this, "Error al Añadir Datos");
					}
					estadoTextDatos(false);
					rs=bd.obtenerDatos();//RECUPERAR DATOS DE LA BDD
					try {
						rs.absolute(regAct);
						txtRegistro.setText(rs.getRow()+"");
						mostrarDatos();
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					break;

				case EDIT:							

					if (bd.editar(txtNombre.getText(), txtDir.getText(), txtTlf.getText(), txtNumSocio.getText())==0) {
						JOptionPane.showMessageDialog(Socios.this, "Error al Editar Datos");
					}
					estadoTextDatos(false);
					rs=bd.obtenerDatos();//RECUPERAR DATOS DE LA BDD
					try {
						rs.absolute(regAct);
						txtRegistro.setText(rs.getRow()+"");
						mostrarDatos();
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}

					break;

				}
			}
		});
		btnEliminar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				if(JOptionPane.showConfirmDialog(Socios.this, 
						"Seguro que quieres borrar este usuario?",
						"Eliminar Usuario",
						JOptionPane.YES_NO_OPTION)==JOptionPane.YES_OPTION) {
					bd.eliminar(txtNumSocio.getText());
					estadoTextDatos(false);
					rs=bd.obtenerDatos();//RECUPERAR DATOS DE LA BDD
					try {
						rs.last();
						txtRegistro.setText(rs.getRow()+"");
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					mostrarDatos();
				}
			}
			
		});
	}//FIN DE REGISTRAR EVENTOS

	private void estadoTextDatos(boolean estado) {
		//DATOS
		txtNombre.setEditable(estado);
		txtDir.setEditable(estado);
		txtTlf.setEditable(estado);
		btnConfirmar.setEnabled(estado);
		btnCancelar.setEnabled(estado);

		//SELECTOR DATOS
		btnAnt.setEnabled(!estado);
		btnPrim.setEnabled(!estado);
		btnSig.setEnabled(!estado);
		btnUlt.setEnabled(!estado);

		//BOTONES NUEVO/MODIFICAR SOCIO
		btnNuevoSocio.setEnabled(!estado);
		btnModificar.setEnabled(!estado);
		btnEliminar.setEnabled(!estado);

	}

	private void mostrarDatos() {
		try {
			txtNumSocio.setText(rs.getString("num_socio"));
			txtNombre.setText(rs.getString("nombre"));
			txtDir.setText(rs.getString("direccion"));
			txtTlf.setText(rs.getString("telefono"));
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
}
