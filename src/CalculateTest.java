import org.junit.jupiter.api.Test;

import java.util.ArrayList;

class CalculateTest {

    @Test
    void testCalculate() {
        ArrayList<Double> parameter1 = new ArrayList<Double>();
        ArrayList<Double> parameter2 = new ArrayList<Double>();
        ArrayList<Double> parameter3 = new ArrayList<Double>();

        parameter1.add(10.2);
        parameter1.add(329.2);

        parameter2.add(25.10);

        parameter3.add(0.25);
        parameter3.add(5.20);

        Calculate calc = new Calculate(100.5, parameter1, parameter2, parameter3);
        Circuit result = calc.calculate("(R1+L1)+C1");
        result.print();
    }

}