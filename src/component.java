
public class component extends J { //class representing a component in a electronic curcuit
    private float freq; // freqency applied to the curcuit
    private float value; // value of the component

    public component(){
        this.freq = 0;
        this.value = 0;
    }
    public component(float freq, float value){
        this.freq = freq;
        this.value = value;
    }
    public component(float im, float re, float freq, float value){
        super(im,re);
        this.freq = freq;
        this.value = value;
    }


    public void setFreq(float toSet){this.freq = toSet;};
    public float getFreq() {return this.freq;};
    public void setValue(float toSet){this.value = toSet;};
    public float getValue(){return this.value;};
}