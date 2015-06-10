package jugabilidad_tests;

import excepciones.jugador.ExcepcionNoSePudoCrearElJugador;
import excepciones.jugador.ExcepcionElColorIngresadoRepiteAlDeOtroJugador;
import excepciones.jugador.ExcepcionElNombreIngresadoRepiteAlDeOtroJugador;
import excepciones.jugador.ExcepcionNombreDeJugadorMenorACuatroCaracteres;

import jugabilidad.Jugador;
import jugabilidad.extrasJuego.CreadorDeJugador;

import jugabilidad.utilidadesMapa.Coordenadas;
import org.junit.Test;
import static org.junit.Assert.*;

public class CreadorDeJugadorTest {

    @Test
    public void alCrearUnJugadorTerranSeDeberianVerificarElNombreYColorAsignados()
            throws ExcepcionNoSePudoCrearElJugador {

        CreadorDeJugador creadorDeJugador = new CreadorDeJugador();
        Coordenadas base = new Coordenadas(5,5);

        Jugador jugador = creadorDeJugador.crearNuevoJugadorTerran("Mariano", "Azul",base);

        assertTrue(jugador.getNombre().equals("Mariano")  && jugador.getColor().equals("Azul") );

    }

    @Test
    public void alCrearUnJugadorProtosSeDeberianVerificarElNombreYColorAsignados()
            throws ExcepcionNoSePudoCrearElJugador{

        CreadorDeJugador creadorDeJugador = new CreadorDeJugador();
        Coordenadas base = new Coordenadas(5,5);

        Jugador jugador = creadorDeJugador.crearNuevoJugadorProtos("Mariano", "Azul", base);

        assertTrue(jugador.getNombre().equals("Mariano")  && jugador.getColor().equals("Azul") );

    }

    @Test (expected = ExcepcionNombreDeJugadorMenorACuatroCaracteres.class)
    public void alCrearseUnJugadorSiSuNombreTieneMenosDeCuatroCaracteresEsperoUnaExcepcion()
            throws ExcepcionNoSePudoCrearElJugador{

        CreadorDeJugador creadorDeJugador = new CreadorDeJugador();
        Coordenadas base = new Coordenadas(5,5);

        Jugador jugador = creadorDeJugador.crearNuevoJugadorProtos("Mar", "Azul",base);

    }

    @Test
    @SuppressWarnings("unused")
    public void alCrearElSegundoJugadorSiElNombreYElColorNoSonIgualesAlDelPrimeroDeberianVerificarse()
            throws ExcepcionNoSePudoCrearElJugador{

        CreadorDeJugador creadorDeJugador = new CreadorDeJugador();
        Coordenadas baseUno = new Coordenadas(5,5);
        Coordenadas baseDos = new Coordenadas(10,10);

        Jugador jugadorUno = creadorDeJugador.crearNuevoJugadorProtos("Mariano", "Azul",baseUno);
        Jugador jugadorDos = creadorDeJugador.crearNuevoJugadorProtos("Roberto", "Rojo",baseDos);

        assertTrue(jugadorDos.getNombre().equals("Roberto")  && jugadorDos.getColor().equals("Rojo") );

    }

    @Test (expected = ExcepcionElNombreIngresadoRepiteAlDeOtroJugador.class)
    @SuppressWarnings("unused")
    public void alCrearElSegundoJugadorSiElNombreEsIgualAlDelPrimeroEsperoUnaExcepcion()
            throws ExcepcionNoSePudoCrearElJugador {

        CreadorDeJugador creadorDeJugador = new CreadorDeJugador();
        Coordenadas baseUno = new Coordenadas(5,5);
        Coordenadas baseDos = new Coordenadas(10,10);

        Jugador jugadorUno = creadorDeJugador.crearNuevoJugadorProtos("Mariano", "Azul",baseUno);
        Jugador jugadorDos = creadorDeJugador.crearNuevoJugadorProtos("Mariano", "Rojo",baseDos);

    }

    @Test (expected = ExcepcionElColorIngresadoRepiteAlDeOtroJugador.class)
    @SuppressWarnings("unused")
    public void alCrearElSegundoJugadorSiElColorEsIgualAlDelPrimeroEsperoUnaExcepcion()
            throws ExcepcionNoSePudoCrearElJugador{

        CreadorDeJugador creadorDeJugador = new CreadorDeJugador();
        Coordenadas baseUno = new Coordenadas(5,5);
        Coordenadas baseDos = new Coordenadas(10,10);

        Jugador jugadorUno = creadorDeJugador.crearNuevoJugadorProtos("Mariano", "Azul", baseUno);
        Jugador jugadorDos = creadorDeJugador.crearNuevoJugadorProtos("Roberto", "Azul", baseDos);

    }

    @Test
    public void alCrearUnJugadorTerranSeDeberiaVerificarLaBaseAsignada()
            throws ExcepcionNoSePudoCrearElJugador {

        CreadorDeJugador creadorDeJugador = new CreadorDeJugador();
        Coordenadas base = new Coordenadas(5,5);

        Jugador jugador = creadorDeJugador.crearNuevoJugadorTerran("Mariano", "Azul",base);

        assertTrue( jugador.getVisibilidad().esVisible(base) );

    }


}
