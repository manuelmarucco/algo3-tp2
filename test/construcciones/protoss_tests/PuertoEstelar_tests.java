package construcciones.protoss_tests;

import org.junit.Assert;
import org.junit.Test;

import construcciones.protoss.ConstruccionProtoss;
import construcciones.protoss.PuertoEstelar;


public class PuertoEstelar_tests {

	@Test
	public void VidaInicializada() {
		ConstruccionProtoss f = new PuertoEstelar();
		
		Assert.assertEquals(150, f.getVida());
	}
	
	@Test
	public void EscudoInicializado() {
		PuertoEstelar f = new PuertoEstelar();
		
		Assert.assertEquals(150, f.getVida());
	}

}
