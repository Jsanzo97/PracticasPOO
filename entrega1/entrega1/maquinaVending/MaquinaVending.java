package entrega1.maquinaVending;
import fabricante.externo.tarjetas.TarjetaMonedero;
import entrega2.vendible.Vendible;
import entrega1.producto.Producto;
import entrega2.pack.Pack;

/**
 * Servicio de venta de una maquina vending
 * @author Jaimarq
 * @author Jorgsan
 */
public class MaquinaVending {
	private int [] cantidad;
	private int cantidadMax;
	private Vendible maquina [];
	
	
	/**
	 * Constructor de la clase
	 * 
	 * @param nLineas		Tamaño deseado de la máquina
	 * @param cantidadMax	Número máximo de productos que se podrán colocar en cada línea
	 * @assert.pre  nLineas &gt; 0  cantidadMax &gt; 0
	 */
	public MaquinaVending(int nLineas,int cantidadMax){
		assert(nLineas>0 && cantidadMax>0);
		
		this.maquina = new Vendible[nLineas];
		this.cantidad = new int[nLineas];
		this.cantidadMax=cantidadMax;
	}
	
	/**
	 * Crea un producto y lo coloca en una línea de la máquina
	 * @param linea			Lugar de la máquina donde se colocara, la numeración de la máquina empieza en el entero 1
	 * @param cantidad		Cantidad de productos que se colocan
	 * @param upc			Identificador del producto
	 * @param nombre		Nombre del producto
	 * @param precio		Precio del producto
	 * @assert.pre {@code PrecioValido (Producto)} == true 
	 * @assert.pre linea &lt;= {@code this.GetLineas()} &amp;&amp; linea &gt; 0 
	 * @assert.pre linea == vacía 
	 * @assert.pre cantidad &lt;= {@code GetCantidadMaxima()}
	 */
	public void newVendible(int linea, int cantidad, String upc, String nombre, int precio){
		Producto p = new Producto(upc, nombre, precio);
		
		assert (linea-1<this.getLineas() && linea-1>=0);
		assert (maquina[linea-1]==null);
		assert (cantidad<=this.getCantidadMaxima());
		
		maquina[linea-1]=p;
		this.cantidad[linea-1]=cantidad;
		}
	public void newVendible(int linea, int cantidad, String nombre, Producto[]productos){
		Pack p = new Pack(nombre, productos);
		
		assert (linea-1<this.getLineas() && linea-1>=0);
		assert (maquina[linea-1]==null);
		assert (cantidad<=this.getCantidadMaxima());
		
		maquina[linea-1]=p;
		this.cantidad[linea-1]=cantidad;
		}
	
	/**
	 * Recarga una linea con ese mismo producto
	 * @param linea			Linea que se quiere recargar
	 * @param cantidad		Cantidad del producto que se va a recargar
	 * @assert.pre linea &lt;= this.GetLineas() &amp;&amp; linea &gt; 0
	 * @assert.pre this.GetProducto(linea)!= null &amp;&amp; cantidad &gt; 0
	 * @assert.pre (this.GetCantidadRestante(linea) + cantidad) &lt;= this.GetCantidadMaxima()
	 */
	public void recarga(int linea, int cantidad){
		assert (linea<=this.getLineas() && linea > 0 );
		assert (this.getVendible(linea)!= null);
		assert (cantidad>0);
		assert((this.getCantidadRestante(linea)+cantidad)<=this.getCantidadMaxima());
		this.cantidad [linea-1]=this.cantidad[linea-1]+cantidad;	
	}
	
