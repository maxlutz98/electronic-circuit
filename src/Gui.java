import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.ArrayList;

public class Gui extends JFrame {
    private JTextField circ;                            // textfield for the circuit input
    private JTextField freq;                            // textfield for the frequency
    private ArrayList<JTextField> resistor_fields;      // list of textfields for resistor values
    private ArrayList<JTextField> capacity_fields;      // list of textfields for capacity values
    private ArrayList<JTextField> inductance_fields;    // list of textfields for inductance values
    private JFrame value_frame;                         // permanent variable of the frame for the component values
    private JLabel result;                              // permanent label for the result

    public Gui() throws HeadlessException {
    }

    public void init() {
        // method for generating the main frame

        // main settings for the frame
        JFrame frame = new JFrame("electric-circuit");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 300);

        // generate a new panel
        JPanel panel = new JPanel();

        // set layout
        GridLayout layout = new GridLayout(0, 1);
        panel.setLayout(layout);

        // generate interactive elements
        this.circ = new JTextField("<Gib die Schaltung hier ein>");
        this.freq = new JTextField("<Gib die gwünschte Frequenz an>");
        JButton gen_button = new JButton("Bauteilfelder erzeugen");
        gen_button.addActionListener((ActionEvent arg0) -> input_values());

        // add the components to the panel
        panel.add(new JLabel("<html>Eingabe der Schaltung: <br>R, L, C für Bauteile<br>+ : Reihe, || : Parallel, () : Priorität<html>"));
        panel.add(this.circ);
        panel.add(new JLabel("Gib die gewünschte Frequenz (in Hz) an:"));
        panel.add(this.freq);
        panel.add(gen_button);

        // add panel to frame and set visible
        frame.add(panel);
        frame.setVisible(true);
    }

    private void input_values() {
        // method for index the circuit string

        String tmp = "";                                            // empty string for editing
        String input = this.circ.getText();                         // get text from textfield
        input = input.replaceAll("[0-9]+", "");   // replace all nummerics from string
        // create counter and list for each component type
        int numberres = 0;
        int numbercon = 0;
        int numberind = 0;
        ArrayList<String> resistors = new ArrayList<String>();
        ArrayList<String> capacities = new ArrayList<String>();
        ArrayList<String> inductance = new ArrayList<String>();
        // index the component with continuous numbers and add them to string
        for (int i = 0; i < input.length(); i++) {
            switch (input.charAt(i)) {
                case 'R':
                    numberres += 1;
                    tmp += input.charAt(i) + Integer.toString(numberres);
                    resistors.add(input.charAt(i) + Integer.toString(numberres));
                    break;
                case 'L':
                    numberind += 1;
                    tmp += input.charAt(i) + Integer.toString(numberind);
                    inductance.add(input.charAt(i) + Integer.toString(numberind));
                    break;
                case 'C':
                    numbercon += 1;
                    tmp += input.charAt(i) + Integer.toString(numbercon);
                    capacities.add(input.charAt(i) + Integer.toString(numbercon));
                    break;
                default:
                    tmp += input.charAt(i);
                    break;
            }
        }
        // set circuit string to the indexed one and call method for generating the frame for component values
        this.circ.setText(tmp);
        second_frame(resistors, capacities, inductance);
    }

    private void second_frame(ArrayList<String> resistors, ArrayList<String> capacities, ArrayList<String> inductance) {
        // method for creating second frame with textfield for component values

        // create temporary variable and lists of textfields for each component type
        JTextField tmp;
        this.resistor_fields = new ArrayList<JTextField>();
        this.capacity_fields = new ArrayList<JTextField>();
        this.inductance_fields = new ArrayList<JTextField>();

        // only one time creation of the frame
        if (this.value_frame == null) {
            this.value_frame = new JFrame("Bauteilwerte");
        }
        // clear frame
        this.value_frame.getContentPane().removeAll();
        this.value_frame.repaint();
        // set size dynamically
        this.value_frame.setSize(800, 40 * (resistors.size() + capacities.size() + inductance.size()) + 40);

        // create empty panel
        JPanel panel = new JPanel();

        // set layout
        GridLayout layout = new GridLayout(0, 2);
        panel.setLayout(layout);

        // create textfields for every component with suitable label
        for (int i = 0; i < resistors.size(); i++) {
            panel.add(new JLabel(resistors.get(i) + ":"));
            tmp = new JTextField("<trage hier den zugehörigen Widerstandswert ein>");
            this.resistor_fields.add(tmp);
            panel.add(tmp);
        }
        for (int i = 0; i < capacities.size(); i++) {
            panel.add(new JLabel(capacities.get(i) + ":"));
            tmp = new JTextField("<trage hier den zugehörigen Kapazitätswert ein>");
            this.capacity_fields.add(tmp);
            panel.add(tmp);
        }
        for (int i = 0; i < inductance.size(); i++) {
            panel.add(new JLabel(inductance.get(i) + ":"));
            tmp = new JTextField("<trage hier den zugehörigen Induktivitätswert ein>");
            this.inductance_fields.add(tmp);
            panel.add(tmp);
        }

        // create button and associated ActionListener
        JButton calc_button = new JButton("Gesamtimpedanz berechnen ");
        calc_button.addActionListener((ActionEvent arg0) -> start_calculating());

        // add label for the result and button at the end to panel
        this.result = new JLabel("");
        panel.add(this.result);
        panel.add(calc_button);

        // add panel to frame and set visible
        this.value_frame.add(panel);
        this.value_frame.setVisible(true);
    }

    private void start_calculating() {
        // method for start calculation

        // create empty lists of values for every component and get entered frequency
        ArrayList<Double> resistor_values = new ArrayList<Double>();
        ArrayList<Double> capacity_values = new ArrayList<Double>();
        ArrayList<Double> inductance_values = new ArrayList<Double>();
        Double frequency = Double.valueOf(this.freq.getText());

        // read the text out of the textfields to the list of values
        for (int i = 0; i < this.resistor_fields.size(); i++) {
            resistor_values.add(Double.valueOf(this.resistor_fields.get(i).getText()));
        }

        for (int i = 0; i < this.capacity_fields.size(); i++) {
            capacity_values.add(Double.valueOf(this.capacity_fields.get(i).getText()));
        }

        for (int i = 0; i < this.inductance_fields.size(); i++) {
            inductance_values.add(Double.valueOf(this.inductance_fields.get(i).getText()));
        }

        // generate calculate object with frequency and component values
        Calculate calc = new Calculate(frequency, resistor_values, capacity_values, inductance_values);

        // calculate the entered circuit
        Circuit impedance = calc.calculate(this.circ.getText());

        // show the result in the associated label
        this.result.setText("Gesamtimpedanz: " + impedance.getRe() + " + " + impedance.getIm() + "j");
    }
}
