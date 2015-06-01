package construcciones.terran_tests;

import auxiliares.Recursos;
import construcciones.terran.Barraca;
import fiuba.algo3.algocraft.comandos.Accion;
import fiuba.algo3.algocraft.unidades.Unidad;
import jugabilidad.Jugador;
import jugabilidad.Mapa;
import jugabilidad.utilidadesMapa.Coordenadas;
import org.junit.Assert;
import org.junit.Test;
import razas.Terran;

public class Barraca_tests {
	
	@Test
	public void VidaInicializada() {
		Mapa mapa = new Mapa();
		Jugador jugador = new Jugador(new Terran(),new Recursos(50,0));
		Barraca b = new Barraca(jugador,mapa);
		
		Assert.assertEquals(250, b.getVida().getVidaActual());
	}

	@Test
	public void creoMarineYEsMarine() {
		Mapa mapa = new Mapa();
		Jugador jugador = new Jugador(new Terran(),new Recursos(50,0));
		Barraca barraca = new Barraca(jugador,mapa);
		barraca.actuar(Accion.ConstruirMarine,new Coordenadas(1,1));
		Assert.assertEquals(mapa.getTerrestre(new Coordenadas(1,1)).getClass(), Unidad.class);//cambiar esto y agregar get nombre
	}

}
