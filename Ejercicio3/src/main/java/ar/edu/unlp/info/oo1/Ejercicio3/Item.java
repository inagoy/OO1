package ar.edu.unlp.info.oo1.Ejercicio3;

public class Item {
	private String detalle;
	private int cantidad;
	private double costoUnitario;
	
	public Item detalle(String unDetalle) {
		this.detalle = unDetalle;
		return this;
	}
	public Item cantidad(int cantidad) {
		this.cantidad = cantidad;
		return this;
	}
	public Item costoUnitario(double costoUnitario) {
		this.costoUnitario = costoUnitario;
		return this;
	}

	public double costo() {
		return this.costoUnitario * this.cantidad;
	}
	public String getDetalle(){
		return this.detalle;
	}
	public double getCostoUnitario() {
		return this.costoUnitario;
	}
}
