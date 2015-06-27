package jugabilidad_tests;

import construcciones.terran.Barraca;
import excepciones.Mapa.ExcepcionNoSePudoAgregarAlMapa;
import excepciones.Mapa.ExcepcionPosicionOcupada;
import interfaces.ColocableEnMapa;
import jugabilidad.Mapa;
import jugabilidad.utilidadesMapa.Coordenada;
import org.junit.Test;
import recursos.Cristal;
import unidades.protoss.NaveTransporteProtoss;
import unidades.terrran.Marine;
import unidades.terrran.NaveCiencia;
import unidades.terrran.NaveTransporteTerran;

import java.util.ArrayList;

import static org.junit.Assert.*;


public class MapaTest {

	@Test
	public void deberiaAgregarUnaBarracaEnLasCoordenadasEspecificadas() throws ExcepcionPosicionOcupada {
		Mapa mapa = new Mapa();

		Coordenada coordenada = new Coordenada(1,2);
		ColocableEnMapa barraca = new Barraca();
		
		mapa.agregarEnCapaTerrestre(barraca, coordenada);
		
		assertEquals( barraca , mapa.obtenerDeCapaTerrestre(coordenada) );
	
	}

	@Test
	public void deberiaAgregarUnaUnidadTerrestreEnLaCapaTerrestre() throws ExcepcionNoSePudoAgregarAlMapa {
		Mapa mapa = new Mapa();

		Coordenada coordenada = new Coordenada(2,2);
		ColocableEnMapa marine = new Marine();

		mapa.agregarEnCapaTerrestre(marine, coordenada);

		assertEquals( marine , mapa.obtenerDeCapaTerrestre(coordenada) );
	}

	@Test
	public void deberiaAgregarUnaNaveCienciaEnLaCapaAerea() throws ExcepcionNoSePudoAgregarAlMapa {

		Mapa mapa = new Mapa();

		Coordenada coordenada = new Coordenada(2,6);
		ColocableEnMapa nave = new NaveCiencia();

		mapa.agregarEnCapaAerea(nave, coordenada);

		assertEquals( nave , mapa.obtenerDeCapaAerea(coordenada) );
	}

	@Test
	public void deberiaAgregarUnaNaveTransporteProtossEnLaCapaAerea() throws ExcepcionNoSePudoAgregarAlMapa {
		Mapa mapa = new Mapa();

		Coordenada coordenada = new Coordenada(2,4);
		ColocableEnMapa nave = new NaveTransporteProtoss();

		mapa.agregarEnCapaAerea(nave, coordenada);

		assertEquals( nave , mapa.obtenerDeCapaAerea(coordenada) );
	}

	@Test
	public void deberiaAgregarUnaNaveTransporteTerranEnLaCapaAerea() throws ExcepcionNoSePudoAgregarAlMapa {
		Mapa mapa = new Mapa();

		Coordenada coordenada = new Coordenada(2,3);
		ColocableEnMapa nave = new NaveTransporteTerran();

		mapa.agregarEnCapaAerea(nave, coordenada);

		assertEquals( nave , mapa.obtenerDeCapaAerea(coordenada) );
	}

	@Test
	public void deberiaAgregarUnRecursoEnLaCapaDeRecursos() throws ExcepcionNoSePudoAgregarAlMapa{

		Mapa mapa = new Mapa();

		Coordenada coordenada = new Coordenada(1,2);
		Cristal cristal = new Cristal();

		mapa.agregarEnCapaDeRecursos(cristal, coordenada);

		assertEquals( cristal , mapa.obtenerDeCapaDeRecursos(coordenada) );

	}

	@Test
	public void siEliminoUnaUnidadTerrestreLasCoordenadasDeEsaUnidadDeberianEstarVacias()
			throws ExcepcionNoSePudoAgregarAlMapa{

		Mapa mapa = new Mapa();

		Coordenada coordenada = new Coordenada(1,2);
		ColocableEnMapa barraca = new Barraca();

		mapa.agregarEnCapaTerrestre(barraca, coordenada);
		mapa.borrarEnCapaTerrestre(coordenada);

		assertFalse(mapa.posicionTerrestreOcupada(coordenada));

	}

	@Test
	public void siEliminoUnaUnidadAereaLasCoordenadasDeEsaUnidadDeberianEstarVacias()
			throws ExcepcionNoSePudoAgregarAlMapa{

		Mapa mapa = new Mapa();

		Coordenada coordenada = new Coordenada(1,2);
		NaveCiencia nave = new NaveCiencia();

		mapa.agregarEnCapaAerea(nave, coordenada);
		mapa.borrarEnCapaAerea(coordenada);

		assertFalse(mapa.posicionAereaOcupada(coordenada));

	}

	@Test
	@SuppressWarnings("null")
	public void dadaLaCircunferenciaFormadaPorUnCentroYUnRadioDeberiaDevolverLasUnidadesPertenecientes(){

		Mapa mapa = new Mapa();

		Marine marine = new Marine();
		Coordenada coordenadaMarine = new Coordenada(5,5);

		NaveCiencia naveCiencia = new NaveCiencia();
		Coordenada coordenadaNaveCiencia = new Coordenada(5,6);

		try {

			mapa.agregarEnCapaTerrestre(marine, coordenadaMarine);
			mapa.agregarEnCapaAerea(naveCiencia, coordenadaNaveCiencia);

		} catch (ExcepcionPosicionOcupada e) {
			e.printStackTrace();
		}

		Coordenada centro = new Coordenada(6,5);

		ArrayList<ColocableEnMapa> encontrados = null;

		try {

			encontrados = mapa.obtenerUnidadesYConstruccionesEncerradasEnCircunferenciaDe(centro,5);

		} catch (ExcepcionNoSePudoAgregarAlMapa e) {
			e.printStackTrace();
		}

		assertTrue(encontrados.contains(marine));
		assertTrue(encontrados.contains(naveCiencia));

	}

	@Test
	@SuppressWarnings("null")
	public void dadaLaCircunferenciaFormadaPorUnCentroYUnRadioNoDeberiaDevolverLasUnidadesNoPertenecientes(){

		Mapa mapa = new Mapa();

		Marine marine = new Marine();
		Coordenada coordenadaMarine = new Coordenada(5,5);

		NaveCiencia naveCiencia = new NaveCiencia();
		Coordenada coordenadaNaveCiencia = new Coordenada(15,16);

		try {

			mapa.agregarEnCapaTerrestre(marine, coordenadaMarine);
			mapa.agregarEnCapaAerea(naveCiencia, coordenadaNaveCiencia);

		} catch (ExcepcionPosicionOcupada e) {
			e.printStackTrace();
		}

		Coordenada centro = new Coordenada(6,5);

		ArrayList<ColocableEnMapa> encontrados = null;

		try {

			encontrados = mapa.obtenerUnidadesYConstruccionesEncerradasEnCircunferenciaDe(centro,5);

		} catch (ExcepcionNoSePudoAgregarAlMapa e) {
			e.printStackTrace();
		}

		assertTrue(encontrados.contains(marine));
		assertTrue(! encontrados.contains(naveCiencia));

	}

}
