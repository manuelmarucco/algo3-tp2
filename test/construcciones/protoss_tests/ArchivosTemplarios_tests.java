package construcciones.protoss_tests;

import org.junit.Assert;
import org.junit.Test;

import construcciones.protoss.ArchivosTemplarios;
import construcciones.protoss.ConstruccionProtoss;

public class ArchivosTemplarios_tests {

	@Test
	public void VidaInicializada() {
		ConstruccionProtoss a = new ArchivosTemplarios();
		
		Assert.assertEquals(500, a.getVida());
		Assert.assertEquals(500, a.getEscudo());
	}
}
