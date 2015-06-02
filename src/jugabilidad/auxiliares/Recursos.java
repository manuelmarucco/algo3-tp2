package jugabilidad.auxiliares;

import excepciones.ExcepcionRecursosInsuficientes;

public class Recursos {

	private int minerales;
	private int gasVespeno;
	
	public Recursos(int m, int g){
		this.minerales = m;
		this.gasVespeno = g;
	}
	
	public void validacionRecursosSuficientes(Costo costoDeEntidad) throws ExcepcionRecursosInsuficientes{

		if (minerales< costoDeEntidad.getCostoMineral())
			throw new ExcepcionRecursosInsuficientes();
		
		if (gasVespeno< costoDeEntidad.getCostoGas())
			throw new ExcepcionRecursosInsuficientes(); 
		
		//despues se puede hacer una excepcion para minerales y otra para gas
	}
	
	public void gastarRecursos(Costo costoDeEntidad) throws ExcepcionRecursosInsuficientes{
		
		this.validacionRecursosSuficientes(costoDeEntidad);
		
		minerales -= costoDeEntidad.getCostoMineral();
		gasVespeno -= costoDeEntidad.getCostoGas();
	}

	public int getMinerales() {
		return this.minerales;
	}
	
	public int getGasVespeno() {
		return this.gasVespeno;
	}

	public void agregarRecursos(int i, int j) {
		this.minerales += i;
		this.gasVespeno += j;
	}
	
}
