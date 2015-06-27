package tests_de_integracion;

import construcciones.terran.*;
import excepciones.Mapa.ExcepcionNoSePudoAgregarAlMapa;
import excepciones.Mapa.ExcepcionPosicionOcupada;
import excepciones.construcciones.*;
import interfaces.Construible;
import jugabilidad.ProxyMapa;
import jugabilidad.RazaDeJugador.JugadorTerran;
import jugabilidad.auxiliares.Recursos;
import jugabilidad.auxiliares.Suministros;
import jugabilidad.auxiliares.Vision;
import jugabilidad.utilidadesMapa.Coordenada;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import recursos.Cristal;
import recursos.Volcan;

import java.util.ArrayList;


public class ConstruccionesTerranTest {

	//////////////////////// Verificacion de construccion de cada edificio ////////
	ProxyMapa proxyMapa;
	@Before
	public void resetearProxy(){
		ProxyMapa.resetear();

		proxyMapa = ProxyMapa.getInstance();
		proxyMapa.setCoordenadasMaximas(20,20);
	}

	@Test
	public void SeConstruyeUnaBarraca() throws ExcepcionNoSePuedeConstruir, ExcepcionNoSePudoAgregarAlMapa {

		JugadorTerran jugador = new JugadorTerran(new Recursos(150,0));
		jugador.setVisibilidad(Vision.VisionCompleta(20, 20));
		Barraca b;
		int i1;
		Coordenada coordenada = new Coordenada(1,1);

		b = jugador.construirBarraca(coordenada);
		i1 = b.getTiempoDeConstruccion();
		for (int i = 0; i < i1; i++) jugador.update();

		Assert.assertTrue(jugador.buscarConstruccion(b));
	}

	@Test
	public void SeConstruyeUnaCentroDeMineralSobreUnCristal() throws ExcepcionNoSePudoAgregarAlMapa, ExcepcionNoSePuedeConstruir {
		JugadorTerran j = new JugadorTerran(new Recursos(150,0));
		j.setVisibilidad(Vision.VisionCompleta(20, 20));
		Coordenada coordenada = new Coordenada(1,1);
		Cristal cristal = new Cristal();
		CentroDeMineral centroDeMineral;
		ProxyMapa mapa = ProxyMapa.getInstance();
		ProxyMapa.getInstance().setCoordenadasMaximas(10,10);

		mapa.agregar(cristal, coordenada);

		centroDeMineral = j.construirCentroDeMineral(coordenada);
		for (int i = 0; i < centroDeMineral.getTiempoDeConstruccion(); i ++) j.update();

		Assert.assertTrue(j.buscarConstruccion(centroDeMineral));
	}

	@Test(expected = ExcepcionConstruccionNoRecolectaVolcan.class)
	public void SeQuiereConstruirUnaCentroDeMineralSobreUnVolcanYNoSePuede() throws ExcepcionNoSePudoAgregarAlMapa, ExcepcionNoSePuedeConstruir {
		JugadorTerran j = new JugadorTerran(new Recursos(150,0));
		j.setVisibilidad(Vision.VisionCompleta(25, 25));
		Coordenada coordenada = new Coordenada(1,1);
		Volcan volcan = new Volcan();
		CentroDeMineral centroDeMineral;
		ProxyMapa mapa = ProxyMapa.getInstance();
		ProxyMapa.getInstance().setCoordenadasMaximas(10,10);

		mapa.agregar(volcan, coordenada);

		centroDeMineral = j.construirCentroDeMineral(coordenada);
		for (int i = 0; i < centroDeMineral.getTiempoDeConstruccion(); i ++) j.update();

		Assert.assertFalse(j.buscarConstruccion(centroDeMineral));
	}

	@Test
	public void SeConstruyeUnaRefineriaSobreUnVolcan() throws ExcepcionNoSePudoAgregarAlMapa, ExcepcionNoSePuedeConstruir {

		JugadorTerran j = new JugadorTerran(new Recursos(150,150));
		j.setVisibilidad(Vision.VisionCompleta(20, 20));
		Refineria r;
		Coordenada coordenada = new Coordenada(1,4);
		Volcan volcan = new Volcan();
		ProxyMapa mapa = ProxyMapa.getInstance();
		ProxyMapa.getInstance().setCoordenadasMaximas(10,10);

		mapa.agregar(volcan, coordenada);
		
		r = j.construirRefineria(coordenada);
		for (int i = 0; i < r.getTiempoDeConstruccion(); i ++) j.update();
		
		Assert.assertTrue(j.buscarConstruccion(r));
	}

