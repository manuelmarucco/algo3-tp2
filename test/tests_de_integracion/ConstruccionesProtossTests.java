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
import construcciones.protoss.Acceso;
import construcciones.protoss.ArchivosTemplarios;
import construcciones.protoss.Asimilador;
import construcciones.protoss.NexoMineral;
import construcciones.protoss.Pilon;
import construcciones.protoss.PortalEstelar;
import construcciones.terran.Refineria;
import excepciones.ExcepcionNecesitaConstruirAcceso;
import excepciones.ExcepcionNecesitaConstruirPortalEstelar;
import excepciones.ExcepcionNoSePuedeConstruir;



public class ConstruccionesProtossTests {
	
	//////////////////////// Verificacion de construccion de cada edificio ////////

	@Test
	public void SeConstruyeUnAcceso() {

		Jugador j = new Jugador(new Protoss(),new Recursos(1000,1000));
		Acceso b = new Acceso();
		
		j.construir(b);
		
		Assert.assertTrue(j.buscarConstruccion(b));
	}
	
	@Test
	public void SeConstruyeUnaNexoMineral() {

		Jugador j = new Jugador(new Protoss(),new Recursos(1000,1000));
		NexoMineral b = new NexoMineral(j.getRecursos());
		
		j.construir(b);
		
		Assert.assertTrue(j.buscarConstruccion(b));
	}
	
	@Test
	public void SeConstruyeUnaRefineria() {

		Jugador j = new Jugador(new Protoss(),new Recursos(1000,1000));
		Asimilador b = new Asimilador(j.getRecursos());
		
		j.construir(b);
		
		Assert.assertTrue(j.buscarConstruccion(b));
	}
	
	@Test
	public void SeConstruyeUnPilon() {

		Jugador j = new Jugador(new Protoss(),new Recursos(1000,1000));
		Pilon b = new Pilon(j);
		
		j.construir(b);
		
		Assert.assertTrue(j.buscarConstruccion(b));
	}
	
	/////////////////////// Construccion habilita a otra ////////////////////
	
	
	@Rule
	public ExpectedException exception = ExpectedException.none();
	@Test
	public void SeQuiereCrearPortalEstelarPeroNoEncuentraAccesoYExcepcion() throws ExcepcionNoSePuedeConstruir {
		ArrayList<Construible> cs =  new ArrayList<Construible>();
		Recursos recursosRecolectados = new Recursos(1000,1000);
		
		cs.add(new NexoMineral(recursosRecolectados));
		
		PortalEstelar f = new PortalEstelar();

	    exception.expect(ExcepcionNecesitaConstruirAcceso.class);
		f.esConstruible(cs,recursosRecolectados);
		
	}
	
	
	@Rule
	public ExpectedException exception2 = ExpectedException.none();
	@Test
	public void SeQuiereCrearArchivosTemplariosrPeroNoEncuentraPortalEstelarYExcepcion() throws ExcepcionNoSePuedeConstruir {
		ArrayList<Construible> cs =  new ArrayList<Construible>();
		Recursos recursosRecolectados = new Recursos(1000,1000);

		cs.add(new Acceso());
		
		ArchivosTemplarios p = new ArchivosTemplarios();

	    exception2.expect(ExcepcionNecesitaConstruirPortalEstelar.class);
		p.esConstruible(cs,recursosRecolectados);
		
	}
	
	@Test
	public void JugadorCreaPortalEstelarConAccesoPrevia(){
		Jugador j = new Jugador(new Protoss(),new Recursos(1000,1000));
		Acceso b = new Acceso();
		PortalEstelar f = new PortalEstelar();
		
		j.construir(b);
		
		Assert.assertTrue(j.buscarConstruccion(b));
		
		j.construir(f);

		Assert.assertTrue(j.buscarConstruccion(f));
	}
	
	@Test
	public void JugadorQuiereCrearPortalEstelarPeroNecesitaAcceso(){
		Jugador j = new Jugador(new Protoss(),new Recursos(1000,1000));
		PortalEstelar f = new PortalEstelar();
		
		j.construir(f);

		Assert.assertFalse(j.buscarConstruccion(f));
	}
	
	@Test
	public void JugadorCreaArchivosTemplariosConPortalEstelarPrevia(){
		Jugador j = new Jugador(new Protoss(),new Recursos(1000,1000));
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
		Jugador j = new Jugador(new Protoss(),new Recursos(1000,1000));
		ArchivosTemplarios p = new ArchivosTemplarios();
		
		j.construir(p);

		Assert.assertFalse(j.buscarConstruccion(p));
	}
	
	// Construccion con Recursos Insuficientes
	
	@Test
	public void JugadorNoPuedeConstruirNexoMineralPorFaltaDeRecursos(){
		Jugador j = new Jugador(new Protoss(),new Recursos(0,0));
		NexoMineral p = new NexoMineral(j.getRecursos());
		
		j.construir(p);

		Assert.assertFalse(j.buscarConstruccion(p));
	}
	
	@Test
	public void JugadorNoPuedeConstruirAccesoPorFaltaDeRecursos(){
		Jugador j = new Jugador(new Protoss(),new Recursos(0,0));
		Acceso p = new Acceso();
		
		j.construir(p);

		Assert.assertFalse(j.buscarConstruccion(p));
	}
	
	@Test
	public void JugadorNoPuedeConstruirPortalEstelarPorFaltaDeRecursos(){
		Jugador j = new Jugador(new Protoss(),new Recursos(150,0));
		Acceso b = new Acceso();
		PortalEstelar f = new PortalEstelar();
		
		j.construir(b);
		j.construir(f);

		Assert.assertFalse(j.buscarConstruccion(f));
	}
	
	@Test
	public void JugadorNoPuedeConstruirArchivosTemplariosPorFaltaDeRecursos(){
		Jugador j = new Jugador(new Protoss(),new Recursos(1000,100));
		Acceso b = new Acceso(); //costo 150
		PortalEstelar f = new PortalEstelar(); //costo 200,100
		ArchivosTemplarios p = new ArchivosTemplarios(); //costo 150,100
		
		j.construir(b);
		j.construir(f);
		j.construir(p);

		Assert.assertFalse(j.buscarConstruccion(p));
	}
	
	@Test
	public void JugadorNoPuedeConstruirPilonPorFaltaDeRecursos(){
		Jugador j = new Jugador(new Protoss(),new Recursos(0,0));
		Pilon p = new Pilon(j);
		
		j.construir(p);

		Assert.assertFalse(j.buscarConstruccion(p));
	}
	
	@Test
	public void JugadorNoPuedeConstruirAsimiladorPorFaltaDeRecursos(){
		Recursos r = new Recursos(0,0);
		Jugador j = new Jugador(new Protoss(),r);
		Asimilador p = new Asimilador(r);
		
		j.construir(p);

		Assert.assertFalse(j.buscarConstruccion(p));
	}
	
}
