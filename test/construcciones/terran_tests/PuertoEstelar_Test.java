package construcciones.terran_tests;

import construcciones.terran.PuertoEstelar;
import org.junit.Assert;
import org.junit.Test;

public class PuertoEstelar_Test {

	@Test
	public void VidaInicializada() {
		PuertoEstelar f = new PuertoEstelar();
		
		Assert.assertEquals(1300, f.getVida());
	}

}
