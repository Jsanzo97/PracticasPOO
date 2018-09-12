/**
 * Clase Fecha
 * @author Jorge
 * Implementacion basica de la fecha y capacidad de saber que dia sera dentro de X dias
 */
package ejercicioFecha;

public class Fecha {

	private int dia;
	private int mes;
	private int year;
	
	/** 
	 * Constructor de la clase
	 * @param dia 
	 * @param mes 
	 * @param a�o
	 */
	public Fecha(int dia, int mes, int year){

		this.dia = dia;
		this.mes = mes;
		this.year = year;
	}
	
	public Fecha(){
		dia = 1;
		mes = 1;
		year = 2001;
	}
	
	public int Dia(){
		return dia;
	}
	
	public int year(){
		return year;
	}
	
	public String Mes(){
		
		if (mes>12){
			mes = mes%12;
		}
		
		switch(mes){
			case 1:
				return "Enero";
			case 2:
				return "Febrero";
			case 3:
				return "Marzo";
			case 4:
				return "Abril";
			case 5:
				return "Mayo";
			case 6:
				return "Junio";
			case 7:
				return "Julio";
			case 8:
				return "Agosto";
			case 9:
				return "Septiembre";
			case 10:
				return "Octubre";
			case 11:
				return "Noviembre";
			case 12:
				return "Diciembre";
			default:
				return "";
		}
	}
	
	/**
	 * Funcion suma
	 * @param x , suma x dias con la fecha dada
	 */
	public void Suma(int x){

		boolean bisiesto = Bisiesto();
		dia = dia+x;
		if(mes == 1 || mes == 3 || mes == 5 || mes == 7 || mes == 8 || mes == 10 || mes ==12){
			while(dia>31){
				dia = dia-31;
				mes = mes +1;
			}
			if (mes == 3){
				dia = dia+1;
			}
			if (mes == 12){
				dia = dia +6;
			}
		}
		
		if(mes == 2){
			if(bisiesto == true){
				while(dia>29){
					dia = dia-29;
					mes = mes +1;
				}
			}
			else{
				while(dia>28){
					dia = dia-28;
					mes = mes +1;
				}
			}
		}
		if(mes == 4 || mes == 6 || mes == 9 || mes == 11){
			while(dia>30){
				dia = dia-30;
				mes = mes +1;
			}
		}
		
		
	}
	 /**
	  * Funcion bisiesto
	  * @return true si es bisiesto, false si no lo es
	  */
	public boolean Bisiesto(){
		year = this.year();
		if (year%4==0 || year%400==0 && year%100!=0){
			return true;
		}
		else{
			return false;
		}
	}
}