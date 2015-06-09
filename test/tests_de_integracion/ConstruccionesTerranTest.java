package tests_de_integracion;

import construcciones.terran.*;
import excepciones.ExcepcionNoSePudoAgregarAlMapa;
import excepciones.ExcepcionNoSePuedeConstruir;
import interfaces.Construible;
import jugabilidad.ProxyMapa;
import jugabilidad.RazaDeJugador.JugadorTerran;
import jugabilidad.auxiliares.Recursos;
import jugabilidad.auxiliares.Suministros;
import jugabilidad.utilidadesMapa.Coordenadas;
import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import recursos.Cristal;
import recursos.Volcan;

import java.util.ArrayList;


public class ConstruccionesTerranTest {

	//////////////////////// Verificacion de construccion de cada edificio ////////

	@Test
	public void SeConstruyeUnaBarraca() {

		JugadorTerran jugador = new JugadorTerran(new Recursos(150,0));
		Barraca b;
		int i1;
		Coordenadas coordenadas = new Coordenadas(0,0);

		b = jugador.construirBarraca(coordenadas);
		i1 = b.getTiempoDeConstruccion();
		for (int i = 0; i < i1; i++) jugador.update();

		Assert.assertTrue(jugador.buscarConstruccion(b));
	}

		@Test
	public void SeConstruyeUnaCentroDeMineralSobreUnCristal() throws ExcepcionNoSePudoAgregarAlMapa {
		JugadorTerran j = new JugadorTerran(new Recursos(150,0));
		Coordenadas coordenadas = new Coordenadas(1,1);
		Cristal cristal = new Cristal();
		CentroDeMineral centroDeMineral;
		ProxyMapa mapa = ProxyMapa.getInstance();
		ProxyMapa.getInstance().setCoordenadasMaximas(10,10);

		mapa.agregar(cristal,coordenadas);

		centroDeMineral = j.construirCentroDeMineral(coordenadas);
		for (int i = 0; i < centroDeMineral.getTiempoDeConstruccion(); i ++) j.update();

		Assert.assertTrue(j.buscarConstruccion(centroDeMineral));
	}

	@Test
	public void SeQuiereConstruirUnaCentroDeMineralSobreUnVolcanYNoSePuede() throws ExcepcionNoSePudoAgregarAlMapa {
		JugadorTerran j = new JugadorTerran(new Recursos(150,0));
		Coordenadas coordenadas = new Coordenadas(0,1);
		Volcan volcan = new Volcan();
		CentroDeMineral centroDeMineral;
		ProxyMapa mapa = ProxyMapa.getInstance();
		ProxyMapa.getInstance().setCoordenadasMaximas(10,10);

		mapa.agregar(volcan,coordenadas);

		centroDeMineral = j.construirCentroDeMineral(coordenadas);
		for (int i = 0; i < centroDeMineral.getTiempoDeConstruccion(); i ++) j.update();

		Assert.assertFalse(j.buscarConstruccion(centroDeMineral));
	}

	@Test
	public void SeConstruyeUnaRefineriaSobreUnVolcan() throws ExcepcionNoSePudoAgregarAlMapa {

		JugadorTerran j = new JugadorTerran(new Recursos(150,150));
		Refineria r;
		Coordenadas coordenadas = new Coordenadas(1,4);
		Volcan volcan = new Volcan();
		ProxyMapa mapa = ProxyMapa.getInstance();
		ProxyMapa.getInstance().setCoordenadasMaximas(10,10);

		mapa.agregar(volcan,coordenadas);
		
		r = j.construirRefineria(coordenadas);
		for (int i = 0; i < r.getTiempoDeConstruccion(); i ++) j.update();
		
		Assert.assertTrue(j.buscarConstruccion(r));
	}

