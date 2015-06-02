package construcciones.protoss_tests;

import org.junit.Assert;
import org.junit.Test;

import razas.protoss.construcciones.Acceso;
import razas.protoss.construcciones.ConstruccionProtoss;

public class Acceso_Test {

	@Test
	public void VidaEscudoInicializada() {
		ConstruccionProtoss a = new Acceso();
		
		Assert.assertEquals(500, a.getVida());
		Assert.assertEquals(500, a.getEscudo());
	}
}
