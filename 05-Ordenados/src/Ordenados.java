import java.util.Scanner;

public class Ordenados {
	/*PROGRAMA QUE LEA DOS NUMEROS POR TECLADO Y LOS MUESTRE POR PANTALLA EN ORDEN ASCENDENTE
	 *DE MENOR A MAYOR 
	 */
	@SuppressWarnings("resource")
	public static void main(String[] args) {
		
		//DECLARACION DE VARIABLES
		int valor1, valor2;
		Scanner sc;
		sc=new Scanner(System.in);
		
		//LECTURA DE NUMEROS
		System.out.println("Introduce el primer numero");
		valor1=sc.nextInt();
		System.out.println("Introduce el segundo numero");
		valor2=sc.nextInt();
		
		//ORDENAR NUMEROS
	if (valor1 > valor2) {
			System.out.println("Los numeros en orden ascendente son" +valor2+ "y" +valor1);
		} else if (valor2 < valor1) {
			System.out.println("Los numeros en orden ascendente son" +valor1+ "y" +valor2);
			} else {
			System.out.println("Los numeros son iguales " +valor1+ " y " +valor2);
			}
		}
	}
