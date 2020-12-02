import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JSeparator;
import javax.swing.JSpinner;
import javax.swing.JToggleButton;
import javax.swing.SpinnerNumberModel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

@SuppressWarnings("serial")
public class Monoespacia2 extends JFrame {

	private JPanel contentPane;
	private JComboBox<String> clasesBox;
	private JLabel ClaseLabel;
	private JLabel lblConstitucionNum;
	private JLabel lblDestrezaNum;
	private JLabel lblFuerzaNum;
	private JLabel lblPrecisionNum;
	private JLabel lblResistenciaNum;
	private JLabel lblSentidosNum;
	private JRadioButton lblConstitucion;
	private JRadioButton lblDestreza;
	private JRadioButton lblFuerza;
	private JRadioButton lblPrecision;
	private JRadioButton lblResistencia;
	private JRadioButton lblSentidos;
	private JRadioButton lblArmas;
	private JRadioButton lblBiologia;
	private JRadioButton lblIngenieria;
	private JRadioButton lblMedicina;
	private JRadioButton lblSupervivencia;
	private JRadioButton lblPilotar;
	private JRadioButton lblUsos;
	private JLabel lblArmasNum;
	private JLabel lblBiologiaNum;
	private JLabel lblIngenieriaNum;
	private JLabel lblMedicinaNum;
	private JLabel lblPilotarNum;
	private JLabel lblSupervivenciaNum;
	private JSpinner contVida;
	private JLabel lblMonoImagen;
	@SuppressWarnings("unused")
	private ImageIcon MonoIcono = new ImageIcon("images\\MonkeyIcono.png");
	private ImageIcon MonoExpl = new ImageIcon("images\\MonoExpl.png");
	private ImageIcon MonoInge = new ImageIcon("images\\MonoInge.png");
	private ImageIcon MonoMedic = new ImageIcon("images\\MonoMedic.png");
	private ImageIcon MonoPil = new ImageIcon("images\\MonoPil.png");
	private ImageIcon MonoSol = new ImageIcon("images\\MonoSol.png");
	private JLabel lblVida;
	private JSpinner contUsos;
	private ButtonGroup seleccionTirada;
	private JSeparator separator;
	private JToggleButton tglbtnDosTiradas;
	private JLabel lblTirada1;
	private JLabel lblTirada2;
	private boolean turno=true;
	private JButton btnRoll;
	private JRadioButton[] arrayHabilidades;
	private JLabel[] arrayHabilidadesNum;



	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Monoespacia2 frame = new Monoespacia2();
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
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public Monoespacia2() {
		setIconImage(Toolkit.getDefaultToolkit().getImage("images\\MonkeyIcono.png"));
		setTitle("M O N O E S P A C I A D O S");
		seleccionTirada = new ButtonGroup();

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 566, 375);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		ClaseLabel = new JLabel("Clase");
		ClaseLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		ClaseLabel.setBounds(15, 15, 110, 14);
		contentPane.add(ClaseLabel);

		clasesBox = new JComboBox();
		clasesBox.setFont(new Font("Tahoma", Font.PLAIN, 17));
		clasesBox.setBounds(15, 33, 146, 30);
		contentPane.add(clasesBox);
		clasesBox.addItem("Elige tu clase");
		clasesBox.addItem("Explorador");
		clasesBox.addItem("Ingeniero");
		clasesBox.addItem("Médico");
		clasesBox.addItem("Piloto");
		clasesBox.addItem("Soldado");

		lblConstitucionNum = new JLabel("0");
		lblConstitucionNum.setBounds(338, 197, 16, 14);
		contentPane.add(lblConstitucionNum);

		lblDestrezaNum = new JLabel("0");
		lblDestrezaNum.setBounds(338, 217, 16, 14);
		contentPane.add(lblDestrezaNum);

		lblFuerzaNum = new JLabel("0");
		lblFuerzaNum.setBounds(338, 237, 16, 14);
		contentPane.add(lblFuerzaNum);

		lblPrecisionNum = new JLabel("0");
		lblPrecisionNum.setBounds(338, 257, 16, 14);
		contentPane.add(lblPrecisionNum);

		lblResistenciaNum = new JLabel("0");
		lblResistenciaNum.setBounds(338, 277, 16, 14);
		contentPane.add(lblResistenciaNum);

		lblSentidosNum = new JLabel("0");
		lblSentidosNum.setBounds(338, 297, 16, 14);
		contentPane.add(lblSentidosNum);

