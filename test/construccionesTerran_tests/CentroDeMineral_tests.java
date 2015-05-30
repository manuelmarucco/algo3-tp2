package construccionesTerran_tests;


import org.junit.Assert;
import org.junit.Test;

import construccionesTerran.CentroDeMineral;
import construccionesTerran.ConstruccionTerran;

public class CentroDeMineral_tests {

	@Test
	public void VidaInicializada() {
		ConstruccionTerran r = new CentroDeMineral();
		
		Assert.assertEquals(150, r.getVida());
	}
	
	@Test
	public void recoletaGasVespeno() {
		CentroDeMineral r = new CentroDeMineral();
		
		Assert.assertNotEquals(0, r.getMineralRecolectado());
	}

}
