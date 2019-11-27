
public class Complex {  // class for complex numbers
  private double re;  // real part
  private double im;  // imaginary part

	public Complex(){ // default constructor needed for inheritance
		this.re = 0;
		this.im = 0;
	}

  public Complex(double re, double im) { // constructor with real and imaginary part
	  this.re = re;
	  this.im = im;
  }
  
  public double getRe() {  // return real part of Complex. chose r() instead of getR() for shorter code
	  return this.re;
  }
  
  public Complex setRe(double re) { // set real part of Complex class
	  this.re = re;
	  return this;
  }
  
  public double getIm() {  // return imaginary part of J. chose i() instead of getI() for shorter code
	  return this.im;
  }
  
  public Complex setIm(double im) { // set imaginary part of Complex class
	  this.im = im;
	  return this;
  }
  
  public void print() {
	  System.out.println("(" + String.valueOf(this.re) + " + " + String.valueOf(this.im) + "j)");
  }
  
  public boolean equals(Complex secondNumber) {
	  return this.re == secondNumber.getRe() && this.im == secondNumber.getIm();
  }
  
  public Complex plus(Complex secondNumber) {  // returns addition of J with a second J
	  return new Complex(this.re + secondNumber.getRe(), this.im + secondNumber.getIm());
  }
  
  public Complex minus(Complex secondNumber) {  // returns subtraction of J with a second J
	  return new Complex(this.re - secondNumber.getRe(), this.im - secondNumber.getIm());
  }
  
  public Complex mult(Complex secondNumber) {  // returns multiplication of J with a second J
	  return new Complex(this.re * secondNumber.getRe() - this.im * secondNumber.getIm(), this.re * secondNumber.getIm() + this.im * secondNumber.getRe());
  }
  
  public Complex div(Complex secondNumber) {  // returns division of J with a second J
	  Complex numerator = this.mult(secondNumber.conj());
	  double denominator = secondNumber.mult(secondNumber.conj()).getRe();
	  return new Complex(numerator.getRe() / denominator, numerator.getIm() / denominator);
  }
  
  public Complex inv() {  // inverse of J
	  return new Complex(1, 0).div(this);
  }
  
  public Complex conj() {  // returns conjugate of J with a second J
	  return new Complex(this.re, -this.im);
  }
  
  public double mod() {  // returns modulus of J
	  return (float)Math.sqrt(this.re * this.re + this.im * this.im);
  }
  
  public double arg() {  // returns argument of J
	  double arg = 0;
	  if (this.re > 0) {
		  arg = Math.atan(this.im / this.re);
	  }
	  else if (this.re < 0) {
		  if (this.im >= 0) {
			  arg = Math.atan(this.im / this.re) + Math.PI;
		  }
		  else {
			  arg = Math.atan(this.im / this.re) - Math.PI;
		  }
	  }
	  else {
		  if (this.im > 0) {
			  arg = Math.PI / 2;
		  }
		  else if (this.im < 0) {
			  arg = -Math.PI / 2;
		  }
	  }
	  return arg;
  }
}
