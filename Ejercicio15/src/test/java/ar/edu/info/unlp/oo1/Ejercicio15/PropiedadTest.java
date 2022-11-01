package ar.edu.info.unlp.oo1.Ejercicio15;

import java.time.LocalDate;
import java.util.ArrayList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;


 class PropiedadTest {
	Propiedad prop1, prop2;
	@BeforeEach
	void setUp() throws Exception {
		prop1=new Propiedad("Casa Linda", "es linda",
			"1 y 32", 5000);
		prop2=new Propiedad("Casa fea", "es fea", "2 y 32", 2000);
	}
	
	@Test
	public void testTieneReservasEnPeriodo() {
		prop1.hacerUnaReserva(new DateLapse(LocalDate.of(2022, 10, 20), LocalDate.of(2022, 10, 25)), 
				new Usuario("Juan", "3 y 32", "1"));
		assertTrue(prop1.tieneReservasEnPeriodo( new DateLapse(LocalDate.of(2022, 10, 20), LocalDate.of(2022, 10, 25))));
		assertFalse(prop1.tieneReservasEnPeriodo( new DateLapse(LocalDate.of(2022, 10, 26), LocalDate.of(2022, 10, 27))));
	}
	
	@Test
	public void testReservar() {
		assertNotNull(prop1.hacerUnaReserva(new DateLapse(LocalDate.of(2022, 10, 20), LocalDate.of(2022, 10, 25)), 
				new Usuario("Juan", "3 y 32", "1")));
		assertNull(prop1.hacerUnaReserva(new DateLapse(LocalDate.of(222, 10, 10), LocalDate.of(2022, 10, 25)), 
				new Usuario("Martin", "5 y 35", "2")));
	}
	
	@Test
	public void testTodasSusReservas() {
		Usuario user = new Usuario("Juan", "3 y 32", "1");
		ArrayList<Reserva> lista = new ArrayList<Reserva>();
		
		assertTrue(prop1.todasSusReservas(user).isEmpty());
		
		lista.add(prop1.hacerUnaReserva(new DateLapse(LocalDate.of(2022, 10, 20), LocalDate.of(2022, 10, 25)), user));
		lista.add(prop1.hacerUnaReserva(new DateLapse(LocalDate.of(2022, 12, 1), LocalDate.of(2022, 12, 3)), user));
		prop1.hacerUnaReserva(new DateLapse(LocalDate.of(222, 10, 10), LocalDate.of(2022, 10, 25)), 
				new Usuario("Martin", "5 y 35", "2"));
		
		assertEquals(lista,prop1.todasSusReservas(user));
	}

}
