package construcciones.protoss_tests;

import org.junit.Assert;
import org.junit.Test;

import construcciones.protoss.Acceso;
import construcciones.protoss.ConstruccionProtoss;

public class Acceso_tests {

	@Test
	public void VidaEscudoInicializada() {
		ConstruccionProtoss a = new Acceso();
		
		Assert.assertEquals(500, a.getVida());
		Assert.assertEquals(500, a.getEscudo());
	}
}
