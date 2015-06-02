package tests_de_integracion;

import jugabilidad.Jugador;

import org.junit.Assert;
import org.junit.Test;

import construcciones.comandos.ConstruccionesDisponibles;
import razas.Terran;
import auxiliares.Recursos;

public class RecolectarRecursosJugadorTests {
	
	@Test
	public void RecolectarRecursos(){
		Jugador jugador = new Jugador(new Terran(),new Recursos(150,0));
		
		jugador.construir(ConstruccionesDisponibles.CENTRODEMINERAL);
		jugador.construir(ConstruccionesDisponibles.REFINERIA);

		jugador.update();
		
		Assert.assertEquals(10,jugador.getRecursos().getMinerales());
		Assert.assertEquals(10,jugador.getRecursos().getGasVespeno());
		
	}
}
