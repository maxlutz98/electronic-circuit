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
	}

}
