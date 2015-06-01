package jugabilidad_tests;

import static org.junit.Assert.*;

import interfaces.ColocableEnMapa;
import jugabilidad.Mapa;
import jugabilidad.utilidadesMapa.Coordenadas;

import org.junit.Test;

import construcciones.terran.Barraca;


public class MapaTest {
	
	@Test
	public void deberiaAgregarUnMarineEnLasCoordenadasEspecificadas() {
		
		Mapa mapa = new Mapa();
		Coordenadas coordenadas = new Coordenadas(1,2);
		ColocableEnMapa barraca = new Barraca();
		
		mapa.agregar( barraca, coordenadas);
		
		assertEquals( barraca , mapa.getTerrestre(coordenadas) );
	
	}
	
}
