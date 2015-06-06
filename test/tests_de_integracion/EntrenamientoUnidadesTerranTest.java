package tests_de_integracion;

import construcciones.terran.Barraca;
import construcciones.terran.Fabrica;
import jugabilidad.razaDeJugador.JugadorTerran;
import jugabilidad.auxiliares.Recursos;
import org.junit.Assert;
import org.junit.Test;
import unidades.terrran.Golliat;
import unidades.terrran.Marine;

public class EntrenamientoUnidadesTerranTest {
/*
	@Test
	public void entrenoMarineYSeAgregaAlJugador() {
		JugadorTerran j = new JugadorTerran(new Recursos(1000,0));
		Barraca b;
		Marine m;
		
		b = j.construirBarraca();
		for(int i = 0; i<12; i++) j.update();
		
		m = b.entrenarMarine();
		for(int i = 0; i<3; i++) j.update();
		
		Assert.assertTrue(j.buscarUnidad(m));
	}

	@Test
	public void entrenoMarineYLoBuscoPeroTodaviaNoTerminoElTiempoDeEntrenamiento() {
		JugadorTerran j = new JugadorTerran(new Recursos(1000,0));
		Barraca b;
		Marine m;
		int tem;

		b = j.construirBarraca();
		for(int i = 0; i<12; i++) j.update();

		m = b.entrenarMarine();
		tem = m.getTiempoDeEntrenamiento();
		for(int i = 0; i<tem-1; i++) j.update();

		Assert.assertFalse(j.buscarUnidad(m));
	}

	@Test
	public void entrenoGolliatYSeAgregaAlJugador() {
		JugadorTerran j = new JugadorTerran(new Recursos(1000,1000));
		Barraca b;
		Fabrica f;
		Golliat g;
		int	 i1,i2,i3;


		b = j.construirBarraca();
		i1 =  b.getTiempoDeConstruccion();
		for(int i = 0; i<i1; i++) j.update();

		f = j.construirFabrica();
		i2 = f.getTiempoDeConstruccion();
		for(int i = 0; i<i2; i++) j.update();

		g = f.entrenarGolliat();
		i3 = g.getTiempoDeEntrenamiento();
		for(int i = 0; i<i3; i++) j.update();

		Assert.assertTrue(j.buscarUnidad(g));
	}

	@Test
	public void entrenoGolliatYLoBuscoPeroTodaviaNoTerminoElTiempoDeEntrenamiento() {
		JugadorTerran j = new JugadorTerran(new Recursos(1000,1000));
		Barraca b;
		Fabrica f;
		Golliat g;
		int	 i1,i2,i3;


		b = j.construirBarraca();
		i1 = b.getTiempoDeConstruccion();
		for(int i = 0; i<i1; i++) j.update();

		f = j.construirFabrica();
		i2 = f.getTiempoDeConstruccion();
		for(int i = 0; i<i2; i++) j.update();

		g = f.entrenarGolliat();
		i3 = g.getTiempoDeEntrenamiento();
		for(int i = 0; i<i3-1; i++) j.update();

		Assert.assertFalse(j.buscarUnidad(g));
	}
	*/
/*
	@Test
	public void entrenoEspectroYSeAgregaAlJugador() {
		Jugador j = new Jugador(new Terran(),new Recursos(1000,1000));
		Barraca b = new Barraca(j);
		Fabrica f = new Fabrica(j);
		PuertoEstelar p = new PuertoEstelar(j);
		Espectro e = new Espectro();

		j.construir(b);
		for(int i = 0; i<12; i++) j.update();
		j.construir(f);
		for(int i = 0; i<12; i++) j.update();

		p.entrenarEspectro(e);
		for(int i = 0; i<e.getTiempoDeEntrenamiento(); i++) j.update();

		Assert.assertTrue(j.buscarUnidad(e));
	}
	*/
}
