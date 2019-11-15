
public class Inductivity extends Component{ // represents a in a curcuit

    public Inductivity(){//default constructor
    }
    public Inductivity(double newFreq, double newValue){
        super(newFreq,newValue);
    }

    public void calculateImpedance(){
        float temp_Impedance = (float) ((this.getFreq() * 2 * Math.PI) * this.getValue());
        this.setIm(temp_Impedance);
    }
}