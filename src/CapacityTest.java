import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CapacityTest extends Capacity {

    @Test
    void testCalculateImpedance() {
        Capacity testObject = new Capacity(20000,0.0001);

        testObject.calculateImpedance();
        assertEquals((int) (testObject.getIm() * 100000), -7957);
        //multiplied with 100000 and casted to int to make shure that the result is right within the first 5 decimal places
    }
}