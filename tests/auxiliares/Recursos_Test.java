package auxiliares;

import org.junit.Assert;
import org.junit.Test;

import excepciones.ExcepcionRecursosInsuficientes;

public class Recursos_Test {
	
	@Test
	public void RecursosSuficientesYBien() throws ExcepcionRecursosInsuficientes{
		Recursos recursos = new Recursos(100,50);
		
		recursos.gastarRecursos(new Costo(100,25));
		
		Assert.assertEquals(recursos.getMinerales(),0);
		Assert.assertEquals(recursos.getGasVespeno(),25);
	}
	
	@Test(expected = ExcepcionRecursosInsuficientes.class)
	public void MineralesInsuficientesYExcepcion() throws ExcepcionRecursosInsuficientes{
		Recursos recursos = new Recursos(100,50);
		
		recursos.gastarRecursos(new Costo(200,25));
		
	}
	
	@Test(expected = ExcepcionRecursosInsuficientes.class)
	public void GasInsuficientesYExcepcion() throws ExcepcionRecursosInsuficientes{
		Recursos recursos = new Recursos(100,50);
		
		recursos.gastarRecursos(new Costo(10,51));
		
	}

}
