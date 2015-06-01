package construcciones.protoss_tests;

import org.junit.Assert;
import org.junit.Test;

import construcciones.protoss.ArchivosTemplarios;
import construcciones.protoss.ConstruccionProtoss;

public class ArchivosTemplarios_tests {

	@Test
	public void VidaInicializada() {
		ConstruccionProtoss f = new ArchivosTemplarios();
		
		Assert.assertEquals(150, f.getVida().getVidaActual());
	}
	
	@Test
	public void EscudoInicializado() {
		ArchivosTemplarios f = new ArchivosTemplarios();
		
		Assert.assertEquals(50, f.getEscudo());
	}

}
