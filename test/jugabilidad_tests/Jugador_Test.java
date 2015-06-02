package jugabilidad_tests;

import org.junit.Assert;
import org.junit.Test;

import construcciones.comandos.AccionesDisponibles;
import construcciones.comandos.ConstruccionesDisponibles;
import auxiliares.Recursos;
import razas.Terran;
import jugabilidad.Jugador;

public class Jugador_Test {

	@Test
	public void CreoDepositosDeSuministrosYAumentaPoblacionMaxima(){
		Jugador jugador1 = new Jugador(new Terran(),new Recursos(400,0));
		
		jugador1.construir(ConstruccionesDisponibles.DEPOSITODESUMINISTROS);
		jugador1.construir(ConstruccionesDisponibles.DEPOSITODESUMINISTROS);
		jugador1.construir(ConstruccionesDisponibles.DEPOSITODESUMINISTROS);
		
		Assert.assertEquals(15,jugador1.getPoblacionMaxima());
	}
	
	@Test
	public void JugadorCreaUnaBarracaYUnMarine(){
		Jugador jugador1 = new Jugador(new Terran(),new Recursos(400,0));

		jugador1.construir(ConstruccionesDisponibles.DEPOSITODESUMINISTROS);
		jugador1.construir(ConstruccionesDisponibles.BARRACA);
		jugador1.buscarConstruccionCreada("Barraca").accionesDeEdificio(jugador1, AccionesDisponibles.EntrenarMarine);
		
		Assert.assertEquals(jugador1.buscarUnidadCreada("marine").getNombre(),"marine");
		
	}
}
