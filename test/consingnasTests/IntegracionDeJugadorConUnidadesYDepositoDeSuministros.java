package consingnasTests;

import construcciones.terran.Barraca;
import construcciones.terran.Fabrica;
import excepciones.Mapa.ExcepcionNoSePudoAgregarAlMapa;
import excepciones.construicciones.ExcepcionNoSePuedeConstruir;
import excepciones.construicciones.ExcepcionNoSePuedeEntrenarUnidad;
import jugabilidad.Jugador;
import jugabilidad.ProxyMapa;
import jugabilidad.RazaDeJugador.JugadorTerran;
import jugabilidad.auxiliares.Recursos;
import jugabilidad.auxiliares.Suministros;
import jugabilidad.auxiliares.Vision;
import jugabilidad.extrasJuego.CreadorDeMapa;
import jugabilidad.utilidadesMapa.Coordenada;
import org.junit.Before;
import org.junit.Test;
import unidades.terrran.Golliat;
import unidades.terrran.Marine;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class IntegracionDeJugadorConUnidadesYDepositoDeSuministros {

    private void lanzarUpdates(int cantidad, Jugador jugador){

        for (int i = 0; i < cantidad; i++){
            jugador.update();
        }

    }

    @Before
    public void resetProxy(){
        ProxyMapa.resetear();
    }

    /* Al morir una unidad que usa un suministro deberian aumentar los suministros del jugador en uno. */

    @Test
    @SuppressWarnings("unused")
    public void test1() throws ExcepcionNoSePuedeConstruir, ExcepcionNoSePudoAgregarAlMapa, ExcepcionNoSePuedeEntrenarUnidad {

        CreadorDeMapa creador = new CreadorDeMapa(2);

        Vision vision  = Vision.VisionCompleta(25,25);

        Suministros suministros = new Suministros(0,0);
        JugadorTerran jugadorTerran = new JugadorTerran(new Recursos(1000,1000),suministros);
        jugadorTerran.setVisibilidad(vision);

        Coordenada coordenada = new Coordenada(8,18);
        // Suministros 5. Usados 0.
        jugadorTerran.construirDepositoDeSuministros(coordenada);

        // Para que se construya el deposito.
        this.lanzarUpdates(6, jugadorTerran);

        Coordenada coordenada2 = new Coordenada(10,18);
        Barraca barraca = jugadorTerran.construirBarraca(coordenada2);

        // Para que se construya la barraca.
        this.lanzarUpdates(13, jugadorTerran);

        Marine marine = barraca.entrenarMarine();

        // Para que se entrene el marine.
        this.lanzarUpdates(4,jugadorTerran);
        // Suministros 4. Usados 1.
        assertTrue(suministros.getSuministrosUsados() == 1);

        // Tiene 40 de vida se lo saco.
        marine.recibirDanio(40);

        // Para que el jugador se de cuenta que el marine murio.
        jugadorTerran.update();

        assertTrue(suministros.getSuministrosUsados() == 0);

    }

    /* Al morir una unidad que usa dos suministros deberian aumentar los suministros del jugador en dos. */

    @Test
    @SuppressWarnings("unused")
    public void test2() throws ExcepcionNoSePuedeConstruir, ExcepcionNoSePudoAgregarAlMapa, ExcepcionNoSePuedeEntrenarUnidad {

        CreadorDeMapa creador = new CreadorDeMapa(2);
        ProxyMapa proxyMapa = creador.obtenerProxyMapa();

        Vision vision  = Vision.VisionCompleta(25,25);

        Suministros suministros = new Suministros(0,0);
        JugadorTerran jugadorTerran = new JugadorTerran(new Recursos(1000,1000),suministros);
        jugadorTerran.setVisibilidad(vision);

        Coordenada coordenada = new Coordenada(8,18);
        jugadorTerran.construirDepositoDeSuministros(coordenada);

        // Para que se construya el deposito.
        this.lanzarUpdates(6, jugadorTerran);
        // Suministros 5. Usados 0.

        Coordenada coordenada2 = new Coordenada(10,18);
        Barraca barraca = jugadorTerran.construirBarraca(coordenada2);

        // Para que se construya la barraca.
        this.lanzarUpdates(13, jugadorTerran);

        Coordenada coordenada3 = new Coordenada(17,17);
        Fabrica fabrica = jugadorTerran.construirFabrica(coordenada3);

        // Para que se construya la fabrica.
        this.lanzarUpdates(12, jugadorTerran);

        Golliat goliat = fabrica.entrenarGolliat();

        // Para que se entrene el goliat.
        this.lanzarUpdates(6,jugadorTerran);
        // Suministros 3. Usados 2.
        assertTrue(suministros.getSuministrosUsados() == 2);

        // Tiene 125 de vida se lo saco.
        goliat.recibirDanio(125);

        // Para que el jugador se de cuenta que el marine murio.
        jugadorTerran.update();

        assertTrue(suministros.getSuministrosUsados() == 0);

    }

    /* Test de creacion de unidades, con chequeo de suministros. */

    @Test
    @SuppressWarnings("unused")
    public void test4() throws ExcepcionNoSePuedeConstruir, ExcepcionNoSePudoAgregarAlMapa, ExcepcionNoSePuedeEntrenarUnidad {

        CreadorDeMapa creador = new CreadorDeMapa(2);
        ProxyMapa proxyMapa = creador.obtenerProxyMapa();

        Vision vision  = Vision.VisionCompleta(25,25);

        Suministros suministros = new Suministros(0,0);
        JugadorTerran jugadorTerran = new JugadorTerran(new Recursos(1000,1000),suministros);
        jugadorTerran.setVisibilidad(vision);

        Coordenada coordenada = new Coordenada(8,18);
        // Suministros 5. Usados 0.
        jugadorTerran.construirDepositoDeSuministros(coordenada);

        // Para que se construya el deposito.
        this.lanzarUpdates(6, jugadorTerran);

        Coordenada coordenada2 = new Coordenada(10,18);
        Barraca barraca = jugadorTerran.construirBarraca(coordenada2);

        // Para que se construya la barraca.
        this.lanzarUpdates(13, jugadorTerran);

        Marine marineUno =  barraca.entrenarMarine();

        // Para que se entrene el marine.
        this.lanzarUpdates(4,jugadorTerran);
        // Suministros 5. Usados 1.
        assertTrue(suministros.getSuministrosUsados() == 1);
        assertTrue(jugadorTerran.buscarUnidad(marineUno));

        Marine marineDos = barraca.entrenarMarine();

        // Para que se entrene el marine.
        this.lanzarUpdates(4,jugadorTerran);
        // Suministros 5. Usados 2.
        assertTrue(suministros.getSuministrosUsados() == 2);
        assertTrue(jugadorTerran.buscarUnidad(marineDos));

        Marine marineTres = barraca.entrenarMarine();

        // Para que se entrene el marine.
        this.lanzarUpdates(4,jugadorTerran);
        // Suministros 5. Usados 3.
        assertTrue(suministros.getSuministrosUsados() == 3);
        assertTrue(jugadorTerran.buscarUnidad(marineTres));

    }

    /* Si envio tres unidades a crearse a la vez se deben crear de a una a la vez. */

    @Test
    @SuppressWarnings("unused")
    public void test5() throws ExcepcionNoSePuedeConstruir, ExcepcionNoSePudoAgregarAlMapa, ExcepcionNoSePuedeEntrenarUnidad {

        CreadorDeMapa creador = new CreadorDeMapa(2);
        ProxyMapa proxyMapa = creador.obtenerProxyMapa();

        Vision vision  = Vision.VisionCompleta(25,25);

        Suministros suministros = new Suministros(0,0);
        JugadorTerran jugadorTerran = new JugadorTerran(new Recursos(1000,1000),suministros);
        jugadorTerran.setVisibilidad(vision);

        Coordenada coordenada = new Coordenada(8,18);
        // Suministros 5. Usados 0.
        jugadorTerran.construirDepositoDeSuministros(coordenada);

        // Para que se construya el deposito.
        this.lanzarUpdates(6, jugadorTerran);

        Coordenada coordenada2 = new Coordenada(10,18);
        Barraca barraca = jugadorTerran.construirBarraca(coordenada2);

        // Para que se construya la barraca.
        this.lanzarUpdates(13, jugadorTerran);

        Marine marineUno =  barraca.entrenarMarine();
        Marine marineDos = barraca.entrenarMarine();
        Marine marineTres = barraca.entrenarMarine();

        // Para que se entrene el marine.
        this.lanzarUpdates(4,jugadorTerran);
        // Suministros 5. Usados 3. Solo un marine encontrado.
        assertTrue(suministros.getSuministrosUsados() == 3);
        assertTrue(jugadorTerran.buscarUnidad(marineUno));
        assertFalse(jugadorTerran.buscarUnidad(marineDos));
        assertFalse(jugadorTerran.buscarUnidad(marineTres));

        // Para que se entrene el marine.
        this.lanzarUpdates(4,jugadorTerran);
        // Suministros 5. Usados 3. Dos marines encontrados.
        assertTrue(suministros.getSuministrosUsados() == 3);
        assertTrue(jugadorTerran.buscarUnidad(marineUno));
        assertTrue(jugadorTerran.buscarUnidad(marineDos));
        assertFalse(jugadorTerran.buscarUnidad(marineTres));

        // Para que se entrene el marine.
        this.lanzarUpdates(4,jugadorTerran);
        // Suministros 5. Usados 3. Tres marines encontrados.
        assertTrue(suministros.getSuministrosUsados() == 3);
        assertTrue(jugadorTerran.buscarUnidad(marineUno));
        assertTrue(jugadorTerran.buscarUnidad(marineDos));
        assertTrue(jugadorTerran.buscarUnidad(marineTres));

    }

    @Test (expected = ExcepcionNoSePuedeConstruir.class)
    @SuppressWarnings("unused")
    public void seIntentaCrearUnaBarracaFueraDelRangoDeVisionEsperoUnaExcepcio() throws ExcepcionNoSePuedeConstruir, ExcepcionNoSePudoAgregarAlMapa {
        JugadorTerran jugador = new JugadorTerran(new Recursos(1000, 100));
        Vision vision = new Vision();
        vision.agregarSectorVisible(new Coordenada(4, 4), 3);
        jugador.setVisibilidad(vision);
        ProxyMapa proxy = ProxyMapa.getInstance();

        Coordenada coordenada = new Coordenada(10, 10);

        jugador.construirBarraca(coordenada);

    }

}
