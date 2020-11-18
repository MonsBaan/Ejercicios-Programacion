import java.util.Scanner;

public class OperacionesArray {
	/*
	 * ARRAY DE 10 ELEMENTOS INICIALMENTE VACIO
	 * MEDIANTE FUNCIONES:
	 * LeerNumeros: LEER NUMEROS POR TECLADO HASTA QUE SE TECLEE EL 0 Y GUARDARLOS EN POSICIONES SUCESIVAS DEL ARRAY
	 * 				LA FUNCION MOSTRARÁ UN MENSAJE SI EL ARRAY ESTA LLENO
	 * 
	 * Menu: Muestra por pantalla el siguiente menu
	 * 		0- Mostrar array
	 * 		1- Añadir elemento por el final
	 * 		2- Eliminar elemento
	 * 		3- Insertar elemento en una posicion
	 * 		4- Fin de Programa
	 * 		ELIGE UNA OPCION: 
	 * 
	 * AnNum: Recibe el array, el elemento a añador y el numero de elementos que hay en el array
	 * Eliminar: Elimina un elemento del array
	 * Insertar: Si el array no esta lleno desplaza una posicion a la derecha los elementos que estan a partir de esa posicion;
	 */
	public static final int TAMAÑO=10;
	public static void main(String[] args) {
		int contador = 0;
		int[] array;
		array=new int [TAMAÑO];
		LeerNumeros(array);
		Menu(array);
	}

	public static void Menu(int[]a) {
		Scanner sc=new Scanner(System.in);
		int numTeclado=0;

		do {
			System.out.println("\n-Menu Principal-");
			System.out.println("Escoge una Opcion");
			System.out.println("1- Mostrar Array");
			System.out.println("2- Añadir Elemento por el Final");
			System.out.println("3- Eliminar Elemento");
			System.out.println("4- Insertar Elemento en una Posicion");
			System.out.println("5- Fin de Programa");
			System.out.print("\nElige Una Opcion: ");

			numTeclado=sc.nextInt();
			switch (numTeclado) {
			case 1:
				MostrarArr(a);
				break;
			case 2:
				AnNum(a);
				break;
			case 3:
				ElimNum(a);
				break;
			case 4:
				AnNumPos(a);
				break;

			default:
				System.out.println("Valor introducido Nulo");
				break;
			}

		} while (numTeclado!=5);
		System.out.println("Fin de Programa");

	}

	public static void MostrarArr(int[]a) {
		System.out.println();
		for (int i = 0; i < TAMAÑO; i++) {
			System.out.print(a[i]+" ");
		}
	}

	public static void LeerNumeros(int[]a) {
		Scanner sc=new Scanner(System.in);
		int numTeclado=1;		
		int cont=0;
		System.out.println("Introduce los numeros que desees(Escribe 0 para terminar)");
		do {
			if (cont==TAMAÑO) {
				System.out.println("\nHas llegado al limite de numeros");
				numTeclado=0;
			}else {				
				numTeclado=sc.nextInt();
				a[cont]=numTeclado;
				cont++;
			}
		} while (numTeclado!=0);

	}

	public static int ContNum(int[]a) {
		int contNum=0;
		for (int i = 0; i < TAMAÑO; i++) {
			if (a[i]!=0) {
				contNum++;
			}
		}
		return contNum;
	}

	public static void ElimNum(int[]a) {
		Scanner sc=new Scanner(System.in);
		int numTeclado;

		System.out.println("Menu Eliminar Numero");
		System.out.println("1- Eliminar Numero");
		System.out.println("2- Volver Atras");
		System.out.print("\nElige Una Opcion: ");

		numTeclado=sc.nextInt();
		switch (numTeclado) {
		case 1:
			System.out.print("Elige la posicion del numero que quieras eliminar: ");
			numTeclado=sc.nextInt();
			int numEliminado=numTeclado-1;

			a[numEliminado]=a[numTeclado];
			for (int i = numEliminado; i < TAMAÑO; i++) {
				if (a[i]==0) {

				}else {
					a[i]=a[numTeclado];
					numTeclado++;
				}
			}
			break;
		case 2:
			System.out.println("\nVolviendo al Menu Principal");
			break;
		default:
			System.out.println("\nValor introducido Nulo");
			break;
		}
	}

	public static void AnNum(int[]a) {
		Scanner sc=new Scanner(System.in);
		int numTeclado=0;
		if (ContNum(a)==TAMAÑO) {
			System.out.println("\nLimite de valores alcanzado OPERACION NO VALIDA");
		}else {
			System.out.println("Introduce el valor que desees añadir");
			numTeclado=sc.nextInt();
			a[ContNum(a)]=numTeclado;
		}
	}

	public static void AnNumPos(int[]a) {
		if (ContNum(a)==TAMAÑO) {
			System.out.println("\nLimite de valores alcanzado OPERACION NO VALIDA");
		}else {
			Scanner sc=new Scanner(System.in);
			int numTeclado=0, numPosicion=0;
			System.out.println("Introduce el valor que quieras añadir");
			numTeclado=sc.nextInt();
			System.out.println("Introduce la posicion");
			numPosicion=sc.nextInt();
		}
	}
}







