package consingnasTests;


import excepciones.ExcepcionAtacarAUnidadAliada;
import excepciones.ExcepcionNoSePudoAgregarAlMapa;
import excepciones.ExcepcionObjetivoFueraDeRango;
import excepciones.ExcepcionYaActuo;
import jugabilidad.ProxyMapa;
import jugabilidad.RazaDeJugador.JugadorProtoss;
import jugabilidad.RazaDeJugador.JugadorTerran;
import jugabilidad.auxiliares.Recursos;
import jugabilidad.auxiliares.Suministros;
import jugabilidad.auxiliares.Vision;
import jugabilidad.extrasJuego.AdministradorDeTurnos;
import jugabilidad.utilidadesMapa.Coordenadas;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import unidades.ProxiDeAtaque;
import unidades.ProxyDeHechizos;
import unidades.protoss.AltoTemplario;
import unidades.protoss.ClonGuerrero;
import excepciones.ExcepcionNoPuedeAtacarAire;
import unidades.protoss.Zealot;
import unidades.terrran.NaveCiencia;

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
        mapa =ProxyMapa.getInstance();
        mapa.setCoordenadasMaximas(10, 10);
        ProxiDeAtaque.inicializar(j1, j2);
        ProxyDeHechizos.inicializar(j1,j2);
        v = Vision.VisionCompleta(10,10);
    }

    /*   Se construye  una nave de ciencia, se pasan turnos para que acumule la suficiente energía.
    A continuación se sitúa una unidad protoss, se le aplica el misil EMP. Se verifica que:
    La nave de ciencia tenga menos energía
    El protoss no tenga más escudo*/
    @Test
    public void primerTest() throws ExcepcionNoSePudoAgregarAlMapa, ExcepcionYaActuo {
        NaveCiencia nc = new NaveCiencia(v);
        j1.agregarUnidad(nc);
        AltoTemplario at = new AltoTemplario(v);
        j2.agregarUnidad(at);
        Coordenadas c1 = new Coordenadas(1,1);
        Coordenadas c2 = new Coordenadas(6,5);
        ProxyMapa.getInstance().setCoordenadasMaximas(10, 10);
        ProxyMapa mapa = ProxyMapa.getInstance();
        mapa.agregar(nc, c1);
        mapa.agregar(at, c2);
        for(int i = 0;i<10;i++) asignadorDeTurnos.update();//paso 5 turnos
        Assert.assertEquals(100,nc.getEnergia());//energia antes de EMP
        nc.EMP(c2);
        Assert.assertEquals(0, nc.getEnergia());//le bajo la energia a la nave
        Assert.assertEquals(0, at.getEscudo());
    }
    /*Se sitúa un alto templario y otra nave de ciencia (propia o no). se lanza el EMP. Se verifica que:
    La nave de ciencia tenga menos energía
    El alto templario y la otra nave de ciencia no tengan más energía*/
    @Test
    public void segundoTest() throws ExcepcionNoSePudoAgregarAlMapa, ExcepcionYaActuo {
        NaveCiencia nc = new NaveCiencia(v);
        NaveCiencia nc2 = new NaveCiencia(v);
        j1.agregarUnidad(nc);
        j1.agregarUnidad(nc2);
        AltoTemplario at = new AltoTemplario(v);
        j2.agregarUnidad(at);
        Coordenadas c1 = new Coordenadas(1,1);
        Coordenadas c2 = new Coordenadas(6,5);
        Coordenadas c3 = new Coordenadas(6,6);
        ProxyMapa.getInstance().setCoordenadasMaximas(10, 10);
        ProxyMapa mapa = ProxyMapa.getInstance();
        mapa.agregar(nc, c1);
        mapa.agregar(at, c2);
        mapa.agregar(nc2, c3);
        for(int i = 0;i<10;i++) asignadorDeTurnos.update();//paso 5 turnos
        Assert.assertEquals(100,nc.getEnergia());//energia antes de EMP
        nc.EMP(c2);
        Assert.assertEquals(0, nc.getEnergia());//le bajo la energia a la nave
        Assert.assertEquals(0, at.getEnergia());
        Assert.assertEquals(0, nc2.getEnergia());
    }
    /*Se sitúan una unidad protoss y un alto templario. Se lanza el EMP fuera del rango de alcance del mismo. Se verifica que:
    La nave de ciencia tenga menos energía
    El alto templario y la unidad protoss no han sufrido modificaciones.*/
    @Test
    public void tercerTest() throws ExcepcionNoSePudoAgregarAlMapa, ExcepcionYaActuo {
        NaveCiencia nc = new NaveCiencia(v);
        j1.agregarUnidad(nc);
        AltoTemplario at = new AltoTemplario(v);
        Zealot zl = new Zealot();
        j2.agregarUnidad(at);
        j2.agregarUnidad(zl);
        Coordenadas c1 = new Coordenadas(1,1);
        Coordenadas c2 = new Coordenadas(6,5);
        Coordenadas c3 = new Coordenadas(6,6);
        ProxyMapa.getInstance().setCoordenadasMaximas(10, 10);
        ProxyMapa mapa = ProxyMapa.getInstance();
        mapa.agregar(nc, c1);
        mapa.agregar(at, c2);
        mapa.agregar(zl,c3);
        for(int i = 0;i<10;i++) asignadorDeTurnos.update();//paso 5 turnos
        Assert.assertEquals(100,nc.getEnergia());//energia antes de EMP
        nc.EMP(new Coordenadas(3, 3));
        Assert.assertEquals(0, nc.getEnergia());//le bajo la energia a la nave
        Assert.assertEquals(40, at.getEscudo());//no baja el escudo
        Assert.assertEquals(60, zl.getEscudo());
    }

   /* Se contruye un alto templario, se pasan turnos  para que acumule la suficiente energía.
    se sitúan unidades enemigas, se lanza la tormenta psiónica. Se comprueba el daño.
    Se sitúa una unidad propia y se le aplica la alucinación. Se corrobora:
    Solo poseen escudo y no vida //TODO:preguntar por esto
    Se les hace pelear contra un enemigo y el enemigo no recibe daño.
    Al recibir un EMP, mueren instantáneamente.*/

    @Test
    public void cuartoTest() throws ExcepcionNoSePudoAgregarAlMapa, ExcepcionYaActuo {
        NaveCiencia nc = new NaveCiencia(v);
        j1.agregarUnidad(nc);
        AltoTemplario at = new AltoTemplario(v);
        Zealot zl = new Zealot();
        j2.agregarUnidad(at);
        j2.agregarUnidad(zl);
        Coordenadas c1 = new Coordenadas(7,7);
        Coordenadas c2 = new Coordenadas(6,5);
        Coordenadas c3 = new Coordenadas(6,6);
        Coordenadas c4 = new Coordenadas(6,7);
        Coordenadas c5 = new Coordenadas(7,6);
        mapa.agregar(nc, c1);
        mapa.agregar(at, c2);
        mapa.agregar(zl, c3);
        for(int i = 0;i<10;i++) asignadorDeTurnos.update();//paso 5 turnos
        at.alucinacion(zl,c4,c5);
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
    /* 5) Naves de transporte soportan su capacidad. Se debe probar que se sube unidades, desde un punto A , se pasa por espacio y se bajan del otro lado tierra B.*/
    /* 9) Verificar recuperación del escudo protoss con el paso de los turnos.*/


}
