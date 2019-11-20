import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ParalellTest {

    @Test
    void calculateImpedance() {
        // method for testing the calculateImpedance method with two circuit objects as parameter
        Circuit circ1 = new Circuit("Circ1");
        circ1.setIm(15.0);
        circ1.setRe(10.0);
        Circuit circ2 = new Circuit("Circ2");
        circ2.setIm(22.5);
        circ2.setRe(5.0);

        Paralell par = new Paralell("Test");
        par.calculateImpedance(circ1, circ2);
        assertEquals(par.getRe(), 4.25287356321839);
        assertEquals(par.getIm(), 9.36781609195402);
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

        Paralell par = new Paralell(circ1, circ2);
        par.calculateImpedance();
        assertEquals(par.getRe(), 4.25287356321839);
        assertEquals(par.getIm(), 9.36781609195402);
    }
}