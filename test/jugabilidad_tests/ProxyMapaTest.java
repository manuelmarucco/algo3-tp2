package jugabilidad_tests;

import excepciones.ExcepcionCoordenadaXIngresadaFueraDelMapa;
import excepciones.ExcepcionCoordenadaYIngresadaFueraDelMapa;
import jugabilidad.ProxyMapa;
import jugabilidad.utilidadesMapa.Coordenadas;
import org.junit.Test;
import unidades.terrran.Marine;

import static org.junit.Assert.*;

public class ProxyMapaTest {

    @Test
    public void comoEsUnSingletonAlCrearDosInstanciasDeberianSerElMismoObjeto(){

        ProxyMapa primeraInstancia = ProxyMapa.getInstance();
        ProxyMapa segundaInstancia = ProxyMapa.getInstance();

        assertTrue(primeraInstancia == segundaInstancia);

    }

    @Test(expected=ExcepcionCoordenadaXIngresadaFueraDelMapa.class)
    public void siIntentoAgregarUnMarineConCoordenadaXFueraDelMapaDeberiaLanzarUnaExcepcion()
            throws ExcepcionCoordenadaXIngresadaFueraDelMapa, ExcepcionCoordenadaYIngresadaFueraDelMapa {

        ProxyMapa proxy = ProxyMapa.getInstance();
        proxy.setCoordenadasMaximas(10,10);

        Coordenadas coordenadas = new Coordenadas(15,5);
        Marine marine = new Marine();

        proxy.agregar(marine, coordenadas);
    }

    @Test(expected= ExcepcionCoordenadaYIngresadaFueraDelMapa.class)
    public void siIntentoAgregarUnMarineConCoordenadaYFueraDelMapaDeberiaLanzarUnaExcepcion()
            throws ExcepcionCoordenadaYIngresadaFueraDelMapa, ExcepcionCoordenadaXIngresadaFueraDelMapa {

        ProxyMapa proxy = ProxyMapa.getInstance();
        proxy.setCoordenadasMaximas(10,10);

        Coordenadas coordenadas = new Coordenadas(5,15);
        Marine marine = new Marine();

        proxy.agregar(marine, coordenadas);
    }

}
