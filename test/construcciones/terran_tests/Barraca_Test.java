package construcciones.terran_tests;

import construcciones.terran.Barraca;
import org.junit.Assert;
import org.junit.Test;

public class Barraca_Test {
	
	@Test
	public void VidaInicializada() {
		Barraca b = new Barraca();
		
		Assert.assertEquals(1000, b.getVida());
	}


}
