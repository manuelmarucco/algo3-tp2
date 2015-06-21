package juegoCompleto;

import construcciones.Construccion;
import construcciones.protoss.Acceso;
import construcciones.protoss.Pilon;
import excepciones.Mapa.ExcepcionNoSePudoAgregarAlMapa;
import excepciones.Unidades.*;
import excepciones.construicciones.ExcepcionNoSePuedeConstruir;
import jugabilidad.Juego;
import jugabilidad.ProxyMapa;
import jugabilidad.RazaDeJugador.JugadorProtoss;
import jugabilidad.RazaDeJugador.JugadorTerran;
import jugabilidad.auxiliares.Vision;
import jugabilidad.extrasJuego.CreadorDeMapa;
import jugabilidad.utilidadesMapa.Coordenadas;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import unidades.ProxiDeAtaque;
import unidades.protoss.Zealot;

import java.util.ArrayList;

public class simulacionGanador {

    @Before
    public void resetProxy(){
        ProxyMapa.resetear();
    }


    @Test
    public void Jugador1MataTodoDeJugador2YGana() throws ExcepcionNoSePuedeConstruir, ExcepcionNoSePudoAgregarAlMapa, ExcepcionObjetivoFueraDeRango, ExcepcionYaActuo, ExcepcionAtacarAUnidadAliada, ExcepcionMoverfueraDeRango, ExcepcionYaSeMovioLaUnidad {
        Juego juego = new Juego();
        JugadorProtoss j1;
        JugadorTerran j2;

        CreadorDeMapa creador = new CreadorDeMapa(2);

        ArrayList<Coordenadas> bases = creador.obtenerCoordenadasDeLasBases();

        Construccion c1,c3;
        Acceso c2;
        Zealot d;

        j1 = (JugadorProtoss) juego.crearJugadorProtoss("manuel","rojo", bases.get(0));
        j2 = (JugadorTerran) juego.crearJugadorTerran("jorge", "azul",bases.get(1));


        j1.setVisibilidad(Vision.VisionCompleta(25,25));
        j2.setVisibilidad(Vision.VisionCompleta(25,25));

        ProxiDeAtaque.inicializar(j1, j2);

        c1 =j1.construirNexoMineral(new Coordenadas(3, 23)); //hay un cristal en 3,23 por defecto
        for(int i = 0; i<c1.getTiempoDeConstruccion()*2; i++ ) {
            juego.update();
        }

        for(int i = 0; i<30; i++ ) { //para que recolecte minerales
            juego.update();
        }

        c2 = j1.construirAcceso(new Coordenadas(10, 23));
        for(int i = 0; i<c2.getTiempoDeConstruccion()*2; i++ ) juego.update();

        Pilon c4 = j1.construirPilon(new Coordenadas(7, 24));
        for(int i = 0; i<c4.getTiempoDeConstruccion()*2; i++ ) juego.update();

        c3 = j2.construirDepositoDeSuministros(new Coordenadas(10,24));
        for(int i = 0; i<c3.getTiempoDeConstruccion()*2; i++ ) juego.update();

        d = c2.entrenarZealot();
        int tiempo = d.getTiempoDeEntrenamiento();
        for(int i = 0; i<tiempo*2; i++){
            juego.update();
        }
        d.mover(new Coordenadas(9,24));
        while (c3.getVida()!=0) {
            d.atacarTierra(c3);
            juego.update();
            juego.update();

        }

        Assert.assertEquals(j1, juego.ganador());

    }

    @Test
    public void JugadorNoPierdePorTenerEdificiosEnConstruccion() throws ExcepcionNoSePuedeConstruir, ExcepcionNoSePudoAgregarAlMapa, ExcepcionObjetivoFueraDeRango, ExcepcionYaActuo, ExcepcionAtacarAUnidadAliada, ExcepcionMoverfueraDeRango, ExcepcionYaSeMovioLaUnidad {
        Juego juego = new Juego();
        JugadorProtoss j1;
        JugadorTerran j2;

        CreadorDeMapa creador = new CreadorDeMapa(2);
        ArrayList<Coordenadas> bases = creador.obtenerCoordenadasDeLasBases();

        Construccion c1,c3;
        Acceso c2;
        Zealot d;

        j1 = (JugadorProtoss) juego.crearJugadorProtoss("manuel","rojo", bases.get(0));
        j2 = (JugadorTerran) juego.crearJugadorTerran("jorge", "azul",bases.get(1));


        j1.setVisibilidad(Vision.VisionCompleta(25,25));
        j2.setVisibilidad(Vision.VisionCompleta(25,25));

        ProxiDeAtaque.inicializar(j1, j2);

        c1 =j1.construirNexoMineral(new Coordenadas(3, 23)); //hay un cristal en 3,23 por defecto
        for(int i = 0; i<c1.getTiempoDeConstruccion()*2; i++ ) {
            juego.update();
        }

        for(int i = 0; i<30; i++ ) { //para que recolecte minerales
            juego.update();
        }

        c2 = j1.construirAcceso(new Coordenadas(10, 23));
        for(int i = 0; i<c2.getTiempoDeConstruccion()*2; i++ ) juego.update();

        Pilon c4 = j1.construirPilon(new Coordenadas(7, 24));
        for(int i = 0; i<c4.getTiempoDeConstruccion()*2; i++ ) juego.update();

        c3 = j2.construirDepositoDeSuministros(new Coordenadas(10,24));
        for(int i = 0; i<c3.getTiempoDeConstruccion()*2; i++ ) juego.update();

        d = c2.entrenarZealot();
        int tiempo = d.getTiempoDeEntrenamiento();
        for(int i = 0; i<tiempo*2; i++){ //Un turno equivale a que el jugador retome el control ( 2 subturnos)
            juego.update();
        }
        d.mover(new Coordenadas(9,24));
        while (c3.getVida()!=0) {
            d.atacarTierra(c3);
            juego.update();
            juego.update();

        }

        j2.construirDepositoDeSuministros(new Coordenadas(11,24)); //edificio en Construccion

        Assert.assertEquals(null, juego.ganador());

    }


}
