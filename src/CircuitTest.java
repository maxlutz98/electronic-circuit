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
    }

    @Test
    void setComponent1() {
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