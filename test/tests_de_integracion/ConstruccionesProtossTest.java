package tests_de_integracion;

import construcciones.protoss.*;
import excepciones.Mapa.ExcepcionNoSePudoAgregarAlMapa;
import excepciones.Mapa.ExcepcionPosicionOcupada;
import excepciones.construicciones.*;
import interfaces.Construible;
import jugabilidad.ProxyMapa;
import jugabilidad.RazaDeJugador.JugadorProtoss;
import jugabilidad.auxiliares.Recursos;
import jugabilidad.auxiliares.Suministros;
import jugabilidad.utilidadesMapa.Coordenadas;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import recursos.Cristal;
import recursos.Volcan;

import java.util.ArrayList;



public class ConstruccionesProtossTest {

	//////////////////////// Verificacion de construccion de cada edificio ////////

	@Before
	public void resetearProxy(){
		ProxyMapa.resetear();
	}

	@Test
	public void SeConstruyeUnAcceso() throws ExcepcionNoSePuedeConstruir, ExcepcionPosicionOcupada {

		JugadorProtoss j = new JugadorProtoss(new Recursos(1000,1000));
		Acceso a;
		int i1;
		Coordenadas coordenadas = new Coordenadas(0,0);

		a = j.construirAcceso(coordenadas);
		i1 = a.getTiempoDeConstruccion();
		for(int i=0; i<i1; i++)	j.update();
		
		Assert.assertTrue(j.buscarConstruccion(a));
	}


	@Test
	public void SeConstruyeUnaNexoMineralSobreUnCristal() throws ExcepcionNoSePudoAgregarAlMapa, ExcepcionNoSePuedeConstruir {
		JugadorProtoss j = new JugadorProtoss(new Recursos(150,0));
		Coordenadas coordenadas = new Coordenadas(1,1);
		Cristal cristal = new Cristal();
		NexoMineral nexoMineral;
		ProxyMapa mapa = ProxyMapa.getInstance();
		ProxyMapa.getInstance().setCoordenadasMaximas(10,10);

		mapa.agregar(cristal,coordenadas);

		nexoMineral = j.construirNexoMineral(coordenadas);
		for (int i = 0; i < nexoMineral.getTiempoDeConstruccion(); i ++) j.update();

		Assert.assertTrue(j.buscarConstruccion(nexoMineral));
	}

	@Test(expected = ExcepcionConstruccionNoRecolectaVolcan.class)
	public void SeQuiereConstruirUnaNexoMineralSobreUnVolcanYNoSePuede() throws ExcepcionNoSePudoAgregarAlMapa, ExcepcionNoSePuedeConstruir {
		JugadorProtoss j = new JugadorProtoss(new Recursos(150,0));
		Coordenadas coordenadas = new Coordenadas(0,1);
		Volcan volcan = new Volcan();
		NexoMineral NexoMineral;
		ProxyMapa mapa = ProxyMapa.getInstance();
		ProxyMapa.getInstance().setCoordenadasMaximas(10,10);

		mapa.agregar(volcan,coordenadas);

		NexoMineral = j.construirNexoMineral(coordenadas);
		for (int i = 0; i < NexoMineral.getTiempoDeConstruccion(); i ++) j.update();

		Assert.assertFalse(j.buscarConstruccion(NexoMineral));
	}


	@Test
	public void SeConstruyeUnaAsimilador() throws ExcepcionNoSePudoAgregarAlMapa, ExcepcionNoSePuedeConstruir {

		JugadorProtoss j = new JugadorProtoss(new Recursos(150,150));
		Asimilador r;
		Coordenadas coordenadas = new Coordenadas(1,4);
		Volcan volcan = new Volcan();
		ProxyMapa mapa = ProxyMapa.getInstance();
		ProxyMapa.getInstance().setCoordenadasMaximas(10,10);

		mapa.agregar(volcan,coordenadas);

		r = j.construirAsimilador(coordenadas);
		for (int i = 0; i < r.getTiempoDeConstruccion(); i ++) j.update();

		Assert.assertTrue(j.buscarConstruccion(r));
	}

	@Test(expected = ExcepcionConstruccionNoRecolectaCristal.class)
	public void SeQuiereConstruirUnaAsimiladorSobreUnVolcanYNoSePuede() throws ExcepcionNoSePudoAgregarAlMapa, ExcepcionNoSePuedeConstruir {
		JugadorProtoss j = new JugadorProtoss(new Recursos(150,0));
		Coordenadas coordenadas = new Coordenadas(9,6);
		Cristal cristal = new Cristal();
		Asimilador Asimilador;
		ProxyMapa mapa = ProxyMapa.getInstance();
		ProxyMapa.getInstance().setCoordenadasMaximas(10,10);

		mapa.agregar(cristal,coordenadas);

		Asimilador = j.construirAsimilador(coordenadas);
		for (int i = 0; i < Asimilador.getTiempoDeConstruccion(); i ++) j.update();

		Assert.assertFalse(j.buscarConstruccion(Asimilador));
	}


