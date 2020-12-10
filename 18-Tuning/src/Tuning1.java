import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JSplitPane;
import java.awt.FlowLayout;
import javax.swing.JButton;
import javax.swing.BoxLayout;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.GridLayout;
import javax.swing.JTextField;
import java.awt.Component;
import javax.swing.JCheckBox;
import javax.swing.JList;
import javax.swing.JComboBox;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTextPane;
import javax.swing.JTextArea;
import javax.swing.DropMode;
import javax.swing.border.BevelBorder;
import java.awt.Color;
import javax.swing.border.MatteBorder;
import java.awt.Scrollbar;
import java.awt.TextArea;
import java.awt.Dimension;
import java.awt.Cursor;
import java.awt.Frame;

public class Tuning1 extends JFrame {

	private JPanel contentPane;
	private JTextField textApellidos;
	private JTextField txtDireccion;
	private JLabel lblTuning;
	private JPanel panelEnviarCancelar;
	private JButton btnEnviar;
	private JButton btnCancelar;
	private JPanel panel_1;
	private JPanel panelGridSuperior;
	private JLabel lblNombre;
	private JTextField textNombre;
	private JLabel lblApellidos;
	private JLabel lblDireccion;
	private JLabel lblProvincia;
	private JComboBox comboBoxProvincia;
	private JLabel lblEdad;
	private JComboBox comboBoxEdad;
	private JLabel lblSexo;
	private JPanel panelSexos;
	private JRadioButton rdbtnHombre;
	private JRadioButton rdbtnNewMujer;
	private JPanel panelSelectButtons;
	private JPanel panel;
	private JCheckBox chckbxTunning;
	private JCheckBox chckbxEquipamiento;
	private JCheckBox chckbxRecambios;
	private JCheckBox chckbxReparaciones;
	private JCheckBox chckbxPuestaPunto;
	private JCheckBox chckbxMantenimiento;
	private JCheckBox chckbxCompeticion;
	private JCheckBox chckbxVehiculosOcasion;
	private JPanel panelComentarios;
	private JPanel panelComentario1;
	private JLabel lblComentarios;
	private JPanel panelComentario2;
	private JLabel lblPedidos;
	private JLabel lblPreferencias;
	private TextArea textComentarios;
	private TextArea textPedidos;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Tuning1 frame = new Tuning1();
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
	public Tuning1() {
		setResizable(false);
		setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
		setBackground(Color.GRAY);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 419, 565);
		contentPane = new JPanel();
		contentPane.setBackground(Color.GRAY);
		contentPane.setForeground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		lblTuning = new JLabel("TALLER TUNING");
		lblTuning.setBackground(Color.GRAY);
		lblTuning.setHorizontalAlignment(SwingConstants.CENTER);
		contentPane.add(lblTuning, BorderLayout.NORTH);
		
		panelEnviarCancelar = new JPanel();
		panelEnviarCancelar.setBackground(Color.GRAY);
		contentPane.add(panelEnviarCancelar, BorderLayout.SOUTH);
		panelEnviarCancelar.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		btnEnviar = new JButton("Enviar");
		btnEnviar.setBackground(Color.WHITE);
		panelEnviarCancelar.add(btnEnviar);
		
		btnCancelar = new JButton("Cancelar");
		btnCancelar.setBackground(Color.WHITE);
		panelEnviarCancelar.add(btnCancelar);
		
		panel_1 = new JPanel();
		panel_1.setBackground(Color.GRAY);
		contentPane.add(panel_1, BorderLayout.CENTER);
		panel_1.setLayout(new BoxLayout(panel_1, BoxLayout.Y_AXIS));
		
		panelGridSuperior = new JPanel();
		panelGridSuperior.setBackground(Color.GRAY);
		panel_1.add(panelGridSuperior);
		panelGridSuperior.setLayout(new GridLayout(0, 2, 0, 0));
		
		lblNombre = new JLabel("Nombre: ");
		lblNombre.setBackground(Color.GRAY);
		lblNombre.setHorizontalAlignment(SwingConstants.RIGHT);
		panelGridSuperior.add(lblNombre);
		
		textNombre = new JTextField();
		textNombre.setBackground(Color.WHITE);
		panelGridSuperior.add(textNombre);
		textNombre.setColumns(10);
		
		lblApellidos = new JLabel("Apellidos: ");
		lblApellidos.setBackground(Color.GRAY);
		lblApellidos.setHorizontalAlignment(SwingConstants.RIGHT);
		panelGridSuperior.add(lblApellidos);
		
		textApellidos = new JTextField();
		textApellidos.setBackground(Color.WHITE);
		panelGridSuperior.add(textApellidos);
		textApellidos.setColumns(10);
		
		lblDireccion = new JLabel("Direccion: ");
		lblDireccion.setBackground(Color.GRAY);
		lblDireccion.setHorizontalAlignment(SwingConstants.RIGHT);
		panelGridSuperior.add(lblDireccion);
		
		txtDireccion = new JTextField();
		txtDireccion.setBackground(Color.WHITE);
		panelGridSuperior.add(txtDireccion);
		txtDireccion.setColumns(10);
		
		lblProvincia = new JLabel("Provincia: ");
		lblProvincia.setBackground(Color.GRAY);
		lblProvincia.setHorizontalAlignment(SwingConstants.RIGHT);
		panelGridSuperior.add(lblProvincia);
		