	@Test
	public void SeQuiereConstruirUnaRefineriaSobreUnVolcanYNoSePuede() throws ExcepcionNoSePudoAgregarAlMapa {
		JugadorTerran j = new JugadorTerran(new Recursos(150,0));
		Coordenadas coordenadas = new Coordenadas(0,1);
		Cristal cristal = new Cristal();
		Refineria refineria;
		ProxyMapa mapa = ProxyMapa.getInstance();
		ProxyMapa.getInstance().setCoordenadasMaximas(10,10);

		mapa.agregar(cristal,coordenadas);

		refineria = j.construirRefineria(coordenadas);
		for (int i = 0; i < refineria.getTiempoDeConstruccion(); i ++) j.update();

		Assert.assertFalse(j.buscarConstruccion(refineria));
	}

	@Test
	public void SeConstruyeUnDepositoDeSuministrosYAumentanLosSuministrosLimitesActuales() {
		Suministros suministros = new Suministros(0,0);
		JugadorTerran j = new JugadorTerran(new Recursos(150,150),suministros);
		DepositoDeSuministros d ;
		Coordenadas coordenadas = new Coordenadas(2,2);
		
		d = j.construirDepositoDeSuministros(coordenadas);
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
		f.esConstruible(cs,r,new Coordenadas(9,9));
		
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
		p.esConstruible(cs,recursosRecolectados, new Coordenadas(5,6));
		
	}
	
	@Test
	public void JugadorCreaFabricaConBarracaPrevia(){
		JugadorTerran jugador = new JugadorTerran(new Recursos(1000,1000));
		Barraca b;
		Fabrica f;
		int i1,i2;
		
		b = jugador.construirBarraca(new Coordenadas(3,3));
		i1 = b.getTiempoDeConstruccion();
		for (int i = 0; i < i1; i ++) jugador.update();
		
		Assert.assertTrue(jugador.buscarConstruccion(b));
		
		f = jugador.construirFabrica(new Coordenadas(3,4));
		i2 = f.getTiempoDeConstruccion();
		for (int i = 0; i < i2; i ++) jugador.update();

		Assert.assertTrue(jugador.buscarConstruccion(f));
	}
	
	@Test
	public void JugadorQuiereCrearFabricaPeroNecesitaBarraca(){
		JugadorTerran j = new JugadorTerran(new Recursos(10000,1000));
		Fabrica f;
		Coordenadas coordenadas = new Coordenadas(5,6);
		
		f = j.construirFabrica(coordenadas);

		Assert.assertFalse(j.buscarConstruccion(f));
	}
	
	@Test
	public void JugadorCreaPuertoEstelarConFabricaPrevia(){
		JugadorTerran j = new JugadorTerran(new Recursos(10000,1000));
		Barraca b;
		Fabrica f;
		PuertoEstelar p;
		new Coordenadas(1,1);

		b = j.construirBarraca(new Coordenadas(5,5));
		for (int i = 0; i < b.getTiempoDeConstruccion(); i ++) j.update();

		f = j.construirFabrica(new Coordenadas(5,7));
		for (int i = 0; i < f.getTiempoDeConstruccion(); i ++) j.update();

		p = j.construirPuertoEstelar(new Coordenadas(7,7));
		for (int i = 0; i < p.getTiempoDeConstruccion(); i ++) j.update();

		Assert.assertTrue(j.buscarConstruccion(p));
	}
	
	@Test
	public void JugadorQuiereCrearPuertoEstelarPeroNecesitaFabrica(){
		JugadorTerran j = new JugadorTerran(new Recursos(10000,1000));
		PuertoEstelar p;
		Coordenadas coordenadas = new Coordenadas(8,8);
		
		p = j.construirPuertoEstelar(coordenadas);

		Assert.assertFalse(j.buscarConstruccion(p));
	}
	
	//// RecursosInsuficientes para Construir

	@Test
	public void JugadorNoPuedeConstruirCentroDeMineralPorFaltaDeRecursos() throws ExcepcionNoSePudoAgregarAlMapa {
		JugadorTerran j = new JugadorTerran(new Recursos(0,0));
		CentroDeMineral c;
		Cristal cristal = new Cristal();
		Coordenadas coordenadas = new Coordenadas(1,7);
		ProxyMapa mapa = ProxyMapa.getInstance();
		ProxyMapa.getInstance().setCoordenadasMaximas(10,10);

		mapa.agregar(cristal,coordenadas);

		c = j.construirCentroDeMineral(coordenadas);

		Assert.assertFalse(j.buscarConstruccion(c));
	}

