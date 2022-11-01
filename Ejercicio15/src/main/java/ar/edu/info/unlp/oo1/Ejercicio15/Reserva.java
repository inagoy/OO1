package ar.edu.info.unlp.oo1.Ejercicio15;

import java.time.LocalDate;

public class Reserva {
	private DateLapse periodo;
	private Usuario inquilino;
	private Propiedad propiedad;
	
	public Reserva(DateLapse periodo, Usuario inquilino, Propiedad propiedad) {
		this.periodo = periodo;
		this. inquilino = inquilino;
	}
	
	public DateLapse getPeriodo() {
		return this.periodo;
	}
	
	public Usuario getInquilino() {
		return this.inquilino;
	}
	
	public Propiedad getPropiedad() {
		return this.propiedad;
	}
	
	public boolean eliminarReserva() {
		if (this.getPeriodo().getFrom().isAfter(LocalDate.now()))
			return propiedad.eliminarReserva(this);
		return false;
	}
	
	public double calcularPrecio(){
		return this.getPeriodo().sizeInDays() * propiedad.getPrecioNoche();
	}
}
