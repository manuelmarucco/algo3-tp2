package jugabilidad_tests;

import excepciones.ExcepcionCoordenadaXIngresadaFueraDelMapa;
import excepciones.ExcepcionCoordenadaYIngresadaFueraDelMapa;
import excepciones.ExcepcionNoSePudoAgregarAlMapa;
import excepciones.ExcepcionPosicionOcupada;
import jugabilidad.ProxyMapa;
import jugabilidad.utilidadesMapa.Coordenadas;
import org.junit.Before;
import org.junit.Test;
import unidades.terrran.Marine;

import static org.junit.Assert.*;

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

        Coordenadas coordenadas = new Coordenadas(15,5);
        Marine marine = new Marine();

        proxy.agregar(marine, coordenadas);
    }

    @Test(expected= ExcepcionCoordenadaYIngresadaFueraDelMapa.class)
    public void siIntentoAgregarUnMarineConCoordenadaYFueraDelMapaDeberiaLanzarUnaExcepcion()
            throws ExcepcionNoSePudoAgregarAlMapa {

        ProxyMapa proxy = ProxyMapa.getInstance();
        proxy.setCoordenadasMaximas(10,10);

        Coordenadas coordenadas = new Coordenadas(5,15);
        Marine marine = new Marine();

        proxy.agregar(marine, coordenadas);
    }

    @Test
    public void siMuevoUnaUnidadTerrestreDeUnPuntoAlOtroElPuntoDondeEstabaDebeEstarVacio()
            throws ExcepcionNoSePudoAgregarAlMapa {

        ProxyMapa proxy = ProxyMapa.getInstance();
        proxy.setCoordenadasMaximas(10,10);

        Coordenadas coordenadasUno = new Coordenadas(5,5);
        Marine marine = new Marine();

        proxy.agregar(marine, coordenadasUno);
        Coordenadas coordenadasDos = new Coordenadas(5,6);

        proxy.mover(coordenadasDos, marine);

        assertFalse(proxy.posicionTerrestreOcupada(coordenadasUno));

    }

    @Test(expected = ExcepcionPosicionOcupada.class)
    public void siMuevoUnaUnidadTerrestreDeUnPuntoAOtroQueEstaOcupadoDeberiaRecibirUnaExcepcion()
            throws ExcepcionNoSePudoAgregarAlMapa {

        ProxyMapa proxy = ProxyMapa.getInstance();
        proxy.setCoordenadasMaximas(10,10);

        Coordenadas coordenadasUno = new Coordenadas(5,5);
        Marine marineUno = new Marine();

        Coordenadas coordenadasDos = new Coordenadas(5,6);
        Marine marineDos = new Marine();

        proxy.agregar(marineUno, coordenadasUno);
        proxy.agregar(marineDos, coordenadasDos);

        proxy.mover(coordenadasDos, marineUno);
    }

    @Test
    public void siMuevoUnaUnidadTerrestreDeUnPuntoAOtroQueEstaOcupadoLaPrimeraPosicionDeberiaEstarOcupada()
            throws ExcepcionNoSePudoAgregarAlMapa {

        ProxyMapa proxy = ProxyMapa.getInstance();
        proxy.setCoordenadasMaximas(10,10);

        Coordenadas coordenadasUno = new Coordenadas(5,5);
        Marine marineUno = new Marine();

        Coordenadas coordenadasDos = new Coordenadas(5,6);
        Marine marineDos = new Marine();

        proxy.agregar(marineUno, coordenadasUno);
        proxy.agregar(marineDos, coordenadasDos);

        try {
            proxy.mover(coordenadasDos, marineUno);
        } catch (ExcepcionPosicionOcupada e){
            e.printStackTrace();
        }

        assertTrue(proxy.posicionTerrestreOcupada(coordenadasUno));
    }

    @Test
    public void siMuevoUnaUnidadTerrestreDeUnPuntoAOtroQueEstaOcupadoLaSegundaPosicionDeberiaEstarOcupada()
            throws ExcepcionNoSePudoAgregarAlMapa {

        ProxyMapa proxy = ProxyMapa.getInstance();
        proxy.setCoordenadasMaximas(10,10);

        Coordenadas coordenadasUno = new Coordenadas(5,5);
        Marine marineUno = new Marine();

        Coordenadas coordenadasDos = new Coordenadas(5,6);
        Marine marineDos = new Marine();

        proxy.agregar(marineUno, coordenadasUno);
        proxy.agregar(marineDos, coordenadasDos);

        try {
            proxy.mover(coordenadasDos, marineUno);
        } catch (ExcepcionPosicionOcupada e){
            e.printStackTrace();
        }

        assertTrue(proxy.posicionTerrestreOcupada(coordenadasDos));
    }

}
