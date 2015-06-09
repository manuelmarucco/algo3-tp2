package jugabilidad_tests;

import construcciones.terran.Barraca;
import excepciones.ExcepcionNoSePudoAgregarAlMapa;
import excepciones.ExcepcionPosicionOcupada;
import interfaces.ColocableEnMapa;
import jugabilidad.Mapa;
import jugabilidad.ProxyMapa;
import jugabilidad.utilidadesMapa.Coordenadas;
import org.junit.Test;
import recursos.Cristal;
import unidades.protoss.NaveTransporteProtoss;
import unidades.terrran.Marine;
import unidades.terrran.NaveCiencia;
import unidades.terrran.NaveTransporteTerran;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;


public class MapaTest {

	@Test
	public void deberiaAgregarUnaBarracaEnLasCoordenadasEspecificadas() throws ExcepcionPosicionOcupada {
		Mapa mapa = new Mapa();

		Coordenadas coordenadas = new Coordenadas(1,2);
		ColocableEnMapa barraca = new Barraca();
		
		mapa.agregarEnCapaTerrestre(barraca, coordenadas);
		
		assertEquals( barraca , mapa.obtenerDeCapaTerrestre(coordenadas) );
	
	}

	@Test
	public void deberiaAgregarUnaUnidadTerrestreEnLaCapaTerrestre() throws ExcepcionNoSePudoAgregarAlMapa {
		Mapa mapa = new Mapa();

		Coordenadas coordenadas = new Coordenadas(2,2);
		ColocableEnMapa marine = new Marine();

		mapa.agregarEnCapaTerrestre(marine, coordenadas);

		assertEquals( marine , mapa.obtenerDeCapaTerrestre(coordenadas) );
	}

	@Test
	public void deberiaAgregarUnaNaveCienciaEnLaCapaAerea() throws ExcepcionNoSePudoAgregarAlMapa {

		Mapa mapa = new Mapa();

		Coordenadas coordenadas = new Coordenadas(2,6);
		ColocableEnMapa nave = new NaveCiencia();

		mapa.agregarEnCapaAerea(nave, coordenadas);

		assertEquals( nave , mapa.obtenerDeCapaAerea(coordenadas) );
	}

	@Test
	public void deberiaAgregarUnaNaveTransporteProtossEnLaCapaAerea() throws ExcepcionNoSePudoAgregarAlMapa {
		Mapa mapa = new Mapa();

		Coordenadas coordenadas = new Coordenadas(2,4);
		ColocableEnMapa nave = new NaveTransporteProtoss();

		mapa.agregarEnCapaAerea(nave, coordenadas);

		assertEquals( nave , mapa.obtenerDeCapaAerea(coordenadas) );
	}

	@Test
	public void deberiaAgregarUnaNaveTransporteTerranEnLaCapaAerea() throws ExcepcionNoSePudoAgregarAlMapa {
		Mapa mapa = new Mapa();

		Coordenadas coordenadas = new Coordenadas(2,3);
		ColocableEnMapa nave = new NaveTransporteTerran();

		mapa.agregarEnCapaAerea(nave, coordenadas);

		assertEquals( nave , mapa.obtenerDeCapaAerea(coordenadas) );
	}

	@Test
	public void deberiaAgregarUnRecursoEnLaCapaDeRecursos() throws ExcepcionNoSePudoAgregarAlMapa{

		Mapa mapa = new Mapa();

		Coordenadas coordenadas = new Coordenadas(1,2);
		Cristal cristal = new Cristal();

		mapa.agregarEnCapaDeRecursos(cristal, coordenadas);

		assertEquals( cristal , mapa.obtenerDeCapaDeRecursos(coordenadas) );

	}

	@Test
	public void siEliminoUnaUnidadTerrestreLasCoordenadasDeEsaUnidadDeberianEstarVacias()
			throws ExcepcionNoSePudoAgregarAlMapa{

		Mapa mapa = new Mapa();

		Coordenadas coordenadas = new Coordenadas(1,2);
		ColocableEnMapa barraca = new Barraca();

		mapa.agregarEnCapaTerrestre(barraca, coordenadas);
		mapa.borrarEnCapaTerrestre(coordenadas);

		assertFalse(mapa.posicionTerrestreOcupada(coordenadas));

	}

	@Test
	public void siEliminoUnaUnidadAereaLasCoordenadasDeEsaUnidadDeberianEstarVacias()
			throws ExcepcionNoSePudoAgregarAlMapa{

		Mapa mapa = new Mapa();

		Coordenadas coordenadas = new Coordenadas(1,2);
		NaveCiencia nave = new NaveCiencia();

		mapa.agregarEnCapaAerea(nave, coordenadas);
		mapa.borrarEnCapaAerea(coordenadas);

		assertFalse(mapa.posicionAereaOcupada(coordenadas));

	}

}
