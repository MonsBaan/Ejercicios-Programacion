import java.util.Scanner;

public class Ejercicio1 {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int numT=0, cont=1, contSec=0;;
		
		do {
			System.out.println("Introduce el "+cont+" numero");
			numT=sc.nextInt();
			if (numT==4){
				cont++;
				System.out.println("Introduce el "+cont+" numero");
				numT=sc.nextInt();
				if (numT==5) {
					cont++;
					System.out.println("Introduce el "+cont+" numero");
					numT=sc.nextInt();
					if (numT==6) {
						cont++;
						System.out.println("Introduce el "+cont+" numero");
						numT=sc.nextInt();
						if (numT==7) {
							contSec++;
						}
					}
				}
			}
			
			cont++;
		} while (numT!=0);
		
		System.out.println("La sucesion 4, 5, 6, 7 ha sido introducida "+contSec+" veces");
	}

}
