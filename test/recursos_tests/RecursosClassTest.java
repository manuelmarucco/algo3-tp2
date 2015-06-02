package recursos_tests;

import jugabilidad.auxiliares.Costo;
import jugabilidad.auxiliares.Recursos;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import excepciones.ExcepcionRecursosInsuficientes;

public class RecursosClassTest {

	@Rule
	public ExpectedException exception = ExpectedException.none();
	@Test
	public void GastoMasMineralesDelQueTengoYExcepcion() throws ExcepcionRecursosInsuficientes {
		Recursos recursos = new Recursos(10,10);
		
	    exception.expect(ExcepcionRecursosInsuficientes.class);
	    recursos.gastarRecursos(new Costo(20,10));
	}
	
	@Test
	public void GastoMasGasDelQueTengoYExcepcion() throws ExcepcionRecursosInsuficientes {
		Recursos recursos = new Recursos(10,10);
		
	    exception.expect(ExcepcionRecursosInsuficientes.class);
	    recursos.gastarRecursos(new Costo(10,20));
	}

}
