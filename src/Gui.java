import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.ArrayList;

public class Gui extends JFrame {
    private JTextField circ;
    private JTextField freq;
    private ArrayList<String> resistors;
    private ArrayList<String> condensators;
    private ArrayList<String> inductors;

    public Gui() throws HeadlessException {
    }

    public void init() {
        JFrame frame = new JFrame("electric-circuit");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 300);

        JPanel panel = new JPanel();

        GridLayout layout = new GridLayout(0, 1);
        panel.setLayout(layout);

        circ = new JTextField("<Gib die Schaltung hier ein>");
        freq = new JTextField("<Gib die gwünschte Frequenz an>");
        JButton gen_button = new JButton("Bauteilfelder erzeugen");
        gen_button.addActionListener((ActionEvent arg0) -> this.input_values());

        panel.add(new JLabel("<html>Eingabe der Schaltung: <br>R, L, C für Bauteile<br>+ : Reihe, || : Parallel, () : Priorität<html>"));
        panel.add(circ);
        panel.add(new JLabel("Gib die gewünschte Frequenz (in Hz) an:"));
        panel.add(freq);
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
        resistors = new ArrayList<>();
        condensators = new ArrayList<>();
        inductors = new ArrayList<>();
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
                    inductors.add(input.charAt(i) + Integer.toString(numberind));
                    break;
                case 'C':
                    numbercon += 1;
                    tmp += input.charAt(i) + Integer.toString(numbercon);
                    condensators.add(input.charAt(i) + Integer.toString(numbercon));
                    break;
                default:
                    tmp += input.charAt(i);
                    break;
            }
        }
        this.circ.setText(tmp);
        second_frame();
    }

    private void second_frame() {
        JFrame frame2 = new JFrame("Bauteilwerte");
        frame2.setSize(500, 100 * (resistors.size() + condensators.size() + inductors.size()));

        JPanel panel = new JPanel();

        GridLayout layout = new GridLayout(0, 2);
        panel.setLayout(layout);

        resistors.forEach(resistor -> {
            panel.add(new JLabel(resistor + ":"));
            panel.add(new JTextField("<trage hier den Widerstandswert ein>"));
        });
        condensators.forEach(condensator -> {
            panel.add(new JLabel(condensator + ":"));
            panel.add(new JTextField("<trage hier die Kapazitätswert ein>"));
        });
        inductors.forEach(inductor -> {
            panel.add(new JLabel(inductor + ":"));
            panel.add(new JTextField("<trage hier die Induktivitätswert ein>"));
        });


        frame2.add(panel);
        frame2.setVisible(true);
    }
}
