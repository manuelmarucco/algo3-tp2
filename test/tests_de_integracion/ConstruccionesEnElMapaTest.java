package tests_de_integracion;

import modelo.construcciones.terran.Barraca;
import modelo.construcciones.terran.Fabrica;
import modelo.excepciones.Mapa.ExcepcionNoSePudoAgregarAlMapa;
import modelo.excepciones.Mapa.ExcepcionPosicionOcupada;
import modelo.excepciones.construcciones.ExcepcionNoSePuedeConstruir;
import modelo.jugabilidad.ProxyMapa;
import modelo.jugabilidad.RazaDeJugador.JugadorTerran;
import modelo.jugabilidad.auxiliares.Recursos;
import modelo.jugabilidad.auxiliares.Vision;
import modelo.jugabilidad.utilidadesMapa.Coordenada;
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
