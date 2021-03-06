package tests_de_integracion;

import modelo.excepciones.Mapa.ExcepcionCasillaVacia;
import modelo.excepciones.Mapa.ExcepcionNoSePudoAgregarAlMapa;
import modelo.excepciones.Unidades.ExcepcionDeAccionDeUnidad;
import modelo.excepciones.Unidades.ExcepcionObjetivoFueraDeRango;
import modelo.excepciones.Unidades.ExcepcionYaActuo;
import modelo.excepciones.Unidades.ExcepcionYaSeMovioLaUnidad;
import modelo.excepciones.construcciones.ExcepcionNoSePuedeClonarEdificio;
import modelo.jugabilidad.Jugador;
import modelo.jugabilidad.ProxyMapa;
import modelo.jugabilidad.RazaDeJugador.JugadorProtoss;
import modelo.jugabilidad.RazaDeJugador.JugadorTerran;
import modelo.jugabilidad.auxiliares.Recursos;
import modelo.jugabilidad.auxiliares.Suministros;
import modelo.jugabilidad.auxiliares.Vision;
import modelo.jugabilidad.utilidadesMapa.Coordenada;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import modelo.unidades.ProxiDeAtaque;
import modelo.unidades.ProxyDeHechizos;
import modelo.unidades.protoss.AltoTemplario;
import modelo.unidades.protoss.ClonMagico;
import modelo.unidades.protoss.Zealot;
import modelo.unidades.terrran.Marine;
import modelo.unidades.terrran.NaveCiencia;

public class UnidadesTerranTest {
    Vision v = Vision.VisionCompleta(10,10);
    @Before
    public void resetearProxy(){
        ProxyMapa.resetear();
    }
    @Test
    public void MarineAtacaAZealotDentroDeSuRango() throws ExcepcionDeAccionDeUnidad, ExcepcionNoSePudoAgregarAlMapa {
        Jugador j1 = new JugadorTerran(new Recursos(200,200),new Suministros(100,200));
        Jugador j2 = new JugadorProtoss(new Recursos(200,200),new Suministros(100,200));
        ProxiDeAtaque.inicializar(j1);
        ProxiDeAtaque.inicializar(j2);
        ProxyDeHechizos.inicializar(j1);
        ProxyDeHechizos.inicializar(j2);
        Marine marine = new Marine(v);
        j1.agregarUnidad(marine);
        Zealot zealot = new Zealot(v);
        j2.agregarUnidad(zealot);
        Coordenada c1 = new Coordenada(5,5);
        Coordenada c2 = new Coordenada(6,6);
        ProxyMapa mapa = ProxyMapa.getInstance();
        ProxyMapa.getInstance().setCoordenadasMaximas(10, 10);
        mapa.agregar(marine, c1);
        mapa.agregar(zealot, c2);
        marine.atacar(c2);
        Assert.assertEquals(54,zealot.getEscudo());
    }

    @Test(expected = ExcepcionObjetivoFueraDeRango.class)
    public void MarineAtacaAZealotFueraDeSuRango() throws ExcepcionDeAccionDeUnidad, ExcepcionNoSePudoAgregarAlMapa {
        Jugador j1 = new JugadorTerran(new Recursos(200,200),new Suministros(100,200));
        Jugador j2 = new JugadorProtoss(new Recursos(200,200),new Suministros(100,200));
        ProxiDeAtaque.inicializar(j1);
        ProxiDeAtaque.inicializar(j2);
        ProxyDeHechizos.inicializar(j1);
        ProxyDeHechizos.inicializar(j2);
        Marine marine = new Marine(v);
        j1.agregarUnidad(marine);
        Zealot zealot = new Zealot(v);
        j2.agregarUnidad(zealot);
        Coordenada c1 = new Coordenada(3,3);
        Coordenada c2 = new Coordenada(8,8);
        ProxyMapa.getInstance().setCoordenadasMaximas(10, 10);
        ProxyMapa mapa = ProxyMapa.getInstance();
        mapa.agregar(marine, c1);
        mapa.agregar(zealot, c2);
        ProxiDeAtaque.comprobarRangoTerrestre(marine, zealot);
    }

    @Test
    public void NaveCienciaLanzaEMPDejaSinEscudoYEnergiaAUnAltoTemplario() throws ExcepcionNoSePudoAgregarAlMapa, ExcepcionDeAccionDeUnidad {
        Jugador j1 = new JugadorTerran(new Recursos(200,200),new Suministros(100,200));
        Jugador j2 = new JugadorTerran(new Recursos(200,200),new Suministros(100,200));
        ProxiDeAtaque.inicializar(j1);
        ProxiDeAtaque.inicializar(j2);
        ProxyDeHechizos.inicializar(j1);
        ProxyDeHechizos.inicializar(j2);
        NaveCiencia nc = new NaveCiencia(v);
        j1.agregarUnidad(nc);
        AltoTemplario at = new AltoTemplario(v);
        j2.agregarUnidad(at);
        Coordenada c1 = new Coordenada(4,4);
        Coordenada c2 = new Coordenada(9,9);
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
        Assert.assertEquals(0, at.getEnergiaActual());
    }