		lblArmasNum = new JLabel("0");
		lblArmasNum.setBounds(490, 197, 16, 14);
		contentPane.add(lblArmasNum);

		lblBiologiaNum = new JLabel("0");
		lblBiologiaNum.setBounds(490, 217, 16, 14);
		contentPane.add(lblBiologiaNum);

		lblIngenieriaNum = new JLabel("0");
		lblIngenieriaNum.setBounds(490, 237, 16, 14);
		contentPane.add(lblIngenieriaNum);

		lblMedicinaNum = new JLabel("0");
		lblMedicinaNum.setBounds(490, 257, 16, 14);
		contentPane.add(lblMedicinaNum);

		lblPilotarNum = new JLabel("0");
		lblPilotarNum.setBounds(490, 277, 16, 14);
		contentPane.add(lblPilotarNum);

		lblSupervivenciaNum = new JLabel("0");
		lblSupervivenciaNum.setBounds(490, 297, 16, 14);
		contentPane.add(lblSupervivenciaNum);

		separator = new JSeparator();
		separator.setOrientation(SwingConstants.VERTICAL);
		separator.setBounds(364, 196, 2, 117);
		contentPane.add(separator);

		lblConstitucion = new JRadioButton("Constituci\u00F3n");
		lblConstitucion.setEnabled(false);
		lblConstitucion.setBounds(224, 197, 109, 14);
		contentPane.add(lblConstitucion);

		lblDestreza = new JRadioButton("Destreza");
		lblDestreza.setEnabled(false);
		lblDestreza.setBounds(224, 217, 109, 14);
		contentPane.add(lblDestreza);

		lblFuerza = new JRadioButton("Fuerza");
		lblFuerza.setEnabled(false);
		lblFuerza.setBounds(224, 237, 109, 14);
		contentPane.add(lblFuerza);

		lblPrecision = new JRadioButton("Precisi\u00F3n");
		lblPrecision.setEnabled(false);
		lblPrecision.setBounds(224, 257, 109, 14);
		contentPane.add(lblPrecision);

		lblResistencia = new JRadioButton("Resistencia");
		lblResistencia.setEnabled(false);
		lblResistencia.setBounds(224, 277, 109, 14);
		contentPane.add(lblResistencia);

		lblSentidos = new JRadioButton("Sentidos");
		lblSentidos.setEnabled(false);
		lblSentidos.setBounds(224, 297, 109, 14);
		contentPane.add(lblSentidos);

		lblArmas = new JRadioButton("Armas");
		lblArmas.setEnabled(false);
		lblArmas.setBounds(375, 197, 109, 14);
		contentPane.add(lblArmas);

		lblBiologia = new JRadioButton("Biolog\u00EDa");
		lblBiologia.setEnabled(false);
		lblBiologia.setBounds(375, 217, 109, 14);
		contentPane.add(lblBiologia);

		lblIngenieria = new JRadioButton("Ingenier\u00EDa");
		lblIngenieria.setEnabled(false);
		lblIngenieria.setBounds(375, 237, 109, 14);
		contentPane.add(lblIngenieria);

		lblMedicina = new JRadioButton("Medicina");
		lblMedicina.setEnabled(false);
		lblMedicina.setBounds(375, 257, 109, 14);
		contentPane.add(lblMedicina);

		lblPilotar = new JRadioButton("Pilotar");
		lblPilotar.setEnabled(false);
		lblPilotar.setBounds(375, 277, 109, 14);
		contentPane.add(lblPilotar);

		lblSupervivencia = new JRadioButton("Supervivencia");
		lblSupervivencia.setEnabled(false);
		lblSupervivencia.setBounds(375, 297, 109, 14);
		contentPane.add(lblSupervivencia);

		lblVida = new JLabel("Puntos de Vida");
		lblVida.setEnabled(false);
		lblVida.setToolTipText("");
		lblVida.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblVida.setHorizontalAlignment(SwingConstants.LEFT);
		lblVida.setBounds(311, 19, 141, 44);
		contentPane.add(lblVida);

		contUsos = new JSpinner();
		contUsos.setFont(new Font("Tahoma", Font.BOLD, 18));
		contUsos.setEnabled(false);
		contUsos.setBounds(224, 69, 62, 47);
		contentPane.add(contUsos);

		lblUsos = new JRadioButton("-");
		lblUsos.setEnabled(false);
		lblUsos.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblUsos.setBounds(292, 69, 224, 47);
		contentPane.add(lblUsos);

