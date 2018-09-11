package entrega2.polimorfismo;

import static org.junit.Assert.*;
import org.junit.Test;
import entrega1.producto.Producto;
import entrega2.pack.Pack;
import entrega2.vendible.Vendible;

public class PolimorfismoTest {

	@Test
	public void testPolimorfismoDeVendible() {
		Vendible v;
		
		v = new Producto("251483719020","Agua",100);
		assertEquals(v.getPrecio(), 1, 0.01);
		assertEquals (v.getUpc(),"251483719020");
		assertEquals (v.getNombre(),"Agua");
		assertEquals(v.toString(), "Agua. 1.0 €");
		assertNotNull(v);
		
		Producto p = new Producto("251483719020","Agua",100);
		Producto q = new Producto("251483719020","Agua",100);
		Producto x [] = {p,q};
		
		v = new Pack ("Agua 2x1.6", x );
		assertNotNull (v);
		assertEquals(v.getPrecio(), 1.6, 0.01);
		assertEquals(v.getNombre(), "Agua 2x1.6");
		assertEquals(v.getUpc(),"4028664280404");
		assertEquals(v.toString(), "Agua 2x1.6. 1.6 €");
		
	}
}
