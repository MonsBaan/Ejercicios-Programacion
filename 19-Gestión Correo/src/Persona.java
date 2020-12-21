import java.io.PrintWriter;
import java.util.Scanner;

public class Persona {
	//DATOS
	private String nombre, mail, web;
	private String strError;
	
	//CONSTRUCTORES
	public Persona() {
		nombre="";
		mail="";
		web="";
	}
	
	public Persona(String nombre, String mail, String web) {
		this.nombre=nombre;
		this.mail=mail;
		this.web=web;
	}

	//GETTERS Y SETTERS
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
	
	public String getStrError() {
		return strError;
	}

	public void setStrError(String strError) {
		this.strError = strError;
	}

	//MÉTODOS
	public boolean esMailCorrecto() {
		int contArrobas=0;
		for(int i=0;i<mail.length();i++) {
			if(mail.charAt(i)=='@') {
				contArrobas++;
			}
		}
		if(contArrobas>1 || contArrobas==0) {
			strError="Solo puede haber una arroba";
			return false;
		}
		//No hay al menos dos caracteres antes de la arroba
		if(mail.indexOf("@")<3) {
			strError="Antes de la arroba debe haber al menos 3 caracteres";
			return false;
		}
		
		//Hay algún espacio
		if(mail.contains(" ")) {
			strError="El mail no puede contener espacios";
			return false;
		}
		//Entre la @ y el último punto hay menos de 3 caracteres
		if(mail.indexOf("@")>=mail.lastIndexOf(".")-3) {
			strError="Entre la @ y el último punto debe haber al menos 3 caracteres";
			return false;
		}
		//Menos de dos caracteres después del último punto
		if(mail.lastIndexOf('.')>=mail.length()-2) {
			strError="la extensión del dominio debe tener al menos 2 caracteres";
			return false;
		}
			
		
		return true;
	}

	public void guardar(PrintWriter pw) {
		pw.println(this.nombre);
		pw.println(this.mail);
		pw.println(this.web);
	}
	
	public Persona cargar(Scanner sc) {
		/*Persona p=new Persona(String.valueOf(sc.nextLine()),
				String.valueOf(sc.nextLine()),
				String.valueOf(sc.nextLine()));
		return p;*/
		Persona p;
		String nombre, mail, web;
		nombre=sc.nextLine();
		mail=sc.nextLine();
		web=sc.nextLine();
		p=new Persona(nombre, mail, web);
		return p;
	}
}









