package ar.edu.info.unlp.oo1.Ejercicio15;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Propiedad {
	private String nombre;
	private String descripcion;
	private String direccion;
	private double precioNoche;
	private List<Reserva> reservas;
	
	public Propiedad(String nombre, String descripcion,
			String direccion, double precioNoche){
		this.nombre=nombre;
		this.descripcion=descripcion;
		this.direccion=direccion;
		this.precioNoche=precioNoche;
		this.reservas = new ArrayList<Reserva>();
		
	}
	
	public boolean tieneReservasEnPeriodo(DateLapse periodo){
		 return reservas
				 .stream()
				 .anyMatch( reserva -> periodo.overlaps(reserva.getPeriodo()));
	}
	
	public Reserva hacerUnaReserva(DateLapse periodo, Usuario inquilino) {
		if (! this.tieneReservasEnPeriodo(periodo)){
			Reserva nueva = new Reserva(periodo,inquilino);
			reservas.add(nueva);
			return nueva;
		}
		return null;
	}
	
	public double calcularPrecio(Reserva unaReserva) {
		return unaReserva.getPeriodo().sizeInDays() * this.precioNoche;
	}
	
	public boolean eliminarReserva(Reserva unaReserva) {
		if (unaReserva.getPeriodo().getFrom().isAfter(LocalDate.now()))
			return this.reservas.remove(unaReserva);
		return false;
	}
	
	public List<Reserva> getReservas(){
		return this.reservas;
	}
	
	public List<Reserva> todasSusReservas(Usuario unUsuario){
		return this.reservas
		.stream()
		.filter(r -> r.getInquilino().equals(unUsuario))
		.collect(Collectors.toList());
	}
	
	public double calcularIngresos(DateLapse periodo) {
		return 
				this.reservas
				.stream()
				.filter(r -> periodo.includesDate(r.getPeriodo().getFrom())
						&& periodo.includesDate(r.getPeriodo().getTo()))
				.mapToDouble(r -> this.calcularPrecio(r))
				.sum();
	}
	
}
