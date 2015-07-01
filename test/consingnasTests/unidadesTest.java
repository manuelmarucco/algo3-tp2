package consingnasTests;


import excepciones.Mapa.ExcepcionCasillaVacia;
import excepciones.Mapa.ExcepcionNoSePudoAgregarAlMapa;
import excepciones.Unidades.*;
import excepciones.construcciones.ExcepcionNoSePuedeClonarEdificio;
import jugabilidad.ProxyMapa;
import jugabilidad.RazaDeJugador.JugadorProtoss;
import jugabilidad.RazaDeJugador.JugadorTerran;
import jugabilidad.auxiliares.Recursos;
import jugabilidad.auxiliares.Suministros;
import jugabilidad.auxiliares.Vision;
import jugabilidad.extrasJuego.AdministradorDeTurnos;
import jugabilidad.utilidadesMapa.Coordenada;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import unidades.ProxiDeAtaque;
import unidades.ProxyDeHechizos;
import unidades.protoss.*;
import unidades.terrran.*;

public class unidadesTest {

    private JugadorTerran j1;
    private JugadorProtoss j2;
    private AdministradorDeTurnos asignadorDeTurnos;
    private ProxyMapa mapa;
    private Vision v;
    @Before
    public void init(){
        j1 = new JugadorTerran(new Recursos(200,200),new Suministros(100,200));
        j2 = new JugadorProtoss(new Recursos(200,200),new Suministros(100,200));
        asignadorDeTurnos = new AdministradorDeTurnos();
        asignadorDeTurnos.agregarJugador(j1);
        asignadorDeTurnos.agregarJugador(j2);
        ProxyMapa.resetear();
        ProxiDeAtaque.inicializar(j1);
        ProxiDeAtaque.inicializar(j2);
        ProxyDeHechizos.inicializar(j1);
        ProxyDeHechizos.inicializar(j2);
        v = Vision.VisionCompleta(20,20);
        this.mapa = ProxyMapa.getInstance();
        mapa.setCoordenadasMaximas(20,20);
    }

