package generica;
/**
 * Ejemplo de uso de una clase generica
 */
import java.util.ArrayList;
public class Prueba {

	public static void main (String [] args){		
		Generica<Integer> x = new Generica<Integer> (new ArrayList<Integer>());
		Generica<String> y = new Generica<String> (new ArrayList<String>());
		
		x.add(1);
		x.add(2);
		
		y.add("uno");
		y.add("dos");
		
		System.out.println(x.getObj(0));
		x.borra(0);
		System.out.println(x.getObj(0));
		
		System.out.println(y.getObj(0));
		y.borra(0);
		System.out.println(y.getObj(0));
	}
}