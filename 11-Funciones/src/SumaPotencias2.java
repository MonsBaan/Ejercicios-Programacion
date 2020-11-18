import java.util.Scanner;

public class SumaPotencias2 {
	/* PROGRAMA QUE MEDIANTE LLAMADAS A LA FUNCION POTENCIA CALCULE LA SUMA DE LAS POTENCIAS DE UN NUMERO ELEVADO A SI MISMO DESDE EL 1 A UN NUMERO
	 * CALCULA Y DEVUELVE COMO UN DOUBLE LA POTENCIA DE UN NUMERO ENTERO ELEVADO A OTRO NUMERO ENTERO POSITIVO
	 * 
	 * PARTE2: PEDIR UN NUMERO POR TECLADO Y SUMAR LAS POTENCIAS DEL 1 HASTA ESE NUMERO
	 * EJ: 1^1+2^2+3^3...
	 */
	public static void main(String[] args) {
		@SuppressWarnings("resource")
		Scanner sc= new Scanner(System.in);
		int num1;
		double potRes = 0;
		System.out.println("Introduce el valor que quieras");
		num1=sc.nextInt();
		for (int i = 1; i < num1; i++) {
			potRes=potRes + potencias(i, i);
		}
		System.out.println("El resultado es " +potRes);

	}
	public static double potencias(int a, int b) {
		double resultado=1;
		for (int i = 0; i < b; i++) {
			resultado=resultado*a;
		}
		return resultado;

	}
}
