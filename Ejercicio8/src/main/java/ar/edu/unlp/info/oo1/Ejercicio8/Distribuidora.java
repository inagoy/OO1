package ar.edu.unlp.info.oo1.Ejercicio8;

import java.util.ArrayList;
import java.util.List;

public class Distribuidora {
	private double precioKWh;
	private List<Usuario> usuarios = new ArrayList<Usuario>();
	
	public Distribuidora(double precioKWh) {
		this.precioKWh = precioKWh;
	}
	
	public void agregarUsuario(Usuario unUsuario) {
		if (!this.usuarios.contains(unUsuario))
			this.usuarios.add(unUsuario);
	}
	
	public void facturar() {
		
	}
	
	public double precioKWh() {
		return this.precioKWh;
	}
}
