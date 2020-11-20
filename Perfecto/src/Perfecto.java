import java.util.Scanner;

public class Perfecto {
	/*
	 * FUNCION QUE DEVUELVA "TRUE" SI EL NUMERO RECIBIDO COMO PARAMETRO ES PERFECTO Y "FALSE" EN CASO CONTRARIO
	 * 
	 * NUMERO PERFECTO: NUMERO QUE ES IGUAL A LA SUMA DE TODOS SUS DIVISORES INCLUYENDO EL 1, PERO NO A SI MISMO
	 * 
	 * PROGRAMA QUE MEDIANTE LLAMADAS A LA FUNCION ANTERIOR, MUESTRE LOS NUMEROS PERFECTOS QUE HAY ENTRE 1 Y 100.00
	 */
	public static void main(String[] args) {
		@SuppressWarnings("resource")
		Scanner sc=new Scanner(System.in);
		int numT=0, cont=0;
		
		System.out.println("Escoge la cantidad de numeros hasta donde quieras contar los perfectos");
		numT=sc.nextInt();
		
		for (int i = 1; i < numT; i++) {
			if (esPerfecto(i)==true) {
				System.out.println(i);
				cont++;
			}else if (esPerfecto(i)==false) {
				
			}
		}
		System.out.println("Del 1 al "+numT+" hay "+cont+" numeros perfectos");
	}
	
	public static boolean esPerfecto(int num) {
		int numP=0;
		for (int i = 1; i < num; i++) {
			if (num%i==0) {
				numP=numP+i;
			}
		}
		if (numP==num) {
			return true;

		}else {
			return false;

		}
	}

}