    /*   Se construye  una nave de ciencia, se pasan turnos para que acumule la suficiente energía.
    A continuación se sitúa una unidad protoss, se le aplica el misil EMP. Se verifica que:
    La nave de ciencia tenga menos energía
    El protoss no tenga más escudo*/
    @Test
    public void primerTest() throws ExcepcionNoSePudoAgregarAlMapa, ExcepcionDeAccionDeUnidad {
        NaveCiencia nc = new NaveCiencia(v);
        j1.agregarUnidad(nc);
        AltoTemplario at = new AltoTemplario(v);
        j2.agregarUnidad(at);
        Coordenada c1 = new Coordenada(1,1);
        Coordenada c2 = new Coordenada(6,5);
        ProxyMapa.getInstance().setCoordenadasMaximas(10, 10);
        ProxyMapa mapa = ProxyMapa.getInstance();
        mapa.agregar(nc, c1);
        mapa.agregar(at, c2);
        for(int i = 0;i<10;i++) asignadorDeTurnos.update();//paso 5 turnos
        Assert.assertEquals(100, nc.getEnergiaActual());//energia antes de EMP
        nc.EMP(c2);
        Assert.assertEquals(0, nc.getEnergiaActual());//le bajo la energia a la nave
        Assert.assertEquals(0, at.getEscudo());
    }
    /*Se sitúa un alto templario y otra nave de ciencia (propia o no). se lanza el EMP. Se verifica que:
    La nave de ciencia tenga menos energía
    El alto templario y la otra nave de ciencia no tengan más energía*/
    @Test
    public void segundoTest() throws ExcepcionNoSePudoAgregarAlMapa, ExcepcionDeAccionDeUnidad {
        NaveCiencia nc = new NaveCiencia(v);
        NaveCiencia nc2 = new NaveCiencia(v);
        j1.agregarUnidad(nc);
        j1.agregarUnidad(nc2);
        AltoTemplario at = new AltoTemplario(v);
        j2.agregarUnidad(at);
        Coordenada c1 = new Coordenada(1,1);
        Coordenada c2 = new Coordenada(6,5);
        Coordenada c3 = new Coordenada(6,6);
        ProxyMapa.getInstance().setCoordenadasMaximas(10, 10);
        ProxyMapa mapa = ProxyMapa.getInstance();
        mapa.agregar(nc, c1);
        mapa.agregar(at, c2);
        mapa.agregar(nc2, c3);
        for(int i = 0;i<10;i++) asignadorDeTurnos.update();//paso 5 turnos
        Assert.assertEquals(100,nc.getEnergiaActual());//energia antes de EMP
        nc.EMP(c2);
        Assert.assertEquals(0, nc.getEnergiaActual());//le bajo la energia a la nave
        Assert.assertEquals(0, at.getEnergiaActual());
        Assert.assertEquals(0, nc2.getEnergiaActual());
    }
    /*Se sitúan una unidad protoss y un alto templario. Se lanza el EMP fuera del rango de alcance del mismo. Se verifica que:
    La nave de ciencia tenga menos energía
    El alto templario y la unidad protoss no han sufrido modificaciones.*/
    @Test
    public void tercerTest() throws ExcepcionNoSePudoAgregarAlMapa, ExcepcionDeAccionDeUnidad {
        NaveCiencia nc = new NaveCiencia(v);
        j1.agregarUnidad(nc);
        AltoTemplario at = new AltoTemplario(v);
        Zealot zl = new Zealot(v);
        j2.agregarUnidad(at);
        j2.agregarUnidad(zl);
        Coordenada c1 = new Coordenada(1,1);
        Coordenada c2 = new Coordenada(6,5);
        Coordenada c3 = new Coordenada(6,6);
        mapa.agregar(nc, c1);
        mapa.agregar(at, c2);
        mapa.agregar(zl,c3);
        for(int i = 0;i<10;i++) asignadorDeTurnos.update();//paso 5 turnos
        Assert.assertEquals(100,nc.getEnergiaActual());//energia antes de EMP
        nc.EMP(new Coordenada(3, 3));
        Assert.assertEquals(0, nc.getEnergiaActual());//le bajo la energia a la nave
        Assert.assertEquals(40, at.getEscudo());//no baja el escudo
        Assert.assertEquals(60, zl.getEscudo());
    }

   /* Se contruye un alto templario, se pasan turnos  para que acumule la suficiente energía.
    se sitúan unidades enemigas, se lanza la tormenta psiónica. Se comprueba el daño.
    Se sitúa una unidad propia y se le aplica la alucinación. Se corrobora:
    Solo poseen escudo y no vida
    Se les hace pelear contra un enemigo y el enemigo no recibe daño.
    Al recibir un EMP, mueren instantáneamente.*/

    @Test
    public void cuartoTest() throws ExcepcionNoSePudoAgregarAlMapa, ExcepcionDeAccionDeUnidad, ExcepcionNoSePuedeClonarEdificio, ExcepcionCasillaVacia {
        NaveCiencia nc = new NaveCiencia(v);
        j1.agregarUnidad(nc);
        AltoTemplario at = new AltoTemplario(v);
        Zealot zl = new Zealot(v);
        j2.agregarUnidad(at);
        j2.agregarUnidad(zl);
        Coordenada c1 = new Coordenada(7,7);
        Coordenada c2 = new Coordenada(6,5);
        Coordenada c3 = new Coordenada(6,6);
        Coordenada c4 = new Coordenada(5,5);
        Coordenada c5 = new Coordenada(7,6);
        mapa.agregar(nc, c1);
        mapa.agregar(at, c2);
        mapa.agregar(zl, c3);
        for(int i = 0;i<10;i++) asignadorDeTurnos.update();//paso 5 turnos
        at.alucinacion(c3);
        ((ClonGuerrero)mapa.obtenerDeCapaTerrestre(c4)).atacarTierra(c1);
        Assert.assertEquals(200, nc.getVida());
        asignadorDeTurnos.update();
        nc.EMP(c3);
        Assert.assertFalse(mapa.posicionTerrestreOcupada(c4));
        Assert.assertFalse(mapa.posicionTerrestreOcupada(c5));

    }
   /* 3) Unidades de tierra no pueden atacar a unidades de aire y visceversa en todas las combinaciones, cuando corresponda.*/

