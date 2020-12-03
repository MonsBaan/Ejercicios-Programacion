
public class Punto {
	//DATOS

	private double x;
	private double y;

	//CONSTRUCTOR
	public Punto() {
		x=0;
		y=0;
	}

	public Punto (double x, double y) {
		this.x=x;
		this.y=y;
	}

	//GETTERS Y SETTERS

	public double getX() {
		return x;
	}
	public double getY() {
		return y;
	}
	public void setX(double x) {
		this.x=x;
	}
	public void setY(double y) {
		this.y=y;
	}


	//METODOS (FUNCIONES ASOCIADAS A LA CLASE) (PUBLIC)
	public double distancia(double x, double y) {
		double dist;
		dist= Math.sqrt(((x-this.x)*(x-this.x))+((y-this.y)*(y-this.y)));
		return dist;
	}
	
	public String getStr() {
		
		return(String.format("%.2f", x)+ ", " +String.format("%.2f", y));
	}
	public double distancia(Punto p) {
		double dist;
		dist= Math.sqrt(((p.x-this.x)*(p.x-this.x))+((p.y-this.y)*(p.y-this.y)));
		return dist;
	}
}


