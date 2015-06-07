package tests_de_integracion;

import construcciones.terran.*;
import excepciones.ExcepcionNoSePuedeConstruir;
import interfaces.Construible;
import jugabilidad.Mapa;
import jugabilidad.RazaDeJugador.JugadorTerran;
import jugabilidad.auxiliares.Recursos;
import jugabilidad.utilidadesMapa.Coordenadas;
import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import recursos.Cristal;

import java.util.ArrayList;


public class ConstruccionesTerranTest {
	
	//////////////////////// Verificacion de construccion de cada edificio ////////

	@Test
	public void SeConstruyeUnaBarraca() {

		JugadorTerran jugador = new JugadorTerran(new Recursos(150,0));
		Barraca b;
		int i1;
		Coordenadas coordenadas = new Coordenadas(1,1);

		b = jugador.construirBarraca(coordenadas);
		i1 = b.getTiempoDeConstruccion();
		for (int i = 0; i < i1; i++) jugador.update();

		Assert.assertTrue(jugador.buscarConstruccion(b));
	}

	@Test
	public void SeConstruyeUnaCentroDeMineralSobreUnCristal() {
		JugadorTerran j = new JugadorTerran(new Recursos(150,0));
		Mapa mapa = new Mapa();
		Coordenadas coordenadas = new Coordenadas(1,1);
		Cristal cristal = new Cristal();
		CentroDeMineral centroDeMineral;

		mapa.agregar(cristal,coordenadas);

		centroDeMineral = j.construirCentroDeMineral(coordenadas);
		 for (int i = 0; i < centroDeMineral.getTiempoDeConstruccion(); i ++) j.update();

		//mapa.agregar(centroDeMineral,coordenadas);
		
		Assert.assertTrue(j.buscarConstruccion(centroDeMineral));
	}
/*
	@Test
	public void SeConstruyeUnaRefineria() {

		JugadorTerran j = new JugadorTerran(new Recursos(150,150));
		Refineria r;
		Coordenadas coordenadas = new Coordenadas(1,1);
		Volcan volcan = new Volcan();
		int tdc;
		
		r = j.construirRefineria(coordenadas);
		tdc = r.getTiempoDeConstruccion();
		for (int i = 0; i < tdc; i ++) j.update();
		
		Assert.assertTrue(j.buscarConstruccion(r));
	}
*/
	@Test
	public void SeConstruyeUnDepositoDeSuministros() {

		JugadorTerran j = new JugadorTerran(new Recursos(150,150));
		DepositoDeSuministros d ;
		int tdc;
		Coordenadas coordenadas = new Coordenadas(1,1);
		
		d = j.construirDepositoDeSuministros(coordenadas);
		tdc = d.getTiempoDeConstruccion();
		for (int i = 0; i < tdc; i ++) j.update();
		
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
		f.esConstruible(cs,r);
		
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
		p.esConstruible(cs,recursosRecolectados);
		
	}
	
	@Test
	public void JugadorCreaFabricaConBarracaPrevia(){
		JugadorTerran jugador = new JugadorTerran(new Recursos(1000,1000));
		Barraca b;
		Fabrica f;
		Coordenadas coordenadas = new Coordenadas(1,1);
		int i1,i2;
		
		b = jugador.construirBarraca(coordenadas);
		i1 = b.getTiempoDeConstruccion();
		for (int i = 0; i < i1; i ++) jugador.update();
		
		Assert.assertTrue(jugador.buscarConstruccion(b));
		
		f = jugador.construirFabrica(coordenadas);
		i2 = f.getTiempoDeConstruccion();
		for (int i = 0; i < i2; i ++) jugador.update();

		Assert.assertTrue(jugador.buscarConstruccion(f));
	}
	
	@Test
	public void JugadorQuiereCrearFabricaPeroNecesitaBarraca(){
		JugadorTerran j = new JugadorTerran(new Recursos(10000,1000));
		Fabrica f;
		Coordenadas coordenadas = new Coordenadas(1,1);
		
		f = j.construirFabrica(coordenadas);

		Assert.assertFalse(j.buscarConstruccion(f));
	}
	
