package construccionesTerran_tests;

import org.junit.Assert;

import org.junit.Test;

import construccionesTerran.*;

public class Barraca_tests {
	
	@Test
	public void VidaInicializada() {
		ConstruccionTerran b = new Barraca();
		
		Assert.assertEquals(250, b.getVida());
	}

	@Test
	public void creoMarineYEsMarine() {
		
	}

}
