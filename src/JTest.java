import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class JTest {

	@Test
	void test() {
		J a = new J(4, 5);
		J b = new J(4, 5);
		
		a.print();
		b.print();
		
		assertTrue(a.equals(b));
		a.j(3);
		a.print();
		assertFalse(a.equals(b));
		assertTrue(a.plus(b).equals(new J(8, 8)));
		assertTrue(a.minus(b).equals(new J(0, -2)));
		assertTrue(a.mult(b).equals(new J(1, 32)));
		b.r(11);
		b.j(2);
		b.print();
		assertTrue(b.div(a).equals(new J(2, -1)));
		assertTrue(a.conj().equals(new J(4, -3)));
	}

}
