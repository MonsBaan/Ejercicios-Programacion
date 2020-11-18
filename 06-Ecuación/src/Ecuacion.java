import java.util.Scanner;

public class Ecuacion {
	/*RESOLVER UNA ECUACI�N DE SEGUNDO GRADO
	 *PEDIR Y LEER POR TECLADO LOS TRES T�RMINOS DE UNA ECUACION DE SEGUNDO GRADO (INT).
	 *RESOLVER Y MOSTRAR POR PANTALLA LOS RESULTADOS DE LA ECUACI�N (FLOAT O DOUBLE)
	 *NOTA: CONTROLAR LOS DIFERENTES CASOS 
	 */
	@SuppressWarnings("resource")
	public static void main(String[] args) {
		int a, b, c;
		double resultado1, resultado2;
		Scanner sc;
		sc=new Scanner(System.in);

		//LECTURA DE TECLADO Y GUARDADO DE DATOS
		System.out.println("Introduzca el numero A");
		a=sc.nextInt();
		System.out.println("Introduzca el numero B");
		b=sc.nextInt();
		System.out.println("Introduzca el numero C");
		c=sc.nextInt();
		//NO SON ECUACIONES
		if (a==0 && b==0 && c==0) {
			System.out.println("No existe soluci�n, introduce un valor valido");
		} else if (a==0 && b==0) {
			System.out.println("No existe soluci�n, introduce un valor valido");
		}
		//SIN SOLUCI�N
		else if ((b*b)-(4*a*c) < 0) {
			System.out.println("No hay soluci�n");
		}
		//UNA SOLUCIONES
		else if (a==0) {
			resultado1=-c/b;
			System.out.println("Solo hay una soluci�n");
			System.out.println(resultado1);	
		}
		//DOS SOLUCIONES
		else {
			resultado1= (-b + Math.sqrt((b*b)-(4*a*c)))/(2*a);
			resultado2= (-b - Math.sqrt((b*b)-(4*a*c)))/(2*a);
			System.out.println("Hay dos soluciones");
			System.out.println(resultado1);
			System.out.println(resultado2);
		}

	}
}



