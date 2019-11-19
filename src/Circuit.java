
public class Circuit extends Complex implements CircuitImpedance {

    private Circuit component1;
    private Circuit component2;
    private String formula;

    public Circuit() {//default constructor
    }

    public Circuit(Circuit component1, Circuit component2) {
        this.component1 = component1;
        this.component2 = component2;
    }

    public Circuit(Circuit component1, Circuit component2, String formula) {
        this.component1 = component1;
        this.component2 = component2;
        this.formula = formula;
    }

    public Circuit(String formula) {
        this.formula = formula;
    }

    public Circuit(double re, double im, Circuit component1, Circuit component2, String formula) {
        super(re, im);
        this.component1 = component1;
        this.component2 = component2;
        this.formula = formula;
    }

    public Circuit getComponent1() {
        return this.component1;
    }

    public Circuit getComponent2() {
        return this.component2;
    }

    public void setComponent1(Circuit component1) {
        this.component1 = component1;
    }

    public void setComponent2(Circuit component2) {
        this.component2 = component2;
    }

    public String getFormula() {
        return formula;
    }

    public void setFormula(String formula) {
        this.formula = formula;
    }

    @Override
    public void calculateImpedance(Component part1) {
        this.setRe(part1.getRe());
        this.setIm(part1.getIm());
    }

    @Override
    public void calculateImpedance(Circuit part1, Circuit part2) {

    }

    @Override
    public void calculateImpedance() {

    }
}
