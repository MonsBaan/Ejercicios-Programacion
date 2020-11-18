import java.util.Scanner;

public class Notas {
	/*PROGRAMA QUE LEA UNA NOTA UMERICA ENTERA POR TECLADO Y MUESTRE POR PANTALLA EL VALOR DE LA NOTA EN FORMA DE TEXTO SEGÚN LA SIGUIENTE TABLA:
	 * NOTA:
	 * 		0, 1, 2	: Muy deficiente
	 * 		3, 4	: Insuficiente
	 * 		5		: Suficiente
	 * 		6		: Bien
	 * 		7, 8	: Notable
	 * 		9, 10	: Sobresaliente
	 * 
	 */
	@SuppressWarnings("resource")
	public static void main(String[] args) {
		Scanner sc;
		sc =new Scanner(System.in);
		int nota;

		//INTRODUCE LA NOTA
		System.out.println("Introduce la Nota del Alumno");
		nota=sc.nextInt();
		//SWITCH
		switch (nota) {
		case 0, 1, 2: System.out.println("Muy Deficiente");
		break;
		case 3, 4: System.out.println("Insuficiente");
		break;
		case 5: System.out.println("Suficiente");
		break;
		case 6: System.out.println("Bien");
		break;
		case 7, 8: System.out.println("Notable");
		break;
		case 9, 10: System.out.println("Sobresaliente");
		break;

		default:
			System.out.println("Introduce un valor valido");
		break;
		}
		}
	}

