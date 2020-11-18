import java.util.Scanner;

public class Adivinar {
	/*
	 * GENERAR UN NUMERO DEL 1 AL 100
	 * 
	 * EL JUGADOR TIENE 10 INTENTOS COMO MAXIMO PARA ADIVINAR EL NUMERO
	 * SE LE DIRÁ SI EL NUMERO ES MAYOR O MENOR
	 * 
	 * SE LE INDICARA AL FINAL DE LOS 10 INTENTOS SI SE HA ADIVINADO EL NUMERO
	 */
	public static void main(String[] args) {
		@SuppressWarnings("resource")
		Scanner sc=new Scanner(System.in);
		int randomNum, num;

		System.out.println(randomNum= (int) (Math.random()*99));

		System.out.println("Descubre el numero del 0 al 100 que se ha creado, tienes 10 intentos");



		for (int i = 1; i <= 10; i++) {
			System.out.println("\nIntento numero: " +i);
			num=sc.nextInt();
			if (i==10) {
				System.out.println("\n\nHas perdido");
			}else if (num < randomNum) {
				System.out.println("El numero que buscas es MAYOR que "+num);
			}else if (num>randomNum) {
				System.out.println("El numero que buscas es MENOR que "+num);
			}else if (num == randomNum) {
				i=10;
				System.out.println("Has acertado!");
			}
		}
	}
}








