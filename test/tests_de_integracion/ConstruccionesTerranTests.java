package tests_de_integracion;

import org.junit.Assert;
import org.junit.Rule;

import interfaces.Construible;

import java.util.ArrayList;

import jugabilidad.Jugador;
import jugabilidad.auxiliares.Recursos;

import org.junit.Test;
import org.junit.rules.ExpectedException;

import construcciones.terran.Barraca;
import construcciones.terran.CentroDeMineral;
import construcciones.terran.DepositoDeSuministros;
import construcciones.terran.Fabrica;
import construcciones.terran.PuertoEstelar;
import construcciones.terran.Refineria;
import excepciones.ExcepcionNecesitaConstruirBarraca;
import excepciones.ExcepcionNecesitaConstruirFabrica;


public class ConstruccionesTerranTests {
	
	//////////////////////// Verificacion de construccion de cada edificio ////////

	@Test
	public void SeConstruyeUnaBarraca() {

		Jugador j = new Jugador();
		Barraca b = new Barraca();
		
		j.construir(b);
		
		Assert.assertTrue(j.buscarConstruccion(b));
	}
	
	@Test
	public void SeConstruyeUnaCentroDeMineral() {

		Jugador j = new Jugador();
		CentroDeMineral b = new CentroDeMineral(j.getRecursos());
		
		j.construir(b);
		
		Assert.assertTrue(j.buscarConstruccion(b));
	}
	
	@Test
	public void SeConstruyeUnaRefineria() {

		Jugador j = new Jugador();
		Refineria b = new Refineria();
		
		j.construir(b);
		
		Assert.assertTrue(j.buscarConstruccion(b));
	}
	
	@Test
	public void SeConstruyeUnDepositoDeSuministros() {

		Jugador j = new Jugador();
		DepositoDeSuministros b = new DepositoDeSuministros(j);
		
		j.construir(b);
		
		Assert.assertTrue(j.buscarConstruccion(b));
	}
	
	/////////////////////// Construccion habilita a otra ////////////////////
	
	
	
	@Rule
	public ExpectedException exception = ExpectedException.none();
	@Test
	public void SeQuiereCrearFabricaPeroNoEncuentraBarracaYExcepcion() throws ExcepcionNecesitaConstruirBarraca {
		ArrayList<Construible> cs =  new ArrayList<Construible>();

		cs.add(new CentroDeMineral(new Recursos(100,100)));
		
		Fabrica f = new Fabrica();

	    exception.expect(ExcepcionNecesitaConstruirBarraca.class);
		f.verificaConstruccionPrevia(cs);
		
	}
	
	
	@Rule
	public ExpectedException exception2 = ExpectedException.none();
	@Test
	public void SeQuiereCrearPuertoEstelarPeroNoEncuentraFabricaYExcepcion() throws ExcepcionNecesitaConstruirFabrica {
		ArrayList<Construible> cs =  new ArrayList<Construible>();

		cs.add(new Barraca());
		
		PuertoEstelar p = new PuertoEstelar();

	    exception2.expect(ExcepcionNecesitaConstruirFabrica.class);
		p.verificaConstruccionPrevia(cs);
		
	}
	
	@Test
	public void JugadorCreaFabricaConBarracaPrevia(){
		Jugador j = new Jugador();
		Barraca b = new Barraca();
		Fabrica f = new Fabrica();
		
		j.construir(b);
		
		Assert.assertTrue(j.buscarConstruccion(b));
		
		j.construir(f);

		Assert.assertTrue(j.buscarConstruccion(f));
	}
	
	@Test
	public void JugadorQuiereCrearFabricaPeroNecesitaBarraca(){
		Jugador j = new Jugador();
		Fabrica f = new Fabrica();
		
		j.construir(f);

		Assert.assertFalse(j.buscarConstruccion(f));
	}
	
	@Test
	public void JugadorCreaPuertoEstelarConFabricaPrevia(){
		Jugador j = new Jugador();
		Barraca b = new Barraca();
		Fabrica f = new Fabrica();
		PuertoEstelar p = new PuertoEstelar();

		j.construir(b);
		j.construir(f);
		j.construir(p);

		Assert.assertTrue(j.buscarConstruccion(p));
	}
	
	@Test
	public void JugadorQuiereCrearPuertoEstelarPeroNecesitaFabrica(){
		Jugador j = new Jugador();
		PuertoEstelar p = new PuertoEstelar();
		
		j.construir(p);

		Assert.assertFalse(j.buscarConstruccion(p));
	}
	
}
