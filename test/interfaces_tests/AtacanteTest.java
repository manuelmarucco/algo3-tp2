package interfaces_tests;


import modelo.excepciones.Mapa.ExcepcionNoSePudoAgregarAlMapa;
import modelo.excepciones.Unidades.ExcepcionDeAccionDeUnidad;
import modelo.jugabilidad.Jugador;
import modelo.jugabilidad.ProxyMapa;
import modelo.jugabilidad.RazaDeJugador.JugadorTerran;
import modelo.jugabilidad.auxiliares.Recursos;
import modelo.jugabilidad.auxiliares.Suministros;
import modelo.jugabilidad.utilidadesMapa.Coordenada;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import modelo.unidades.ProxiDeAtaque;
import modelo.unidades.Unidad;
import modelo.unidades.UnidadGuerrera;
import modelo.unidades.terrran.Golliat;
import modelo.unidades.terrran.Marine;
import modelo.unidades.terrran.NaveCiencia;

public class AtacanteTest {
    @Before
    public void resetearProxy(){
        ProxyMapa.resetear();
    }

    @Test
    public void testAtacarAereo() throws ExcepcionDeAccionDeUnidad, ExcepcionNoSePudoAgregarAlMapa {
        ProxyMapa proxyMapa =ProxyMapa.getInstance();
        proxyMapa.setCoordenadasMaximas(20,20);

        Jugador j1 = new JugadorTerran(new Recursos(200,200),new Suministros(100,200));
        Jugador j2 = new JugadorTerran(new Recursos(200,200),new Suministros(100,200));
        ProxiDeAtaque.inicializar(j1);
        ProxiDeAtaque.inicializar(j2);
        UnidadGuerrera golliat = new Golliat();
        j1.agregarUnidad(golliat);
        Unidad objetivo = new NaveCiencia();
        j2.agregarUnidad(objetivo);
        proxyMapa.agregar(objetivo, new Coordenada(5, 5));
        proxyMapa.agregar(golliat, new Coordenada(6, 5));
        golliat.atacar(new Coordenada(5, 5));
        Assert.assertEquals(190, objetivo.getVida());
    }

    @Test
    public void testAtacarTerrestre() throws ExcepcionDeAccionDeUnidad, ExcepcionNoSePudoAgregarAlMapa {
        ProxyMapa proxyMapa =ProxyMapa.getInstance();
        proxyMapa.setCoordenadasMaximas(20,20);

        Jugador j1 = new JugadorTerran(new Recursos(200,200),new Suministros(100,200));
        Jugador j2 = new JugadorTerran(new Recursos(200,200),new Suministros(100,200));

        ProxiDeAtaque.inicializar(j1);
        ProxiDeAtaque.inicializar(j2);
        UnidadGuerrera golliat = new Golliat();
        j1.agregarUnidad(golliat);
        proxyMapa.agregar(golliat, new Coordenada(5, 5));
        Unidad marine = new Marine();
        j2.agregarUnidad(golliat);
        proxyMapa.agregar(marine, new Coordenada(6, 5));
        golliat.atacar(new Coordenada(6, 5));
        Assert.assertEquals(28, marine.getVida());
    }
}