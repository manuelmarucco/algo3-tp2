package construccionesTerran_tests;


import org.junit.Assert;
import org.junit.Test;

import construccionesTerran.DepositoDeSuministros;

public class DepositoDeSuministros_tests {
	
	@Test
	public void capacidadExtraInicializada() {
		DepositoDeSuministros d = new DepositoDeSuministros();
		
		Assert.assertEquals(5,d.getCapacidadExtra());
	}
}
