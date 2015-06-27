package jugabilidad_tests;

import construcciones.terran.CentroDeMineral;
import construcciones.terran.Refineria;
import excepciones.Mapa.ExcepcionNoSePudoAgregarAlMapa;
import jugabilidad.ProxyMapa;
import jugabilidad.auxiliares.Recursos;
import jugabilidad.extrasJuego.CreadorDeMapa;
import jugabilidad.utilidadesMapa.Coordenada;
import org.junit.Before;
import org.junit.Test;
import unidades.terrran.Marine;
import unidades.terrran.NaveCiencia;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class CreadorDeMapaTest {

    private Boolean comprobarMinerales() throws ExcepcionNoSePudoAgregarAlMapa {

        // Coloco un CentroDeMineral sobre los cristales, para verificar que ahi hay cristales.


        ProxyMapa proxyMapa = ProxyMapa.getInstance();
        CentroDeMineral centroUno = new CentroDeMineral(new Recursos(50,0));
        CentroDeMineral centroDos = new CentroDeMineral(new Recursos(50,0));

        proxyMapa.agregar(centroUno, new Coordenada(3,23));
        proxyMapa.agregar(centroDos, new Coordenada(23,3));

        // De no haber cristales saltan Excepciones.
        centroUno.update();
        centroDos.update();

        return true;

    }

    private Boolean comprobarVolcanes() throws ExcepcionNoSePudoAgregarAlMapa {

        ProxyMapa proxyMapa = ProxyMapa.getInstance();
        Refineria refineriaUno = new Refineria(new Recursos(50,0));
        Refineria refineriaDos = new Refineria(new Recursos(50,0));

        proxyMapa.agregar(refineriaUno, new Coordenada(3,23));
        proxyMapa.agregar(refineriaDos, new Coordenada(23,3));

        // De no haber cristales saltan Excepciones.
        refineriaUno.update();
        refineriaDos.update();

        return true;
    }

    @Before
    public void resetearProxy(){
        ProxyMapa.resetear();
    }

    @Test
    @SuppressWarnings("unused")
    public void comprobacionDeMineralesDeberiaPoderConstruirCentrosDeRecoleccionSobreEllos()
            throws ExcepcionNoSePudoAgregarAlMapa {

        CreadorDeMapa creador = new CreadorDeMapa(2);
        ProxyMapa proxyMapa = creador.obtenerProxyMapa();

        assertTrue( this.comprobarMinerales() );

    }

    @Test
    @SuppressWarnings("unused")
    public void comprobacionDeVolcanesDeberiaPoderConstruirRefineriasSobreEllos()
            throws ExcepcionNoSePudoAgregarAlMapa {

        CreadorDeMapa creador = new CreadorDeMapa(2);
        ProxyMapa proxyMapa = creador.obtenerProxyMapa();

        assertTrue( this.comprobarVolcanes() );

    }

    @Test
    @SuppressWarnings("unused")
    public void comprobarCoordenadasIniciales(){

        CreadorDeMapa creador = new CreadorDeMapa(2);
        ProxyMapa proxyMapa = creador.obtenerProxyMapa();

        ArrayList<Coordenada> bases = creador.obtenerCoordenadasDeLasBases();

        Coordenada baseUno = bases.get(0);
        Coordenada baseDos = bases.get(1);

        // Supuestas coordenadas de las bases.
        Coordenada uno = new Coordenada(4,22);
        Coordenada dos = new Coordenada(22,4);

        assertTrue( baseUno.equals(uno) && baseDos.equals(dos)  );


    }

    // Zonas exclusivamente aereas. Un test por cada coordenada exclusiva, son 7.
    // Intento agregar una unidad terrestre en esas coordenadas exclusivas.

    @Test (expected = ExcepcionNoSePudoAgregarAlMapa.class)
    public void coordenadas1214esperoUnaExcepcion() throws ExcepcionNoSePudoAgregarAlMapa {

        CreadorDeMapa creador = new CreadorDeMapa(2);
        ProxyMapa proxyMapa = creador.obtenerProxyMapa();

        Marine marine = new Marine();
        Coordenada coordenada = new Coordenada(12,14);

        proxyMapa.agregar(marine, coordenada);

    }

    @Test (expected = ExcepcionNoSePudoAgregarAlMapa.class)
    public void coordenadas1314esperoUnaExcepcion() throws ExcepcionNoSePudoAgregarAlMapa {

        CreadorDeMapa creador = new CreadorDeMapa(2);
        ProxyMapa proxyMapa = creador.obtenerProxyMapa();
        Marine marine = new Marine();
        Coordenada coordenada = new Coordenada(13,14);

        proxyMapa.agregar(marine, coordenada);

    }

    @Test (expected = ExcepcionNoSePudoAgregarAlMapa.class)
    public void coordenadas1215esperoUnaExcepcion() throws ExcepcionNoSePudoAgregarAlMapa {

        CreadorDeMapa creador = new CreadorDeMapa(2);
        ProxyMapa proxyMapa = creador.obtenerProxyMapa();
        Marine marine = new Marine();
        Coordenada coordenada = new Coordenada(12,15);

        proxyMapa.agregar(marine, coordenada);

    }

    @Test (expected = ExcepcionNoSePudoAgregarAlMapa.class)
    public void coordenadas1315esperoUnaExcepcion() throws ExcepcionNoSePudoAgregarAlMapa {

        CreadorDeMapa creador = new CreadorDeMapa(2);
        ProxyMapa proxyMapa = creador.obtenerProxyMapa();
        Marine marine = new Marine();
        Coordenada coordenada = new Coordenada(13,15);

        proxyMapa.agregar(marine, coordenada);

    }

    @Test (expected = ExcepcionNoSePudoAgregarAlMapa.class)
    public void coordenadas1415esperoUnaExcepcion() throws ExcepcionNoSePudoAgregarAlMapa {

        CreadorDeMapa creador = new CreadorDeMapa(2);
        ProxyMapa proxyMapa = creador.obtenerProxyMapa();
        Marine marine = new Marine();
        Coordenada coordenada = new Coordenada(14,15);

        proxyMapa.agregar(marine, coordenada);

    }

    @Test (expected = ExcepcionNoSePudoAgregarAlMapa.class)
    public void coordenadas1316esperoUnaExcepcion() throws ExcepcionNoSePudoAgregarAlMapa {

        CreadorDeMapa creador = new CreadorDeMapa(2);
        ProxyMapa proxyMapa = creador.obtenerProxyMapa();
        Marine marine = new Marine();
        Coordenada coordenada = new Coordenada(13,16);

        proxyMapa.agregar(marine, coordenada);

    }

    @Test (expected = ExcepcionNoSePudoAgregarAlMapa.class)
    public void coordenadas1416esperoUnaExcepcion() throws ExcepcionNoSePudoAgregarAlMapa {

        CreadorDeMapa creador = new CreadorDeMapa(2);
        ProxyMapa proxyMapa = creador.obtenerProxyMapa();
        Marine marine = new Marine();
        Coordenada coordenada = new Coordenada(14,16);

        proxyMapa.agregar(marine, coordenada);

    }

    // Zonas exclusivamente aereas. Un test por cada coordenada exclusiva, son 7.
    // Agrego una unidad aerea y verifico que se haya agregado.

    @Test
    public void coordenadas1214() throws ExcepcionNoSePudoAgregarAlMapa {

        CreadorDeMapa creador = new CreadorDeMapa(2);
        ProxyMapa proxyMapa = creador.obtenerProxyMapa();

        NaveCiencia naveCiencia = new NaveCiencia();
        Coordenada coordenada = new Coordenada(12,14);

        proxyMapa.agregar(naveCiencia, coordenada);

        assertEquals(naveCiencia, proxyMapa.obtenerDeCapaAerea(coordenada));

    }

    @Test
    public void coordenadas1314() throws ExcepcionNoSePudoAgregarAlMapa {

        CreadorDeMapa creador = new CreadorDeMapa(2);
        ProxyMapa proxyMapa = creador.obtenerProxyMapa();
        NaveCiencia naveCiencia = new NaveCiencia();
        Coordenada coordenada = new Coordenada(13,14);

        proxyMapa.agregar(naveCiencia, coordenada);

        assertEquals(naveCiencia, proxyMapa.obtenerDeCapaAerea(coordenada));

    }

    @Test
    public void coordenadas1215() throws ExcepcionNoSePudoAgregarAlMapa {

        CreadorDeMapa creador = new CreadorDeMapa(2);
        ProxyMapa proxyMapa = creador.obtenerProxyMapa();
        NaveCiencia naveCiencia = new NaveCiencia();
        Coordenada coordenada = new Coordenada(12,15);

        proxyMapa.agregar(naveCiencia, coordenada);

        assertEquals(naveCiencia, proxyMapa.obtenerDeCapaAerea(coordenada));

    }

    @Test
    public void coordenadas1315() throws ExcepcionNoSePudoAgregarAlMapa {

        CreadorDeMapa creador = new CreadorDeMapa(2);
        ProxyMapa proxyMapa = creador.obtenerProxyMapa();
        NaveCiencia naveCiencia = new NaveCiencia();
        Coordenada coordenada = new Coordenada(13,15);

        proxyMapa.agregar(naveCiencia, coordenada);

        assertEquals(naveCiencia, proxyMapa.obtenerDeCapaAerea(coordenada));

    }

    @Test
    public void coordenadas1415() throws ExcepcionNoSePudoAgregarAlMapa {

        CreadorDeMapa creador = new CreadorDeMapa(2);
        ProxyMapa proxyMapa = creador.obtenerProxyMapa();
        NaveCiencia naveCiencia = new NaveCiencia();
        Coordenada coordenada = new Coordenada(14,15);

        proxyMapa.agregar(naveCiencia, coordenada);

        assertEquals(naveCiencia, proxyMapa.obtenerDeCapaAerea(coordenada));

    }

    @Test
    public void coordenadas1316() throws ExcepcionNoSePudoAgregarAlMapa {

        CreadorDeMapa creador = new CreadorDeMapa(2);
        ProxyMapa proxyMapa = creador.obtenerProxyMapa();
        NaveCiencia naveCiencia = new NaveCiencia();
        Coordenada coordenada = new Coordenada(13,16);

        proxyMapa.agregar(naveCiencia, coordenada);

        assertEquals(naveCiencia, proxyMapa.obtenerDeCapaAerea(coordenada));

    }

    @Test
    public void coordenadas1416() throws ExcepcionNoSePudoAgregarAlMapa {

        CreadorDeMapa creador = new CreadorDeMapa(2);
        ProxyMapa proxyMapa = creador.obtenerProxyMapa();
        NaveCiencia naveCiencia = new NaveCiencia();
        Coordenada coordenada = new Coordenada(14,16);

        proxyMapa.agregar(naveCiencia, coordenada);

        assertEquals(naveCiencia, proxyMapa.obtenerDeCapaAerea(coordenada));

    }

    // En las coordenadas en las que se encuentra un recurso, volcan/cristal, no se pordran poner unidades terrestres
    // Intento agregar una unidad terrestre en esas coordenadas, espero una excepcion.

    @Test (expected = ExcepcionNoSePudoAgregarAlMapa.class)
    public void coordenadas323esperoUnaExcepcion() throws ExcepcionNoSePudoAgregarAlMapa {

        CreadorDeMapa creador = new CreadorDeMapa(2);
        ProxyMapa proxyMapa = creador.obtenerProxyMapa();
        Marine marine = new Marine();
        Coordenada coordenada = new Coordenada(3,23);

        proxyMapa.agregar(marine, coordenada);

    }

    @Test (expected = ExcepcionNoSePudoAgregarAlMapa.class)
    public void coordenadas233esperoUnaExcepcion() throws ExcepcionNoSePudoAgregarAlMapa {

        CreadorDeMapa creador = new CreadorDeMapa(2);
        ProxyMapa proxyMapa = creador.obtenerProxyMapa();
        Marine marine = new Marine();
        Coordenada coordenada = new Coordenada(23,3);

        proxyMapa.agregar(marine, coordenada);

    }

    @Test (expected = ExcepcionNoSePudoAgregarAlMapa.class)
    public void coordenadas521esperoUnaExcepcion() throws ExcepcionNoSePudoAgregarAlMapa {

        CreadorDeMapa creador = new CreadorDeMapa(2);
        ProxyMapa proxyMapa = creador.obtenerProxyMapa();
        Marine marine = new Marine();
        Coordenada coordenada = new Coordenada(5,21);

        proxyMapa.agregar(marine, coordenada);

    }

    @Test (expected = ExcepcionNoSePudoAgregarAlMapa.class)
    public void coordenadas215esperoUnaExcepcion() throws ExcepcionNoSePudoAgregarAlMapa {

        CreadorDeMapa creador = new CreadorDeMapa(2);
        ProxyMapa proxyMapa = creador.obtenerProxyMapa();
        Marine marine = new Marine();
        Coordenada coordenada = new Coordenada(21,5);

        proxyMapa.agregar(marine, coordenada);

    }

}
