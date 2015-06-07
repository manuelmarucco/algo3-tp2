package tests_de_integracion;

import construcciones.protoss.*;
import excepciones.ExcepcionNecesitaConstruirAcceso;
import excepciones.ExcepcionNecesitaConstruirPortalEstelar;
import excepciones.ExcepcionNoSePuedeConstruir;
import interfaces.Construible;
import jugabilidad.RazaDeJugador.JugadorProtoss;
import jugabilidad.auxiliares.Recursos;
import jugabilidad.utilidadesMapa.Coordenadas;
import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.util.ArrayList;



public class ConstruccionesProtossTest {

	//////////////////////// Verificacion de construccion de cada edificio ////////

	@Test
	public void SeConstruyeUnAcceso() {

		JugadorProtoss j = new JugadorProtoss(new Recursos(1000,1000));
		Acceso a;
		int i1;
		Coordenadas coordenadas = new Coordenadas(0,0);

		a = j.construirAcceso(coordenadas);
		i1 = a.getTiempoDeConstruccion();
		for(int i=0; i<i1; i++)	j.update();
		
		Assert.assertTrue(j.buscarConstruccion(a));
	}
	/*
	@Test
	public void SeConstruyeUnaNexoMineral() {

		JugadorProtoss j = new JugadorProtoss(new Recursos(1000,1000));
		NexoMineral n;
		int i1;
		
		n = j.construirNexoMineral(new Coordenadas(5,4));
		i1 = n.getTiempoDeConstruccion();
		for(int i=0; i<i1; i++)	j.update();
		
		Assert.assertTrue(j.buscarConstruccion(n));
	}
	*/
	/*
	@Test
	public void SeConstruyeUnaAsimilador() {

		JugadorProtoss j = new JugadorProtoss(new Recursos(1000,1000));
		Asimilador a;
		int i1;
		Coordenadas coordenadas = new Coordenadas(1,1);
		
		a = j.construirAsimilador(coordenadas);
		i1 = a.getTiempoDeConstruccion();
		for(int i=0; i<i1; i++)	j.update();
		
		Assert.assertTrue(j.buscarConstruccion(a));
	}

	@Test
	public void SeConstruyeUnPilon() {

		JugadorProtoss j = new JugadorProtoss(new Recursos(1000,1000));
		Pilon p;
		int t;
		Coordenadas coordenadas = new Coordenadas(1,1);
		
		p = j.construirPilon(coordenadas);
		t = p.getTiempoDeConstruccion();
		for(int i=0; i<t; i++)	j.update();
		
		Assert.assertTrue(j.buscarConstruccion(p));
	}
	*/
	/////////////////////// Construccion habilita a otra ////////////////////
	
	
	@Rule
	public ExpectedException exception = ExpectedException.none();
	@Test
	public void SeQuiereCrearPortalEstelarPeroNoEncuentraAccesoYExcepcion() throws ExcepcionNoSePuedeConstruir {
		ArrayList<Construible> cs =  new ArrayList<>();
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
		ArrayList<Construible> cs =  new ArrayList<>();
		Recursos recursosRecolectados = new Recursos(1000,1000);

		cs.add(new Acceso());
		
		ArchivosTemplarios p = new ArchivosTemplarios();

	    exception2.expect(ExcepcionNecesitaConstruirPortalEstelar.class);
		p.esConstruible(cs,recursosRecolectados);
		
	}
	
	@Test
	public void JugadorCreaPortalEstelarConAccesoPrevia(){
		JugadorProtoss j = new JugadorProtoss(new Recursos(1000,1000));
		Acceso a;
		PortalEstelar p;
		int i1,i2;
		
		a = j.construirAcceso(new Coordenadas(0,4));
		i1 = a.getTiempoDeConstruccion();
		for(int i=0; i<i1; i++)	j.update();
		
		Assert.assertTrue(j.buscarConstruccion(a));
		
		p = j.construirPortalEstelar(new Coordenadas(2,3));
		i2 = p.getTiempoDeConstruccion();
		for(int i=0; i<i2; i++)	j.update();

		Assert.assertTrue(j.buscarConstruccion(p));
	}
	
