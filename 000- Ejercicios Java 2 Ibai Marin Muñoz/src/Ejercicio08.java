
public class Ejercicio08 {
	/*
	 * PROGRAMA QUE MEDIANTE LLAMADAS A FUNCIONES LLENE UN ARRAY Y LO MUESTRE CON SU CONTENIDO Y DESPUÉS LO MUESTRE POR PANTALLA TAL Y COMO SE INDICA EN LA OTRA FUNCION:
	 * 		· FUNCION PARA LLENAR UN ARRAY DE 10 ELEMENTOS CON NUMEROS ENTEROS ENTRE 1 Y 50
	 * 		· FUNCION PARA MOSTRAR EL ARRAY CON SU CONTENIDO
	 * 		· FUNCION PARA MOSTRARLOS EN EL SIGUIENTE ORDEN: 1-10,2-9,3-8,4-7,5-6
	 */
	public static void main(String[] args) {
		int[] array;
		array= new int[10];

		llenarArray(array);
		mostrarArray(array);
		System.out.println();
		reordenarArray(array);
	}

	public static void llenarArray(int[] array) {
		for (int i = 0; i < array.length; i++) {
			int randomNum=(int) (Math.random()*50+1);
			array[i]=randomNum;
		}
	}

	public static void mostrarArray(int[] array) {
		for (int i = 0; i < array.length; i++) {
			System.out.print(array[i]+" ");
		}
	}

	public static void reordenarArray(int[] array) {
		for (int i = 0; i < array.length/2; i++) {
			System.out.print(array[i]+ " " +array[9-i]+" ");	
		}
	}
}



