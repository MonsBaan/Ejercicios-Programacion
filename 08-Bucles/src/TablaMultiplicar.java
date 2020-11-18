import java.util.InputMismatchException;
import java.util.Scanner;

public class TablaMultiplicar {
	/*
	 * PROGRAMA QUE LEA UN NUMERO POR TECLADO Y MUESTRE POR PANTALLA SU TABLA DE MULTIPLICAR
	 * EJ: NUMERO 8
	 * 			8*1=8
	 * 			8*2=16
	 * 			....
	 */
	@SuppressWarnings("resource")
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String palabra;
		int num1;
		boolean error;
		num1=0;
		palabra="S";
		error=false;

		while (palabra.equalsIgnoreCase("S")) {
			do {
				try {
					System.out.println("Inserta el numero que quieras");
					num1= sc.nextInt();
					error=false;
				}catch (InputMismatchException e) {
					System.out.println("EL VALOR INTRODUCIDO NO ES VALIDO");
					sc.next();
					error=true;
				}				
			} while (error);
			
			for (int cont = 1; cont <= 10; cont++) {
				System.out.println(""+num1+" x "+cont+" = " +num1 * +cont);
			}
			//QUIERES CALCULAR OTRA TABLA? (S/N)
			System.out.println("Quieres calcular una tabla nueva? (S/N)");
			palabra= sc.next();
		}
			System.out.println("Gracias por utilizar el algoritmo avanzado de sumas de numeros y sus duplicados en base decimal");
		
	}
}

