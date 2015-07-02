package JugadoresYTurnosTest;

import modelo.jugabilidad.Juego;
import modelo.jugabilidad.Jugador;
import modelo.jugabilidad.ProxyMapa;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class AdministradorDeTurnosTest {


    ProxyMapa proxyMapa;
    @Before
    public void resetearProxy(){
        ProxyMapa.resetear();

        proxyMapa = ProxyMapa.getInstance();
        proxyMapa.setCoordenadasMaximas(20,20);
    }

    @Test
    public void creo2JugadoresYLosTurnosSonRotativos() {

        Juego juego = new Juego(2);
        Jugador j1, j2;

        j1 = juego.crearJugadorProtoss("jugador1", "rojo");
        j2 = juego.crearJugadorTerran("jugador2", "azul");

        Assert.assertEquals(j1, juego.getJugadorActual());

        juego.update();
        Assert.assertEquals(j2, juego.getJugadorActual());

        juego.update();
        Assert.assertEquals(j1, juego.getJugadorActual());
    }

    @Test
    @SuppressWarnings("unused")
    public void verificoQueElPrimerTurnoCorrespondeAlPrimerJugadorEnDarseDeAlta() {

        Juego juego = new Juego(2);

        Jugador jugadorUno = juego.crearJugadorProtoss("jugador1", "rojo");
        Jugador JugadorDos = juego.crearJugadorTerran("jugador2", "azul");

        Assert.assertEquals(jugadorUno, juego.getJugadorActual());
    }

}
