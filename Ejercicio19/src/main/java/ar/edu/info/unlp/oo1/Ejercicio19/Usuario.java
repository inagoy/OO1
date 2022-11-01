package ar.edu.info.unlp.oo1.Ejercicio19;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Usuario {
	private String nombre;
	private String direccion;
	private List<Producto> productos;
	private List<Pedido> pedidos;
	
	public Usuario(String nombre, String direccion) {
		this.nombre = nombre;
		this.direccion = direccion;
		this.productos = new ArrayList<Producto>();
		this.pedidos = new ArrayList<Pedido>();
	}
	
	public Producto altaProducto(String nombre, String direccion, double precio, int stock) {
		Producto nuevoProducto = new Producto(nombre, direccion, precio, stock, this);
		this.productos.add(nuevoProducto);
		return nuevoProducto;
	}
	
	public List<Producto> buscarProducto(String nombre){
		return this.productos.stream()
		.filter(p -> p.getNombre().equals(nombre))
		.collect(Collectors.toList());
	}
	
	public Pedido crearPedido(Producto unProducto, int cantidad, 
		Pago formaPago, Envio formaEnvio) {
		
		if (unProducto.suficienteStock(cantidad)){
			Pedido nuevoPedido = new Pedido(unProducto, 
					cantidad, formaPago, formaEnvio, this);
			this.pedidos.add(nuevoPedido);
			return nuevoPedido;
		}
		return null;
	}
	
	public String getDireccion() {
		return this.direccion;
	}
	
	public String getNombre() {
		return this.nombre;
	}
}
