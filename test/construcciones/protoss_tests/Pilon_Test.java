package construcciones.protoss_tests;

import jugabilidad.Jugador;
import jugabilidad.RazaDeJugador.JugadorProtoss;
import jugabilidad.auxiliares.Recursos;

import jugabilidad.auxiliares.Suministros;
import org.junit.Assert;
import org.junit.Test;
import construcciones.protoss.Pilon;

public class Pilon_Test {
	@Test
	public void VidaEscudoInicializado() {
		Pilon a = new Pilon(new Suministros());
		

		Assert.assertEquals(300, a.getVida());
		Assert.assertEquals(300, a.getEscudo());
	}
	
	@Test
	public void capacidadExtraInicializada() {
		Pilon p = new Pilon(new Suministros());
		
		Assert.assertEquals(5,p.getCapacidadExtra());
	}
	
}
