import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class InductivityTest extends Inductivity {

    @Test
    void testCalculateImpedance() {
        Inductivity testObject = new Inductivity(20000,0.0001);

        testObject.calculateImpedance();
        assertEquals((int)(testObject.getIm() * 100000),(int)(20000* 0.0001 * Math.PI * 2 * 100000));
        //multiplied with 100000 and casted to int to make shure that the result is right within the first 5 decimal places
    }

    @Override // neccesary because of the interface implemented in Inductivity
    public void calculateImpedance() {
    }
}