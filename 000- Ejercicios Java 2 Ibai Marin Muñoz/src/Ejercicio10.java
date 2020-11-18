
public class Ejercicio10 {
/*
 * PROGRAMA QUE MEDIANTE LLAMADAS A LAS SIGUIENTES FUNCIONES LLENE UN ARRAY DE 5X5 Y LO MUESTRE POR PANTALLA
 * 
 * FUNCION QUE LLENE EL ARRAY BIDIMENSIONAL RECIBIDO COMO PARAMETRO CON LOS SIGUIENTES VALORES
 * 		LA POSICION T[N,M] TIENE QUE SER N+M PARA LAS FILAS PARES Y N*M PARA LAS IMPARES
 * 
 * FUNCION QUE MUESTRE POR PANTALLA EL ARRAY BIDIMENSIONAL
 * 
 */
	
	public static final int FILAS=5;
	public static final int COLUMNAS=5;
	
	public static void main(String[] args) {
		int[][]arrayBase;
		arrayBase=new int [FILAS][COLUMNAS];
		
		llenarArray(arrayBase);
		mostrarArray(arrayBase);
	}

	
	public static void mostrarArray(int[][]array) {
		for (int i = 0; i < FILAS; i++) {
			for (int j = 0; j < COLUMNAS; j++) {
				System.out.print(array[i][j]+ " ");
			}
			System.out.println();
		}
	}
	
	public static void llenarArray(int[][]array) {
		for (int i = 0; i < FILAS; i++) {
			for (int j = 0; j < COLUMNAS; j++) {
				if (i%2==0) {
					array[i][j]=(i+1)*(j+1);
				}else if (i%2!=0) {
					array[i][j]=(i+1)+(j+1);

				}
			}
		}
	}
}
