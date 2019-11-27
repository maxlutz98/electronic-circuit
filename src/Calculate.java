import java.util.ArrayList;

public class Calculate {
    private Double frequency;               // frequency of the circuit
    private ArrayList<Double> resistors;    // list of resistor values
    private ArrayList<Double> capacities;   // list of capacity values
    private ArrayList<Double> inductance;   // list of inductance values

    public Calculate(Double frequency, ArrayList resistors, ArrayList capacities, ArrayList inductance) {
        this.frequency = frequency;
        this.resistors = resistors;
        this.capacities = capacities;
        this.inductance = inductance;
    }

    public Circuit calculate(String term) { // method for calculating the impedance of the given circuit
        Boolean found = false;      // marker if found a symbol
        Integer symbol_pos = -1;    // postion of the found symbol
        Character symbol = ' ';     // found symbol
        Integer num_braces = 0;     // counter for braces
        String left;                // string for the left part from the symbol
        String right;               // string for the right part from the symbol
        Circuit circ;               // declare circuit object

        term = remove_braces(term); // remove braces from term in case it is enclosed

        Integer index = 0;          // counter variable for do-while-loop
        do {
            if ((term.charAt(index) == '+' || (term.charAt(index) == '|' && term.charAt(index + 1) == '|')) && num_braces == 0) {
                // found suitable symbol not enclosed by braces
                found = true;
                symbol_pos = index;
                symbol = term.charAt(index);
            } else if (term.charAt(index) == '(') {
                // found opening brace
                num_braces += 1;
            } else if (term.charAt(index) == ')') {
                // found closing brace
                num_braces -= 1;
            }
            index++;
        } while (!found && index < term.length());  // not found symbol and in range of string

        if (found) { // if found suitable symbol
            // split left part from the string
            left = remove_braces(term.substring(0, symbol_pos));
            switch (symbol) {
                // analyse found symbol
                case '+':
                    // split right part from the string
                    right = remove_braces(term.substring(symbol_pos + 1));
                    // create a seriell object with the objects out of the left and right string as parameter
                    circ = new Seriell(this.calculate(left), this.calculate(right), term);
                    // calculate impedance
                    circ.calculateImpedance();
                    break;
                case '|':
                    // split right part from the string (because of the length of parallel symbol
                    right = remove_braces(term.substring(symbol_pos + 2));
                    // create a paralell object with the objects out of the left and right string as parameter
                    circ = new Paralell(this.calculate(left), this.calculate(right), term);
                    //
                    circ.calculateImpedance();
                    break;
                default:
                    // create in not suitable cases a empty circuit object
                    circ = new Circuit("Fehler");
                    break;
            }
        } else {
            // in case it's only a component, create a empty circuit object
            circ = new Circuit(term);
            if (term.matches("^R[0-9]+")) {
                // in case of a resistor, create a resistor with according values, calculate impedance and
                // set the circuit impedance to the component values
                Resistor res = new Resistor(this.frequency, this.resistors.get(Integer.valueOf(term.replaceAll("R", "")) - 1));
                res.calculateImpedance();
                circ.calculateImpedance(res);
            } else if (term.matches("^C[0-9]+")) {
                // in case of a capacity, create a resistor with according values, calculate impedance and
                // set the circuit impedance to the component values
                Capacity cap = new Capacity(this.frequency, this.capacities.get(Integer.valueOf(term.replaceAll("C", "")) - 1));
                cap.calculateImpedance();
                circ.calculateImpedance(cap);
            } else if (term.matches("^L[0-9]+")) {
                // in case of a inductance, create a resistor with according values, calculate impedance and
                // set the circuit impedance to the component values
                Inductivity ind = new Inductivity(this.frequency, this.inductance.get(Integer.valueOf(term.replaceAll("L", "")) - 1));
                ind.calculateImpedance();
                circ.calculateImpedance(ind);
            }
        }
        return circ;
    }

    private String remove_braces(String text) {
        // method for removing enclosing braces from the string
        if (text.charAt(0) == '(' && text.charAt(text.length() - 1) == ')') {
            text = text.substring(1, text.length() - 1);
        }
        return text;
    }

}
