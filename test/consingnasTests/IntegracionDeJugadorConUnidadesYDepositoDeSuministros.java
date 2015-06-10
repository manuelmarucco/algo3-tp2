package consingnasTests;

import excepciones.Mapa.ExcepcionNoSePudoAgregarAlMapa;
import excepciones.Mapa.ExcepcionPosicionOcupada;
import excepciones.construicciones.ExcepcionNoSePuedeConstruir;
import jugabilidad.Jugador;
import jugabilidad.ProxyMapa;
import jugabilidad.RazaDeJugador.JugadorTerran;
import jugabilidad.auxiliares.Recursos;
import jugabilidad.auxiliares.Suministros;
import jugabilidad.auxiliares.Vision;
import jugabilidad.extrasJuego.CreadorDeMapa;
import jugabilidad.utilidadesMapa.Coordenadas;
import static org.junit.Assert.*;
import org.junit.Test;
import unidades.terrran.Marine;

public class IntegracionDeJugadorConUnidadesYDepositoDeSuministros {

    private void lanzarUpdates(int cantidad, Jugador jugador){

        for (int i = 0; i < cantidad; i++){
            jugador.update();
        }

    }

    /* Al morir una unidad deberian disminuir los suministros del jugador en uno. */
    @Test
    public void test1() throws ExcepcionNoSePuedeConstruir, ExcepcionPosicionOcupada {

        CreadorDeMapa creadorDeMapa = new CreadorDeMapa();
        ProxyMapa proxyMapa = creadorDeMapa.crearMapa();
        Vision vision  = new Vision();

        Suministros suministros = new Suministros(0,0);
        JugadorTerran jugadorTerran = new JugadorTerran(new Recursos(1000,1000),suministros);
        jugadorTerran.setVisibilidad(vision);

        Coordenadas coordenadas = new Coordenadas(8,18);
        // Suministros 5.
        jugadorTerran.construirDepositoDeSuministros(coordenadas);

        // Para que se construya el deposito.
        this.lanzarUpdates(6, jugadorTerran);

        Marine marine = new Marine(vision);
        jugadorTerran.agregarUnidad(marine);

        Coordenadas coordenadas2 = new Coordenadas(10,18);
        try {
            proxyMapa.agregar(marine, coordenadas2);
        } catch (ExcepcionNoSePudoAgregarAlMapa e) {
            e.printStackTrace();
        }

        // Para que se entrene el marine.
        this.lanzarUpdates(3,jugadorTerran);

        // Suministros 4.

        // Tiene 40 de vida se lo saco.
        marine.recibirDanio(40);

        // Para que el jugador se de cuenta que el marine murio.
        jugadorTerran.update();

        assertTrue(suministros.getSuministrosUsados() == 0);

    }

}
