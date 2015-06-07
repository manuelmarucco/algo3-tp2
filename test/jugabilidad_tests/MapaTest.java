package jugabilidad_tests;

import construcciones.terran.Barraca;
import excepciones.ExcepcionPosicionOcupada;
import interfaces.ColocableEnMapa;
import jugabilidad.Mapa;
import jugabilidad.utilidadesMapa.Coordenadas;
import org.junit.Test;
import unidades.terrran.Marine;
import unidades.terrran.NaveCiencia;

import static org.junit.Assert.assertEquals;


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
	public void deberiaAgregarUnaUnidadTerrestreEnLaColeccionDeUnidadesTerrestres(){

		Mapa mapa = new Mapa();
		Coordenadas coordenadas = new Coordenadas(1,2);
		ColocableEnMapa marine = new Marine();

		mapa.agregar( marine, coordenadas);

		assertEquals( marine , mapa.obtenerDeCapaTerrestre(coordenadas) );
	}

	@Test
	public void deberiaAgregarUnaUnidadAereaEnLaColeccionDeUnidadesAereas(){

		Mapa mapa = new Mapa();
		Coordenadas coordenadas = new Coordenadas(1,2);
		ColocableEnMapa nave = new NaveCiencia();

		mapa.agregar( nave, coordenadas);

		assertEquals( nave , mapa.obtenerDeCapaAerea(coordenadas) );
	}

	// TODO: Mas Tests.

}
