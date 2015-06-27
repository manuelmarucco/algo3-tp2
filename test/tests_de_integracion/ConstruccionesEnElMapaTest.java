package tests_de_integracion;

import construcciones.terran.Barraca;
import construcciones.terran.Fabrica;
import excepciones.Mapa.ExcepcionNoSePudoAgregarAlMapa;
import excepciones.Mapa.ExcepcionPosicionOcupada;
import excepciones.construcciones.ExcepcionNoSePuedeConstruir;
import jugabilidad.ProxyMapa;
import jugabilidad.RazaDeJugador.JugadorTerran;
import jugabilidad.auxiliares.Recursos;
import jugabilidad.auxiliares.Vision;
import jugabilidad.utilidadesMapa.Coordenada;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class ConstruccionesEnElMapaTest {
    @Before
    public void resetearProxy(){
        ProxyMapa.resetear();
    }

    @Test(expected = ExcepcionPosicionOcupada.class)
    public void QuieroCrearUnaConstruccionSobreOtraPeroNoSeCrea() throws ExcepcionNoSePuedeConstruir, ExcepcionNoSePudoAgregarAlMapa {
        ProxyMapa proxyMapa = ProxyMapa.getInstance();
        proxyMapa.setCoordenadasMaximas(5,5);

        JugadorTerran j = new JugadorTerran(new Recursos(1000,1000));
        j.setVisibilidad(Vision.VisionCompleta(5,5));
        Fabrica f;
        Barraca b;

        b = j.construirBarraca(new Coordenada(1,1));
        for (int i = 0; i < b.getTiempoDeConstruccion(); i ++) j.update();
        f = j.construirFabrica(new Coordenada(1,1));

        Assert.assertFalse(j.buscarConstruccion(f));
    }

}
