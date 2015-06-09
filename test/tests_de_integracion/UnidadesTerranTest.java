package tests_de_integracion;

import excepciones.ExcepcionAtacarAUnidadAliada;
import excepciones.ExcepcionObjetivoFueraDeRango;
import jugabilidad.Jugador;
import jugabilidad.ProxyMapa;
import jugabilidad.RazaDeJugador.JugadorProtoss;
import jugabilidad.RazaDeJugador.JugadorTerran;
import jugabilidad.auxiliares.Recursos;
import jugabilidad.auxiliares.Suministros;
import jugabilidad.utilidadesMapa.Coordenadas;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import unidades.ProxiDeAtaque;
import unidades.ProxyDeHechizos;
import unidades.protoss.AltoTemplario;
import unidades.protoss.ClonMagico;
import unidades.protoss.Zealot;
import unidades.terrran.Marine;
import unidades.terrran.NaveCiencia;

public class UnidadesTerranTest {

    @Before
    public void resetearProxy(){
        ProxyMapa.resetear();
    }
    @Test
    public void MarineAtacaAZealotDentroDeSuRango() throws ExcepcionObjetivoFueraDeRango, ExcepcionAtacarAUnidadAliada {
        Jugador j1 = new JugadorTerran(new Recursos(200,200),new Suministros(100,200));
        Jugador j2 = new JugadorProtoss(new Recursos(200,200),new Suministros(100,200));
        ProxiDeAtaque.inicializar(j1, j2);
        Marine marine = new Marine();
        j1.agregarUnidad(marine);
        Zealot zealot = new Zealot();
        j2.agregarUnidad(zealot);
        Coordenadas c1 = new Coordenadas(5,5);
        Coordenadas c2 = new Coordenadas(6,6);
        ProxyMapa mapa = ProxyMapa.getInstance();
        ProxyMapa.getInstance().setCoordenadasMaximas(10,10);
        mapa.agregar(marine, c1);
        mapa.agregar(zealot, c2);
        ProxiDeAtaque.comprobarRango(marine, zealot);
        marine.atacarTierra(zealot);
        Assert.assertEquals(54,zealot.getEscudo());
    }

    @Test(expected = ExcepcionObjetivoFueraDeRango.class)
    public void MarineAtacaAZealotFueraDeSuRango() throws ExcepcionObjetivoFueraDeRango {
        Jugador j1 = new JugadorTerran(new Recursos(200,200),new Suministros(100,200));
        Jugador j2 = new JugadorProtoss(new Recursos(200,200),new Suministros(100,200));
        ProxiDeAtaque.inicializar(j1, j2);
        Marine marine = new Marine();
        j1.agregarUnidad(marine);
        Zealot zealot = new Zealot();
        j2.agregarUnidad(zealot);
        Coordenadas c1 = new Coordenadas(3,3);
        Coordenadas c2 = new Coordenadas(8,8);
        ProxyMapa.getInstance().setCoordenadasMaximas(10,10);
        ProxyMapa mapa = ProxyMapa.getInstance();
        mapa.agregar(marine, c1);
        mapa.agregar(zealot, c2);
        ProxiDeAtaque.comprobarRango(marine, zealot);
    }

    @Test
    public void NaveCienciaLanzaEMPDejaSinEscudoYEnergiaAUnAltoTemplario(){
        Jugador j1 = new JugadorTerran(new Recursos(200,200),new Suministros(100,200));
        Jugador j2 = new JugadorTerran(new Recursos(200,200),new Suministros(100,200));
        ProxyDeHechizos.inicializar(j1, j2);
        NaveCiencia nc = new NaveCiencia();
        j1.agregarUnidad(nc);
        AltoTemplario at = new AltoTemplario();
        j2.agregarUnidad(at);
        Coordenadas c1 = new Coordenadas(4,4);
        Coordenadas c2 = new Coordenadas(9,9);
        ProxyMapa.getInstance().setCoordenadasMaximas(10,10);
        ProxyMapa mapa = ProxyMapa.getInstance();
        mapa.agregar(nc,c1);
        mapa.agregar(at, c2);
        nc.update();
        nc.update();
        nc.update();
        nc.update();
        nc.update();
        nc.EMP(c2);
        Assert.assertEquals(0, at.getEscudo());
        Assert.assertEquals(0, at.getEnergia());
    }

