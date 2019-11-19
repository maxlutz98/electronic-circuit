import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

class CircuitTest {

    @Test
    void getComponent1() {
        Circuit circ1 = new Circuit("Circ1");
        Circuit circ2 = new Circuit("Circ2");
        Circuit test = new Circuit(circ1, circ2, "Main");
        assertTrue(test.getComponent1() == circ1);
    }

    @Test
    void getComponent2() {
        Circuit circ1 = new Circuit("Circ1");
        Circuit circ2 = new Circuit("Circ2");
        Circuit test = new Circuit(circ1, circ2, "Main");
        assertTrue(test.getComponent2() == circ2);
    }

    @Test
    void setComponent1() {
        Circuit circ1 = new Circuit("Circ1");
        Circuit test = new Circuit("Main");
        test.setComponent1(circ1);
        assertTrue(test.getComponent1() == circ1);
    }

    @Test
    void setComponent2() {
    }

    @Test
    void getFormula() {
    }

    @Test
    void setFormula() {
    }

    @Test
    void calculateImpedance() {
    }

    @Test
    void testCalculateImpedance() {
    }

    @Test
    void testCalculateImpedance1() {
    }
}