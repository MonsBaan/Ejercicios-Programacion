import java.util.Scanner;

public class Ejercicio07 {
	/*
	 * PROGRAMA QUE PIDA UN NUMERO ENTERO POR TECLADO Y DIBUJE POR PANTALLA UN TRIANGULO DE NUMEROS DE TANTAS FILAS COMO INDIQUE EL NUMERO LEIDO
	 * 1						1						12345
	 * 12						21						1234
	 * 123						321						123
	 * 1234						4321					12
	 * 12345					54321					1
	 */
	public static void main(String[] args) {
		@SuppressWarnings("resource")
		Scanner sc= new Scanner(System.in);
		int numT, cont=1, numTAux = 0;

		System.out.println("Introduce un numero");
		numT=sc.nextInt();
		System.out.println();
		for (int i = 1; i <= numT; i++) {
			for (int j = 0; j < cont; j++) {
				System.out.print(j+1);
			}
			System.out.println();
			cont++;
		}

		System.out.println();
		cont=0;
		for (int i = 1; i <= numT; i++) {
			for (int j = cont; j >= 0; j--) {
				System.out.print(j+1);
			}
			System.out.println();
			cont++;
		}

		System.out.println();
		cont=0;
		numTAux=numT;
		for (int i = numT; i >= 0; i--) {
			for (int j = 0; j < numTAux; j++) {
				System.out.print(j+1);
			}
			System.out.println();
			numTAux--;
		}
	}
}




