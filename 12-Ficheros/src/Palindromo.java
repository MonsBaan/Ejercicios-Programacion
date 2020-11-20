import java.util.Scanner;

public class Palindromo {
	/*
	 * PROGRAMA QUE LEA UNA FRASE POR TECLADO
	 * FUNCION PALINDROMO: RECIBE UNA FRASE COMO PARAMENTRO Y DEVUELVE TRUE SI LA FRASE ES UN PALINDROMO Y FALSE EN CASO CONTRARIO
	 * SE GUARDARA LA FRASE EN UN ARCHIVO AÑADIENDO AL FINAL DE LA FRASE "---> SI ES PALINDROMO" O "---> NO ES PALINDROMO"
	 * DEPENDIENDO DE SI LA FRASE ES PALINDROMA O NO
	 */
	public static void main(String[] args) {
		String palindromo;
		@SuppressWarnings("resource")
		Scanner sc= new Scanner(System.in);
		System.out.println("Introduce una frase: ");
		palindromo=sc.nextLine();
		
		if (palindromo(palindromo)==true) {
			System.out.println("Si es palindromo");
			
		}else {
			System.out.println("No es palindromo");
		}
	}

	private static boolean palindromo(String frase) {
		int j;
		j=frase.length()-1;
		frase=frase.toLowerCase();
		for (int i = 0; i < frase.length()/2; i++,j--) {
			
			while (frase.charAt(i)==' ') {
				i++;
			}
			while (frase.charAt(j)==' ') {
				j--;
			}
			
			if (frase.charAt(i)!=frase.charAt(j)) {
				return false;
			}
		}
		return true;
	}

}
