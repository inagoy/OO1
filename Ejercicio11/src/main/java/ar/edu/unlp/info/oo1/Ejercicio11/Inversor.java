package ar.edu.unlp.info.oo1.Ejercicio11;

import java.util.ArrayList;
import java.util.List;

public class Inversor {
	private String nombre;
	private List<Inversion> inversiones;
	
	public Inversor(String nombre, List<Inversion> inversiones) {
		this.nombre = nombre;
		this.inversiones = new ArrayList<Inversion>();
	}
	
	public double valorActual() {
		return 0;
	}
	
	public String getNombre() {
		return nombre;
	}
	public List<Inversion> getInversiones() {
		return inversiones;
	}
	
}
