import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ResistorTest {

    @Test
    void calculateImpedance() {
        Resistor res = new Resistor(100, 100000);
        res.calculateImpedance();
        assertEquals(res.getRe(), 100000);
        assertEquals(res.getIm(), 0);
    }
}