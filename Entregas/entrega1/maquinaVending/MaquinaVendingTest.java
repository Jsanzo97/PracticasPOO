package entrega1.maquinaVending;

import static org.junit.Assert.*;
import org.junit.Test;
import fabricante.externo.tarjetas.TarjetaMonedero;
import entrega1.producto.Producto;
/**
 * Test de MaquinaVending
 * @author Jaimarq
 * @author Jorgsan
 */
public class MaquinaVendingTest {
	
	@Test
	public void testMaquinaValido() {
		MaquinaVending m = new MaquinaVending(1,1);
		assertEquals(m.getLineas(),1);
		assertEquals(m.getCantidadMaxima(),1);
		assertNotNull(m);							//TEST VALORES LIMITE EN LOS INTERVALOS
	}
	@Test (expected = AssertionError.class)
	public void testMaquinaLineasNoValidas() {
		MaquinaVending m = new MaquinaVending(0,1);
		assertNotNull(m);
	}
	@Test (expected = AssertionError.class)
	public void testMaquinaLineasCantidadMaximaNoValida() {
		MaquinaVending m = new MaquinaVending(1,0);
		assertNotNull(m);
	}
	@Test 
	public void testNewProductoValido() {
		MaquinaVending m = new MaquinaVending(2,5);
		assertNotNull(m);
		m.newVendible(1,1,"251483719020","Agua",60);
		assertEquals(m.consultaPrecio(1), 0.6, 0.01);
		assertEquals(m.getCantidadRestante(1), 1);
	}/*He creado este test que inicializo una máquina creo un array de productos y 
	lo añado a la fila uno. Creo que estaría bien pero no estoy seguro.
	He tenido que importar Producto
	
	@Test 
	public void testNewProductoValidoPack() {
		MaquinaVending m = new MaquinaVending(2,5);
		assertNotNull(m);
		Producto p = new Producto("251483719020","Agua",100);
		Producto v = new Producto("251483719020","Agua",100);
		Producto x [] = {p,v};
		m.newVendible(1,2,"Agua 2*1.6", x);
		assertEquals(m.consultaPrecio(1), 1.6, 0.01);
		assertEquals(m.getCantidadRestante(1), 2);
	}*/
	@Test (expected = AssertionError.class)
	public void testNewProductoPrecioNoValido() {
		MaquinaVending m = new MaquinaVending(1,1);
		assertNotNull(m);
		m.newVendible(1,1,"251483719020","Agua",-1);
	}
	@Test (expected = AssertionError.class)
	public void testNewProductoLineaYaOcupada() {
		MaquinaVending m = new MaquinaVending(1,5);
		assertNotNull(m);
		m.newVendible(1,1,"251483719020","Agua",1);
		m.newVendible(1,1,"251483719020","Agua",1);
	}
	@Test (expected = AssertionError.class)
	public void testNewProductoLineaFueraDeRangoSuperior() {
		MaquinaVending m = new MaquinaVending(1,1);
		assertNotNull(m);
		m.newVendible(5,1,"251483719020","Agua",1);
	}
	@Test (expected = AssertionError.class)
	public void testNewProductoLineaFueraDeRangoInferior() {
		MaquinaVending m = new MaquinaVending(1,1);
		assertNotNull(m);
		m.newVendible(0,1,"251483719020","Agua",1);
	}
	@Test (expected = AssertionError.class)
	public void testNewProductoCantidadSuperiorALaPermitida() {
		MaquinaVending m = new MaquinaVending(1,1);
		assertNotNull(m);
		m.newVendible(1,5,"251483719020","Agua",1);
	}
	@Test 
	public void testRecargaValida() {
		MaquinaVending m = new MaquinaVending(1,5);
		assertNotNull(m);
		m.newVendible(1,1,"251483719020","Agua",1);
		assertEquals(m.getCantidadRestante(1),1);
		m.recarga(1,3);
		assertEquals(m.getCantidadRestante(1),4);
	}
	@Test (expected = AssertionError.class)
	public void testRecargaSobrepasandoElMaximo() {
		MaquinaVending m = new MaquinaVending(1,5);
		assertNotNull(m);
		m.newVendible(1,1,"251483719020","Agua",1);
		m.recarga(1,8);
	}
	@Test (expected = AssertionError.class)
	public void testRecargaLineaVacia() {
		MaquinaVending m = new MaquinaVending(1,5);
		assertNotNull(m);
		m.recarga(1,1);
	}
	@Test (expected = AssertionError.class)
	public void testRecargaCantidadNoValida() {
		MaquinaVending m = new MaquinaVending(1,5);
		assertNotNull(m);
		m.recarga(1,0);
	}
	@Test 
	public void testCompraValida() {
		MaquinaVending m = new MaquinaVending(1,5);
		assertNotNull(m);
		m.newVendible(1,1,"251483719020","Agua",60);
		assertEquals(m.getCantidadRestante(1),1);
		TarjetaMonedero tarjeta = new TarjetaMonedero("A156Bv09_1zXo894",60);
		double saldoInicial = tarjeta.getSaldoActual();
		double precio = m.consultaPrecio(1);
		m.compra(1, tarjeta);
		assertEquals(saldoInicial - precio, tarjeta.getSaldoActual(), 0.01);
	}
	@Test (expected = AssertionError.class)
	public void testCompraLineaNoPermitida() {
		MaquinaVending m = new MaquinaVending(2,5);
		assertNotNull(m);
		m.newVendible(1,1,"251483719020","Agua",60);
		TarjetaMonedero tarjeta = new TarjetaMonedero("A156Bv09_1zXo894",60);
		m.compra(0, tarjeta);
	}
	@Test (expected = AssertionError.class)
	public void testCompraLineaFueraDeMaquina() {
		MaquinaVending m = new MaquinaVending(1,5);
		assertNotNull(m);
		m.newVendible(1,1,"251483719020","Agua",60);
		TarjetaMonedero tarjeta = new TarjetaMonedero("A156Bv09_1zXo894",60);
		m.compra(2, tarjeta);
	}
	@Test (expected = AssertionError.class)
	public void testCompraLineaValidaVacia() {
		MaquinaVending m = new MaquinaVending(2,5);
		assertNotNull(m);
		TarjetaMonedero tarjeta = new TarjetaMonedero("A156Bv09_1zXo894",60);
		m.compra(1, tarjeta);
	}
	@Test (expected = AssertionError.class)
	public void testCompraSaldoInsuficiente() {
		MaquinaVending m = new MaquinaVending(2,5);
		assertNotNull(m);
		m.newVendible(1,1,"251483719020","Agua",60);
		TarjetaMonedero tarjeta = new TarjetaMonedero("A156Bv09_1zXo894",0.50);
		m.compra(1, tarjeta);
	}
	@Test (expected = AssertionError.class)
	public void testCompraProductoAgotado() {
		MaquinaVending m = new MaquinaVending(1,5);
		assertNotNull(m);
		m.newVendible(1,2,"251483719020","Agua",60);
		TarjetaMonedero tarjeta = new TarjetaMonedero("A156Bv09_1zXo894",60);
		m.compra(1, tarjeta);
		m.compra(1, tarjeta);
		m.compra(1, tarjeta);
	
	}
	@Test 
	public void testConsultaPrecioValido() {
		MaquinaVending m = new MaquinaVending(1,5);
		assertNotNull(m);
		m.newVendible(1,1,"251483719020","Agua",60);
		assertEquals(m.consultaPrecio(1), 0.6, 0.001);
	}
	@Test (expected = AssertionError.class)
	public void testConsultaPrecioLineaNoPermitida() {
		MaquinaVending m = new MaquinaVending(1,5);
		assertNotNull(m);
		m.newVendible(1,1,"251483719020","Agua",60);
		m.consultaPrecio(0);
	}
	@Test (expected = AssertionError.class)
	public void testConsultaPrecioLineaFueraDeMaquina() {
		MaquinaVending m = new MaquinaVending(1,5);
		assertNotNull(m);
		m.newVendible(1,1,"251483719020","Agua",60);
		m.consultaPrecio(2);
	}
	@Test (expected = AssertionError.class)
	public void testConsultaPrecioLineaVacia() {
		MaquinaVending m = new MaquinaVending(2,5);
		assertNotNull(m);
		m.newVendible(1,1,"251483719020","Agua",60);
		m.consultaPrecio(2);
	}
	@Test 
	public void testGetCantidadRestanteValida() {
		MaquinaVending m = new MaquinaVending(2,5);
		assertNotNull(m);
		m.newVendible(1,3,"251483719020","Agua",60);
		assertEquals(m.getCantidadRestante(1),3);
		TarjetaMonedero tarjeta = new TarjetaMonedero("A156Bv09_1zXo894",60);
		m.compra(1, tarjeta);
		assertEquals(m.getCantidadRestante(1),2);
	}
	@Test (expected = AssertionError.class)
	public void testGetCantidadRestanteLineaNoValida() {
		MaquinaVending m = new MaquinaVending(1,5);
		assertNotNull(m);
		m.newVendible(1,4,"251483719020","Agua",60);
		m.getCantidadRestante(0);	
	}
	@Test (expected = AssertionError.class)
	public void testGetCantidadRestanteLineaNoFueraDeMaquina() {
		MaquinaVending m = new MaquinaVending(1,5);
		assertNotNull(m);
		m.newVendible(1,4,"251483719020","Agua",60);
		m.getCantidadRestante(2);	
	}
	@Test 
	public void testVaciaLineaValido() {
		MaquinaVending m = new MaquinaVending(1,5);
		assertNotNull(m);
		m.newVendible(1,4,"251483719020","Agua",60);
		m.vaciaLinea(1,2);	
		assertEquals(m.getCantidadRestante(1),2);
	}
	@Test (expected = AssertionError.class)
	public void testVaciaLineaNoValida() {
		MaquinaVending m = new MaquinaVending(1,5);
		assertNotNull(m);
		m.vaciaLinea(0,1);	
	}
	@Test (expected = AssertionError.class)
	public void testVaciaLineaFueraDeLaMaquina() {
		MaquinaVending m = new MaquinaVending(1,5);
		assertNotNull(m);
		m.vaciaLinea(2,1);	
	}
	@Test (expected = AssertionError.class)
	public void testVaciaLineaYaVacia() {
		MaquinaVending m = new MaquinaVending(1,5);
		assertNotNull(m);
		m.newVendible(1,4,"251483719020","Agua",60);
		m.vaciaLinea(1,4);
		assertEquals(m.getCantidadRestante(1),0);
		m.vaciaLinea(1,1);
	}
	@Test (expected = AssertionError.class)
	public void testVaciaLineaMasDelProducto() {
		MaquinaVending m = new MaquinaVending(1,5);
		assertNotNull(m);
		m.newVendible(1,4,"251483719020","Agua",60);
		m.vaciaLinea(1,5);
	}
	@Test (expected = AssertionError.class)
	public void testVaciaLineaCantidadCero() {
		MaquinaVending m = new MaquinaVending(1,5);
		assertNotNull(m);
		m.newVendible(1,4,"251483719020","Agua",60);
		m.vaciaLinea(1,0);
	}
	@Test (expected = AssertionError.class)
	public void testVaciaLineaCantidadNegativa() {
		MaquinaVending m = new MaquinaVending(1,5);
		assertNotNull(m);
		m.newVendible(1,4,"251483719020","Agua",60);
		m.vaciaLinea(1,-1);
	}
	@Test
	public void testVaciaLineaDosVeces() {
		MaquinaVending m = new MaquinaVending(1,5);
		assertNotNull(m);
		m.newVendible(1,4,"251483719020","Agua",60);
		m.vaciaLinea(1,2);
		assertEquals(m.getCantidadRestante(1),2);
		m.vaciaLinea(1,2);
		assertEquals(m.getCantidadRestante(1),0);
	}
	
	@Test 
	public void testToString() {
		MaquinaVending m = new MaquinaVending(2,5);
		assertNotNull(m);
		m.newVendible(1,4,"251483719020","Agua",60);
		assertEquals(m.consultaProducto(1), "Agua. 0.6 €");
		
	}
	@Test (expected = AssertionError.class)
	public void testToStringLineaNoValida() {
		MaquinaVending m = new MaquinaVending(1,5);
		assertNotNull(m);
		m.consultaPrecio(0);
	}
	@Test (expected = AssertionError.class)
	public void testToStringLineaVacia() {
		MaquinaVending m = new MaquinaVending(2,5);
		assertNotNull(m);
		m.newVendible(1, 1, "251483719020","Agua",60);
		m.consultaPrecio(2);
	}
	@Test (expected = AssertionError.class)
	public void testToStringLineaFueraDeMaquina() {
		MaquinaVending m = new MaquinaVending(1,5);
		assertNotNull(m);
		m.consultaPrecio(2);
	}

}

