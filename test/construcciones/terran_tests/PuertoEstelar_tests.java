package construcciones.terran_tests;

import org.junit.Assert;
import org.junit.Test;

import construcciones.terran.ConstruccionTerran;
import construcciones.terran.PuertoEstelar;

public class PuertoEstelar_tests {

	@Test
	public void VidaInicializada() {
		ConstruccionTerran f = new PuertoEstelar();
		
		Assert.assertEquals(250, f.getVida().getVidaActual());
	}

}