	@Test
	public void JugadorQuiereCrearPortalEstelarPeroNecesitaAcceso(){
		JugadorProtoss j = new JugadorProtoss(new Recursos(1000,1000));
		PortalEstelar p;
		Coordenadas coordenadas = new Coordenadas(0,5);

		p =j.construirPortalEstelar(coordenadas);

		Assert.assertFalse(j.buscarConstruccion(p));
	}
	
	@Test
	public void JugadorCreaArchivosTemplariosConPortalEstelarPrevia(){
		JugadorProtoss j = new JugadorProtoss(new Recursos(1000,1000));
		Acceso a;
		PortalEstelar p;
		ArchivosTemplarios at;
		int i1, i2,i3;

		a = j.construirAcceso(new Coordenadas(0,6));
		i1 = a.getTiempoDeConstruccion();
		for(int i=0; i<i1; i++)	j.update();

		p = j.construirPortalEstelar(new Coordenadas(0,7));
		i2 = p.getTiempoDeConstruccion();
		for(int i=0; i<i2; i++)	j.update();

		at = j.construirArchivosTemplarios(new Coordenadas(0,8));
		i3 = at.getTiempoDeConstruccion();
		for(int i=0; i<i3; i++)	j.update();

		Assert.assertTrue(j.buscarConstruccion(p));
	}
	
	@Test
	public void JugadorQuiereCrearArchivosTemplariosPeroNecesitaPortalEstelar(){
		JugadorProtoss j = new JugadorProtoss(new Recursos(1000,1000));
		ArchivosTemplarios at;
		
		at = j.construirArchivosTemplarios(new Coordenadas(0,9));

		Assert.assertFalse(j.buscarConstruccion(at));
	}
	
	// Construccion con Recursos Insuficientes
	/*
	@Test
	public void JugadorNoPuedeConstruirNexoMineralPorFaltaDeRecursos(){
		JugadorProtoss j = new JugadorProtoss(new Recursos(0,0));
		NexoMineral n;
		
		n = j.construirNexoMineral();

		Assert.assertFalse(j.buscarConstruccion(n));
	}
	*/
	@Test
	public void JugadorNoPuedeConstruirAccesoPorFaltaDeRecursos(){
		JugadorProtoss j = new JugadorProtoss(new Recursos(0,0));
		Acceso a;
		
		a = j.construirAcceso(new Coordenadas(1,0));

		Assert.assertFalse(j.buscarConstruccion(a));
	}
	
	@Test
	public void JugadorNoPuedeConstruirPortalEstelarPorFaltaDeRecursos(){
		JugadorProtoss j = new JugadorProtoss(new Recursos(150,0));
		Acceso a;
		PortalEstelar p;
		
		a = j.construirAcceso(new Coordenadas(1,2));
		p = j.construirPortalEstelar(new Coordenadas(1,3));

		Assert.assertFalse(j.buscarConstruccion(p));
	}
	
	@Test
	public void JugadorNoPuedeConstruirArchivosTemplariosPorFaltaDeRecursos(){
		JugadorProtoss j = new JugadorProtoss(new Recursos(1000,100));
		Acceso a;
		PortalEstelar p;
		ArchivosTemplarios at;
		
		a = j.construirAcceso(new Coordenadas(1,4)); //costo 150
		p = j.construirPortalEstelar(new Coordenadas(1,5)); //costo 200,100
		at = j.construirArchivosTemplarios(new Coordenadas(1,6)); //costo 150,100

		Assert.assertFalse(j.buscarConstruccion(p));
	}
	
	@Test
	public void JugadorNoPuedeConstruirPilonPorFaltaDeRecursos(){
		JugadorProtoss j = new JugadorProtoss(new Recursos(0,0));
		Pilon p;
		
		p = j.construirPilon(new Coordenadas(1,7));

		Assert.assertFalse(j.buscarConstruccion(p));
	}
	/*
	@Test
	public void JugadorNoPuedeConstruirAsimiladorPorFaltaDeRecursos(){
		JugadorProtoss j = new JugadorProtoss(new Recursos(0,0));
		Asimilador a;
		
		a = j.construirAsimilador();

		Assert.assertFalse(j.buscarConstruccion(a));
	}
*/
}
