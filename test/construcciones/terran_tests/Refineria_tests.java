package construcciones.terran_tests;

import org.junit.Assert;
import org.junit.Test;

import construcciones.terran.ConstruccionTerran;
import construcciones.terran.Refineria;

public class Refineria_tests {

	@Test
	public void VidaInicializada() {
		ConstruccionTerran r = new Refineria();
		
		Assert.assertEquals(150, r.getVida());
	}
	
	@Test
	public void recoletaGasVespeno() {
		Refineria r = new Refineria();
		
		Assert.assertEquals(10, r.getGasRecolectado());
	}


}
