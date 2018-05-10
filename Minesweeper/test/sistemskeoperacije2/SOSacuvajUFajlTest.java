package sistemskeoperacije2;

import static org.junit.Assert.*;

import java.io.File;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import ranglista.RangLista;
import ranglista.Rezultat;
import tabla.SistemskiKontroler;

public class SOSacuvajUFajlTest {

	private RangLista rl;
	private Rezultat r;
	private Rezultat r2;
	private SistemskiKontroler sk;
	
	@Before
	public void setUp() throws Exception {
		sk = new SistemskiKontroler();
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

	@SuppressWarnings("deprecation")
	@Test
	public void testIzvrsi() {
		sk.dodajRezultatSortirano(r);
		sk.dodajRezultatSortirano(r2);
		SOSacuvajUFajl.izvrsi("data/nekiFajl.txt", rl);
		assertEquals(rl.vratiRangListu(), SOUcitajIzFajla.izvrsi("data/nekiFajl.txt").vratiRangListu());
	}

}
