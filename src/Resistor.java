
public class Resistor extends Component implements ComponentImpedance { // represents a resistor in a curcuit

    public Resistor (){// default constructor
         }

    public Resistor (double newFreq, double newValue){
        super(newFreq, newValue);
    }
    public void calculateImpedance(){
        this.setRe((float)this.getValue());
    }
}