package jugabilidad_tests;

import auxiliares.Recursos;
import construcciones.terran.Barraca;
import construcciones.terran.ConstruccionTerran;
import jugabilidad.Jugador;
import jugabilidad.Mapa;
import jugabilidad.utilidadesMapa.Coordenadas;
import org.junit.Test;
import razas.Terran;

import static org.junit.Assert.assertEquals;


public class MapaTest {
	
	@Test
	public void deberiaAgregarUnMarineEnLasCoordenadasEspecificadas() {
		
		Mapa mapa = new Mapa();
		Coordenadas coordenadas = new Coordenadas(1,2);
		Jugador jugador = new Jugador(new Terran(),new Recursos(50,0));
		ConstruccionTerran barraca = new Barraca(jugador,mapa);
		
		mapa.agregar( barraca, coordenadas);
		
		assertEquals( barraca , mapa.getTerrestre(coordenadas) );
	
	}
	
}
