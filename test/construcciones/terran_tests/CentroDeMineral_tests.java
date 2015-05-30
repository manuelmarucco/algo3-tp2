package construcciones.terran_tests;


import org.junit.Assert;
import org.junit.Test;

import construcciones.terran.CentroDeMineral;
import construcciones.terran.ConstruccionTerran;

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
