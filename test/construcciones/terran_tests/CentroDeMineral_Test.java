package construcciones.terran_tests;

import modelo.construcciones.terran.CentroDeMineral;
import modelo.jugabilidad.auxiliares.Recursos;
import org.junit.Assert;
import org.junit.Test;

public class CentroDeMineral_Test {

	@Test
	public void VidaInicializada() {
		CentroDeMineral r = new CentroDeMineral(new Recursos(0,0));
		
		Assert.assertEquals(500, r.getVida());
	}

}
