import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Fichero {

	private ArrayList<String> arrayPalabras;
	private File fichero;
	private Scanner sc;

	public Fichero() {
		cargarFichero();
	}

	public String obtenerPalabra() {
		int randomNum;
		String palabra;
		/*
		 * DEVUELVE UNA PALABRA ALEATORIA DEL ARRAYLIST
		 * BORRA LA PALABRA
		 * SIN PALABRAS = FIN JUEGO
		 */
		if (arrayPalabras.size()>0) {
			randomNum=(int) (Math.random()*arrayPalabras.size());
			palabra=arrayPalabras.get(randomNum);
			arrayPalabras.remove(randomNum);
			System.out.println("DEBUG: "+palabra);

			return palabra;
		}else {
			return null;
		}
	}
	
	public void cargarFichero() {
		try {
			arrayPalabras=new ArrayList<String>();
			sc=new Scanner(new File("palabras.txt"));
			//CARGAR PALABRAS
			do {
				arrayPalabras.add(sc.nextLine());
			} while (sc.hasNextLine());
			sc.close();

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}