		comboBoxProvincia = new JComboBox();
		comboBoxProvincia.setBackground(Color.WHITE);
		panelGridSuperior.add(comboBoxProvincia);
		
		lblEdad = new JLabel("Edad:  ");
		lblEdad.setBackground(Color.GRAY);
		lblEdad.setHorizontalAlignment(SwingConstants.RIGHT);
		panelGridSuperior.add(lblEdad);
		
		comboBoxEdad = new JComboBox();
		comboBoxEdad.setBackground(Color.WHITE);
		panelGridSuperior.add(comboBoxEdad);
		
		lblSexo = new JLabel("Sexo: ");
		lblSexo.setBackground(Color.GRAY);
		lblSexo.setHorizontalAlignment(SwingConstants.RIGHT);
		panelGridSuperior.add(lblSexo);
		
		panelSexos = new JPanel();
		panelSexos.setBackground(Color.GRAY);
		panelGridSuperior.add(panelSexos);
		panelSexos.setLayout(new GridLayout(0, 2, 0, 0));
		
		rdbtnHombre = new JRadioButton("Hombre");
		rdbtnHombre.setBackground(Color.GRAY);
		panelSexos.add(rdbtnHombre);
		
		rdbtnNewMujer = new JRadioButton("Mujer");
		rdbtnNewMujer.setBackground(Color.GRAY);
		panelSexos.add(rdbtnNewMujer);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(Color.GRAY);
		panel_1.add(panel_2);
		panel_2.setLayout(new GridLayout(0, 2, 0, 0));
		
		lblPreferencias = new JLabel("Preferencias:");
		lblPreferencias.setBackground(Color.GRAY);
		lblPreferencias.setHorizontalAlignment(SwingConstants.RIGHT);
		panel_2.add(lblPreferencias);
		
		panelSelectButtons = new JPanel();
		panelSelectButtons.setBackground(Color.GRAY);
		panel_1.add(panelSelectButtons);
		panelSelectButtons.setLayout(new BorderLayout(0, 0));
		
		panel = new JPanel();
		panel.setBackground(Color.GRAY);
		panelSelectButtons.add(panel, BorderLayout.CENTER);
		panel.setLayout(new GridLayout(0, 2, 0, 0));
		
		chckbxTunning = new JCheckBox("Tunning");
		chckbxTunning.setBackground(Color.GRAY);
		panel.add(chckbxTunning);
		
		chckbxEquipamiento = new JCheckBox("Equipamiento");
		chckbxEquipamiento.setBackground(Color.GRAY);
		panel.add(chckbxEquipamiento);
		
		chckbxRecambios = new JCheckBox("Recambios");
		chckbxRecambios.setBackground(Color.GRAY);
		panel.add(chckbxRecambios);
		
		chckbxReparaciones = new JCheckBox("Reparaciones");
		chckbxReparaciones.setBackground(Color.GRAY);
		panel.add(chckbxReparaciones);
		
		chckbxPuestaPunto = new JCheckBox("Puesta a Punto");
		chckbxPuestaPunto.setBackground(Color.GRAY);
		panel.add(chckbxPuestaPunto);
		
		chckbxMantenimiento = new JCheckBox("Mantenimiento");
		chckbxMantenimiento.setBackground(Color.GRAY);
		panel.add(chckbxMantenimiento);
		
		chckbxCompeticion = new JCheckBox("Competicion");
		chckbxCompeticion.setBackground(Color.GRAY);
		panel.add(chckbxCompeticion);
		
		chckbxVehiculosOcasion = new JCheckBox("Vehiculos Ocasion");
		chckbxVehiculosOcasion.setBackground(Color.GRAY);
		panel.add(chckbxVehiculosOcasion);
		
		panelComentarios = new JPanel();
		panelComentarios.setBackground(Color.GRAY);
		panel_1.add(panelComentarios);
		panelComentarios.setLayout(new GridLayout(0, 1, 0, 1));
		
		panelComentario1 = new JPanel();
		panelComentario1.setBackground(Color.GRAY);
		panelComentarios.add(panelComentario1);
		panelComentario1.setLayout(new GridLayout(1, 0, 0, 0));
		
		lblComentarios = new JLabel("Comentarios: ");
		lblComentarios.setBackground(Color.GRAY);
		lblComentarios.setHorizontalAlignment(SwingConstants.RIGHT);
		panelComentario1.add(lblComentarios);
		
		textComentarios = new TextArea();
		textComentarios.setPreferredSize(new Dimension(250, 50));
		textComentarios.setMaximumSize(new Dimension(500, 500));
		panelComentario1.add(textComentarios);
		
		panelComentario2 = new JPanel();
		panelComentario2.setBackground(Color.GRAY);
		panelComentarios.add(panelComentario2);
		panelComentario2.setLayout(new GridLayout(1, 0, 0, 0));
		
		lblPedidos = new JLabel("Pedidos: ");
		lblPedidos.setBackground(Color.GRAY);
		lblPedidos.setHorizontalAlignment(SwingConstants.RIGHT);
		panelComentario2.add(lblPedidos);
		
		textPedidos = new TextArea();
		textPedidos.setPreferredSize(new Dimension(250, 50));
		textPedidos.setMaximumSize(new Dimension(500, 500));
		panelComentario2.add(textPedidos);
	}

}