    @Test(expected = ExcepcionNoPuedeAtacarAire.class)
    public void quintoTest() throws ExcepcionObjetivoFueraDeRango, ExcepcionYaActuo, ExcepcionAtacarAUnidadAliada, ExcepcionNoPuedeAtacarAire {
        NaveCiencia nc = new NaveCiencia(v);
        j1.agregarUnidad(nc);
        Zealot zl = new Zealot(v);
        j2.agregarUnidad(zl);
        zl.atacarAire(nc);
    }

    /*4) Se verifica unidad por unidad, que ataque en el rango correspondiente.*/
    @Test
    public void marineAtacaTest() throws ExcepcionNoSePudoAgregarAlMapa, ExcepcionDeAccionDeUnidad {
        Marine m = new Marine(v);
        j1.agregarUnidad(m);
        Zealot zl = new Zealot(v);
        j2.agregarUnidad(zl);
        Coordenada c1 = new Coordenada(1,1);
        Coordenada c2 = new Coordenada(2,2);
        mapa.agregar(m, c1);
        mapa.agregar(zl, c2);
        m.atacar(c2);
        Assert.assertEquals(54, zl.getEscudo());
    }

    @Test(expected = ExcepcionObjetivoFueraDeRango.class)
    public void marineNoAtacaTest() throws ExcepcionNoSePudoAgregarAlMapa, ExcepcionDeAccionDeUnidad {
        Marine m = new Marine(v);
        j1.agregarUnidad(m);
        Zealot zl = new Zealot(v);
        j2.agregarUnidad(zl);
        Coordenada c1 = new Coordenada(1,1);
        Coordenada c2 = new Coordenada(5,2);
        mapa.agregar(m, c1);
        mapa.agregar(zl, c2);
        m.atacar(c2);
        Assert.assertEquals(54, zl.getEscudo());
    }

    @Test
    public void golliatAtacaTest() throws ExcepcionNoSePudoAgregarAlMapa, ExcepcionDeAccionDeUnidad {
        Golliat g = new Golliat(v);
        j1.agregarUnidad(g);
        Zealot zl = new Zealot(v);
        j2.agregarUnidad(zl);
        Coordenada c1 = new Coordenada(1,1);
        Coordenada c2 = new Coordenada(2,2);
        mapa.agregar(g, c1);
        mapa.agregar(zl, c2);
        g.atacar(c2);
        Assert.assertEquals(48, zl.getEscudo());
    }

    @Test(expected = ExcepcionObjetivoFueraDeRango.class)
    public void golliatNoAtacaTest() throws ExcepcionNoSePudoAgregarAlMapa, ExcepcionDeAccionDeUnidad {
        Golliat g = new Golliat(v);
        j1.agregarUnidad(g);
        Zealot zl = new Zealot(v);
        j2.agregarUnidad(zl);
        Coordenada c1 = new Coordenada(1,1);
        Coordenada c2 = new Coordenada(7,3);
        mapa.agregar(g, c1);
        mapa.agregar(zl,c2);
        g.atacar(c2);
        Assert.assertEquals(54,zl.getEscudo());
    }

    @Test
    public void espectroAtacaTest() throws ExcepcionNoSePudoAgregarAlMapa, ExcepcionDeAccionDeUnidad {
        Espectro e = new Espectro(v);
        j1.agregarUnidad(e);
        Zealot zl = new Zealot(v);
        j2.agregarUnidad(zl);
        Coordenada c1 = new Coordenada(1,1);
        Coordenada c2 = new Coordenada(2,2);
        mapa.agregar(e, c1);
        mapa.agregar(zl, c2);
        e.atacar(c2);
        Assert.assertEquals(52, zl.getEscudo());
    }

