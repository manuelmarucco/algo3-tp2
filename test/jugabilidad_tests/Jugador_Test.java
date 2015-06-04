package jugabilidad_tests;

import org.junit.Assert;
import org.junit.Test;

import razas.Terran;
import jugabilidad.Jugador;
import jugabilidad.auxiliares.Recursos;

public class Jugador_Test {
	
	
	
	
	
	// TERRAN
	
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
	public void JugadorCreaTodasLasUnidadesTerranConEdificiosCorrespondientes(){
		Jugador jugador1 = new Jugador(new Terran(),new Recursos(10000,10000));

		jugador1.construir(ConstruccionesDisponibles.DEPOSITODESUMINISTROS);
		jugador1.construir(ConstruccionesDisponibles.DEPOSITODESUMINISTROS);
		jugador1.construir(ConstruccionesDisponibles.BARRACA);
		jugador1.construir(ConstruccionesDisponibles.FABRICA);
		jugador1.construir(ConstruccionesDisponibles.PUERTOESTELAR);

		jugador1.buscarConstruccionCreada("Barraca").accionesDeEdificio(jugador1, AccionesDisponibles.EntrenarMarine);
		jugador1.buscarConstruccionCreada("Fabrica").accionesDeEdificio(jugador1, AccionesDisponibles.EntrenarGolliat);
		jugador1.buscarConstruccionCreada("PuertoEstelar").accionesDeEdificio(jugador1, AccionesDisponibles.EntrenarEspectro);
		jugador1.buscarConstruccionCreada("PuertoEstelar").accionesDeEdificio(jugador1, AccionesDisponibles.EntrenarNaveDeTransporte);
		jugador1.buscarConstruccionCreada("PuertoEstelar").accionesDeEdificio(jugador1, AccionesDisponibles.EntrenarNaveDeCiencia);
		

		Assert.assertEquals(jugador1.buscarUnidadCreada("Marine").getNombre(),"Marine");
		Assert.assertEquals(jugador1.buscarUnidadCreada("Golliat").getNombre(),"Golliat");
		Assert.assertEquals(jugador1.buscarUnidadCreada("Espectro").getNombre(),"Espectro");
		Assert.assertEquals(jugador1.buscarUnidadCreada("Nave de transporte").getNombre(),"Nave de transporte");
		Assert.assertEquals(jugador1.buscarUnidadCreada("NaveCiencia").getNombre(),"NaveCiencia");
		
	}
	
	@Test
	public void JugadorQuiereCrearGolliatEnBarracaPeroLaBarracaNoPuede(){
		Jugador jugador1 = new Jugador(new Terran(),new Recursos(1000,1000));

		jugador1.construir(ConstruccionesDisponibles.BARRACA);
		jugador1.construir(ConstruccionesDisponibles.FABRICA);

		jugador1.buscarConstruccionCreada("Fabrica").accionesDeEdificio(jugador1, AccionesDisponibles.EntrenarMarine);

		Assert.assertEquals(jugador1.buscarUnidadCreada("Marine"),null);
	}
	
	
	@Test
	public void CreoDepositosDeSuministrosYAumentaPoblacionMaxima(){
		Jugador jugador1 = new Jugador(new Terran(),new Recursos(400,0));
		
		jugador1.construir(ConstruccionesDisponibles.DEPOSITODESUMINISTROS);
		jugador1.construir(ConstruccionesDisponibles.DEPOSITODESUMINISTROS);
		jugador1.construir(ConstruccionesDisponibles.DEPOSITODESUMINISTROS);
		
		Assert.assertEquals(15,jugador1.getSuministrosMaximos());
	}
	
	@Test
	public void JugadorCreaUnaBarracaYUnMarine(){
		Jugador jugador1 = new Jugador(new Terran(),new Recursos(400,0));

		jugador1.construir(ConstruccionesDisponibles.DEPOSITODESUMINISTROS);
		jugador1.construir(ConstruccionesDisponibles.BARRACA);
		jugador1.buscarConstruccionCreada("Barraca").accionesDeEdificio(jugador1, AccionesDisponibles.EntrenarMarine);
		
		Assert.assertEquals(jugador1.buscarUnidadCreada("Marine").getNombre(),"Marine");
		
	}
	
	
	@Test
	public void NoSeCreaMarinePorqueJugadorNoTeniaRecursosSuficientes(){
		Jugador jugador1 = new Jugador(new Terran(),new Recursos(250,0));
		jugador1.construir(ConstruccionesDisponibles.DEPOSITODESUMINISTROS);
		jugador1.construir(ConstruccionesDisponibles.BARRACA);

		jugador1.buscarConstruccionCreada("Barraca").accionesDeEdificio(jugador1, AccionesDisponibles.EntrenarMarine);
		

		Assert.assertEquals(jugador1.buscarUnidadCreada("Marine"),null);
	}
	@Test
	public void NoSeCreaMarinePorqueJugadorNoTeniaSuministrosSuficientes(){
		Jugador jugador1 = new Jugador(new Terran(),new Recursos(200,0));
		
		jugador1.construir(ConstruccionesDisponibles.BARRACA);

		jugador1.buscarConstruccionCreada("Barraca").accionesDeEdificio(jugador1, AccionesDisponibles.EntrenarMarine);
		

		Assert.assertEquals(jugador1.buscarUnidadCreada("Marine"),null);
	}
	@Test
	public void Crea5MarinePeroOtroNoPorqueJugadorNoTieneSuministrosSuficientes(){
		Jugador jugador1 = new Jugador(new Terran(),new Recursos(1000,0));

		jugador1.construir(ConstruccionesDisponibles.DEPOSITODESUMINISTROS);
		jugador1.construir(ConstruccionesDisponibles.BARRACA);

		jugador1.buscarConstruccionCreada("Barraca").accionesDeEdificio(jugador1, AccionesDisponibles.EntrenarMarine);
		jugador1.buscarConstruccionCreada("Barraca").accionesDeEdificio(jugador1, AccionesDisponibles.EntrenarMarine);
		jugador1.buscarConstruccionCreada("Barraca").accionesDeEdificio(jugador1, AccionesDisponibles.EntrenarMarine);
		jugador1.buscarConstruccionCreada("Barraca").accionesDeEdificio(jugador1, AccionesDisponibles.EntrenarMarine);
		jugador1.buscarConstruccionCreada("Barraca").accionesDeEdificio(jugador1, AccionesDisponibles.EntrenarMarine);
		jugador1.buscarConstruccionCreada("Barraca").accionesDeEdificio(jugador1, AccionesDisponibles.EntrenarMarine); //6 marines
		

		Assert.assertEquals(5,jugador1.getSuministrosUsados());
	}
	
