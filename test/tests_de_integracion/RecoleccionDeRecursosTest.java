package tests_de_integracion;

import construcciones.terran.CentroDeMineral;
import jugabilidad.Mapa;
import jugabilidad.auxiliares.Recursos;
import jugabilidad.utilidadesMapa.Coordenadas;
import org.junit.Test;
import static org.junit.Assert.*;
import recursos.Cristal;

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


}
