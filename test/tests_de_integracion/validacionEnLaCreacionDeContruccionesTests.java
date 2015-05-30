package tests_de_integracion;

import org.junit.Assert;
import jugabilidad.Jugador;

import org.junit.Test;

import construcciones.terran.BaseTerran;

public class validacionEnLaCreacionDeContruccionesTests {

	@Test
	public void construyoBarracaYSeGuardaEnConstruccionesCreadas() {
		BaseTerran base = new BaseTerran();
		Jugador jugador1 = new Jugador();
		
		jugador1.construir(base.construirBarraca());
		
		Assert.assertEquals((jugador1.buscarConstruccionCreada("barraca")).getNombre(), "barraca");
	}

}
