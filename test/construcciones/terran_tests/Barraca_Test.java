package construcciones.terran_tests;

import org.junit.Assert;
import org.junit.Test;

import construcciones.terran.*;

public class Barraca_Test {
	
	@Test
	public void VidaInicializada() {
		ConstruccionTerran b = new Barraca();
		
		Assert.assertEquals(1000, b.getVida());
	}


}