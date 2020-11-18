import java.util.Scanner;

public class Ejercicio03 {
	/*
	 * PROGRAMA QUE PIDA UN NUMERO ENTRE 0 Y 999999999 Y LO MUESTRE POR PANTALLA CON LAS CIFRAS AL REVES
	 * EJ:	123456
	 * 		654321
	 */
	public static void main(String[] args) {
		int numT;
		@SuppressWarnings("resource")
		Scanner sc=new Scanner(System.in);
		System.out.println("Introduce un numero entre 0 y 999.999.999");
		numT=sc.nextInt();
		if (numT<0 || numT>999999999) {
			System.out.println("Valor no valido");
		}else {
			String num= Integer.toString(numT);
			for (int i = num.length(); i>0; i--) {
				System.out.print(num.charAt(i-1));
			}
		}
	}
}


