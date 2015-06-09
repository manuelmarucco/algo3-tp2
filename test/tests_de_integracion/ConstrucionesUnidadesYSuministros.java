package tests_de_integracion;

import construcciones.protoss.Acceso;
import construcciones.protoss.Pilon;
import construcciones.terran.DepositoDeSuministros;
import excepciones.*;
import jugabilidad.ProxyMapa;
import jugabilidad.RazaDeJugador.JugadorProtoss;
import jugabilidad.RazaDeJugador.JugadorTerran;
import jugabilidad.auxiliares.Recursos;
import jugabilidad.auxiliares.Suministros;
import jugabilidad.utilidadesMapa.Coordenadas;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import unidades.ProxiDeAtaque;
import unidades.protoss.Dragon;
import unidades.terrran.Marine;

public class ConstrucionesUnidadesYSuministros {
    @Before
    public void resetearProxy(){
        ProxyMapa.resetear();
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
     public void CreoVariosPilonesYAumentanLosSuministrosLimiteActuales() throws ExcepcionNoSePuedeConstruir, ExcepcionPosicionOcupada {
        Suministros s = new Suministros(0,0);
        JugadorProtoss j = new JugadorProtoss(new Recursos(1000,1000),s);
        Pilon p;

        p = j.construirPilon(new Coordenadas(0,0));
        for (int i = 0; i < p.getTiempoDeConstruccion(); i ++) j.update();
        j.construirPilon(new Coordenadas(0,1));
        for (int i = 0; i < p.getTiempoDeConstruccion(); i ++) j.update();
        j.construirPilon(new Coordenadas(0,2));
        for (int i = 0; i < p.getTiempoDeConstruccion(); i ++) j.update();

        Assert.assertEquals(15,s.getSuministrosLimiteActuales());
    }

    @Test
    public void CreoVariosDepositosDeSuministrosYAumentanLosSuministrosLimiteActuales() throws ExcepcionNoSePuedeConstruir, ExcepcionPosicionOcupada {
        Suministros s = new Suministros(0,0);
        JugadorTerran j = new JugadorTerran(new Recursos(1000,1000),s);
        DepositoDeSuministros d;

        d = j.construirDepositoDeSuministros(new Coordenadas(4, 0));
        for (int i = 0; i < d.getTiempoDeConstruccion(); i ++) j.update();
        j.construirDepositoDeSuministros(new Coordenadas(4, 1));
        for (int i = 0; i < d.getTiempoDeConstruccion(); i ++) j.update();
        j.construirDepositoDeSuministros(new Coordenadas(4, 2));
        for (int i = 0; i < d.getTiempoDeConstruccion(); i ++) j.update();

        Assert.assertEquals(15,s.getSuministrosLimiteActuales());
    }

    @Test
    public void CreoPilonesPeroNoPuedoSuperarLos200SuministrosMaximos() throws ExcepcionNoSePuedeConstruir, ExcepcionPosicionOcupada {
        Suministros s = new Suministros(0,191);
        JugadorProtoss j = new JugadorProtoss(new Recursos(1000,1000),s);
        Pilon p;


        p = j.construirPilon(new Coordenadas(3,0));
        for (int i = 0; i < p.getTiempoDeConstruccion(); i ++) j.update();
        j.construirPilon(new Coordenadas(3,1));
        for (int i = 0; i < p.getTiempoDeConstruccion(); i ++) j.update();
        j.construirPilon(new Coordenadas(3,2));
        for (int i = 0; i < p.getTiempoDeConstruccion(); i ++) j.update();

        Assert.assertEquals(200,s.getSuministrosLimiteActuales());
    }

    @Test
    public void CreoDepositosDeSuministrosPeroNoPuedoSuperarLos200SuministrosMaximos() throws ExcepcionNoSePuedeConstruir, ExcepcionPosicionOcupada {
        Suministros s = new Suministros(0,191);
        JugadorTerran j = new JugadorTerran(new Recursos(1000,1000),s);
        DepositoDeSuministros d;

        d = j.construirDepositoDeSuministros(new Coordenadas(1, 0));
        for (int i = 0; i < d.getTiempoDeConstruccion(); i ++) j.update();
        j.construirDepositoDeSuministros(new Coordenadas(1, 1));
        for (int i = 0; i < d.getTiempoDeConstruccion(); i ++) j.update();
        j.construirDepositoDeSuministros(new Coordenadas(1, 2));
        for (int i = 0; i < d.getTiempoDeConstruccion(); i ++) j.update();

        Assert.assertEquals( 200,s.getSuministrosLimiteActuales());
    }

    @Test
    public void SeDestruyeUnDepositoDeSuminisitrosYDisminuyenLosSuministrosDelJugador() throws ExcepcionAtacarAUnidadAliada, ExcepcionObjetivoFueraDeRango, ExcepcionPosicionOcupada, ExcepcionNoSePuedeConstruir, ExcepcionYaActuo {
        Suministros s = new Suministros(0,20);
        JugadorTerran j1 = new JugadorTerran(new Recursos(1000,1000),s);
        JugadorTerran j2 = new JugadorTerran(new Recursos(200,200),new Suministros(0,20));
        ProxiDeAtaque.inicializar(j2, j1);
        ProxyMapa mapa=ProxyMapa.getInstance();
        DepositoDeSuministros d;
        Marine m = new Marine();
        Coordenadas coordDeDepot = new Coordenadas(5, 6);

        mapa.agregarEnCapaTerrestre(m,new Coordenadas(5,5));
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
        Assert.assertTrue(mapa.posicionTerrestreOcupada(coordDeDepot));
    }

    @Test
    public void SeDestruyeUnPilonYDisminuyenLosSuministrosDelJugador() throws ExcepcionAtacarAUnidadAliada, ExcepcionObjetivoFueraDeRango, ExcepcionPosicionOcupada, ExcepcionNoSePuedeConstruir, ExcepcionYaActuo {
        Suministros s = new Suministros(0,20);
        JugadorProtoss j1 = new JugadorProtoss(new Recursos(1000,1000),s);
        JugadorTerran j2 = new JugadorTerran(new Recursos(200,200),new Suministros(0,20));
        ProxiDeAtaque.inicializar(j2, j1);
        ProxyMapa mapa=ProxyMapa.getInstance();
        Pilon p;
        Marine m = new Marine();
        Coordenadas coordDePilon = new Coordenadas(7, 6);

        mapa.agregarEnCapaTerrestre(m,new Coordenadas(7,5));
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
        Assert.assertTrue(mapa.posicionTerrestreOcupada(coordDePilon));
    }

}
