import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SeriellTest {

    @Test
    void calculateImpedance() {
        // method for testing the calculateImpedance method with two circuit objects as parameter
        Circuit circ1 = new Circuit("Circ1");
        circ1.setIm(15.0);
        circ1.setRe(10.0);
        Circuit circ2 = new Circuit("Circ2");
        circ2.setIm(22.5);
        circ2.setRe(5.0);

        Seriell ser = new Seriell("Test");
        ser.calculateImpedance(circ1, circ2);
        assertEquals(ser.getRe(), 15.0);
        assertEquals(ser.getIm(), 37.5);
    }

    @Test
    void testCalculateImpedance() {
        // method for testing the calculateImpedance method with no parameter
        Circuit circ1 = new Circuit("Circ1");
        circ1.setIm(15.0);
        circ1.setRe(10.0);
        Circuit circ2 = new Circuit("Circ2");
        circ2.setIm(22.5);
        circ2.setRe(5.0);

        Seriell ser = new Seriell(circ1, circ2);
        ser.calculateImpedance();
        assertEquals(ser.getRe(), 15.0);
        assertEquals(ser.getIm(), 37.5);
    }
}