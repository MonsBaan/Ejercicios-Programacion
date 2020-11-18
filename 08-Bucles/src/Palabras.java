import java.util.Scanner;

public class Palabras {
	/*PROGRAMA QUE LEA UN NUMERO POR TECLADO ("OBLIGAR" A QUE SE META UN NUMERO POSITIVO)
	 * MIENTRAS EL NUMERO QUE EL USUARIO META POR TECLADO NO SEA >0, PEDIRLE EL NUMERO DE NUEVO
	 * UNA VEZ METIDO UN NUMERO POSITIVO, LEEMOS UNA PALABRA POR TECLADO, Y MOSTRAMOS POR
	 * PANTALLA LA PALABRA LEIDA TANTAS VECES COMO INDIQUE EL NUMERO
	 * 
	 */
	@SuppressWarnings("resource")
	public static void main(String[] args) {
		//VARIABLES
		Scanner sc;
		sc=new Scanner(System.in);

		String palabra;
		int num;
		num=0;	
		
		
		System.out.println("Introduce el numero de veces que quieras ver la palabra repetida");
		
		//INTRODUCCION DEL NUMERO Y FILTRO NUMERO
		num=sc.nextInt();
		while (num<=0) {
			System.out.println("Introduce un numero valido");
			num=sc.nextInt();
		}
		
		//INTRODUCCION DE LA PALABRA
		System.out.println("Introduce la palabra que quieras repetir "+num+" veces");
		palabra=sc.next();
		
		//REPETICION DE LA PALABRA "a" VECES
		for (int cont = 0; cont < num; cont++) {
			System.out.print(""+palabra+" ");
		}

	}

}
