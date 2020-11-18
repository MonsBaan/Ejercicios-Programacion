import java.util.Scanner;

public class Sumar {
	/*
	 * PROGRAMA QUE PIDA DOS NUMEROS POR TECLADO Y MEDIANTE LLAMADAS A FUNCION "SUMA" OBTENER EL RESULTADO DE LA SUMA Y MUESTRE EL RESULTADO
	 * POR PANTALLA
	 */

	public static void main(String[] args) {
		@SuppressWarnings("resource")
		Scanner sc=new Scanner(System.in);
		int num1, num2, resultado;
		
		System.out.println("Introduce el primer numero");
		num1=sc.nextInt();
		System.out.println("Introduce el segundo numero");
		num2=sc.nextInt();
		
		resultado=suma(num1, num2);
		System.out.println(resultado);
		
	}
//DECLARACION DE FUNCION
	public static int suma(int a, int b) {
		int sumar;
		sumar=a+b;
		return sumar;
		
	}


}
