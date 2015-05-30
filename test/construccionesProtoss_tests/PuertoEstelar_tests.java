package construccionesProtoss_tests;

import org.junit.Assert;
import org.junit.Test;

import construccionesProtoss.ConstruccionProtoss;
import construccionesProtoss.PuertoEstelar;


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
