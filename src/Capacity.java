
public class Capacity extends Component { // represents a capacitor in the curcuit

    public Capacity(){// default constructor
         }

    public void calculateImpedance(){
        float tempImpedance = (float) (1/ ((this.getFreq() * 2 * Math.PI) * this.getValue()));
        this.setRe(tempImpedance);
    }
}