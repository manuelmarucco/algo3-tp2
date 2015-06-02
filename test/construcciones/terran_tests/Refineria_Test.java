package construcciones.terran_tests;

import org.junit.Assert;
import org.junit.Test;

import auxiliares.Recursos;
import construcciones.terran.ConstruccionTerran;
import construcciones.terran.Refineria;

public class Refineria_Test {

	@Test
	public void VidaInicializada() {
		ConstruccionTerran r = new Refineria(new Recursos(0,0));
		
		Assert.assertEquals(750, r.getVida());
	}

}
