package sistemskeoperacije2;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import ranglista.RangLista;
import ranglista.Rezultat;

public class SOPrikazListeTest {
	
	private RangLista rl;
	private Rezultat r;
	private Rezultat r2;

	@Before
	public void setUp() throws Exception {
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

	@After
	public void tearDown() throws Exception {
		rl = null;
		r = null;
		r2 = null;
	}

	@Test
	public void testIzvrsi() {
		SODodajRezultat.izvrsi(r, rl);
		assertEquals(
				"Mesto:  Vreme:   Tip igre:       Ime:          Prezime:\n1.              20        Expert      Milos      Brkic",
				SOPrikazListe.izvrsi(rl.vratiRangListu(), rl.brRezultata));
	}
	
	@Test
	public void testIzvrsiPrazna() {
		assertEquals("Mesto:  Vreme:   Tip igre:       Ime:          Prezime:\n", SOPrikazListe.izvrsi(rl.vratiRangListu(), rl.brRezultata));
	}

}
