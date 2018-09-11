package entrega2.pack;

import static org.junit.Assert.*;

import org.junit.Test;

import entrega1.producto.Producto;

public class PackTest {

	@Test
	public void testPackValido() {
		Producto p = new Producto("251483719020","Agua",100);
		Producto v = new Producto("251483719020","Agua",100);
		Producto x [] = {p,v};
		Pack h = new Pack ("Agua 2x1.6", x );
		assertNotNull (h);
		Producto y [] = h.productos();
		for (int i =0; i<y.length; i++){
			assertEquals (x[i],y[i]);
			assertSame (x[i],y[i]);
		}
		assertEquals(h.getPrecio(), 1.6, 0.01);
		assertEquals(h.getNombre(), "Agua 2x1.6");
		assertTrue(h.estaEnPack(v));
		assertTrue(h.estaEnPack(p));
		assertEquals(h.getNumProductosPack(),2);
		assertEquals(h.getUpc(),"4028664280404");
		assertTrue(h.hayProductos(x));
	}
	@Test (expected = AssertionError.class)
	public void testPackNoValidoUnSoloProducto() {
		Producto p = new Producto("251483719020","Agua",100);
		Producto x [] = {p};
		Pack h = new Pack ("Agua", x );
	}
	@Test (expected = AssertionError.class)
	public void testPackNoValidoArrayConHuecos() {
		Producto p = new Producto("251483719020","Agua",100);
		Producto v = new Producto("251483719020","Agua",100);
		Producto x [] = {p,null,v};
		Pack h = new Pack ("Agua", x );	
	}
	@Test (expected = AssertionError.class)
	public void testPackNoValidoArrayVacio() {
		Producto x [] = {null,null,null};
		Pack h = new Pack ("Agua", x );	
	}
	@Test 
	public void testGetUpcValido() {
		Producto p = new Producto("251483719020","Leche",100);
		Producto q = new Producto("111111111117","Galletas",150);
		Producto[] x = {p,q};
		Pack h = new Pack("Desayuno", x);
		assertEquals(h.getUpc(),"3625948201370");
	}
	@Test 
	public void testGetNumProductosPackValido() {
		Producto p = new Producto("251483719020","Leche",100);
		Producto q = new Producto("111111111117","Galletas",150);
		Producto[] x = {p,q};
		Pack h = new Pack("Desayuno", x);
		assertEquals(h.getNumProductosPack(),2);
	}
	@Test 
	public void testGetPrecioValido() {
		Producto p = new Producto("251483719020","Leche",100);
		Producto q = new Producto("111111111117","Galletas",150);
		Producto[] x = {p,q};
		Pack h = new Pack("Desayuno", x);
		assertEquals(h.getPrecio(), 2, 0.01);
	}
	@Test 
	public void testProductosValido() {
		Producto p = new Producto("251483719020","Leche",100);
		Producto q = new Producto("111111111117","Galletas",150);
		Producto[] x = {p,q};
		Pack h = new Pack("Desayuno", x);
		Producto y [] = h.productos();
		for (int i =0; i<y.length; i++){
			assertEquals (x[i],y[i]);
			assertSame (x[i],y[i]);
		}
	}
	@Test 
	public void testHayProductosValido() {
		Producto p = new Producto("251483719020","Leche",100);
		Producto q = new Producto("111111111117","Galletas",150);
		Producto[] x = {p,q};
		Pack h = new Pack("Desayuno", x);
		assertEquals(h.hayProductos(x),true);
	}
	@Test 
	public void testEstaEnPackValido() {
		Producto p = new Producto("251483719020","Leche",100);
		Producto q = new Producto("111111111117","Galletas",150);
		Producto[] x = {p,q};
		Pack h = new Pack("Desayuno", x);
		assertTrue(h.estaEnPack(p));
		assertTrue(h.estaEnPack(q));
	}
	@Test 
	public void testQuitaProductoValido() {
		Producto p = new Producto("251483719020","Leche",100);
		Producto q = new Producto("111111111117","Galletas",150);
		Producto r = new Producto("111111111124","Patatas",80);
		Producto s = new Producto("251483719020","Leche",80);
		Producto[] x = {p,q,r,s};
		Producto[] quitar = {p,q};
		Pack h = new Pack("Desayuno", x);
		h.quitaProducto(quitar);
		assertFalse(h.estaEnPack(p));
		assertFalse(h.estaEnPack(q));
		assertTrue(h.estaEnPack(r));
		assertTrue(h.estaEnPack(s));	
	}
	@Test (expected = AssertionError.class)
	public void testQuitaProductoNoEnPack() {
		Producto p = new Producto("251483719020","Leche",100);
		Producto q = new Producto("111111111117","Galletas",150);
		Producto r = new Producto("111111111124","Patatas",100);
		Producto[] x = {q,r};
		Producto[] quitar = {p};
		Pack h = new Pack("Desayuno", x);
		h.quitaProducto(quitar);
	}
	@Test (expected = AssertionError.class)
	public void testQuitaProductoPackPequeño() {
		Producto p = new Producto("251483719020","Leche",100);
		Producto q = new Producto("111111111117","Galletas",150);
		Producto[] x = {p,q};
		Producto[] quitar = {p};
		Pack h = new Pack("Desayuno", x);
		h.quitaProducto(quitar);
	}
	@Test (expected = AssertionError.class)
	public void testQuitaProductoEnPackDistintoPrecio() {
		Producto p = new Producto("251483719020","Leche",100);
		Producto q = new Producto("111111111117","Galletas",150);
		Producto r = new Producto("251483719020","Leche",80);
		Producto[] x = {q,r};
		Producto[] quitar = {p};
		Pack h = new Pack("Desayuno", x);
		h.quitaProducto(quitar);
	}
	@Test (expected = AssertionError.class)
	public void testQuitaProductoUnoValidoUnoNoValido() {
		Producto p = new Producto("251483719020","Leche",100);
		Producto q = new Producto("111111111117","Galletas",150);
		Producto r = new Producto("251483719020","Leche",80);
		Producto s = new Producto("111111111117","Galletas",150);
		Producto[] x = {p,q,r};
		Producto[] quitar = {p,s};
		Pack h = new Pack("Desayuno", x);
		h.quitaProducto(quitar);
	}
	@Test 
	public void testAñadeProductoValido() {
		Producto p = new Producto("251483719020","Leche",100);
		Producto q = new Producto("111111111117","Galletas",150);
		Producto r = new Producto("111111111124","Patatas",80);
		Producto[] x = {p,q};
		Producto[] añadir = {r};
		Pack h = new Pack("Desayuno", x);
		h.añadeProducto(añadir);
		assertTrue(h.estaEnPack(p));
		assertTrue(h.estaEnPack(q));
		assertTrue(h.estaEnPack(r));	
	}
	@Test (expected = AssertionError.class)
	public void testAñadeProductoArrayVacioNoValido() {
		Producto p = new Producto("251483719020","Leche",100);
		Producto q = new Producto("111111111117","Galletas",150);
		Producto r = new Producto("111111111124","Patatas",80);
		Producto[] x = {p,q,r};
		Producto[] añadir = {};
		Pack h = new Pack("Desayuno", x);
		h.quitaProducto(añadir);	
	}
	@Test (expected = AssertionError.class)
	public void testAñadeProductoarrayConHuecosVaciosNoValido() {
		Producto p = new Producto("251483719020","Leche",100);
		Producto q = new Producto("111111111117","Galletas",150);
		Producto r = new Producto("111111111124","Patatas",80);
		Producto[] x = {p,q};
		Producto[] añadir = {r,null,r};
		Pack h = new Pack("Desayuno", x);
		h.quitaProducto(añadir);	
	}
	
}
