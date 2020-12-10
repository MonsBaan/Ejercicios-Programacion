
public class Persona {
	private String nombre, mail, web;

	public Persona() {
		//CONSTRUCTOR 1
		nombre="";
		mail="";
		web="";
	}

	public Persona(String nombre, String mail, String web) {
		//CONSTRUCTOR 2
		this.nombre=nombre;
		this.mail=mail;
		this.web=web;
	}

	//GETTER Y SETTERS
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public String getWeb() {
		return web;
	}

	public void setWeb(String web) {
		this.web = web;
	}

	public boolean esMailCorrecto(String mail) {
		int contArroba=0;
		int cont=0;
		boolean entreArrobaPunto=false;
		boolean espacio=false;
		boolean antesArroba=false;
		boolean despuesPunto=false;
		boolean esPunto=false;

		for (int i = 0; i < mail.length(); i++) {
			if (mail.charAt(i)=='.') {		//SE DETECTA EL PUNTO
				if (cont<3) {				//MENOS DE 3 LETRAS ENTRE @ Y PUNTO
					entreArrobaPunto=true;
				}else {
					entreArrobaPunto=false;
				}
				esPunto=true;
				cont=0;
			}
			
			if (esPunto) {					//CUENTA NUMEROS DESPUES DEL PUNTO
				if (cont<2) {
					despuesPunto=true;
				}else if (cont>2) {
					despuesPunto=false;
				}
				cont++;
			}
			if (mail.charAt(i)=='@') {		//SI LA ARROBA NO TIENE 3 CARACTERES POR DETRAS
				if (cont<3) {
					antesArroba=true;
				}else if (cont>3) {
					antesArroba=false;
				}
				cont=0;
				contArroba++;				//CUENTA ARROBAS
			}
			if (mail.charAt(i)==' ') {		//SI EL EMAIL TIENE UN ESPACIO
				espacio=true;
			}
			cont++;
		}

		if (contArroba==0 || contArroba>1 || espacio==true || antesArroba==true || despuesPunto==true || entreArrobaPunto==true) {
			return false;
		}else {
			return true;
		}

	}
	
	public void guardar() {
		
	}
	public void cargar() {
		
	}

}
