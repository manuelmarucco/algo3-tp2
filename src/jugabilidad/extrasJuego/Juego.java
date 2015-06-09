package jugabilidad.extrasJuego;

import excepciones.ExcepcionNoSePudoCrearElJugador;
import interfaces.Actualizable;
import jugabilidad.Jugador;
import jugabilidad.RazaDeJugador.JugadorProtoss;
import jugabilidad.RazaDeJugador.JugadorTerran;


public class Juego implements Actualizable{

    AdministradorDeTurnos administradorDeTurnos;

    public Jugador getJugador(){
       return administradorDeTurnos.getJugadorDelTurnoActual();
    }

    public void crearJugadorProtoss(String nombre, String color){

        CreadorDeJugador creadorDeJugador = new CreadorDeJugador();
        JugadorProtoss jugador = null;

        try {
            jugador = creadorDeJugador.crearNuevoJugadorProtos(nombre,color);
        } catch (ExcepcionNoSePudoCrearElJugador e) {
            e.printStackTrace();
        }

        administradorDeTurnos.agregarJugador(jugador);
    }

    public void crearJugadorTerran(String nombre, String color){

        CreadorDeJugador creadorDeJugador = new CreadorDeJugador();
        JugadorTerran jugador = null;

        try {
            jugador = creadorDeJugador.crearNuevoJugadorTerran(nombre, color);
        } catch (ExcepcionNoSePudoCrearElJugador e) {
            e.printStackTrace();
        }

        administradorDeTurnos.agregarJugador(jugador);
    }

    @Override
    public void update() {
        administradorDeTurnos.update();
    }

}
