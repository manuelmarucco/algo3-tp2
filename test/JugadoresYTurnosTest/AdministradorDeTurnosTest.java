package JugadoresYTurnosTest;

import jugabilidad.Juego;
import jugabilidad.Jugador;
import org.junit.Assert;
import org.junit.Test;

public class AdministradorDeTurnosTest {
    @Test
    public void creo3JugadoresYLosTurnosSonRotativos() {
        Juego juego = new Juego();
        Jugador j1, j2, j3;

        j1 = juego.crearJugadorProtoss("manuel", "rojo");
        j2 = juego.crearJugadorTerran("jorge", "azul");
        j3 = juego.crearJugadorProtoss("mariano", "amarillo");

        Assert.assertEquals(j1, juego.getJugador());

        juego.update();
        Assert.assertEquals(j2, juego.getJugador());

        juego.update();
        Assert.assertEquals(j3, juego.getJugador());

        juego.update();
        Assert.assertEquals(j1, juego.getJugador());
    }
}
