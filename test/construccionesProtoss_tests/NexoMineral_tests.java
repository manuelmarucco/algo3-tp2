package construccionesProtoss_tests;

import org.junit.Assert;
import org.junit.Test;

import construccionesProtoss.ConstruccionProtoss;
import construccionesProtoss.NexoMineral;

public class NexoMineral_tests {

	@Test
	public void VidaInicializada() {
		ConstruccionProtoss n = new NexoMineral();
		
		Assert.assertEquals(150, n.getVida());
	}
	
	@Test
	public void EscudoInicializado() {
		ConstruccionProtoss a = new NexoMineral();
		
		Assert.assertEquals(50, a.getEscudo());
	}
	
	@Test
	public void recoletaGasVespeno() {
		NexoMineral n = new NexoMineral();
		
		Assert.assertNotEquals(0, n.getMineralRecolectado());
	}
}
