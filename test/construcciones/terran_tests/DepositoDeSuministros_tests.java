package construcciones.terran_tests;


import org.junit.Assert;
import org.junit.Test;

import construcciones.terran.CentroDeMineral;
import construcciones.terran.ConstruccionTerran;
import construcciones.terran.DepositoDeSuministros;

public class DepositoDeSuministros_tests {
	
	@Test
	public void VidaInicializada() {
		ConstruccionTerran r = new CentroDeMineral();
		
		Assert.assertEquals(500, r.getVida());
	}
	
	
	@Test
	public void capacidadExtraInicializada() {
		DepositoDeSuministros d = new DepositoDeSuministros();
		
		Assert.assertEquals(5,d.getCapacidadExtra());
	}
}
