package tests_de_integracion;

import org.junit.Assert;
import org.junit.Rule;

import interfaces.Construible;

import java.util.ArrayList;

import jugabilidad.Jugador;
import jugabilidad.auxiliares.Recursos;

import org.junit.Test;
import org.junit.rules.ExpectedException;

import razas.Protoss;
import razas.Terran;
import construcciones.terran.Barraca;
import construcciones.terran.CentroDeMineral;
import construcciones.terran.DepositoDeSuministros;
import construcciones.terran.Fabrica;
import construcciones.terran.PuertoEstelar;
import construcciones.terran.Refineria;
import excepciones.ExcepcionNoSePuedeConstruir;


public class ConstruccionesTerranTests {
	
	//////////////////////// Verificacion de construccion de cada edificio ////////

	@Test
	public void SeConstruyeUnaBarraca() {

		Jugador j = new Jugador(new Terran(),new Recursos(150,0));
		Barraca b = new Barraca();
		
		
		j.construir(b);
		 for (int i = 0; i < 12; i ++) j.update();
		
		Assert.assertTrue(j.buscarConstruccion(b));
	}
	
	@Test
	public void SeConstruyeUnaCentroDeMineral() {

		Jugador j = new Jugador(new Terran(),new Recursos(150,0));
		CentroDeMineral b = new CentroDeMineral(j.getRecursos());
		
		j.construir(b);
		 for (int i = 0; i < 6; i ++) j.update();
		
		Assert.assertTrue(j.buscarConstruccion(b));
	}
	
	@Test
	public void SeConstruyeUnaRefineria() {

		Jugador j = new Jugador(new Terran(),new Recursos(150,150));
		Refineria b = new Refineria(j.getRecursos());
		
		j.construir(b);
		for (int i = 0; i < 12; i ++) j.update();
		
		Assert.assertTrue(j.buscarConstruccion(b));
	}
	
	@Test
	public void SeConstruyeUnDepositoDeSuministros() {

		Jugador j = new Jugador(new Terran(),new Recursos(150,150));
		DepositoDeSuministros b = new DepositoDeSuministros(j);
		
		j.construir(b);
		for (int i = 0; i < 12; i ++) j.update();
		
		Assert.assertTrue(j.buscarConstruccion(b));
	}
	
	/////////////////////// Construccion habilita a otra ////////////////////
	
	
	
	@Rule
	public ExpectedException exception = ExpectedException.none();
	@Test
	public void SeQuiereCrearFabricaPeroNoEncuentraBarracaYExcepcion() throws ExcepcionNoSePuedeConstruir {
		ArrayList<Construible> cs =  new ArrayList<Construible>();
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
		ArrayList<Construible> cs =  new ArrayList<Construible>();
		Recursos recursosRecolectados =  new Recursos(1000,1000);
		
		cs.add(new Barraca());
		
		PuertoEstelar p = new PuertoEstelar();

	    exception2.expect(ExcepcionNoSePuedeConstruir.class);
		p.esConstruible(cs,recursosRecolectados);
		
	}
	
	@Test
	public void JugadorCreaFabricaConBarracaPrevia(){
		Jugador j = new Jugador(new Terran(),new Recursos(1000,1000));
		Barraca b = new Barraca();
		Fabrica f = new Fabrica();
		int i1 = b.getTiempoDeConstruccion(),
			i2 = f.getTiempoDeConstruccion();
		
		j.construir(b);
		for (int i = 0; i < i1; i ++) j.update();
		
		Assert.assertTrue(j.buscarConstruccion(b));
		
		j.construir(f);
		for (int i = 0; i < i2; i ++) j.update();

		Assert.assertTrue(j.buscarConstruccion(f));
	}
	
	@Test
	public void JugadorQuiereCrearFabricaPeroNecesitaBarraca(){
		Jugador j = new Jugador(new Terran(),new Recursos(1000,1000));
		Fabrica f = new Fabrica();
		
		j.construir(f);

		Assert.assertFalse(j.buscarConstruccion(f));
	}
	
	@Test
	public void JugadorCreaPuertoEstelarConFabricaPrevia(){
		Jugador j = new Jugador(new Terran(),new Recursos(1000,1000));
		Barraca b = new Barraca();
		Fabrica f = new Fabrica();
		PuertoEstelar p = new PuertoEstelar();
		int i1 = b.getTiempoDeConstruccion(),
			i2 = f.getTiempoDeConstruccion(),
			i3 = p.getTiempoDeConstruccion();

		j.construir(b); 
		for (int i = 0; i < i1; i ++) j.update();
		j.construir(f);	
		for (int i = 0; i < i2; i ++) j.update();
		j.construir(p);

		for (int i = 0; i < i3; i ++) j.update();

		Assert.assertTrue(j.buscarConstruccion(p));
	}
	
	@Test
	public void JugadorQuiereCrearPuertoEstelarPeroNecesitaFabrica(){
		Jugador j = new Jugador(new Terran(),new Recursos(1000,1000));
		PuertoEstelar p = new PuertoEstelar();
		
		j.construir(p);

		Assert.assertFalse(j.buscarConstruccion(p));
	}
	
	//// RecursosInsuficientes para Construir
	
	@Test
	public void JugadorNoPuedeConstruirCentroDeMineralPorFaltaDeRecursos(){
		Jugador j = new Jugador(new Terran(),new Recursos(0,0));
		CentroDeMineral p = new CentroDeMineral(j.getRecursos());
		
		j.construir(p);

		Assert.assertFalse(j.buscarConstruccion(p));
	}
	
	@Test
	public void JugadorNoPuedeConstruirBarracaPorFaltaDeRecursos(){
		Jugador j = new Jugador(new Terran(),new Recursos(0,0));
		Barraca p = new Barraca();
		
		j.construir(p);

		Assert.assertFalse(j.buscarConstruccion(p));
	}
	
	@Test
	public void JugadorNoPuedeConstruirFabricaPorFaltaDeRecursos(){
		Jugador j = new Jugador(new Terran(),new Recursos(150,0));
		Barraca b = new Barraca();
		Fabrica f = new Fabrica();
		
		j.construir(b);
		j.construir(f);

		Assert.assertFalse(j.buscarConstruccion(f));
	}
	
	@Test
	public void JugadorNoPuedeConstruirPuertoEstelarPorFaltaDeRecursos(){
		Jugador j = new Jugador(new Terran(),new Recursos(1000,100));
		Barraca b = new Barraca(); //costo 150
		Fabrica f = new Fabrica(); //costo 200,100
		PuertoEstelar p = new PuertoEstelar(); //costo 150,100
		
		j.construir(b);
		j.construir(f);
		j.construir(p);

		Assert.assertFalse(j.buscarConstruccion(p));
	}
	
	@Test
	public void JugadorNoPuedeConstruirDepositoDeSuministrosPorFaltaDeRecursos(){
		Jugador j = new Jugador(new Terran(),new Recursos(0,0));
		DepositoDeSuministros p = new DepositoDeSuministros(j);
		
		j.construir(p);

		Assert.assertFalse(j.buscarConstruccion(p));
	}
	
	@Test
	public void JugadorNoPuedeConstruirRefineriaPorFaltaDeRecursos(){
		Recursos r = new Recursos(0,0);
		Jugador j = new Jugador(new Protoss(),r);
		Refineria p = new Refineria(r);
		
		j.construir(p);

		Assert.assertFalse(j.buscarConstruccion(p));
	}
}
