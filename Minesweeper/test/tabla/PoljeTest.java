package tabla;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class PoljeTest {

	private Polje p;
	
	@Before
	public void setUp() throws Exception {
		p = new Polje();
	}

	@After
	public void tearDown() throws Exception {
		p = null;
	}

	@Test
	public void testSetOtvorenoTrue() {
		p.setOtvoreno(true);
		assertTrue(p.isOtvoreno());
	}
	
	@Test
	public void testSetOtvorenoFalse() {
		p.setOtvoreno(false);
		assertFalse(p.isOtvoreno());
	}

	@Test
	public void testSetMinaTrue() {
		p.setMina(true);
		assertTrue(p.isMina());
	}
	
	@Test
	public void testSetMinaFalse() {
		p.setMina(false);
		assertFalse(p.isMina());
	}


	@Test
	public void testSetbrMinaOkoloNormal() {
		p.setbrMinaOkolo(5);
		assertEquals(5,p.getbrMinaOkolo());
	}
	
	@Test (expected = java.lang.RuntimeException.class)
	public void testSetbrMinaOkoloWrong() {
		p.setbrMinaOkolo(10);
	}

}
