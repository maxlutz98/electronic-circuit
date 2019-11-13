import java.util.ArrayList;

public class Calculate {
    private double frequency;
    private ArrayList resistors;
    private ArrayList condensators;
    private ArrayList inductors;

    public Calculate(double frequency, ArrayList resistors, ArrayList condensators, ArrayList inductors) {
        this.frequency = frequency;
        this.resistors = resistors;
        this.condensators = condensators;
        this.inductors = inductors;
    }
}