	@Test
	public void SeConstruyeUnPilonYAumentanLosSuministrosLimitesActuales() throws ExcepcionNoSePuedeConstruir, ExcepcionPosicionOcupada {
		Suministros suministros = new Suministros(0,0);
		JugadorProtoss j = new JugadorProtoss(new Recursos(1000,1000),suministros);
		Pilon p;
		int t;
		Coordenadas coordenadas = new Coordenadas(9,7);
		
		p = j.construirPilon(coordenadas);
		t = p.getTiempoDeConstruccion();
		for(int i=0; i<t; i++)	j.update();

		Assert.assertEquals(5,suministros.getSuministrosLimiteActuales());
		Assert.assertTrue(j.buscarConstruccion(p));
	}

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
		f.esConstruible(cs,recursosRecolectados,new Coordenadas(4,5));
		
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
		p.esConstruible(cs,recursosRecolectados,new Coordenadas(4,6));
		
	}
	
	@Test
	public void JugadorCreaPortalEstelarConAccesoPrevia() throws ExcepcionNoSePuedeConstruir, ExcepcionPosicionOcupada {
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
	
	@Test(expected = ExcepcionNecesitaConstruirAcceso.class)
	public void JugadorQuiereCrearPortalEstelarPeroNecesitaAcceso() throws ExcepcionNoSePuedeConstruir, ExcepcionPosicionOcupada {
		JugadorProtoss j = new JugadorProtoss(new Recursos(1000,1000));
		PortalEstelar p;
		Coordenadas coordenadas = new Coordenadas(0,5);

		p =j.construirPortalEstelar(coordenadas);

		Assert.assertFalse(j.buscarConstruccion(p));
	}
	
	@Test
	public void JugadorCreaArchivosTemplariosConPortalEstelarPrevia() throws ExcepcionNoSePuedeConstruir, ExcepcionPosicionOcupada {
		JugadorProtoss j = new JugadorProtoss(new Recursos(1000,1000));
		Acceso a;
		PortalEstelar p;
		ArchivosTemplarios at;
		int i1, i2,i3;

		a = j.construirAcceso(new Coordenadas(0,6));
		for(int i=0; i<a.getTiempoDeConstruccion(); i++)	j.update();

		p = j.construirPortalEstelar(new Coordenadas(0,7));
		for(int i=0; i<p.getTiempoDeConstruccion(); i++)	j.update();

		at = j.construirArchivosTemplarios(new Coordenadas(0,8));
		for(int i=0; i<at.getTiempoDeConstruccion(); i++)	j.update();

		Assert.assertTrue(j.buscarConstruccion(p));
	}
	
	@Test(expected = ExcepcionNecesitaConstruirPortalEstelar.class)
	public void JugadorQuiereCrearArchivosTemplariosPeroNecesitaPortalEstelar() throws ExcepcionNoSePuedeConstruir, ExcepcionPosicionOcupada {
		JugadorProtoss j = new JugadorProtoss(new Recursos(1000,1000));
		ArchivosTemplarios at;
		
		at = j.construirArchivosTemplarios(new Coordenadas(0,9));

		Assert.assertFalse(j.buscarConstruccion(at));
	}
	
	// Construccion con Recursos Insuficientes

	@Test(expected = ExcepcionMineralesInsuficientes.class)
	public void JugadorNoPuedeConstruirNexoMineralPorFaltaDeRecursos() throws ExcepcionNoSePudoAgregarAlMapa, ExcepcionNoSePuedeConstruir {
		JugadorProtoss j = new JugadorProtoss(new Recursos(0,0));
		NexoMineral c;
		Cristal cristal = new Cristal();
		Coordenadas coordenadas = new Coordenadas(1,7);
		ProxyMapa mapa = ProxyMapa.getInstance();
		ProxyMapa.getInstance().setCoordenadasMaximas(10,10);

		mapa.agregar(cristal,coordenadas);

		c = j.construirNexoMineral(coordenadas);

		Assert.assertFalse(j.buscarConstruccion(c));
	}
	
	@Test(expected = ExcepcionMineralesInsuficientes.class)
	public void JugadorNoPuedeConstruirAccesoPorFaltaDeRecursos() throws ExcepcionNoSePuedeConstruir, ExcepcionPosicionOcupada {
		JugadorProtoss j = new JugadorProtoss(new Recursos(0,0));
		Acceso a;
		
		a = j.construirAcceso(new Coordenadas(1,0));

		Assert.assertFalse(j.buscarConstruccion(a));
	}
	
	@Test(expected = ExcepcionMineralesInsuficientes.class)
	public void JugadorNoPuedeConstruirPortalEstelarPorFaltaDeRecursos() throws ExcepcionNoSePuedeConstruir, ExcepcionPosicionOcupada {
		JugadorProtoss j = new JugadorProtoss(new Recursos(150,0));
		Acceso a;
		PortalEstelar p;
		
		a = j.construirAcceso(new Coordenadas(1,2));
		for(int i=0; i<a.getTiempoDeConstruccion(); i++)	j.update();
		p = j.construirPortalEstelar(new Coordenadas(1,3));

		Assert.assertFalse(j.buscarConstruccion(p));
	}
	
	@Test(expected = ExcepcionGasInsuficiente.class)
	public void JugadorNoPuedeConstruirArchivosTemplariosPorFaltaDeRecursos() throws ExcepcionNoSePuedeConstruir, ExcepcionPosicionOcupada {
		JugadorProtoss j = new JugadorProtoss(new Recursos(1000,100));
		Acceso a;
		PortalEstelar p;
		ArchivosTemplarios at;
		
		a = j.construirAcceso(new Coordenadas(1,4)); //costo 150
		for(int i=0; i<a.getTiempoDeConstruccion(); i++)	j.update();
		p = j.construirPortalEstelar(new Coordenadas(1,5)); //costo 200,100
		for(int i=0; i<p.getTiempoDeConstruccion(); i++)	j.update();
		at = j.construirArchivosTemplarios(new Coordenadas(1,6)); //costo 150,100

		Assert.assertFalse(j.buscarConstruccion(p));
	}
	
	@Test(expected = ExcepcionMineralesInsuficientes.class)
	public void JugadorNoPuedeConstruirPilonPorFaltaDeRecursos() throws ExcepcionNoSePuedeConstruir, ExcepcionPosicionOcupada {
		JugadorProtoss j = new JugadorProtoss(new Recursos(0,0));
		Pilon p;
		
		p = j.construirPilon(new Coordenadas(1,7));

		Assert.assertFalse(j.buscarConstruccion(p));
	}


	@Test(expected = ExcepcionMineralesInsuficientes.class)
	public void JugadorNoPuedeConstruirAsimiladorPorFaltaDeRecursos() throws ExcepcionNoSePudoAgregarAlMapa, ExcepcionNoSePuedeConstruir {
		JugadorProtoss j = new JugadorProtoss(new Recursos(0,0));
		Asimilador a;
		Volcan volcan = new Volcan();
		Coordenadas coordenadas = new Coordenadas(9,3);
		ProxyMapa mapa = ProxyMapa.getInstance();
		ProxyMapa.getInstance().setCoordenadasMaximas(10,10);

		mapa.agregar(volcan,coordenadas);

		a = j.construirAsimilador(coordenadas);

		Assert.assertFalse(j.buscarConstruccion(a));
	}

	////////////CentrosDeRecoleccion sobre lugares donde no hay un recursos

	@Test(expected = ExcepcionPosicionOcupada.class)
	public void JugadorNoPuedeConstruirUnEdificioNoRecolectorDondeHayUnVolcan() throws ExcepcionNoSePudoAgregarAlMapa, ExcepcionNoSePuedeConstruir {
		JugadorProtoss j = new JugadorProtoss(new Recursos(1000,1000));
		Acceso b;
		Coordenadas coordenadas = new Coordenadas(8,1);
		ProxyMapa mapa = ProxyMapa.getInstance();
		ProxyMapa.getInstance().setCoordenadasMaximas(10,10);
		Volcan volcan = new Volcan();

		mapa.agregar(volcan,coordenadas);

		b = j.construirAcceso(coordenadas);

		Assert.assertFalse(j.buscarConstruccion(b));
	}

	@Test(expected = ExcepcionPosicionOcupada.class)
	public void JugadorNoPuedeConstruirUnEdificioNoRecolectoDondeHayUnCristal() throws ExcepcionNoSePudoAgregarAlMapa, ExcepcionNoSePuedeConstruir {
		JugadorProtoss j = new JugadorProtoss(new Recursos(1000,1000));
		Acceso b;
		Coordenadas coordenadas = new Coordenadas(8,1);
		ProxyMapa mapa = ProxyMapa.getInstance();
		ProxyMapa.getInstance().setCoordenadasMaximas(10,10);
		Cristal cristal = new Cristal();

		mapa.agregar(cristal,coordenadas);

		b = j.construirAcceso(coordenadas);

		Assert.assertFalse(j.buscarConstruccion(b));
	}

}