		contVida = new JSpinner();
		contVida.setEnabled(false);
		contVida.setFont(new Font("Tahoma", Font.BOLD, 18));
		contVida.setBounds(224, 15, 62, 47);
		contentPane.add(contVida);

		lblMonoImagen = new JLabel("");
		lblMonoImagen.setIcon(null);
		lblMonoImagen.setBounds(40, 74, 100, 100);
		contentPane.add(lblMonoImagen);

		//INSERCION DE RADIOBUTTONS
		seleccionTirada.add(lblConstitucion);
		seleccionTirada.add(lblDestreza);
		seleccionTirada.add(lblFuerza);
		seleccionTirada.add(lblPrecision);
		seleccionTirada.add(lblResistencia);
		seleccionTirada.add(lblSentidos);
		seleccionTirada.add(lblArmas);
		seleccionTirada.add(lblBiologia);
		seleccionTirada.add(lblIngenieria);
		seleccionTirada.add(lblMedicina);
		seleccionTirada.add(lblPilotar);
		seleccionTirada.add(lblSupervivencia);
		seleccionTirada.add(lblUsos);

		tglbtnDosTiradas = new JToggleButton("Tirada Doble");
		tglbtnDosTiradas.setEnabled(false);
		tglbtnDosTiradas.setBounds(31, 289, 142, 30);
		contentPane.add(tglbtnDosTiradas);

		lblTirada1 = new JLabel("-");
		lblTirada1.setHorizontalAlignment(SwingConstants.CENTER);
		lblTirada1.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblTirada1.setBounds(50, 192, 100, 100);
		contentPane.add(lblTirada1);

		btnRoll = new JButton("Roll Dice");
		btnRoll.setEnabled(false);
		btnRoll.setFont(new Font("Tahoma", Font.PLAIN, 21));
		btnRoll.setBounds(299, 143, 130, 43);
		contentPane.add(btnRoll);

