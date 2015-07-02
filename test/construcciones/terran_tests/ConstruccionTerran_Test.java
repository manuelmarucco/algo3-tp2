package construcciones.terran_tests;


import modelo.construcciones.terran.Barraca;
import org.junit.Assert;
import org.junit.Test;

public class ConstruccionTerran_Test {

	@Test
	public void UnaConstruccionTerranRecibeDanio() {
		Barraca construccion = new Barraca();
		int vidaAnterior = 0;
		
		vidaAnterior = construccion.getVida();
		
		construccion.recibirDanio(50);
		
		Assert.assertEquals(vidaAnterior - 50, construccion.getVida());
	}
	
	@Test
	public void UnaConstruccionTerranRecibeMasDanioQueSuVida() {
		Barraca construccion = new Barraca();
		
		construccion.recibirDanio(construccion.getVida()+50);
		
		Assert.assertEquals(0, construccion.getVida());
		
	}

}
