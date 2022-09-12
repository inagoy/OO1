package ar.edu.unlp.info.oo1.Ejercicio3;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;


public class Presupuesto {
	private LocalDate fecha;
	private String cliente;
	private List<Item> items = new ArrayList<Item>();
	
	public Presupuesto fecha(LocalDate fecha) {
		this.fecha = fecha;
		return this;
	}
	public Presupuesto cliente(String cliente) {
		this.cliente = cliente;
		return this;
	}	
	
	public void agregarItem(Item item) {
		items.add(item);
	}
	
	public double calcularTotal() {
		return items.stream()
				.mapToDouble(item -> item.costo())
				.sum();
	}
}
