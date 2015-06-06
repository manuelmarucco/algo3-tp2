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

		b = jugador.construirBarraca();
		i1 = b.getTiempoDeConstruccion();
		for (int i = 0; i < i1; i++) jugador.update();
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
		 for (int i = 0; i < 6; i ++) j.update();

		mapa.agregar(centroDeMineral,coordenadas);
		
		Assert.assertTrue(j.buscarConstruccion(centroDeMineral));
	}
	
	@Test
	public void SeConstruyeUnaRefineria() {

		JugadorTerran j = new JugadorTerran(new Recursos(150,150));
		Refineria r;
		int tdc;
		
		r = j.construirRefineria();
		tdc = r.getTiempoDeConstruccion();
		for (int i = 0; i < tdc; i ++) j.update();
		
		Assert.assertTrue(j.buscarConstruccion(r));
	}
	
	@Test
	public void SeConstruyeUnDepositoDeSuministros() {

		JugadorTerran j = new JugadorTerran(new Recursos(150,150));
		DepositoDeSuministros d ;
		int tdc;
		
		d = j.construirDepositoDeSuministros();
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

		int i1,i2;
		
		b = jugador.construirBarraca();
		i1 = b.getTiempoDeConstruccion();
		for (int i = 0; i < i1; i ++) jugador.update();
		
		Assert.assertTrue(jugador.buscarConstruccion(b));
		
		f = jugador.construirFabrica();
		i2 = f.getTiempoDeConstruccion();
		for (int i = 0; i < i2; i ++) jugador.update();

		Assert.assertTrue(jugador.buscarConstruccion(f));
	}
	
	@Test
	public void JugadorQuiereCrearFabricaPeroNecesitaBarraca(){
		JugadorTerran j = new JugadorTerran(new Recursos(10000,1000));
		Fabrica f;
		
		f = j.construirFabrica();

		Assert.assertFalse(j.buscarConstruccion(f));
	}
	
	@Test
	public void JugadorCreaPuertoEstelarConFabricaPrevia(){
		JugadorTerran j = new JugadorTerran(new Recursos(10000,1000));
		Barraca b;
		Fabrica f;
		PuertoEstelar p;
		int i1,i2,i3;

		b = j.construirBarraca();
		i1 = b.getTiempoDeConstruccion();
		for (int i = 0; i < i1; i ++) j.update();

		f = j.construirFabrica();
		i2 = f.getTiempoDeConstruccion();
		for (int i = 0; i < i2; i ++) j.update();

		p = j.construirPuertoEstelar();
		i3 = p.getTiempoDeConstruccion();
		for (int i = 0; i < i3; i ++) j.update();

		Assert.assertTrue(j.buscarConstruccion(p));
	}
	
	@Test
	public void JugadorQuiereCrearPuertoEstelarPeroNecesitaFabrica(){
		JugadorTerran j = new JugadorTerran(new Recursos(10000,1000));
		PuertoEstelar p;
		
		p = j.construirPuertoEstelar();

		Assert.assertFalse(j.buscarConstruccion(p));
	}
	
	//// RecursosInsuficientes para Construir
	
	@Test
	public void JugadorNoPuedeConstruirCentroDeMineralPorFaltaDeRecursos(){
		JugadorTerran j = new JugadorTerran(new Recursos(0,0));
		CentroDeMineral c;
		
		c = j.construirCentroDeMineral(coordenadas);

		Assert.assertFalse(j.buscarConstruccion(c));
	}
	
	@Test
	public void JugadorNoPuedeConstruirBarracaPorFaltaDeRecursos(){
		JugadorTerran j = new JugadorTerran(new Recursos(0,0));
		Barraca b;
		
		b = j.construirBarraca();

		Assert.assertFalse(j.buscarConstruccion(b));
	}
	
	@Test
	public void JugadorNoPuedeConstruirFabricaPorFaltaDeRecursos(){
		JugadorTerran j = new JugadorTerran(new Recursos(150,0));
		Barraca b;
		Fabrica f;
		
		j.construirBarraca();
		f = j.construirFabrica();

		Assert.assertFalse(j.buscarConstruccion(f));
	}
	
	@Test
	public void JugadorNoPuedeConstruirPuertoEstelarPorFaltaDeRecursos(){
		JugadorTerran j = new JugadorTerran(new Recursos(1000,100));
		PuertoEstelar p;

		j.construirBarraca(); //costo 150
		j.construirFabrica(); //costo 200,100
		p = j.construirPuertoEstelar(); //costo 150,100

		Assert.assertFalse(j.buscarConstruccion(p));
	}
	
	@Test
	public void JugadorNoPuedeConstruirDepositoDeSuministrosPorFaltaDeRecursos(){
		JugadorTerran j = new JugadorTerran(new Recursos(0,0));
		DepositoDeSuministros d;
		
		d = j.construirDepositoDeSuministros();

		Assert.assertFalse(j.buscarConstruccion(d));
	}
	
	@Test
	public void JugadorNoPuedeConstruirRefineriaPorFaltaDeRecursos(){
		JugadorTerran j = new JugadorTerran(new Recursos(0,0));
		Refineria r;
		
		r = j.construirRefineria();

		Assert.assertFalse(j.buscarConstruccion(r));
	}
}
