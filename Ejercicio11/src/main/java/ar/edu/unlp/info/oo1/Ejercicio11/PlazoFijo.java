package ar.edu.unlp.info.oo1.Ejercicio11;

import java.time.Duration;
import java.time.LocalDate;

public class PlazoFijo implements Inversion{
	
	private LocalDate fechaDeConstitucion;
	private double montoDepositado;
	private double porcentajeDeInteresDiario;
	
	public PlazoFijo(LocalDate fechaDeConstitucion, double montoDepositado,
			double porcentajeDeInteresDiario) {
		
		this.fechaDeConstitucion = LocalDate.now();
		this.montoDepositado = montoDepositado;
		this.porcentajeDeInteresDiario = porcentajeDeInteresDiario;
	}
	
	public double getBonificacion() {
		return montoDepositado * (1 - porcentajeDeInteresDiario/100);
	}
	
	public double valorActual() {
		return this.montoDepositado + (Duration.between(getFechaDeConstitucion(), LocalDate.now()).toDays()) * getBonificacion();
	}
	
	public LocalDate getFechaDeConstitucion() {
		return this.fechaDeConstitucion;
	}

	public double getMontoDepositado() {
		return this.montoDepositado;
	}

	public double getPorcentajeDeInteresDiario() {
		return this.porcentajeDeInteresDiario;
	}
	
	
}
