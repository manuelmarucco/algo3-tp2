package jugabilidad_tests;

import modelo.excepciones.Mapa.ExcepcionCoordenadaXIngresadaFueraDelMapa;
import modelo.excepciones.Mapa.ExcepcionCoordenadaYIngresadaFueraDelMapa;
import modelo.excepciones.Mapa.ExcepcionNoSePudoAgregarAlMapa;
import modelo.excepciones.Mapa.ExcepcionPosicionOcupada;
import modelo.jugabilidad.ProxyMapa;
import modelo.jugabilidad.utilidadesMapa.Coordenada;
import org.junit.Before;
import org.junit.Test;
import modelo.unidades.terrran.Marine;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class ProxyMapaTest {

    @Before
    public void resetearProxy(){
        ProxyMapa.resetear();
    }

    @Test
    public void comoEsUnSingletonAlCrearDosInstanciasDeberianSerElMismoObjeto(){

        ProxyMapa primeraInstancia = ProxyMapa.getInstance();
        ProxyMapa segundaInstancia = ProxyMapa.getInstance();

        assertTrue(primeraInstancia == segundaInstancia);

    }

    @Test(expected=ExcepcionCoordenadaXIngresadaFueraDelMapa.class)
    public void siIntentoAgregarUnMarineConCoordenadaXFueraDelMapaDeberiaLanzarUnaExcepcion()
            throws ExcepcionNoSePudoAgregarAlMapa {

        ProxyMapa proxy = ProxyMapa.getInstance();
        proxy.setCoordenadasMaximas(10,10);

        Coordenada coordenada = new Coordenada(15,5);
        Marine marine = new Marine();

        proxy.agregar(marine, coordenada);
    }

    @Test(expected= ExcepcionCoordenadaYIngresadaFueraDelMapa.class)
    public void siIntentoAgregarUnMarineConCoordenadaYFueraDelMapaDeberiaLanzarUnaExcepcion()
            throws ExcepcionNoSePudoAgregarAlMapa {

        ProxyMapa proxy = ProxyMapa.getInstance();
        proxy.setCoordenadasMaximas(10,10);

        Coordenada coordenada = new Coordenada(5,15);
        Marine marine = new Marine();

        proxy.agregar(marine, coordenada);
    }

    @Test
    public void siMuevoUnaUnidadTerrestreDeUnPuntoAlOtroElPuntoDondeEstabaDebeEstarVacio()
            throws ExcepcionNoSePudoAgregarAlMapa {

        ProxyMapa proxy = ProxyMapa.getInstance();
        proxy.setCoordenadasMaximas(10,10);

        Coordenada coordenadaUno = new Coordenada(5,5);
        Marine marine = new Marine();

        proxy.agregar(marine, coordenadaUno);
        Coordenada coordenadaDos = new Coordenada(5,6);

        proxy.mover(coordenadaDos, marine);

        assertFalse(proxy.posicionTerrestreOcupada(coordenadaUno));

    }

    @Test(expected = ExcepcionPosicionOcupada.class)
    public void siMuevoUnaUnidadTerrestreDeUnPuntoAOtroQueEstaOcupadoDeberiaRecibirUnaExcepcion()
            throws ExcepcionNoSePudoAgregarAlMapa {

        ProxyMapa proxy = ProxyMapa.getInstance();
        proxy.setCoordenadasMaximas(10,10);

        Coordenada coordenadaUno = new Coordenada(5,5);
        Marine marineUno = new Marine();

        Coordenada coordenadaDos = new Coordenada(5,6);
        Marine marineDos = new Marine();

        proxy.agregar(marineUno, coordenadaUno);
        proxy.agregar(marineDos, coordenadaDos);

        proxy.mover(coordenadaDos, marineUno);
    }

    @Test
    public void siMuevoUnaUnidadTerrestreDeUnPuntoAOtroQueEstaOcupadoLaPrimeraPosicionDeberiaEstarOcupada()
            throws ExcepcionNoSePudoAgregarAlMapa {

        ProxyMapa proxy = ProxyMapa.getInstance();
        proxy.setCoordenadasMaximas(10,10);

        Coordenada coordenadaUno = new Coordenada(5,5);
        Marine marineUno = new Marine();

        Coordenada coordenadaDos = new Coordenada(5,6);
        Marine marineDos = new Marine();

        proxy.agregar(marineUno, coordenadaUno);
        proxy.agregar(marineDos, coordenadaDos);

        try {
            proxy.mover(coordenadaDos, marineUno);
        } catch (ExcepcionPosicionOcupada e){
            e.printStackTrace();
        }

        assertTrue(proxy.posicionTerrestreOcupada(coordenadaUno));
    }

    @Test
    public void siMuevoUnaUnidadTerrestreDeUnPuntoAOtroQueEstaOcupadoLaSegundaPosicionDeberiaEstarOcupada()
            throws ExcepcionNoSePudoAgregarAlMapa {

        ProxyMapa proxy = ProxyMapa.getInstance();
        proxy.setCoordenadasMaximas(10,10);

        Coordenada coordenadaUno = new Coordenada(5,5);
        Marine marineUno = new Marine();

        Coordenada coordenadaDos = new Coordenada(5,6);
        Marine marineDos = new Marine();

        proxy.agregar(marineUno, coordenadaUno);
        proxy.agregar(marineDos, coordenadaDos);

        try {
            proxy.mover(coordenadaDos, marineUno);
        } catch (ExcepcionPosicionOcupada e){
            e.printStackTrace();
        }

        assertTrue(proxy.posicionTerrestreOcupada(coordenadaDos));
    }

    @Test (expected= ExcepcionNoSePudoAgregarAlMapa.class)
    public void siPidoLasUnidadesEncerradasPorUnaCircunferenciaDeCentroNoPertenecienteAlMapaEsperoUnaExcepcion()
    throws ExcepcionNoSePudoAgregarAlMapa {

        ProxyMapa proxy = ProxyMapa.getInstance();
        proxy.setCoordenadasMaximas(10,10);

        Coordenada centro = new Coordenada(11,11);

        proxy.obtenerUnidadesYConstruccionesEncerradasEnCircunferenciaDe(centro,1);

    }

}
