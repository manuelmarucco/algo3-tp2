package construccionesTerran_tests;

import org.junit.Assert;
import org.junit.Test;

import construccionesTerran.ConstruccionTerran;
import construccionesTerran.Refineria;

public class Refineria_tests {

	@Test
	public void VidaInicializada() {
		ConstruccionTerran r = new Refineria();
		
		Assert.assertEquals(150, r.getVida());
	}

}
