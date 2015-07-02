package construcciones.protoss_tests;

import org.junit.Assert;
import org.junit.Test;

import modelo.construcciones.protoss.ArchivosTemplarios;

public class ArchivosTemplarios_Test {

	@Test
	public void VidaInicializada() {
		ArchivosTemplarios a = new ArchivosTemplarios();
		
		Assert.assertEquals(500, a.getVida());
		Assert.assertEquals(500, a.getEscudo());
	}
}
