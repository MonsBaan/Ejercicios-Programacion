
public class MaxMin {
	/*
	 * PROGRAMA QUE LLENE UN ARRAY DE 20 ELEMENTOS CON NUMEROS ALEATORIOS ENTEROS PARES DE DOS DIGITOS
	 * MOSTRAR EL ARRAY POR PANTALLA
	 * MOSTRAR EL MAXIMO Y EL MINIMO QUE HAY EN EL ARRAY
	 * 
	 * LLEVAR EL MAXIMO A LA ULTIMA POSICION DEL ARRAY Y EL MINIMO A LA PRIMERA
	 */
	public static void main(String[] args) {
		int randomnum, contPar, numMay, numMen, numGuardar;
		int[] array20;
		contPar=0; numMay=0; numMen=99; numGuardar=0;
		array20= new int [20];


		//GENERAR NUMEROS AL AZAR
		for (@SuppressWarnings("unused")
		int i = 0; contPar < array20.length; i++) {
			randomnum= (int)(Math.random()*99);
			if (randomnum < 10) {
				randomnum= randomnum+9;
			}
			if (randomnum%2==0) {
				array20[contPar]=randomnum;
				contPar++;
			}
		}
		//MOSTRAR NUMEROS DEL ARRAY
		for (int i = 0; i < array20.length; i++) {
			System.out.print(array20[i] + " ");
		}
		//SELECCIONAR NUMERO MAYOR
		for (int i = 0; i < array20.length; i++) {
			if (array20[i]>numMay) {
				numMay=array20[i];
			}
		}
		System.out.print("\nEl numero mayor es: " +numMay);
		//SELECCIONAR NUMERO MENOR
		for (int i = 0; i < array20.length; i++) {
			if (array20[i]<numMen) {
				numMen=array20[i];
			}
		}
		System.out.println("\nEl numero menor es: " +numMen);

		System.out.println("\nLa posicion 1 y del numero mayor se van a intercambiar");
		System.out.println("La posicion 2 y del numero menor se van a intercambiar");
		for (int i = 0; i < array20.length; i++) {
			if (array20[i] == numMay) {
				numGuardar=array20[0];
				array20[0]=numMay;
				array20[i]=numGuardar;			
			}
			if (array20[i] == numMen) {
				numGuardar=array20[19];
				array20[19]=numMen;
				array20[i]=numGuardar;
			}
		}
		for (int i = 0; i < array20.length; i++) {
			System.out.print(array20[i]+" ");

	}
}
}



