package jugabilidad_tests;

import construcciones.terran.CentroDeMineral;
import construcciones.terran.Refineria;
import excepciones.Mapa.ExcepcionNoSePudoAgregarAlMapa;
import jugabilidad.ProxyMapa;
import jugabilidad.auxiliares.Recursos;
import jugabilidad.extrasJuego.CreadorDeMapa;
import jugabilidad.utilidadesMapa.Coordenadas;
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

        proxyMapa.agregar(centroUno, new Coordenadas(3,23));

        proxyMapa.agregar(centroDos, new Coordenadas(23,3));

        // De no haber cristales saltan Excepciones.
        centroUno.update();
        centroDos.update();

        return true;

    }

    private Boolean comprobarVolcanes() throws ExcepcionNoSePudoAgregarAlMapa {

        ProxyMapa proxyMapa = ProxyMapa.getInstance();
        Refineria refineriaUno = new Refineria(new Recursos(50,0));
        Refineria refineriaDos = new Refineria(new Recursos(50,0));

        proxyMapa.agregar(refineriaUno, new Coordenadas(3,23));
        proxyMapa.agregar(refineriaDos, new Coordenadas(23,3));

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
    public void comprobacionDeMineralesDeberiaPoderConstruirCentrosDeRecoleccionSobreEllos()
            throws ExcepcionNoSePudoAgregarAlMapa {

        CreadorDeMapa creador = new CreadorDeMapa();
        ProxyMapa mapa = creador.crearMapa();

        assertTrue( this.comprobarMinerales() );

    }

    @Test
    public void comprobacionDeVolcanesDeberiaPoderConstruirRefineriasSobreEllos()
            throws ExcepcionNoSePudoAgregarAlMapa {

        CreadorDeMapa creador = new CreadorDeMapa();
        ProxyMapa mapa = creador.crearMapa();

        assertTrue( this.comprobarVolcanes() );

    }

    @Test
    public void comprobarCoordenadasIniciales(){

        CreadorDeMapa creador = new CreadorDeMapa();
        ProxyMapa mapa = creador.crearMapa();

        ArrayList<Coordenadas> bases = creador.obtenerCoordenadasDeLasBases();

        Coordenadas baseUno = bases.get(0);
        Coordenadas baseDos = bases.get(1);

        // Supuestas coordenadas de las bases.
        Coordenadas uno = new Coordenadas(4,22);
        Coordenadas dos = new Coordenadas(22,4);

        assertTrue( baseUno.equals(uno) && baseDos.equals(dos)  );


    }

    // Zonas exclusivamente aereas. Un test por cada coordenada exclusiva, son 7.
    // Intento agregar una unidad terrestre en esas coordenadas exclusivas.

    @Test (expected = ExcepcionNoSePudoAgregarAlMapa.class)
    public void coordenadas1212esperoUnaExcepcion() throws ExcepcionNoSePudoAgregarAlMapa {

        CreadorDeMapa creador = new CreadorDeMapa();
        ProxyMapa mapa = creador.crearMapa();
        Marine marine = new Marine();
        Coordenadas coordenadas = new Coordenadas(12,12);

        mapa.agregar(marine,coordenadas);

    }

    @Test (expected = ExcepcionNoSePudoAgregarAlMapa.class)
    public void coordenadas1213esperoUnaExcepcion() throws ExcepcionNoSePudoAgregarAlMapa {

        CreadorDeMapa creador = new CreadorDeMapa();
        ProxyMapa mapa = creador.crearMapa();
        Marine marine = new Marine();
        Coordenadas coordenadas = new Coordenadas(12,13);

        mapa.agregar(marine, coordenadas);

    }

    @Test (expected = ExcepcionNoSePudoAgregarAlMapa.class)
    public void coordenadas1312esperoUnaExcepcion() throws ExcepcionNoSePudoAgregarAlMapa {

        CreadorDeMapa creador = new CreadorDeMapa();
        ProxyMapa mapa = creador.crearMapa();
        Marine marine = new Marine();
        Coordenadas coordenadas = new Coordenadas(13,12);

        mapa.agregar(marine, coordenadas);

    }

    @Test (expected = ExcepcionNoSePudoAgregarAlMapa.class)
    public void coordenadas1313esperoUnaExcepcion() throws ExcepcionNoSePudoAgregarAlMapa {

        CreadorDeMapa creador = new CreadorDeMapa();
        ProxyMapa mapa = creador.crearMapa();
        Marine marine = new Marine();
        Coordenadas coordenadas = new Coordenadas(13,13);

        mapa.agregar(marine, coordenadas);

    }

    @Test (expected = ExcepcionNoSePudoAgregarAlMapa.class)
    public void coordenadas1314esperoUnaExcepcion() throws ExcepcionNoSePudoAgregarAlMapa {

        CreadorDeMapa creador = new CreadorDeMapa();
        ProxyMapa mapa = creador.crearMapa();
        Marine marine = new Marine();
        Coordenadas coordenadas = new Coordenadas(13,14);

        mapa.agregar(marine, coordenadas);

    }

    @Test (expected = ExcepcionNoSePudoAgregarAlMapa.class)
    public void coordenadas1413esperoUnaExcepcion() throws ExcepcionNoSePudoAgregarAlMapa {

        CreadorDeMapa creador = new CreadorDeMapa();
        ProxyMapa mapa = creador.crearMapa();
        Marine marine = new Marine();
        Coordenadas coordenadas = new Coordenadas(14,13);

        mapa.agregar(marine, coordenadas);

    }

    @Test (expected = ExcepcionNoSePudoAgregarAlMapa.class)
    public void coordenadas1414esperoUnaExcepcion() throws ExcepcionNoSePudoAgregarAlMapa {

        CreadorDeMapa creador = new CreadorDeMapa();
        ProxyMapa mapa = creador.crearMapa();
        Marine marine = new Marine();
        Coordenadas coordenadas = new Coordenadas(14,14);

        mapa.agregar(marine, coordenadas);

    }

    // Zonas exclusivamente aereas. Un test por cada coordenada exclusiva, son 7.
    // Agrego una unidad aerea y verifico que se haya agregado.

    @Test
    public void coordenadas1212() throws ExcepcionNoSePudoAgregarAlMapa {

        CreadorDeMapa creador = new CreadorDeMapa();
        ProxyMapa mapa = creador.crearMapa();
        NaveCiencia naveCiencia = new NaveCiencia();
        Coordenadas coordenadas = new Coordenadas(12,12);

        mapa.agregar(naveCiencia,coordenadas);

        assertEquals(naveCiencia, mapa.obtenerDeCapaAerea(coordenadas));

    }

    @Test
    public void coordenadas1213() throws ExcepcionNoSePudoAgregarAlMapa {

        CreadorDeMapa creador = new CreadorDeMapa();
        ProxyMapa mapa = creador.crearMapa();
        NaveCiencia naveCiencia = new NaveCiencia();
        Coordenadas coordenadas = new Coordenadas(12,13);

        mapa.agregar(naveCiencia,coordenadas);

        assertEquals(naveCiencia, mapa.obtenerDeCapaAerea(coordenadas));

    }

    @Test
    public void coordenadas1312() throws ExcepcionNoSePudoAgregarAlMapa {

        CreadorDeMapa creador = new CreadorDeMapa();
        ProxyMapa mapa = creador.crearMapa();
        NaveCiencia naveCiencia = new NaveCiencia();
        Coordenadas coordenadas = new Coordenadas(13,12);

        mapa.agregar(naveCiencia,coordenadas);

        assertEquals(naveCiencia, mapa.obtenerDeCapaAerea(coordenadas));

    }

    @Test
    public void coordenadas1313() throws ExcepcionNoSePudoAgregarAlMapa {

        CreadorDeMapa creador = new CreadorDeMapa();
        ProxyMapa mapa = creador.crearMapa();
        NaveCiencia naveCiencia = new NaveCiencia();
        Coordenadas coordenadas = new Coordenadas(13,13);

        mapa.agregar(naveCiencia,coordenadas);

        assertEquals(naveCiencia, mapa.obtenerDeCapaAerea(coordenadas));

    }

    @Test
    public void coordenadas1314() throws ExcepcionNoSePudoAgregarAlMapa {

        CreadorDeMapa creador = new CreadorDeMapa();
        ProxyMapa mapa = creador.crearMapa();
        NaveCiencia naveCiencia = new NaveCiencia();
        Coordenadas coordenadas = new Coordenadas(13,14);

        mapa.agregar(naveCiencia,coordenadas);

        assertEquals(naveCiencia, mapa.obtenerDeCapaAerea(coordenadas));

    }

    @Test
    public void coordenadas1413() throws ExcepcionNoSePudoAgregarAlMapa {

        CreadorDeMapa creador = new CreadorDeMapa();
        ProxyMapa mapa = creador.crearMapa();
        NaveCiencia naveCiencia = new NaveCiencia();
        Coordenadas coordenadas = new Coordenadas(14,13);

        mapa.agregar(naveCiencia,coordenadas);

        assertEquals(naveCiencia, mapa.obtenerDeCapaAerea(coordenadas));

    }

    @Test
    public void coordenadas1414() throws ExcepcionNoSePudoAgregarAlMapa {

        CreadorDeMapa creador = new CreadorDeMapa();
        ProxyMapa mapa = creador.crearMapa();
        NaveCiencia naveCiencia = new NaveCiencia();
        Coordenadas coordenadas = new Coordenadas(14,14);

        mapa.agregar(naveCiencia,coordenadas);

        assertEquals(naveCiencia, mapa.obtenerDeCapaAerea(coordenadas));

    }



}
