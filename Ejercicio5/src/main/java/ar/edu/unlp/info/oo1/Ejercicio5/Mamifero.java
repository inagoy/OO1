package ar.edu.unlp.info.oo1.Ejercicio5;

import java.time.LocalDate;

public class Mamifero {
	private String identificador;
	private String especie;
	private LocalDate fechaNacimiento;
	private Mamifero padre;
	private Mamifero madre;
	
	public Mamifero(String string) {
		identificador= string;
	}
	public Mamifero() {
		// TODO Auto-generated constructor stub
	}
	public String getIdentificador() {
		return identificador;
	}
	public void setIdentificador(String identificador) {
		this.identificador = identificador;
	}
	public String getEspecie() {
		return especie;
	}
	public void setEspecie(String especie) {
		this.especie = especie;
	}
	public LocalDate getFechaNacimiento() {
		return fechaNacimiento;
	}
	public void setFechaNacimiento(LocalDate fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}
	public Mamifero getPadre() {
		return padre;
	}
	public void setPadre(Mamifero padre) {
		this.padre = padre;
	}
	public Mamifero getMadre() {
		return madre;
	}
	public void setMadre(Mamifero madre) {
		this.madre = madre;
	}
	
	public Mamifero getAbueloPaterno() {
		if (this.padre != null)
			return padre.getPadre();
		return null;
	}
	public Mamifero getAbuelaPaterna() {
		if (this.padre != null)	
			return padre.getMadre();
		return null;
	}
	
	public Mamifero getAbueloMaterno() {
		if (this.madre != null)
			return madre.getPadre();
		return null;
	}
	public Mamifero getAbuelaMaterna() {
		if (this.madre != null)
			return madre.getMadre();
		return null;
	}

	public boolean tieneComoAncestroA(Mamifero unMamifero) {
		return (madre != null && madre.evaluar(unMamifero)) || (padre != null && padre.evaluar(unMamifero));
	}
	
	private boolean evaluar(Mamifero unMamifero) {
		return this == unMamifero || (madre != null && madre.evaluar(unMamifero)) || (padre != null && padre.evaluar(unMamifero));
	}
	/*	
	private boolean evaluar2(Mamifero unMamifero) {
	
	 * NO ANDA
		if (this != unMamifero) {
			if (madre != null)
				madre.evaluar2(unMamifero);
			else if (padre != null)
				padre.evaluar2(unMamifero);
			return false;
		}
		return true;
	}
	*/
}
