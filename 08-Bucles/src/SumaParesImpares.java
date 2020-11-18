import java.util.Scanner;

public class SumaParesImpares {
	/*
	 * PROGRAMA QUE MUESTRE EL SIGUIENTE MENÚ POR PANTALLA:
	 * 		1-Sumar Pares
	 * 		2-Sumar Impares
	 * 		3-Sumar Todos
	 * 		4-Finalizar Programa
	 * UNA VEZ ELEGIDA LA OPCION EL PROGRAMA REALIZARA LA OPERACION CORRESPONDIENTE CON LOS NUMEROS INTRODUCIDOS POR TECLADO HASTA QUE SE TECLEE EL 0
	 * EN ESE MOMENTO SE MOSTRARÁ EL RESULTADO
	 */
	public static void main(String[] args) {
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
		int menu, menu1, menuBuff;
		menuBuff=0;



		//INICIO PROGRAMA


		//SELECCION DE MENU	
		do {
			System.out.println("Elige una opción");
			System.out.println("1- Sumar Pares");
			System.out.println("2- Sumar Impares");
			System.out.println("3- Sumar Todos");
			System.out.println("4- Fin de programa");
			menu=sc.nextInt();
			switch (menu) {

			//SUMA PARES
			case 1:
				System.out.println("Has seleccionado el numero 1: Sumar Pares");
				do {
					System.out.println("Introduce el numero que quieras (Introduce un 0 para salir del programa)");
					menu1=sc.nextInt();
					if (menu1%2==0) {
						menuBuff=menuBuff+menu1;
					}
				} while (menu1!=0);
				System.out.println("La suma de los numeros pares introducidos es: "+menuBuff);
				menuBuff=0; /* RESETEA EL BUFFER  */
				break;

				//SUMA IMPARES
			case 2:			
				System.out.println("Has seleccionado el numero 2: Sumar Impares");
				do {
					System.out.println("Introduce el numero que quieras (Introduce un 0 para salir del programa)");
					menu1=sc.nextInt();
					if (menu1%2!=0) {
						menuBuff=menuBuff+menu1;
					}
				} while (menu1!=0);
				System.out.println("La suma de los numeros impares introducidos es: "+menuBuff);
				menuBuff=0; /* RESETEA EL BUFFER  */
				break;

				//SUMA TODOS
			case 3:			
				System.out.println("Has seleccionado el numero 3: Sumar Todos");
				do {
					System.out.println("Introduce el numero que quieras (Introduce un 0 para salir del programa)");
					menu1=sc.nextInt();
					menuBuff=menuBuff+menu1;
				} while (menu1!=0);
				System.out.println("La suma de los numeros introducidos es: "+menuBuff);
				menuBuff=0; /* RESETEA EL BUFFER  */
				break;

				//SALIR
			case 4: 			
				System.out.println("Adios!");
				break;

				//VALOR INCORRECTO
			default:			
				System.out.println("Error en switch (menu) espera... como estas leyendo esto?");//DEBUG
				break;
			} 
		}while (menu!=4);

	}
}

