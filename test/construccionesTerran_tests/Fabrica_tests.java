package construccionesTerran_tests;

import org.junit.Assert;
import org.junit.Test;

import construccionesTerran.Fabrica;
import construccionesTerran.ConstruccionTerran;

public class Fabrica_tests {

	@Test
	public void VidaInicializada() {
		ConstruccionTerran f = new Fabrica();
		
		Assert.assertEquals(250, f.getVida());
	}


}
