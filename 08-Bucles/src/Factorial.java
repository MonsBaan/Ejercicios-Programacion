import java.util.Scanner;

public class Factorial {
	/*LEER NUMERO ENTEROS POR TECLADO HASTA QUE SE TECLEE UN NUMERO NEGATIVO
	 * PARA CADA NUMERO SE MOSTRARA POR PANTALLA EL FACTORIAL DE DICHO NUMERO
	 * num -> entero
	 * resultado -> double
	 */
	public static void main(String[] args) {
		@SuppressWarnings("resource")
		Scanner sc= new Scanner(System.in);
		int numT, cont1, factorial;
	
		numT=0; cont1=1; factorial=1;
				
		//LECTURA DE NUMERO
		do {
			System.out.println("Introduce un numero");
			numT=sc.nextInt();
			cont1=numT;
			//CALCULO FACTORIAL
			do {
				factorial=factorial*cont1;
				cont1--;
				
			} while (cont1>0);
			//APARICION POR PANTALLA
			System.out.println(factorial);
			} while (numT>0);
	}

}
