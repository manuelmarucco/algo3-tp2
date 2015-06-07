package tests_de_integracion;

import construcciones.terran.Barraca;
import construcciones.terran.Fabrica;
import construcciones.terran.PuertoEstelar;
import jugabilidad.RazaDeJugador.JugadorTerran;
import jugabilidad.auxiliares.Recursos;
import jugabilidad.utilidadesMapa.Coordenadas;
import org.junit.Assert;
import org.junit.Test;
import unidades.terrran.*;

public class EntrenamientoUnidadesTerranTest {

	@Test
	public void entrenoMarineYSeAgregaAlJugador() {
		JugadorTerran j = new JugadorTerran(new Recursos(1000,0));
		Barraca b;
		Marine m;
		
		b = j.construirBarraca(new Coordenadas(0,0));
		for(int i = 0; i<12; i++) j.update();
		
		m = b.entrenarMarine();
		for(int i = 0; i<3; i++) j.update();
		
		Assert.assertTrue(j.buscarUnidad(m));
	}

	@Test
	public void entrenoMarineYLoBuscoPeroTodaviaNoTerminoElTiempoDeEntrenamiento() {
		JugadorTerran j = new JugadorTerran(new Recursos(200,0));
		Barraca b;
		Marine m;
		int tem;

		b = j.construirBarraca(new Coordenadas(0,1));
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


		b = j.construirBarraca(new Coordenadas(0,2));
		i1 =  b.getTiempoDeConstruccion();
		for(int i = 0; i<i1; i++) j.update();

		f = j.construirFabrica(new Coordenadas(0,3));
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


		b = j.construirBarraca(new Coordenadas(0,4));
		i1 = b.getTiempoDeConstruccion();
		for(int i = 0; i<i1; i++) j.update();

		f = j.construirFabrica(new Coordenadas(0,5));
		i2 = f.getTiempoDeConstruccion();
		for(int i = 0; i<i2; i++) j.update();

		g = f.entrenarGolliat();
		i3 = g.getTiempoDeEntrenamiento();
		for(int i = 0; i<i3-1; i++) j.update();

		Assert.assertFalse(j.buscarUnidad(g));
	}


	@Test
	public void entrenoEspectroYSeAgregaAlJugador() {
		JugadorTerran j = new JugadorTerran(new Recursos(1000,1000));
		Barraca b;
		Fabrica f;
		PuertoEstelar p;
		Espectro e;
		int tiempo;

		b = j.construirBarraca(new Coordenadas(0,6));
		for(int i = 0; i<b.getTiempoDeConstruccion(); i++) j.update();
		f = j.construirFabrica(new Coordenadas(0,7));
		for(int i = 0; i<f.getTiempoDeConstruccion(); i++) j.update();
		p = j.construirPuertoEstelar(new Coordenadas(0, 8));
		for(int i = 0; i<p.getTiempoDeConstruccion(); i++) j.update();

		e = p.entrenarEspectro();
		tiempo = e.getTiempoDeEntrenamiento();
		for(int i = 0; i<tiempo; i++) j.update();

		Assert.assertTrue(j.buscarUnidad(e));
	}

	@Test
	public void entrenoEspectreYLoBuscoPeroTodaviaNoTerminoElTiempoDeEntrenamiento() {
		JugadorTerran j = new JugadorTerran(new Recursos(1000,1000));
		Barraca b;
		Fabrica f;
		PuertoEstelar p;
		Espectro e;
		int tiempo;

		b = j.construirBarraca(new Coordenadas(0,9));
		for(int i = 0; i<b.getTiempoDeConstruccion(); i++) j.update();
		f = j.construirFabrica(new Coordenadas(1,0));
		for(int i = 0; i<f.getTiempoDeConstruccion(); i++) j.update();
		p = j.construirPuertoEstelar(new Coordenadas(1,1));
		for(int i = 0; i<p.getTiempoDeConstruccion(); i++) j.update();

		e = p.entrenarEspectro();
		tiempo = e.getTiempoDeEntrenamiento();
		for(int i = 0; i<tiempo-1; i++) j.update();

		Assert.assertFalse(j.buscarUnidad(e));
	}

