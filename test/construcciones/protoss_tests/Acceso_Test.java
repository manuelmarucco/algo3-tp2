package construcciones.protoss_tests;

import org.junit.Assert;
import org.junit.Test;

import modelo.construcciones.protoss.Acceso;

public class Acceso_Test {

	@Test
	public void VidaEscudoInicializada() {
		Acceso a = new Acceso();
		
		Assert.assertEquals(500, a.getVida());
		Assert.assertEquals(500, a.getEscudo());
	}
}
