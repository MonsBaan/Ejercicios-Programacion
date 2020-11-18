import java.util.Scanner;
public class Palillos {
	//JUEGO DE LOS PALILLOS
	//JUEGO PARA DOS JUGADORES QUE JUEGAN DE FORMA ALTERNATIVA
	//EL JUEGO COMIENZA CON 15 PALILLOS
	//EN CADA TURNO 1 JUGADOR PUEDE QUITAR 1, 2 ó 3 PALILLOS
	//PIERDE EL QUE QUITA EL ÚLTIMO PALILLO

	/*INTRODUCE LOS NOMBRES DE LOS JUGADORES:
	 * JUGADOR 1: Roberto
	 * JUGADOR 2: Ander
	 * COMIENZA EL JUEGO:
	 * Quedan 15 palillos: IIIII IIIII IIIII
	 * Turno: Roberto. Elige número de palillos (1-3): 3
	 * Quedan 12 palillos: IIIII IIIII II
	 * Turno: Ander. Elige número de palillos (1-3): 4
	 * Turno: Ander. Elige número de palillos (1-3): 5
	 * Turno: Ander. Elige número de palillos (1-3): 2
	 * Quedan 10 palillos: IIIII IIIII
	 * Turno: Roberto. Elige número de palillos (1-3):
	 */
	public static void main(String[] args) {
		@SuppressWarnings("resource")
		Scanner sc=new Scanner(System.in);
		String jugador1= null, jugador2 = null;
		int palillosTotal=15, randomnum, palillosEli=0;
		randomnum=(int) (Math.random()*10+1);
		boolean turno=true;
		System.out.println("Debug para saber el primer turno: "+randomnum+" (1-5=Jugador1  6-10=Jugador2)");
		System.out.println("\n\n\nIntroduce el nombre del primer jugador");
		jugador1=sc.next();
		System.out.println("Introduce el nombre del segundo jugador");
		jugador2=sc.next();
		System.out.println("Comienza el Juego:");
		if (randomnum<=5) {
			turno=true;
		}else {
			turno=false;
		}
		do {
			contarPalillos(palillosTotal);
			if (turno==true) {
				System.out.println("\n\nEs el turno de: "+jugador1+". Elige numero de palillos a eliminar (1-3)");
				palillosEli=quitaPalillos(palillosTotal);
				palillosTotal= palillosTotal-palillosEli;
				if (palillosTotal==0) {
					System.out.println(jugador1+" ha perdido al eliminar todos los palillos");
				}else {
					turno=false;
				}
			}else if (turno==false) {
				System.out.println("\n\nEs el turno de: "+jugador2+". Elige numero de palillos a eliminar (1-3)");
				palillosEli=quitaPalillos(palillosTotal);
				palillosTotal= palillosTotal-palillosEli;
				if (palillosTotal==0) {
					System.out.println(jugador2+" ha perdido al eliminar todos los palillos");
				}else {
					turno=true;
				}
			}
		} while (palillosTotal!=0);
	}
	public static void contarPalillos(int a) {
		System.out.print("Quedan "+a+" palillos: ");
		for (int i = 1; i <= a; i++) {
			if (i%5==0) {
				System.out.print("I ");
			}else {
				System.out.print("I");
			}
		}
	}
	public static int quitaPalillos(int a) {
		@SuppressWarnings("resource")
		Scanner sc=new Scanner(System.in);
		int numT=0, numEli=0;
		if (a>=3) {
			do {
				numT=sc.nextInt();
				switch (numT) {
				case 1:
					numEli=1;
					break;
				case 2:
					numEli=2;
					break;
				case 3:
					numEli=3;
					break;
				default:
					System.out.println("Valor erroneo, añade un valor comprendido entre 1 y 3");
					break;
				}
			} while (numEli<=0 || numEli>3);
		}else if (a==2) {
			do {
				numT=sc.nextInt();
				switch (numT) {
				case 1:
					numEli=1;
					break;
				case 2:
					numEli=2;
					break;
				default:
					System.out.println("Valor erroneo, añade un valor comprendido entre 1 y ");
					break;
				}
			} while (numEli<=0 || numEli>2);

		}else if (a==1) {
			do {
				numT=sc.nextInt();
				switch (numT) {
				case 1:
					numEli=1;
					break;
				case 2:
					numEli=2;
					break;
				case 3:
					numEli=3;
					break;

				default:
					System.out.println("Valor erroneo, añade un valor comprendido entre 1 y 3");
					break;
				}
			} while (numEli<=0 || numEli>1);
		}
		return numEli;
	}
}
