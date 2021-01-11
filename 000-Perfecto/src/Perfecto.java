import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class Perfecto {
	/*
	 * FUNCION QUE DEVUELVA "TRUE" SI EL NUMERO RECIBIDO COMO PARAMETRO ES PERFECTO Y "FALSE" EN CASO CONTRARIO
	 * 
	 * NUMERO PERFECTO: NUMERO QUE ES IGUAL A LA SUMA DE TODOS SUS DIVISORES INCLUYENDO EL 1, PERO NO A SI MISMO
	 * 
	 * PROGRAMA QUE MEDIANTE LLAMADAS A LA FUNCION ANTERIOR, MUESTRE LOS NUMEROS PERFECTOS QUE HAY ENTRE 1 Y 100.000
	 * 
	 * ESCRIBIR LOS NUMEROS PERFECTOS EN UN FICHERO LLAMADO perfectos.txt (UN NUMERO POR LINEA)
	 */
	public static void main(String[] args) {
		@SuppressWarnings("resource")
		Scanner sc=new Scanner(System.in);
		PrintWriter pw;
		int numT=0, cont=0;

		System.out.println("Escoge la cantidad de numeros hasta donde quieras contar los perfectos");
		numT=sc.nextInt();
		try {
			pw=new PrintWriter(new File("perfecto.txt")); //CREACIÓN DE ARCHIVO
			
			for (int i = 1; i < numT; i++) {
				if (esPerfecto(i)==true) {
					pw.println(i); //ABRIR ARCHIVO
					cont++;
				}
			}
			pw.close(); //CERRAR ARCHIVO
			System.out.println("Del 1 al "+numT+" hay "+cont+" numeros perfectos");

		} catch (FileNotFoundException e) {
			System.out.println("Que has liado para que estes leyendo esto");
		}

	}

	public static boolean esPerfecto(int num) {
		int numP=0;
		for (int i = 1; i < num; i++) {
			if (num%i==0) {
				numP=numP+i;
			}
		}
		if (numP==num) {
			return true;

		}else {
			return false;

		}
	}

}
