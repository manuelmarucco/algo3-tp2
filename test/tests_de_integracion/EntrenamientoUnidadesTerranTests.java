package tests_de_integracion;

import jugabilidad.Jugador;
import jugabilidad.auxiliares.Recursos;

import org.junit.Assert;
import org.junit.Test;

import razas.Terran;

public class EntrenamientoUnidadesTerranTests {

	@Test
	public void entrenoMarineYSeAgregaAlJugador() {
		Jugador j = new Jugador(new Terran(),new Recursos(1000,0));
		Barraca b = new Barraca(j);
		
		
	}

}