		inicializar();
		registrarEventos();
	}





	private void inicializar() {

		arrayHabilidades=new JRadioButton[13];
		arrayHabilidadesNum=new JLabel[12];

		arrayHabilidades[0]=lblConstitucion;
		arrayHabilidades[1]=lblDestreza;
		arrayHabilidades[2]=lblFuerza;
		arrayHabilidades[3]=lblPrecision;
		arrayHabilidades[4]=lblResistencia;
		arrayHabilidades[5]=lblSentidos;
		arrayHabilidades[6]=lblArmas;
		arrayHabilidades[7]=lblBiologia;
		arrayHabilidades[8]=lblIngenieria;
		arrayHabilidades[9]=lblMedicina;
		arrayHabilidades[10]=lblPilotar;
		arrayHabilidades[11]=lblSupervivencia;
		arrayHabilidades[12]=lblUsos;


		arrayHabilidadesNum[0]=lblConstitucionNum;
		arrayHabilidadesNum[1]=lblDestrezaNum;
		arrayHabilidadesNum[2]=lblFuerzaNum;
		arrayHabilidadesNum[3]=lblPrecisionNum;
		arrayHabilidadesNum[4]=lblResistenciaNum;
		arrayHabilidadesNum[5]=lblSentidosNum;
		arrayHabilidadesNum[6]=lblArmasNum;
		arrayHabilidadesNum[7]=lblBiologiaNum;
		arrayHabilidadesNum[8]=lblIngenieriaNum;
		arrayHabilidadesNum[9]=lblMedicinaNum;
		arrayHabilidadesNum[10]=lblPilotarNum;
		arrayHabilidadesNum[11]=lblSupervivenciaNum;

	}

	public void registrarEventos() {

		clasesBox.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {

				String clase= (String) clasesBox.getSelectedItem();
				switch (clase) {
				case "Explorador":
					contVida.setModel(new SpinnerNumberModel(7, 0, 7, 1));
					contUsos.setModel(new SpinnerNumberModel(3, 0, 3, 1));

					contVida.setEnabled(true);
					contVida.setValue(7);
					contUsos.setEnabled(true);
					contUsos.setValue(3);		
					lblUsos.setEnabled(true);


					lblMonoImagen.setIcon(MonoExpl);

					lblUsos.setText("PrimateDrone");
					lblConstitucionNum.setText("2");
					lblDestrezaNum.setText("3");
					lblFuerzaNum.setText("2");
					lblPrecisionNum.setText("1");
					lblResistenciaNum.setText("3");
					lblSentidosNum.setText("2");
					lblArmasNum.setText("1");
					lblBiologiaNum.setText("1");
					lblIngenieriaNum.setText("1");
					lblMedicinaNum.setText("2");
					lblPilotarNum.setText("2");
					lblSupervivenciaNum.setText("3");

					lblConstitucion.setEnabled(true);
					lblDestreza.setEnabled(true);
					lblFuerza.setEnabled(true);
					lblPrecision.setEnabled(true);
					lblResistencia.setEnabled(true);
					lblSentidos.setEnabled(true);
					lblArmas.setEnabled(true);
					lblBiologia.setEnabled(true);
					lblIngenieria.setEnabled(true);
					lblMedicina.setEnabled(true);
					lblPilotar.setEnabled(true);
					lblSupervivencia.setEnabled(true);
					btnRoll.setEnabled(true);
					tglbtnDosTiradas.setEnabled(true);
					lblVida.setEnabled(true);

					break;

				case "Ingeniero":
					contVida.setModel(new SpinnerNumberModel(7, 0, 7, 1));
					contUsos.setModel(new SpinnerNumberModel(3, 0, 3, 1));

					contVida.setEnabled(true);
					contVida.setValue(7);
					contUsos.setEnabled(true);
					contUsos.setValue(3);
					lblUsos.setEnabled(true);

					lblMonoImagen.setIcon(MonoInge);

					lblUsos.setText("SimiHerramienta");
					lblConstitucionNum.setText("2");
					lblDestrezaNum.setText("2");
					lblFuerzaNum.setText("3");
					lblPrecisionNum.setText("3");
					lblResistenciaNum.setText("2");
					lblSentidosNum.setText("1");
					lblArmasNum.setText("2");
					lblBiologiaNum.setText("1");
					lblIngenieriaNum.setText("3");
					lblMedicinaNum.setText("1");
					lblPilotarNum.setText("2");
					lblSupervivenciaNum.setText("1");

					lblConstitucion.setEnabled(true);
					lblDestreza.setEnabled(true);
					lblFuerza.setEnabled(true);
					lblPrecision.setEnabled(true);
					lblResistencia.setEnabled(true);
					lblSentidos.setEnabled(true);
					lblArmas.setEnabled(true);
					lblBiologia.setEnabled(true);
					lblIngenieria.setEnabled(true);
					lblMedicina.setEnabled(true);
					lblPilotar.setEnabled(true);
					lblSupervivencia.setEnabled(true);
					btnRoll.setEnabled(true);
					tglbtnDosTiradas.setEnabled(true);
					lblVida.setEnabled(true);

					break;

				case "Médico":
					contVida.setModel(new SpinnerNumberModel(4, 0, 4, 1));
					contUsos.setModel(new SpinnerNumberModel(3, 0, 3, 1));

					contVida.setEnabled(true);
					contVida.setValue(4);
					contUsos.setEnabled(true);
					contUsos.setValue(3);
					lblUsos.setEnabled(true);

					lblMonoImagen.setIcon(MonoMedic);

					lblUsos.setText("MonoAuxilios");
					lblConstitucionNum.setText("1");
					lblDestrezaNum.setText("2");
					lblFuerzaNum.setText("1");
					lblPrecisionNum.setText("3");
					lblResistenciaNum.setText("2");
					lblSentidosNum.setText("1");
					lblArmasNum.setText("1");
					lblBiologiaNum.setText("2");
					lblIngenieriaNum.setText("1");
					lblMedicinaNum.setText("2");
					lblPilotarNum.setText("1");
					lblSupervivenciaNum.setText("2");

					lblConstitucion.setEnabled(true);
					lblDestreza.setEnabled(true);
					lblFuerza.setEnabled(true);
					lblPrecision.setEnabled(true);
					lblResistencia.setEnabled(true);
					lblSentidos.setEnabled(true);
					lblArmas.setEnabled(true);
					lblBiologia.setEnabled(true);
					lblIngenieria.setEnabled(true);
					lblMedicina.setEnabled(true);
					lblPilotar.setEnabled(true);
					lblSupervivencia.setEnabled(true);
					btnRoll.setEnabled(true);
					tglbtnDosTiradas.setEnabled(true);
					lblVida.setEnabled(true);

					break;

				case "Piloto":
					contVida.setModel(new SpinnerNumberModel(4, 0, 4, 1));
					contUsos.setModel(new SpinnerNumberModel(3, 0, 3, 1));

					contVida.setEnabled(true);
					contVida.setValue(4);
					contUsos.setEnabled(true);
					contUsos.setValue(3);
					lblUsos.setEnabled(true);

					lblMonoImagen.setIcon(MonoPil);

					lblUsos.setText("Monolograma");
					lblConstitucionNum.setText("1");
					lblDestrezaNum.setText("3");
					lblFuerzaNum.setText("2");
					lblPrecisionNum.setText("2");
					lblResistenciaNum.setText("1");
					lblSentidosNum.setText("3");
					lblArmasNum.setText("2");
					lblBiologiaNum.setText("1");
					lblIngenieriaNum.setText("2");
					lblMedicinaNum.setText("1");
					lblPilotarNum.setText("3");
					lblSupervivenciaNum.setText("1");

					lblConstitucion.setEnabled(true);
					lblDestreza.setEnabled(true);
					lblFuerza.setEnabled(true);
					lblPrecision.setEnabled(true);
					lblResistencia.setEnabled(true);
					lblSentidos.setEnabled(true);
					lblArmas.setEnabled(true);
					lblBiologia.setEnabled(true);
					lblIngenieria.setEnabled(true);
					lblMedicina.setEnabled(true);
					lblPilotar.setEnabled(true);
					lblSupervivencia.setEnabled(true);
					btnRoll.setEnabled(true);
					tglbtnDosTiradas.setEnabled(true);
					lblVida.setEnabled(true);

					break;

				case "Soldado":
					contVida.setModel(new SpinnerNumberModel(9, 0, 9, 1));
					contUsos.setModel(new SpinnerNumberModel(3, 0, 3, 1));
					lblUsos.setEnabled(true);

					contVida.setEnabled(true);
					contVida.setValue(9);
					contUsos.setEnabled(true);
					contUsos.setValue(3);
					lblUsos.setEnabled(true);

					lblMonoImagen.setIcon(MonoSol);

					lblUsos.setText("MonoPistola");
					lblConstitucionNum.setText("3");
					lblDestrezaNum.setText("2");
					lblFuerzaNum.setText("3");
					lblPrecisionNum.setText("1");
					lblResistenciaNum.setText("3");
					lblSentidosNum.setText("2");
					lblArmasNum.setText("4");
					lblBiologiaNum.setText("1");
					lblIngenieriaNum.setText("2");
					lblMedicinaNum.setText("1");
					lblPilotarNum.setText("1");
					lblSupervivenciaNum.setText("3");

					lblConstitucion.setEnabled(true);
					lblDestreza.setEnabled(true);
					lblFuerza.setEnabled(true);
					lblPrecision.setEnabled(true);
					lblResistencia.setEnabled(true);
					lblSentidos.setEnabled(true);
					lblArmas.setEnabled(true);
					lblBiologia.setEnabled(true);
					lblIngenieria.setEnabled(true);
					lblMedicina.setEnabled(true);
					lblPilotar.setEnabled(true);
					lblSupervivencia.setEnabled(true);
					btnRoll.setEnabled(true);
					tglbtnDosTiradas.setEnabled(true);
					lblVida.setEnabled(true);

					break;

				default:
					contVida.setEnabled(false);
					contVida.setValue(0);
					contUsos.setEnabled(false);
					contUsos.setValue(0);

					lblMonoImagen.setIcon(null);

					lblConstitucion.setEnabled(false);
					lblDestreza.setEnabled(false);
					lblFuerza.setEnabled(false);
					lblPrecision.setEnabled(false);
					lblResistencia.setEnabled(false);
					lblSentidos.setEnabled(false);
					lblArmas.setEnabled(false);
					lblBiologia.setEnabled(false);
					lblIngenieria.setEnabled(false);
					lblMedicina.setEnabled(false);
					lblPilotar.setEnabled(false);
					lblSupervivencia.setEnabled(false);
					btnRoll.setEnabled(false);
					tglbtnDosTiradas.setEnabled(false);
					lblVida.setEnabled(false);

					lblConstitucionNum.setText("0");
					lblDestrezaNum.setText("0");
					lblFuerzaNum.setText("0");
					lblPrecisionNum.setText("0");
					lblResistenciaNum.setText("0");
					lblSentidosNum.setText("0");
					lblArmasNum.setText("0");
					lblBiologiaNum.setText("0");
					lblIngenieriaNum.setText("0");
					lblMedicinaNum.setText("0");
					lblPilotarNum.setText("0");
					lblSupervivenciaNum.setText("0");

					break;
				}

			}
		});

		contUsos.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent arg0) {
				if (contUsos.getValue().equals(0)) {
					lblUsos.setEnabled(false);
				} else {
					lblUsos.setEnabled(true);
				}
			}
		});		

		tglbtnDosTiradas.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				if (turno==true) {

					lblTirada1.setBounds(0, 192, 100, 100);

					lblTirada2 = new JLabel("-");
					lblTirada2.setHorizontalAlignment(SwingConstants.CENTER);
					lblTirada2.setFont(new Font("Tahoma", Font.PLAIN, 25));
					lblTirada2.setBounds(100, 192, 100, 100);
					contentPane.add(lblTirada2);

					turno=false;
				}else {

					contentPane.remove(lblTirada2);

					lblTirada1.setBounds(50, 192, 100, 100);


					turno=true;
				}				
			}
		});

		btnRoll.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				boolean uso=false;
				for (int i = 0; i < arrayHabilidades.length; i++) {
					if (arrayHabilidades[i].isSelected()) {
						uso=false;
						if (tglbtnDosTiradas.isSelected()) {
							lblTirada1.setText(tirarDado(uso, Integer.parseInt(arrayHabilidadesNum[i].getText())));
							lblTirada2.setText(tirarDado(uso, Integer.parseInt(arrayHabilidadesNum[i].getText())));

						}else {
							lblTirada1.setText(tirarDado(uso, Integer.parseInt(arrayHabilidadesNum[i].getText())));

						}

						break;
					}else if (arrayHabilidades[12].isSelected()) {
						uso=true;
						String clase= (String) clasesBox.getSelectedItem();
						switch (clase) {
						case "Explorador":
							if (tglbtnDosTiradas.isSelected()) {
								lblTirada1.setText(tirarDado(uso, Integer.parseInt(arrayHabilidadesNum[11].getText())));
								lblTirada2.setText(tirarDado(uso, Integer.parseInt(arrayHabilidadesNum[11].getText())));

							}else {
								lblTirada1.setText(tirarDado(uso, Integer.parseInt(arrayHabilidadesNum[11].getText())));
							}						
							
							break;//BREAK EXPLORADOR

						case "Ingeniero":
							if (tglbtnDosTiradas.isSelected()) {
								lblTirada1.setText(tirarDado(uso, Integer.parseInt(arrayHabilidadesNum[8].getText())));
								lblTirada2.setText(tirarDado(uso, Integer.parseInt(arrayHabilidadesNum[8].getText())));

							}else {
								lblTirada1.setText(tirarDado(uso, Integer.parseInt(arrayHabilidadesNum[8].getText())));
							}
							
							break;//BREAK INGENIERO

						case "Médico":
							if (tglbtnDosTiradas.isSelected()) {
								lblTirada1.setText(tirarDado(uso, Integer.parseInt(arrayHabilidadesNum[9].getText())));
								lblTirada2.setText(tirarDado(uso, Integer.parseInt(arrayHabilidadesNum[9].getText())));

							}else {
								lblTirada1.setText(tirarDado(uso, Integer.parseInt(arrayHabilidadesNum[9].getText())));
							}

							break;//BREAK MEDICO

						case "Piloto":
							if (tglbtnDosTiradas.isSelected()) {
								lblTirada1.setText(tirarDado(uso, Integer.parseInt(arrayHabilidadesNum[10].getText())));
								lblTirada2.setText(tirarDado(uso, Integer.parseInt(arrayHabilidadesNum[10].getText())));

							}else {
								lblTirada1.setText(tirarDado(uso, Integer.parseInt(arrayHabilidadesNum[10].getText())));

							}

							break;//BREAK PILOTO

						case "Soldado":
							if (tglbtnDosTiradas.isSelected()) {
								lblTirada1.setText(tirarDado(uso, Integer.parseInt(arrayHabilidadesNum[6].getText())));
								lblTirada2.setText(tirarDado(uso, Integer.parseInt(arrayHabilidadesNum[6].getText())));

							}else {
								lblTirada1.setText(tirarDado(uso, Integer.parseInt(arrayHabilidadesNum[6].getText())));

							}

							break;//BREAK SOLDADO

						default:
							break;
						}
						break;
						
					}
				}



			}
		});

	}
	private String tirarDado(boolean uso, int numeroHabilidad) {
		String tirada;
		int dado1, dado2;
		dado1=(int) (Math.random()*7+1);
		dado2=(int) (Math.random()*7+1);
		tirada=Integer.toString(dado1+dado2+numeroHabilidad);
		return tirada;


	}
}
