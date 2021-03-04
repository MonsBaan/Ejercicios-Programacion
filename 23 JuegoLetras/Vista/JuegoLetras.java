import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import javax.swing.JButton;

public class JuegoLetras extends JFrame {

	private JPanel contentPane;
	private JRadioButton rbFacil;
	private JRadioButton rbMedio;
	private JRadioButton rbDificil;
	private JButton btnComprobar;
	private JButton btnComenzar;
	private AreaDibujo areaDibujo;
	private ButtonGroup grpNivel;
	private EventosJuegoLetras eventosJuegoLetras;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JuegoLetras frame = new JuegoLetras();
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
	public JuegoLetras() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 10, 1050, 975);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Elige Nivel:");
		lblNewLabel.setBounds(47, 44, 86, 14);
		contentPane.add(lblNewLabel);
		
		rbFacil = new JRadioButton("F\u00E1cil");
		rbFacil.setSelected(true);
		rbFacil.setBounds(47, 78, 74, 23);
		contentPane.add(rbFacil);
		
		rbMedio = new JRadioButton("Medio");
		rbMedio.setBounds(47, 116, 86, 23);
		contentPane.add(rbMedio);
		
		rbDificil = new JRadioButton("Dif\u00EDcil");
		rbDificil.setBounds(47, 157, 79, 23);
		contentPane.add(rbDificil);
		
		grpNivel=new ButtonGroup();
		grpNivel.add(rbFacil);
		grpNivel.add(rbMedio);
		grpNivel.add(rbDificil);
		
		btnComenzar = new JButton("Comenzar");
		btnComenzar.setBounds(20, 197, 113, 23);
		contentPane.add(btnComenzar);
		
		btnComprobar = new JButton("Comprobar");
		btnComprobar.setEnabled(false);
		btnComprobar.setBounds(20, 244, 113, 23);
		contentPane.add(btnComprobar);
		
		areaDibujo=new AreaDibujo(this);
		areaDibujo.setBounds(150, 20, 850, 900);
		areaDibujo.setBackground(Color.cyan);
		contentPane.add(areaDibujo);
		
		
		eventosJuegoLetras=new EventosJuegoLetras(this);
	}

	public JRadioButton getRbFacil() {
		return rbFacil;
	}

	public void setRbFacil(JRadioButton rbFacil) {
		this.rbFacil = rbFacil;
	}

	public JRadioButton getRbMedio() {
		return rbMedio;
	}

	public void setRbMedio(JRadioButton rbMedio) {
		this.rbMedio = rbMedio;
	}

	public JRadioButton getRbDificil() {
		return rbDificil;
	}

	public void setRbDificil(JRadioButton rbDificil) {
		this.rbDificil = rbDificil;
	}

	public JButton getBtnComprobar() {
		return btnComprobar;
	}

	public void setBtnComprobar(JButton btnComprobar) {
		this.btnComprobar = btnComprobar;
	}

	public JButton getBtnComenzar() {
		return btnComenzar;
	}

	public void setBtnComenzar(JButton btnComenzar) {
		this.btnComenzar = btnComenzar;
	}

	public AreaDibujo getAreaDibujo() {
		return areaDibujo;
	}

	public void setAreaDibujo(AreaDibujo areaDibujo) {
		this.areaDibujo = areaDibujo;
	}

	public ButtonGroup getGrpNivel() {
		return grpNivel;
	}

	public void setGrpNivel(ButtonGroup grpNivel) {
		this.grpNivel = grpNivel;
	}
	
	public void estadoBotones(boolean estado) {
		btnComenzar.setEnabled(estado);
		rbFacil.setEnabled(estado);
		rbMedio.setEnabled(estado);
		rbDificil.setEnabled(estado);
	}
	
}










