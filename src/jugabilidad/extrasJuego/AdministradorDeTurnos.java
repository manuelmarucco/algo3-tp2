package jugabilidad.extrasJuego;

import interfaces.Actualizable;
import jugabilidad.Jugador;

import java.util.ArrayList;

public class AdministradorDeTurnos implements Actualizable{
    private Jugador jugadorDelTurnoActual;
    private ArrayList<Jugador> jugadores = new ArrayList<>();
    private int iterador;

    public AdministradorDeTurnos(){

        iterador = 0;
    }

    @Override
    public void update() {
        if(iterador == jugadores.size()) iterador=0;
        jugadorDelTurnoActual = jugadores.get(iterador);
        jugadorDelTurnoActual.update();
        iterador++;
    }

    public Jugador getJugadorDelTurnoActual(){
        if(jugadorDelTurnoActual == null) {
            this.update();
        }
        return jugadorDelTurnoActual;
    }

    public void agregarJugador(Jugador j) {
        jugadores.add(j);
    }

    public boolean hayGanador() {
        this.removerJugadoresQuePerdieron();
        if(jugadores.size()==1){
            return true;
        }else
            return false;
    }

    private void removerJugadoresQuePerdieron() {
        Jugador j;
        for(int i = 0; i < jugadores.size(); i++){
            j = jugadores.get(i);
            if(j.noTieneMasConstruccionesYUnidades()){
                jugadores.remove(j);
            }
        }
    }

    public Jugador getGanador(){
        return jugadores.get(0);
    }
}
