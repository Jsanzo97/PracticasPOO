/**
 * Ejemplo de creacion de un objeto tipo Fecha y uso de sus operaciones
 */
package ejercicioFecha;

public class Main {
	
	public static void main(String[] args){
		Fecha a = new Fecha();
		Fecha b = new Fecha(1,1,1990);
		System.out.println("Fecha actual: "+a.Dia()+" de "+a.Mes()+" del "+a.year());
		a.Suma(36);
		System.out.println("Fecha calculada: "+a.Dia()+" de "+a.Mes()+" del "+a.year());
	}
}