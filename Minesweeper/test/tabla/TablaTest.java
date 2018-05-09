package tabla;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class TablaTest {

	private Tabla t;

	@Test
	void testTabla() {
		t = new Tabla(8,7,10);
		assertEquals(8,t.getX());
		assertEquals(7,t.getY());
		assertEquals(10,t.brMina);
		assertEquals(0,t.brOtvorenih);
		assertEquals(46,t.brPreostalih);
	}

}
