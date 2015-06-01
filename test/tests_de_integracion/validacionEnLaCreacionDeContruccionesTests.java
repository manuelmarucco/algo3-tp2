package tests_de_integracion;

import org.junit.Assert;

import jugabilidad.Jugador;

import org.junit.Test;

import auxiliares.Recursos;
import razas.Terran;
import construcciones.comandos.ConstruccionesDisponibles;
import construcciones.protoss.BaseProtoss;
import construcciones.terran.BaseTerran;

public class validacionEnLaCreacionDeContruccionesTests {

	@Test
	public void construyoBarracaYSeGuardaEnConstruccionesCreadas() {
		Jugador jugador1 = new Jugador(new Terran(),new Recursos(400,400));
		
		jugador1.construir(((jugador1.getRaza()).getComandos()).get(ConstruccionesDisponibles.BARRACA).accionConstruir());
		
		Assert.assertEquals((jugador1.buscarConstruccionCreada("Barraca")).getNombre(), "Barraca");
	}
	
	@Test
	public void PuedeConstruirFabrica() {
		Jugador jugador1 = new Jugador(new Terran(),new Recursos(400,400));

		jugador1.construir(((jugador1.getRaza()).getComandos()).get(ConstruccionesDisponibles.BARRACA).accionConstruir());
		jugador1.construir(((jugador1.getRaza()).getComandos()).get(ConstruccionesDisponibles.FABRICA).accionConstruir());
		
		Assert.assertEquals(jugador1.buscarConstruccionCreada("Fabrica").getNombre(), "Fabrica");
	}
	
	@Test
	public void TrataDeConstruirFabricaPeroSinBarracaAntesNoSeConstruye() {
		Jugador jugador1 = new Jugador(new Terran(),new Recursos(400,0));

		jugador1.construir(((jugador1.getRaza()).getComandos()).get(ConstruccionesDisponibles.FABRICA).accionConstruir());
		
		Assert.assertEquals(jugador1.buscarConstruccionCreada("Fabrica"), null);
	}
	
	@Test
	public void IntentaConstruirFabricaYComoNoPuedeLosRecursosNoSeGastaron() {
		Jugador jugador1 = new Jugador(new Terran(),new Recursos(400,0));

		jugador1.construir(((jugador1.getRaza()).getComandos()).get(ConstruccionesDisponibles.FABRICA).accionConstruir());
		
		Assert.assertEquals(jugador1.getRecursos().getMinerales(), 400);
		Assert.assertEquals(jugador1.getRecursos().getGasVespeno(), 0);
	}
	
	@Test
	public void PuedeConstruirPuertoEstelar() {
		Jugador jugador1 = new Jugador(new Terran(),new Recursos(400,400));


		jugador1.construir(((jugador1.getRaza()).getComandos()).get(ConstruccionesDisponibles.BARRACA).accionConstruir());
		jugador1.construir(((jugador1.getRaza()).getComandos()).get(ConstruccionesDisponibles.FABRICA).accionConstruir());
		jugador1.construir(((jugador1.getRaza()).getComandos()).get(ConstruccionesDisponibles.PUERTOESTELAR).accionConstruir());
		
		Assert.assertEquals(jugador1.buscarConstruccionCreada("PuertoEstelar").getNombre(), "PuertoEstelar");
	}
	
	@Test
	public void TrataDeConstruirPuertoEstelarPeroSinFabricaAntesNoSeConstruye() {
		Jugador jugador1 = new Jugador();
		BaseTerran base = new BaseTerran();

		jugador1.construir(base.construirPuertoEstelar());
		
		Assert.assertEquals(jugador1.buscarConstruccionCreada("PuertoEstelar"), null);
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
	public void TrataDeConstruirPortalEstelarPeroSinAccesoAntesNoSeConstruye() {
		Jugador jugador1 = new Jugador();
		BaseProtoss base = new BaseProtoss();

		jugador1.construir(base.construirPortalEstelar());
		
		Assert.assertEquals(jugador1.buscarConstruccionCreada("PortalEstelar"), null);
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
	
	@Test
	public void TrataDeConstruirArchivosTemplariosPeroSinPortalEstelarAntesNoSeConstruye() {
		Jugador jugador1 = new Jugador();
		BaseProtoss base = new BaseProtoss();

		jugador1.construir(base.construirArchivosTemplarios());
		
		Assert.assertEquals(jugador1.buscarConstruccionCreada("ArchivosTemplarios"), null);
	}


}
