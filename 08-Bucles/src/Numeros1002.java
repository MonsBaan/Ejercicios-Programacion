
public class Numeros1002 {
	/*PROGRAMA QUE MUESTRE POR PANTALLA LOS NUMEROS DEL 1 AL 300 SEPARADOS POR UN - 
	 * 15 numeros por fila
	 */
	public static void main(String[] args) {
		int a=0;		
		while (a<300) {
			if (a%15!=0) {
				System.out.print(a=a+1);
				System.out.print(" - ");
			} else {
				System.out.println(a=a+1);
			}

		}
	}
}

