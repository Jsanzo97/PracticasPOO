package entrega2.vendible;

abstract public class Vendible {
	private String nombre;
	
	public String getNombre(){
		return nombre;
	}
	
	abstract public String getUpc();
		
	public String toString(){
		String vendible = getNombre()+". "+String.valueOf(getPrecio())+" €";
		return vendible;
	}
	abstract public double getPrecio();
		
	public void setNombre(String nombre){
		this.nombre=nombre;
	}
}
	
	


