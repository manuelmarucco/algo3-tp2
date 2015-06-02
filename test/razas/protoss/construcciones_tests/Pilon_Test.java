package razas.protoss.construcciones_tests;

import jugabilidad.Jugador;

import org.junit.Assert;
import org.junit.Test;

import razas.protoss.construcciones.ConstruccionProtoss;
import razas.protoss.construcciones.Pilon;

public class Pilon_Test {
	@Test
	public void VidaEscudoInicializado() {
		ConstruccionProtoss a = new Pilon(new Jugador());
		

		Assert.assertEquals(300, a.getVida());
		Assert.assertEquals(300, a.getEscudo());
	}
	
	@Test
	public void capacidadExtraInicializada() {
		Pilon p = new Pilon(new Jugador());
		
		Assert.assertEquals(5,p.getCapacidadExtra());
	}
	
}
