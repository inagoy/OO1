package ar.edu.info.unlp.oo1.Ejercicio19;

public class SeisCuotas implements Pago{
	@Override
	public double calcularPrecio(double monto) {
		return monto * 1.2;
	}	
}
