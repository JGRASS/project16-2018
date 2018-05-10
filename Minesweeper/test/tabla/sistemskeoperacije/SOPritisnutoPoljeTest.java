package tabla.sistemskeoperacije;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import tabla.Tabla;

public class SOPritisnutoPoljeTest {

	private Tabla t;

	@Before
	public void setUp() throws Exception {
		t = new Tabla(3, 3, 2);
	}

	@After
	public void tearDown() throws Exception {
		t = null;
	}

	@Test
	public void testIzvrsiLose() {
		t.polja[1][1].setMina(true);
		assertEquals(1, SOPritisnutoPolje.izvrsi(1, 1, t));
	}

	@Test
	public void testIzvrsiNormal() {
		t.polja[0][0].setMina(true);
		t.polja[0][1].setMina(true);
		SOOznacavanjePolja.izvrsi(3, 3, t.polja);

		assertEquals(0, SOPritisnutoPolje.izvrsi(2, 2, t));
		assertEquals(6, t.brOtvorenih);
	}

	@Test
	public void testIzvrsiWin() {
		t.polja[0][0].setMina(true);
		t.polja[0][1].setMina(true);
		SOOznacavanjePolja.izvrsi(3, 3, t.polja);

		assertEquals(0, SOPritisnutoPolje.izvrsi(2, 2, t));
		assertEquals(2, SOPritisnutoPolje.izvrsi(0, 2, t));
	}

}
