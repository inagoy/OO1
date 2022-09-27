package ar.edu.unlp.info.oo1.Ejercicio8;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Distribuidora {
	private double precioKWh;
	private Set<Usuario> usuarios;
	
	public Distribuidora(double precioKWh) {
		this.precioKWh = precioKWh;
		this.usuarios = new HashSet<>();
	}
	
	public void agregarUsuario(Usuario unUsuario) {
		if (!this.usuarios.contains(unUsuario))
			this.usuarios.add(unUsuario);
	}
	
	public double getPrecioKWh() {
		return this.precioKWh;
	}
	public void setPrecioKW(double preciokwh) {
		this.precioKWh = preciokwh;
	}
	public List<Usuario> getUsuarios() {
		return new ArrayList<>(this.usuarios);
	}
	
	public List<Factura> facturar() {
		List<Factura> result = this.usuarios
			.stream()
			.map((Usuario u) -> u.facturarEnBaseA(this.getPrecioKWh()))
			.collect(Collectors.toList());
		return result;
	}
	
	public double consumoTotalActiva() {
		return this.usuarios
			.stream()
			.mapToDouble((Usuario u) -> u.ultimoConsumoActiva())
			.sum();
	}
}
