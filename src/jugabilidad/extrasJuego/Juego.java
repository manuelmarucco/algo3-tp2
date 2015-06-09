package jugabilidad.extrasJuego;

import interfaces.Actualizable;

public class Juego {
    AdministradorDeTurnos administradorDeTurnos;

    public Actualizable getJugador(){
       return administradorDeTurnos.getJugadorDelTurnoActual();
    }
}
