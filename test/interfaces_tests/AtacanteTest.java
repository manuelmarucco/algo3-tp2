package interfaces_tests;


import excepciones.Mapa.ExcepcionNoSePudoAgregarAlMapa;
import excepciones.Unidades.*;
import jugabilidad.Jugador;
import jugabilidad.ProxyMapa;
import jugabilidad.RazaDeJugador.JugadorTerran;
import jugabilidad.auxiliares.Recursos;
import jugabilidad.auxiliares.Suministros;
import jugabilidad.utilidadesMapa.Coordenada;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import unidades.ProxiDeAtaque;
import unidades.Unidad;
import unidades.UnidadGuerrera;
import unidades.terrran.Golliat;
import unidades.terrran.Marine;
import unidades.terrran.NaveCiencia;

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