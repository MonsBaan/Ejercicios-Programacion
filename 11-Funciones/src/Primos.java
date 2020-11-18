import java.util.Scanner;

public class Primos {
	/*
	 * FUNCION QUE DEVUELVE VERDADERO SI EL NUMERO RECIBIDO COMO PARAMETRO ES PRIMO, Y FALSO EL CASO CONTRARIO	
	 * (Contar el numero de divisiores, si es mayor que 2, el numero no es primo)
	 */
	public static void main(String[] args) {
		@SuppressWarnings("resource")
		Scanner sc=new Scanner(System.in);
		int num, cont;
		num=0; cont=0;

		System.out.println("\nIntroduce un numero que desee comprobar si es primo o no");
		num=sc.nextInt();

		if (esPrimoB(num)==true) {
			System.out.println("El numero "+num+" es primo");
		}else{
			System.out.println("El numero "+num+" no es primo");
		}

		//MOSTRAR "NUM" PRIMOS

		for (int i = 1; cont <= num; i++) {
			if (esPrimoB(i)) {
				cont++;
				System.out.print(i + " ");
			}
		}

	}

	public static boolean esPrimoB(int a) {
		boolean respuesta;
		int cont=0;
		for (int i = a; i > 0; i--) {
			if (a%i==0) {
				cont++;
			}
		}
		if (cont>2) {
			//No es primo
			respuesta=false;
		}else {
			//Es primo
			respuesta=true;
		}
		return respuesta;
	}

}

