import java.util.ArrayList;

public class Calculate {
    private Double frequency;
    private ArrayList<Double> resistors;
    private ArrayList<Double> capacities;
    private ArrayList<Double> inductivities;

    public Calculate(Double frequency, ArrayList resistors, ArrayList capacities, ArrayList inductivities) {
        this.frequency = frequency;
        this.resistors = resistors;
        this.capacities = capacities;
        this.inductivities = inductivities;
    }

    public Circuit calculate(String term) {
        Boolean found = false;
        Integer symbol_pos = -1;
        Character symbol = ' ';
        Integer num_braces = 0;
        Integer index = 0;
        String left;
        String right;
        Circuit circ;

        term = remove_braces(term);

        do {
            if ((term.charAt(index) == '+' || (term.charAt(index) == '|' && term.charAt(index + 1) == '|')) && num_braces == 0) {
                found = true;
                symbol_pos = index;
                symbol = term.charAt(index);
            } else if (term.charAt(index) == '(') {
                num_braces += 1;
            } else if (term.charAt(index) == ')') {
                num_braces -= 1;
            }
            index++;
        } while (!found && index < term.length());

        if (found) {
            left = remove_braces(term.substring(0, symbol_pos));
            switch (symbol) {
                case '+':
                    right = remove_braces(term.substring(symbol_pos + 1));
                    circ = new Seriell(this.calculate(left), this.calculate(right), term);
                    circ.calculateImpedance();
                    break;
                case '|':
                    right = remove_braces(term.substring(symbol_pos + 2));
                    circ = new Paralell(this.calculate(left), this.calculate(right), term);
                    circ.calculateImpedance();
                    break;
                default:
                    circ = new Circuit("Fehler");
                    break;
            }
        } else {
            circ = new Circuit(term);
            if (term.matches("^R[0-9]+")) {
                Resistor res = new Resistor(this.frequency, this.resistors.get(Integer.valueOf(term.replaceAll("R", "")) - 1));
                res.calculateImpedance();
                circ.calculateImpedance(res);
            } else if (term.matches("^C[0-9]+")) {
                Capacity cap = new Capacity(this.frequency, this.capacities.get(Integer.valueOf(term.replaceAll("C", "")) - 1));
                cap.calculateImpedance();
                circ.calculateImpedance(cap);
            } else if (term.matches("^L[0-9]+")) {
                Inductivity ind = new Inductivity(this.frequency, this.inductivities.get(Integer.valueOf(term.replaceAll("L", "")) - 1));
                ind.calculateImpedance();
                circ.calculateImpedance(ind);
            }
        }
        return circ;
    }

    private String remove_braces(String text) {
        if (text.charAt(0) == '(' && text.charAt(text.length() - 1) == ')') {
            text = text.substring(1, text.length() - 1);
        }
        return text;
    }

}
