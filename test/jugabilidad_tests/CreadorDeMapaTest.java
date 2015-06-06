package jugabilidad_tests;

import jugabilidad.CreadorDeMapa;
import jugabilidad.Mapa;
import jugabilidad.utilidadesMapa.Coordenadas;
import org.junit.Test;
import static org.junit.Assert.*;

public class CreadorDeMapaTest {

    private Boolean comprobarMinerales(Mapa mapa){

        // TODO: Hacer esto.
        return true;
    }

    @Test
    public void test(){

        CreadorDeMapa creador = new CreadorDeMapa();
        Mapa mapa = creador.crearMapa();

        assertTrue( this.comprobarMinerales( mapa ) );

    }

}
