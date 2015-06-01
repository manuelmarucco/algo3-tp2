package construcciones.protoss_tests;

import org.junit.Assert;
import org.junit.Test;

import construcciones.protoss.ConstruccionProtoss;
import construcciones.protoss.Pilon;

public class Pilon_tests {
	
	@Test
	public void VidaEscudoInicializado() {
		ConstruccionProtoss a = new Pilon();
		

		Assert.assertEquals(300, a.getVida());
		Assert.assertEquals(300, a.getEscudo());
	}
	
	@Test
	public void capacidadExtraInicializada() {
		Pilon p = new Pilon();
		
		Assert.assertEquals(5,p.getCapacidadExtra());
	}
	
}