    @Test(expected = ExcepcionObjetivoFueraDeRango.class)
    public void espectroNoAtacaTest() throws ExcepcionNoSePudoAgregarAlMapa, ExcepcionDeAccionDeUnidad {
        Espectro e = new Espectro(v);
        j1.agregarUnidad(e);
        Zealot zl = new Zealot(v);
        j2.agregarUnidad(zl);
        Coordenada c1 = new Coordenada(1,1);
        Coordenada c2 = new Coordenada(6,2);
        mapa.agregar(e, c1);
        mapa.agregar(zl, c2);
        e.atacar(c2);;
        Assert.assertEquals(52, zl.getEscudo());
    }

    @Test
    public void zealotAtacaTest() throws ExcepcionNoSePudoAgregarAlMapa, ExcepcionDeAccionDeUnidad {
        Marine m = new Marine(v);
        j1.agregarUnidad(m);
        Zealot zl = new Zealot(v);
        j2.agregarUnidad(zl);
        Coordenada c1 = new Coordenada(1,1);
        Coordenada c2 = new Coordenada(1,2);
        mapa.agregar(m, c1);
        mapa.agregar(zl, c2);
        zl.atacar(c1);
        Assert.assertEquals(32, m.getVida());
    }

    @Test(expected = ExcepcionObjetivoFueraDeRango.class)
    public void zealotNoAtacaTest() throws ExcepcionNoSePudoAgregarAlMapa, ExcepcionDeAccionDeUnidad {
        Marine m = new Marine(v);
        j1.agregarUnidad(m);
        Zealot zl = new Zealot(v);
        j2.agregarUnidad(zl);
        Coordenada c1 = new Coordenada(1,1);
        Coordenada c2 = new Coordenada(2,2);
        mapa.agregar(m, c1);
        mapa.agregar(zl, c2);
        zl.atacar(c1);
        Assert.assertEquals(54, m.getVida());
    }

    @Test
    public void dragontAtacaTest() throws ExcepcionNoSePudoAgregarAlMapa, ExcepcionDeAccionDeUnidad {
        Marine m = new Marine(v);
        j1.agregarUnidad(m);
        Dragon zl = new Dragon(v);
        j2.agregarUnidad(zl);
        Coordenada c1 = new Coordenada(1,1);
        Coordenada c2 = new Coordenada(1,2);
        mapa.agregar(m, c1);
        mapa.agregar(zl, c2);
        zl.atacar(c1);
        Assert.assertEquals(20, m.getVida());
    }

    @Test(expected = ExcepcionObjetivoFueraDeRango.class)
    public void dragonNoAtacaTest() throws ExcepcionNoSePudoAgregarAlMapa, ExcepcionDeAccionDeUnidad {
        Marine m = new Marine(v);
        j1.agregarUnidad(m);
        Dragon zl = new Dragon(v);
        j2.agregarUnidad(zl);
        Coordenada c1 = new Coordenada(1,1);
        Coordenada c2 = new Coordenada(5,2);
        mapa.agregar(m, c1);
        mapa.agregar(zl, c2);
        zl.atacar(c1);
        Assert.assertEquals(54, m.getVida());
    }

    @Test
    public void scoutAtacaTest() throws ExcepcionNoSePudoAgregarAlMapa, ExcepcionDeAccionDeUnidad {
        Marine m = new Marine(v);
        j1.agregarUnidad(m);
        Scout zl = new Scout(v);
        j2.agregarUnidad(zl);
        Coordenada c1 = new Coordenada(1,1);
        Coordenada c2 = new Coordenada(1,2);
        mapa.agregar(m, c1);
        mapa.agregar(zl, c2);
        zl.atacar(c1);
        Assert.assertEquals(32, m.getVida());
    }

