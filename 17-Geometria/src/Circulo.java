
public class Circulo {
	public static final double PI=Math.PI;
	//DATOS
	private double radio;
	private Punto centro;


	//CONSTRUCTOR 1 SIN PARAMETROS
	public Circulo() {
		radio=0;
		centro= new Punto();
	}

	//CONSTRUCTOR 2: RECIBE SOLO EL RADIO (SOLO PARA CIRCULOS CON EL CENTRO EN EL PUNTO 0, 0)
	public Circulo(double radio) {
		this.radio=radio;
		centro= new Punto(0,0);
	}
	//CONSTRUCTOR 3: RECIBE EL RADIO Y EL CENTRO EN FORMA DE PUNTO
	public Circulo(double radio, Punto centro) {
		this.radio=radio;
		this.centro=centro;
	}
	//CONSTRUCTOR 4: RECIBE EL RADIO Y LAS DOS COORDENADAS DEL CENTRO
	public Circulo(double radio, double x, double y) {
		this.radio=radio;
		this.centro=new Punto(x,y);
	}

	//GETTERS Y SETTERS

	public double getRadio() {
		return radio;
	}

	public void setRadio(double radio) {
		this.radio = radio;
	}

	public Punto getCentro() {
		return centro;
	}

	public void setCentro(Punto centro) {
		this.centro = centro;
	}

	//METODOS
	//METODO QUE DEVUELVA EL AREA DEL CIRCULO
	public double area() {
		return (PI*radio*radio);
	}
	//METODO QUE DEVUELVA LA LONGITUD DE LA CIRCUNFERENCIA
	public double perimetro() {
		return (2*PI*radio);
	}
	//METODO QUE MUEVA EL CIRCULO A UNA POSICION RECIBIDA COMO PARAMETRO
	public void mover(double x, double y) {
		centro=new Punto();	//MEDIANTE EL CONSTRUCTOR
		
		centro.setX(x);//MEDIANTE EL SETTERS
		centro.setY(y);
		
		
	}
	
	//METODO QUE DEVUELVE EN FORMA DE STRING EL RADIO Y LAS DOS COORDENADAS DEL CENTRO TODO CON DOS DECIMALES Y SEPARADOS POR ", "
	public String toString() {
		return("R= "+String.format("%.2f", radio)+" X= "+String.format("%.2f", centro.getX())+ " Y= "+String.format("%.2f", centro.getY()));
	}
}
