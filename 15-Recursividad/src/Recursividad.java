import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.SpringLayout;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JSeparator;
import javax.swing.JSplitPane;

public class Recursividad extends JFrame {

	private JPanel contentPane;
	private JTextField textNum2;
	private JTextField textPotencia;
	private JLabel lblFactorial;
	private JButton btnFactorial;
	private JTextField textFactorial;
	private JLabel lblNum1;
	private JButton btnPotencia;
	private JLabel lblPotencia;
	private JTextField textNum1;
	private JTextField textNum3;
	private JTextField textFibo;
	private JLabel lblFibonacci;
	private JButton btnFibo;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Recursividad frame = new Recursividad();
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
	public Recursividad() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		textFactorial = new JTextField();
		textFactorial.setBounds(123, 36, 125, 20);
		contentPane.add(textFactorial);
		textFactorial.setColumns(10);
		
		lblFactorial = new JLabel("Factorial");
		lblFactorial.setBounds(123, 11, 46, 14);
		contentPane.add(lblFactorial);
		
		btnFactorial = new JButton("Calcular Factorial");
		btnFactorial.setBounds(275, 35, 136, 23);
		contentPane.add(btnFactorial);
		
		textNum1 = new JTextField();
		textNum1.setBounds(10, 36, 86, 20);
		contentPane.add(textNum1);
		textNum1.setColumns(10);
		
		lblNum1 = new JLabel("Num");
		lblNum1.setBounds(10, 11, 46, 14);
		contentPane.add(lblNum1);
		
		textNum2 = new JTextField();
		textNum2.setBounds(10, 120, 86, 20);
		contentPane.add(textNum2);
		textNum2.setColumns(10);
		
		textPotencia = new JTextField();
		textPotencia.setBounds(123, 120, 125, 20);
		contentPane.add(textPotencia);
		textPotencia.setColumns(10);
		
		btnPotencia = new JButton("Calcular Potencia");
		btnPotencia.setBounds(275, 119, 136, 23);
		contentPane.add(btnPotencia);
		
		lblPotencia = new JLabel("Potencia");
		lblPotencia.setBounds(123, 95, 46, 14);
		contentPane.add(lblPotencia);
		
		textNum3 = new JTextField();
		textNum3.setColumns(10);
		textNum3.setBounds(10, 199, 86, 20);
		contentPane.add(textNum3);
		
		textFibo = new JTextField();
		textFibo.setColumns(10);
		textFibo.setBounds(123, 199, 125, 20);
		contentPane.add(textFibo);
		
		btnFibo = new JButton("Calcular Fibonacci");
		btnFibo.setBounds(275, 198, 136, 23);
		contentPane.add(btnFibo);
		
		lblFibonacci = new JLabel("Fibonacci");
		lblFibonacci.setBounds(123, 174, 46, 14);
		contentPane.add(lblFibonacci);
		
		registrarEventos();
	}// FIN CONSTRUCTOR
	
	private void registrarEventos() {
		btnFactorial.addActionListener(new ActionListener() {
			//CALCULA EL FACTORIAL DEL NUMERO INTRODUCIDO
			@Override
			public void actionPerformed(ActionEvent arg0) {
				int num;
				if (!textNum1.getText().equals("")) {
					num=Integer.parseInt(textNum1.getText());
					textFactorial.setText(factorial(num)+"");
				}


			}
		});
		btnPotencia.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				int numPot, num;
				if (!textNum2.getText().equals("")) {
					numPot=Integer.parseInt(textNum2.getText());
					num=Integer.parseInt(textNum1.getText());
					
					textPotencia.setText(potencia(num, numPot)+"");
				}
				
				
			}
		});
		
		btnFibo.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				int num;
				if (!textNum3.getText().equals("")) {
					num=Integer.parseInt(textNum1.getText());
					textFibo.setText(fibonacci(num)+"");
				}
			}
		});
	}
	
	

	/*
	 * Funcion que calcula el factorial de un numero entero positivo recibido como parametro
	 */
	public double factorial (int num) {
		if (num<=1) {
			return 1;
		}else {
			return(num*factorial(num-1));
		}
	}
	
	public double potencia (int num, int numPot) {
		if (numPot==1) {
			return num;
		}if (numPot==0) {
			return 1;
		}else {
			return(num*potencia(num,numPot-1));
		}
	}
	
	public double fibonacci (int num) {
		if (num==1 || num==0) {
			return num;
		}else {
			return(fibonacci(num-1)+fibonacci(num-2));
		}
	}
}