    @Test(expected = ExcepcionObjetivoFueraDeRango.class)
    public void scoutNoAtacaTest() throws ExcepcionNoSePudoAgregarAlMapa, ExcepcionDeAccionDeUnidad {
        Marine m = new Marine(v);
        j1.agregarUnidad(m);
        Scout zl = new Scout(v);
        j2.agregarUnidad(zl);
        Coordenada c1 = new Coordenada(1,1);
        Coordenada c2 = new Coordenada(5,2);
        mapa.agregar(m, c1);
        mapa.agregar(zl, c2);
        zl.atacar(c1);
        Assert.assertEquals(54, m.getVida());
    }

    /* 5) Naves de transporte soportan su capacidad. Se debe probar que se sube unidades, desde un punto A , se pasa por espacio y se bajan del otro lado tierra B.*/

    @Test
    public void naveTransporteTerranCargaUnMarineYlodeja() throws ExcepcionNoSePudoAgregarAlMapa, ExcepcionDeAccionDeUnidad {
        Marine m = new Marine(v);
        j1.agregarUnidad(m);
        NaveTransporteTerran nt = new NaveTransporteTerran(v);
        j1.agregarUnidad(nt);
        Coordenada c1 = new Coordenada(1,1);
        Coordenada c2 = new Coordenada(1,5);
        mapa.agregar(m, c1);
        mapa.agregar(nt, c1);
        Assert.assertTrue(mapa.posicionTerrestreOcupada(c1));
        nt.cargar(m);
        Assert.assertEquals(1, nt.getTransporteOcupado());
        Assert.assertFalse(mapa.posicionTerrestreOcupada(c1));
        nt.mover(c2);
        asignadorDeTurnos.update();//paso el turno
        Assert.assertFalse(mapa.posicionTerrestreOcupada(c2));
        nt.descargar(c2);
        Assert.assertTrue(mapa.posicionTerrestreOcupada(c2));
    }

    @Test(expected = ExcepcionCargaSuperada.class)
    public void naveTransporteTerranSeLLena() throws ExcepcionNoSePudoAgregarAlMapa, ExcepcionDeAccionDeUnidad {
        Golliat g1 = new Golliat(v);
        Golliat g2 = new Golliat(v);
        Golliat g3 = new Golliat(v);
        Golliat g4 = new Golliat(v);
        Golliat g5 = new Golliat(v);
        j1.agregarUnidad(g1);
        j1.agregarUnidad(g2);
        j1.agregarUnidad(g3);
        j1.agregarUnidad(g4);
        j1.agregarUnidad(g5);
        NaveTransporteTerran nt = new NaveTransporteTerran(v);
        j1.agregarUnidad(nt);
        Coordenada c1 = new Coordenada(1,1);
        Coordenada c2 = new Coordenada(1,2);
        Coordenada c3 = new Coordenada(1,3);
        Coordenada c4 = new Coordenada(1,4);
        Coordenada c5 = new Coordenada(1,5);
        mapa.agregar(g1, c1);
        mapa.agregar(g2, c2);
        mapa.agregar(g3, c3);
        mapa.agregar(g4, c4);
        mapa.agregar(g5, c5);
        mapa.agregar(nt, c1);
        nt.cargar(g1);
        Assert.assertEquals(2, nt.getTransporteOcupado());
        nt.mover(c2);
        asignadorDeTurnos.update();
        asignadorDeTurnos.update();
        nt.cargar(g2);
        Assert.assertEquals(4, nt.getTransporteOcupado());
        nt.mover(c3);
        asignadorDeTurnos.update();
        asignadorDeTurnos.update();
        nt.cargar(g3);
        Assert.assertEquals(6, nt.getTransporteOcupado());
        nt.mover(c4);
        asignadorDeTurnos.update();
        asignadorDeTurnos.update();
        nt.cargar(g4);
        Assert.assertEquals(8, nt.getTransporteOcupado());
        nt.mover(c5);
        asignadorDeTurnos.update();
        asignadorDeTurnos.update();
        nt.cargar(g5);
    }

