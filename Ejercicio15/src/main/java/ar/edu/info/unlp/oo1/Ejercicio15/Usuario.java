package ar.edu.info.unlp.oo1.Ejercicio15;

import java.util.ArrayList;
import java.util.List;

public class Usuario {
	private String nombre;
	private String direccion;
	private String dni;
	private List<Propiedad> propiedades;
	
	public Usuario(String nombre, String direccion, String dni) {
		this.nombre=nombre;
		this.direccion=direccion;
		this.dni=dni;
		this.propiedades = new ArrayList<Propiedad>();
	}
	
	
	public String getNombre() {
		return nombre;
	}


	public String getDireccion() {
		return direccion;
	}


	public String getDni() {
		return dni;
	}


	public Propiedad registrarPropiedad(String nombre, String descripcion,
			String direccion, double precioNoche) {
		Propiedad nueva = new Propiedad(nombre,descripcion,direccion,precioNoche);
		propiedades.add(nueva);
		return nueva;
	}
	
	public List<Propiedad> getPropiedades(){
		return this.propiedades;
	}
	
	public double calcularIngresos(DateLapse periodo) {
		return this.propiedades
				.stream()
				.mapToDouble(p -> p.calcularIngresos(periodo))
				.sum();
	}
}
