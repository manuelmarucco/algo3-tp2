package jugabilidad_tests;

import static org.junit.Assert.*;
import interfaces.ColocableEnMapa;
import jugabilidad.Mapa;
import jugabilidad.utilidadesMapa.Coordenadas;

import org.junit.Test;

import construcciones.terran.Barraca;
import unidades.terrran.Marine;
import unidades.terrran.NaveCiencia;


public class MapaTest {
	
	@Test
	public void deberiaAgregarUnaBarraEnLasCoordenadasEspecificadas() {
		
		Mapa mapa = new Mapa();
		Coordenadas coordenadas = new Coordenadas(1,2);
		ColocableEnMapa barraca = new Barraca();
		
		mapa.agregarEnTierra( barraca, coordenadas);
		
		assertEquals( barraca , mapa.getTerrestre(coordenadas) );
	
	}

	@Test
	public void deberiaAgregarUnaUnidadTerrestreEnLaColeccionDeUnidadesTerrestres(){

		Mapa mapa = new Mapa();
		Coordenadas coordenadas = new Coordenadas(1,2);
		ColocableEnMapa marine = new Marine();

		mapa.agregar( marine, coordenadas);

		assertEquals( marine , mapa.getTerrestre(coordenadas) );
	}

	@Test
	public void deberiaAgregarUnaUnidadAereaEnLaColeccionDeUnidadesAereas(){

		Mapa mapa = new Mapa();
		Coordenadas coordenadas = new Coordenadas(1,2);
		ColocableEnMapa nave = new NaveCiencia();

		mapa.agregar( nave, coordenadas);

		assertEquals( nave , mapa.getAerea(coordenadas) );
	}


	@Test
	public void siAgregoUnaUnidadTerrestreEnUnaPosicionDichaPosicionTerrestreDeberiaEstarOcupada() {

		Mapa mapa = new Mapa();
		Coordenadas coordenadas = new Coordenadas(1,2);
		ColocableEnMapa marine = new Marine();

		mapa.agregarEnTierra( marine, coordenadas);

		assertTrue( mapa.posicionTerrestreOcupada(coordenadas) );

	}

	@Test
	public void siAgregoUnaUnidadAereaEnUnaPosicionDichaPosicionAereaDeberiaEstarOcupada() {

		Mapa mapa = new Mapa();
		Coordenadas coordenadas = new Coordenadas(1,2);
		ColocableEnMapa nave = new NaveCiencia();

		mapa.agregarEnAire( nave, coordenadas);

		assertTrue( mapa.posicionAereaOcupada(coordenadas) );

	}

}
