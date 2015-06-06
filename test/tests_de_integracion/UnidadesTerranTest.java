package tests_de_integracion;

import excepciones.ExcepcionObjetivoFueraDeRango;
import jugabilidad.Mapa;
import jugabilidad.SingletonMapa;
import jugabilidad.utilidadesMapa.Coordenadas;
import org.junit.Assert;
import org.junit.Test;
import unidades.protoss.AltoTemplario;
import unidades.protoss.ClonMagico;
import unidades.protoss.Zealot;
import unidades.terrran.Marine;
import unidades.terrran.NaveCiencia;

public class UnidadesTerranTest {

    @Test
    public void MarineAtacaAZealotDentroDeSuRango() throws ExcepcionObjetivoFueraDeRango {
        Marine marine = new Marine();
        Zealot zealot = new Zealot();
        Coordenadas c1 = new Coordenadas(5,5);
        Coordenadas c2 = new Coordenadas(6,6);
        Mapa mapa = SingletonMapa.getInstance();
        mapa.agregar(marine,c1);
        mapa.agregar(zealot, c2);
        marine.atacarTierra(c1, c2);
        Assert.assertEquals(54,zealot.getEscudo().getEscudoActual());
    }

    @Test(expected = ExcepcionObjetivoFueraDeRango.class)
    public void MarineAtacaAZealotFueraDeSuRango() throws ExcepcionObjetivoFueraDeRango {
        Marine marine = new Marine();
        Zealot zealot = new Zealot();
        Coordenadas c1 = new Coordenadas(3,3);
        Coordenadas c2 = new Coordenadas(8,8);
        Mapa mapa = SingletonMapa.getInstance();
        mapa.agregar(marine,c1);
        mapa.agregar(zealot, c2);
        marine.atacarTierra(c1, c2);
    }

    @Test
    public void NaveCienciaLanzaEMPDejaSinEscudoYEnergiaAUnAltoTemplario(){
        NaveCiencia nc = new NaveCiencia();
        AltoTemplario at = new AltoTemplario();
        Coordenadas c1 = new Coordenadas(3,3);
        Coordenadas c2 = new Coordenadas(8,8);
        Mapa mapa = SingletonMapa.getInstance();
        mapa.agregar(nc,c1);
        mapa.agregar(at, c2);
        nc.update();
        nc.update();
        nc.update();
        nc.update();
        nc.update();
        nc.EMP(c2);
        Assert.assertEquals(0, at.getEscudo().getEscudoActual());
        Assert.assertEquals(0, at.getEnergia().getEnergiaActual());
    }

    @Test
    public void NaveCienciaLanzaRadiacionYBajaLaVidaAlTemplario(){//baja de a 6 por q recupera 10% de escudo por turno (4)
        NaveCiencia nc = new NaveCiencia();
        AltoTemplario at = new AltoTemplario();
        Coordenadas c1 = new Coordenadas(3,3);
        Coordenadas c2 = new Coordenadas(8,8);
        Mapa mapa = SingletonMapa.getInstance();
        mapa.agregar(nc,c1);
        mapa.agregar(at, c2);
        nc.update();
        nc.update();
        nc.update();
        nc.update();
        nc.update();
        nc.Radiacion(at);
        Assert.assertEquals(40, at.getEscudo().getEscudoActual());
        at.update();
        Assert.assertEquals(34, at.getEscudo().getEscudoActual());
        at.update();
        Assert.assertEquals(28, at.getEscudo().getEscudoActual());
        at.update();
        Assert.assertEquals(22, at.getEscudo().getEscudoActual());
        at.update();
        Assert.assertEquals(16, at.getEscudo().getEscudoActual());
        at.update();
        Assert.assertEquals(10, at.getEscudo().getEscudoActual());
        at.update();
        Assert.assertEquals(4, at.getEscudo().getEscudoActual());
        at.update();
        Assert.assertEquals(4, at.getEscudo().getEscudoActual());
        Assert.assertEquals(34, at.getVida().getVidaActual());
        at.update();
        Assert.assertEquals(4, at.getEscudo().getEscudoActual());
        Assert.assertEquals(28,at.getVida().getVidaActual());
    }

    @Test
    public void testAltoTemplarioSeClonaYUnaNaveDeCienciaMataAlosClones(){
        NaveCiencia nc = new NaveCiencia();
        AltoTemplario at = new AltoTemplario();
        Coordenadas c1 = new Coordenadas(3,3);
        Coordenadas c2 = new Coordenadas(8,8);
        Coordenadas c3 = new Coordenadas(8,7);
        Coordenadas c4 = new Coordenadas(7,8);
        Mapa mapa = SingletonMapa.getInstance();
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
        at.alucinacion(at, c3, c4);
        Assert.assertEquals(ClonMagico.class, mapa.obtenerDeCapaTerrestre(c3).getClass());
        Assert.assertEquals(ClonMagico.class, mapa.obtenerDeCapaTerrestre(c4).getClass());
        nc.EMP(c2);

        Assert.assertEquals(null, mapa.obtenerDeCapaTerrestre(c3));
        Assert.assertEquals(null,mapa.obtenerDeCapaTerrestre(c4));
    }

}
