public interface CircuitImpedance {

    void calculateImpedance(Component part1);

    void calculateImpedance(Circuit part1, Circuit part2);

    void calculateImpedance();

}