	@Test(expected = ExcepcionConstruccionNoRecolectaCristal.class)
	public void SeQuiereConstruirUnaRefineriaSobreUnVolcanYNoSePuede() throws ExcepcionNoSePudoAgregarAlMapa, ExcepcionNoSePuedeConstruir {
		JugadorTerran jugador = new JugadorTerran(new Recursos(150,0));
		jugador.setVisibilidad(Vision.VisionCompleta(25, 25));
		Coordenada coordenada = new Coordenada(1,1);
		Cristal cristal = new Cristal();
		ProxyMapa mapa = ProxyMapa.getInstance();
		ProxyMapa.getInstance().setCoordenadasMaximas(10,10);

		mapa.agregar(cristal, coordenada);

		jugador.construirRefineria(coordenada);
	}

	@Test
	public void SeConstruyeUnDepositoDeSuministrosYAumentanLosSuministrosLimitesActuales() throws ExcepcionNoSePuedeConstruir, ExcepcionNoSePudoAgregarAlMapa {
		Suministros suministros = new Suministros(0,0);
		JugadorTerran j = new JugadorTerran(new Recursos(150,150),suministros);
		j.setVisibilidad(Vision.VisionCompleta(20, 20));
		DepositoDeSuministros d ;
		Coordenada coordenada = new Coordenada(2,2);
		
		d = j.construirDepositoDeSuministros(coordenada);
		for (int i = 0; i < d.getTiempoDeConstruccion(); i ++) j.update();

		Assert.assertEquals(5,suministros.getSuministrosLimiteActuales());
		Assert.assertTrue(j.buscarConstruccion(d));
	}
	
	/////////////////////// Construccion habilita a otra ////////////////////
	
	
	
	@Rule
	public ExpectedException exception = ExpectedException.none();
	@Test
	public void SeQuiereCrearFabricaPeroNoEncuentraBarracaYExcepcion() throws ExcepcionNoSePuedeConstruir {
		ArrayList<Construible> cs =  new ArrayList<>();
		Recursos r = new Recursos(1000,1000);
		cs.add(new CentroDeMineral(r));
		
		Fabrica f = new Fabrica();

	    exception.expect(ExcepcionNoSePuedeConstruir.class);
		f.esConstruible(cs,r,new Coordenada(9,9));
		
	}
	
	
	@Rule
	public ExpectedException exception2 = ExpectedException.none();
	@Test
	public void SeQuiereCrearPuertoEstelarPeroNoEncuentraFabricaYExcepcion() throws ExcepcionNoSePuedeConstruir{
		ArrayList<Construible> cs =  new ArrayList<>();
		Recursos recursosRecolectados =  new Recursos(1000,1000);
		
		cs.add(new Barraca());
		
		PuertoEstelar p = new PuertoEstelar();

	    exception2.expect(ExcepcionNoSePuedeConstruir.class);
		p.esConstruible(cs,recursosRecolectados, new Coordenada(5,6));
		
	}
	
	@Test
	public void JugadorCreaFabricaConBarracaPrevia() throws ExcepcionNoSePuedeConstruir, ExcepcionNoSePudoAgregarAlMapa {
		JugadorTerran jugador = new JugadorTerran(new Recursos(1000,1000));
		jugador.setVisibilidad(Vision.VisionCompleta(20, 20));
		Barraca b;
		Fabrica f;
		int i1,i2;
		
		b = jugador.construirBarraca(new Coordenada(3,3));
		i1 = b.getTiempoDeConstruccion();
		for (int i = 0; i < i1; i ++) jugador.update();
		
		Assert.assertTrue(jugador.buscarConstruccion(b));
		
		f = jugador.construirFabrica(new Coordenada(3,4));
		i2 = f.getTiempoDeConstruccion();
		for (int i = 0; i < i2; i ++) jugador.update();

		Assert.assertTrue(jugador.buscarConstruccion(f));
	}
	
