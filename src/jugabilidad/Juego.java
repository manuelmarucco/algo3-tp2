package jugabilidad;

import excepciones.jugador.ExcepcionNoSePudoCrearElJugador;
import interfaces.Actualizable;
import jugabilidad.RazaDeJugador.JugadorProtoss;
import jugabilidad.RazaDeJugador.JugadorTerran;
import jugabilidad.extrasJuego.AdministradorDeTurnos;
import jugabilidad.extrasJuego.CreadorDeJugador;
import jugabilidad.extrasJuego.CreadorDeMapa;
import jugabilidad.utilidadesMapa.Coordenadas;

import java.util.ArrayList;


public class Juego implements Actualizable{

    AdministradorDeTurnos administradorDeTurnos = new AdministradorDeTurnos();
    CreadorDeMapa creadorDeMapa = new CreadorDeMapa( 2 );
    ArrayList<Coordenadas> bases;

    // Metodos

    public Jugador getJugadorActual(){
       return administradorDeTurnos.getJugadorDelTurnoActual();
    }

    public JugadorProtoss crearJugadorProtoss(String nombre, String color, Coordenadas base){

        CreadorDeJugador creadorDeJugador = new CreadorDeJugador();
        JugadorProtoss jugador;

        try {
            jugador = creadorDeJugador.crearNuevoJugadorProtos(nombre,color,base);
        } catch (ExcepcionNoSePudoCrearElJugador e) {
            e.printStackTrace();
            return null;
        }

        administradorDeTurnos.agregarJugador(jugador);
        return jugador;
    }

    public JugadorTerran crearJugadorTerran(String nombre, String color, Coordenadas base){

        CreadorDeJugador creadorDeJugador = new CreadorDeJugador();
        JugadorTerran jugador;

        try {
            jugador = creadorDeJugador.crearNuevoJugadorTerran(nombre, color, base);
        } catch (ExcepcionNoSePudoCrearElJugador e) {
            e.printStackTrace();
            return null;
        }

        administradorDeTurnos.agregarJugador(jugador);
        return jugador;
    }

    public ArrayList<Coordenadas> getBases(){
        return (this.bases);
    }

    public ProxyMapa crearMapa(){

        CreadorDeMapa creadorDeMapa = new CreadorDeMapa(2);

        ProxyMapa proxyMapa = creadorDeMapa.obtenerProxyMapa();

        this.bases = creadorDeMapa.obtenerCoordenadasDeLasBases();

        return (proxyMapa);

    }

    @Override
    public void update() {
        administradorDeTurnos.update();

    }

    public Jugador ganador(){
        if(administradorDeTurnos.hayGanador()){
            return administradorDeTurnos.getGanador();
        }else
            return null;
    }

}
