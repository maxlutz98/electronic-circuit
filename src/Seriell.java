public class Seriell extends Circuit{

    public Seriell(Circuit component1, Circuit component2) {
        super(component1, component2);
    }

    public Seriell(Circuit component1, Circuit component2, String formula) {
        super(component1, component2, formula);
    }

    public Seriell(String formula) {
        super(formula);
    }

    public Seriell(double re, double im, Circuit component1, Circuit component2, String formula) {
        super(re, im, component1, component2, formula);
    }

    public void calculateImpedance(Circuit part1, Circuit part2){
        Complex impedance = part1.plus(part2);
        this.setRe(impedance.getRe());
        this.setIm(impedance.getIm());
    }

    public void calculateImpedance(){
        Complex impedance = this.getComponent1().plus(this.getComponent2());
        this.setRe(impedance.getRe());
        this.setIm(impedance.getIm());
    }
}
