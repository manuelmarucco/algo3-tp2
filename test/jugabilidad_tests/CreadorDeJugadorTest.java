package jugabilidad_tests;

import modelo.excepciones.jugador.ExcepcionElColorIngresadoRepiteAlDeOtroJugador;
import modelo.excepciones.jugador.ExcepcionElNombreIngresadoRepiteAlDeOtroJugador;
import modelo.excepciones.jugador.ExcepcionNoSePudoCrearElJugador;
import modelo.excepciones.jugador.ExcepcionNombreDeJugadorMenorACuatroCaracteres;
import modelo.jugabilidad.Jugador;
import modelo.jugabilidad.extrasJuego.CreadorDeJugador;
import modelo.jugabilidad.utilidadesMapa.Coordenada;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class CreadorDeJugadorTest {

    @Test
    public void alCrearUnJugadorTerranSeDeberianVerificarElNombreYColorAsignados()
            throws ExcepcionNoSePudoCrearElJugador {

        CreadorDeJugador creadorDeJugador = new CreadorDeJugador();
        Coordenada base = new Coordenada(5,5);

        Jugador jugador = creadorDeJugador.crearNuevoJugadorTerran("Mariano", "Azul",base);

        assertTrue(jugador.getNombre().equals("Mariano")  && jugador.getColor().equals("Azul") );

    }

    @Test
    public void alCrearUnJugadorProtosSeDeberianVerificarElNombreYColorAsignados()
            throws ExcepcionNoSePudoCrearElJugador{

        CreadorDeJugador creadorDeJugador = new CreadorDeJugador();
        Coordenada base = new Coordenada(5,5);

        Jugador jugador = creadorDeJugador.crearNuevoJugadorProtos("Mariano", "Azul", base);

        assertTrue(jugador.getNombre().equals("Mariano")  && jugador.getColor().equals("Azul") );

    }

    @Test (expected = ExcepcionNombreDeJugadorMenorACuatroCaracteres.class)
    public void alCrearseUnJugadorSiSuNombreTieneMenosDeCuatroCaracteresEsperoUnaExcepcion()
            throws ExcepcionNoSePudoCrearElJugador{

        CreadorDeJugador creadorDeJugador = new CreadorDeJugador();
        Coordenada base = new Coordenada(5,5);

        Jugador jugador = creadorDeJugador.crearNuevoJugadorProtos("Mar", "Azul",base);

    }

    @Test (expected = ExcepcionNombreDeJugadorMenorACuatroCaracteres.class)
    public void alCrearseUnJugadorSiSuNombreTieneSoloEspaciosEsperoUnaExcepcion()
            throws ExcepcionNoSePudoCrearElJugador{

        CreadorDeJugador creadorDeJugador = new CreadorDeJugador();
        Coordenada base = new Coordenada(5,5);

        Jugador jugador = creadorDeJugador.crearNuevoJugadorProtos("       ", "Azul",base);

    }

    @Test
    @SuppressWarnings("unused")
    public void alCrearElSegundoJugadorSiElNombreYElColorNoSonIgualesAlDelPrimeroDeberianVerificarse()
            throws ExcepcionNoSePudoCrearElJugador{

        CreadorDeJugador creadorDeJugador = new CreadorDeJugador();
        Coordenada baseUno = new Coordenada(5,5);
        Coordenada baseDos = new Coordenada(10,10);

        Jugador jugadorUno = creadorDeJugador.crearNuevoJugadorProtos("Mariano", "Azul",baseUno);
        Jugador jugadorDos = creadorDeJugador.crearNuevoJugadorProtos("Roberto", "Rojo",baseDos);

        assertTrue(jugadorDos.getNombre().equals("Roberto")  && jugadorDos.getColor().equals("Rojo") );

    }

    @Test (expected = ExcepcionElNombreIngresadoRepiteAlDeOtroJugador.class)
    @SuppressWarnings("unused")
    public void alCrearElSegundoJugadorSiElNombreEsIgualAlDelPrimeroEsperoUnaExcepcion()
            throws ExcepcionNoSePudoCrearElJugador {

        CreadorDeJugador creadorDeJugador = new CreadorDeJugador();
        Coordenada baseUno = new Coordenada(5,5);
        Coordenada baseDos = new Coordenada(10,10);

        Jugador jugadorUno = creadorDeJugador.crearNuevoJugadorProtos("Mariano", "Azul",baseUno);
        Jugador jugadorDos = creadorDeJugador.crearNuevoJugadorProtos("Mariano", "Rojo",baseDos);

    }

    @Test (expected = ExcepcionElColorIngresadoRepiteAlDeOtroJugador.class)
    @SuppressWarnings("unused")
    public void alCrearElSegundoJugadorSiElColorEsIgualAlDelPrimeroEsperoUnaExcepcion()
            throws ExcepcionNoSePudoCrearElJugador{

        CreadorDeJugador creadorDeJugador = new CreadorDeJugador();
        Coordenada baseUno = new Coordenada(5,5);
        Coordenada baseDos = new Coordenada(10,10);

        Jugador jugadorUno = creadorDeJugador.crearNuevoJugadorProtos("Mariano", "Azul", baseUno);
        Jugador jugadorDos = creadorDeJugador.crearNuevoJugadorProtos("Roberto", "Azul", baseDos);

    }

    @Test
    public void alCrearUnJugadorTerranSeDeberiaVerificarLaBaseAsignada()
            throws ExcepcionNoSePudoCrearElJugador {

        CreadorDeJugador creadorDeJugador = new CreadorDeJugador();
        Coordenada base = new Coordenada(5,5);

        Jugador jugador = creadorDeJugador.crearNuevoJugadorTerran("Mariano", "Azul",base);

        assertTrue( jugador.getVisibilidad().esVisible(base) );

    }


}
