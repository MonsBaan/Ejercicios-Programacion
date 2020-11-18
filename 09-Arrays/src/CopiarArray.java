
public class CopiarArray {
	/*
	 * LLENAR UN ARRAY DE 50 ELEMENTOS CON NUMEROS ALEATORIOS ENTEROS POSITIVOS DE DOS DIGITOS
	 * MOSTRAR EL ARRAY (10 POR FILA)
	 * COPIAR LOS ELEMENTOS DE LAS POSICIONES IMPARES DEL ARRAY EN OTRO ARRAY DE 25 ELEMENTOS (INICIALMENTE VACIOS)
	 * MOSTRAR EL CONTENIDO DE ESTE ARRAY DE 25 ELEMENTOS (10 POR FILA)
	 */

	public static void main(String[] args) {
		int randomnum, contAI, array1;
		int[] ArrayG, ArrayI;
		ArrayG = new int[50];
		ArrayI = new int[25];
		contAI= 0;
		
		System.out.println("Se estan generando 50 numeros \n");
		for (int i = 0; i < ArrayG.length; i++) {
			randomnum= (int)(Math.random()*100);
			ArrayG[i]=randomnum;
		}
	
		System.out.println("Los valores creados al azar son: ");
		for (int i = 0; i < 50; i++) {
			if (i%10==0 && i!=0) {
				System.out.println();
			}System.out.print(ArrayG[i]+" ");
		}
		for (int i = 0; i < 50; i++) {
			if (i%2==0) {
				array1=ArrayG[i];
				ArrayI[contAI]=  array1;
				contAI++;
			}
		}
		System.out.println();
		System.out.println("\nLos valores en POSICION impar son: ");
		for (int i = 0; i < 25; i++) {
			if (i%10==0 && i!=0) {
				System.out.println();
			}System.out.print(ArrayI[i]+" ");

		}
		
	}

}
