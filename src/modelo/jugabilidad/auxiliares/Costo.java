package modelo.jugabilidad.auxiliares;

public class Costo {

	private final int costoMineral;
	private final int costoGas;
	
	public Costo(int m, int g){
		this.costoMineral = m;
		this.costoGas = g;
	}

	public int getCostoMineral() {
		return costoMineral;
	}


	public int getCostoGas() {
		return costoGas;
	}

	
}
