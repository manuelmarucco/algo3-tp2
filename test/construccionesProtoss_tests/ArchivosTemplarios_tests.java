package construccionesProtoss_tests;

import org.junit.Assert;
import org.junit.Test;

import construccionesProtoss.ArchivosTemplarios;
import construccionesProtoss.ConstruccionProtoss;

public class ArchivosTemplarios_tests {

	@Test
	public void VidaInicializada() {
		ConstruccionProtoss f = new ArchivosTemplarios();
		
		Assert.assertEquals(150, f.getVida());
	}
	
	@Test
	public void EscudoInicializado() {
		ArchivosTemplarios f = new ArchivosTemplarios();
		
		Assert.assertEquals(150, f.getVida());
	}

}
