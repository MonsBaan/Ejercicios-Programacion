import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Ejercicio3 {

	public static void main(String[] args) {
		String leer;
		System.out.println("Listado de Convalidaciones:");
		Scanner sc;
		try {
			sc = new Scanner(new File("alumnado.txt"));
			do {
				leer=sc.nextLine();

				switch (leer) {
				case "1":
					for (int i = 0; i < 1; i++) {
						leer=sc.nextLine();
						if (i!=0) {
							System.out.print(leer+", ");
						}else {
							System.out.print(leer);
						}
					}
					System.out.println();
					break;
				case "2":
					for (int i = 0; i < 2; i++) {
						leer=sc.nextLine();
						if (i!=1) {
							System.out.print(leer+", ");
						}else {
							System.out.print(leer);
						}
					}
					System.out.println();
					break;
				case "3":
					for (int i = 0; i < 3; i++) {
						leer=sc.nextLine();
						if (i!=2) {
							System.out.print(leer+", ");
						}else {
							System.out.print(leer);
						}
					}
					System.out.println();
					break;
				case "4":
					for (int i = 0; i < 4; i++) {
						leer=sc.nextLine();
						if (i!=3) {
							System.out.print(leer+", ");
						}else {
							System.out.print(leer);
						}
					}
					System.out.println();
					break;
				case "5":
					for (int i = 0; i < 5; i++) {
						leer=sc.nextLine();
						if (i!=4) {
							System.out.print(leer+", ");
						}else {
							System.out.print(leer);
						}					}
					System.out.println();
					break;
				case "6":
					for (int i = 0; i < 6; i++) {
						leer=sc.nextLine();
						if (i!=5) {
							System.out.print(leer+", ");
						}else {
							System.out.print(leer);
						}					}
					System.out.println();
					break;

				default:
					System.out.print(leer+ ": ");
					break;
				}

			}while (sc.hasNextLine());

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}


}
