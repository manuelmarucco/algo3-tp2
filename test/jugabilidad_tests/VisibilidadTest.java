package jugabilidad_tests;

import jugabilidad.auxiliares.Vision;
import jugabilidad.utilidadesMapa.Coordenadas;
import org.junit.Test;
import static org.junit.Assert.*;

public class VisibilidadTest {

    @Test
    public void dadasunasCoordenadasYUnRadioDeVisionDeberiaAgregarLosPuntosVisibles(){

        Coordenadas coordenadas = new Coordenadas(5,5);
        int radioDeVision = 1;

        Vision vision = new Vision();
        vision.agregarSectorVisible(coordenadas,radioDeVision);

        // Centro
        assertTrue(vision.esVisible(new Coordenadas(5,5)));
        // Arriba
        assertTrue(vision.esVisible(new Coordenadas(5,6)));
        // Derecha
        assertTrue(vision.esVisible(new Coordenadas(6,5)));
        // Izquierda
        assertTrue(vision.esVisible(new Coordenadas(4,5)));
        // Abajo
        assertTrue(vision.esVisible(new Coordenadas(5,4)));

    }

    @Test
    public void dadasunasCoordenadasYUnRadioDeVisionNoDeberiaAgregarPuntosAMayorRadio(){
        Coordenadas coordenadas = new Coordenadas(5,5);
        int radioDeVision = 1;

        Vision vision = new Vision();
        vision.agregarSectorVisible(coordenadas,radioDeVision);

        // Centro
        assertFalse(vision.esVisible(new Coordenadas(4, 6)));
        // Arriba
        assertFalse(vision.esVisible(new Coordenadas(4, 4)));
        // Derecha
        assertFalse(vision.esVisible(new Coordenadas(6, 4)));
        // Izquierda
        assertFalse(vision.esVisible(new Coordenadas(6, 6)));

    }

    @Test
    public void paraUnMapaDeCincoPorCincoSeDeberianAgregarLosVenticincoPuntos(){

        Vision vision = Vision.VisionCompleta(5,5);

        assertTrue(vision.esVisible(new Coordenadas(1,1)));
        assertTrue(vision.esVisible(new Coordenadas(2,1)));
        assertTrue(vision.esVisible(new Coordenadas(3,1)));
        assertTrue(vision.esVisible(new Coordenadas(4,1)));
        assertTrue(vision.esVisible(new Coordenadas(5,1)));
        assertTrue(vision.esVisible(new Coordenadas(1,2)));
        assertTrue(vision.esVisible(new Coordenadas(2,2)));
        assertTrue(vision.esVisible(new Coordenadas(3,2)));
        assertTrue(vision.esVisible(new Coordenadas(4,2)));
        assertTrue(vision.esVisible(new Coordenadas(5,2)));
        assertTrue(vision.esVisible(new Coordenadas(1,3)));
        assertTrue(vision.esVisible(new Coordenadas(2,3)));
        assertTrue(vision.esVisible(new Coordenadas(3,3)));
        assertTrue(vision.esVisible(new Coordenadas(4,3)));
        assertTrue(vision.esVisible(new Coordenadas(5,3)));
        assertTrue(vision.esVisible(new Coordenadas(1,4)));
        assertTrue(vision.esVisible(new Coordenadas(2,4)));
        assertTrue(vision.esVisible(new Coordenadas(3,4)));
        assertTrue(vision.esVisible(new Coordenadas(4,4)));
        assertTrue(vision.esVisible(new Coordenadas(5,4)));
        assertTrue(vision.esVisible(new Coordenadas(1,5)));
        assertTrue(vision.esVisible(new Coordenadas(2,5)));
        assertTrue(vision.esVisible(new Coordenadas(3,5)));
        assertTrue(vision.esVisible(new Coordenadas(4,5)));
        assertTrue(vision.esVisible(new Coordenadas(5,5)));


    }

}
