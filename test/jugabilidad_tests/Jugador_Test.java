package jugabilidad_tests;

import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import construcciones.comandos.AccionesDisponibles;
import construcciones.comandos.ConstruccionesDisponibles;
import construcciones.comandos.terran.accionesDeEdficio.AccionEntrenarMarine;
import excepciones.ExcepcionRecursosInsuficientes;
import auxiliares.Recursos;
import razas.Protoss;
import razas.Terran;
import jugabilidad.Jugador;

public class Jugador_Test {
	
	// TERRAN
	
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
		
		Assert.assertEquals(jugador1.buscarUnidadCreada("marine").getNombre(),"marine");
		
	}
	
	
	@Test
	public void NoSeCreaMarinePorqueJugadorNoTeniaRecursosSuficientes(){
		Jugador jugador1 = new Jugador(new Terran(),new Recursos(250,0));
		jugador1.construir(ConstruccionesDisponibles.DEPOSITODESUMINISTROS);
		jugador1.construir(ConstruccionesDisponibles.BARRACA);

		jugador1.buscarConstruccionCreada("Barraca").accionesDeEdificio(jugador1, AccionesDisponibles.EntrenarMarine);
		

		Assert.assertEquals(jugador1.buscarUnidadCreada("marine"),null);
	}
	@Test
	public void NoSeCreaMarinePorqueJugadorNoTeniaSuministrosSuficientes(){
		Jugador jugador1 = new Jugador(new Terran(),new Recursos(200,0));
		
		jugador1.construir(ConstruccionesDisponibles.BARRACA);

		jugador1.buscarConstruccionCreada("Barraca").accionesDeEdificio(jugador1, AccionesDisponibles.EntrenarMarine);
		

		Assert.assertEquals(jugador1.buscarUnidadCreada("marine"),null);
	}
	@Test
	public void CreaUnMarinePeroOtroNoPorqueJugadorNoTieneSuministrosSuficientes(){
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
	public void CreoPilonYAumentaPoblacionMaxima(){
		Jugador jugador1 = new Jugador(new Protoss(),new Recursos(400,0));
		
		jugador1.construir(ConstruccionesDisponibles.PILON);
		jugador1.construir(ConstruccionesDisponibles.PILON);
		jugador1.construir(ConstruccionesDisponibles.PILON);
		
		Assert.assertEquals(15,jugador1.getSuministrosMaximos());
	}
}
