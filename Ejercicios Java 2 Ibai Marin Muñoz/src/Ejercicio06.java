import java.util.Scanner;

public class Ejercicio06 {
	/*
	 * PROGRAMA QUE PIDA UN NUMERO ENTERO POR TECLADO Y DIBUJE UN TRIANGULO CON * DE TANTAS FILAS POR PANTALLA COMO INDIQUE EL NUMERO LEIDO
	 * *
	 * **
	 * ***
	 * ****
	 * *****
	 */
	public static void main(String[] args) {
		@SuppressWarnings("resource")
		Scanner sc= new Scanner(System.in);
		int numT, cont=1;
		System.out.println("Introduce un numero");
		
		numT=sc.nextInt();
		for (int i = 1; i <= numT; i++) {
			for (int j = 0; j < cont; j++) {
				System.out.print("*");
			}
			System.out.println();
			cont++;
		}
	}

}
