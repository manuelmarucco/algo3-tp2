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
    CreadorDeMapa creadorDeMapa = new CreadorDeMapa();
    ArrayList<Coordenadas> bases;

    // Metodos

    public Jugador getJugador(){
       return administradorDeTurnos.getJugadorDelTurnoActual();
    }

    public Jugador crearJugadorProtoss(String nombre, String color){

        CreadorDeJugador creadorDeJugador = new CreadorDeJugador();
        JugadorProtoss jugador;

        try {
            jugador = creadorDeJugador.crearNuevoJugadorProtos(nombre,color);
        } catch (ExcepcionNoSePudoCrearElJugador e) {
            e.printStackTrace();
            return null;
        }

        administradorDeTurnos.agregarJugador(jugador);
        return jugador;
    }

    public Jugador crearJugadorTerran(String nombre, String color){

        CreadorDeJugador creadorDeJugador = new CreadorDeJugador();
        JugadorTerran jugador;

        try {
            jugador = creadorDeJugador.crearNuevoJugadorTerran(nombre, color);
        } catch (ExcepcionNoSePudoCrearElJugador e) {
            e.printStackTrace();
            return null;
        }

        administradorDeTurnos.agregarJugador(jugador);
        return jugador;
    }
/*
    // No terminado.
    public ProxyMapa crearMapa(){

        ProxyMapa proxyMapa = this.creadorDeMapa.crearMapa();

        this.bases = creadorDeMapa.obtenerCoordenadasDeLasBases();

        return (proxyMapa);

    }
*/
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
