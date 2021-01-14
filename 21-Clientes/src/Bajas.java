import javax.swing.JPanel;
import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;
import javax.swing.JButton;
import java.awt.BorderLayout;
import javax.swing.JComboBox;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;

@SuppressWarnings("serial")
public class Bajas extends JPanel {
	private JPanel panelBotones;
	private JButton btnBaja;
	private JPanel panelContenido;
	private JPanel panelDatosPersonales;
	private JLabel lblNombre;
	private JTextField txtNombre;
	private JLabel lblApellidos;
	private JTextField txtApellidos;
	private JLabel lblEdad;
	private JTextField txtEdad;
	private JPanel panelDireccion;
	private JLabel lblCalle;
	private JTextField txtCalle;
	private JLabel lblNumero;
	private JTextField txtNumero;
	private JLabel lblCodigoPostal;
	private JTextField txtCp;
	private JPanel panelClientes;
	private JComboBox<String> cBClave;
	private JLabel lblClave;
	private BaseDatos bd;
	private ResultSet rs;


	/**
	 * Create the panel.
	 */
	public Bajas() {
		setLayout(new BorderLayout(0, 0));

		panelBotones = new JPanel();
		add(panelBotones, BorderLayout.SOUTH);

		btnBaja = new JButton("Dar de Baja");
		panelBotones.add(btnBaja);

		panelContenido = new JPanel();
		add(panelContenido, BorderLayout.CENTER);
		GridBagLayout gbl_panelContenido = new GridBagLayout();
		gbl_panelContenido.columnWidths = new int[]{280, 0};
		gbl_panelContenido.rowHeights = new int[]{60, 95, 100, 0};
		gbl_panelContenido.columnWeights = new double[]{0.0, Double.MIN_VALUE};
		gbl_panelContenido.rowWeights = new double[]{0.0, 0.0, 0.0, Double.MIN_VALUE};
		panelContenido.setLayout(gbl_panelContenido);

		panelClientes = new JPanel();
		panelClientes.setBorder(new TitledBorder(null, "Clientes:", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		GridBagConstraints gbc_panelClientes = new GridBagConstraints();
		gbc_panelClientes.fill = GridBagConstraints.BOTH;
		gbc_panelClientes.insets = new Insets(0, 0, 5, 0);
		gbc_panelClientes.gridx = 0;
		gbc_panelClientes.gridy = 0;
		panelContenido.add(panelClientes, gbc_panelClientes);
		GridBagLayout gbl_panelClientes = new GridBagLayout();
		gbl_panelClientes.columnWidths = new int[]{132, 132, 0};
		gbl_panelClientes.rowHeights = new int[]{20, 0};
		gbl_panelClientes.columnWeights = new double[]{0.0, 0.0, Double.MIN_VALUE};
		gbl_panelClientes.rowWeights = new double[]{0.0, Double.MIN_VALUE};
		panelClientes.setLayout(gbl_panelClientes);

		lblClave = new JLabel("* Clave:");
		GridBagConstraints gbc_lblClave = new GridBagConstraints();
		gbc_lblClave.fill = GridBagConstraints.BOTH;
		gbc_lblClave.insets = new Insets(0, 0, 0, 5);
		gbc_lblClave.gridx = 0;
		gbc_lblClave.gridy = 0;
		panelClientes.add(lblClave, gbc_lblClave);

		cBClave = new JComboBox<String>();

		GridBagConstraints gbc_cBClave = new GridBagConstraints();
		gbc_cBClave.fill = GridBagConstraints.BOTH;
		gbc_cBClave.gridx = 1;
		gbc_cBClave.gridy = 0;
		panelClientes.add(cBClave, gbc_cBClave);

		panelDatosPersonales = new JPanel();
		panelDatosPersonales.setBorder(new TitledBorder(null, "Datos Personales:", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		GridBagConstraints gbc_panelDatosPersonales = new GridBagConstraints();
		gbc_panelDatosPersonales.fill = GridBagConstraints.BOTH;
		gbc_panelDatosPersonales.insets = new Insets(0, 0, 5, 0);
		gbc_panelDatosPersonales.gridx = 0;
		gbc_panelDatosPersonales.gridy = 1;
		panelContenido.add(panelDatosPersonales, gbc_panelDatosPersonales);
		panelDatosPersonales.setLayout(new GridLayout(3, 2, 0, 5));

		lblNombre = new JLabel("* Nombre:");
		panelDatosPersonales.add(lblNombre);

		txtNombre = new JTextField();
		txtNombre.setEditable(false);
		txtNombre.setColumns(10);
		panelDatosPersonales.add(txtNombre);

		lblApellidos = new JLabel("Apellidos:");
		panelDatosPersonales.add(lblApellidos);

		txtApellidos = new JTextField();
		txtApellidos.setEditable(false);
		txtApellidos.setColumns(10);
		panelDatosPersonales.add(txtApellidos);

		lblEdad = new JLabel("* Edad:");
		panelDatosPersonales.add(lblEdad);

		txtEdad = new JTextField();
		txtEdad.setEditable(false);
		txtEdad.setColumns(10);
		panelDatosPersonales.add(txtEdad);

		panelDireccion = new JPanel();
		panelDireccion.setBorder(new TitledBorder(null, "Direccion:", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		GridBagConstraints gbc_panelDireccion = new GridBagConstraints();
		gbc_panelDireccion.fill = GridBagConstraints.BOTH;
		gbc_panelDireccion.gridx = 0;
		gbc_panelDireccion.gridy = 2;
		panelContenido.add(panelDireccion, gbc_panelDireccion);
		panelDireccion.setLayout(new GridLayout(0, 2, 0, 5));

		lblCalle = new JLabel("* Calle:");
		panelDireccion.add(lblCalle);

		txtCalle = new JTextField();
		txtCalle.setEditable(false);
		txtCalle.setColumns(10);
		panelDireccion.add(txtCalle);

		lblNumero = new JLabel("* Numero:");
		panelDireccion.add(lblNumero);

		txtNumero = new JTextField();
		txtNumero.setEditable(false);
		txtNumero.setColumns(10);
		panelDireccion.add(txtNumero);

		lblCodigoPostal = new JLabel("Codigo Postal:");
		panelDireccion.add(lblCodigoPostal);

		txtCp = new JTextField();
		txtCp.setEditable(false);
		txtCp.setColumns(10);
		panelDireccion.add(txtCp);

		inicializar();
		registrarEventos();


	}
	private void inicializar() {
		bd=new BaseDatos();
		bd.conectar();
		rs=bd.obtenerDatos();
	}

	private void mostrarDatos() {
		try {
			txtNombre.setText(rs.getString("nombre"));
			txtApellidos.setText(rs.getString("apellidos"));
			txtEdad.setText(rs.getString("edad"));
			txtCalle.setText(rs.getString("calle"));
			txtNumero.setText(rs.getString("numero"));
			txtCp.setText(rs.getString("cp"));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	private void registrarEventos() {
		this.addComponentListener(new ComponentListener() {

			@Override
			public void componentShown(ComponentEvent arg0) {
				refrescarComboBox();
			}

			@Override
			public void componentHidden(ComponentEvent arg0) {
			}

			@Override
			public void componentMoved(ComponentEvent arg0) {
				// TODO Auto-generated method stub
			}

			@Override
			public void componentResized(ComponentEvent arg0) {
				// TODO Auto-generated method stub
			}
		});


		cBClave.addItemListener(new ItemListener() {

			@Override
			public void itemStateChanged(ItemEvent arg0) {
				int clave=cBClave.getSelectedIndex();

				if (cBClave.getItemCount()!=0) {
					try {
						rs.absolute(clave+1);
						mostrarDatos();
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}


			}
		});

		btnBaja.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				if(JOptionPane.showConfirmDialog(Bajas.this, 
						"Estas seguro que quieres dar de baja a este usuario?",
						"Baja",
						JOptionPane.YES_NO_OPTION)==JOptionPane.YES_OPTION) {
					bd.baja((String) cBClave.getSelectedItem());

					refrescarComboBox();
				}

			}
		});


	}//FIN REGISTRAR EVENTOS

	private void refrescarComboBox(){
		rs=bd.obtenerDatos();
		cBClave.removeAllItems();
		try {
			rs.first();
			do {
				cBClave.addItem(rs.getString("clave"));
			} while (rs.next());
			rs.first();

			mostrarDatos();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}


}

