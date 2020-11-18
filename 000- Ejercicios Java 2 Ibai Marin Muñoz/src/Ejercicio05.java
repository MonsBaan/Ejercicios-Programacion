import java.util.Scanner;

public class Ejercicio05 {
	/*
	 * PROGRAMA QUE PIDA UN NUMERO "n" Y MUESTRE POR PANTALLA LA MULTIPLICACION DE LOS "n" PRIMEROS NUMEROS IMPARES
	 */
	public static void main(String[] args) {
		@SuppressWarnings("resource")
		Scanner sc=new Scanner(System.in);
		float numT, multi = 1;
		System.out.println("Escribe el numero que quieras");
		numT=sc.nextInt();

		for (int i = 0; i <= numT; i++) {
			if (i%2!=0) {
				multi=multi*i;
			} 
		}
		System.out.println("La multiplicacion de los primeros "+numT+" numeros es: "+multi);
	}

}
