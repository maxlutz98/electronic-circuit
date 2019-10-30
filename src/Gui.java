import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class Gui extends JFrame {
    private JFrame frame; // default frame
    private JTextField circ;

    public Gui() throws HeadlessException {
    }

    public void init() {
        this.frame = new JFrame("electric-circuit");
        this.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.frame.setSize(500, 200);

        JPanel panel = new JPanel();

        GridLayout layout = new GridLayout(0, 1);
        panel.setLayout(layout);

        circ = new JTextField("<Gib die Schaltung hier ein>");
        JButton input = new JButton("Eingabefelder erzeugen");
        input.addActionListener((ActionEvent arg0) -> this.input_values());

        panel.add(new JLabel("<html>Eingabe der Schaltung: <br>(Mit Logischen Symbolen: + für Reihe, || für Parallel)<html>"));
        panel.add(circ);
        panel.add(input);

        this.frame.add(panel);
        this.frame.setVisible(true);
    }

    public void input_values() {
        String tmp = this.circ.getText();

        System.out.println(tmp);
        JFrame frame2 = new JFrame("Bauteilwerte");
        frame2.setSize(300, 700);


        frame2.setVisible(true);
    }
}
