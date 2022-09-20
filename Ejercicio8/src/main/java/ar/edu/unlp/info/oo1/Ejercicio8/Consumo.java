package ar.edu.unlp.info.oo1.Ejercicio8;

import java.time.LocalDate;

public class Consumo {
	private LocalDate fecha;
	private double consumoEnergiaActiva;
	private double consumoEnergiaReactiva;
	
	public Consumo(LocalDate fecha, double cEA, double cER) {
		this.fecha = fecha;
		this.consumoEnergiaActiva = cEA;
		this.consumoEnergiaReactiva = cER;
	}
	
	public double factorDePotencia() {
		return 	(this.consumoEnergiaActiva / 
				(Math.sqrt(Math.pow(this.consumoEnergiaActiva, 2)) 
				+ Math.sqrt(Math.pow(this.consumoEnergiaReactiva, 2)))
				);
	}
	
	public double costoEnBaseA(double precioKWh) {
		double consumo = this.consumoEnergiaActiva * precioKWh;
		double bonificacion = 0;
		if (this.factorDePotencia() > 0.8) bonificacion = (consumo * 10) / 100;
		return  consumo + bonificacion;
	}
}
