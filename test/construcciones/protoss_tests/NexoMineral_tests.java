package construcciones.protoss_tests;

import org.junit.Assert;
import org.junit.Test;

import construcciones.protoss.ConstruccionProtoss;
import construcciones.protoss.NexoMineral;

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
		
		Assert.assertTrue(0 != n.getMineralRecolectado());
		//Assert.assertNotEquals(0, n.getMineralRecolectado()); <- ant no compila
	}
}
