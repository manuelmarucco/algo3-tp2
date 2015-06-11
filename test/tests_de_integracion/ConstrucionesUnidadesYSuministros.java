package tests_de_integracion;

import construcciones.protoss.Acceso;
import construcciones.protoss.Pilon;
import construcciones.terran.DepositoDeSuministros;
import excepciones.Mapa.ExcepcionNoSePudoAgregarAlMapa;
import excepciones.Mapa.ExcepcionPosicionOcupada;
import excepciones.Unidades.ExcepcionAtacarAUnidadAliada;
import excepciones.Unidades.ExcepcionObjetivoFueraDeRango;
import excepciones.Unidades.ExcepcionYaActuo;
import excepciones.construicciones.ExcepcionNoSePuedeConstruir;
import jugabilidad.ProxyMapa;
import jugabilidad.RazaDeJugador.JugadorProtoss;
import jugabilidad.RazaDeJugador.JugadorTerran;
import jugabilidad.auxiliares.Recursos;
import jugabilidad.auxiliares.Suministros;
import jugabilidad.auxiliares.Vision;
import jugabilidad.utilidadesMapa.Coordenadas;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import unidades.ProxiDeAtaque;
import unidades.protoss.Dragon;
import unidades.terrran.Marine;

public class ConstrucionesUnidadesYSuministros {
    ProxyMapa proxyMapa;
    @Before
    public void resetearProxy(){
        ProxyMapa.resetear();

        proxyMapa = ProxyMapa.getInstance();
        proxyMapa.setCoordenadasMaximas(20, 20);
    }

    @Test
    public void NoPuedoEntrenarMasUnidadesPorLlegarALLimiteDeSuministros(){
        JugadorProtoss j = new JugadorProtoss(new Recursos(1000,1000),new Suministros(4,5));// 4 usados, 5 limite
        Acceso a = new Acceso(j);
        Dragon d;

        d = a.entrenarDragon();//+ 2 sumistro

        Assert.assertFalse(j.buscarUnidad(d));

    }

    @Test
     public void CreoVariosPilonesYAumentanLosSuministrosLimiteActuales() throws ExcepcionNoSePuedeConstruir, ExcepcionNoSePudoAgregarAlMapa {
        Suministros s = new Suministros(0,0);
        JugadorProtoss j = new JugadorProtoss(new Recursos(1000,1000),s);
        j.setVisibilidad(Vision.VisionCompleta(20, 20));
        Pilon p;

        p = j.construirPilon(new Coordenadas(1,2));
        for (int i = 0; i < p.getTiempoDeConstruccion(); i ++) j.update();
        j.construirPilon(new Coordenadas(1,1));
        for (int i = 0; i < p.getTiempoDeConstruccion(); i ++) j.update();
        j.construirPilon(new Coordenadas(5,2));
        for (int i = 0; i < p.getTiempoDeConstruccion(); i ++) j.update();

        Assert.assertEquals(15,s.getSuministrosLimiteActuales());
    }

    @Test
    public void CreoVariosDepositosDeSuministrosYAumentanLosSuministrosLimiteActuales() throws ExcepcionNoSePuedeConstruir, ExcepcionNoSePudoAgregarAlMapa {
        Suministros s = new Suministros(0,0);
        JugadorTerran j = new JugadorTerran(new Recursos(1000,1000),s);
        j.setVisibilidad(Vision.VisionCompleta(20, 20));
        DepositoDeSuministros d;

        d = j.construirDepositoDeSuministros(new Coordenadas(4, 6));
        for (int i = 0; i < d.getTiempoDeConstruccion(); i ++) j.update();
        j.construirDepositoDeSuministros(new Coordenadas(4, 1));
        for (int i = 0; i < d.getTiempoDeConstruccion(); i ++) j.update();
        j.construirDepositoDeSuministros(new Coordenadas(4, 2));
        for (int i = 0; i < d.getTiempoDeConstruccion(); i ++) j.update();

        Assert.assertEquals(15,s.getSuministrosLimiteActuales());
    }

    @Test
    public void CreoPilonesPeroNoPuedoSuperarLos200SuministrosMaximos() throws ExcepcionNoSePuedeConstruir, ExcepcionNoSePudoAgregarAlMapa {
        Suministros s = new Suministros(0,191);
        JugadorProtoss j = new JugadorProtoss(new Recursos(1000,1000),s);
        j.setVisibilidad(Vision.VisionCompleta(20, 20));
        Pilon p;


        p = j.construirPilon(new Coordenadas(3,5));
        for (int i = 0; i < p.getTiempoDeConstruccion(); i ++) j.update();
        j.construirPilon(new Coordenadas(3,1));
        for (int i = 0; i < p.getTiempoDeConstruccion(); i ++) j.update();
        j.construirPilon(new Coordenadas(3,2));
        for (int i = 0; i < p.getTiempoDeConstruccion(); i ++) j.update();

        Assert.assertEquals(200,s.getSuministrosLimiteActuales());
    }

