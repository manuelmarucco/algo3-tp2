package jugabilidad_tests;

import jugabilidad.auxiliares.Vision;
import jugabilidad.utilidadesMapa.Coordenada;
import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class VisibilidadTest {

    @Test
    public void dadasunasCoordenadasYUnRadioDeVisionDeberiaAgregarLosPuntosVisibles(){

        Coordenada coordenada = new Coordenada(5,5);
        int radioDeVision = 1;

        Vision vision = new Vision();
        vision.agregarSectorVisible(coordenada,radioDeVision);

        // Centro
        assertTrue(vision.esVisible(new Coordenada(5,5)));
        // Arriba
        assertTrue(vision.esVisible(new Coordenada(5,6)));
        // Derecha
        assertTrue(vision.esVisible(new Coordenada(6,5)));
        // Izquierda
        assertTrue(vision.esVisible(new Coordenada(4,5)));
        // Abajo
        assertTrue(vision.esVisible(new Coordenada(5,4)));

    }

    @Test
    public void dadasunasCoordenadasYUnRadioDeVisionNoDeberiaAgregarPuntosAMayorRadio(){
        Coordenada coordenada = new Coordenada(5,5);
        int radioDeVision = 1;

        Vision vision = new Vision();
        vision.agregarSectorVisible(coordenada,radioDeVision);

        // Centro
        assertFalse(vision.esVisible(new Coordenada(4, 6)));
        // Arriba
        assertFalse(vision.esVisible(new Coordenada(4, 4)));
        // Derecha
        assertFalse(vision.esVisible(new Coordenada(6, 4)));
        // Izquierda
        assertFalse(vision.esVisible(new Coordenada(6, 6)));

    }

    @Test
    public void paraUnMapaDeCincoPorCincoSeDeberianAgregarLosVenticincoPuntos(){

        Vision vision = Vision.VisionCompleta(5,5);

        assertTrue(vision.esVisible(new Coordenada(1,1)));
        assertTrue(vision.esVisible(new Coordenada(2,1)));
        assertTrue(vision.esVisible(new Coordenada(3,1)));
        assertTrue(vision.esVisible(new Coordenada(4,1)));
        assertTrue(vision.esVisible(new Coordenada(5,1)));
        assertTrue(vision.esVisible(new Coordenada(1,2)));
        assertTrue(vision.esVisible(new Coordenada(2,2)));
        assertTrue(vision.esVisible(new Coordenada(3,2)));
        assertTrue(vision.esVisible(new Coordenada(4,2)));
        assertTrue(vision.esVisible(new Coordenada(5,2)));
        assertTrue(vision.esVisible(new Coordenada(1,3)));
        assertTrue(vision.esVisible(new Coordenada(2,3)));
        assertTrue(vision.esVisible(new Coordenada(3,3)));
        assertTrue(vision.esVisible(new Coordenada(4,3)));
        assertTrue(vision.esVisible(new Coordenada(5,3)));
        assertTrue(vision.esVisible(new Coordenada(1,4)));
        assertTrue(vision.esVisible(new Coordenada(2,4)));
        assertTrue(vision.esVisible(new Coordenada(3,4)));
        assertTrue(vision.esVisible(new Coordenada(4,4)));
        assertTrue(vision.esVisible(new Coordenada(5,4)));
        assertTrue(vision.esVisible(new Coordenada(1,5)));
        assertTrue(vision.esVisible(new Coordenada(2,5)));
        assertTrue(vision.esVisible(new Coordenada(3,5)));
        assertTrue(vision.esVisible(new Coordenada(4,5)));
        assertTrue(vision.esVisible(new Coordenada(5,5)));


    }

}
