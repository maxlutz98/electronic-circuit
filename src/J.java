
public class J {  // class for complex numbers
  private float r;  // real part
  private float j;  // imaginary part
	
  public J(float r, float j) { // constructor with real and imaginary part
	  this.r = r;
	  this.j = j;
  }
  
  public float r() {  // return real part of J. chose r() instead of getR() for shorter code
	  return this.r;
  }
  
  public J r(float r) {
	  this.r = r;
	  return this;
  }
  
  public float j() {  // return imaginary part of J. chose i() instead of getI() for shorter code
	  return this.j;
  }
  
  public J j(float j) {
	  this.j = j;
	  return this;
  }
  
  public void print() {
	  System.out.println("(" + String.valueOf(this.r) + " + " + String.valueOf(this.j) + "j)");
  }
  
  public boolean equals(J j) {
	  return this.r == j.r() && this.j == j.j();
  }
  
  public J plus(J j) {  // returns addition of J with a second J
	  return new J(this.r + j.r(), this.j + j.j());
  }
  
  public J minus(J j) {  // returns subtraction of J with a second J
	  return new J(this.r - j.r(), this.j - j.j());
  }
  
  public J mult(J j) {  // returns multiplication of J with a second J
	  return new J(this.r * j.r() - this.j * j.j(), this.r * j.j() + this.j * j.r());
  }
  
  public J div(J j) {  // returns division of J with a second J
	  J numerator = this.mult(j.conj());
	  float denominator = j.mult(j.conj()).r();
	  return new J(numerator.r() / denominator, numerator.j() / denominator);
  }
  
  public J conj() {  // returns conjugate of J with a second J
	  return new J(this.r, -this.j);
  }
}
