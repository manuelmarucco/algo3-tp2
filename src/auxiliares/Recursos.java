package auxiliares;

import excepciones.ExcepcionRecursosInsuficientes;

public class Recursos {

	private int minerales;
	private int gasVespeno;
	
	public Recursos(int m, int g){
		this.minerales = m;
		this.gasVespeno = g;
	}
	
	public void gastarRecursos(Costo costoDeEntidad) throws ExcepcionRecursosInsuficientes{
		
		if (minerales>= costoDeEntidad.getCostoMineral())
			minerales -= costoDeEntidad.getCostoMineral();
		else
			throw new ExcepcionRecursosInsuficientes();
		
		if (gasVespeno>= costoDeEntidad.getCostoGas())
			gasVespeno -= costoDeEntidad.getCostoGas();
		else
			throw new ExcepcionRecursosInsuficientes();
	}

	public int getMinerales() {
		return this.minerales;
	}
	
	public int getGasVespeno() {
		return this.gasVespeno;
	}

	public void RecolectarMirerales(int mineralRecolectado) {
		this.minerales+=mineralRecolectado;
	}
}
