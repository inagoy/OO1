package ar.edu.info.unlp.oo1.Ejercicio15;

public class Reserva {
	private DateLapse periodo;
	private Usuario inquilino;
	
	public Reserva(DateLapse periodo, Usuario inquilino) {
		this.periodo = periodo;
		this. inquilino = inquilino;
	}
	
	public DateLapse getPeriodo() {
		return this.periodo;
	}
	
	public Usuario getInquilino() {
		return this.inquilino;
	}
}
