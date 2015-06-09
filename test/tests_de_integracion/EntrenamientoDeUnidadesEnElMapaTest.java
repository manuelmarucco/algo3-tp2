package tests_de_integracion;

import construcciones.terran.Barraca;
import excepciones.ExcepcionNoSePuedeConstruir;
import excepciones.ExcepcionPosicionOcupada;
import jugabilidad.ProxyMapa;
import jugabilidad.RazaDeJugador.JugadorTerran;
import jugabilidad.auxiliares.Recursos;
import jugabilidad.auxiliares.Suministros;
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
    public void LosMarinesSeCreanAlrededorArribaDeLaBarraca() throws ExcepcionNoSePuedeConstruir, ExcepcionPosicionOcupada {
        JugadorTerran j = new JugadorTerran(new Recursos(1000,1000),new Suministros(0,200));
        ProxyMapa mapa = ProxyMapa.getInstance();
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
    public void BarracaRodeadaDeVolcanExceptoUnLugarYMarineSeAgregaEnEseLugar() throws ExcepcionNoSePuedeConstruir, ExcepcionPosicionOcupada {
        JugadorTerran j = new JugadorTerran(new Recursos(1000,1000),new Suministros(0,200));
        ProxyMapa mapa = ProxyMapa.getInstance();
        Barraca b;
        Marine m;
        int tiempoDeEntrenamiento;
        Coordenadas cb = new Coordenadas(1,1);

        mapa.agregarEnCapaTerrestre(new Volcan(),new Coordenadas(0,0));
        mapa.agregarEnCapaTerrestre(new Volcan(),new Coordenadas(0,1));
        mapa.agregarEnCapaTerrestre(new Volcan(),new Coordenadas(0,2));
        mapa.agregarEnCapaTerrestre(new Volcan(),new Coordenadas(1,0));
        mapa.agregarEnCapaTerrestre(new Volcan(),new Coordenadas(1,2));
        mapa.agregarEnCapaTerrestre(new Volcan(),new Coordenadas(2,0));
        mapa.agregarEnCapaTerrestre(new Volcan(),new Coordenadas(2,1));

        b = j.construirBarraca(cb);
        for(int i=0; i<b.getTiempoDeConstruccion(); i++)  j.update();

        m = b.entrenarMarine();
        tiempoDeEntrenamiento = m.getTiempoDeEntrenamiento();
        for(int i=0; i<(tiempoDeEntrenamiento*3); i++)  j.update();

        Assert.assertTrue(j.buscarUnidad(m));
        Assert.assertTrue(mapa.getCoordenada(m).equals(new Coordenadas(cb.getX()+1,cb.getY()+1)));



    }
}
