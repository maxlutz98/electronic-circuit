import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class ComplexTest {

	@Test
	void test() {
		Complex a = new Complex(4, 5);
		Complex b = new Complex(4, 5);
		
		a.print();
		b.print();
		
		assertTrue(a.equals(b));
		a.setIm(3);
		a.print();
		assertFalse(a.equals(b));
		assertTrue(a.plus(b).equals(new Complex(8, 8)));
		assertTrue(a.minus(b).equals(new Complex(0, -2)));
		assertTrue(a.mult(b).equals(new Complex(1, 32)));
		b.setRe(11);
		b.setIm(2);
		b.print();
		assertTrue(b.div(a).equals(new Complex(2, -1)));
		assertTrue(a.conj().equals(new Complex(4, -3)));
		assertEquals(a.mod(), 5);
		a.setRe(3);
		assertEquals(a.arg(), (float)Math.PI / 4);
		a.setRe(-3);
		assertEquals(a.arg(), (float)Math.PI / 4 * 3);
		a.setIm(-3);
		assertEquals(a.arg(), (float)Math.PI / 4 * -3);
		a.setRe(0);
		assertEquals(a.arg(), (float)Math.PI / -2);
		a.setIm(3);
		assertEquals(a.arg(), (float)Math.PI / 2);
	}

}
