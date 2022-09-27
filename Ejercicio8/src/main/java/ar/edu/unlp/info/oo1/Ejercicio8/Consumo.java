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
		return this.consumoEnergiaActiva * precioKWh;
	}

	public LocalDate getFecha() {
		return fecha;
	}

	public double getConsumoEnergiaActiva() {
		return consumoEnergiaActiva;
	}

	public double getConsumoEnergiaReactiva() {
		return consumoEnergiaReactiva;
	}
	
}
