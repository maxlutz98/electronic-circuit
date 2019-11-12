
abstract class Component extends Complex implements ComponentImpedance{ //class representing a component in a electronic curcuit
    private static float freq; // freqency applied to the curcuit
    private float value; // value of the component

    public Component(){
        this.freq = 0;
        this.value = 0;
    }
    public Component(float freq, float value){
        this.freq = freq;
        this.value = value;
    }
    public Component(float im, float re, float freq, float value){
        super(im,re);
        this.freq = freq;
        this.value = value;
    }


    public void setFreq(float toSet){this.freq = toSet;};
    public float getFreq() {return this.freq;};
    public void setValue(float toSet){this.value = toSet;};
    public float getValue(){return this.value;};
}