import java.util.Scanner;

public class Intercambio {
	/* LEER POR TECLADO DOS VALORES NUMERICOS Y GUARDARLOS EN DOS VARIABLES.
	 * MOSTRAR AMBOS VALORES EN PANTALLA (IDENTIFICANDOLOS).
	 * A CONTINUACI�N EL PROGRAMA INTERCAMBIAR� EL VALOR DE LAS DOS VARIABLES.
	 * VOLVER A MOSTRAR EL VALOR DE LAS DOS VARIABLES PARA COMPROBAR QUE SE HAN INTERCAMBIADO
	 */
	@SuppressWarnings("resource")
	public static void main(String[] args) {
		//DECLARACI�N DE VARIABLES
		int valor1, valor2, valorTemp;
		
		//LECTURA
		Scanner sc;
		sc=new Scanner(System.in);
		
		//VALORES EN PANTALLA 1
		System.out.println("Introduce el valor del primer numero");
		valor1=sc.nextInt();
		
		System.out.println("Introduce el valor del segundo numero");
		valor2=sc.nextInt();
		
		System.out.println("N�mero 1: " +valor1);
		System.out.println("N�mero 2: " +valor2);
		
		//INTERCAMBIO
		valorTemp=valor1;
		valor1=valor2;
		valor2=valorTemp;
		
		//VALORES EN PANTALLA 2
		System.out.println("N�mero 1 Intercambiado: " +valor1);
		System.out.print("N�mero 2 Intercambiado: " +valor2);
	}

}
