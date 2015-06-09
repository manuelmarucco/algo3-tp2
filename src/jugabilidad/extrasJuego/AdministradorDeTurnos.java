package jugabilidad.extrasJuego;

import interfaces.Actualizable;

import java.util.ArrayList;

public class AdministradorDeTurnos implements Actualizable{
    private Actualizable jugadorDelTurnoActual;
    private ArrayList<Actualizable> jugadores = new ArrayList<>();
    private int iterador;

    public AdministradorDeTurnos(){
        iterador = 0;
    }
    @Override
    public void update() {
        jugadorDelTurnoActual = jugadores.get(iterador);
        jugadorDelTurnoActual.update();

        if(iterador == jugadores.size()) iterador=0;
        else iterador++;
    }

    public Actualizable getJugadorDelTurnoActual(){
        return jugadorDelTurnoActual;
    }

    public void agregarJugador(Actualizable j) {
        jugadores.add(j);
    }
}
