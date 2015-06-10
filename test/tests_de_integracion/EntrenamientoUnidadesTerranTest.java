package tests_de_integracion;

import construcciones.terran.Barraca;
import construcciones.terran.Fabrica;
import construcciones.terran.PuertoEstelar;
import excepciones.construicciones.ExcepcionNoSePuedeConstruir;
import excepciones.Mapa.ExcepcionPosicionOcupada;
import jugabilidad.ProxyMapa;
import jugabilidad.RazaDeJugador.JugadorTerran;
import jugabilidad.auxiliares.Recursos;
import jugabilidad.auxiliares.Vision;
import jugabilidad.utilidadesMapa.Coordenadas;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import unidades.terrran.*;

public class EntrenamientoUnidadesTerranTest {

	@Before
	public void resetearProxy(){
		ProxyMapa.resetear();
	}
	@Test
	public void entrenoMarineYSeAgregaAlJugador() throws ExcepcionNoSePuedeConstruir, ExcepcionPosicionOcupada {
		JugadorTerran j = new JugadorTerran(new Recursos(1000,0));
		j.setVisibilidad(Vision.VisionCompleta(20, 20));
		Barraca b;
		Marine m;
		
		b = j.construirBarraca(new Coordenadas(2,2));
		for(int i = 0; i<12; i++) j.update();
		
		m = b.entrenarMarine();
		for(int i = 0; i<3; i++) j.update();
		
		Assert.assertTrue(j.buscarUnidad(m));
	}

	@Test
	public void entrenoMarineYLoBuscoPeroTodaviaNoTerminoElTiempoDeEntrenamiento() throws ExcepcionNoSePuedeConstruir, ExcepcionPosicionOcupada {
		JugadorTerran j = new JugadorTerran(new Recursos(200,0));
		j.setVisibilidad(Vision.VisionCompleta(20, 20));
		Barraca b;
		Marine m;
		int tem;

		b = j.construirBarraca(new Coordenadas(3,2));
		for(int i = 0; i<12; i++) j.update();

		m = b.entrenarMarine();
		tem = m.getTiempoDeEntrenamiento();
		for(int i = 0; i<tem-1; i++) j.update();

		Assert.assertFalse(j.buscarUnidad(m));
	}

	@Test
	public void entrenoGolliatYSeAgregaAlJugador() throws ExcepcionNoSePuedeConstruir, ExcepcionPosicionOcupada {
		JugadorTerran j = new JugadorTerran(new Recursos(1000,1000));
		j.setVisibilidad(Vision.VisionCompleta(20, 20));
		Barraca b;
		Fabrica f;
		Golliat g;
		int	 i1,i2,i3;


		b = j.construirBarraca(new Coordenadas(3,2));
		i1 =  b.getTiempoDeConstruccion();
		for(int i = 0; i<i1; i++) j.update();

		f = j.construirFabrica(new Coordenadas(2,3));
		i2 = f.getTiempoDeConstruccion();
		for(int i = 0; i<i2; i++) j.update();

		g = f.entrenarGolliat();
		i3 = g.getTiempoDeEntrenamiento();
		for(int i = 0; i<i3; i++) j.update();

		Assert.assertTrue(j.buscarUnidad(g));
	}

	@Test
	public void entrenoGolliatYLoBuscoPeroTodaviaNoTerminoElTiempoDeEntrenamiento() throws ExcepcionNoSePuedeConstruir, ExcepcionPosicionOcupada {
		JugadorTerran j = new JugadorTerran(new Recursos(1000,1000));
		j.setVisibilidad(Vision.VisionCompleta(20, 20));
		Barraca b;
		Fabrica f;
		Golliat g;
		int	 i1,i2,i3;


		b = j.construirBarraca(new Coordenadas(1,4));
		i1 = b.getTiempoDeConstruccion();
		for(int i = 0; i<i1; i++) j.update();

		f = j.construirFabrica(new Coordenadas(3,5));
		i2 = f.getTiempoDeConstruccion();
		for(int i = 0; i<i2; i++) j.update();

		g = f.entrenarGolliat();
		i3 = g.getTiempoDeEntrenamiento();
		for(int i = 0; i<i3-1; i++) j.update();

		Assert.assertFalse(j.buscarUnidad(g));
	}


