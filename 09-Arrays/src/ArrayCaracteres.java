import java.util.Scanner;

public class ArrayCaracteres {
	/*
	 * LLENAR UN ARRAY DE 25 ELEMENTOS CON LETRAS MAYUSCULAS ALEATORIAS. MOSTRARLO POR PANTALLA SEPARANDO CADA LETRA POR ESPACIOS ES BLANCO
	 * 
	 * LEER UN CARACTER POR TECLADO Y MOSTRAR LA POSICION O POSICIONES EN LAS QUE SE ENCUENTRA ESA LESTRA. SINO ESTÁ, MOSTRAR UN MENSAJE
	 */
	public static void main(String[] args) {
		@SuppressWarnings("resource")
		Scanner sc=new Scanner(System.in);
		int randomnum, cont;
		char caracter;
		String teclado;
		char[] cadena;
		cadena= new char[25];

		for (int i = 0; i < cadena.length; i++) {
			randomnum= (int) (Math.random()*26+65);
			cadena[i]=(char) randomnum;
			System.out.print(cadena[i] +" ");
		}

		System.out.println("\n\nIntroduce la Letra que quieras buscar (SOLO MAYUS)");
		cont=0;
		teclado=sc.next();
		caracter=teclado.charAt(0);
		for (int i = 0; i < cadena.length; i++) {
			if (cadena[i]== caracter) {
				cont++;
			}
		}
		if (cont>0) {
			System.out.println("Se han encontrado "+cont+" letras");
		}else {
			System.out.println("No se han encontrado la letra");
		}
		
		//MOSTRAR LAS POSICIONES DE LAS VOCALES
		for (int i = 0; i < cadena.length; i++) {
			if (cadena[i]=='A') {
				System.out.println("Se ha encontrado la vocal A en la posicion: "+(i+1));
			}else if (cadena[i]=='E') {
				System.out.println("Se ha encontrado la vocal E en la posicion: "+(i+1));
			}else if (cadena[i]=='I') {
				System.out.println("Se ha encontrado la vocal I en la posicion: "+(i+1));
			}else if (cadena[i]=='O') {
				System.out.println("Se ha encontrado la vocal O en la posicion: "+(i+1));
			}else if (cadena[i]=='U') {
				System.out.println("Se ha encontrado la vocal U en la posicion: "+(i+1));
			}
		}
	}
}
