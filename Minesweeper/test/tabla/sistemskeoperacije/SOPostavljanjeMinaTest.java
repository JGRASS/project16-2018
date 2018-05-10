package tabla.sistemskeoperacije;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import tabla.Tabla;

public class SOPostavljanjeMinaTest {

	private Tabla t;

	@Before
	public void setUp() throws Exception {
		t = new Tabla(3, 3, 4);
	}

	@Test
	public void testIzvrsi() {
		SOPostavljanjeMina.izvrsi(t, 1, 2);
		assertFalse(t.polja[1][2].isMina());

		int brMina = 0;
		for (int x = 0; x < t.getX(); x++)
			for (int y = 0; y < t.getY(); y++)
				if (t.polja[x][y].isMina())
					brMina++;

		assertEquals(4, brMina);
	}
}
