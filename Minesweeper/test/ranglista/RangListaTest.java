package ranglista;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import sistemskeoperacije2.SODodajRezultat;

public class RangListaTest {
	private RangLista rl;
	private Rezultat r;
	private Rezultat r2;

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void SetUp() throws Exception {
		rl = new RangLista();
		r = new Rezultat();
		r.setVreme(20);
		r.setTipIgre("Expert");
		r.setIme("Milos");
		r.setPrezime("Brkic");
		r2 = new Rezultat();
		r2.setVreme(19);
		r2.setTipIgre("Expert");
		r2.setIme("Vanja");
		r2.setPrezime("Vlahovic");
	}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
		rl = null;
		r = null;
	}

	@Test
	public void testVratiRangListu() {
		SODodajRezultat.izvrsi(r, rl);
		assertEquals(1, rl.brRezultata);
		assertEquals(r, rl.vratiRangListu()[0]);
	}

	@Test
	public void testVratiRangListuPrazna() {
		assertEquals(0, rl.brRezultata);
	}


}
