package modelo.jugabilidad.auxiliares;

import modelo.excepciones.construcciones.ExcepcionGasInsuficiente;
import modelo.excepciones.construcciones.ExcepcionMineralesInsuficientes;
import modelo.excepciones.construcciones.ExcepcionRecursosInsuficientes;

public class Recursos {

	private int mineralesDisponibles;
	private int gasVespenoDisponible;
	
	public Recursos(int m, int g){
		this.mineralesDisponibles = m;
		this.gasVespenoDisponible = g;
	}
	
	public void validacionRecursosSuficientes(Costo costoDeEntidad) throws ExcepcionRecursosInsuficientes{

		if (mineralesDisponibles< costoDeEntidad.getCostoMineral())
			throw new ExcepcionMineralesInsuficientes();
		
		if (gasVespenoDisponible< costoDeEntidad.getCostoGas())
			throw new ExcepcionGasInsuficiente();
		
		//despues se puede hacer una excepcion para minerales y otra para gas
	}
	
	public void gastarRecursos(Costo costoDeEntidad) throws ExcepcionRecursosInsuficientes{

		this.validacionRecursosSuficientes(costoDeEntidad);

		mineralesDisponibles -= costoDeEntidad.getCostoMineral();
		gasVespenoDisponible -= costoDeEntidad.getCostoGas();
	}

	public int getMinerales() {
		return this.mineralesDisponibles;
	}
	
	public int getGasVespeno() {
		return this.gasVespenoDisponible;
	}

	public void agregarRecursos(int i, int j) {
		this.mineralesDisponibles += i;
		this.gasVespenoDisponible += j;
	}
	
}
