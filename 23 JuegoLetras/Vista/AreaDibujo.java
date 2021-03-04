import java.awt.Canvas;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.Timer;



public class AreaDibujo extends Canvas{
	public static final int SEP=80;
	
	public static final int FACIL=1;
	public static final int MEDIO=2;
	public static final int DIFICIL=3;
	
	//DATOS
	private JuegoLetras juegoLetras;
	private Circulo[] arrayCirculos;
	private Cuadrado[] arrayCuadrados;
	private int nivel;
	//PARA EL MENSAJE FINAL
	private int aciertos, fallos;
	private EventosAreaDibujo eventosAreaDibujo;
	//PARA EL DOBLE BUFFER
	private Image buffer;
	private Graphics pantVirtual;
	
	//PARA LA ANIMACION INICIAL
	private Timer reloj;
	private Circulo circ;
	private Cuadrado cuad;
	
	public AreaDibujo(JuegoLetras juegoLetras) {
		this.juegoLetras=juegoLetras;
		//CREAR EL CIRCULO Y EL CUADRADO PARA LA ANIMACIÓN
		circ=new Circulo(0,0,80,80);
		circ.setDirH(1);
		circ.setDirV(1);
		circ.setLetra("A");
		circ.setVelocidad(5);
		
		cuad=new Cuadrado(0,700,80,80);
		cuad.setDirH(1);
		cuad.setDirV(-1);
		cuad.setVelocidad(10);
		
		eventosAreaDibujo=new EventosAreaDibujo(this);
		aciertos=0;
		fallos=0;
	}
	
	public Timer getReloj() {
		return reloj;
	}

	public void setReloj(Timer reloj) {
		this.reloj = reloj;
	}

	public Circulo getCirc() {
		return circ;
	}

	public void setCirc(Circulo circ) {
		this.circ = circ;
	}

	public Cuadrado getCuad() {
		return cuad;
	}

	public void setCuad(Cuadrado cuad) {
		this.cuad = cuad;
	}

	public int getAciertos() {
		return aciertos;
	}

	public void setAciertos(int aciertos) {
		this.aciertos = aciertos;
	}

	public int getFallos() {
		return fallos;
	}

	public void setFallos(int fallos) {
		this.fallos = fallos;
	}

	public JuegoLetras getJuegoLetras() {
		return juegoLetras;
	}

	public void setJuegoLetras(JuegoLetras juegoLetras) {
		this.juegoLetras = juegoLetras;
	}

	public Circulo[] getArrayCirculos() {
		return arrayCirculos;
	}

	public void setArrayCirculos(Circulo[] arrayCirculos) {
		this.arrayCirculos = arrayCirculos;
	}

	public Cuadrado[] getArrayCuadrados() {
		return arrayCuadrados;
	}

	public void setArrayCuadrados(Cuadrado[] arrayCuadrados) {
		this.arrayCuadrados = arrayCuadrados;
	}

	public int getNivel() {
		return nivel;
	}

	public void setNivel(int nivel) {
		this.nivel = nivel;
	}

	public void crearCirculos() {
		//INSTANCIAR ARRAY
		arrayCirculos=new Circulo[nivel*5];
		//CREAR CIRCULOS EN FUNCIÓN DEL NIVEL, INDICANDO POSICION PARA CADA UNO
		//Y AÑADIRLOS AL ARRAY
		for (int i = 0; i < arrayCirculos.length; i++) {
			if(i==0) { //EL PRIMERO
				arrayCirculos[i]=new Circulo(30, 30, 75, 75);
			}else if(i%5==0){//LOS DE LA PRIMERA COLUMNA
				arrayCirculos[i]=new Circulo(arrayCirculos[i-5].getPosX(),
											arrayCirculos[i-5].getPosY()+
											arrayCirculos[i-5].getAlto()+SEP,
											75,75);
			}else {//EL RESTO
				arrayCirculos[i]=new Circulo(arrayCirculos[i-1].getPosX()+
												arrayCirculos[i-1].getAncho()+SEP, 
												arrayCirculos[i-1].getPosY(), 75, 75);
			}
		}
		//ASIGNAR LAS LETRAS A CADA CIRCULO (MAYUSCULAS ALEATORIAS SIN REPETIR)
		Random r=new Random();
		for (int i = 0; i < arrayCirculos.length; i++) {
			arrayCirculos[i].setLetra((char)(r.nextInt(27)+'A')+"");
			if(arrayCirculos[i].getLetra().equals("[")) {
				arrayCirculos[i].setLetra("Ñ");
			}
			for (int j = 0; j < i; j++) {
				if(arrayCirculos[i].getLetra().equals(arrayCirculos[j].getLetra())) {
					i--;
					break;
				}
			}
		}
	}
	
