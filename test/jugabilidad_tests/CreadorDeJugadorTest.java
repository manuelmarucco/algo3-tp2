package jugabilidad_tests;


import jugabilidad.Jugador;
import jugabilidad.extrasJuego.CreadorDeJugador;

import org.junit.Test;
import static org.junit.Assert.*;

public class CreadorDeJugadorTest {

    @Test
    public void alCrearUnNombreTerranSeDeberianVerificarElNombreYColorAsignados(){

        CreadorDeJugador creadorDeJugador = new CreadorDeJugador();
        Jugador jugador = creadorDeJugador.crearNuevoJugadorTerran("Mariano", "Azul");

        assertTrue(jugador.getNombre().equals("Mariano")  && jugador.getColor().equals("Azul") );

    }

}
