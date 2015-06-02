package construcciones.protoss_tests;

import org.junit.Assert;
import org.junit.Test;

import razas.protoss.construcciones.ArchivosTemplarios;
import razas.protoss.construcciones.ConstruccionProtoss;

public class ArchivosTemplarios_Test {

	@Test
	public void VidaInicializada() {
		ConstruccionProtoss a = new ArchivosTemplarios();
		
		Assert.assertEquals(500, a.getVida());
		Assert.assertEquals(500, a.getEscudo());
	}
}