	/**
	 * Permite al cliente la compra de un producto 
	 * @param linea			Línea a comprar
	 * @param tarjeta		Tarjeta del cliente
	 * @assert.pre linea &gt; 0 &amp;&amp; linea &lt;= this.GetLineas()
	 * @assert.pre this.GetProducto(linea) != null
	 * @assert.pre tarjeta.getSaldoActual() &gt;= this.ConsultaPrecio(linea)
	 */
	public void compra (int linea, TarjetaMonedero tarjeta){
		assert (linea > 0 && linea <= this.getLineas());
		assert (this.getVendible(linea) != null);
		assert (tarjeta.getSaldoActual() >= this.consultaPrecio(linea));
		String credencial = "6Z1y00Nm31aA-571";
		tarjeta.descontarDelSaldo(credencial, this.consultaPrecio(linea));
		cantidad[linea-1]=cantidad[linea-1]-1;
		if (cantidad[linea-1] == 0){
			maquina[linea-1] = null;
		}
		
	}
	
	/**
	 * Devuelve la cantidad de producto de una linea
	 * @param linea 	Identificador de línea
	 * @return	cantidadrestante 	Devuelve la cantidad que queda de producto en esa línea
	 * @assert.pre linea &gt; 0 &amp;&amp; linea &lt;= this.GetLineas()
	 */
	public int getCantidadRestante (int linea){
		assert (linea > 0 && linea <= this.getLineas());
		int cantidadrestante = cantidad[linea-1];
		return cantidadrestante;
	}
	
	/**
	 * Devuelve el precio de un producto
	 * @param linea		línea del producto
	 * @return 		Devuelve el precio del producto
	 * @assert.pre  linea &gt; 0 &amp;&amp; linea &lt;= this.GetLineas()
	 * @assert.pre  this.GetProducto(linea) != null
	 */
	public double consultaPrecio(int linea){
		assert (linea > 0 && linea <= this.getLineas());
		assert (this.getVendible(linea) != null):"Producto agotado";
		return maquina[linea-1].getPrecio();
	}
	
	/**
	 * Devuelve información acerca del producto indicado
	 * @param linea 	línea del producto
	 * @return		String informativo
	 * @assert.pre  linea &lt; 0 &amp;&amp; linea &lt;= this.GetLineas()
	 * @assert.pre  this.GetProducto(linea)!=null
	 */
	public String consultaProducto (int linea){
		assert (linea > 0 && linea <= this.getLineas());
		assert(this.getVendible(linea)!=null):"Producto agotado";
		return (this.getVendible(linea).toString());
		
	}
	
	/**
	 * Deja la linea en null
	 * @param linea		línea del producto
	 * @assert.pre linea &gt; 0 &amp;&amp; linea &lt;= this.GetLineas()
	 * @assert.pre this.GetProducto(linea) != null
	 */
	//He añadido la función de vaciar un número de productos que se desee, faltan los test
	public void vaciaLinea(int linea, int cantidad){
		assert(linea>0 && linea<=this.getLineas());
		assert(this.getVendible(linea) != null);
		assert(this.getCantidadRestante(linea)>= cantidad && cantidad > 0);
		this.cantidad[linea-1]-= cantidad;
		if (this.getCantidadRestante(linea)==0){
			maquina[linea-1]=null;
		}
	}
	
	/**
	 * Devuelve la cantidad máxima que puede haber por línea
	 * @return cantidad maxima permitida
	 */
	public int getCantidadMaxima(){
		return cantidadMax;
	}
	
	/**
	 * Devuelve el número de líneas de la máquina
	 * @return cantidad de lineas de la maquina
	 */
	public int getLineas(){
		return maquina.length;
	}
	
	/**
	 * Devuelve el producto de una línea
	 * @param linea línea del producto
	 * @return	producto de la línea
	 * @assert.pre linea &gt;0 &amp;&amp; linea &lt;= this.GetLineas()
	 * @assert.pre this.GetProducto(linea) != null
	 */
	public Vendible getVendible(int linea){
		assert(linea>0 && linea<=getLineas());
		assert(maquina[linea-1] != null):"Producto agotado";
		return maquina[linea-1];
	}
	
	public void moverVendible(int origen, int destino){
		assert(origen>0);
		assert(origen<getLineas());
		assert(getVendible(origen)!=null);
		assert(destino>0);
		assert(destino<getLineas());
		assert(getVendible(destino)==null);
		
		
	}
}