    @Test
    public void naveTransporteProtossCargaUnZealotYlodeja() throws ExcepcionNoSePudoAgregarAlMapa, ExcepcionDeAccionDeUnidad {
        Zealot m = new Zealot(v);
        j2.agregarUnidad(m);
        NaveTransporteProtoss nt = new NaveTransporteProtoss(v);
        j2.agregarUnidad(nt);
        Coordenada c1 = new Coordenada(1,1);
        Coordenada c2 = new Coordenada(1,5);
        mapa.agregar(m, c1);
        mapa.agregar(nt, c1);
        Assert.assertTrue(mapa.posicionTerrestreOcupada(c1));
        nt.cargar(m);
        Assert.assertEquals(2, nt.getTransporteOcupado());
        Assert.assertFalse(mapa.posicionTerrestreOcupada(c1));
        nt.mover(c2);
        asignadorDeTurnos.update();//paso el turno
        asignadorDeTurnos.update();//paso el turno
        Assert.assertFalse(mapa.posicionTerrestreOcupada(c2));
        nt.descargar(c2);
        Assert.assertTrue(mapa.posicionTerrestreOcupada(c2));
    }

    @Test(expected = ExcepcionCargarUnidadEnemiga.class)
    public void naveTransporteNOCargaEnemigos() throws ExcepcionNoSePudoAgregarAlMapa, ExcepcionDeAccionDeUnidad {

        Marine m = new Marine(v);
        j1.agregarUnidad(m);
        NaveTransporteProtoss nt = new NaveTransporteProtoss(v);
        j2.agregarUnidad(nt);
        Coordenada c1 = new Coordenada(1,1);
        mapa.agregar(m, c1);
        mapa.agregar(nt, c1);
        Assert.assertTrue(mapa.posicionTerrestreOcupada(c1));
        nt.cargar(m);
    }

    @Test
    public void naveTransporteMuereTambienLoHaceLaCarga() throws ExcepcionNoSePudoAgregarAlMapa, ExcepcionDeAccionDeUnidad {
        Zealot m = new Zealot(v);
        j2.agregarUnidad(m);
        NaveTransporteProtoss nt = new NaveTransporteProtoss(v);
        j2.agregarUnidad(nt);
        Coordenada c1 = new Coordenada(1,1);
        mapa.agregar(m, c1);
        mapa.agregar(nt, c1);
        Assert.assertTrue(mapa.posicionTerrestreOcupada(c1));
        nt.cargar(m);
        Assert.assertTrue(j2.buscarUnidad(m));
        nt.recibirDanio(140);
        asignadorDeTurnos.update();
        asignadorDeTurnos.update();
        Assert.assertFalse(j2.buscarUnidad(m));
        Assert.assertFalse(j2.buscarUnidad(nt));
    }

    @Test(expected = ExcepcionCargaSuperada.class)
    public void naveTransporteProtossSeLLena() throws ExcepcionNoSePudoAgregarAlMapa, ExcepcionDeAccionDeUnidad {
        Dragon g1 = new Dragon(v);
        AltoTemplario g2 = new AltoTemplario(v);
        Dragon g3 = new Dragon(v);
        j1.agregarUnidad(g1);
        j1.agregarUnidad(g2);
        j1.agregarUnidad(g3);
        NaveTransporteTerran nt = new NaveTransporteTerran(v);
        j1.agregarUnidad(nt);
        Coordenada c1 = new Coordenada(1,1);
        Coordenada c2 = new Coordenada(1,2);
        Coordenada c3 = new Coordenada(1,3);
        mapa.agregar(g1, c1);
        mapa.agregar(g2, c2);
        mapa.agregar(g3, c3);
        mapa.agregar(nt, c1);
        nt.cargar(g1);
        Assert.assertEquals(4, nt.getTransporteOcupado());
        nt.mover(c2);
        asignadorDeTurnos.update();
        asignadorDeTurnos.update();
        nt.cargar(g2);
        Assert.assertEquals(6, nt.getTransporteOcupado());
        nt.mover(c3);
        asignadorDeTurnos.update();
        asignadorDeTurnos.update();
        nt.cargar(g3);
    }
    /* 9) Verificar recuperación del escudo protoss con el paso de los turnos.*/

