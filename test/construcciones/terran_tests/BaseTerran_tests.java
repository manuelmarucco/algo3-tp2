package construcciones.terran_tests;

import org.junit.Assert;
import org.junit.Test;

import construcciones.terran.BaseTerran;

public class BaseTerran_tests {

	@Test
	public void creaUnaBarraca() {
		BaseTerran base = new BaseTerran();
		
		Assert.assertEquals(base.construirBarraca().getNombre(),"Barraca");
		
	}

}
