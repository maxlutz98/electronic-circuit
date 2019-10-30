import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class Gui extends JFrame {
    private JFrame frame; // default frame

    public Gui() throws HeadlessException {
    }

    public void init() {
        this.frame = new JFrame("electric-circuit");
        this.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.frame.setSize(500, 200);

        JPanel panel = new JPanel();

        GridLayout layout = new GridLayout(0, 1);
        panel.setLayout(layout);

        JComponent circ = new JTextField("<Gebe die Schaltung hier ein>");
        JButton input = new JButton("Eingabefelder erzeugen");
        input.addActionListener((ActionEvent arg0) -> this.input_values());

        panel.add(new JLabel("<html>Eingabe der Schaltung: <br>(Mit Logischen Symbolen: + für Reihe, || für Parallel)<html>"));
        panel.add(circ);
        panel.add(input);

        this.frame.add(panel);
        this.frame.setVisible(true);
    }
}
