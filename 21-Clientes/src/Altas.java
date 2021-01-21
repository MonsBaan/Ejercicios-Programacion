import javax.swing.JPanel;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;
import java.sql.ResultSet;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;
import javax.swing.JButton;
import java.awt.BorderLayout;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;

@SuppressWarnings("serial")
public class Altas extends JPanel {
	private JPanel panelBotones;
	private JButton btnLimpiar;
	private JButton btnAlta;
	private JPanel panelContenido;
	private JPanel panel_2;
	private JLabel lblNombre;
	private JTextField txtNombre;
	private JLabel lblApellidos;
	private JTextField txtApellidos;
	private JLabel lblEdad;
	private JTextField txtEdad;
	private JPanel panel_3;
	private JLabel lblCalle;
	private JTextField txtCalle;
	private JLabel lblNumero;
	private JTextField txtNumero;
	private JLabel lblCodigoPostal;
	private JTextField txtCp;
	private BaseDatos bd;
	@SuppressWarnings("unused")
	private ResultSet rs;
	private JPanel panelClientes;
	private JLabel lblClave;
	private JTextField txtClave;


	/**
	 * Create the panel.
	 */
	public Altas() {
		setLayout(new BorderLayout(0, 0));

		panelBotones = new JPanel();
		add(panelBotones, BorderLayout.SOUTH);

		btnLimpiar = new JButton("Limpiar");
		panelBotones.add(btnLimpiar);

		btnAlta = new JButton("Dar de Alta");
		panelBotones.add(btnAlta);

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
		gbc_panelClientes.insets = new Insets(0, 0, 5, 0);
		gbc_panelClientes.fill = GridBagConstraints.BOTH;
		gbc_panelClientes.gridx = 0;
		gbc_panelClientes.gridy = 0;
		panelContenido.add(panelClientes, gbc_panelClientes);
		GridBagLayout gbl_panelClientes = new GridBagLayout();
		gbl_panelClientes.columnWidths = new int[]{132, 132, 0};
		gbl_panelClientes.rowHeights = new int[]{25, 0};
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

		txtClave = new JTextField();
		GridBagConstraints gbc_txtClave = new GridBagConstraints();
		gbc_txtClave.fill = GridBagConstraints.BOTH;
		gbc_txtClave.gridx = 1;
		gbc_txtClave.gridy = 0;
		panelClientes.add(txtClave, gbc_txtClave);
		
		panel_2 = new JPanel();
		panel_2.setBorder(new TitledBorder(null, "Datos Personales:", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		GridBagConstraints gbc_panel_2 = new GridBagConstraints();
		gbc_panel_2.fill = GridBagConstraints.BOTH;
		gbc_panel_2.insets = new Insets(0, 0, 5, 0);
		gbc_panel_2.gridx = 0;
		gbc_panel_2.gridy = 1;
		panelContenido.add(panel_2, gbc_panel_2);
		panel_2.setLayout(new GridLayout(3, 2, 0, 5));

		lblNombre = new JLabel("* Nombre:");
		panel_2.add(lblNombre);

		txtNombre = new JTextField();
		txtNombre.setColumns(10);
		panel_2.add(txtNombre);

		lblApellidos = new JLabel("Apellidos:");
		panel_2.add(lblApellidos);

		txtApellidos = new JTextField();
		txtApellidos.setColumns(10);
		panel_2.add(txtApellidos);

		lblEdad = new JLabel("* Edad:");
		panel_2.add(lblEdad);

		txtEdad = new JTextField();
		txtEdad.setColumns(10);
		panel_2.add(txtEdad);

		panel_3 = new JPanel();
		panel_3.setBorder(new TitledBorder(null, "Direccion:", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		GridBagConstraints gbc_panel_3 = new GridBagConstraints();
		gbc_panel_3.fill = GridBagConstraints.BOTH;
		gbc_panel_3.gridx = 0;
		gbc_panel_3.gridy = 2;
		panelContenido.add(panel_3, gbc_panel_3);
		panel_3.setLayout(new GridLayout(0, 2, 0, 5));

		lblCalle = new JLabel("* Calle:");
		panel_3.add(lblCalle);

		txtCalle = new JTextField();
		txtCalle.setColumns(10);
		panel_3.add(txtCalle);

		lblNumero = new JLabel("* Numero:");
		panel_3.add(lblNumero);

		txtNumero = new JTextField();
		txtNumero.setColumns(10);
		panel_3.add(txtNumero);

		lblCodigoPostal = new JLabel("Codigo Postal:");
		panel_3.add(lblCodigoPostal);

		txtCp = new JTextField();
		txtCp.setColumns(10);
		panel_3.add(txtCp);

		inicializar();
		registrarEventos();

		this.addComponentListener(new ComponentListener() {

			@Override
			public void componentShown(ComponentEvent arg0) {	
				bd.obtenerDatos();
				txtClave.requestFocus();	
				txtClave.setToolTipText("Numero de Usuarios Actuales: "+bd.obtenerMaxNumSocio()+"");
				txtClave.setText(bd.obtenerMaxNumSocio()+1+"");

			}

			@Override
			public void componentHidden(ComponentEvent arg0) {
				// TODO Auto-generated method stub

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
	}


	private void registrarEventos() {
		btnAlta.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				bd.obtenerDatos();

				if (txtClave.getText().isBlank() || txtNombre.getText().isBlank() || txtEdad.getText().isBlank() || txtCalle.getText().isBlank() || txtNumero.getText().isBlank()) {
					JOptionPane.showMessageDialog(Altas.this, "Faltan datos obligatorios");
					return;
				}
				if (bd.alta(txtClave.getText(),	txtNombre.getText(), txtApellidos.getText(),
						txtEdad.getText(), txtCalle.getText(),	txtNumero.getText(), txtCp.getText())==1) {
					JOptionPane.showMessageDialog(Altas.this, "Error al insertar datos");
					return;
				}else {
					bd.alta(txtClave.getText().replaceAll(" ", ""),	txtNombre.getText(), txtApellidos.getText(),
							txtEdad.getText(), txtCalle.getText(),	txtNumero.getText(), txtCp.getText());
					JOptionPane.showMessageDialog(Altas.this, "Usuario Añadido");
					limpiar();
				}
					
			}
		});

		btnLimpiar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				if(JOptionPane.showConfirmDialog(Altas.this, 
						"Seguro que quieres limpiar los datos?",
						"Limpiar",
						JOptionPane.YES_NO_OPTION)==JOptionPane.YES_OPTION) {
					limpiar();			
				}

			}
		});
	}


	private void inicializar() {
		bd=new BaseDatos();
		bd.conectar();
		rs=bd.obtenerDatos();
	}


	private void limpiar() {
		txtClave.setText("");
		txtNombre.setText("");
		txtApellidos.setText("");
		txtEdad.setText("");
		txtCalle.setText("");
		txtNumero.setText("");
		txtCp.setText("");	
	}
}
