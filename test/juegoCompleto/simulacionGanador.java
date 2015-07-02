package juegoCompleto;

import modelo.construcciones.Construccion;
import modelo.construcciones.protoss.Acceso;
import modelo.construcciones.protoss.Pilon;
import modelo.excepciones.Mapa.ExcepcionNoSePudoAgregarAlMapa;
import modelo.excepciones.Unidades.ExcepcionDeAccionDeUnidad;
import modelo.excepciones.construcciones.ExcepcionNoSePuedeConstruir;
import modelo.excepciones.construcciones.ExcepcionNoSePuedeEntrenarUnidad;
import modelo.jugabilidad.Juego;
import modelo.jugabilidad.ProxyMapa;
import modelo.jugabilidad.RazaDeJugador.JugadorProtoss;
import modelo.jugabilidad.RazaDeJugador.JugadorTerran;
import modelo.jugabilidad.auxiliares.Vision;
import modelo.jugabilidad.utilidadesMapa.Coordenada;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import modelo.unidades.ProxiDeAtaque;
import modelo.unidades.protoss.Zealot;

public class simulacionGanador {

    @Before
    public void resetProxy(){
        ProxyMapa.resetear();
    }


    @Test
    public void Jugador1MataTodoDeJugador2YGana() throws ExcepcionNoSePuedeConstruir, ExcepcionNoSePudoAgregarAlMapa, ExcepcionDeAccionDeUnidad, ExcepcionNoSePuedeEntrenarUnidad {
        Juego juego = new Juego(2);
        JugadorProtoss j1;
        JugadorTerran j2;

        Construccion c1,depositoDeSuministrosDeJugador2;
        Acceso c2;
        Zealot zealot;

        j1 = juego.crearJugadorProtoss("manuel","rojo");
        j2 = juego.crearJugadorTerran("jorge", "azul");


        j1.setVisibilidad(Vision.VisionCompleta(25,25));
        j2.setVisibilidad(Vision.VisionCompleta(25,25));

        ProxiDeAtaque.inicializar(j1);
        ProxiDeAtaque.inicializar(j2);

        c1 =j1.construirNexoMineral(new Coordenada(3, 23)); //hay un cristal en 3,23 por defecto
        for(int i = 0; i<c1.getTiempoDeConstruccion()*2; i++ ) {
            juego.update();
        }

        for(int i = 0; i<30; i++ ) { //para que recolecte minerales
            juego.update();
        }

        c2 = j1.construirAcceso(new Coordenada(10, 23));
        for(int i = 0; i<c2.getTiempoDeConstruccion()*2; i++ ) juego.update();

        Pilon c4 = j1.construirPilon(new Coordenada(7, 24));
        for(int i = 0; i<c4.getTiempoDeConstruccion()*2; i++ ) juego.update();

        depositoDeSuministrosDeJugador2 = j2.construirDepositoDeSuministros(new Coordenada(10,24));
        for(int i = 0; i<depositoDeSuministrosDeJugador2.getTiempoDeConstruccion()*2; i++ ) juego.update();

        zealot = c2.entrenarZealot();
        int tiempo = zealot.getTiempoDeEntrenamientoActual();
        for(int i = 0; i<tiempo*2; i++){
            juego.update();
        }

        zealot.mover(new Coordenada(9, 24));
        while (depositoDeSuministrosDeJugador2.getVida()!=0) {
            zealot.atacar(new Coordenada(10, 24));
            juego.update();
            juego.update();

        }
        Assert.assertEquals(j1, juego.getJugadorGanador());

    }

    @Test
    public void JugadorNoPierdePorTenerEdificiosEnConstruccion() throws ExcepcionNoSePuedeConstruir, ExcepcionNoSePudoAgregarAlMapa, ExcepcionDeAccionDeUnidad, ExcepcionNoSePuedeEntrenarUnidad {
        Juego juego = new Juego(2);
        JugadorProtoss j1;
        JugadorTerran j2;

        Construccion c1,c3;
        Acceso c2;
        Zealot d;

        j1 = juego.crearJugadorProtoss("manuel","rojo");
        j2 = juego.crearJugadorTerran("jorge", "azul");


        j1.setVisibilidad(Vision.VisionCompleta(25,25));
        j2.setVisibilidad(Vision.VisionCompleta(25,25));

        ProxiDeAtaque.inicializar(j1);
        ProxiDeAtaque.inicializar(j2);

        c1 =j1.construirNexoMineral(new Coordenada(3, 23)); //hay un cristal en 3,23 por defecto
        for(int i = 0; i<c1.getTiempoDeConstruccion()*2; i++ ) {
            juego.update();
        }

        for(int i = 0; i<30; i++ ) { //para que recolecte minerales
            juego.update();
        }

        c2 = j1.construirAcceso(new Coordenada(10, 23));
        for(int i = 0; i<c2.getTiempoDeConstruccion()*2; i++ ) juego.update();

        Pilon c4 = j1.construirPilon(new Coordenada(7, 24));
        for(int i = 0; i<c4.getTiempoDeConstruccion()*2; i++ ) juego.update();

        c3 = j2.construirDepositoDeSuministros(new Coordenada(10,24));
        for(int i = 0; i<c3.getTiempoDeConstruccion()*2; i++ ) juego.update();

        d = c2.entrenarZealot();
        int tiempo = d.getTiempoDeEntrenamientoActual();
        for(int i = 0; i<tiempo*2; i++){ //Un turno equivale a que el jugador retome el control ( 2 subturnos)
            juego.update();
        }
        d.mover(new Coordenada(9,24));
        while (c3.getVida()!=0) {
            d.atacar(new Coordenada(10, 24));
            juego.update();
            juego.update();

        }

        j2.construirDepositoDeSuministros(new Coordenada(11,24)); //edificio en Construccion

        Assert.assertEquals(null, juego.getJugadorGanador());

    }


}
