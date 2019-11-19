import java.util.ArrayList;

public class Calculate {
    private Double frequency;
    private ArrayList<Double> resistors;
    private ArrayList<Double> condensators;
    private ArrayList<Double> inductors;

    public Calculate(Double frequency, ArrayList resistors, ArrayList condensators, ArrayList inductors) {
        this.frequency = frequency;
        this.resistors = resistors;
        this.condensators = condensators;
        this.inductors = inductors;
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
            right = remove_braces(term.substring(symbol_pos + 1));
            switch (symbol) {
                case '+':
                    circ = new Seriell(this.calculate(left), this.calculate(right), term);
                    break;
                case '|':
                    circ = new Paralell(this.calculate(left), this.calculate(right), term);
                    break;
                default:
                    break;
            }
            circ.calculateImpedance();
        } else {
            circ = new Circuit(term);
            if (term.matches("^R{0-9}+")) {
                Resistor res = new Resistor(this.frequency, this.resistors.get(Integer.valueOf(term.replaceAll("R", "")) - 1));
                // TODO: 15.11.19 function for generating circuit class out of component
            } else if (term.matches("^C{0-9}+")) {
                Capacity cap = new Capacity(this.frequency, this.condensators.get(Integer.valueOf(term.replaceAll("C", "")) - 1));
                // TODO: 15.11.19 function for generating circuit class out of component
            } else if (term.matches("^L{0-9}+")) {
                Inductivity ind = new Inductivity(this.frequency, this.inductors.get(Integer.valueOf(term.replaceAll("L", "")) - 1));
                // TODO: 15.11.19 function for generating circuit class out of component, e. g.
                // circ.calculateImpedance(ind);
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
