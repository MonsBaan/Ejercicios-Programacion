import java.util.Scanner;

public class Ejercicio04 {
	/*
	 * PROGRAMA QUE PIDA POR SEPARADO DIA, MES, Y A�O DE UNA FECHA CORRECTA Y MUESTRE POR PANTALLA LA FECHA DEL DIA SIGUIENTE
	 */
	public static void main(String[] args) {
		@SuppressWarnings("resource")
		Scanner sc=new Scanner(System.in);
		int dia, mes, a�o, limitDia = 1;
		dia=1;
		mes=1;
		a�o=1;
		Boolean mesValido=false;
		Boolean diaValido=false;
		System.out.println("Introduce el A�o");
		a�o=sc.nextInt();
		do {
			System.out.println("Introduce el Mes (01-Enero,02-Febrero,03-Marzo...)");
			mes=sc.nextInt();
			switch (mes) {
			case 1:
				mesValido=true;
				limitDia=31;
				System.out.println("Introduce el dia");
				dia=sc.nextInt();
				do {
					if (dia<1 || dia>limitDia) {
						diaValido=false;
						System.out.println("Dia no valido, introducelo de nuevo");
						dia=sc.nextInt();
					}else {
						diaValido=true;
					}
				} while (diaValido!=true);
				break;

			case 2:
				mesValido=true;
				if (a�o%4==0 || a�o%400==0) {
					limitDia=29;
					System.out.println("Introduce el dia");
					dia=sc.nextInt();
					do {
						if (dia<1 || dia>limitDia) {
							diaValido=false;
							System.out.println("Dia no valido, introducelo de nuevo");
							dia=sc.nextInt();
						}else {
							diaValido=true;
						}
					} while (diaValido!=true);
					break;
				}else {
					limitDia=28;
					System.out.println("Introduce el dia");
					dia=sc.nextInt();
					do {
						if (dia<1 || dia>limitDia) {
							diaValido=false;
							System.out.println("Dia no valido, introducelo de nuevo");
							dia=sc.nextInt();
						}else {
							diaValido=true;
						}
					} while (diaValido!=true);
					break;
				}

			case 3:
				mesValido=true;
				limitDia=31;
				System.out.println("Introduce el dia");
				dia=sc.nextInt();
				do {
					if (dia<1 || dia>limitDia) {
						diaValido=false;
						System.out.println("Dia no valido, introducelo de nuevo");
						dia=sc.nextInt();
					}else {
						diaValido=true;
					}
				} while (diaValido!=true);
				break;
			case 4:
				mesValido=true;
				limitDia=30;
				System.out.println("Introduce el dia");
				dia=sc.nextInt();
				do {
					if (dia<1 || dia>limitDia) {
						diaValido=false;
						System.out.println("Dia no valido, introducelo de nuevo");
						dia=sc.nextInt();
					}else {
						diaValido=true;
					}
				} while (diaValido!=true);
				break;

			case 5:
				mesValido=true;
				limitDia=31;
				System.out.println("Introduce el dia");
				dia=sc.nextInt();
				do {
					if (dia<1 || dia>limitDia) {
						diaValido=false;
						System.out.println("Dia no valido, introducelo de nuevo");
						dia=sc.nextInt();
					}else {
						diaValido=true;
					}
				} while (diaValido!=true);
				break;

			case 6:
				mesValido=true;
				limitDia=30;
				System.out.println("Introduce el dia");
				dia=sc.nextInt();
				do {
					if (dia<1 || dia>limitDia) {
						diaValido=false;
						System.out.println("Dia no valido, introducelo de nuevo");
						dia=sc.nextInt();
					}else {
						diaValido=true;
					}
				} while (diaValido!=true);
				break;

			case 7:
				mesValido=true;
				limitDia=31;
				System.out.println("Introduce el dia");
				dia=sc.nextInt();
				do {
					if (dia<1 || dia>limitDia) {
						diaValido=false;
						System.out.println("Dia no valido, introducelo de nuevo");
						dia=sc.nextInt();
					}else {
						diaValido=true;
					}
				} while (diaValido!=true);
				break;

			case 8:
				mesValido=true;
				limitDia=31;
				System.out.println("Introduce el dia");
				dia=sc.nextInt();
				do {
					if (dia<1 || dia>limitDia) {
						diaValido=false;
						System.out.println("Dia no valido, introducelo de nuevo");
						dia=sc.nextInt();
					}else {
						diaValido=true;
					}
				} while (diaValido!=true);
				break;

			case 9:
				mesValido=true;
				limitDia=30;
				System.out.println("Introduce el dia");
				dia=sc.nextInt();
				do {
					if (dia<1 || dia>limitDia) {
						diaValido=false;
						System.out.println("Dia no valido, introducelo de nuevo");
						dia=sc.nextInt();
					}else {
						diaValido=true;
					}
				} while (diaValido!=true);
				break;

			case 10:
				mesValido=true;
				limitDia=31;
				System.out.println("Introduce el dia");
				dia=sc.nextInt();
				do {
					if (dia<1 || dia>limitDia) {
						diaValido=false;
						System.out.println("Dia no valido, introducelo de nuevo");
						dia=sc.nextInt();
					}else {
						diaValido=true;
					}
				} while (diaValido!=true);
				break;

			case 11:
				mesValido=true;
				limitDia=30;
				System.out.println("Introduce el dia");
				dia=sc.nextInt();
				do {
					if (dia<1 || dia>limitDia) {
						diaValido=false;
						System.out.println("Dia no valido, introducelo de nuevo");
						dia=sc.nextInt();
					}else {
						diaValido=true;
					}
				} while (diaValido!=true);
				break;

			case 12:
				mesValido=true;
				limitDia=31;
				System.out.println("Introduce el dia");
				dia=sc.nextInt();
				do {
					if (dia<1 || dia>limitDia) {
						diaValido=false;
						System.out.println("Dia no valido, introducelo de nuevo");
						dia=sc.nextInt();
					}else {
						diaValido=true;
					}
				} while (diaValido!=true);
				break;

			default:
				mesValido=false;
				System.out.println("Mes no valido, insertalo otra vez");
				break;
			}
		} while (mesValido!=true);

		System.out.println("La fecha introducia es: "+a�o+" - "+mes+" - "+dia);
		dia++;
		if (dia>limitDia) {
			dia=1;
			mes++;
		}
		if (mes>12) {
			mes=1;
			a�o++;
		}
		System.out.println("La fecha del dia siguiente es: "+a�o+" - "+mes+" - "+dia);
	}

}
