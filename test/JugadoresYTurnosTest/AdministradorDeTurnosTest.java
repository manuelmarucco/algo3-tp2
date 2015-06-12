package JugadoresYTurnosTest;

import construcciones.Construccion;
import jugabilidad.Juego;
import jugabilidad.Jugador;
import jugabilidad.utilidadesMapa.Coordenadas;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;

public class AdministradorDeTurnosTest {

    @Test
    public void creo2JugadoresYLosTurnosSonRotativos() {

        Juego juego = new Juego();
        Jugador j1, j2;

        juego.crearMapa();
        ArrayList<Coordenadas> bases = juego.getBases();

        j1 = juego.crearJugadorProtoss("jugador1", "rojo", bases.get(0));
        j2 = juego.crearJugadorTerran("jugador2", "azul", bases.get(1));

        Assert.assertEquals(j1, juego.getJugador());

        juego.update();
        Assert.assertEquals(j2, juego.getJugador());

        juego.update();
        Assert.assertEquals(j1, juego.getJugador());
    }

    @Test
    @SuppressWarnings("unused")
    public void verificoQueElPrimerTurnoCorrespondeAlPrimerJugadorEnDarseDeAlta() {

        Juego juego = new Juego();
        juego.crearMapa();
        ArrayList<Coordenadas> bases = juego.getBases();

        Jugador jugadorUno = juego.crearJugadorProtoss("jugador1", "rojo", bases.get(0));
        Jugador JugadorDos = juego.crearJugadorTerran("jugador2", "azul", bases.get(1));

        Assert.assertEquals(jugadorUno, juego.getJugador());
    }

}
