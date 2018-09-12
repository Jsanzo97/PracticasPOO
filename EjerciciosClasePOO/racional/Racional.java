/**
 * Implementacion basica de los racionales
 * @author Jorge y Jaime
 */
package racional;

public class Racional {

	private double numerador;
	private double denominador;
	
	/**
	 * Constructor por defecto
	 * Racional = 0
	 */
	public Racional(){
		denominador = 1;
		numerador=0;
	}

	/**
	 * Constructor principal de la clase
	 * @param numerador
	 * @param denominador , nunca puede ser cero
	 */
	public Racional(double numerador, double denominador){
		this.numerador = numerador;
		this.denominador = denominador;
	}
	
	/**
	 * Obtiene el denominador del racional como valor
	 * @return denominador
	 */
	public double getDenominador(){
		return denominador;
	}
	
	/**
	 * Obtiene el numerador del racional como valor
	 * @return numerador
	 */
	public double getNumerador(){
		return numerador;
	}
	
	/**
	 * Suma de this con otro
	 * @param otro es un racional
	 */
	public void Suma(Racional otro){
		numerador = otro.getDenominador() * numerador + denominador * otro.getNumerador();
		denominador = denominador * otro.getDenominador();
		Simplifica();
	}
	
	/**
	 * Resta de this con otro
	 * @param otro 
	 */
	public void Resta(Racional otro){
		otro.Opuesto();
		this.Suma(otro);
	}
	
	/**
	 * Multiplica this con otro
	 * @param otro
	 */
	public void Multiplica(Racional otro){
		numerador = numerador * otro.getNumerador();
		denominador = denominador * otro.getDenominador();
		Simplifica();
	}
	
	/**
	 * Divide this con otro
	 * @param otro
	 */
	public void Divide(Racional otro){
		this.Inverso();
		this.Multiplica(otro);
		
	}
	
	/**
	 * Calcula el maximo comun divisor
	 * @param a primer numero
	 * @param b segundo numero
	 * @return maximo comun divisor de a y b
	 */
	private double mcd(double a, double b){
		if(b==0)
			return a;
		else
		    return mcd(b, a % b);
	}
	
	/**
	 * Inverso de this
	 */
	public void Inverso(){
		double aux = numerador;
		numerador = denominador;
		denominador = aux;
	}
	
	/**
	 * Opuesto de this
	 */
	public void Opuesto(){
		numerador = -numerador;
	}
	
	/**
	 * Simplifica this si es posible, si no devuelve this
	 */
	public void Simplifica(){
		double x = mcd(numerador,denominador);
		numerador = numerador / x;
		denominador = denominador / x;
	}
	
	/**
	 * Convierte this a String para imprimirle
	 */
	public String toString(){
		String numero=" "+String.valueOf(numerador)+"\n-----\n"+" "+String.valueOf(denominador)  ;
		return numero;
	}
}