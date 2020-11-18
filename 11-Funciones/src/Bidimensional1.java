
public class Bidimensional1 {
	/*
	 * TENEMOS 3 ARRAYS DE NUMEROS ENTEROS
	 * ARRAY 1: BIDIMENSIONAL DE 6X8
	 * ARRAY 2: ARRAY DE 6 ELEMENTOS
	 * ARRAY 3: ARRAY DE 8 ELEMENTOS
	 * 
	 * MEDIANTE LLAMADAS A FUNCIONES:
	 * 		LLENAR EL ARRAY BIDIMENSIONAL CON NUMEROS ALEATORIOS ENTRE 1 Y 10 Y MOSTRAR EL ARRAY
	 * 		REALIZAR LA SUMA POR FILAS DEJANDO EL RESULTADO EN UNO DE LOS ARRAYS Y LA SUMA POR COLUMNAS EN EL OTROARRAY
	 * 		MOSTRAR LOS DOS ARRAYS UNIDIMENSIONALES
	 * 
	 * FUNCIONES:
	 * 		-llenarArray: RECIBE COMO PARAMETRO UN ARRAY BIDIMENSIONAL Y LO LLENA CON NUMEROS ALEATORIOS DE 1 A 10
	 * 		-mostrarArray: MUESTRA EL ARRAY RECIBIDO COMO PARAMETRO POR PANTALLA
	 * 		-sumaFilas RECIBE COMO PARAMETRO EL ARRAY BIDIMENSIONAL Y LOS DOS UNIDIMENSIONALES, GUARDA LA SUMA DE LAS FILAS EN UNO YLA SUMA DE COLUMNAS EN OTRO
	 */
	public static final int FILAS=6;
	public static final int COLUMNAS=8;

	public static void main(String[] args) {
		int[][]array1;
		int[]arrayFil;
		int[]arrayCol;
		array1=new int[FILAS][COLUMNAS];
		arrayFil=new int[6];
		arrayCol=new int[8];


		llenarArray(array1);
		sumaFilas(array1, arrayFil, arrayCol);
		mostrarArray(array1, arrayFil, arrayCol);


	}
	public static void llenarArray(int[][]a) {
		int randomnum;
		for (int i = 0; i < FILAS; i++) {
			for (int j = 0; j < COLUMNAS; j++) {
				randomnum=(int)(Math.random()*9+1);
				a[i][j]=randomnum;
			}
		}
	}
	
	public static void mostrarArray(int[][]a, int[]b, int[]c) {
		for (int i = 0; i < FILAS; i++) {
			for (int j = 0; j < COLUMNAS; j++) {
				System.out.print(a[i][j]+" ");
			}
			System.out.println();
		}
		for (int i = 0; i < b.length; i++) {
			System.out.println(b[i]);
		}
		System.out.println();
		for (int i = 0; i < c.length; i++) {
			System.out.println(+c[i]);
		}
	}
	
	public static void sumaFilas(int[][]a, int[]b, int[]c) {
		for (int i = 0; i < FILAS; i++) {
			for (int j = 0; j < COLUMNAS; j++) {
				b[i]=a[i][j]+b[i];
			}
		}
		for (int i = 0; i < COLUMNAS; i++) {
			for (int j = 0; j < FILAS; j++) {
				c[i]=a[j][i]+c[i];

			}

		}
	}

}