    @Test
    public void NaveCienciaLanzaRadiacionYBajaLaVidaAlTemplario(){//baja de a 6 por q recupera 10% de escudo por turno (4)
        Jugador j1 = new JugadorTerran(new Recursos(200,200),new Suministros(100,200));
        Jugador j2 = new JugadorTerran(new Recursos(200,200),new Suministros(100,200));
        ProxyDeHechizos.inicializar(j1, j2);
        NaveCiencia nc = new NaveCiencia();
        j1.agregarUnidad(nc);
        AltoTemplario at = new AltoTemplario();
        j2.agregarUnidad(at);
        Coordenadas c1 = new Coordenadas(1,1);
        Coordenadas c2 = new Coordenadas(6,5);
        ProxyMapa.getInstance().setCoordenadasMaximas(10,10);
        ProxyMapa mapa = ProxyMapa.getInstance();
        mapa.agregar(nc,c1);
        mapa.agregar(at, c2);
        nc.update();
        nc.update();
        nc.update();
        nc.update();
        nc.update();
        nc.Radiacion(at);
        Assert.assertEquals(40, at.getEscudo());
        at.update();
        Assert.assertEquals(32, at.getEscudo());
        at.update();
        Assert.assertEquals(24, at.getEscudo());
        at.update();
        Assert.assertEquals(16, at.getEscudo());
        at.update();
        Assert.assertEquals(8, at.getEscudo());
        at.update();
        Assert.assertEquals(2, at.getEscudo());
        Assert.assertEquals(38, at.getVida());

        at.update();
        Assert.assertEquals(2, at.getEscudo());
        Assert.assertEquals(30, at.getVida());

        at.update();
        Assert.assertEquals(2, at.getEscudo());
        Assert.assertEquals(22, at.getVida());
        at.update();
        Assert.assertEquals(2, at.getEscudo());
        Assert.assertEquals(14,at.getVida());
    }
    //TODO: arreglar este test
    @Test
    public void testAltoTemplarioSeClonaYUnaNaveDeCienciaMataAlosClones(){
        Jugador j1 = new JugadorTerran(new Recursos(200,200),new Suministros(100,200));
        Jugador j2 = new JugadorTerran(new Recursos(200,200),new Suministros(100,200));
        ProxyDeHechizos.inicializar(j1, j2);
        NaveCiencia nc = new NaveCiencia();
        j1.agregarUnidad(nc);
        AltoTemplario at = new AltoTemplario();
        j2.agregarUnidad(at);
        Coordenadas c1 = new Coordenadas(3,2);
        Coordenadas c2 = new Coordenadas(8,8);
        Coordenadas c3 = new Coordenadas(9,8);
        Coordenadas c4 = new Coordenadas(8,9);
        ProxyMapa mapa = ProxyMapa.getInstance();
        ProxyMapa.getInstance().setCoordenadasMaximas(10,10);

        mapa.agregar(nc, c1);
        mapa.agregar(at, c2);
        nc.update();
        nc.update();
        nc.update();
        nc.update();
        nc.update();

        at.update();
        at.update();
        at.update();
        at.update();
        at.update();
        at.alucinacion(at, c3, c4);
        Assert.assertEquals(ClonMagico.class, mapa.obtenerDeCapaTerrestre(c3).getClass());
        Assert.assertEquals(ClonMagico.class, mapa.obtenerDeCapaTerrestre(c4).getClass());
        nc.EMP(c2);

        Assert.assertEquals(null, mapa.obtenerDeCapaTerrestre(c3));
        Assert.assertEquals(null,mapa.obtenerDeCapaTerrestre(c4));
    }

}
