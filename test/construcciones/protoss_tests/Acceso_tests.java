package construcciones.protoss_tests;

import org.junit.Assert;
import org.junit.Test;

import construcciones.protoss.Acceso;
import construcciones.protoss.ConstruccionProtoss;

public class Acceso_tests {

	@Test
	public void VidaInicializada() {
		ConstruccionProtoss a = new Acceso();
		
		Assert.assertEquals(150, a.getVida());
	}

	@Test
	public void EscudoInicializado() {
		ConstruccionProtoss a = new Acceso();
		
		Assert.assertEquals(50, a.getEscudo());
	}

}