	@Test
	public void JugadorCreaPuertoEstelarConFabricaPrevia(){
		JugadorTerran j = new JugadorTerran(new Recursos(10000,1000));
		Barraca b;
		Fabrica f;
		PuertoEstelar p;
		Coordenadas coordenadas = new Coordenadas(1,1);
		int i1,i2,i3;

		b = j.construirBarraca(coordenadas);
		i1 = b.getTiempoDeConstruccion();
		for (int i = 0; i < i1; i ++) j.update();

		f = j.construirFabrica(coordenadas);
		i2 = f.getTiempoDeConstruccion();
		for (int i = 0; i < i2; i ++) j.update();

		p = j.construirPuertoEstelar(coordenadas);
		i3 = p.getTiempoDeConstruccion();
		for (int i = 0; i < i3; i ++) j.update();

		Assert.assertTrue(j.buscarConstruccion(p));
	}
	
	@Test
	public void JugadorQuiereCrearPuertoEstelarPeroNecesitaFabrica(){
		JugadorTerran j = new JugadorTerran(new Recursos(10000,1000));
		PuertoEstelar p;
		Coordenadas coordenadas = new Coordenadas(1,1);
		
		p = j.construirPuertoEstelar(coordenadas);

		Assert.assertFalse(j.buscarConstruccion(p));
	}
	
	//// RecursosInsuficientes para Construir

	@Test
	public void JugadorNoPuedeConstruirCentroDeMineralPorFaltaDeRecursos(){
		JugadorTerran j = new JugadorTerran(new Recursos(0,0));
		CentroDeMineral c;
		Coordenadas coordenadas = new Coordenadas(1,1);
		
		c = j.construirCentroDeMineral(coordenadas);

		Assert.assertFalse(j.buscarConstruccion(c));
	}

	@Test
	public void JugadorNoPuedeConstruirBarracaPorFaltaDeRecursos(){
		JugadorTerran j = new JugadorTerran(new Recursos(0,0));
		Barraca b;
		Coordenadas coordenadas = new Coordenadas(1,1);
		
		b = j.construirBarraca(coordenadas);

		Assert.assertFalse(j.buscarConstruccion(b));
	}
	
	@Test
	public void JugadorNoPuedeConstruirFabricaPorFaltaDeRecursos(){
		JugadorTerran j = new JugadorTerran(new Recursos(150,0));
		Barraca b;
		Fabrica f;
		Coordenadas coordenadas = new Coordenadas(1,1);
		
		j.construirBarraca(coordenadas);
		f = j.construirFabrica(coordenadas);

		Assert.assertFalse(j.buscarConstruccion(f));
	}
	
	@Test
	public void JugadorNoPuedeConstruirPuertoEstelarPorFaltaDeRecursos(){
		JugadorTerran j = new JugadorTerran(new Recursos(1000,100));
		PuertoEstelar p;
		Coordenadas coordenadas = new Coordenadas(1,1);

		j.construirBarraca(coordenadas); //costo 150
		j.construirFabrica(coordenadas); //costo 200,100
		p = j.construirPuertoEstelar(coordenadas); //costo 150,100

		Assert.assertFalse(j.buscarConstruccion(p));
	}
	
	@Test
	public void JugadorNoPuedeConstruirDepositoDeSuministrosPorFaltaDeRecursos(){
		JugadorTerran j = new JugadorTerran(new Recursos(0,0));
		DepositoDeSuministros d;
		Coordenadas coordenadas = new Coordenadas(1,1);
		
		d = j.construirDepositoDeSuministros(coordenadas);

		Assert.assertFalse(j.buscarConstruccion(d));
	}

	@Test
	public void JugadorNoPuedeConstruirRefineriaPorFaltaDeRecursos(){
		JugadorTerran j = new JugadorTerran(new Recursos(0,0));
		Refineria r;
		Coordenadas coordenadas = new Coordenadas(1,1);
		
		r = j.construirRefineria(coordenadas);

		Assert.assertFalse(j.buscarConstruccion(r));
	}

}
