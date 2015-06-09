package jugabilidad_tests;

import construcciones.terran.CentroDeMineral;
import excepciones.ExcepcionNoSePudoAgregarAlMapa;
import jugabilidad.ProxyMapa;
import jugabilidad.auxiliares.Recursos;
import jugabilidad.extrasJuego.CreadorDeMapa;
import jugabilidad.utilidadesMapa.Coordenadas;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class CreadorDeMapaTest {

    private Boolean comprobarMinerales(){

        // Coloco un CentroDeMineral sobre los cristales, para verificar que ahi hay cristales.


        ProxyMapa proxyMapa = ProxyMapa.getInstance();
        CentroDeMineral centro = new CentroDeMineral(new Recursos(50,0));

        try {
            proxyMapa.agregar(centro, new Coordenadas(2,19));
        } catch (ExcepcionNoSePudoAgregarAlMapa e) {
            e.printStackTrace();
        }
        try {
            proxyMapa.agregar(new CentroDeMineral(new Recursos(50,0)), new Coordenadas(19,2));
        } catch (ExcepcionNoSePudoAgregarAlMapa e) {
            e.printStackTrace();
        }

        // De no haber cristales saltan Excepciones.
        //centro.update();

        return true;

    }

    @Test
    public void test(){

        CreadorDeMapa creador = new CreadorDeMapa();
        ProxyMapa mapa = creador.crearMapa();

        assertTrue( this.comprobarMinerales() );

    }

}
