package razas.protoss.construcciones_tests;

import jugabilidad.auxiliares.Recursos;

import org.junit.Assert;
import org.junit.Test;

import razas.protoss.construcciones.Asimilador;
import razas.protoss.construcciones.ConstruccionProtoss;

public class Asimilador_Test {

	@Test
	public void VidaInicializada() {
		ConstruccionProtoss a = new Asimilador(new Recursos(0,0));

		Assert.assertEquals(450, a.getVida());
		Assert.assertEquals(450, a.getEscudo());
		}
	


}