    @Test
    public void NaveCienciaLanzaRadiacionYBajaLaVidaAlTemplario() throws ExcepcionNoSePudoAgregarAlMapa, ExcepcionDeAccionDeUnidad {//baja de a 6 por q recupera 10% de escudo por turno (4)
        Jugador j1 = new JugadorTerran(new Recursos(200,200),new Suministros(100,200));
        Jugador j2 = new JugadorTerran(new Recursos(200,200),new Suministros(100,200));
        ProxiDeAtaque.inicializar(j1);
        ProxiDeAtaque.inicializar(j2);
        ProxyDeHechizos.inicializar(j1);
        ProxyDeHechizos.inicializar(j2);
        NaveCiencia nc = new NaveCiencia(Vision.VisionCompleta(10,10));
        j1.agregarUnidad(nc);
        AltoTemplario at = new AltoTemplario(v);
        j2.agregarUnidad(at);
        Coordenada c1 = new Coordenada(1,1);
        Coordenada c2 = new Coordenada(6,5);
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

    @Test
    public void testAltoTemplarioSeClonaYUnaNaveDeCienciaMataAlosClones() throws ExcepcionNoSePudoAgregarAlMapa, ExcepcionDeAccionDeUnidad, ExcepcionNoSePuedeClonarEdificio, ExcepcionCasillaVacia {
        Jugador j1 = new JugadorTerran(new Recursos(200,200),new Suministros(100,200));
        Jugador j2 = new JugadorTerran(new Recursos(200,200),new Suministros(100,200));
        ProxiDeAtaque.inicializar(j1);
        ProxiDeAtaque.inicializar(j2);
        ProxyDeHechizos.inicializar(j1);
        ProxyDeHechizos.inicializar(j2);
        NaveCiencia nc = new NaveCiencia(v);
        j1.agregarUnidad(nc);
        AltoTemplario at = new AltoTemplario(v);
        j2.agregarUnidad(at);
        Coordenada c1 = new Coordenada(3,2);
        Coordenada c2 = new Coordenada(8,8);
        Coordenada c3 = new Coordenada(7,7);
        Coordenada c4 = new Coordenada(8,7);
        ProxyMapa mapa = ProxyMapa.getInstance();
        ProxyMapa.getInstance().setCoordenadasMaximas(10, 10);

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
        at.alucinacion(c2);
        Assert.assertEquals(ClonMagico.class, mapa.obtenerDeCapaTerrestre(c3).getClass());
        Assert.assertEquals(ClonMagico.class, mapa.obtenerDeCapaTerrestre(c4).getClass());
        nc.EMP(c2);

        Assert.assertEquals(null, mapa.obtenerDeCapaTerrestre(c3));
        Assert.assertEquals(null,mapa.obtenerDeCapaTerrestre(c4));
    }

    @Test(expected = ExcepcionYaSeMovioLaUnidad.class)
    public void testLaUnidadSoloSePuedeMoverUnaVezPorTurno() throws ExcepcionNoSePudoAgregarAlMapa, ExcepcionDeAccionDeUnidad {
        Marine marine = new Marine(v);
        ProxyMapa mapa = ProxyMapa.getInstance();
        mapa.setCoordenadasMaximas(100,100);
        mapa.agregar(marine,new Coordenada(1,1));
        marine.mover(new Coordenada(1, 2));
        marine.mover(new Coordenada(1,3));
    }

    @Test(expected = ExcepcionYaActuo.class)
    public void MarineNoPuedeAtacar2VecesPorTurno() throws ExcepcionDeAccionDeUnidad, ExcepcionNoSePudoAgregarAlMapa {
        Jugador j1 = new JugadorTerran(new Recursos(200,200),new Suministros(100,200));
        Jugador j2 = new JugadorProtoss(new Recursos(200,200),new Suministros(100,200));
        ProxiDeAtaque.inicializar(j1);
        ProxiDeAtaque.inicializar(j2);
        ProxyDeHechizos.inicializar(j1);
        ProxyDeHechizos.inicializar(j2);
        Marine marine = new Marine(v);
        j1.agregarUnidad(marine);
        Zealot zealot = new Zealot(v);
        j2.agregarUnidad(zealot);
        Coordenada c1 = new Coordenada(5,5);
        Coordenada c2 = new Coordenada(6,6);
        ProxyMapa mapa = ProxyMapa.getInstance();
        ProxyMapa.getInstance().setCoordenadasMaximas(10, 10);
        mapa.agregar(marine, c1);
        mapa.agregar(zealot, c2);
        marine.atacar(c2);
        marine.atacar(c2);
    }

}
