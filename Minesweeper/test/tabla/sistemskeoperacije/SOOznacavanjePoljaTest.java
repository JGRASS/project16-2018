package tabla.sistemskeoperacije;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import tabla.Tabla;

public class SOOznacavanjePoljaTest {

	private Tabla t;

	@Before
	public void setUp() throws Exception {
		t = new Tabla(3, 3, 2);
		t.polja[0][0].setMina(true);
		t.polja[0][1].setMina(true);
	}

	@Test
	public void testIzvrsi() {
		SOOznacavanjePolja.izvrsi(3, 3, t.polja);
		assertEquals(1, t.polja[0][2].getbrMinaOkolo());
		assertEquals(1, t.polja[1][2].getbrMinaOkolo());
		assertEquals(2, t.polja[1][1].getbrMinaOkolo());
		assertEquals(2, t.polja[1][0].getbrMinaOkolo());
		assertEquals(0, t.polja[2][2].getbrMinaOkolo());
	}

}
