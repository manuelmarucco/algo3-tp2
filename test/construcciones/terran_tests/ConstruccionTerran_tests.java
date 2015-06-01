package construcciones.terran_tests;


import auxiliares.Recursos;
import fiuba.algo3.algocraft.unidades.parametros.Danio;
import jugabilidad.Jugador;
import jugabilidad.Mapa;
import org.junit.Assert;

import org.junit.Test;

import construcciones.terran.Barraca;
import construcciones.terran.ConstruccionTerran;
import razas.Terran;

public class ConstruccionTerran_tests {

	@Test
	public void UnaConstruccionTerranRecibeDanio() {
		Mapa mapa = new Mapa();
		Jugador jugador = new Jugador(new Terran(),new Recursos(50,0));
		ConstruccionTerran construccion = new Barraca(jugador,mapa);
		int vidaAnterior;
		
		vidaAnterior = construccion.getVida().getVidaActual();
		
		construccion.recibirDanio(new Danio(50,20,1));
		
		Assert.assertEquals(vidaAnterior-50, construccion.getVida().getVidaActual());
	}
	
	@Test
	public void UnaConstruccionTerranRecibeMasDanioQueSuVida() {
		Mapa mapa = new Mapa();
		Jugador jugador = new Jugador(new Terran(),new Recursos(50,0));
		ConstruccionTerran construccion = new Barraca(jugador,mapa);
		
		construccion.recibirDanio(new Danio(construccion.getVida().getVidaActual()+50,0,0));
		
		Assert.assertEquals(0, construccion.getVida().getVidaActual());
		
	}

}
