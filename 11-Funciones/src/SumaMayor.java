
public class SumaMayor {
	/*
	 * ARRAY DE 10X15
	 * LLENARLO, MOSTRARLO, OBTENER EL NUMERO DE FILA CUYAS SUMA ES LA MAYOR, OBTENER LA SUMA DE DICHA FILA
	 * 
	 * FUNCIONES:
	 * 			LLENAR: LLENAR EL ARRAY RECIBIDO COMO PARAMETRO CON NUMEROS ALEATORIOS ENTRE 1 Y 99
	 * 			MOSTRAR: MOSTRAR EL ARRAY RECIBIDO COMO PARAMETRO POR PANTALLA
	 * 			FILAMAYOR: RECIBE UN ARRAY BIDIMENSIONAL COMO PARAMETRO Y DEVUELVE EL NUMERO DE FILA CUYA SUMA SEA LA MAYOR
	 * 			SUMARFILA: RECIBE COMO PARAMETROS UN ARRAY BIDIMENSIONAL Y UN NUMERO DE FILA Y DEVUELVE LA SUMA DE DICHA FILA
	 */
	public static final int FILAS=10;
	public static final int COLUMNAS=15;

	public static void main(String[] args) {
		int [][] array10x15;
		array10x15= new int [FILAS][COLUMNAS];

		llenarArray(array10x15);
		mostrarArray(array10x15);
		System.out.println("\nLa fila con suma mayor es la numero "+filaMayor(array10x15)+" con el numero "+sumaFila(array10x15, filaMayor(array10x15)));

	}
	public static void llenarArray(int[][]a) {
		int randomNum;
		for (int i = 0; i < FILAS; i++) {
			for (int j = 0; j < COLUMNAS; j++) {
				randomNum=(int)(Math.random()*99+1);
				a[i][j]=randomNum;
			}
		}
	}

	public static void mostrarArray(int[][]a) {
		for (int i = 0; i < FILAS; i++) {
			for (int j = 0; j < COLUMNAS; j++) {
				System.out.print(a[i][j]+" ");
			}
			System.out.println();
		}
	}

	public static int filaMayor(int[][]a) {
		int sumafila=0;
		int filamayor=0;
		int filamayorAux=0;
		for (int i = 0; i < FILAS; i++) {
			for (int j = 0; j < COLUMNAS; j++) {
				sumafila=sumafila+a[i][j];
			}
			if (sumafila>filamayorAux) {
				filamayor++;
				filamayorAux=sumafila;
			}
			sumafila=0;
		}
		return filamayor;
	}
	public static int sumaFila(int[][]a, int b) {
		int sumafila=0;
		for (int i = 0; i < COLUMNAS; i++) {
			sumafila=sumafila+ a[b][i];
		}
		return sumafila;

	}
}
