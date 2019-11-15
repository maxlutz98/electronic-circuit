
abstract public class Circuit extends Complex implements CircuitImpedance{

    private Circuit component1;
    private Circuit component2;
    private String formula;

    public Circuit getComponent1() {
        return this.component1;
    }

    public Circuit getComponent2() {
        return this.component2;
    }

    public void setComponent1(Circuit component1) {
        this.component1 = component1;
    }

    public void setComponent2(Circuit component2) {
        this.component2 = component2;
    }

    public String getFormula() {
        return formula;
    }

    public void setFormula(String formula) {
        this.formula = formula;
    }

    public float overallImpedance(){
        //TODO Betrag der Complexen Zahl
        float zahl = 1;
        return zahl;
    };
}
