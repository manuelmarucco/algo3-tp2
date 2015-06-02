package razas.terran.construcciones_tests;


import org.junit.Assert;
import org.junit.Test;

import razas.terran.construcciones.Barraca;
import razas.terran.construcciones.ConstruccionTerran;

public class ConstruccionTerran_Test {

	@Test
	public void UnaConstruccionTerranRecibeDanio() {
		ConstruccionTerran construccion = new Barraca();
		int vidaAnterior = 0;
		
		vidaAnterior = construccion.getVida();
		
		construccion.recibirDanio(50);
		
		Assert.assertEquals(vidaAnterior-50, construccion.getVida());
	}
	
	@Test
	public void UnaConstruccionTerranRecibeMasDanioQueSuVida() {
		ConstruccionTerran construccion = new Barraca();
		
		construccion.recibirDanio(construccion.getVida()+50);
		
		Assert.assertEquals(0, construccion.getVida());
		
	}

}
