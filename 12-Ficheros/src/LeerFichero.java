import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class LeerFichero {
	/*
	 * Leer el contenido de un fichero de texto y mostrarlo por pantalla
	 */
	public static void main(String[] args) {
		int numChar = 0;
		@SuppressWarnings("unused")
		Scanner sc;
		leerFich("fichero.txt", numChar);
		System.out.println("\n\nEl fichero contiene " +numChar +" vocales");

	}
	private static int leerFich(String strFich, int a) {
		String cadena;
		try {
			Scanner sc=new Scanner(new File(strFich));
			do {
				cadena=sc.nextLine();
				for (int i = 0; i < cadena.length(); i++) {
					if (cadena.charAt(i)=='a' || cadena.charAt(i)=='A') {
						System.out.print("a ");
					}else if (cadena.charAt(i)=='e' || cadena.charAt(i)=='E') {
						System.out.print("e ");
					}else if (cadena.charAt(i)=='i' || cadena.charAt(i)=='I') {
						System.out.print("i ");
					}else if (cadena.charAt(i)=='o' || cadena.charAt(i)=='O') {
						System.out.print("o ");
					}else if (cadena.charAt(i)=='u' || cadena.charAt(i)=='U') {
						System.out.print("u ");
					}
					a++;
				}
			}while (sc.hasNextLine());
		} catch (FileNotFoundException e) {
			System.out.println("El fichero no existe");
		}
		return a;
	}


}


