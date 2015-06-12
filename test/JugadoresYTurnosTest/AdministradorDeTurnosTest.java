package JugadoresYTurnosTest;

import jugabilidad.Juego;
import jugabilidad.Jugador;
import jugabilidad.utilidadesMapa.Coordenadas;
import org.junit.Assert;
import org.junit.Test;

public class AdministradorDeTurnosTest {

    @Test
    public void creo2JugadoresYLosTurnosSonRotativos() {

        Juego juego = new Juego();
        Jugador j1, j2;

        Coordenadas baseUno = new Coordenadas(5,5);
        Coordenadas baseDos = new Coordenadas(5,5);

        j1 = juego.crearJugadorProtoss("jugador1", "rojo", baseUno);
        j2 = juego.crearJugadorTerran("jugador2", "azul", baseDos);

        Assert.assertEquals(j1, juego.getJugador());

        juego.update();
        Assert.assertEquals(j2, juego.getJugador());

        juego.update();
        Assert.assertEquals(j1, juego.getJugador());
    }
}
