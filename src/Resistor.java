
public class Resistor extends Component implements ComponentImpedance { // represents a resistor in a curcuit

    public Resistor (){// default constructor
         }

    public void calculateImpedance(){
        this.setRe(this.getValue());
    }
}