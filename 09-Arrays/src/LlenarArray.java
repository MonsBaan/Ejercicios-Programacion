import java.util.Scanner;

public class LlenarArray {
	/*
	 * LLENAR UN ARRAY DE 10 ELEMENTOS CON 10 NUMEROS ENTEROS INTRODUCIDOS POR TECLADO
	 * UNA VEZ LLENO MOSTRARLO POR PANTALLA EN ORDEN INVERSO
	 */
	@SuppressWarnings("resource")
	public static void main(String[] args) {
		Scanner sc= new Scanner(System.in);
		int[] numeros;
		int teclado;
		numeros= new int[10];

		for (int cont = 0; cont < numeros.length; cont++) {
			System.out.print("Introduce el valor en posicion " + cont);
			teclado=sc.nextInt();
			numeros[cont]=teclado;
		}
		System.out.println("Los valores introducidos en orden inverso son:");
		for (int cont = 9; cont >= 0; cont--) {
			System.out.println(numeros[cont]);
		}


	}
}


