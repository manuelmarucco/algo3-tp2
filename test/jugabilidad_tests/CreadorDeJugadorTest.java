package jugabilidad_tests;

import excepciones.jugador.ExcepcionNoSePudoCrearElJugador;
import excepciones.jugador.ExcepcionElColorIngresadoRepiteAlDeOtroJugador;
import excepciones.jugador.ExcepcionElNombreIngresadoRepiteAlDeOtroJugador;
import excepciones.jugador.ExcepcionNombreDeJugadorMenorACuatroCaracteres;

import jugabilidad.Jugador;
import jugabilidad.extrasJuego.CreadorDeJugador;

import org.junit.Test;
import static org.junit.Assert.*;

public class CreadorDeJugadorTest {

    @Test
    public void alCrearUnJugadorTerranSeDeberianVerificarElNombreYColorAsignados()
            throws ExcepcionNoSePudoCrearElJugador {

        CreadorDeJugador creadorDeJugador = new CreadorDeJugador();

        Jugador jugador = creadorDeJugador.crearNuevoJugadorTerran("Mariano", "Azul");

        assertTrue(jugador.getNombre().equals("Mariano")  && jugador.getColor().equals("Azul") );

    }

    @Test
    public void alCrearUnJugadorProtosSeDeberianVerificarElNombreYColorAsignados()
            throws ExcepcionNoSePudoCrearElJugador{

        CreadorDeJugador creadorDeJugador = new CreadorDeJugador();
        Jugador jugador = creadorDeJugador.crearNuevoJugadorProtos("Mariano", "Azul");

        assertTrue(jugador.getNombre().equals("Mariano")  && jugador.getColor().equals("Azul") );

    }

    @Test (expected = ExcepcionNombreDeJugadorMenorACuatroCaracteres.class)
    public void alCrearseUnJugadorSiSuNombreTieneMenosDeCuatroCaracteresEsperoUnaExcepcion()
            throws ExcepcionNoSePudoCrearElJugador{

        CreadorDeJugador creadorDeJugador = new CreadorDeJugador();

        Jugador jugador = creadorDeJugador.crearNuevoJugadorProtos("Mar", "Azul");

    }

    @Test
    @SuppressWarnings("unused")
    public void alCrearElSegundoJugadorSiElNombreYElColorNoSonIgualesAlDelPrimeroDeberianVerificarse()
            throws ExcepcionNoSePudoCrearElJugador{

        CreadorDeJugador creadorDeJugador = new CreadorDeJugador();

        Jugador jugadorUno = creadorDeJugador.crearNuevoJugadorProtos("Mariano", "Azul");
        Jugador jugadorDos = creadorDeJugador.crearNuevoJugadorProtos("Roberto", "Rojo");

        assertTrue(jugadorDos.getNombre().equals("Roberto")  && jugadorDos.getColor().equals("Rojo") );

    }

    @Test (expected = ExcepcionElNombreIngresadoRepiteAlDeOtroJugador.class)
    @SuppressWarnings("unused")
    public void alCrearElSegundoJugadorSiElNombreEsIgualAlDelPrimeroEsperoUnaExcepcion()
            throws ExcepcionNoSePudoCrearElJugador {

        CreadorDeJugador creadorDeJugador = new CreadorDeJugador();
        Jugador jugadorUno = null;

        jugadorUno = creadorDeJugador.crearNuevoJugadorProtos("Mariano", "Azul");

        Jugador jugadorDos = null;

        try {
            jugadorDos = creadorDeJugador.crearNuevoJugadorProtos("Mariano", "Rojo");
        } catch (ExcepcionNombreDeJugadorMenorACuatroCaracteres excepcionNombreDeJugadorMenorACuatroCaracteres) {
            excepcionNombreDeJugadorMenorACuatroCaracteres.printStackTrace();
        }

    }

    @Test (expected = ExcepcionElColorIngresadoRepiteAlDeOtroJugador.class)
    @SuppressWarnings("unused")
    public void alCrearElSegundoJugadorSiElColorEsIgualAlDelPrimeroEsperoUnaExcepcion()
            throws ExcepcionNoSePudoCrearElJugador{

        CreadorDeJugador creadorDeJugador = new CreadorDeJugador();

        Jugador jugadorUno = creadorDeJugador.crearNuevoJugadorProtos("Mariano", "Azul");
        Jugador jugadorDos = creadorDeJugador.crearNuevoJugadorProtos("Roberto", "Azul");

    }

}
