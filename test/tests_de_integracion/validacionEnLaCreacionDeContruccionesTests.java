package tests_de_integracion;

import org.junit.Assert;

import jugabilidad.Jugador;

import org.junit.Test;

import construcciones.protoss.BaseProtoss;
import construcciones.terran.BaseTerran;

public class validacionEnLaCreacionDeContruccionesTests {

	@Test
	public void construyoBarracaYSeGuardaEnConstruccionesCreadas() {
		BaseTerran base = new BaseTerran();
		Jugador jugador1 = new Jugador();
		
		jugador1.construir(base.construirBarraca());
		
		Assert.assertEquals((jugador1.buscarConstruccionCreada("Barraca")).getNombre(), "Barraca");
	}
	
	@Test
	public void PuedeConstruirFabrica() {
		Jugador jugador1 = new Jugador();
		BaseTerran base = new BaseTerran();

		jugador1.construir(base.construirBarraca());
		jugador1.construir(base.construirFabrica());
		
		Assert.assertEquals(jugador1.buscarConstruccionCreada("Fabrica").getNombre(), "Fabrica");
	}
	
	@Test
	public void PuedeConstruirPuertoEstelar() {
		Jugador jugador1 = new Jugador();
		BaseTerran base = new BaseTerran();

		jugador1.construir(base.construirBarraca());
		jugador1.construir(base.construirFabrica());
		jugador1.construir(base.construirPuertoEstelar());
		
		Assert.assertEquals(jugador1.buscarConstruccionCreada("PuertoEstelar").getNombre(), "PuertoEstelar");
	}
	
	@Test
	public void PuedeConstruirPortalEstelar() {
		Jugador jugador1 = new Jugador();
		BaseProtoss base = new BaseProtoss();

		jugador1.construir(base.construirAcceso());
		jugador1.construir(base.construirPortalEstelar());
		
		Assert.assertEquals(jugador1.buscarConstruccionCreada("PortalEstelar").getNombre(), "PortalEstelar");
	}
	
	@Test
	public void PuedeConstruirArchivosTemplarios() {
		Jugador jugador1 = new Jugador();
		BaseProtoss base = new BaseProtoss();

		jugador1.construir(base.construirAcceso());
		jugador1.construir(base.construirPortalEstelar());
		jugador1.construir(base.construirArchivosTemplarios());
		
		Assert.assertEquals(jugador1.buscarConstruccionCreada("ArchivosTemplarios").getNombre(), "ArchivosTemplarios");
	}
	
}
