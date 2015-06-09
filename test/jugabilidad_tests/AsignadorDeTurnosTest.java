package jugabilidad_tests;

import jugabilidad.extrasJuego.AsignadorDeTurnos;
import jugabilidad.Jugador;
import jugabilidad.RazaDeJugador.JugadorProtoss;
import jugabilidad.RazaDeJugador.JugadorTerran;
import jugabilidad.auxiliares.Recursos;

import org.junit.Test;
import static org.junit.Assert.*;

public class AsignadorDeTurnosTest {

    @Test
    public void alPedirPorPrimeraVezElSiguienteJugadorDeberiaDevolverElJugadorUno(){

        Jugador jugadorUno = new JugadorTerran(new Recursos(0,0));
        Jugador jugadorDos = new JugadorProtoss(new Recursos(0,0));

        AsignadorDeTurnos asignador = new AsignadorDeTurnos(jugadorUno, jugadorDos);

        assertTrue( asignador.jugadorSiguiente() == jugadorUno );

    }

    @Test
    @SuppressWarnings("unused")
    public void alPedirPorSegundaVezElSiguienteJugadorDeberiaDevolverElJugadorDos(){

        Jugador jugadorUno = new JugadorTerran(new Recursos(0,0));
        Jugador jugadorDos = new JugadorProtoss(new Recursos(0,0));

        AsignadorDeTurnos asignador = new AsignadorDeTurnos(jugadorUno, jugadorDos);

        Jugador resultadoADesechar = asignador.jugadorSiguiente();
        assertTrue(asignador.jugadorSiguiente() == jugadorDos);

    }

    @Test
    @SuppressWarnings("unused")
    public void alPedirPorTerceraVezElSiguienteJugadorDeberiaDevolverElJugadorDos(){

        Jugador jugadorUno = new JugadorTerran(new Recursos(0,0));
        Jugador jugadorDos = new JugadorProtoss(new Recursos(0,0));

        AsignadorDeTurnos asignador = new AsignadorDeTurnos(jugadorUno, jugadorDos);

        Jugador resultadoADesechar = asignador.jugadorSiguiente();
        resultadoADesechar = asignador.jugadorSiguiente();
        assertTrue( asignador.jugadorSiguiente() == jugadorUno );

    }
}
