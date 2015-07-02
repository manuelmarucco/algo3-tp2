package construcciones.terran_tests;

import modelo.construcciones.terran.Refineria;
import modelo.jugabilidad.auxiliares.Recursos;
import org.junit.Assert;
import org.junit.Test;

public class Refineria_Test {

	@Test
	public void VidaInicializada() {
		Refineria r = new Refineria(new Recursos(0,0));
		
		Assert.assertEquals(750, r.getVida());
	}

}
