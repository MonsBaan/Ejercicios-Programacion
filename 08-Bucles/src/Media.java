import java.util.Scanner;

public class Media {
	/*PROGRAMA QUE LEA NUMEROS POR TECLADO HASTA QUE SE TECLEE EL 0
	 * AL FINAL DIRÁ CUANTOS ERAN MENORES QUE 10, CUANTOS MAYORES QUE 10 Y MOSTRARÁ LA MEDIA DE LOS MAYORES DE 5 
	 */
	public static void main(String[] args) {
		int num, men, may, calc, cont;
		float med;
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
		num = 1; men = 0; may = 0; calc=0; cont=0; med=0;

		//INTRODUCIR EL NUMERO
		do {
			System.out.println("Introduce el numero que desees (Finaliza el Programa escribiendo un 0)");
			num =sc.nextInt();

			//EVALUAR EL NUMERO
			if (num < 10) {
				men++;
			} else if (num > 10) {
				may++;
			}

			if (num > 5) {
				cont++;
				calc= calc+num;
			}
		} while (num!=0);

		//RESULTADOS
		med= (float)calc/cont;
		System.out.println("Has insertado "+men+" numero menores a 10");
		System.out.println("Has insertado "+may+" numero mayores a 10");
		System.out.print("La media de los numeros mayores a 5: ");
		System.out.println(+med);

	}
}


