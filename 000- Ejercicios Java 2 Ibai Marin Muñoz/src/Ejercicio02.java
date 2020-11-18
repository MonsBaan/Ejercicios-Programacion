import java.util.Scanner;

public class Ejercicio02 {
	/*
	 * PROGRAMA QUE PIDA UN NUMERO ENTERO (DE 9 DIGITOS COMO MUCHO) POR TECLADO Y MUESTRE UN MENSAJE POR PANTALLA INDICANDO CUANTOS DIGITOS TIENE
	 * EJ: 	INTRODUCE UN NUMERO: 4568
	 * 		ESE NUMERO TIENE 4 DIGITOS
	 */
	public static void main(String[] args) {
		@SuppressWarnings("resource")
		Scanner sc=new Scanner(System.in);
		int numT = 0;
		int cont=0;
		System.out.println("Introduce un numero (9 digitos como maximo)");
		numT=sc.nextInt();
		String num= Integer.toString(numT);

		for (int i = 0; i < num.length(); i++) {
			if (num.charAt(i)== '-' || num.charAt(i)== '+' ) {

			}else {
				cont++;
			}
		}
		if (cont>9) {
			System.out.println("El numero excede el maximo de digitos");
		}else {
			System.out.println("Ese numero tiene "+cont+" digitos");
		}
	}
}
