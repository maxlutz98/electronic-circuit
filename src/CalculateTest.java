import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CalculateTest {

    @Test
    void calculate() {
        ArrayList<Double> parameter1 = new ArrayList<Double>();
        ArrayList<Double> parameter2 = new ArrayList<Double>();
        ArrayList<Double> parameter3 = new ArrayList<Double>();

        parameter1.add(10.2);
        parameter1.add(329.2);
        parameter1.add(100.0);

        parameter2.add(25.10);

        parameter3.add(0.25);
        parameter3.add(5.20);

        Calculate calc = new Calculate(100.5, parameter1, parameter2, parameter3);
        Circuit result = calc.calculate("(R1+L1)||C1");
        assertEquals(result.getRe(), 1.622482464960298E-12);
        assertEquals(result.getIm(), -6.309290457508656E-5);

        result = calc.calculate("R1||C1||L1");
        assertEquals(result.getRe(), 3.902661465916038E-10);
        assertEquals(result.getIm(), -6.309290467750467E-5);
    }
}