package tests_de_integracion;

import construcciones.terran.Barraca;
import construcciones.terran.Fabrica;
import excepciones.ExcepcionNoSePuedeConstruir;
import excepciones.ExcepcionPosicionOcupada;
import jugabilidad.ProxyMapa;
import jugabilidad.RazaDeJugador.JugadorTerran;
import jugabilidad.auxiliares.Recursos;
import jugabilidad.utilidadesMapa.Coordenadas;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class ConstruccionesEnElMapaTest {
    @Before
    public void resetearProxy(){
        ProxyMapa.resetear();
    }

    @Test(expected = ExcepcionPosicionOcupada.class)
    public void QuieroCrearUnaConstruccionSobreOtraPeroNoSeCrea() throws ExcepcionNoSePuedeConstruir, ExcepcionPosicionOcupada {
        JugadorTerran j = new JugadorTerran(new Recursos(1000,1000));
        Fabrica f;
        Barraca b;

        b = j.construirBarraca(new Coordenadas(1,1));
        for (int i = 0; i < b.getTiempoDeConstruccion(); i ++) j.update();
        f = j.construirFabrica(new Coordenadas(1,1));

        Assert.assertFalse(j.buscarConstruccion(f));
    }

}
