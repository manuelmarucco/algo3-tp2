package tests_de_integracion;

import construcciones.protoss.Asimilador;
import construcciones.protoss.NexoMineral;
import construcciones.terran.CentroDeMineral;
import construcciones.terran.Refineria;
import excepciones.Mapa.ExcepcionNoSePudoAgregarAlMapa;
import excepciones.construicciones.ExcepcionNoSePuedeConstruir;
import jugabilidad.Juego;
import jugabilidad.Jugador;
import jugabilidad.ProxyMapa;
import jugabilidad.RazaDeJugador.JugadorProtoss;
import jugabilidad.RazaDeJugador.JugadorTerran;
import jugabilidad.utilidadesMapa.Coordenada;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class ConstruccionesParaRecoleccionDeRecursosEnRecursosCorrectos {

    ProxyMapa proxyMapa;
    @Before
    public void resetearProxy(){
        ProxyMapa.resetear();
    }

    private void lanzarUpdates(int cantidad, Jugador jugador){

        for (int i = 1; i <= cantidad; i++){
            jugador.update();
        }

    }

    // Verificacion de recurso apropiado en la construccion de edificio recolector. Tests positivos

    @Test
    public void construirCentroDeMineralSobreCristal() throws ExcepcionNoSePuedeConstruir, ExcepcionNoSePudoAgregarAlMapa {

        Juego juego = new Juego(2);
        // Crea un cristal en 3 , 23
        JugadorTerran jugador = juego.crearJugadorTerran("Jugado","Azul");

        Coordenada coordenada = new Coordenada(3,23);
        CentroDeMineral centroDeMineral = jugador.construirCentroDeMineral(coordenada);

        this.lanzarUpdates(4,jugador);

        assertTrue(jugador.buscarConstruccion(centroDeMineral));

    }

    @Test
    public void construirNexoMineralSobreCristal() throws ExcepcionNoSePuedeConstruir, ExcepcionNoSePudoAgregarAlMapa {

        Juego juego = new Juego(2);
        // Crea un cristal en 3 , 23
        JugadorProtoss jugador = juego.crearJugadorProtoss("Jugado", "Azul");

        Coordenada coordenada = new Coordenada(3,23);
        NexoMineral nexoMineral = jugador.construirNexoMineral(coordenada);

        this.lanzarUpdates(4,jugador);

        assertTrue(jugador.buscarConstruccion(nexoMineral));


    }

    @Test
    public void construirAsimiladorSobreVolcan() throws ExcepcionNoSePuedeConstruir, ExcepcionNoSePudoAgregarAlMapa {

        Juego juego = new Juego(2);
        // Crea un volcan en 5 , 21
        JugadorProtoss jugador = juego.crearJugadorProtoss("Jugado", "Azul");

        Coordenada coordenada = new Coordenada(5,21);
        Asimilador asimilador = jugador.construirAsimilador(coordenada);

        this.lanzarUpdates(6,jugador);

        assertTrue(jugador.buscarConstruccion(asimilador));

    }

    @Test
    public void construirRefineriaAsimiladorSobreVolcan() throws ExcepcionNoSePuedeConstruir, ExcepcionNoSePudoAgregarAlMapa {

        Juego juego = new Juego(2);
        // Crea un volcan en 5 , 21
        JugadorTerran jugador = juego.crearJugadorTerran("Jugado", "Azul");

        Coordenada coordenada = new Coordenada(5,21);
        Refineria refineria = jugador.construirRefineria(coordenada);

        this.lanzarUpdates(6,jugador);

        assertTrue(jugador.buscarConstruccion(refineria));

    }

    // Verificacion de recurso apropiado en la construccion de edificio recolector. Tests negativos

    @Test(expected = ExcepcionNoSePuedeConstruir.class)
    public void siIntentoColocarUnaRefineriaSobreUnCristalEsperoUnaExcepcion() throws ExcepcionNoSePuedeConstruir, ExcepcionNoSePudoAgregarAlMapa {

        Juego juego = new Juego(2);
        // Crea un cristal en 3 , 23
        JugadorTerran jugador = juego.crearJugadorTerran("Jugado","Azul");

        Coordenada coordenada = new Coordenada(3,23);
        jugador.construirRefineria(coordenada);

    }

    @Test (expected = ExcepcionNoSePuedeConstruir.class)
    public void siIntentoColocarUnaAsimiladorSobreUnCristalEsperoUnaExcepcion() throws ExcepcionNoSePuedeConstruir, ExcepcionNoSePudoAgregarAlMapa {

        Juego juego = new Juego(2);
        // Crea un cristal en 3 , 23
        JugadorProtoss jugador = juego.crearJugadorProtoss("Jugado", "Azul");

        Coordenada coordenada = new Coordenada(3,23);
        jugador.construirAsimilador(coordenada);

    }

    @Test (expected = ExcepcionNoSePuedeConstruir.class)
    public void siIntentoColocarUnaNexoDeMineralSobreUnVolcanEsperoUnaExcepcion() throws ExcepcionNoSePuedeConstruir, ExcepcionNoSePudoAgregarAlMapa {

        Juego juego = new Juego(2);
        // Crea un volcan en 5 , 21
        JugadorProtoss jugador = juego.crearJugadorProtoss("Jugado", "Azul");

        Coordenada coordenada = new Coordenada(5,21);
        jugador.construirNexoMineral(coordenada);

    }

    @Test (expected = ExcepcionNoSePuedeConstruir.class)
    public void siIntentoColocarUnaCentroDeMineralSobreUnVolcanEsperoUnaExcepcion() throws ExcepcionNoSePuedeConstruir, ExcepcionNoSePudoAgregarAlMapa {

        Juego juego = new Juego(2);
        // Crea un volcan en 5 , 21
        JugadorTerran jugador = juego.crearJugadorTerran("Jugado", "Azul");

        Coordenada coordenada = new Coordenada(5,21);
        jugador.construirCentroDeMineral(coordenada);

    }
}
