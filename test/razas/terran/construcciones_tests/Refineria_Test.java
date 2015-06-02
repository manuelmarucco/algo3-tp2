package razas.terran.construcciones_tests;

import jugabilidad.auxiliares.Recursos;

import org.junit.Assert;
import org.junit.Test;

import razas.terran.construcciones.ConstruccionTerran;
import razas.terran.construcciones.Refineria;

public class Refineria_Test {

	@Test
	public void VidaInicializada() {
		ConstruccionTerran r = new Refineria(new Recursos(0,0));
		
		Assert.assertEquals(750, r.getVida());
	}

}
