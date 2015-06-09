package juegoCompleto;

import construcciones.Construccion;
import construcciones.protoss.Acceso;
import excepciones.*;
import jugabilidad.ProxyMapa;
import jugabilidad.RazaDeJugador.JugadorProtoss;
import jugabilidad.RazaDeJugador.JugadorTerran;
import jugabilidad.extrasJuego.Juego;
import jugabilidad.utilidadesMapa.Coordenadas;
import org.junit.Test;
import unidades.protoss.Dragon;

public class simulacionGanador {
    @Test
    public void Jugador1MataTodoDeJugador2YGana() throws ExcepcionNoSePuedeConstruir, ExcepcionPosicionOcupada, ExcepcionObjetivoFueraDeRango, ExcepcionYaActuo, ExcepcionAtacarAUnidadAliada {
        Juego juego = new Juego();
        JugadorProtoss j1;
        JugadorTerran j2;
        ProxyMapa mapa = ProxyMapa.getInstance();
        Construccion c1,c3;
        Acceso c2;
        Dragon d;

        j1 = (JugadorProtoss) juego.crearJugadorProtoss("manuel","rojo");
        j2 = (JugadorTerran) juego.crearJugadorTerran("jorge","azul");

        c1 =j1.construirPilon(new Coordenadas(0,0));
        c2 = j1.construirAcceso(new Coordenadas(0,1));
        for(int i = 0; i<(c1.getTiempoDeConstruccion()+c2.getTiempoDeConstruccion()); i++ ) juego.update();

        c3 = j2.construirDepositoDeSuministros(new Coordenadas(1,1));
        for(int i = 0; i<c3.getTiempoDeConstruccion(); i++ ) juego.update();

        d = c2.entrenarDragon();
        int tiempo = d.getTiempoDeEntrenamiento();
        for(int i = 0; i<tiempo; i++)   juego.update();

        while (c3.getVida()!=0) d.atacarTierra(c3);
        //Assert.assertEquals();

    }
}
