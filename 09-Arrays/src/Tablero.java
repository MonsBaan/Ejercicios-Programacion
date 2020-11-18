import java.util.Scanner;

public class Tablero {
	/*
	 * CREAR UN TABLERO DE AJEDREZ DE 8X8
	 * EN EL TABLERO ALMACENAREMOS UN CARACTER POR CADA FICHA: "P", "T"...
	 */
	//CONSTANTES
	public static final int FILAS=9;
	public static final int COLUMNAS=9;

	@SuppressWarnings("resource")
	public static void main(String[] args) {	
		char[][]tablero;
		tablero=new char [FILAS][COLUMNAS];
		int filaFicha, columnaFicha, selFicha, rotarP;
		Scanner sc= new Scanner(System.in);
		
		for (int fila = 0; fila < FILAS; fila++) {
			for (int columna = 0; columna < COLUMNAS; columna++) {
				tablero[fila][columna]='.';
				tablero[0][0]=' ';
			}
		}

	//TABLERO A POSICION INICIAL
		//FICHAS
		tablero[1][1]='t';
		tablero[1][2]='c';
		tablero[1][3]='a';
		tablero[1][4]='r';
		tablero[1][5]='x';
		tablero[1][6]='a';
		tablero[1][7]='c';
		tablero[1][8]='t';

		tablero[8][1]='T';
		tablero[8][2]='C';
		tablero[8][3]='A';
		tablero[8][4]='X';
		tablero[8][5]='R';
		tablero[8][6]='A';
		tablero[8][7]='C';
		tablero[8][8]='T';

		//PEONES
		for (int columna = 0; columna < COLUMNAS; columna++) {
			//FILA1
			tablero[2][columna]='p';
			//FILA6
			tablero[7][columna]='P';
		}
		//NUMEROS
		tablero[1][0]='1';
		tablero[2][0]='2';
		tablero[3][0]='3';
		tablero[4][0]='4';
		tablero[5][0]='5';
		tablero[6][0]='6';
		tablero[7][0]='7';
		tablero[8][0]='8';
		
		tablero[0][1]='1';
		tablero[0][2]='2';
		tablero[0][3]='3';
		tablero[0][4]='4';
		tablero[0][5]='5';
		tablero[0][6]='6';
		tablero[0][7]='7';
		tablero[0][8]='8';
		
		for (int fila = 0; fila < FILAS; fila++) {
			for (int columna = 0; columna < COLUMNAS; columna++) {
				System.out.print(tablero[fila][columna]+"  ");
			}System.out.println();
		}
		do {
			System.out.println("\nQuieres rotar el tablero? SI=1");
			rotarP=sc.nextInt();
			if (rotarP==1) {
				for (int fila = 0; fila < FILAS; fila++) {
					for (int columna = 0; columna < COLUMNAS; columna++) {
						System.out.print(tablero[columna][fila]+"  ");
						}System.out.println();
				}
			}
			//SELECCION DE FICHA
			System.out.println("\nIntroduce la FILA y COLUMNA de la ficha que deseas mover");
			filaFicha=sc.nextInt();
			columnaFicha=sc.nextInt();
			selFicha= tablero[filaFicha][columnaFicha];
			
			//SELECCION DE DESTINO
			System.out.println("\nIntroduce la FILA y COLUMNA de la casilla donde quieras mover la ficha");
			int filaDestino, columnaDestino;
			filaDestino=sc.nextInt();
			columnaDestino=sc.nextInt();
			tablero[filaDestino][columnaDestino]=(char) selFicha;
			tablero[filaFicha][columnaFicha]='.';
			
			for (int fila = 0; fila < FILAS; fila++) {
				for (int columna = 0; columna < COLUMNAS; columna++) {
					System.out.print(tablero[fila][columna]+"  ");
				}System.out.println();
			}
		} while (filaFicha!= 0 && columnaFicha!=0);
		
		}
	}