	@Test(expected = ExcepcionNecesitaConstruirBarraca.class)
	public void JugadorQuiereCrearFabricaPeroNecesitaBarraca() throws ExcepcionNoSePuedeConstruir, ExcepcionNoSePudoAgregarAlMapa {
		JugadorTerran j = new JugadorTerran(new Recursos(10000,1000));
		j.setVisibilidad(Vision.VisionCompleta(20, 20));
		Fabrica f;
		Coordenada coordenada = new Coordenada(5,6);
		
		f = j.construirFabrica(coordenada);

		Assert.assertFalse(j.buscarConstruccion(f));
	}
	
	@Test
	public void JugadorCreaPuertoEstelarConFabricaPrevia() throws ExcepcionNoSePuedeConstruir, ExcepcionNoSePudoAgregarAlMapa {
		JugadorTerran j = new JugadorTerran(new Recursos(10000,1000));
		j.setVisibilidad(Vision.VisionCompleta(20, 20));
		Barraca b;
		Fabrica f;
		PuertoEstelar p;

		b = j.construirBarraca(new Coordenada(5,5));
		for (int i = 0; i < b.getTiempoDeConstruccion(); i ++) j.update();

		f = j.construirFabrica(new Coordenada(5,7));
		for (int i = 0; i < f.getTiempoDeConstruccion(); i ++) j.update();

		p = j.construirPuertoEstelar(new Coordenada(7,7));
		for (int i = 0; i < p.getTiempoDeConstruccion(); i ++) j.update();

		Assert.assertTrue(j.buscarConstruccion(p));
	}
	
	@Test(expected = ExcepcionNecesitaConstruirFabrica.class)
	public void JugadorQuiereCrearPuertoEstelarPeroNecesitaFabrica() throws ExcepcionNoSePuedeConstruir, ExcepcionNoSePudoAgregarAlMapa {
		JugadorTerran j = new JugadorTerran(new Recursos(10000,1000));
		j.setVisibilidad(Vision.VisionCompleta(25, 25));
		Coordenada coordenada = new Coordenada(8,8);

		j.construirPuertoEstelar(coordenada);

	}
	
	//// RecursosInsuficientes para Construir

	@Test(expected = ExcepcionRecursosInsuficientes.class)
	public void JugadorNoPuedeConstruirCentroDeMineralPorFaltaDeRecursos() throws ExcepcionNoSePudoAgregarAlMapa, ExcepcionNoSePuedeConstruir {
		JugadorTerran j = new JugadorTerran(new Recursos(0,0));
		j.setVisibilidad(Vision.VisionCompleta(25, 25));
		Cristal cristal = new Cristal();
		Coordenada coordenada = new Coordenada(1,7);
		ProxyMapa mapa = ProxyMapa.getInstance();
		ProxyMapa.getInstance().setCoordenadasMaximas(10,10);

		mapa.agregar(cristal, coordenada);

		j.construirCentroDeMineral(coordenada);
	}

	@Test(expected = ExcepcionMineralesInsuficientes.class)
	public void JugadorNoPuedeConstruirBarracaPorFaltaDeRecursos() throws ExcepcionNoSePuedeConstruir, ExcepcionNoSePudoAgregarAlMapa {
		JugadorTerran j = new JugadorTerran(new Recursos(0,0));
		j.setVisibilidad(Vision.VisionCompleta(25, 25));
		Coordenada coordenada = new Coordenada(1,8);
		
		j.construirBarraca(coordenada);
	}
	
	@Test(expected = ExcepcionGasInsuficiente.class)
	public void JugadorNoPuedeConstruirFabricaPorFaltaDeRecursos() throws ExcepcionNoSePuedeConstruir, ExcepcionNoSePudoAgregarAlMapa {
		JugadorTerran j = new JugadorTerran(new Recursos(1000,0));
		j.setVisibilidad(Vision.VisionCompleta(20, 20));
		Barraca b;
		Coordenada coordenada = new Coordenada(1,9);
		
		b = j.construirBarraca(coordenada);
		for (int i = 0; i < b.getTiempoDeConstruccion(); i ++) j.update();

		j.construirFabrica(coordenada);

	}
	
