package ar.edu.info.unlp.oo1.Ejercicio15;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class DataLapseTest {
	DateLapse lapso, otrolapso;
	
	@BeforeEach
	void setUp() throws Exception {
		lapso = new DateLapse(LocalDate.now(), LocalDate.of(2022, 10, 28));
		otrolapso = new DateLapse(LocalDate.of(2022, 10, 28),LocalDate.now());
	}
	
    @Test
    public void incluyeFecha() {
        assertTrue(lapso.includesDate(LocalDate.now()));
        assertFalse(otrolapso.includesDate(LocalDate.of(2020, 1, 1)));
    }
    
    @Test
    public void seSolapa() {
    	assertTrue(lapso.overlaps(otrolapso));
    	assertTrue(otrolapso.overlaps(lapso));
    }
}
