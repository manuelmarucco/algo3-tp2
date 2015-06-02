package construcciones.protoss_tests;

import org.junit.Assert;
import org.junit.Test;

import construcciones.protoss.ConstruccionProtoss;
import construcciones.protoss.PortalEstelar;


public class PortalEstelar_Test {

	@Test
	public void VidaEscudoInicializada() {
		ConstruccionProtoss a = new PortalEstelar();
		
		Assert.assertEquals(600, a.getVida());
		Assert.assertEquals(600, a.getEscudo());
	}

}
