package ar.edu.unlp.info.oo1.Ejercicio4;

public class Circulo implements Figura{
	private double radio;
	
	public void setRadio(double radio) {
		this.radio = radio;
	}
	public void setDiametro(double diametro) {
		this.radio = diametro / 2;
	}
	public double getRadio() {
		return this.radio;
	}
	public double getDiametro() {
		return this.radio * 2;
	}
	
	public double getPerimetro() {
		return this.radio * 2 * Math.PI;
	}
	
	public double getArea() {
		return Math.pow(this.radio, 2) * Math.PI;
	}
	
}
