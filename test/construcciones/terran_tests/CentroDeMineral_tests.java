package construcciones.terran_tests;

import auxiliares.Recursos;
import org.junit.Assert;
import org.junit.Test;

import construcciones.terran.CentroDeMineral;
import construcciones.terran.ConstruccionTerran;

public class CentroDeMineral_tests {

	@Test
	public void VidaInicializada() {
		Recursos rec = new Recursos(0,0);
		ConstruccionTerran r = new CentroDeMineral(rec);
		
		Assert.assertEquals(150, r.getVida().getVidaActual());
	}
	
	@Test
	public void recoletaGasVespeno() {
		Recursos rec = new Recursos(0,0);
		CentroDeMineral r = new CentroDeMineral(rec);
		r.update();
		Assert.assertEquals(10, rec.getMinerales());
		//Assert.assertNotEquals(0, r.getMineralRecolectado()); <- ant no compila
	}


}
