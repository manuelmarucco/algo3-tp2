package razas.terran.construcciones_tests;

import org.junit.Assert;
import org.junit.Test;

import razas.terran.construcciones.ConstruccionTerran;
import razas.terran.construcciones.PuertoEstelar;

public class PuertoEstelar_Test {

	@Test
	public void VidaInicializada() {
		ConstruccionTerran f = new PuertoEstelar();
		
		Assert.assertEquals(1300, f.getVida());
	}

}
