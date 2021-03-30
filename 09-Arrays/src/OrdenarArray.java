
public class OrdenarArray {
	/*
	 * LLENAR UN ARRAY DE 20 ELEMENTOS CON NUMEROS ALEATORIOS POSITIVOS MENORES QUE 100
	 * MOSTRAR EL ARRAY
	 * ORDENAR EL ARRAY POR EL METODO DE LA BURBUJA (doble bucle)
	 * VOLVER A MOSTRAR EL ARRAY
	 */
	public static void main(String[] args) {
		int[] array20;
		array20 = new int [20];
		int aux;

		System.out.println("Se estan generando 20 numeros \n");
		for (int i = 0; i < array20.length; i++) {
			array20[i]= (int)(Math.random()*100);
			System.out.print(array20[i]+" ");
		}
		
		for (int i = 0; i < array20.length-1; i++) {
			
			for (int j = 0; j < array20.length-1-i; j++) {
				if (array20[j]<array20[j+1]) {
					
					aux=array20[j+1];
					array20[j+1]=array20[j];
					array20[j]=aux;
				} 
			}
		}
		System.out.println("\nLos numeros ordenados son");
		for (int i = 0; i < array20.length; i++) {
			System.out.print(array20[i] +" ");
		}


	}
}