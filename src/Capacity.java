
public class Capacity extends Component { // represents a capacitor in the curcuit

    public Capacity(){// default constructor
         }
    public Capacity(double newFreq, double newValue){
        super(newFreq,newValue);
    }
    public void calculateImpedance(){
        double tempImpedance = (1/ (this.getFreq() * 2 * Math.PI * this.getValue()));
        this.setIm(1/ (this.getFreq() * 2 * Math.PI * this.getValue()));
    }
}