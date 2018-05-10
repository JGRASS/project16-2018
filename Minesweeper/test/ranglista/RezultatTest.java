package ranglista;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class RezultatTest {

	private Rezultat r;

	@Before
	public void setUp() throws Exception {
		r = new Rezultat();
	}

	@After
	public void tearDown() throws Exception {
		r = null;
	}

	@Test
	public void testSetIme() {
		r.setIme("Vanja");
		assertEquals("Vanja", r.getIme());
	}

	@Test(expected = java.lang.RuntimeException.class)
	public void testSetImeNull() {
		r.setIme(null);
	}

	@Test(expected = java.lang.RuntimeException.class)
	public void testSetImePrazanString() {
		r.setIme("");
	}

	@Test
	public void testSetPrezime() {
		r.setPrezime("Vlahovic");
		assertEquals("Vlahovic", r.getPrezime());
	}

	@Test(expected = java.lang.RuntimeException.class)
	public void testSetPrezimeNull() {
		r.setPrezime(null);
	}

	@Test(expected = java.lang.RuntimeException.class)
	public void testSetPrezimePrazanString() {
		r.setPrezime("");
	}

	@Test
	public void testToString() {
		r.setVreme(1);
		r.setTipIgre("Beginner");
		r.setIme("Marina");
		r.setPrezime("Obradovic");

		assertEquals("            1        Beginner      Marina      Obradovic", r.toString());
	}

}
