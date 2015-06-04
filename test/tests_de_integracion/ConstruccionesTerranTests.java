package tests_de_integracion;

import org.junit.Assert;

import interfaces.Construible;

import java.util.ArrayList;

import jugabilidad.Jugador;

import org.junit.Test;

import construcciones.terran.Barraca;
import construcciones.terran.CentroDeMineral;
import construcciones.terran.Fabrica;
import construcciones.terran.PuertoEstelar;
import excepciones.ExcepcionNecesitaConstruirBarraca;
import excepciones.ExcepcionNecesitaConstruirFabrica;


public class ConstruccionesTerranTests {
	
	@Test
	public void BarracaHabilitaFabrica() {
		ArrayList<Construible> cs =  new ArrayList<Construible>();

		cs.add(new CentroDeMineral());
		cs.add(new Barraca());
		
		Fabrica f = new Fabrica();
		
		try {
			f.verificaConstruccionPrevia(cs);
		} catch (ExcepcionNecesitaConstruirBarraca e) {
			//e.printStackTrace();
		}
		
		Assert.assertTrue(true);
	}
	
	@Test
	public void FabricaHabilitaPuertoEstelar() {
		ArrayList<Construible> cs =  new ArrayList<Construible>();

		cs.add(new CentroDeMineral());
		cs.add(new Barraca());
		cs.add(new Fabrica());
		
		PuertoEstelar p = new PuertoEstelar();
		
		try {
			p.verificaConstruccionPrevia(cs);
		} catch (ExcepcionNecesitaConstruirFabrica e) {
			//e.printStackTrace();
		}
		
		Assert.assertTrue(true);
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
