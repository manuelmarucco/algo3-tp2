package tests_de_integracion;

import manejoDeConstrucciones.comandos.ConstruccionesDisponibles;

import org.junit.Assert;

import jugabilidad.Jugador;
import jugabilidad.auxiliares.Recursos;

import org.junit.Test;

import razas.Protoss;
import razas.Terran;
public class validacionEnLaCreacionDeContruccionesTest {

	@Test
	public void ConstruyeRefineria() {
		Jugador jugador1 = new Jugador(new Terran(),new Recursos(400,0));

		jugador1.construir(ConstruccionesDisponibles.REFINERIA);
		
		Assert.assertEquals(jugador1.buscarConstruccionCreada("Refineria").getNombre(), "Refineria");
	}
	
	@Test
	public void ConstruyeCentroDeMineral() {
		Jugador jugador1 = new Jugador(new Terran(),new Recursos(400,0));

		jugador1.construir(ConstruccionesDisponibles.CENTRODEMINERAL);
		
		Assert.assertEquals(jugador1.buscarConstruccionCreada("CentroDeMineral").getNombre(), "CentroDeMineral");
	}
	
	@Test
	public void construyoBarracaYSeGuardaEnConstruccionesCreadas() {
		Jugador jugador1 = new Jugador(new Terran(),new Recursos(400,400));
		
		jugador1.construir(ConstruccionesDisponibles.BARRACA);
		
		Assert.assertEquals((jugador1.buscarConstruccionCreada("Barraca")).getNombre(), "Barraca");
	}
	
	@Test
	public void PuedeConstruirFabrica() {
		Jugador jugador1 = new Jugador(new Terran(),new Recursos(400,400));

		jugador1.construir(ConstruccionesDisponibles.BARRACA);
		jugador1.construir(ConstruccionesDisponibles.FABRICA);
		
		Assert.assertEquals(jugador1.buscarConstruccionCreada("Fabrica").getNombre(), "Fabrica");
	}
	
	@Test
	public void TrataDeConstruirFabricaPeroSinBarracaAntesNoSeConstruye() {
		Jugador jugador1 = new Jugador(new Terran(),new Recursos(400,0));

		jugador1.construir(ConstruccionesDisponibles.FABRICA);
		
		Assert.assertEquals(jugador1.buscarConstruccionCreada("Fabrica"), null);
	}
	
	@Test
	public void IntentaConstruirFabricaYComoNoPuedeLosRecursosNoSeGastaron() {
		Jugador jugador1 = new Jugador(new Terran(),new Recursos(400,0));

		jugador1.construir(ConstruccionesDisponibles.FABRICA);
		
		Assert.assertEquals(jugador1.getRecursos().getMinerales(), 400);
		Assert.assertEquals(jugador1.getRecursos().getGasVespeno(), 0);
	}
	
	@Test
	public void PuedeConstruirPuertoEstelar() {
		Jugador jugador1 = new Jugador(new Terran(),new Recursos(700,400));


		jugador1.construir(ConstruccionesDisponibles.BARRACA);
		jugador1.construir(ConstruccionesDisponibles.FABRICA);
		jugador1.construir(ConstruccionesDisponibles.PUERTOESTELAR);
		
		Assert.assertEquals(jugador1.buscarConstruccionCreada("PuertoEstelar").getNombre(), "PuertoEstelar");
	}
	
	@Test
	public void TrataDeConstruirPuertoEstelarPeroSinFabricaAntesNoSeConstruye() {
		Jugador jugador1 = new Jugador(new Terran(),new Recursos(700,400));

		jugador1.construir(ConstruccionesDisponibles.BARRACA);
		jugador1.construir(ConstruccionesDisponibles.PUERTOESTELAR);
		
		Assert.assertEquals(jugador1.buscarConstruccionCreada("PuertoEstelar"), null);
	}
	
	@Test
	public void PuedeConstruirPortalEstelar() {
		Jugador jugador1 = new Jugador(new Protoss(),new Recursos(700,400));

		jugador1.construir(ConstruccionesDisponibles.ACCESO);
		jugador1.construir(ConstruccionesDisponibles.PORTALESTELAR);
		
		Assert.assertEquals(jugador1.buscarConstruccionCreada("PortalEstelar").getNombre(), "PortalEstelar");
	}
	
	@Test
	public void TrataDeConstruirPortalEstelarPeroSinAccesoAntesNoSeConstruye() {
		Jugador jugador1 = new Jugador(new Protoss(),new Recursos(700,400));

		jugador1.construir(ConstruccionesDisponibles.PORTALESTELAR);
		
		Assert.assertEquals(jugador1.buscarConstruccionCreada("PortalEstelar"), null);
	}
	
	
	@Test
	public void PuedeConstruirArchivosTemplarios() {
		Jugador jugador1 = new Jugador(new Protoss(),new Recursos(700,400));

		jugador1.construir(ConstruccionesDisponibles.ACCESO);
		jugador1.construir(ConstruccionesDisponibles.PORTALESTELAR);
		jugador1.construir(ConstruccionesDisponibles.ARCHIVOSTEMPLARIOS);
		
		Assert.assertEquals(jugador1.buscarConstruccionCreada("ArchivosTemplarios").getNombre(), "ArchivosTemplarios");
	}
	
	@Test
	public void TrataDeConstruirArchivosTemplariosPeroSinPortalEstelarAntesNoSeConstruye() {
		Jugador jugador1 = new Jugador(new Protoss(),new Recursos(700,400));

		jugador1.construir(ConstruccionesDisponibles.ARCHIVOSTEMPLARIOS);
		
		Assert.assertEquals(jugador1.buscarConstruccionCreada("ArchivosTemplarios"), null);
	}


}
