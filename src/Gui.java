import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.ArrayList;

public class Gui extends JFrame {
    private JTextField circ;
    private JTextField freq;
    private ArrayList<JTextField> resistor_fields;
    private ArrayList<JTextField> capacity_fields;
    private ArrayList<JTextField> inductance_fields;
    private JFrame value_frame;
    private JLabel result;

    public Gui() throws HeadlessException {
    }

    public void init() {
        JFrame frame = new JFrame("electric-circuit");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 300);

        JPanel panel = new JPanel();

        GridLayout layout = new GridLayout(0, 1);
        panel.setLayout(layout);

        this.circ = new JTextField("<Gib die Schaltung hier ein>");
        this.freq = new JTextField("<Gib die gwünschte Frequenz an>");
        JButton gen_button = new JButton("Bauteilfelder erzeugen");
        gen_button.addActionListener((ActionEvent arg0) -> input_values());

        panel.add(new JLabel("<html>Eingabe der Schaltung: <br>R, L, C für Bauteile<br>+ : Reihe, || : Parallel, () : Priorität<html>"));
        panel.add(this.circ);
        panel.add(new JLabel("Gib die gewünschte Frequenz (in Hz) an:"));
        panel.add(this.freq);
        panel.add(gen_button);

        frame.add(panel);
        frame.setVisible(true);
    }

    private void input_values() {
        String tmp = "";
        String input = this.circ.getText();
        input = input.replaceAll("[0-9]+", "");
        int numberres = 0;
        int numbercon = 0;
        int numberind = 0;
        ArrayList<String> resistors = new ArrayList<String>();
        ArrayList<String> capacities = new ArrayList<String>();
        ArrayList<String> inductance = new ArrayList<String>();
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
        this.circ.setText(tmp);
        second_frame(resistors, capacities, inductance);
    }

    private void second_frame(ArrayList<String> resistors, ArrayList<String> capacities, ArrayList<String> inductance) {
        JTextField tmp;
        this.resistor_fields = new ArrayList<JTextField>();
        this.capacity_fields = new ArrayList<JTextField>();
        this.inductance_fields = new ArrayList<JTextField>();

        if (this.value_frame == null) {
            this.value_frame = new JFrame("Bauteilwerte");
        }
        this.value_frame.setSize(800, 40 * (resistors.size() + capacities.size() + inductance.size()));

        JPanel panel = new JPanel();

        GridLayout layout = new GridLayout(0, 2);
        panel.setLayout(layout);

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

        JButton calc_button = new JButton("Gesamtimpedanz berechnen ");
        calc_button.addActionListener((ActionEvent arg0) -> start_calculating());

        this.result = new JLabel("");
        panel.add(this.result);
        panel.add(calc_button);

        this.value_frame.add(panel);
        this.value_frame.setVisible(true);
    }

    private void start_calculating() {
        ArrayList<Double> resistor_values = new ArrayList<Double>();
        ArrayList<Double> capacity_values = new ArrayList<Double>();
        ArrayList<Double> inductance_values = new ArrayList<Double>();
        Double frequency = Double.valueOf(this.freq.getText());

        for (int i = 0; i < this.resistor_fields.size(); i++) {
            resistor_values.add(Double.valueOf(this.resistor_fields.get(i).getText()));
        }

        for (int i = 0; i < this.capacity_fields.size(); i++) {
            capacity_values.add(Double.valueOf(this.capacity_fields.get(i).getText()));
        }

        for (int i = 0; i < this.inductance_fields.size(); i++) {
            inductance_values.add(Double.valueOf(this.inductance_fields.get(i).getText()));
        }

        Calculate calc = new Calculate(frequency, resistor_values, capacity_values, inductance_values);

        Circuit impedance = calc.calculate(this.circ.getText());

        this.result.setText("Gesamtimpedanz: " + impedance.getRe() + " + " + impedance.getIm() + "j");
    }
}
