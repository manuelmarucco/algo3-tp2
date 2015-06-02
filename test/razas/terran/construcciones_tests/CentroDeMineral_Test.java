package razas.terran.construcciones_tests;

import jugabilidad.auxiliares.Recursos;

import org.junit.Assert;
import org.junit.Test;

import razas.terran.construcciones.CentroDeMineral;
import razas.terran.construcciones.ConstruccionTerran;

public class CentroDeMineral_Test {

	@Test
	public void VidaInicializada() {
		ConstruccionTerran r = new CentroDeMineral(new Recursos(0,0));
		
		Assert.assertEquals(500, r.getVida());
	}

}
