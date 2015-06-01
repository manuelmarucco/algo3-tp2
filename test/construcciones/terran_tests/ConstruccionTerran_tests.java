package construcciones.terran_tests;


import fiuba.algo3.algocraft.unidades.parametros.Danio;
import org.junit.Assert;

import org.junit.Test;

import construcciones.terran.Barraca;
import construcciones.terran.ConstruccionTerran;

public class ConstruccionTerran_tests {

	@Test
	public void UnaConstruccionTerranRecibeDanio() {
		ConstruccionTerran construccion = new Barraca();
		int vidaAnterior;
		
		vidaAnterior = construccion.getVida().getVidaActual();
		
		construccion.recibirDanio(new Danio(50,20,1));
		
		Assert.assertEquals(vidaAnterior-50, construccion.getVida().getVidaActual());
	}
	
	@Test
	public void UnaConstruccionTerranRecibeMasDanioQueSuVida() {
		ConstruccionTerran construccion = new Barraca();
		
		construccion.recibirDanio(new Danio(construccion.getVida().getVidaActual()+50,0,0));
		
		Assert.assertEquals(0, construccion.getVida().getVidaActual());
		
	}

}
