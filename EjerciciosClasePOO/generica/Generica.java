package generica;
/**
 * Implementacion basica de una clase generica y sus operaciones
 */
import java.util.ArrayList;
public class Generica <E> {
	private ArrayList<E> gen;
	
	public Generica(ArrayList<E> gen){
		this.gen = new ArrayList<E>();	
		}
	
	public void add(E elem){
		gen.add(elem);
	}
	
	public void borra(int n){
		gen.remove(n);
	}
	
	public E getObj(int n){
		return gen.get(n);
	}
	
}
