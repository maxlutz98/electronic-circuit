public class Paralell extends Circuit {

    public void calculateImpedance(Circuit part1, Circuit part2){
        Complex additivity1 = part1.inv();
        Complex additivity2 = part2.inv();
        additivity1 =  additivity2.plus(additivity1);
        additivity1 = additivity1.inv();
        this.setIm(additivity1.getIm());
        this.setRe(additivity1.getRe());
    }

    public void calculateImpedance(){
        Complex additivity1 = this.getComponent1().inv();
        Complex additivity2 = this.getComponent2().inv();
        additivity1 =  additivity2.plus(additivity1);
        additivity1 = additivity1.inv();
        this.setIm(additivity1.getIm());
        this.setRe(additivity1.getRe());
    }
}