    @Test
    public void CreoDepositosDeSuministrosPeroNoPuedoSuperarLos200SuministrosMaximos() throws ExcepcionNoSePuedeConstruir, ExcepcionNoSePudoAgregarAlMapa {
        Suministros s = new Suministros(0,191);
        JugadorTerran j = new JugadorTerran(new Recursos(1000,1000),s);
        j.setVisibilidad(Vision.VisionCompleta(20, 20));
        DepositoDeSuministros d;

        d = j.construirDepositoDeSuministros(new Coordenadas(1, 1));
        for (int i = 0; i < d.getTiempoDeConstruccion(); i ++) j.update();
        j.construirDepositoDeSuministros(new Coordenadas(1, 3));
        for (int i = 0; i < d.getTiempoDeConstruccion(); i ++) j.update();
        j.construirDepositoDeSuministros(new Coordenadas(1, 5));
        for (int i = 0; i < d.getTiempoDeConstruccion(); i ++) j.update();

        Assert.assertEquals( 200,s.getSuministrosLimiteActuales());
    }

    @Test
    public void SeDestruyeUnDepositoDeSuminisitrosYDisminuyenLosSuministrosDelJugador() throws ExcepcionAtacarAUnidadAliada, ExcepcionObjetivoFueraDeRango, ExcepcionNoSePudoAgregarAlMapa, ExcepcionNoSePuedeConstruir, ExcepcionYaActuo {
        ProxyMapa proxyMapa = ProxyMapa.getInstance();
        proxyMapa.setCoordenadasMaximas(20,20);

        Suministros s = new Suministros(0,20);
        JugadorTerran j1 = new JugadorTerran(new Recursos(1000,1000),s);
        j1.setVisibilidad(Vision.VisionCompleta(20, 20));
        JugadorTerran j2 = new JugadorTerran(new Recursos(200,200),new Suministros(0,20));
        j2.setVisibilidad(Vision.VisionCompleta(20, 20));
        ProxiDeAtaque.inicializar(j2, j1);
        DepositoDeSuministros d;
        Marine m = new Marine(Vision.VisionCompleta(10,10));
        Coordenadas coordDeDepot = new Coordenadas(5, 6);

        proxyMapa.agregar(m, new Coordenadas(5, 5));
        j2.agregarUnidad(m);

        d = j1.construirDepositoDeSuministros(coordDeDepot);

        for (int i = 0; i < d.getTiempoDeConstruccion(); i ++) j1.update();

        Assert.assertEquals( 25,s.getSuministrosLimiteActuales());

        while(d.getVida()!= 0){
            m.atacarTierra(d);
            j2.update();
        }

        j1.update();

        Assert.assertEquals( 20,s.getSuministrosLimiteActuales());
        Assert.assertFalse(j1.buscarConstruccion(d));
        Assert.assertTrue(proxyMapa.posicionTerrestreOcupada(coordDeDepot));
    }

    @Test
    public void SeDestruyeUnPilonYDisminuyenLosSuministrosDelJugador() throws ExcepcionAtacarAUnidadAliada, ExcepcionObjetivoFueraDeRango, ExcepcionNoSePudoAgregarAlMapa, ExcepcionNoSePuedeConstruir, ExcepcionYaActuo {
        ProxyMapa proxyMapa = ProxyMapa.getInstance();
        proxyMapa.setCoordenadasMaximas(20,20);

        Suministros s = new Suministros(0,20);
        JugadorProtoss j1 = new JugadorProtoss(new Recursos(1000,1000),s);
        j1.setVisibilidad(Vision.VisionCompleta(20, 20));
        JugadorTerran j2 = new JugadorTerran(new Recursos(200,200),new Suministros(1,20));
        j2.setVisibilidad(Vision.VisionCompleta(20, 20));
        ProxiDeAtaque.inicializar(j2, j1);
        Pilon p;
        Marine m = new Marine(Vision.VisionCompleta(10,10));
        Coordenadas coordDePilon = new Coordenadas(7, 6);

        proxyMapa.agregar(m, new Coordenadas(7, 5));
        j2.agregarUnidad(m);

        p = j1.construirPilon(coordDePilon);

        for (int i = 0; i < p.getTiempoDeConstruccion(); i ++) j1.update();

        Assert.assertEquals(25, s.getSuministrosLimiteActuales());

        while(p.getVida()!= 0){
            m.atacarTierra(p);
            j2.update();
        }

        j1.update();

        Assert.assertEquals( 20,s.getSuministrosLimiteActuales());
        Assert.assertFalse(j1.buscarConstruccion(p));
        Assert.assertTrue(proxyMapa.posicionTerrestreOcupada(coordDePilon));
    }

}
