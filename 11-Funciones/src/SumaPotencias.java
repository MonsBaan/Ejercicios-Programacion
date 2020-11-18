import java.util.Scanner;

public class SumaPotencias {
	/* PROGRAMA QUE MEDIANTE LLAMADAS A LA FUNCION POTENCIA CALCULE LA SUMA DE LAS POTENCIAS DE UN NUMERO ELEVADO A SI MISMO DESDE EL 1 A UN NUMERO
	 * CALCULA Y DEVUELVE COMO UN DOUBLE LA POTENCIA DE UN NUMERO ENTERO ELEVADO A OTRO NUMERO ENTERO POSITIVO
	 */
	public static void main(String[] args) {
		@SuppressWarnings("resource")
		Scanner sc= new Scanner(System.in);
		int num1, num2;
		System.out.println("Introduce el valor que quieras");
		num1=sc.nextInt();
		num2=sc.nextInt();
		System.out.println(potencias(num1, num2));

	}
	public static double potencias(int a, int b) {
		double resultado = 1;
		for (int i = 0; i < b; i++) {
			resultado=a*resultado;
		}
		return resultado;

	}
}
