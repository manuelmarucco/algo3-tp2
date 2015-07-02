package tests_de_integracion;

import modelo.construcciones.terran.Barraca;
import modelo.excepciones.Mapa.ExcepcionNoSePudoAgregarAlMapa;
import modelo.excepciones.construcciones.ExcepcionNoSePuedeConstruir;
import modelo.excepciones.construcciones.ExcepcionNoSePuedeEntrenarUnidad;
import modelo.jugabilidad.ProxyMapa;
import modelo.jugabilidad.RazaDeJugador.JugadorTerran;
import modelo.jugabilidad.auxiliares.Recursos;
import modelo.jugabilidad.auxiliares.Suministros;
import modelo.jugabilidad.auxiliares.Vision;
import modelo.jugabilidad.utilidadesMapa.Coordenada;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import modelo.recursos.Volcan;
import modelo.unidades.terrran.Marine;

public class EntrenamientoDeUnidadesEnElMapaTest {

    @Before
    public void resetearProxy(){
        ProxyMapa.resetear();
    }

    @Test
    public void LosMarinesSeCreanAlrededorArribaDeLaBarraca() throws ExcepcionNoSePuedeConstruir, ExcepcionNoSePudoAgregarAlMapa, ExcepcionNoSePuedeEntrenarUnidad {
        JugadorTerran j = new JugadorTerran(new Recursos(1000,1000),new Suministros(0,200));
        ProxyMapa mapa = ProxyMapa.getInstance();
        j.setVisibilidad(Vision.VisionCompleta(20, 20));
        mapa.setCoordenadasMaximas(10,10);
        Barraca b;
        Marine m1,m2,m3;
        int tiempoDeEntrenamiento;
        Coordenada cb = new Coordenada(1,1);

        b = j.construirBarraca(cb);
        for(int i=0; i<b.getTiempoDeConstruccion(); i++)  j.update();

        m1 = b.entrenarMarine();
        tiempoDeEntrenamiento = m1.getTiempoDeEntrenamientoActual();
        m2 = b.entrenarMarine();
        m3 = b.entrenarMarine();
        for(int i=0; i<(tiempoDeEntrenamiento*3); i++)  j.update();

        Assert.assertTrue(j.buscarUnidad(m1));
        Assert.assertTrue(mapa.getCoordenada(m1).equals(new Coordenada(cb.getX()-1,cb.getY()-1)));

        Assert.assertTrue(j.buscarUnidad(m2));
        Assert.assertTrue(mapa.getCoordenada(m2).equals(new Coordenada(cb.getX(),cb.getY()-1)));

        Assert.assertTrue(j.buscarUnidad(m2));
        Assert.assertTrue(mapa.getCoordenada(m3).equals(new Coordenada(cb.getX()+1,cb.getY()-1)));


    }
    @Test
    public void BarracaRodeadaDeVolcanExceptoUnLugarYMarineSeAgregaEnEseLugar() throws ExcepcionNoSePuedeConstruir, ExcepcionNoSePudoAgregarAlMapa, ExcepcionNoSePuedeEntrenarUnidad {
        ProxyMapa proxyMapa =ProxyMapa.getInstance();
        proxyMapa.setCoordenadasMaximas(20,20);

        JugadorTerran j = new JugadorTerran(new Recursos(1000,1000),new Suministros(0,200));
        j.setVisibilidad(Vision.VisionCompleta(20, 20));
        proxyMapa.setCoordenadasMaximas(10,10);
        Barraca b;
        Marine m;
        int tiempoDeEntrenamiento;
        Coordenada coordenadaDeBarraca = new Coordenada(5,5);

        proxyMapa.agregar(new Volcan(), new Coordenada(4, 4));
        proxyMapa.agregar(new Volcan(), new Coordenada(5, 4));
        proxyMapa.agregar(new Volcan(), new Coordenada(6, 4));
        proxyMapa.agregar(new Volcan(), new Coordenada(6, 5));
        proxyMapa.agregar(new Volcan(), new Coordenada(4, 5));
        proxyMapa.agregar(new Volcan(), new Coordenada(4, 6));
        proxyMapa.agregar(new Volcan(), new Coordenada(6, 6));

        b = j.construirBarraca(coordenadaDeBarraca);
        for(int i=0; i<b.getTiempoDeConstruccion(); i++)  j.update();

        m = b.entrenarMarine();
        tiempoDeEntrenamiento = m.getTiempoDeEntrenamientoActual();
        for(int i=0; i<(tiempoDeEntrenamiento); i++)  j.update();

        Assert.assertTrue(j.buscarUnidad(m));
        Assert.assertTrue(proxyMapa.getCoordenada(m).equals(new Coordenada(coordenadaDeBarraca.getX(), coordenadaDeBarraca.getY() + 1)));



    }

    @Test
    public void BarracaRodeadaDeVolcanYNoSePuedeAgregarMarineYEntoncesNoSeEntrena() throws ExcepcionNoSePuedeConstruir, ExcepcionNoSePudoAgregarAlMapa, ExcepcionNoSePuedeEntrenarUnidad {
        ProxyMapa proxyMapa =ProxyMapa.getInstance();
        proxyMapa.setCoordenadasMaximas(20,20);

        JugadorTerran j = new JugadorTerran(new Recursos(1000,1000),new Suministros(0,200));
        j.setVisibilidad(Vision.VisionCompleta(20, 20));
        proxyMapa.setCoordenadasMaximas(10,10);
        Barraca b;
        Marine m;
        int tiempoDeEntrenamiento;
        Coordenada coordenadaDeBarraca = new Coordenada(5,5);

        proxyMapa.agregar(new Volcan(), new Coordenada(4, 4));
        proxyMapa.agregar(new Volcan(), new Coordenada(4, 5));
        proxyMapa.agregar(new Volcan(), new Coordenada(4, 6));
        proxyMapa.agregar(new Volcan(), new Coordenada(5, 4));
        proxyMapa.agregar(new Volcan(), new Coordenada(5, 6));
        proxyMapa.agregar(new Volcan(), new Coordenada(6, 4));
        proxyMapa.agregar(new Volcan(), new Coordenada(6, 5));
        proxyMapa.agregar(new Volcan(), new Coordenada(6, 6));

        b = j.construirBarraca(coordenadaDeBarraca);
        for(int i=0; i<b.getTiempoDeConstruccion(); i++)  j.update();

        m = b.entrenarMarine();
        tiempoDeEntrenamiento = m.getTiempoDeEntrenamientoActual();
        for(int i=0; i<(tiempoDeEntrenamiento); i++)  j.update();

        Assert.assertFalse(j.buscarUnidad(m));

    }
}