	@Test
	public void entrenoEspectroYSeAgregaAlJugador() throws ExcepcionNoSePuedeConstruir, ExcepcionPosicionOcupada {
		JugadorTerran j = new JugadorTerran(new Recursos(1000,1000));
		j.setVisibilidad(Vision.VisionCompleta(20, 20));
		Barraca b;
		Fabrica f;
		PuertoEstelar p;
		Espectro e;
		int tiempo;

		b = j.construirBarraca(new Coordenadas(3,6));
		for(int i = 0; i<b.getTiempoDeConstruccion(); i++) j.update();
		f = j.construirFabrica(new Coordenadas(4,7));
		for(int i = 0; i<f.getTiempoDeConstruccion(); i++) j.update();
		p = j.construirPuertoEstelar(new Coordenadas(5, 8));
		for(int i = 0; i<p.getTiempoDeConstruccion(); i++) j.update();

		e = p.entrenarEspectro();
		tiempo = e.getTiempoDeEntrenamiento();
		for(int i = 0; i<tiempo; i++) j.update();

		Assert.assertTrue(j.buscarUnidad(e));
	}

	@Test
	public void entrenoEspectreYLoBuscoPeroTodaviaNoTerminoElTiempoDeEntrenamiento() throws ExcepcionNoSePuedeConstruir, ExcepcionPosicionOcupada {
		JugadorTerran j = new JugadorTerran(new Recursos(1000,1000));
		j.setVisibilidad(Vision.VisionCompleta(20, 20));
		Barraca b;
		Fabrica f;
		PuertoEstelar p;
		Espectro e;
		int tiempo;

		b = j.construirBarraca(new Coordenadas(2,9));
		for(int i = 0; i<b.getTiempoDeConstruccion(); i++) j.update();
		f = j.construirFabrica(new Coordenadas(1,3));
		for(int i = 0; i<f.getTiempoDeConstruccion(); i++) j.update();
		p = j.construirPuertoEstelar(new Coordenadas(1,1));
		for(int i = 0; i<p.getTiempoDeConstruccion(); i++) j.update();

		e = p.entrenarEspectro();
		tiempo = e.getTiempoDeEntrenamiento();
		for(int i = 0; i<tiempo-1; i++) j.update();

		Assert.assertFalse(j.buscarUnidad(e));
	}

	@Test
	public void entrenoNaveCienciaYSeAgregaAlJugador() throws ExcepcionNoSePuedeConstruir, ExcepcionPosicionOcupada {
		JugadorTerran j = new JugadorTerran(new Recursos(1000,1000));
		j.setVisibilidad(Vision.VisionCompleta(20, 20));
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
	public void entrenoNaveCienciaYLoBuscoPeroTodaviaNoTerminoElTiempoDeEntrenamiento() throws ExcepcionNoSePuedeConstruir, ExcepcionPosicionOcupada {
		JugadorTerran j = new JugadorTerran(new Recursos(1000,1000));
		j.setVisibilidad(Vision.VisionCompleta(20, 20));
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
	public void entrenoNaveTransporteYSeAgregaAlJugador() throws ExcepcionNoSePuedeConstruir, ExcepcionPosicionOcupada {
		JugadorTerran j = new JugadorTerran(new Recursos(1000,1000));
		j.setVisibilidad(Vision.VisionCompleta(20, 20));
		Barraca b;
		Fabrica f;
		PuertoEstelar p;
		NaveTransporteTerran n;
		int tiempo;

		b = j.construirBarraca(new Coordenadas(1,8));
		for(int i = 0; i<b.getTiempoDeConstruccion(); i++) j.update();
		f = j.construirFabrica(new Coordenadas(1,9));
		for(int i = 0; i<f.getTiempoDeConstruccion(); i++) j.update();
		p = j.construirPuertoEstelar(new Coordenadas(2,5));
		for(int i = 0; i<p.getTiempoDeConstruccion(); i++) j.update();

		n = p.entrenarNaveTransporte();
		tiempo = n.getTiempoDeEntrenamiento();
		for(int i = 0; i<tiempo; i++) j.update();

		Assert.assertTrue(j.buscarUnidad(n));
	}

	@Test
	public void entrenoNaveTransporteYLoBuscoPeroTodaviaNoTerminoElTiempoDeEntrenamiento() throws ExcepcionNoSePuedeConstruir, ExcepcionPosicionOcupada {
		JugadorTerran j = new JugadorTerran(new Recursos(1000,1000));
		j.setVisibilidad(Vision.VisionCompleta(20, 20));
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
