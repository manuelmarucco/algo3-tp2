package construccionesProtoss_tests;

import org.junit.Assert;
import org.junit.Test;

import construccionesProtoss.Asimilador;
import construccionesProtoss.ConstruccionProtoss;

public class Asimilador_tests {

	@Test
	public void VidaInicializada() {
		ConstruccionProtoss a = new Asimilador();
		
		Assert.assertEquals(150, a.getVida());
	}
	
	@Test
	public void EscudoInicializado() {
		ConstruccionProtoss a = new Asimilador();
		
		Assert.assertEquals(50, a.getEscudo());
	}
	
	@Test
	public void recoletaGasVespeno() {
		Asimilador a = new Asimilador();
		
		Assert.assertEquals(10, a.getGasRecolectado());
	}


}
