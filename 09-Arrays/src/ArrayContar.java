public class ArrayContar {
	/*
	 * LLENAR UN ARRAY DE 30 ELEMENTOS CON NUMEROS ALEATORIOS POSITIVOS MENORES QUE 100
	 * MOSTRAR EL ARRAY ENTERO, 10 NUMEROS POR FILA SEPARADOS POR ""
	 * A CONTINUACION, MOSTRAR CONTAR Y SUMAR LOS NUMEROS PARES DEL ARRAY
	 */
	public static void main(String[] args) {
		int[] numeros;
		int randomnum, pares, contP;
		pares=0; contP=0;
		numeros = new int[30];

		System.out.println("Se estan generando 30 numeros \n");
		for (int cont = 0; cont < numeros.length; cont++) {
			randomnum= (int)(Math.random()*100);
			numeros[cont]=randomnum;
		}
		System.out.println("Los valores al azar creados son:");
		for (int cont2 = 0; cont2 < 30; cont2++) {
			if (cont2%10==0 && cont2!=0) {
				System.out.println();
			}
			System.out.print(numeros[cont2]+ " ");
		}
		System.out.println("\n \n");
		for (int cont3 = 0; cont3 < 30; cont3++) {
			if (numeros[cont3]%2==0) {
				contP++;
				pares=pares+numeros[cont3];
			}
		}
		System.out.println("Los numeros pares son: ");
		for (int cont4 = 0; cont4 < 30; cont4++) {
			if (numeros[cont4]%2==0) {
				System.out.print(numeros[cont4] + " ");
			}
		}
		System.out.println("\n \n");
		System.out.println("El nº de elementos pares: "+contP);
		System.out.println("La suma de los elementos pares: "+pares);
		


	}

}


