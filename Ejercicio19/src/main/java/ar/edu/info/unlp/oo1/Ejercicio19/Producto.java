package ar.edu.info.unlp.oo1.Ejercicio19;

public class Producto {
	private String nombre;
	private String descripcion;
	private double precio;
	private int stock;
	private Usuario vendedor;
	
	public Producto(String nombre, String descripcion, 
			double precio, int stock, Usuario vendedor) {
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.precio = precio;
		this.stock = stock;
		this.vendedor = vendedor;
	}
	
	public void decrementarStock(int cant) {
		this.stock -= cant;
	}
	
	public double getPrecio() {
		return this.precio;
	}
	public double getStock() {
		return this.stock;
	}
	public String getNombre() {
		return this.nombre;
	}
	public String getDescripcion() {
		return this.descripcion;
	}
	
	public String direccionVendedor() {
		return this.vendedor.getDireccion();
	}
	
	public boolean suficienteStock(int cantidad) {
		return this.stock - cantidad >= 0;
	}
	
	
}
