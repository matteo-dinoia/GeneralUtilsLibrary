package utils.vectorsImaginary;

public class ImaginaryNumber {

	private double real;
	private double imaginary;

	public ImaginaryNumber(double realPart, double imaginaryPart) {
		this.setReal(realPart);
		this.setImaginary(imaginaryPart);
	}
	
	//GETTER AND SETTER
	public double getReal() {
		return real;
	}
	public double getImaginary() {
		return imaginary;
	}

	private void setReal(double real) {
		this.real = real;
	}
	private void setImaginary(double imaginary) {
		this.imaginary = imaginary;
	}
	//OPERATION
	public void sum(ImaginaryNumber num) {
		sum(num.getReal(), num.getImaginary());
	}
	public void sum(double realPart, double imaginaryPart) {
		//IMPLEMENT REALLY
		this.setReal(this.real+realPart);
		this.setImaginary(this.imaginary+imaginaryPart);
	}
	public ImaginaryNumber getSummed(ImaginaryNumber num) {
		return getSummed(num.getReal(), num.getImaginary());
	}
	public ImaginaryNumber getSummed(double realPart, double imaginaryPart) {
		ImaginaryNumber ris=new ImaginaryNumber(this.real, this.imaginary);
		ris.sum(realPart, imaginaryPart);
		
		return ris;
	}
	
	public void substract(ImaginaryNumber num) {
		this.substract(num.getReal(), num.getImaginary());
	}
	public void substract(double realPart, double imaginaryPart) {
		//IMPLEMENTS REALLY
		this.sum(-realPart, -imaginaryPart);
	}
	public ImaginaryNumber getSubstracted(ImaginaryNumber num) {
		return this.getSubstracted(num.getReal(), num.getImaginary());
	}
	public ImaginaryNumber getSubstracted(double realPart, double imaginaryPart) {
		ImaginaryNumber ris=new ImaginaryNumber(real, imaginary);
		ris.substract(realPart, imaginaryPart);
		
		return ris;
	}
	
	public void multiplyDouble(double num) {
		this.setReal(real*num);
		this.setImaginary(real*num);
	}
	public ImaginaryNumber getMultipliedDouble(double num) {
		ImaginaryNumber ris=new ImaginaryNumber(real, imaginary);
		ris.multiplyDouble(num);
		
		return ris;
	}
	public void divideDouble(double num) {
		this.multiplyDouble(1/num);
	}
	public ImaginaryNumber getDividedDouble(double num) {
		return this.getMultipliedDouble(1/num);
	}
	
	public void multiply(ImaginaryNumber num) {
		this.multiply(num.getReal(), num.getImaginary());
	}
	public void multiply(double realPart, double imaginaryPart) {
		//IMPLEMENTS REALLY
		this.setReal(this.real*realPart-this.imaginary*imaginaryPart);
		this.setImaginary(this.real*imaginaryPart + imaginary*realPart);
	}
	public ImaginaryNumber getMultiplied(ImaginaryNumber num) {
		return this.getMultiplied(num.getReal(), num.getImaginary());
	}
	public ImaginaryNumber getMultiplied(double realPart, double imaginaryPart) {
		ImaginaryNumber ris=new ImaginaryNumber(real, imaginary);
		ris.multiply(realPart, imaginaryPart);
		
		return ris;
	}

	//--
	/*
	public void divide(ImaginaryNumber num) {
		this.divide(num.getReal(), num.getImaginary());
	}
	public void divide(double realPart, double imaginaryPart) {
		//IMPLEMENTS REALLY
		this.setReal(this.real*realPart-this.imaginary*imaginaryPart);
		this.setImaginary(this.real*imaginaryPart + imaginary*realPart);
	}
	public ImaginaryNumber getDivided(ImaginaryNumber num) {
		return this.getDivided(num.getReal(), num.getImaginary());
	}
	public ImaginaryNumber getDivided(double realPart, double imaginaryPart) {
		ImaginaryNumber ris=new ImaginaryNumber(real, imaginary);
		ris.divide(realPart, imaginaryPart);
		
		return ris;
	}
	((ac+bd)+(cb-ad))/(c^2+d^2)
	*/

}