    @Test
    public void zealotRegeneraEscudoTest() throws ExcepcionNoSePudoAgregarAlMapa, ExcepcionDeAccionDeUnidad {
        Golliat g = new Golliat(v);
        j1.agregarUnidad(g);
        Zealot zl = new Zealot(v);
        j2.agregarUnidad(zl);
        Coordenada c1 = new Coordenada(1,1);
        Coordenada c2 = new Coordenada(2,2);
        mapa.agregar(g, c1);
        mapa.agregar(zl, c2);
        g.atacar(c2);
        Assert.assertEquals(48, zl.getEscudo());
        asignadorDeTurnos.update();
        asignadorDeTurnos.update();
        Assert.assertEquals(51, zl.getEscudo());
    }

    @Test
    public void DragonRegeneraEscudoTest() throws ExcepcionNoSePudoAgregarAlMapa, ExcepcionDeAccionDeUnidad {
        Golliat g = new Golliat(v);
        j1.agregarUnidad(g);
        Dragon zl = new Dragon(v);
        j2.agregarUnidad(zl);
        Coordenada c1 = new Coordenada(1,1);
        Coordenada c2 = new Coordenada(2,2);
        mapa.agregar(g, c1);
        mapa.agregar(zl, c2);
        g.atacar(c2);
        Assert.assertEquals(68, zl.getEscudo());
        asignadorDeTurnos.update();
        asignadorDeTurnos.update();
        Assert.assertEquals(72, zl.getEscudo());
    }

    @Test
    public void ScoutRegeneraEscudoTest() throws ExcepcionNoSePudoAgregarAlMapa, ExcepcionDeAccionDeUnidad {
        Golliat g = new Golliat(v);
        j1.agregarUnidad(g);
        Scout zl = new Scout(v);
        j2.agregarUnidad(zl);
        Coordenada c1 = new Coordenada(1,1);
        Coordenada c2 = new Coordenada(2,2);
        mapa.agregar(g, c1);
        mapa.agregar(zl, c2);
        g.atacar(c2);
        Assert.assertEquals(90, zl.getEscudo());
        asignadorDeTurnos.update();
        asignadorDeTurnos.update();
        Assert.assertEquals(95, zl.getEscudo());
    }

    @Test
    public void AltoTemplarioRegeneraEscudoTest() throws ExcepcionNoSePudoAgregarAlMapa, ExcepcionDeAccionDeUnidad {
        Golliat g = new Golliat(v);
        j1.agregarUnidad(g);
        AltoTemplario zl = new AltoTemplario(v);
        j2.agregarUnidad(zl);
        Coordenada c1 = new Coordenada(1,1);
        Coordenada c2 = new Coordenada(2,2);
        mapa.agregar(g, c1);
        mapa.agregar(zl, c2);
        g.atacar(c2);
        Assert.assertEquals(28, zl.getEscudo());
        asignadorDeTurnos.update();
        asignadorDeTurnos.update();
        Assert.assertEquals(30, zl.getEscudo());
    }

    @Test
    public void NaveTransporteProtossRegeneraEscudoTest() throws ExcepcionNoSePudoAgregarAlMapa, ExcepcionDeAccionDeUnidad {
        Golliat g = new Golliat(v);
        j1.agregarUnidad(g);
        NaveTransporteProtoss zl = new NaveTransporteProtoss(v);
        j2.agregarUnidad(zl);
        Coordenada c1 = new Coordenada(1,1);
        Coordenada c2 = new Coordenada(2,2);
        mapa.agregar(g, c1);
        mapa.agregar(zl, c2);
        g.atacar(c2);
        Assert.assertEquals(50, zl.getEscudo());
        asignadorDeTurnos.update();
        asignadorDeTurnos.update();
        Assert.assertEquals(53, zl.getEscudo());
    }
}
