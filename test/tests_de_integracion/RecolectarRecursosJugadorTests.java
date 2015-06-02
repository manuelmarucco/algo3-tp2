package tests_de_integracion;

import jugabilidad.Jugador;

import org.junit.Assert;
import org.junit.Test;

import construcciones.comandos.ConstruccionesDisponibles;
import razas.Protoss;
import razas.Terran;
import auxiliares.Recursos;

public class RecolectarRecursosJugadorTests {
	
	@Test
	public void RecolectarRecursosTerran(){
		Jugador jugador = new Jugador(new Terran(),new Recursos(150,0));
		
		jugador.construir(ConstruccionesDisponibles.CENTRODEMINERAL);
		jugador.construir(ConstruccionesDisponibles.REFINERIA);

		jugador.update();
		
		Assert.assertEquals(10,jugador.getRecursos().getMinerales());
		Assert.assertEquals(10,jugador.getRecursos().getGasVespeno());
		
	}
	
	@Test
	public void RecolectarRecursosProtoss(){
		Jugador jugador = new Jugador(new Protoss(),new Recursos(150,0));
		
		jugador.construir(ConstruccionesDisponibles.NEXOMINERAL);
		jugador.construir(ConstruccionesDisponibles.ASIMILADOR);

		jugador.update();
		
		Assert.assertEquals(10,jugador.getRecursos().getMinerales());
		Assert.assertEquals(10,jugador.getRecursos().getGasVespeno());
		
	}
}
