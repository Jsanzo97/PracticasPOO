package entrega1.producto;
import entrega2.vendible.Vendible;

/**
 * Gestion de los productos para una maquina de vending
 * 
 * @author Jaimarq
 * @author Jorgsan
 */
public class Producto extends Vendible {
	
	private String upc;
	private double precio;
	
	/**
	 * Costructor de la clase	
	 * @param upc	Debe ser upc valido
	 * @param nombre	Nombre del producto
	 * @param precio 	Un entero que representa el precio en centimos
	 * @assert.pre ComprobarUpc(upc) == true
	 * @assert.pre this.precio &gt;= 0
	 */
	
	
	public Producto(String upc, String nombre, int precio){
		
		assert(comprobarUpc(upc) == true);
		assert(precio>=0);
		this.upc=upc;
		super.setNombre(nombre);
		this.precio=(double)(precio)/100;	
	}
	
	/**
	 * Metodo que comprueba si el upc del producto es correcto
	 * @param upc identificador universal del producto a crear
	 * @return true si el upc es correcto , false si no lo es
	 * @throws NumberFormatException si no puede convertir el String en un entero
	 */
	public boolean comprobarUpc(String upc){
		String w = upc;
		try {
			if(w.length() != 12){
				return false;
			}else{
				Integer.parseInt(w.substring(0,6));
				Integer.parseInt(w.substring(6,11));
				int suma=0;
			
				for(int i=0; i<11; i++){
					if(i%2 ==0 ){
						suma=suma+((((int)w.charAt(i))-48)*3);
					}else{
						suma=suma+((int)w.charAt(i)-48);
					}
				}
				if(suma % 10 != 0){
					suma=10-suma%10;
				}else{
					suma=0;
				}
				if(suma == (int)w.charAt(11)-48){
					return true;
				}else{
					return false;
				}
			}
		}catch (NumberFormatException e){
			return false;
		}
	}
	
	/**
	 * Cambia el precio del producto
	 * @param precio nuevo precio del producto
	 * @assert.pre precio &gt;= 0;
	 */
	public void setPrecio(int precio){
		assert(precio>=0);
		this.precio=((double)precio)/100;
	}
	
	/**
	 * Devuelve el precio del producto
	 * @return precio 
	 */
	@Override
	public double getPrecio(){
		return this.precio;
	}
	
	/**
	 * Devuelve el upc del producto
	 * @return upc
	 */
	@Override
	public String getUpc(){
		return upc;
	}
}
