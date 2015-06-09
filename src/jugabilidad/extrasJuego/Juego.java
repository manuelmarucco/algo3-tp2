package jugabilidad.extrasJuego;

import excepciones.ExcepcionNoSePudoCrearElJugador;
import interfaces.Actualizable;
import jugabilidad.Jugador;
import jugabilidad.RazaDeJugador.JugadorProtoss;
import jugabilidad.RazaDeJugador.JugadorTerran;


public class Juego implements Actualizable{

    AdministradorDeTurnos administradorDeTurnos = new AdministradorDeTurnos();

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

    @Override
    public void update() {
        administradorDeTurnos.update();
    }

}
