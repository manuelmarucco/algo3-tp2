package jugabilidad_tests;

import jugabilidad.CreadorDeMapa;
import jugabilidad.Mapa;
import jugabilidad.utilidadesMapa.Coordenadas;
import org.junit.Test;
import static org.junit.Assert.*;

public class CreadorDeMapaTest {

    private Boolean comprobarMinerales(Mapa mapa){

        Coordenadas coordenadas = new Coordenadas(2,9);
        Boolean cristalSuperiorIzquierdoEncontrado = mapa.posicionTerrestreOcupada(coordenadas);

        coordenadas = new Coordenadas(4,7);
        Boolean volcanSuperiorIzquierdoEncontrado = mapa.posicionTerrestreOcupada(coordenadas);

        coordenadas = new Coordenadas(9,2);
        Boolean cristalInferiorDerechoEncontrado = mapa.posicionTerrestreOcupada(coordenadas);

        coordenadas = new Coordenadas(7,4);
        Boolean volcanInferiorDerechoEncontrado = mapa.posicionTerrestreOcupada(coordenadas);

        Boolean mineralesSuperioresEncontrados = cristalSuperiorIzquierdoEncontrado && volcanSuperiorIzquierdoEncontrado;
        Boolean mineralesInferioresEncontrados = cristalInferiorDerechoEncontrado && volcanInferiorDerechoEncontrado;

        return ( mineralesSuperioresEncontrados && mineralesInferioresEncontrados );
    }

    @Test
    public void test(){

        CreadorDeMapa creador = new CreadorDeMapa();
        Mapa mapa = creador.crearMapa();

        assertTrue( this.comprobarMinerales( mapa ) );

    }

}
