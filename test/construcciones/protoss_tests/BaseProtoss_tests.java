package construcciones.protoss_tests;

import org.junit.Assert;
import org.junit.Test;

import construcciones.protoss.BaseProtoss;

public class BaseProtoss_tests {

	@Test
	public void creaUnAcceso() {
		BaseProtoss base = new BaseProtoss();
		
		Assert.assertEquals(base.construirAcceso().getNombre(),"Acceso");
		
	}

}
