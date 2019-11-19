import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CircuitTest {

    @Test
    void getComponent1() {
        Circuit circ1 = new Circuit("Circ1");
        Circuit circ2 = new Circuit("Circ2");
        Circuit test = new Circuit(circ1, circ2, "Main");
        assertEquals(test.getComponent1(), circ1);
    }

    @Test
    void getComponent2() {
        Circuit circ1 = new Circuit("Circ1");
        Circuit circ2 = new Circuit("Circ2");
        Circuit test = new Circuit(circ1, circ2, "Main");
        assertEquals(test.getComponent2(), circ2);
    }

    @Test
    void setComponent1() {
        Circuit circ1 = new Circuit("Circ1");
        Circuit test = new Circuit("Main");
        test.setComponent1(circ1);
        assertEquals(test.getComponent1(), circ1);
    }

    @Test
    void setComponent2() {
        Circuit circ2 = new Circuit("Circ2");
        Circuit test = new Circuit("Main");
        test.setComponent2(circ2);
        assertEquals(test.getComponent2(), circ2);
    }

    @Test
    void getFormula() {
        Circuit circ = new Circuit("Circ1");
        assertEquals(circ.getFormula(), "Circ1");
    }

    @Test
    void setFormula() {
        Circuit circ = new Circuit("Circ1");
        circ.setFormula("Test");
        assertEquals(circ.getFormula(), "Test");
    }

    @Test
    void calculateImpedance() {
        Resistor res = new Resistor(100, 1000);
        res.calculateImpedance();
        Circuit circ = new Circuit("Resistor");
        circ.calculateImpedance(res);
        assertEquals(circ.getRe(), 1000.0);
    }

}