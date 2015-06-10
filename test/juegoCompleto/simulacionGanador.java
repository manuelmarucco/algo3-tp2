package juegoCompleto;

import construcciones.Construccion;
import construcciones.protoss.Acceso;
import construcciones.protoss.Pilon;
import excepciones.*;
import jugabilidad.ProxyMapa;
import jugabilidad.RazaDeJugador.JugadorProtoss;
import jugabilidad.RazaDeJugador.JugadorTerran;
import jugabilidad.extrasJuego.CreadorDeMapa;
import jugabilidad.extrasJuego.Juego;
import jugabilidad.utilidadesMapa.Coordenadas;
import org.junit.Test;
import unidades.ProxiDeAtaque;
import unidades.protoss.Zealot;

public class simulacionGanador {
    @Test
    public void Jugador1MataTodoDeJugador2YGana() throws ExcepcionNoSePuedeConstruir, ExcepcionNoSePudoAgregarAlMapa, ExcepcionObjetivoFueraDeRango, ExcepcionYaActuo, ExcepcionAtacarAUnidadAliada, ExcepcionMoverfueraDeRango, ExcepcionYaSeMovioLaUnidad {
        Juego juego = new Juego();
        JugadorProtoss j1;
        JugadorTerran j2;
        ProxyMapa mapa = ProxyMapa.getInstance();

        new CreadorDeMapa().crearMapa();
        Construccion c1,c3;
        Acceso c2;
        Zealot d;

        j1 = (JugadorProtoss) juego.crearJugadorProtoss("manuel","rojo");
        j2 = (JugadorTerran) juego.crearJugadorTerran("jorge", "azul");
        ProxiDeAtaque.inicializar(j1,j2);
        c1 =j1.construirNexoMineral(new Coordenadas(2, 19));
        for(int i = 0; i<c1.getTiempoDeConstruccion()*2; i++ ) {
            juego.update();
        }
        for(int i = 0; i<22; i++ ) {
            juego.update();
        }
        c2 = j1.construirAcceso(new Coordenadas(0,1));
        for(int i = 0; i<(+c2.getTiempoDeConstruccion())*2; i++ ) juego.update();

        Pilon c4 = j1.construirPilon(new Coordenadas(0, 2));
        for(int i = 0; i<(+c4.getTiempoDeConstruccion())*2; i++ ) juego.update();

        c3 = j2.construirDepositoDeSuministros(new Coordenadas(1,1));
        for(int i = 0; i<c3.getTiempoDeConstruccion()*2; i++ ) juego.update();

        d = c2.entrenarZealot();
        int tiempo = d.getTiempoDeEntrenamiento()*2;
        for(int i = 0; i<tiempo; i++){
            juego.update();
        }
        d.mover(new Coordenadas(1,2));
        while (c3.getVida()!=0) d.atacarTierra(c3);
        //Assert.assertEquals();

    }
}
