package tests_de_integracion;

import modelo.construcciones.terran.Barraca;
import modelo.construcciones.terran.Fabrica;
import modelo.construcciones.terran.PuertoEstelar;
import modelo.excepciones.Mapa.ExcepcionNoSePudoAgregarAlMapa;
import modelo.excepciones.construcciones.ExcepcionNoSePuedeConstruir;
import modelo.excepciones.construcciones.ExcepcionNoSePuedeEntrenarUnidad;
import modelo.jugabilidad.ProxyMapa;
import modelo.jugabilidad.RazaDeJugador.JugadorTerran;
import modelo.jugabilidad.auxiliares.Recursos;
import modelo.jugabilidad.auxiliares.Vision;
import modelo.jugabilidad.utilidadesMapa.Coordenada;
import modelo.unidades.terrran.*;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class EntrenamientoUnidadesTerranTest {

	ProxyMapa proxyMapa;
	@Before
	public void resetearProxy(){
		ProxyMapa.resetear();

		proxyMapa = ProxyMapa.getInstance();
		proxyMapa.setCoordenadasMaximas(20,20);
	}

	@Test
	public void entrenoMarineYSeAgregaAlJugador() throws ExcepcionNoSePuedeConstruir, ExcepcionNoSePudoAgregarAlMapa, ExcepcionNoSePuedeEntrenarUnidad {
		JugadorTerran j = new JugadorTerran(new Recursos(1000,0));
		j.setVisibilidad(Vision.VisionCompleta(20, 20));
		Barraca b;
		Marine m;
		
		b = j.construirBarraca(new Coordenada(2,2));
		for(int i = 0; i<12; i++) j.update();
		
		m = b.entrenarMarine();
		for(int i = 0; i<3; i++) j.update();
		
		Assert.assertTrue(j.buscarUnidad(m));
	}

	@Test
	public void entrenoMarineYLoBuscoPeroTodaviaNoTerminoElTiempoDeEntrenamiento() throws ExcepcionNoSePuedeConstruir, ExcepcionNoSePudoAgregarAlMapa, ExcepcionNoSePuedeEntrenarUnidad {
		JugadorTerran j = new JugadorTerran(new Recursos(200,0));
		j.setVisibilidad(Vision.VisionCompleta(20, 20));
		Barraca b;
		Marine m;
		int tem;

		b = j.construirBarraca(new Coordenada(3,2));
		for(int i = 0; i<12; i++) j.update();

		m = b.entrenarMarine();
		tem = m.getTiempoDeEntrenamientoActual();
		for(int i = 0; i<tem-1; i++) j.update();

		Assert.assertFalse(j.buscarUnidad(m));
	}

	@Test
	public void entrenoGolliatYSeAgregaAlJugador() throws ExcepcionNoSePuedeConstruir, ExcepcionNoSePudoAgregarAlMapa, ExcepcionNoSePuedeEntrenarUnidad {
		JugadorTerran j = new JugadorTerran(new Recursos(1000,1000));
		j.setVisibilidad(Vision.VisionCompleta(20, 20));
		Barraca b;
		Fabrica f;
		Golliat g;
		int	 i1,i2,i3;


		b = j.construirBarraca(new Coordenada(3,2));
		i1 =  b.getTiempoDeConstruccion();
		for(int i = 0; i<i1; i++) j.update();

		f = j.construirFabrica(new Coordenada(2,3));
		i2 = f.getTiempoDeConstruccion();
		for(int i = 0; i<i2; i++) j.update();

		g = f.entrenarGolliat();
		i3 = g.getTiempoDeEntrenamientoActual();
		for(int i = 0; i<i3; i++) j.update();

		Assert.assertTrue(j.buscarUnidad(g));
	}

	@Test
	public void entrenoGolliatYLoBuscoPeroTodaviaNoTerminoElTiempoDeEntrenamiento() throws ExcepcionNoSePuedeConstruir, ExcepcionNoSePudoAgregarAlMapa, ExcepcionNoSePuedeEntrenarUnidad {
		JugadorTerran j = new JugadorTerran(new Recursos(1000,1000));
		j.setVisibilidad(Vision.VisionCompleta(20, 20));
		Barraca b;
		Fabrica f;
		Golliat g;
		int	 i1,i2,i3;

		b = j.construirBarraca(new Coordenada(1,4));
		i1 = b.getTiempoDeConstruccion();
		for(int i = 0; i<i1; i++) j.update();

		f = j.construirFabrica(new Coordenada(3,5));
		i2 = f.getTiempoDeConstruccion();
		for(int i = 0; i<i2; i++) j.update();

		g = f.entrenarGolliat();
		i3 = g.getTiempoDeEntrenamientoActual();
		for(int i = 0; i<i3-1; i++) j.update();

		Assert.assertFalse(j.buscarUnidad(g));
	}


	@Test
	public void entrenoEspectroYSeAgregaAlJugador() throws ExcepcionNoSePuedeConstruir, ExcepcionNoSePudoAgregarAlMapa, ExcepcionNoSePuedeEntrenarUnidad {
		JugadorTerran j = new JugadorTerran(new Recursos(1000,1000));
		j.setVisibilidad(Vision.VisionCompleta(20, 20));
		Barraca b;
		Fabrica f;
		PuertoEstelar p;
		Espectro e;
		int tiempo;

		b = j.construirBarraca(new Coordenada(3,6));
		for(int i = 0; i<b.getTiempoDeConstruccion(); i++) j.update();
		f = j.construirFabrica(new Coordenada(4,7));
		for(int i = 0; i<f.getTiempoDeConstruccion(); i++) j.update();
		p = j.construirPuertoEstelar(new Coordenada(5, 8));
		for(int i = 0; i<p.getTiempoDeConstruccion(); i++) j.update();

		e = p.entrenarEspectro();
		tiempo = e.getTiempoDeEntrenamientoActual();
		for(int i = 0; i<tiempo; i++) j.update();

		Assert.assertTrue(j.buscarUnidad(e));
	}

	@Test
	public void entrenoEspectreYLoBuscoPeroTodaviaNoTerminoElTiempoDeEntrenamiento() throws ExcepcionNoSePuedeConstruir, ExcepcionNoSePudoAgregarAlMapa, ExcepcionNoSePuedeEntrenarUnidad {
		JugadorTerran j = new JugadorTerran(new Recursos(1000,1000));
		j.setVisibilidad(Vision.VisionCompleta(20, 20));
		Barraca b;
		Fabrica f;
		PuertoEstelar p;
		Espectro e;
		int tiempo;

		b = j.construirBarraca(new Coordenada(2,9));
		for(int i = 0; i<b.getTiempoDeConstruccion(); i++) j.update();
		f = j.construirFabrica(new Coordenada(1,3));
		for(int i = 0; i<f.getTiempoDeConstruccion(); i++) j.update();
		p = j.construirPuertoEstelar(new Coordenada(1,1));
		for(int i = 0; i<p.getTiempoDeConstruccion(); i++) j.update();

		e = p.entrenarEspectro();
		tiempo = e.getTiempoDeEntrenamientoActual();
		for(int i = 0; i<tiempo-1; i++) j.update();

		Assert.assertFalse(j.buscarUnidad(e));
	}

	@Test
	public void entrenoNaveCienciaYSeAgregaAlJugador() throws ExcepcionNoSePuedeConstruir, ExcepcionNoSePudoAgregarAlMapa, ExcepcionNoSePuedeEntrenarUnidad {
		JugadorTerran j = new JugadorTerran(new Recursos(1000,1000));
		j.setVisibilidad(Vision.VisionCompleta(20, 20));
		Barraca b;
		Fabrica f;
		PuertoEstelar p;
		NaveCiencia n;
		int tiempo;

		b = j.construirBarraca(new Coordenada(1,2));
		for(int i = 0; i<b.getTiempoDeConstruccion(); i++) j.update();
		f = j.construirFabrica(new Coordenada(1,3));
		for(int i = 0; i<f.getTiempoDeConstruccion(); i++) j.update();
		p = j.construirPuertoEstelar(new Coordenada(1,4));
		for(int i = 0; i<p.getTiempoDeConstruccion(); i++) j.update();

		n = p.entrenarNaveCiencia();
		tiempo = n.getTiempoDeEntrenamientoActual();
		for(int i = 0; i<tiempo; i++) j.update();

		Assert.assertTrue(j.buscarUnidad(n));
	}

	@Test
	public void entrenoNaveCienciaYLoBuscoPeroTodaviaNoTerminoElTiempoDeEntrenamiento() throws ExcepcionNoSePuedeConstruir, ExcepcionNoSePudoAgregarAlMapa, ExcepcionNoSePuedeEntrenarUnidad {
		JugadorTerran j = new JugadorTerran(new Recursos(1000,1000));
		j.setVisibilidad(Vision.VisionCompleta(20, 20));
		Barraca b;
		Fabrica f;
		PuertoEstelar p;
		NaveCiencia n;
		int tiempo;

		b = j.construirBarraca(new Coordenada(1,5));
		for(int i = 0; i<b.getTiempoDeConstruccion(); i++) j.update();
		f = j.construirFabrica(new Coordenada(1,6));
		for(int i = 0; i<f.getTiempoDeConstruccion(); i++) j.update();
		p = j.construirPuertoEstelar(new Coordenada(1,7));
		for(int i = 0; i<p.getTiempoDeConstruccion(); i++) j.update();

		n = p.entrenarNaveCiencia();
		tiempo = n.getTiempoDeEntrenamientoActual();
		for(int i = 0; i<tiempo-1; i++) j.update();

		Assert.assertFalse(j.buscarUnidad(n));
	}

	@Test
	public void entrenoNaveTransporteYSeAgregaAlJugador() throws ExcepcionNoSePuedeConstruir, ExcepcionNoSePudoAgregarAlMapa, ExcepcionNoSePuedeEntrenarUnidad {
		JugadorTerran j = new JugadorTerran(new Recursos(1000,1000));
		j.setVisibilidad(Vision.VisionCompleta(20, 20));
		Barraca b;
		Fabrica f;
		PuertoEstelar p;
		NaveTransporteTerran n;
		int tiempo;

		b = j.construirBarraca(new Coordenada(1,8));
		for(int i = 0; i<b.getTiempoDeConstruccion(); i++) j.update();
		f = j.construirFabrica(new Coordenada(1,9));
		for(int i = 0; i<f.getTiempoDeConstruccion(); i++) j.update();
		p = j.construirPuertoEstelar(new Coordenada(2,5));
		for(int i = 0; i<p.getTiempoDeConstruccion(); i++) j.update();

		n = p.entrenarNaveTransporte();
		tiempo = n.getTiempoDeEntrenamientoActual();
		for(int i = 0; i<tiempo; i++) j.update();

		Assert.assertTrue(j.buscarUnidad(n));
	}

	@Test
	public void entrenoNaveTransporteYLoBuscoPeroTodaviaNoTerminoElTiempoDeEntrenamiento() throws ExcepcionNoSePuedeConstruir, ExcepcionNoSePudoAgregarAlMapa, ExcepcionNoSePuedeEntrenarUnidad {
		JugadorTerran j = new JugadorTerran(new Recursos(1000,1000));
		j.setVisibilidad(Vision.VisionCompleta(20, 20));
		Barraca b;
		Fabrica f;
		PuertoEstelar p;
		NaveTransporteTerran n;
		int tiempo;

		b = j.construirBarraca(new Coordenada(2,1));
		for(int i = 0; i<b.getTiempoDeConstruccion(); i++) j.update();
		f = j.construirFabrica(new Coordenada(2,2));
		for(int i = 0; i<f.getTiempoDeConstruccion(); i++) j.update();
		p = j.construirPuertoEstelar(new Coordenada(2,3));
		for(int i = 0; i<p.getTiempoDeConstruccion(); i++) j.update();

		n = p.entrenarNaveTransporte();
		tiempo = n.getTiempoDeEntrenamientoActual();
		for(int i = 0; i<tiempo-1; i++) j.update();

		Assert.assertFalse(j.buscarUnidad(n));
	}

}
