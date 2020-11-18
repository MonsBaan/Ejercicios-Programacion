import java.util.Scanner;

public class Multiplos {
	/*PROGRAMA QUE LEA UN NUMERO POR TECLADO Y MUESTRE POR PANTALLA LOS MULTIPLOS DE 6
	 * DESDE EL 1 HASTA EL NUMERO METIDO POR TECLADO
	 * 
	 * EJ: Introduce un numero: 23
	 * 		Los multiplos del 6 hasta el 23 son: 6, 12...
	 * 
	 */
	public static void main(String[] args) {
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
		int num; /*calc;
		calc=0;*/

		System.out.println("Introduce hasta el numero que quieres ver los multiplos de 6: ");
		num=sc.nextInt();

		//BUCLE ROBERTO
		System.out.println("Los multiplos del 6 hasta el "+num+" son:");
		for (int cont = 6; cont <= num; cont+=6) {
			System.out.print(cont+", ");
		}

	}










	/*BUCLE IBAI
	System.out.println("Los multiplos del 6 hasta el "+num+" son:");
	for (int cont = 1; cont <= num; cont++) {
		if (cont%6 == 0) {
			System.out.print(cont+", ");
		}
	}
	*/



	/*PROGRAMA 1
	 * @SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
		int num, calc;
		System.out.println("Introduce cuantos multiplos de 6 quieres");
		num = sc.nextInt();
		System.out.print("Los multiplos del 6 hasta el "+num+" son: ");
		for (int cont = 1; cont <= num; cont++) {
			calc= 6*cont;
			if (cont < num) {
				System.out.print(""+calc+", ");
			} else if (cont == num) {
				System.out.print(calc);
			}
		}
	 */



}