	@Test
	public void JugadorNoPuedeConstruirBarracaPorFaltaDeRecursos(){
		JugadorTerran j = new JugadorTerran(new Recursos(0,0));
		Barraca b;
		Coordenadas coordenadas = new Coordenadas(1,8);
		
		b = j.construirBarraca(coordenadas);

		Assert.assertFalse(j.buscarConstruccion(b));
	}
	
	@Test
	public void JugadorNoPuedeConstruirFabricaPorFaltaDeRecursos(){
		JugadorTerran j = new JugadorTerran(new Recursos(1000,0));
		Barraca b;
		Fabrica f;
		Coordenadas coordenadas = new Coordenadas(1,9);
		
		b = j.construirBarraca(coordenadas);
		for (int i = 0; i < b.getTiempoDeConstruccion(); i ++) j.update();
		f = j.construirFabrica(coordenadas);

		Assert.assertFalse(j.buscarConstruccion(f));
	}
	
	@Test
	public void JugadorNoPuedeConstruirPuertoEstelarPorFaltaDeRecursos(){
		JugadorTerran j = new JugadorTerran(new Recursos(1000,100));
		PuertoEstelar p;
		Coordenadas coordenadas = new Coordenadas(2,9);

		j.construirBarraca(coordenadas); //costo 150
		j.construirFabrica(coordenadas); //costo 200,100
		p = j.construirPuertoEstelar(coordenadas); //costo 150,100

		Assert.assertFalse(j.buscarConstruccion(p));
	}
	
	@Test
	public void JugadorNoPuedeConstruirDepositoDeSuministrosPorFaltaDeRecursos(){
		JugadorTerran j = new JugadorTerran(new Recursos(0,0));
		DepositoDeSuministros d;
		Coordenadas coordenadas = new Coordenadas(0,0);
		
		d = j.construirDepositoDeSuministros(coordenadas);

		Assert.assertFalse(j.buscarConstruccion(d));
	}

	@Test
	public void JugadorNoPuedeConstruirRefineriaPorFaltaDeRecursos() throws ExcepcionNoSePudoAgregarAlMapa {
		JugadorTerran j = new JugadorTerran(new Recursos(0,0));
		Refineria r;
		Volcan volcan = new Volcan();
		Coordenadas coordenadas = new Coordenadas(1,7);
		ProxyMapa mapa = ProxyMapa.getInstance();
		ProxyMapa.getInstance().setCoordenadasMaximas(10,10);

		mapa.agregar(volcan,coordenadas);

		r = j.construirRefineria(coordenadas);

		Assert.assertFalse(j.buscarConstruccion(r));
	}

	////////////CentrosDeRecoleccion sobre lugares donde no hay un recursos

	@Test
	public void JugadorNoPuedeConstruirUnEdificioNoRecolectorDondeHayUnVolcan() throws ExcepcionNoSePudoAgregarAlMapa {
		JugadorTerran j = new JugadorTerran(new Recursos(1000,1000));
		Barraca b;
		Coordenadas coordenadas = new Coordenadas(8,1);
		ProxyMapa mapa = ProxyMapa.getInstance();
		ProxyMapa.getInstance().setCoordenadasMaximas(10,10);
		Volcan volcan = new Volcan();

		mapa.agregar(volcan,coordenadas);

		b = j.construirBarraca(coordenadas);

		Assert.assertFalse(j.buscarConstruccion(b));
	}

	@Test
	public void JugadorNoPuedeConstruirUnEdificioNoRecolectoDondeHayUnCristal() throws ExcepcionNoSePudoAgregarAlMapa {
		JugadorTerran j = new JugadorTerran(new Recursos(1000,1000));
		Barraca b;
		Coordenadas coordenadas = new Coordenadas(8,1);
		ProxyMapa mapa = ProxyMapa.getInstance();
		ProxyMapa.getInstance().setCoordenadasMaximas(10,10);
		Cristal cristal = new Cristal();

		mapa.agregar(cristal,coordenadas);

		b = j.construirBarraca(coordenadas);

		Assert.assertFalse(j.buscarConstruccion(b));
	}

}
