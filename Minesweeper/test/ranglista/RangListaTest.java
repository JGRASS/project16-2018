package ranglista;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import sistemskeoperacije2.SOPrikazListe;

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
		rl.dodajRezultatSortirano(r);
		assertEquals(1, rl.brRezultata);
		assertEquals(r, rl.vratiRangListu()[0]);
	}

	@Test
	public void testVratiRangListuPrazna() {
		assertEquals(0, rl.brRezultata);
	}

	@Test(expected = java.lang.RuntimeException.class)
	public void testDodajRezultatSortiranoNull() {
		rl.dodajRezultatSortirano(null);
	}

	@Test
	public void testDodajRezultatSortirano() {
		rl.dodajRezultatSortirano(r);
		rl.dodajRezultatSortirano(r2);
		assertEquals(r, rl.vratiRangListu()[1]);
		assertEquals(r2, rl.vratiRangListu()[0]);
		assertEquals(2, rl.brRezultata);
	}

	@Test
	public void testPrikaziListu() {
		rl.dodajRezultatSortirano(r);
		assertEquals(
				"Mesto:  Vreme:   Tip igre:       Ime:          Prezime:\n1.              20        Expert      Milos      Brkic",
				rl.prikaziListu());
	}

	@Test
	public void testPrikaziListuPrazna() {
		assertEquals("Mesto:  Vreme:   Tip igre:       Ime:          Prezime:\n", rl.prikaziListu());
	}

}
