import java.util.Scanner;

public class CambiaFilas {
	/*
	 * ARRAY BIDIMENSIONAL DE 6 FILAS Y 10 COLUMNAS. LLENARLO CON NUMEROS ALEATORIOS ENTEROS POSITIVOS DE DOS DIGITOS Y MOSTRARLO PON PANTALLA
	 * PEDIR POR TECLADO DOS FILAS (NUMEROS) Y FORZAR QUE ESTEN COMPRENDIDOS ENTRE LAS FILAS 1 Y 6
	 * 
	 * INTERCAMBIAR LOS ELEMENTOS DE ESAS FILAS
	 */
	public static final int FILAS=6;
	public static final int COLUMNAS=10;
	public static void main(String[] args) {
		@SuppressWarnings("resource")
		Scanner sc=new Scanner(System.in);
		@SuppressWarnings("unused")
		int randomNum, fila1, fila2;
		int[][] array;
		int[] arrayAux;
		array = new int [FILAS][COLUMNAS];
		arrayAux= new int [10];

		for (int fila = 0; fila < FILAS; fila++) {
			for (int columna = 0; columna < COLUMNAS; columna++) {
				array[fila][columna]= (randomNum= (int) (Math.random()*99+1));
				System.out.print(array[fila][columna]+" ");
			}
			System.out.println();
		}

		do {
			System.out.println("\nInserta un numero de fila del 1 al 6");
			fila1=sc.nextInt()-1;
		} while (fila1>=6 || fila1<0);

		do {
			System.out.println("Inserta el numero de la fila del 1 al 6 con la que desees intercambiar valores");
			fila2=sc.nextInt()-1;
		} while (fila2>=6 || fila2<0);

		for (int columna = 0; columna < COLUMNAS; columna++) {
			arrayAux[columna]=array[fila1][columna];
			array[fila1][columna]=array[fila2][columna];
			array[fila2][columna]= arrayAux[columna];
		}

		for (int fila = 0; fila < FILAS; fila++) {
			for (int columna = 0; columna < COLUMNAS; columna++) {
				System.out.print(array[fila][columna]+" ");
			}
			System.out.println();
		}

	}
}
