package ar.edu.unlp.info.oo1.Ejercicio8;

import java.util.ArrayList;
import java.util.List;

public class Usuario {
	private String domicilio;
	private String nombre;
	private List<Consumo> consumos;
	private List<Factura> facturas;
	
	public Usuario(String domicilio, String nombre) {
		this.domicilio = domicilio;
		this.nombre = nombre;
		this.consumos = new ArrayList<Consumo>();
		this.facturas = new ArrayList<Factura>();
	}
	
	public String getNombre() {
		return this.nombre;
	}

	public String getDomicilio() {
		return this.domicilio;
	}
	public void agregarFactura(Factura factura){
		this.facturas.add(factura);
	}
	public void agregarMedicion(Consumo unConsumo) {
		this.consumos.add(unConsumo);
	}
	
	public Consumo ultimoConsumo() {
		//retorna un Optional ya que puede no tener consumos
		return this.consumos
			.stream()
			.max((Consumo c1, Consumo c2) -> c1.getFecha().compareTo(c2.getFecha()))
			.orElse(null);
	}
	
	public double ultimoConsumoActiva() {
		Consumo ultimo = this.ultimoConsumo();
		if (ultimo != null)
			return ultimo.getConsumoEnergiaActiva();
		return 0;
	}
	
	public Factura facturarEnBaseA(double precioKWh) {
		Consumo ultimo = this.ultimoConsumo();
		if (ultimo == null) {
			return new Factura(0, 0, this);
		}

		double descuento = 0d;
		if (ultimo.factorDePotencia() > 0.8d) {
			descuento = 10;
		}
		return new Factura(ultimo.costoEnBaseA(precioKWh), descuento, this);
	}
}
