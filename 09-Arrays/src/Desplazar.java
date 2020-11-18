
public class Desplazar {
	/*
	 * LLENAR UN ARRAY DE 30 ELEMENTOS CON NUMEROS ALEATORIOS ENTEROS POSITIVOS MENORES QUE 100.
	 * MOSTRAR EL ARRAY, 15 NUMEROS POR LINEA
	 * DESPLAZAR TODOS LOS ELEMENTOS DEL ARRAY UNA POSICION A LA DERECHA.
	 * LA ULTIMA POSICION SE DESPLAZA A LA PRIMERA
	 * VOLVER A MOSTRAR EL ARRAY
	 */
	@SuppressWarnings("unused")
	public static void main(String[] args) {
		int randomnum, numBuff;
		int[] Array30;

		Array30= new int[30];
		numBuff=0;

		//GENERACION DE NUMEROS
		System.out.println("Se estan generando 30 numeros \n");
		for (int i = 0; i < Array30.length; i++) {
			randomnum= (int)(Math.random()*100);
			Array30[i]=randomnum;
		}
		//MOSTRAR Y ORDENAR NUMEROS
		System.out.println("Los numeros generados son:");
		for (int i = 0; i < Array30.length; i++) {
			if (i%15!=0) {
			System.out.print(Array30[i]+" ");
			}else {
				System.out.println();
			}
		}
		//DESPLAZAR ARRAY
		System.out.println("\n\nDesplazando numeros una posicion a la derecha");
		numBuff = Array30 [Array30.length-1]; //Se guarda el ultimo numero
		for (int i = Array30.length-1; i > 0; i--) {
			Array30[i]=Array30[i-1];
		}
		
		System.out.println("Los numeros con orden cambiado son:");
		for (int i = 0; i < Array30.length; i++) {
			if (i%15!=0) {
			System.out.print(Array30[i]+" ");
			}else {
				System.out.println();
			}
		}
		



	}
}