	@Test
	public void entrenoNaveCienciaYSeAgregaAlJugador() {
		JugadorTerran j = new JugadorTerran(new Recursos(1000,1000));
		Barraca b;
		Fabrica f;
		PuertoEstelar p;
		NaveCiencia n;
		int tiempo;

		b = j.construirBarraca(new Coordenadas(1,2));
		for(int i = 0; i<b.getTiempoDeConstruccion(); i++) j.update();
		f = j.construirFabrica(new Coordenadas(1,3));
		for(int i = 0; i<f.getTiempoDeConstruccion(); i++) j.update();
		p = j.construirPuertoEstelar(new Coordenadas(1,4));
		for(int i = 0; i<p.getTiempoDeConstruccion(); i++) j.update();

		n = p.entrenarNaveCiencia();
		tiempo = n.getTiempoDeEntrenamiento();
		for(int i = 0; i<tiempo; i++) j.update();

		Assert.assertTrue(j.buscarUnidad(n));
	}

	@Test
	public void entrenoNaveCienciaYLoBuscoPeroTodaviaNoTerminoElTiempoDeEntrenamiento() {
		JugadorTerran j = new JugadorTerran(new Recursos(1000,1000));
		Barraca b;
		Fabrica f;
		PuertoEstelar p;
		NaveCiencia n;
		int tiempo;

		b = j.construirBarraca(new Coordenadas(1,5));
		for(int i = 0; i<b.getTiempoDeConstruccion(); i++) j.update();
		f = j.construirFabrica(new Coordenadas(1,6));
		for(int i = 0; i<f.getTiempoDeConstruccion(); i++) j.update();
		p = j.construirPuertoEstelar(new Coordenadas(1,7));
		for(int i = 0; i<p.getTiempoDeConstruccion(); i++) j.update();

		n = p.entrenarNaveCiencia();
		tiempo = n.getTiempoDeEntrenamiento();
		for(int i = 0; i<tiempo-1; i++) j.update();

		Assert.assertFalse(j.buscarUnidad(n));
	}

	@Test
	public void entrenoNaveTransporteYSeAgregaAlJugador() {
		JugadorTerran j = new JugadorTerran(new Recursos(1000,1000));
		Barraca b;
		Fabrica f;
		PuertoEstelar p;
		NaveTransporteTerran n;
		int tiempo;

		b = j.construirBarraca(new Coordenadas(1,8));
		for(int i = 0; i<b.getTiempoDeConstruccion(); i++) j.update();
		f = j.construirFabrica(new Coordenadas(1,9));
		for(int i = 0; i<f.getTiempoDeConstruccion(); i++) j.update();
		p = j.construirPuertoEstelar(new Coordenadas(2,0));
		for(int i = 0; i<p.getTiempoDeConstruccion(); i++) j.update();

		n = p.entrenarNaveTransporte();
		tiempo = n.getTiempoDeEntrenamiento();
		for(int i = 0; i<tiempo; i++) j.update();

		Assert.assertTrue(j.buscarUnidad(n));
	}

	@Test
	public void entrenoNaveTransporteYLoBuscoPeroTodaviaNoTerminoElTiempoDeEntrenamiento() {
		JugadorTerran j = new JugadorTerran(new Recursos(1000,1000));
		Barraca b;
		Fabrica f;
		PuertoEstelar p;
		NaveTransporteTerran n;
		int tiempo;

		b = j.construirBarraca(new Coordenadas(2,1));
		for(int i = 0; i<b.getTiempoDeConstruccion(); i++) j.update();
		f = j.construirFabrica(new Coordenadas(2,2));
		for(int i = 0; i<f.getTiempoDeConstruccion(); i++) j.update();
		p = j.construirPuertoEstelar(new Coordenadas(2,3));
		for(int i = 0; i<p.getTiempoDeConstruccion(); i++) j.update();

		n = p.entrenarNaveTransporte();
		tiempo = n.getTiempoDeEntrenamiento();
		for(int i = 0; i<tiempo-1; i++) j.update();

		Assert.assertFalse(j.buscarUnidad(n));
	}

}
