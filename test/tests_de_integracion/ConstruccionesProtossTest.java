package tests_de_integracion;

import construcciones.protoss.*;
import excepciones.ExcepcionNecesitaConstruirAcceso;
import excepciones.ExcepcionNecesitaConstruirPortalEstelar;
import excepciones.ExcepcionNoSePuedeConstruir;
import interfaces.Construible;
import jugabilidad.Jugador;
import jugabilidad.auxiliares.Recursos;
import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import razas.Protoss;

import java.util.ArrayList;



public class ConstruccionesProtossTest {
	
	//////////////////////// Verificacion de construccion de cada edificio ////////

	@Test
	public void SeConstruyeUnAcceso() {

		Jugador j = new Jugador(new Protoss(),new Recursos(1000,1000));
		Acceso b = new Acceso();
		int i1 = b.getTiempoDeConstruccion();
		
		j.construir(b);
		for(int i=0; i<i1; i++)	j.update();
		
		Assert.assertTrue(j.buscarConstruccion(b));
	}
	
	@Test
	public void SeConstruyeUnaNexoMineral() {

		Jugador j = new Jugador(new Protoss(),new Recursos(1000,1000));
		NexoMineral b = new NexoMineral(j.getRecursos());
		int i1 = b.getTiempoDeConstruccion();
		
		j.construir(b);
		for(int i=0; i<i1; i++)	j.update();
		
		Assert.assertTrue(j.buscarConstruccion(b));
	}
	
	@Test
	public void SeConstruyeUnaRefineria() {

		Jugador j = new Jugador(new Protoss(),new Recursos(1000,1000));
		Asimilador b = new Asimilador(j.getRecursos());
		int i1 = b.getTiempoDeConstruccion();
		
		j.construir(b);
		for(int i=0; i<i1; i++)	j.update();
		
		Assert.assertTrue(j.buscarConstruccion(b));
	}
	
	@Test
	public void SeConstruyeUnPilon() {

		Jugador j = new Jugador(new Protoss(),new Recursos(1000,1000));
		Pilon p = new Pilon(j);
		int t = p.getTiempoDeConstruccion();
		
		j.construir(p);
		for(int i=0; i<t; i++)	j.update();
		
		Assert.assertTrue(j.buscarConstruccion(p));
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
		int i1 = b.getTiempoDeConstruccion(),
			i2 = f.getTiempoDeConstruccion();
		
		j.construir(b);
		for(int i=0; i<i1; i++)	j.update();
		
		Assert.assertTrue(j.buscarConstruccion(b));
		
		j.construir(f);
		for(int i=0; i<i2; i++)	j.update();

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
		int i1 = b.getTiempoDeConstruccion(),
			i2 = f.getTiempoDeConstruccion(),
			i3 = f.getTiempoDeConstruccion();
		
		
		
		j.construir(b);
		for(int i=0; i<i1; i++)	j.update();
		j.construir(f);
		for(int i=0; i<i2; i++)	j.update();
		j.construir(p);
		for(int i=0; i<i3; i++)	j.update();

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
