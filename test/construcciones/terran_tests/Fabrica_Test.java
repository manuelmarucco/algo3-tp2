package construcciones.terran_tests;

import org.junit.Assert;
import org.junit.Test;

import razas.terran.construcciones.ConstruccionTerran;
import razas.terran.construcciones.Fabrica;

public class Fabrica_Test {

	@Test
	public void VidaInicializada() {
		ConstruccionTerran f = new Fabrica();
		
		Assert.assertEquals(1250, f.getVida());
	}


}
