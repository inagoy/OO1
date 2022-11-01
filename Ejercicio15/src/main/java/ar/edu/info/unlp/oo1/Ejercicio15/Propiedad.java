package ar.edu.info.unlp.oo1.Ejercicio15;

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
	public String getNombre() {
		return nombre;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public String getDireccion() {
		return direccion;
	}
	public double getPrecioNoche() {
		return precioNoche;
	}
	public List<Reserva> getReservas(){
		return this.reservas;
	}
	
	public boolean tieneReservasEnPeriodo(DateLapse periodo){
		 return reservas
				 .stream()
				 .anyMatch( reserva -> periodo.overlaps(reserva.getPeriodo()));
	}
	
	public Reserva hacerUnaReserva(DateLapse periodo, Usuario inquilino) {
		if (! this.tieneReservasEnPeriodo(periodo)){
			Reserva nueva = new Reserva(periodo,inquilino, this);
			reservas.add(nueva);
			return nueva;
		}
		return null;
	}
	
	public boolean eliminarReserva(Reserva unaReserva) {
			return this.reservas.remove(unaReserva);
	}
	
	public List<Reserva> todasSusReservas(Usuario unUsuario){
		return this.reservas
		.stream()
		.filter(r -> r.getInquilino().equals(unUsuario))
		.collect(Collectors.toList());
	}
	
	public double calcularIngresos(DateLapse periodo) {
		return this.reservas
				.stream()
				.filter(r -> r.getPeriodo().containsPeriod(periodo))
				.mapToDouble(r -> r.calcularPrecio())
				.sum();
	}
	
}
