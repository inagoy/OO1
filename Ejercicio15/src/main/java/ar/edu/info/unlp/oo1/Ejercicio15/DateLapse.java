package ar.edu.info.unlp.oo1.Ejercicio15;

import java.time.LocalDate;

public class DateLapse {
	private LocalDate from;
	private LocalDate to;
	
	public DateLapse(LocalDate from, LocalDate to) {
		this.from = from;
		this.to = to;
	}
	
	public LocalDate getFrom() {
		return from; 
	}
	
	public LocalDate getTo() {
		return to; 
	}

	public int sizeInDays() {
		return from.until(to).getDays();
	}
	
	public boolean includesDate(LocalDate other) {
		return other.isEqual(from) || other.isEqual(to)
				|| (other.isAfter(from) && other.isBefore(to));
	}
	
	public boolean overlaps(DateLapse anotherDateLapse) {
		return ! anotherDateLapse.getTo().isBefore(this.from)
				&& ! anotherDateLapse.getFrom().isAfter(this.to);
	}
}
