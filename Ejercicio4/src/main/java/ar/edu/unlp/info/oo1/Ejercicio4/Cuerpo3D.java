package ar.edu.unlp.info.oo1.Ejercicio4;

public class Cuerpo3D {
	
	public double altura;
	public Figura caraBasal;
	
	public void setAltura(double altura) {
		this.altura = altura;
	}
	public double getAltura() {
		return this.altura;
	}
	public void setCaraBasal(Figura caraBasal) {
		this.caraBasal = caraBasal;
	}
	public double getSuperficieExterior() {
		return 2 * this.caraBasal.getArea() + 
				(this.caraBasal.getPerimetro() * this.altura);
	}
	public double getVolumen() {
		return this.caraBasal.getArea() *this.altura;
	}
	
}
