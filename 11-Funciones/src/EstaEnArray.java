import java.util.Scanner;

public class EstaEnArray {
	/*FUNCIONES:
	 * LLENAR ARRAY- FUNCION QUE LLENA EL ARRAY RECIBIDO COMO PARAMETRO CON 25 NUMEROS ALEATORIOS ENTEROS POSITIVOS MENORES QUE 100.
	 * 
	 * MOSTRAR ARRAY- FUNCION QUE MUESTRA POR PANTALLA EL ARRAY RECIBIDO COMO PARAMETRO
	 * 
	 * ESTAN- FUNCION QUE DEVUELVA true SI LOS DOS NUMEROS RECIBIDOS COMO PARAMETROS ESTAN EN EL ARRAY RECIBIDO COMO PARAMETRO
	 * 		Y false EN CASO CONTRARIO
	 */
	public static void main(String[] args) {
		@SuppressWarnings("resource")
		Scanner sc=new Scanner(System.in);
		int num1, num2;
		int[] numeros;
		numeros=new int[25];

		llenarArray(numeros);
		mostrarArray(numeros);

		System.out.println("\n\nEscoge dos numeros para buscar en el array");
		System.out.println("Primer numero");
		num1=sc.nextInt();
		System.out.println("Segundo numero");
		num2=sc.nextInt();

		if (estanArray(numeros, num1, num2)==true) {
			System.out.println("Los numeros están en el array");
		}else {
			System.out.println("Los numeros NO estan en el array");
		}


	}
	public static void llenarArray(int[] a) {
		for (int i = 0; i < a.length; i++) {
			a[i]= (int)(Math.random()*100);
		}
	}
	public static void mostrarArray(int[] a) {
		for (int i = 0; i < a.length; i++) {
			System.out.print(a[i]+" ");
		}
	}
	public static boolean estanArray(int[] a, int b, int c) {
		boolean res1 = false, res2 = false, resT = false;
		
		for (int i = 0; i < a.length; i++) {
			if (a[i]==b) {
				res1=true;
			}
			if (a[i]==c) {
				res2=true;
			}
		}
		if (res1&&res2) {
			resT=true;
		}
		return resT;
	}
}
