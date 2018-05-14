package sistemskeoperacije2;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import ranglista.RangLista;
import ranglista.Rezultat;

public class SODodajRezultatTest {
	
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
			r2 = null;
		}
		
		@Test
		public void testIzvrsi() {
			SODodajRezultat.izvrsi(r, rl);
			SODodajRezultat.izvrsi(r2, rl);
			assertEquals(r2,rl.vratiRangListu()[0]);
			assertEquals(r,rl.vratiRangListu()[1]);
			assertEquals(2,rl.brRezultata);
		}
		
		@Test(expected = java.lang.RuntimeException.class)
		public void testIzvrsiNull() {
			SODodajRezultat.izvrsi(null, rl);
		}
		
		@Test(expected = java.lang.RuntimeException.class)
		public void testIzvrsiFull() {
			for(int i=0;i<101;i++)
				SODodajRezultat.izvrsi(r, rl);
		}


}