	@Test(expected = ExcepcionMineralesInsuficientes.class)
	public void JugadorNoPuedeConstruirPuertoEstelarPorFaltaDeRecursos() throws ExcepcionNoSePuedeConstruir, ExcepcionNoSePudoAgregarAlMapa {
		JugadorTerran j = new JugadorTerran(new Recursos(150,100));
		j.setVisibilidad(Vision.VisionCompleta(20, 20));
		Barraca b;
		Fabrica f;
		Coordenada coordenada = new Coordenada(2,9);
		Coordenada coordenada2 = new Coordenada(2,8);
		Coordenada coordenada3 = new Coordenada(2,7);

		b = j.construirBarraca(coordenada); //costo 150
		for (int i = 0; i < b.getTiempoDeConstruccion(); i ++) j.update();

		f = j.construirFabrica(coordenada2); //costo 200,100
		for (int i = 0; i < f.getTiempoDeConstruccion(); i ++) j.update();

		j.construirPuertoEstelar(coordenada3); //costo 150,100
	}
	
	@Test(expected = ExcepcionMineralesInsuficientes.class)
	public void JugadorNoPuedeConstruirDepositoDeSuministrosPorFaltaDeRecursos() throws ExcepcionNoSePuedeConstruir, ExcepcionNoSePudoAgregarAlMapa {
		JugadorTerran j = new JugadorTerran(new Recursos(0,0));
		j.setVisibilidad(Vision.VisionCompleta(20, 20));
		Coordenada coordenada = new Coordenada(1,1);
		
		j.construirDepositoDeSuministros(coordenada);
	}

	@Test(expected = ExcepcionMineralesInsuficientes.class)
	public void JugadorNoPuedeConstruirRefineriaPorFaltaDeRecursos() throws ExcepcionNoSePudoAgregarAlMapa, ExcepcionNoSePuedeConstruir {
		JugadorTerran j = new JugadorTerran(new Recursos(0,0));
		j.setVisibilidad(Vision.VisionCompleta(20, 20));
		Volcan volcan = new Volcan();
		Coordenada coordenada = new Coordenada(1,7);
		ProxyMapa mapa = ProxyMapa.getInstance();
		ProxyMapa.getInstance().setCoordenadasMaximas(10,10);

		mapa.agregar(volcan, coordenada);

		j.construirRefineria(coordenada);

	}

	////////////Construcciones no recolectoras sobre lugares donde hay recursos

	@Test(expected = ExcepcionPosicionOcupada.class)
	public void JugadorNoPuedeConstruirUnEdificioNoRecolectorDondeHayUnVolcan() throws ExcepcionNoSePudoAgregarAlMapa, ExcepcionNoSePuedeConstruir {
		JugadorTerran j = new JugadorTerran(new Recursos(1000,1000));
		j.setVisibilidad(Vision.VisionCompleta(20, 20));
		Coordenada coordenada = new Coordenada(8,1);
		ProxyMapa mapa = ProxyMapa.getInstance();
		ProxyMapa.getInstance().setCoordenadasMaximas(10,10);
		Volcan volcan = new Volcan();

		mapa.agregar(volcan, coordenada);

		j.construirBarraca(coordenada);

	}

	@Test(expected = ExcepcionPosicionOcupada.class)
	public void JugadorNoPuedeConstruirUnEdificioNoRecolectoDondeHayUnCristal() throws ExcepcionNoSePudoAgregarAlMapa, ExcepcionNoSePuedeConstruir {
		JugadorTerran j = new JugadorTerran(new Recursos(1000,1000));
		j.setVisibilidad(Vision.VisionCompleta(20, 20));
		Coordenada coordenada = new Coordenada(8,1);
		ProxyMapa mapa = ProxyMapa.getInstance();
		ProxyMapa.getInstance().setCoordenadasMaximas(10,10);
		Cristal cristal = new Cristal();

		mapa.agregar(cristal, coordenada);

		j.construirBarraca(coordenada);
	}

}
