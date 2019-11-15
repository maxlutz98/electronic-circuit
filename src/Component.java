
abstract class Component extends Complex implements ComponentImpedance{ //class representing a component in a electronic curcuit
    private static double freq; // freqency applied to the curcuit
    private double value; // value of the component

    public Component(){
        this.freq = 0;
        this.value = 0;
    }
    public Component(double freq, double value){
        this.freq = freq;
        this.value = value;
    }
    public Component(float im, float re, float freq, float value){
        super(im,re);
        this.freq = freq;
        this.value = value;
    }


    public void setFreq(float toSet){this.freq = toSet;};
    public double getFreq() {return this.freq;};
    public void setValue(float toSet){this.value = toSet;};
    public double getValue(){return this.value;};
}