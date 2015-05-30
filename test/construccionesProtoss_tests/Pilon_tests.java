package construccionesProtoss_tests;

import org.junit.Assert;
import org.junit.Test;

import construccionesProtoss.Pilon;

public class Pilon_tests {
	@Test
	public void capacidadExtraInicializada() {
		Pilon p = new Pilon();
		
		Assert.assertEquals(5,p.getCapacidadExtra());
	}
}
