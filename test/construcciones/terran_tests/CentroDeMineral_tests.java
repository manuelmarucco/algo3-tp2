package construcciones.terran_tests;

import org.junit.Assert;
import org.junit.Test;

import auxiliares.Recursos;
import construcciones.terran.CentroDeMineral;
import construcciones.terran.ConstruccionTerran;

public class CentroDeMineral_tests {

	@Test
	public void VidaInicializada() {
		ConstruccionTerran r = new CentroDeMineral(new Recursos(0,0));
		
		Assert.assertEquals(500, r.getVida());
	}

}
