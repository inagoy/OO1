package ar.edu.unlp.info.oo1.Ejercicio6;

import java.util.ArrayList;
import java.util.List;

public class Farola {
	
	private boolean on;
	private List<Farola> vecinas;
	
	public Farola () {
		this.on = false;
		this.vecinas = new ArrayList<Farola>();
	}
	

	public void pairWithNeighbor( Farola otraFarola ) {
		if (!this.vecinas.contains(otraFarola)) {
			this.vecinas.add(otraFarola);
			otraFarola.pairWithNeighbor(this);
		}
	}
	
	public List<Farola> getNeighbors (){
		return this.vecinas;
	}

	public void turnOn() {
		if (!this.isOn()) {
			this.on  = true;
			this.vecinas.forEach(vecina -> vecina.turnOn());
		}
	}

	public void turnOff() {
		if (this.isOn()) {
			this.on = false;
			this.vecinas.forEach(vecina -> vecina.turnOff());
		}
	}
	
	public boolean isOn() {
		return this.on;
	}

}
