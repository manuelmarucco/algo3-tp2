package construccionesProtoss_tests;

import org.junit.Assert;
import org.junit.Test;

import construccionesProtoss.Acceso;
import construccionesProtoss.ConstruccionProtoss;

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
