import org.junit.jupiter.api.Test;

class ParalellTest {

    @Test
    void calculateImpedance() {
    }

    @Test
    void testCalculateImpedance() {
        Circuit circ1 = new Circuit("Circ1");
        circ1.setIm(15.0);
        circ1.setRe(10.0);
        Circuit circ2 = new Circuit("Circ2");
        circ2.setIm(22.5);
        circ2.setRe(5.0);

        Paralell par = new Paralell(circ1, circ2);
        par.calculateImpedance();
        par.print();
    }
}