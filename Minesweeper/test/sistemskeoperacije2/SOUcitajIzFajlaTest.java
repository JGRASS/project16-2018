package sistemskeoperacije2;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import ranglista.RangLista;
import ranglista.Rezultat;
import tabla.SistemskiKontroler;

public class SOUcitajIzFajlaTest {
	private Rezultat r;
	private Rezultat r2;
	private RangLista rl;
	private SistemskiKontroler sk;
	@Before
	public void setUp() throws Exception {
		rl= new RangLista();
		sk = new SistemskiKontroler();
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

	@Test
	public void testIzvrsi() {
		sk.dodajRezultatSortirano(r);
		sk.dodajRezultatSortirano(r2);
		SOSacuvajUFajl.izvrsi("data/nekiFajl.txt", rl);
		assertArrayEquals(SOUcitajIzFajla.izvrsi("data/nekiFajl.txt").vratiRangListu(), rl.vratiRangListu());
	}

}
