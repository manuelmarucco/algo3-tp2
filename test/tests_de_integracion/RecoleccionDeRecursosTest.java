package tests_de_integracion;

import construcciones.terran.CentroDeMineral;
import construcciones.terran.Refineria;
import excepciones.Mapa.ExcepcionNoSePudoAgregarAlMapa;
import excepciones.construicciones.ExcepcionNoSePuedeConstruir;
import jugabilidad.Juego;
import jugabilidad.Jugador;
import jugabilidad.ProxyMapa;
import jugabilidad.RazaDeJugador.JugadorProtoss;
import jugabilidad.RazaDeJugador.JugadorTerran;
import jugabilidad.auxiliares.Recursos;
import jugabilidad.utilidadesMapa.Coordenadas;
import org.junit.Before;
import org.junit.Test;
import recursos.Cristal;
import recursos.Volcan;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class RecoleccionDeRecursosTest {

    ProxyMapa proxyMapa;
    @Before
    public void resetearProxy(){
        ProxyMapa.resetear();

        proxyMapa = ProxyMapa.getInstance();
        proxyMapa.setCoordenadasMaximas(20,20);
    }

    @Test
    public void integracionDelCentroDeMineralConElCristalEnUnMapa() throws ExcepcionNoSePudoAgregarAlMapa {

        Recursos recursos = new Recursos(0,0);

        Coordenadas coordenadas = new Coordenadas(1,1);
        Cristal cristal = new Cristal();
        CentroDeMineral centroDeMineral = new CentroDeMineral(recursos);

        proxyMapa.agregar(cristal,coordenadas);
        proxyMapa.agregar(centroDeMineral,coordenadas);

        assertEquals( 10,centroDeMineral.obtenerRecurso() );

    }
    
        @Test
    public void cuandoUbicoUnaRefineriaSobreUnVolcanMeDeberiaDevolverDiezMinerales() throws ExcepcionNoSePudoAgregarAlMapa {

        Recursos recursos = new Recursos(0,0);
        Coordenadas coordenadas = new Coordenadas(1,2);
        Volcan volcan = new Volcan();
        Refineria refineria = new Refineria(recursos);

        proxyMapa.agregar(volcan,coordenadas);
        proxyMapa.agregar(refineria,coordenadas);

        assertEquals( 10,refineria.obtenerRecurso() );
    }

    // Correcta de Recursos.

    private void lanzarUpdates(int cantidad, Jugador jugador){

        for (int i = 1; i <= cantidad; i++){
            jugador.update();
        }

    }

    @Test
         public void verificacionDeRecoleccionDeCristalesTerran() throws ExcepcionNoSePuedeConstruir, ExcepcionNoSePudoAgregarAlMapa {

        Juego juego = new Juego();
        juego.crearMapa();
        // Crea un cristal en 3 , 23
        // Crea un volcan en 5 , 21
        ArrayList<Coordenadas> bases = juego.getBases();
        JugadorTerran jugador = (JugadorTerran) juego.crearJugadorTerran("Jugado", "Azul", bases.get(0));

        Coordenadas coordenadas = new Coordenadas(3,23);
        jugador.construirCentroDeMineral(coordenadas);

        // Construyo el centroDeMineral.
        this.lanzarUpdates(4,jugador);
        // Cuando se termina de construir comienza a sumar.

        // Corro 3 updates se tienen que sumar 30 cristales.
        this.lanzarUpdates(3,jugador);
        // Como en el juego, el jugador inica con 200. El Centro gasta 50. Mas 30. Tengo 180.

        assertEquals(190, jugador.getRecursos().getMinerales());

    }

    @Test
    public void verificacionDeRecoleccionDeGasTerran() throws ExcepcionNoSePuedeConstruir, ExcepcionNoSePudoAgregarAlMapa {

        Juego juego = new Juego();
        juego.crearMapa();
        // Crea un cristal en 3 , 23
        // Crea un volcan en 5 , 21
        ArrayList<Coordenadas> bases = juego.getBases();
        JugadorTerran jugador = (JugadorTerran) juego.crearJugadorTerran("Jugado", "Azul", bases.get(0));

        Coordenadas coordenadas = new Coordenadas(5,21);
        jugador.construirRefineria(coordenadas);

        assertEquals(0, jugador.getRecursos().getGasVespeno());

        // Construyo la Refineria.
        this.lanzarUpdates(6,jugador);
        // Cuando se termina de construir comienza a sumar.

        // Corro 3 updates se tienen que sumar 30 Gas.
        this.lanzarUpdates(3,jugador);

        assertEquals(40, jugador.getRecursos().getGasVespeno());

    }

    @Test
    public void verificacionDeRecoleccionDeCristalesProtoss() throws ExcepcionNoSePuedeConstruir, ExcepcionNoSePudoAgregarAlMapa {

        Juego juego = new Juego();
        juego.crearMapa();
        // Crea un cristal en 3 , 23
        // Crea un volcan en 5 , 21
        ArrayList<Coordenadas> bases = juego.getBases();
        JugadorProtoss jugador = (JugadorProtoss) juego.crearJugadorProtoss("Jugado", "Azul", bases.get(0));

        Coordenadas coordenadas = new Coordenadas(3,23);
        jugador.construirNexoMineral(coordenadas);

        // Construyo el centroDeMineral.
        this.lanzarUpdates(4,jugador);
        // Cuando se termina de construir comienza a sumar.

        // Corro 3 updates se tienen que sumar 30 cristales.
        this.lanzarUpdates(3,jugador);
        // Como en el juego, el jugador inica con 200. El Centro gasta 50. Se termina de construir suma 10 .Mas 30.
        // Tengo 190.

        assertEquals(190, jugador.getRecursos().getMinerales());

    }

    @Test
    public void verificacionDeRecoleccionDeGasProtoss() throws ExcepcionNoSePuedeConstruir, ExcepcionNoSePudoAgregarAlMapa {

        Juego juego = new Juego();
        juego.crearMapa();
        // Crea un cristal en 3 , 23
        // Crea un volcan en 5 , 21
        ArrayList<Coordenadas> bases = juego.getBases();
        JugadorProtoss jugador = (JugadorProtoss) juego.crearJugadorProtoss("Jugado", "Azul", bases.get(0));

        Coordenadas coordenadas = new Coordenadas(5,21);
        jugador.construirAsimilador(coordenadas);

        assertEquals(0, jugador.getRecursos().getGasVespeno());

        // Construyo la Refineria.
        this.lanzarUpdates(6,jugador);
        // Cuando se termina de construir comienza a sumar.

        // Corro 3 updates se tienen que sumar 30 Gas.
        this.lanzarUpdates(3,jugador);

        assertEquals(40, jugador.getRecursos().getGasVespeno());

    }

}
