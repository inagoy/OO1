package ar.edu.info.unlp.oo1.Ejercicio19;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Sistema {
	private List<Usuario> clientes;
	private List<Usuario> vendedores;
	
	public Sistema() {
		this.clientes = new ArrayList<Usuario>();
		this.vendedores = new ArrayList<Usuario>();
	}
	
	public Usuario registrarVendedor(String nombre, String direccion) {
		Usuario vendedor = new Usuario(nombre, direccion);
		this.vendedores.add(vendedor);
		return vendedor;
	}
	
	public Usuario registrarCliente(String nombre, String direccion) {
		Usuario cliente = new Usuario(nombre, direccion);
		this.clientes.add(cliente);
		return cliente;
	}
	
	public Usuario buscarVendedor(String nombre) {
		return this.vendedores.stream()
				.filter(v -> v.getNombre().equals(nombre))
				.findFirst().orElse(null);
	}
	
	public Usuario buscarCliente(String nombre) {
		return this.clientes.stream()
				.filter(c -> c.getNombre().equals(nombre))
				.findFirst().orElse(null);
	}
	
	public List<Producto> buscarProducto(String nombre){
		return this.vendedores.stream()
				.map(v -> v.buscarProducto(nombre))
				.flatMap(List::stream)
		        .collect(Collectors.toList());
	}
	
	public Producto altaProducto (String nombre, String descripcion, double precio, int stock, Usuario vendedor) {
		Producto producto = vendedor.altaProducto(nombre, descripcion, precio, stock);
		return producto;
	}
	
	public Pedido crearPedido(Producto producto, int cantidad, Pago pago, Envio envio, Usuario cliente) {
		Pedido pedido = cliente.crearPedido(producto, cantidad, pago, envio);
		return pedido;
	}
	
	public double calcularCosto(Pedido pedido) {
		return pedido.calcularCosto();
	}

	
}
