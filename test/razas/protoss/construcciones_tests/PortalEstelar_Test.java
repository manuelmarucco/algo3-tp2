package razas.protoss.construcciones_tests;

import org.junit.Assert;
import org.junit.Test;

import razas.protoss.construcciones.ConstruccionProtoss;
import razas.protoss.construcciones.PortalEstelar;


public class PortalEstelar_Test {

	@Test
	public void VidaEscudoInicializada() {
		ConstruccionProtoss a = new PortalEstelar();
		
		Assert.assertEquals(600, a.getVida());
		Assert.assertEquals(600, a.getEscudo());
	}

}
