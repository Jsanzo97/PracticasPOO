package entrega2.pack;
import entrega1.producto.Producto;
import entrega2.vendible.Vendible;
import java.util.ArrayList;

/**
 * Gestion de packs de productos para una maquina de vending
 * 
 * @author Jaimarq
 * @author Jorgsan
 */
public class Pack extends Vendible {
	private ArrayList<Producto> pack = new ArrayList<Producto>();
	
	/**
	 * Costructor de la clase	
	 * @param nombre	Nombre del producto
	 * @param precio 	Un entero que representa el precio en centimos
	 * @assert.pre productos.length&gt=2
	 * @assert.pre hayProductos(productos) == true
	 */
	public Pack(String nombre, Producto[] productos){
		assert(productos.length>=2);
		assert(hayProductos(productos) == true);
		for(int i=0; i<productos.length; i++)
			pack.add(productos[i]);
		super.setNombre(nombre);
	}
	
	/**
	 * Devuelve el upc del pack
	 * Redefinicion de getUpc de la clase Vendible
	 * @return identificador numero que distigue un pack de cualquier otro
	 */
	@Override
	public String getUpc(){
		int p1=0, p3=0, p5=0, p7=0, p9=0, p11=0;
		int p2=0, p4=0, p6=0, p8=0, p10=0, p12=0;
		String identificador;
		for(int i=0; i<getNumProductosPack(); i++){
			p1+=Integer.parseInt(pack.get(i).getUpc().substring(0,1));
			p2+=Integer.parseInt(pack.get(i).getUpc().substring(1,2));
			p3+=Integer.parseInt(pack.get(i).getUpc().substring(2,3));
			p4+=Integer.parseInt(pack.get(i).getUpc().substring(3,4));
			p5+=Integer.parseInt(pack.get(i).getUpc().substring(4,5));
			p6+=Integer.parseInt(pack.get(i).getUpc().substring(5,6));
			p7+=Integer.parseInt(pack.get(i).getUpc().substring(6,7));
			p8+=Integer.parseInt(pack.get(i).getUpc().substring(7,8));
			p9+=Integer.parseInt(pack.get(i).getUpc().substring(8,9));
			p10+=Integer.parseInt(pack.get(i).getUpc().substring(9,10));
			p11+=Integer.parseInt(pack.get(i).getUpc().substring(10,11));
			p12+=Integer.parseInt(pack.get(i).getUpc().substring(11,12));
		}
		identificador=String.valueOf(p1%10)+String.valueOf(p2%10)+String.valueOf(p3%10)+
				String.valueOf(p4%10)+String.valueOf(p5%10)+String.valueOf(p6%10)+
				String.valueOf(p7%10)+String.valueOf(p8%10)+String.valueOf(p9%10)+
				String.valueOf(p10%10)+String.valueOf(p11%10)+String.valueOf(p12%10)+
				String.valueOf(((p1+p2+p3+p4+p5+p6+p7+p8+p9+p10+p11+p12)%10));
		return identificador;
	}
	
	/**
	 * Devuelve el tamaño del pack
	 * @return pack.size() tamaño del pack
	 */
	public int getNumProductosPack(){
		return pack.size();
	}	
	
	/**
	 * Devuelve el precio del pack
	 * Redefinicion de getPrecio de la clase Vendible
	 * @return precio precio del pack
	 */
	@Override
	public double getPrecio(){
		double precio=0;
		for(int i=0; i<getNumProductosPack(); i++){
			precio+=pack.get(i).getPrecio();
		}
		
		return precio*0.8;
	}
	
	/**
	 * Devuleve los productos que forman el pack
	 * @return productos vector de productos que forman el pack
	 */
	public Producto[] productos(){
		Producto[] productos = new Producto[pack.size()];
		for (int i = 0; i<productos.length; i++){
			productos[i] = pack.get(i);
		}
		return productos;
	}
	
	/**
	 * Comprueba si hay ciertos productos en el pack
	 * @param productos vector de productos para comprobar
	 * @return true o false
	 */
	public boolean hayProductos(Producto[] productos){
		int i=0;
		while(i<productos.length){
			if(productos[i]==null){
				return false;
			}else{
				i++;
			}
		}
		return true;
	}
	
	/**
	 * Metodo de comprobar si un producto está en el pack
	 * 
	 * La comprobación se realiza mediante el upc y el precio
	 * 
	 * @param p Producto que se desea comprobar si esta en el pack
	 * @return True, si el producto esta en el pack; False, si no
	 */
	public boolean estaEnPack(Producto p){
		String upc = p.getUpc();
		double precio = p.getPrecio();
		for(int i=0; i<pack.size(); i++){
			if(upc == pack.get(i).getUpc() && precio == pack.get(i).getPrecio()){
				return true;
			}
		}
		return false;
	}
	
	/**
	 * Metodo para quitar productos de un pack
	 * 
	 * @param p Array de productos que se quieren quitar del pack
	 * @assert.pre La longitud del array tiene que ser mayor que 0
	 * @assert.pre El array tiene que tener exclusivamente productos
	 * @assert.pre Los productos del array deben de estar en el pack
	 * @assert.pre No se pueden quitar productos si el pack resultante no tuviera al menos 2 productos
	 */
	public void quitaProducto(Producto[] p){
		assert(p.length>0);
		assert(hayProductos(p)==true);
		for(int i=0; i<p.length;i++){
			assert(estaEnPack(p[i])==true):"Producto ausente en pack";
		}
		assert((pack.size()-p.length)>=2);
		
		int indice=0, j=0;
		String upc;
		double precio;
		while(j<p.length){
			upc = p[j].getUpc();
			precio = p[j].getPrecio();
			while(indice<pack.size()){
				if(upc==pack.get(indice).getUpc()){
					if(precio == pack.get(indice).getPrecio()){
						pack.remove(indice);
						indice=pack.size();
					}
				}
				indice++;
			}
			indice=0;
			j++;
		}
	}	
	
	/**
	 * Metodo para añadir un producto al pack
	 * 
	 * @param p Array de productos a añadir
	 * @assert.pre La longitud del vector debe ser mayor que 0
	 * @assert.pre El vector debe estar lleno de productos
	 */
	public void añadeProducto(Producto[] p){
		assert(p.length>0);
		assert(hayProductos(p)==true);
		
		for (int i = 0; i<p.length; i++){
			pack.add(p[i]);
		}
	}
}
