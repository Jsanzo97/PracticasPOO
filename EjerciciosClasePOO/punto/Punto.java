/**
 * Representacion de un objeto Punto y sus operaciones
 */
package punto;

public class Punto {

	private double x;
	private double y;

	public Punto(){
		x = 0;
		y = 0;
	}
	
	/**
	 * @param x coordenada X
	 * @param y coordenada Y
	 */
	public Punto(double x,double y){
		this.x = x;
		this.y = y;
	}
	
	/**
	 * 
	 * @param i punto con el que queremos obtener la distancia
	 * @return distancia entre los dos puntos
	 */
	public double distancia(Punto i){
		
		double d = Math.sqrt(Math.pow((i.getX()-x),2)+Math.pow((i.getY()-y),2));
		return d;
	}
	
	/**
	 * Traslada el punto en el espacio
	 * @param a variacion de la coordenada X
	 * @param b variacion de la coordenada Y
	 */
	public void traslada(double a, double b){
		x = x + a;
		y = y + b;
	}
	
	/**
	 * Cambia el punto a una cadena de texto con su informacion
	 * @return
	 */
	public String cartesianasACadena(){
		String x = this.getX()+","+this.getY();
		return x;
	}
	
	public double getX(){
		return x;
	}
	
	public double getY(){
		return y;
	}

}