package construccionesTerran_tests;

import org.junit.Assert;
import org.junit.Test;

import construccionesTerran.PuertoEstelar;
import construccionesTerran.ConstruccionTerran;

public class PuertoEstelar_tests {

	@Test
	public void VidaInicializada() {
		ConstruccionTerran f = new PuertoEstelar();
		
		Assert.assertEquals(250, f.getVida());
	}

}
