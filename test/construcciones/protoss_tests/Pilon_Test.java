package construcciones.protoss_tests;

import jugabilidad.Jugador;
import jugabilidad.auxiliares.Recursos;

import org.junit.Assert;
import org.junit.Test;

import razas.Protoss;
import construcciones.protoss.ConstruccionProtoss;
import construcciones.protoss.Pilon;

public class Pilon_Test {
	@Test
	public void VidaEscudoInicializado() {
		ConstruccionProtoss a = new Pilon(new Jugador(new Protoss(),new Recursos(100,100)));
		

		Assert.assertEquals(300, a.getVida());
		Assert.assertEquals(300, a.getEscudo());
	}
	
	@Test
	public void capacidadExtraInicializada() {
		Pilon p = new Pilon(new Jugador(new Protoss(),new Recursos(100,100)));
		
		Assert.assertEquals(5,p.getCapacidadExtra());
	}
	
}
