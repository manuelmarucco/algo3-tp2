package interfaces_tests;


import excepciones.ExcepcionAtacarAUnidadAliada;
import excepciones.ExcepcionObjetivoFueraDeRango;
import excepciones.ExcepcionPosicionOcupada;
import jugabilidad.Jugador;
import jugabilidad.ProxyMapa;
import jugabilidad.RazaDeJugador.JugadorTerran;
import jugabilidad.auxiliares.Recursos;
import jugabilidad.auxiliares.Suministros;
import jugabilidad.utilidadesMapa.Coordenadas;
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
    public void testAtacarAereo() throws ExcepcionAtacarAUnidadAliada, ExcepcionObjetivoFueraDeRango, ExcepcionPosicionOcupada {
        ProxyMapa mapa =ProxyMapa.getInstance();
        Jugador j1 = new JugadorTerran(new Recursos(200,200),new Suministros(100,200));
        Jugador j2 = new JugadorTerran(new Recursos(200,200),new Suministros(100,200));
        ProxiDeAtaque.inicializar(j1,j2);
        UnidadGuerrera golliat = new Golliat();
        j1.agregarUnidad(golliat);
        Unidad objetivo = new NaveCiencia();
        j2.agregarUnidad(objetivo);
        mapa.agregarEnCapaAerea(objetivo,new Coordenadas(5,5));
        mapa.agregarEnCapaTerrestre(golliat, new Coordenadas(6, 5));
        golliat.atacarAire(objetivo);
        Assert.assertEquals(190, objetivo.getVida());
    }

    @Test
    public void testAtacarTerrestre() throws ExcepcionAtacarAUnidadAliada, ExcepcionObjetivoFueraDeRango, ExcepcionPosicionOcupada {
        ProxyMapa mapa =ProxyMapa.getInstance();
        Jugador j1 = new JugadorTerran(new Recursos(200,200),new Suministros(100,200));
        Jugador j2 = new JugadorTerran(new Recursos(200,200),new Suministros(100,200));
        ProxiDeAtaque.inicializar(j1, j2);
        UnidadGuerrera golliat = new Golliat();
        j1.agregarUnidad(golliat);
        mapa.agregarEnCapaTerrestre(golliat, new Coordenadas(5, 5));
        Unidad marine = new Marine();
        j2.agregarUnidad(golliat);
        mapa.agregarEnCapaTerrestre(marine,new Coordenadas(6,5));
        golliat.atacarTierra(marine);
        Assert.assertEquals(28, marine.getVida());
    }
}