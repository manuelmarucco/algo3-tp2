package tests_de_integracion;

import construcciones.terran.CentroDeMineral;
import construcciones.terran.Refineria;
import jugabilidad.Mapa;
import jugabilidad.auxiliares.Recursos;
import jugabilidad.utilidadesMapa.Coordenadas;
import org.junit.Test;
import static org.junit.Assert.*;
import recursos.Cristal;
import recursos.Volcan;

public class RecoleccionDeRecursosTest {

    @Test
    public void integracionDelCentroDeMineralConElCristalEnUnMapa(){

        Recursos recursos = new Recursos(0,0);

        Mapa mapa = new Mapa();
        Coordenadas coordenadas = new Coordenadas(1,1);
        Cristal cristal = new Cristal();
        CentroDeMineral centroDeMineral = new CentroDeMineral(recursos);

        mapa.agregar(cristal,coordenadas);
        mapa.agregar(centroDeMineral,coordenadas);

        assertEquals( 10,centroDeMineral.obtenerMinerales() );

    }
    
        @Test
    public void cuandoUbicoUnaRefineriaSobreUnVolcanMeDeveriaDevolverDiezMinerales(){

        Recursos recursos = new Recursos(0,0);

        Mapa mapa = new Mapa();
        Coordenadas coordenadas = new Coordenadas(1,1);
        Volcan volcan = new Volcan();
        Refineria refineria = new Refineria(recursos);

        mapa.agregar(volcan,coordenadas);
        mapa.agregar(refineria,coordenadas);

        assertEquals( 10,refineria.obtenerMinerales() );
    }

}
