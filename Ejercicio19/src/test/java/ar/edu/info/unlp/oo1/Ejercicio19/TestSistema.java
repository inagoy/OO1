package ar.edu.info.unlp.oo1.Ejercicio19;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class TestSistema {
	
	private Sistema sistema;
	
	private Pedido AlContadoCorreo;
	private Pedido AlContadoADomicilio;
	private Pedido SeisCuotasComercio;
	
	private Producto producto;
	private Usuario cliente;
	private Usuario vendedor;

	@BeforeEach
	void setUp() throws Exception {
		this.sistema = new Sistema();
		this.cliente = this.sistema.registrarCliente("Macri", "321");
		this.vendedor = this.sistema.registrarVendedor("Alberto", "123");
		this.producto = this.sistema.altaProducto("Pr1", "descr", 100, 10, vendedor);
	}

	@Test
	void testBuscarProducto() {
		assertTrue(this.sistema.buscarProducto("Pr1").contains(producto));
		assertEquals(1,this.sistema.buscarProducto("Pr1").size());
		assertTrue(this.sistema.buscarProducto("123").isEmpty());
	}
	
	@Test
	void testBuscarVendedor() {
		assertEquals(this.vendedor, this.sistema.buscarVendedor("Alberto"));
		assertNull(this.sistema.buscarVendedor("Marcos"));
	}
	@Test
	void testBuscarCliente() {
		assertEquals(this.cliente, this.sistema.buscarCliente("Macri"));
		assertNull(this.sistema.buscarCliente("Veronica"));
	}
	
	@Test
	void testPedidoAlContadoCorreo() {
		this.AlContadoCorreo = this.sistema.crearPedido(producto, 10, new AlContado(), new EnvioSucursal(), cliente);
		assertEquals(1050,this.sistema.calcularCosto(AlContadoCorreo));
	}
	
	@Test
	void testPedidoAlContadoADomicilio() {
		this.AlContadoADomicilio = this.sistema.crearPedido(producto, 10, new AlContado(), new EnvioDomicilio(), cliente);
		assertEquals(1050,this.sistema.calcularCosto(AlContadoADomicilio));
	}
	
	@Test
	void testSeisCuotasComercio() {
		this.SeisCuotasComercio = this.sistema.crearPedido(producto, 10, new SeisCuotas(), new EnvioComercio(), cliente);
		assertEquals(1200,this.sistema.calcularCosto(SeisCuotasComercio));
	}

}