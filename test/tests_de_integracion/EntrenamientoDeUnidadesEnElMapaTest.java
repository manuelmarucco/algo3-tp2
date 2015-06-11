package tests_de_integracion;

import construcciones.terran.Barraca;
import excepciones.Mapa.ExcepcionNoSePudoAgregarAlMapa;
import excepciones.construicciones.ExcepcionNoSePuedeConstruir;
import excepciones.Mapa.ExcepcionPosicionOcupada;
import jugabilidad.ProxyMapa;
import jugabilidad.RazaDeJugador.JugadorTerran;
import jugabilidad.auxiliares.Recursos;
import jugabilidad.auxiliares.Suministros;
import jugabilidad.auxiliares.Vision;
import jugabilidad.utilidadesMapa.Coordenadas;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import recursos.Volcan;
import unidades.terrran.Marine;

public class EntrenamientoDeUnidadesEnElMapaTest {

    @Before
    public void resetearProxy(){
        ProxyMapa.resetear();
    }

    @Test
    public void LosMarinesSeCreanAlrededorArribaDeLaBarraca() throws ExcepcionNoSePuedeConstruir, ExcepcionNoSePudoAgregarAlMapa {
        JugadorTerran j = new JugadorTerran(new Recursos(1000,1000),new Suministros(0,200));
        ProxyMapa mapa = ProxyMapa.getInstance();
        j.setVisibilidad(Vision.VisionCompleta(20, 20));
        mapa.setCoordenadasMaximas(10,10);
        Barraca b;
        Marine m1,m2,m3;
        int tiempoDeEntrenamiento;
        Coordenadas cb = new Coordenadas(1,1);

        b = j.construirBarraca(cb);
        for(int i=0; i<b.getTiempoDeConstruccion(); i++)  j.update();

        m1 = b.entrenarMarine();
        tiempoDeEntrenamiento = m1.getTiempoDeEntrenamiento();
        m2 = b.entrenarMarine();
        m3 = b.entrenarMarine();
        for(int i=0; i<(tiempoDeEntrenamiento*3); i++)  j.update();

        Assert.assertTrue(j.buscarUnidad(m1));
        Assert.assertTrue(mapa.getCoordenada(m1).equals(new Coordenadas(cb.getX()-1,cb.getY()-1)));

        Assert.assertTrue(j.buscarUnidad(m2));
        Assert.assertTrue(mapa.getCoordenada(m2).equals(new Coordenadas(cb.getX()-1,cb.getY())));

        Assert.assertTrue(j.buscarUnidad(m2));
        Assert.assertTrue(mapa.getCoordenada(m3).equals(new Coordenadas(cb.getX()-1,cb.getY()+1)));


    }
    @Test
    public void BarracaRodeadaDeVolcanExceptoUnLugarYMarineSeAgregaEnEseLugar() throws ExcepcionNoSePuedeConstruir, ExcepcionNoSePudoAgregarAlMapa {
        ProxyMapa proxyMapa =ProxyMapa.getInstance();
        proxyMapa.setCoordenadasMaximas(20,20);

        JugadorTerran j = new JugadorTerran(new Recursos(1000,1000),new Suministros(0,200));
        j.setVisibilidad(Vision.VisionCompleta(20, 20));
        proxyMapa.setCoordenadasMaximas(10,10);
        Barraca b;
        Marine m;
        int tiempoDeEntrenamiento;
        Coordenadas cb = new Coordenadas(5,5);

        proxyMapa.agregar(new Volcan(), new Coordenadas(4, 4));
        proxyMapa.agregar(new Volcan(), new Coordenadas(5, 4));
        proxyMapa.agregar(new Volcan(), new Coordenadas(6, 4));
        proxyMapa.agregar(new Volcan(), new Coordenadas(6, 5));
        proxyMapa.agregar(new Volcan(), new Coordenadas(4, 5));
        proxyMapa.agregar(new Volcan(), new Coordenadas(4, 6));
        proxyMapa.agregar(new Volcan(), new Coordenadas(6, 6));

        b = j.construirBarraca(cb);
        for(int i=0; i<b.getTiempoDeConstruccion(); i++)  j.update();

        m = b.entrenarMarine();
        tiempoDeEntrenamiento = m.getTiempoDeEntrenamiento();
        for(int i=0; i<(tiempoDeEntrenamiento); i++)  j.update();

        Assert.assertTrue(j.buscarUnidad(m));
        Assert.assertTrue(proxyMapa.getCoordenada(m).equals(new Coordenadas(cb.getX(), cb.getY() + 1)));



    }
}
