package tests_de_integracion;

import org.junit.Assert;
import org.junit.Rule;

import interfaces.Construible;

import java.util.ArrayList;

import jugabilidad.Jugador;
import jugabilidad.auxiliares.Recursos;

import org.junit.Test;
import org.junit.rules.ExpectedException;

import construcciones.protoss.Acceso;
import construcciones.protoss.ArchivosTemplarios;
import construcciones.protoss.Asimilador;
import construcciones.protoss.NexoMineral;
import construcciones.protoss.Pilon;
import construcciones.protoss.PortalEstelar;
import excepciones.ExcepcionNecesitaConstruirAcceso;
import excepciones.ExcepcionNecesitaConstruirPortalEstelar;



public class ConstruccionesProtossTests {
	
	//////////////////////// Verificacion de construccion de cada edificio ////////

	@Test
	public void SeConstruyeUnaBarraca() {

		Jugador j = new Jugador();
		Acceso b = new Acceso();
		
		j.construir(b);
		
		Assert.assertTrue(j.buscarConstruccion(b));
	}
	
	@Test
	public void SeConstruyeUnaCentroDeMineral() {

		Jugador j = new Jugador();
		NexoMineral b = new NexoMineral(j.getRecursos());
		
		j.construir(b);
		
		Assert.assertTrue(j.buscarConstruccion(b));
	}
	
	@Test
	public void SeConstruyeUnaRefineria() {

		Jugador j = new Jugador();
		Asimilador b = new Asimilador(j.getRecursos());
		
		j.construir(b);
		
		Assert.assertTrue(j.buscarConstruccion(b));
	}
	
	@Test
	public void SeConstruyeUnPilon() {

		Jugador j = new Jugador();
		Pilon b = new Pilon(j);
		
		j.construir(b);
		
		Assert.assertTrue(j.buscarConstruccion(b));
	}
	
	/////////////////////// Construccion habilita a otra ////////////////////
	
	
	@Rule
	public ExpectedException exception = ExpectedException.none();
	@Test
	public void SeQuiereCrearPortalEstelarPeroNoEncuentraAccesoYExcepcion() throws ExcepcionNecesitaConstruirAcceso {
		ArrayList<Construible> cs =  new ArrayList<Construible>();

		cs.add(new NexoMineral(new Recursos(100,100)));
		
		PortalEstelar f = new PortalEstelar();

	    exception.expect(ExcepcionNecesitaConstruirAcceso.class);
		f.verificaConstruccionPrevia(cs);
		
	}
	
	
	@Rule
	public ExpectedException exception2 = ExpectedException.none();
	@Test
	public void SeQuiereCrearArchivosTemplariosrPeroNoEncuentraPortalEstelarYExcepcion() throws ExcepcionNecesitaConstruirPortalEstelar {
		ArrayList<Construible> cs =  new ArrayList<Construible>();

		cs.add(new Acceso());
		
		ArchivosTemplarios p = new ArchivosTemplarios();

	    exception2.expect(ExcepcionNecesitaConstruirPortalEstelar.class);
		p.verificaConstruccionPrevia(cs);
		
	}
	
	@Test
	public void JugadorCreaPortalEstelarConAccesoPrevia(){
		Jugador j = new Jugador();
		Acceso b = new Acceso();
		PortalEstelar f = new PortalEstelar();
		
		j.construir(b);
		
		Assert.assertTrue(j.buscarConstruccion(b));
		
		j.construir(f);

		Assert.assertTrue(j.buscarConstruccion(f));
	}
	
	@Test
	public void JugadorQuiereCrearPortalEstelarPeroNecesitaAcceso(){
		Jugador j = new Jugador();
		PortalEstelar f = new PortalEstelar();
		
		j.construir(f);

		Assert.assertFalse(j.buscarConstruccion(f));
	}
	
	@Test
	public void JugadorCreaArchivosTemplariosConPortalEstelarPrevia(){
		Jugador j = new Jugador();
		Acceso b = new Acceso();
		PortalEstelar f = new PortalEstelar();
		ArchivosTemplarios p = new ArchivosTemplarios();

		j.construir(b);
		j.construir(f);
		j.construir(p);

		Assert.assertTrue(j.buscarConstruccion(p));
	}
	
	@Test
	public void JugadorQuiereCrearArchivosTemplariosPeroNecesitaPortalEstelar(){
		Jugador j = new Jugador();
		ArchivosTemplarios p = new ArchivosTemplarios();
		
		j.construir(p);

		Assert.assertFalse(j.buscarConstruccion(p));
	}
	
}
