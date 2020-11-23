import java.util.Scanner;

public class Ejercicio2 {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int numT;
		int[] array20;
		array20= new int [20];
		
		
		llenaArray(array20);
		mostrarArray(array20);
		System.out.print("\nInserta el valor que quieras buscar: ");
		numT=sc.nextInt();
		System.out.println("\nEl valor se repite sucesivamente "+maxVeces(numT, array20)+" veces");
		
		


	}
	
	public static void llenaArray(int[]array20) {
		for (int i = 0; i < array20.length; i++) {
			array20[i]=(int) (Math.random()*4+1);
		}
	}
	
	public static void mostrarArray(int[]array20) {
		for (int i = 0; i < array20.length; i++) {
			System.out.print(array20[i]+" ");
		}
	}
	
	public static int maxVeces(int numT, int[] array) {
		int consec=0, numBuff, consecMax = 0;
		for (int i = 1; i < array.length; i++) {
			if (array[i]==numT) {
				if (array[i]==array[i-1]) {
					consec++;
					if (consec>consecMax) {
						consecMax=consec;
					}
				}else {
					consec=1;
				}
			}
			
			
			
		}
		
		
		
		return consecMax;
	}

}
