
public class J {  // class for complex numbers
  private float r;  // real part
  private float j;  // imaginary part
	
  J(float r, float j) { // constructor with real and imaginary part
	  this.r = r;
	  this.j = j;
  }
  
  float r() {  // return real part of J. chose r() instead of getR() for shorter code
	  return this.r;
  }
  
  J r(float r) {
	  this.r = r;
	  return this;
  }
  
  float j() {  // return imaginary part of J. chose i() instead of getI() for shorter code
	  return this.j;
  }
  
  J j(float j) {
	  this.j = j;
	  return this;
  }
  
  void print() {
	  System.out.println("(" + String.valueOf(this.r) + " + " + String.valueOf(this.j) + "j)");
  }
  
  boolean equals(J j) {
	  return this.r == j.r() && this.j == j.j();
  }
  
  J plus(J j) {  // returns addition of J with a second J
	  return new J(this.r + j.r(), this.j + j.j());
  }
  
  J minus(J j) {  // returns subtraction of J with a second J
	  return new J(this.r - j.r(), this.j - j.j());
  }
}
