package tabla;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import ranglista.RangLista;

public class SistemskiKontrolerTest {

	private SistemskiKontroler sk;

	@Before
	public void setUp() throws Exception {
		sk = new SistemskiKontroler();
	}

	@After
	public void tearDown() throws Exception {
		sk = null;
	}

	@Test
	public void testSetRangLista() {
		RangLista lista = new RangLista();
		sk.setRangLista(lista);
		assertEquals(lista, sk.getRangLista());
	}

	@Test
	public void testNovaTabla() {
		sk.novaTabla(5, 4, 10);
		assertEquals(5, sk.getTabla().getX());
		assertEquals(4, sk.getTabla().getY());
		assertEquals(10, sk.getTabla().brMina);
	}

	// ostale metode pozivaju sistemske operacije koje su posebno testirane
}
