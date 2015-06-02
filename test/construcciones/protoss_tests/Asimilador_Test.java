package construcciones.protoss_tests;

import jugabilidad.auxiliares.Recursos;

import org.junit.Assert;
import org.junit.Test;

import construcciones.protoss.Asimilador;
import construcciones.protoss.ConstruccionProtoss;

public class Asimilador_Test {

	@Test
	public void VidaInicializada() {
		ConstruccionProtoss a = new Asimilador(new Recursos(0,0));

		Assert.assertEquals(450, a.getVida());
		Assert.assertEquals(450, a.getEscudo());
		}
	


}
