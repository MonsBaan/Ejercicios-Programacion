
public class Ejercicio09 {
	/*
	 * PROGRAMA QUE TIENE 3 ARRAYS 2 DE 10 ELEMENTOS NUMERICOS CADA UNO Y UN TERCERO DE 20
	 * MEDIANTE LLAMADAS A FUNCIONES EL PROGRAMA DEBE LLENAR LOS ARRAYS DE 10 ELEMENTOS, MEZCLARLOS EN EL TERCERO DE 20 Y MOSTRAR LOS 3.
	 * 
	 * FUNCION PARA LLENAR UN ARRAY CON NUMEROS ENTEROS < 100
	 * FUNCION PARA MEZCLAR DOS ARRAYS RECIBIDOS COMO PARAMETROS EN UN TERCERO TAMBIEN RECIBIDO COMO PARAMETRO DE LA SIGUIENTE FORMA
	 * 2-A 2-B 2-A 2-B...
	 * 
	 * FUNCION PARA MOSTRAR POR PANTALLA UN ARRAY RECIBIDO COMO PARAMETRO (SOLO TIENE QUE MOSTRAR UN ARRAY POR LLAMADA)
	 */
	public static void main(String[] args) {
		int[] array1, array2, array3;
		array1= new int[10];
		array2= new int[10];
		array3= new int[20];

		llenarArray(array1);
		llenarArray(array2);

		mezclaArray(array1, array2, array3);

		System.out.println("Mostrando Array 1");
		muestraArray(array1);
		System.out.println("\nMostrando Array 2");
		muestraArray(array2);
		System.out.println("\nMostrando Array 3");
		muestraArray(array3);
	}

	public static void llenarArray(int[]array) {
		for (int i = 0; i < array.length; i++) {
			array[i]=(int) (Math.random()*99+1);
		}
	}

	public static void mezclaArray(int[]array1, int[]array2, int[]array3){
		Boolean turno=false;
		int cont=0;
		int contAr1=0;
		int contAr2=0;

		for (int i = 0; i < array3.length; i++) {
			if (turno==false) {

				for (int j = 0+contAr1; j < array1.length;) {
					array3[i]=array1[j];
					contAr1++;
					cont++;
					if (cont==2) {
						turno=true;
						cont=0;
						break;
					}
					break;
				}
			}else if (turno==true) {

				for (int j = 0+contAr2; j < array2.length;) {
					array3[i]=array2[j];
					contAr2++;
					cont++;
					if (cont==2) {
						turno=false;
						cont=0;
						break;
					}
					break;
				}
			}
		}
	}

	public static void muestraArray(int[]array){
		for (int i = 0; i < array.length; i++) {
			System.out.print(array[i]+" ");
		}
	}
}
