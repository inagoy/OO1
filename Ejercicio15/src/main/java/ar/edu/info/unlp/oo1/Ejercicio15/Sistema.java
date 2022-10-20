package ar.edu.info.unlp.oo1.Ejercicio15;

import java.util.List;
import java.util.stream.Collectors;

public class Sistema {
	private List<Usuario> usuarios;
	
	public Usuario registrarUsuario(String nombre, 
			String direccion, String dni) {
		Usuario nuevo = new Usuario(nombre,direccion,dni);
		usuarios.add(nuevo);
		return nuevo;
	}
	
	public List<Propiedad> todasLasPropiedades(){
		return usuarios
				.stream()
				.map(u-> u.getPropiedades())
				.flatMap(List::stream)
				.collect(Collectors.toList());
	}
	
	public List<Propiedad> todasLasPropiedadesDisponibles(DateLapse periodo){
		
		return todasLasPropiedades()
				.stream()
				.filter(p -> p.tieneReservasEnPeriodo(periodo))
				.collect(Collectors.toList());

	}
	
	public List<Reserva> todasSusReservas( Usuario unUsuario){
		return todasLasPropiedades()
		.stream()
		.map(p-> p.todasSusReservas(unUsuario))
		.flatMap(List :: stream)
		.collect(Collectors.toList());
	}
}