	public void crearCuadrados() {
		//INSTANCIAR ARRAY
		arrayCuadrados=new Cuadrado[nivel*5];
		//CREAR CIRCULOS EN FUNCIÓN DEL NIVEL, INDICANDO POSICION PARA CADA UNO
		//Y AÑADIRLOS AL ARRAY
		for (int i = 0; i < arrayCuadrados.length; i++) {
			if(i==0) { //EL PRIMERO
				arrayCuadrados[i]=new Cuadrado(30, 450, 75, 75);
			}else if(i%5==0){//LOS DE LA PRIMERA COLUMNA
				arrayCuadrados[i]=new Cuadrado(arrayCuadrados[i-5].getPosX(),
						arrayCuadrados[i-5].getPosY()+
						arrayCuadrados[i-5].getAlto()+SEP,
						75,75);
			}else {//EL RESTO
				arrayCuadrados[i]=new Cuadrado(arrayCuadrados[i-1].getPosX()+
						arrayCuadrados[i-1].getAncho()+SEP, 
						arrayCuadrados[i-1].getPosY(), 75, 75);
			}
		}
		
		//ASIGNAR LETRAS A LOS CUADRADOS (cambiar de orden las letras de los circulos
		//y cambiarlas a minúsculas)
		ArrayList<String> arrayLetras=new ArrayList<String>();
		/*for (int i = 0; i < arrayCirculos.length; i++) {
			arrayLetras.add(arrayCirculos[i].getLetra().toLowerCase());
		}*/
		
		for (Circulo circulo:arrayCirculos) {
			arrayLetras.add(circulo.getLetra().toLowerCase());
		}
		//meterlas desordenadas en cada cuadrado
		Random r=new Random();
		int pos;
		for(Cuadrado cuadrado:arrayCuadrados) {
			//coger posicion aleatoria del arrayList
			pos=r.nextInt(arrayLetras.size());
			//meter la letra de esa posicion en el cuadrado actual
			cuadrado.setLetra(arrayLetras.get(pos));
			//eliminar la letra de esa posicion del arrayList
			arrayLetras.remove(pos);
		}
	}
	
	@Override
	public void paint(Graphics g) {
		// DIBUJAR TOOOOOOOOOOOOOOOODOS LOS ELEMENTOS DE LA PARTE GRÁFICA
		super.paint(g);
		if(arrayCirculos!=null) {//CUANDO COMIENZA EL JUEGO
			for (Circulo circulo : arrayCirculos) {
				circulo.dibujar(g);
			}
			for (Cuadrado cuadrado : arrayCuadrados) {
				cuadrado.dibujar(g);
			}
			//SI ES EL FINAL MOSTRAR EL MENSAJE DE ACIERTOS Y FALLOS
			if(aciertos!=0 || fallos!=0) {
				g.setColor(Color.BLUE);
				g.setFont(new Font("Arial", Font.PLAIN, 60));
				g.drawString("ACIERTOS: "+aciertos, 100, 550);
				g.drawString("FALLOS: "+fallos, 100, 650);
				
			}
		}else {//PARA LA ANIMACION INICIAL
			circ.dibujar(g);
			cuad.dibujar(g);
		}
	}
	
	@Override
	public void update(Graphics g) {
		buffer=createImage(this.getWidth(), this.getHeight());
		pantVirtual=buffer.getGraphics();
		paint(pantVirtual);
		g.drawImage(buffer, 0, 0, this.getWidth(), this.getHeight(), null);
	}
	
}









