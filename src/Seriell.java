public class Seriell extends Circuit{

    public void calculateImpedance(Component part1, Component part2){
        Complex impedance = part1.plus(part2);
        this.setRe(impedance.getRe());
        this.setIm(impedance.getIm());
    };
    public void calculateImpedance(Circuit part1, Circuit part2){
        Complex impedance = part1.plus(part2);
        this.setRe(impedance.getRe());
        this.setIm(impedance.getIm());
    };
    public void calculateImpedance(){
        Complex impedance = this.getComponent1().plus(this.getComponent2());
        this.setRe(impedance.getRe());
        this.setIm(impedance.getIm());
    };
}
