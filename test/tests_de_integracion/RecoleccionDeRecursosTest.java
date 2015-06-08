package tests_de_integracion;

import construcciones.terran.CentroDeMineral;
import construcciones.terran.Refineria;
import jugabilidad.ProxyMapa;
import jugabilidad.auxiliares.Recursos;
import jugabilidad.utilidadesMapa.Coordenadas;
import org.junit.Test;
import recursos.Cristal;
import recursos.Volcan;

import static org.junit.Assert.assertEquals;

public class RecoleccionDeRecursosTest {

    @Test
    public void integracionDelCentroDeMineralConElCristalEnUnMapa(){

        Recursos recursos = new Recursos(0,0);

        ProxyMapa mapa = ProxyMapa.getInstance();
        ProxyMapa.getInstance().setCoordenadasMaximas(10,10);
        Coordenadas coordenadas = new Coordenadas(1,1);
        Cristal cristal = new Cristal();
        CentroDeMineral centroDeMineral = new CentroDeMineral(recursos);

        mapa.agregar(cristal,coordenadas);
        mapa.agregar(centroDeMineral,coordenadas);

        assertEquals( 10,centroDeMineral.obtenerRecurso() );

    }
    
        @Test
    public void cuandoUbicoUnaRefineriaSobreUnVolcanMeDeveriaDevolverDiezMinerales(){

        Recursos recursos = new Recursos(0,0);

            ProxyMapa mapa = ProxyMapa.getInstance();
        Coordenadas coordenadas = new Coordenadas(1,1);
        Volcan volcan = new Volcan();
        Refineria refineria = new Refineria(recursos);

        mapa.agregar(volcan,coordenadas);
        mapa.agregar(refineria,coordenadas);

        assertEquals( 10,refineria.obtenerRecurso() );
    }

    //HAY QUE AGREGAR TESTS DONDE SE VERIFIQUE QUE AL JUGADOR SE LE AUMENTAN LOS RECURSOS

}
