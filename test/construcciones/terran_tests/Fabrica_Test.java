package construcciones.terran_tests;

import modelo.construcciones.terran.Fabrica;
import org.junit.Assert;
import org.junit.Test;

public class Fabrica_Test {

	@Test
	public void VidaInicializada() {
		Fabrica f = new Fabrica();
		
		Assert.assertEquals(1250, f.getVida());
	}


}