	// PROTOSS
	
	@Test
	public void RecolectarRecursosProtoss(){
		Jugador jugador = new Jugador(new Protoss(),new Recursos(150,0));
		
		jugador.construir(ConstruccionesDisponibles.NEXOMINERAL);
		jugador.construir(ConstruccionesDisponibles.ASIMILADOR);

		jugador.update();
		
		Assert.assertEquals(10,jugador.getRecursos().getMinerales());
		Assert.assertEquals(10,jugador.getRecursos().getGasVespeno());
		
	}
	
	@Test
	public void CreoPilonYAumentaSuministrosMaximos(){
		Jugador jugador1 = new Jugador(new Protoss(),new Recursos(400,0));
		
		jugador1.construir(ConstruccionesDisponibles.PILON);
		jugador1.construir(ConstruccionesDisponibles.PILON);
		jugador1.construir(ConstruccionesDisponibles.PILON);
		
		Assert.assertEquals(15,jugador1.getSuministrosMaximos());
	}
	
	@Test
	public void CreaDosZealotPeroOtroNoPorqueJugadorNoTieneSuministrosSuficientes(){
		Jugador jugador1 = new Jugador(new Protoss(),new Recursos(1000,0));

		jugador1.construir(ConstruccionesDisponibles.PILON);
		jugador1.construir(ConstruccionesDisponibles.ACCESO);

		jugador1.buscarConstruccionCreada("Acceso").accionesDeEdificio(jugador1, AccionesDisponibles.EntrenarZealot);
		jugador1.buscarConstruccionCreada("Acceso").accionesDeEdificio(jugador1, AccionesDisponibles.EntrenarZealot);
		jugador1.buscarConstruccionCreada("Acceso").accionesDeEdificio(jugador1, AccionesDisponibles.EntrenarZealot);
		

		Assert.assertEquals(4,jugador1.getSuministrosUsados());


	}
	
	@Test
	public void JugadorCreaTodasLasUnidadesProtossConEdificiosCorrespondientes(){
		Jugador jugador1 = new Jugador(new Protoss(),new Recursos(10000,10000));

		jugador1.construir(ConstruccionesDisponibles.PILON);
		jugador1.construir(ConstruccionesDisponibles.PILON);
		jugador1.construir(ConstruccionesDisponibles.PILON);
		jugador1.construir(ConstruccionesDisponibles.ACCESO);
		jugador1.construir(ConstruccionesDisponibles.PORTALESTELAR);
		jugador1.construir(ConstruccionesDisponibles.ARCHIVOSTEMPLARIOS);

		jugador1.buscarConstruccionCreada("Acceso").accionesDeEdificio(jugador1, AccionesDisponibles.EntrenarZealot);
		jugador1.buscarConstruccionCreada("Acceso").accionesDeEdificio(jugador1, AccionesDisponibles.EntrenarDragon);
		jugador1.buscarConstruccionCreada("PortalEstelar").accionesDeEdificio(jugador1, AccionesDisponibles.EntrenarScout);
		jugador1.buscarConstruccionCreada("PortalEstelar").accionesDeEdificio(jugador1, AccionesDisponibles.EntrenarNaveDeTransporte);
		jugador1.buscarConstruccionCreada("ArchivosTemplarios").accionesDeEdificio(jugador1, AccionesDisponibles.EntrenarAltoTemplario);
		

		Assert.assertEquals(jugador1.buscarUnidadCreada("Zealot").getNombre(),"Zealot");
		Assert.assertEquals(jugador1.buscarUnidadCreada("Dragon").getNombre(),"Dragon");
		Assert.assertEquals(jugador1.buscarUnidadCreada("Scout").getNombre(),"Scout");
		Assert.assertEquals(jugador1.buscarUnidadCreada("Nave de Transporte").getNombre(),"Nave de Transporte");
		Assert.assertEquals(jugador1.buscarUnidadCreada("Alto Templario").getNombre(),"Alto Templario");
		
	}
}
