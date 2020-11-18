import java.util.InputMismatchException;
import java.util.Scanner;

public class Ejercicio01 {
	/*
	 * Programa que pida tres numeros enteros por teclado y los muestre ordenados de mayor a menor
	 */
	public static void main(String[] args) {
		boolean error=true;
		int numMay = 0, numMed = 0, numMen = 0;
		int num1 = 0, num2 = 0, num3 = 0;

		@SuppressWarnings("resou"
				+ "rce")
		Scanner sc=new Scanner(System.in);

		//INSERTAR NUMEROS
		do {
			try {
				System.out.println("Escribe el 1º digito");
				num1= sc.nextInt();
				error=false;
			}catch (InputMismatchException e) {
				System.out.println("EL VALOR INTRODUCIDO NO ES VALIDO");
				sc.next();
				error=true;
			}				
		} while (error);

		do {
			try {
				System.out.println("Escribe el 2º digito");
				num2= sc.nextInt();
				error=false;
			}catch (InputMismatchException e) {
				System.out.println("EL VALOR INTRODUCIDO NO ES VALIDO");
				sc.next();
				error=true;
			}				
		} while (error);

		do {
			try {
				System.out.println("Escribe el 3º digito");
				num3= sc.nextInt();
				error=false;
			}catch (InputMismatchException e) {
				System.out.println("EL VALOR INTRODUCIDO NO ES VALIDO");
				sc.next();
				error=true;
			}				
		} while (error);

		//COMPARAR NUMEROS
		if (num1>num2 && num1>num3) {
			numMay=num1;
			if (num2>num3) {
				numMed=num2;
				numMen=num3;
			}else {
				numMed=num3;
				numMen=num2;
			}
		}

		if (num2>num1 && num2>num3) {
			numMay=num2;
			if (num1>num3) {
				numMed=num1;
				numMen=num3;
			}else {
				numMed=num3;
				numMen=num1;
			}
		}

		if (num3>num2 && num3>num1) {
			numMay=num3;
			if (num2>num1) {
				numMed=num2;
				numMen=num1;
			}else {
				numMed=num1;
				numMen=num2;
			}
		}

		//RESULTADO
		System.out.println("Los numeros ordenados: "+numMay+" "+numMed+" "+numMen);

	}
}

