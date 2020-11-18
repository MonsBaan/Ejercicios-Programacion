import java.util.Scanner;

public class NumerosEntre {
	/*LEER DOS NUMEROS POR TECLADO Y MOSTRAR POR PANTALLA TODOS LOS NUMEROS COMPRENDIDOS ENTRE AMBOS EN ORDEN ASCENDENTE. SE MOSTRARAN 10 NUMEROS POR FILA
	 * EJEMPLO: INTRODUCE UN NUMERO: 5
	 * 			INTRODUCE UN NUMERO: 20
	 * 			5 6 7 8 9 10 11 12 13 14
	 * 			15 16 17 18 19 20
	 */
	@SuppressWarnings("resource")
	public static void main(String[] args) {
		Scanner sc;
		sc= new Scanner(System.in);
		int num1, num2;
		int cont2= 0;
		//INTRODUCCION DE NUMEROS
		System.out.println("Introduce el primer numero");
		num1=sc.nextInt();
		System.out.println("Introduce el segundo numero");
		num2=sc.nextInt();
		//COMPARACION DE "num1" Y "num2"
		if (num1 < num2) {
				for (int cont1 = num1; cont1 <= num2; cont1++) {
					cont2++;
					if (cont2%10 != 0) {
						System.out.print(""+cont1+" ");

					}else {
						System.out.println(""+cont1+" ");
					}
				}
			}else {
				for (int cont1 = num2; cont1 <= num1; cont1++) {
					cont2++;
					if (cont2%10 != 0) {
						System.out.print(""+cont1+" ");

					}else {
						System.out.println(""+cont1+" ");
					}
				}
			}
}
}