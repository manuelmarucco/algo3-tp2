package construccionesTerran_tests;

import org.junit.Assert;
import org.junit.Test;

import construccionesTerran.ConstruccionTerran;
import construccionesTerran.Fabrica;

public class PuertoEstelar_tests {

	@Test
	public void VidaInicializada() {
		ConstruccionTerran f = new Fabrica();
		
		Assert.assertEquals(250, f.getVida());
	}

}
