package entrega1.producto;

import static org.junit.Assert.*;
import org.junit.Test;

/**
 * Test de Producto
 * @author Jaimarq
 * @author Jorgsan
 */
public class ProductoTest {

	@Test
	public void testProductoValido() {
		Producto p = new Producto("251483719020","Agua",60);
		Producto q = new Producto("111111111117","Coca-cola",80);
		assertEquals(p.getPrecio(), 0.6, 0.01);
		assertEquals (p.getUpc(),"251483719020");
		assertEquals (p.getNombre(),"Agua");
		assertEquals(q.getPrecio(), 0.8, 0.01);
		assertEquals (q.getUpc(),"111111111117");
		assertEquals (q.getNombre(),"Coca-cola");
		assertEquals(p.toString(), "Agua. 0.6 €");
		assertEquals(q.toString(), "Coca-cola. 0.8 €");
		assertNotSame (p,q);
		assertNotEquals(p,q);
		assertNotNull(p);
		assertNotNull(q);
	}
	@Test (expected = AssertionError.class)
	public void testProductoUpcNoValido() {
		Producto p = new Producto("111911111113","Agua",60);
	}
	@Test (expected = AssertionError.class)
	public void testProductoUpcCorto() {
		Producto p = new Producto("1119111","Agua",60);
	}
	@Test (expected = AssertionError.class)
	public void testProductoUpcLargo() {
		Producto p = new Producto("1119111454111113","Agua",60);
	}
	@Test (expected = AssertionError.class)
	public void testProductoUpcCaracteresNoValidos() {
		Producto p = new Producto("&11u11%11@13","Agua",60);
	}
	@Test (expected = AssertionError.class)
	public void testProductoPrecioNoValido() {
		Producto p = new Producto("111111111113","Agua",-1);
	}
	@Test
	public void testSetPrecioValido() {
		Producto p = new Producto("251483729029","Agua",60);
		assertNotNull(p);
		p.setPrecio(80);
		assertEquals(p.getPrecio(), 0.8, 0.01);
	}
	@Test (expected = AssertionError.class)
	public void testSetPrecioNoValido() {
		Producto p = new Producto("251483729029","Agua",60);
		assertNotNull(p);
		p.setPrecio(-1);
		
	}
	
	//Comprobaciones Extra
	@Test 
	public void testGetPrecioValido() {
		Producto p = new Producto("251483729029","Agua",60);
		assertNotNull(p);
		assertEquals(p.getPrecio(), 0.6, 0.01);
	}
	@Test 
	public void testGetNombreValido() {
		Producto p = new Producto("251483729029","Agua",60);
		assertNotNull(p);
		assertEquals(p.getNombre(), "Agua");
	}
	@Test 
	public void testGetUpcValido() {
		Producto p = new Producto("251483729029","Agua",60);
		assertNotNull(p);
		assertEquals(p.getUpc(), "251483729029");
	}
	@Test 
	public void testToStringValido() {
		Producto p = new Producto("251483729029","Agua",60);
		assertNotNull(p);
		assertEquals(p.toString(), "Agua. 0.6 €");
	}
	
}
