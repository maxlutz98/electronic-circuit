
public class Complex {  // class for complex numbers
  private float re;  // real part
  private float im;  // imaginary part
	
  public Complex(float re, float im) { // constructor with real and imaginary part
	  this.re = re;
	  this.im = im;
  }
  
  public float getRe() {  // return real part of J. chose r() instead of getR() for shorter code
	  return this.re;
  }
  
  public Complex setRe(float re) {
	  this.re = re;
	  return this;
  }
  
  public float getIm() {  // return imaginary part of J. chose i() instead of getI() for shorter code
	  return this.im;
  }
  
  public Complex setIm(float im) {
	  this.im = im;
	  return this;
  }
  
  public void print() {
	  System.out.println("(" + String.valueOf(this.re) + " + " + String.valueOf(this.im) + "j)");
  }
  
  public boolean equals(Complex secondNumber) {
	  return this.re == number.getRe() && this.im == number.getIm();
  }
  
  public Complex plus(Complex secondNumber) {  // returns addition of J with a second J
	  return new Complex(this.re + secondNumber.getRe(), this.im + secondNumber.getIm();
  }
  
  public Complex minus(Complex secondNumber) {  // returns subtraction of J with a second J
	  return new Complex(this.re - secondNumber.getRe(), this.im - secondNumber.getIm());
  }
  
  public Complex mult(Complex secondNumber) {  // returns multiplication of J with a second J
	  return new Complex(this.re * secondNumber.getRe() - this.im * secondNumber.getIm(), this.re * secondNumber.getIm() + this.im * secondNumber.getRe());
  }
  
  public Complex div(Complex secondNumber) {  // returns division of J with a second J
	  Complex numerator = this.mult(secondNumber.conj());
	  float denominator = secondNumber.mult(secondNumber.conj()).getRe();
	  return new Complex(numerator.getRe() / denominator, numerator.getIm() / denominator);
  }
  
  public Complex conj() {  // returns conjugate of J with a second J
	  return new Complex(this.re, -this.im);
  }
  
  public float mod() {  // returns modulus of J
	  return (float)Math.sqrt(this.re * this.re + this.im * this.im);
  }
  
  public float arg() {  // returns argument of J
	  float arg = 0;
	  if (this.re > 0) {
		  arg = (float)Math.atan(this.im / this.re);
	  }
	  else if (this.re < 0) {
		  if (this.im >= 0) {
			  arg = (float)Math.atan(this.im / this.re) + (float)Math.PI;
		  }
		  else {
			  arg = (float)Math.atan(this.im / this.re) - (float)Math.PI;
		  }
	  }
	  else {
		  if (this.im > 0) {
			  arg = (float)Math.PI / 2;
		  }
		  else if (this.im < 0) {
			  arg = (float)-Math.PI / 2;
		  }
	  }
	  return arg;
  }
}
