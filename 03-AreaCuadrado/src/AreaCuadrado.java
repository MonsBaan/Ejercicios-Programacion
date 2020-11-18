import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class AreaCuadrado {
	/* PROGRAMA QUE LEA POR TECLADO LA BASE Y LA ALTURA DE UN RECTANGULO 
	 * Y MUESTRE EL VALOR DEL AREA Y DEL PERIMETRO POR PANTALLA
	 */
	public static void main(String[] args) throws IOException {
		
	//DECLARACION DE VARIABLES
		int base, altura, area, perimetro;
		String strNumBase;
		String strNumAltura;
		
		//LECTURA
		BufferedReader br;
		br=new BufferedReader(new InputStreamReader(System.in));
		
			//Lectura de Base
			System.out.println("CALCULO DEL AREA Y PERIMETRO");
			System.out.println("Intruduce el valor de la base en cm y PULSA ENTER");
		
		strNumBase=br.readLine();
		base=Integer.parseInt(strNumBase);
		
			//Lectura de Altura
			System.out.println("Introduce el valor de la altura en cm y PULSA ENTER");
			
		strNumAltura=br.readLine();
		altura=Integer.parseInt(strNumAltura);
		
	//CALCULOS
		area= base * altura;
			System.out.print("Area del Rectangulo= " +area);
			System.out.println(" cm2");
		
		perimetro= (base *2)+(altura *2);
			System.out.print("Perimetro del Rectangulo= " +perimetro);
			System.out.println(" cm");
		
	}

}
