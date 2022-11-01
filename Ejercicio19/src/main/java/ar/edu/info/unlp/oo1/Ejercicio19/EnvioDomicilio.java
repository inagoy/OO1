package ar.edu.info.unlp.oo1.Ejercicio19;

public class EnvioDomicilio implements Envio{
	private Mapa unMapa = new Mapa();
	@Override
	public double calcularEnvio(String dir1, String dir2) {
		return this.unMapa.distanciaEntre(dir1, dir2) * 0.5;
	}
}
