package jugabilidad.extrasJuego;

import interfaces.Actualizable;
import jugabilidad.Jugador;


public class Juego implements Actualizable{
    AdministradorDeTurnos administradorDeTurnos;

    public Jugador getJugador(){
       return administradorDeTurnos.getJugadorDelTurnoActual();
    }
/*
    public void crearJugadorProtoss(String nombre, String color){
        JugadorProtoss j = new JugadorProtoss(nombre,color);
         administradorDeTurnos.agregarJugador(j);
    }
*/
    @Override
    public void update() {
        administradorDeTurnos.update();
    }
}
