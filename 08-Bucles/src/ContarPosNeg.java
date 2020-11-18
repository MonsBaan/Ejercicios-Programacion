import java.util.Scanner;

public class ContarPosNeg {
	/*PROGRAMA QUE LEA 15 NUMEROS POR TECLADO Y AL FINAL NOS DIGA CUANTOS ERAN
	 * CUANTOS POSITIVOS, NEGATIVOS Y CUANTOS NULOS (VALOR 0)
	 */
	@SuppressWarnings("resource")
	public static void main(String[] args) {
		int a, b, c, d, e;
		Scanner sc;
		sc =new Scanner(System.in);
		//a=ContadorNumeros, b=Positivo, c=Negativo, d=Nulo
		a=0;
		b=0; 
		c=0;
		d=0;
		while (a<15) {
			System.out.println("Añade un Numero");
			e=sc.nextInt();
			if (e > 0) {
				b++;
			} else if (e == 0) {
				d++;
			}else {
				c++;
			}
			a++;
			System.out.print("Numeros Restantes por añadir: ");
			System.out.println(15 -a);
		}
		//Añadir ++ a las variables incrementa la variable en 1
		System.out.println("Se han introducido:");
		System.out.println("Positivos: " +b);
		System.out.println("Negativos: " +c);
		System.out.println("Nulos: " +d);
	}

}


