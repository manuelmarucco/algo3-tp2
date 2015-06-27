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
import jugabilidad.utilidadesMapa.Coordenada;
import org.junit.Before;
import org.junit.Test;
import recursos.Cristal;
import recursos.Volcan;

import static org.junit.Assert.assertEquals;

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

        Coordenada coordenada = new Coordenada(1,1);
        Cristal cristal = new Cristal();
        CentroDeMineral centroDeMineral = new CentroDeMineral(recursos);

        proxyMapa.agregar(cristal, coordenada);
        proxyMapa.agregar(centroDeMineral, coordenada);

        assertEquals( 10,centroDeMineral.obtenerRecurso() );

    }
    
        @Test
    public void cuandoUbicoUnaRefineriaSobreUnVolcanMeDeberiaDevolverDiezMinerales() throws ExcepcionNoSePudoAgregarAlMapa {

        Recursos recursos = new Recursos(0,0);
        Coordenada coordenada = new Coordenada(1,2);
        Volcan volcan = new Volcan();
        Refineria refineria = new Refineria(recursos);

        proxyMapa.agregar(volcan, coordenada);
        proxyMapa.agregar(refineria, coordenada);

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

        Juego juego = new Juego(2);
        // Crea un cristal en 3 , 23
        // Crea un volcan en 5 , 21
        JugadorTerran jugador = (JugadorTerran) juego.crearJugadorTerran("Jugado", "Azul");

        Coordenada coordenada = new Coordenada(3,23);
        int mineralesIniciales = jugador.getRecursos().getMinerales();
        jugador.construirCentroDeMineral(coordenada); //gasto 50 minerales en construirla

        // Construyo el centroDeMineral.
        this.lanzarUpdates(4,jugador); //se contruye y recoelcta 10
        // Cuando se termina de construir comienza a sumar.

        // Corro 3 updates se tienen que sumar 30 cristales.
        this.lanzarUpdates(3,jugador);

        assertEquals(mineralesIniciales-50+10+30, jugador.getRecursos().getMinerales());

    }

    @Test
    public void verificacionDeRecoleccionDeGasTerran() throws ExcepcionNoSePuedeConstruir, ExcepcionNoSePudoAgregarAlMapa {

        Juego juego = new Juego(2);
        // Crea un cristal en 3 , 23
        // Crea un volcan en 5 , 21
        JugadorTerran jugador = juego.crearJugadorTerran("Jugado", "Azul");

        Coordenada coordenada = new Coordenada(5,21);
        jugador.construirRefineria(coordenada);

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

        Juego juego = new Juego(2);
        // Crea un cristal en 3 , 23
        // Crea un volcan en 5 , 21
        JugadorProtoss jugador = juego.crearJugadorProtoss("Jugado", "Azul");

        Coordenada coordenada = new Coordenada(3,23);
        int mineralesIniciales = jugador.getRecursos().getMinerales();
        jugador.construirNexoMineral(coordenada); //gasto 50 minerales

        // Construyo el centroDeMineral.
        this.lanzarUpdates(4,jugador);  //se construye y recolecta 1 turno osea 10 minerales
        // Cuando se termina de construir comienza a sumar.

        // Corro 3 updates se tienen que sumar 30 cristales.
        this.lanzarUpdates(3,jugador); //recoelcta 3 veces osea 30 minerales

        assertEquals(mineralesIniciales-50+10+30, jugador.getRecursos().getMinerales());

    }

    @Test
    public void verificacionDeRecoleccionDeGasProtoss() throws ExcepcionNoSePuedeConstruir, ExcepcionNoSePudoAgregarAlMapa {

        Juego juego = new Juego(2);
        // Crea un cristal en 3 , 23
        // Crea un volcan en 5 , 21
        JugadorProtoss jugador = juego.crearJugadorProtoss("Jugado", "Azul");

        Coordenada coordenada = new Coordenada(5,21);
        jugador.construirAsimilador(coordenada);

        assertEquals(0, jugador.getRecursos().getGasVespeno());

        // Construyo la Refineria.
        this.lanzarUpdates(6,jugador);
        // Cuando se termina de construir comienza a sumar.

        // Corro 3 updates se tienen que sumar 30 Gas.
        this.lanzarUpdates(3,jugador);

        assertEquals(40, jugador.getRecursos().getGasVespeno());

    }

}
