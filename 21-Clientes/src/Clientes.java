import java.awt.BorderLayout;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTabbedPane;

@SuppressWarnings("serial")
public class Clientes extends JFrame {

	private JPanel contentPane;
	private JTabbedPane tabbedPane;
	private Altas panelAltas;
	private Bajas panelBajas;
	private Modificaciones panelModificaciones;


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Clientes frame = new Clientes();
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
	public Clientes() {
		setTitle("Gestion");
		setResizable(false);

		tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		getContentPane().add(tabbedPane, BorderLayout.CENTER);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 300, 381);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));

		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		contentPane.add(tabbedPane, BorderLayout.CENTER);

		panelAltas = new Altas();
		panelBajas = new Bajas();
		panelModificaciones = new Modificaciones();

		tabbedPane.add("Altas", panelAltas);
		tabbedPane.add("Bajas", panelBajas);
		tabbedPane.add("Modificaciones", panelModificaciones);
		
		inicializar();

	}
	public void inicializar() {

	}//FIN INICIALIZAR

}




