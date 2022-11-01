package ar.edu.info.unlp.oo1.Ejercicio19;

public class Pedido {
	private int cantidad;
	private Usuario cliente;
	private Producto unProducto;
	private Pago formaPago;
	private Envio formaEnvio;
	
	public Pedido(Producto unProducto, int cantidad, Pago formaPago, Envio formaEnvio, Usuario cliente) {
		this.unProducto = unProducto;
		this.cantidad = cantidad;
		this.cliente = cliente;
		this.formaEnvio = formaEnvio;
		this.formaPago = formaPago;
	}
	
	public double calcularCosto() {
		return formaPago.calcularPrecio(unProducto.getPrecio() * cantidad) + 
				formaEnvio.calcularEnvio(this.cliente.getDireccion(), this.unProducto.direccionVendedor());
	}
	
	
}
