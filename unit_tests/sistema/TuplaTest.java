package sistema;

/**
 * @author wesley
 *
 */
import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class TuplaTest {
	private Tupla t1;

	@Before
	public void setUp() throws Exception {
		t1 = new Tupla(0, 1);
	}

	@Test
	public void testTupla() {
		Tupla  t2 = new Tupla(0, 1);
		
		assertEquals(t2.getX(), t1.getX());
		assertEquals(t2.getY(), t1.getY());
	}

	@Test
	public void testGetX() {
		assertEquals(0, t1.getX());
	}

	@Test
	public void testGetY() {
		assertEquals(1, t1.getY());
	}

	@Test
	public void testAddX() {
		t1.addX(1);
		assertEquals(1, t1.getX());
	}

	@Test
	public void testAddY() {
		t1.addY(1);
		assertEquals(2, t1.getY());
	}

}
