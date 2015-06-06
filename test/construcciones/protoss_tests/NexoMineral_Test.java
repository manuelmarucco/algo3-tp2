package construcciones.protoss_tests;

import jugabilidad.auxiliares.Recursos;

import org.junit.Assert;
import org.junit.Test;

import construcciones.protoss.NexoMineral;

public class NexoMineral_Test {

	@Test
	public void VidaEscudoInicializada() {
		NexoMineral a = new NexoMineral(new Recursos(0,0));

		Assert.assertEquals(250, a.getVida());
		Assert.assertEquals(250, a.getEscudo());
	}
	
}
