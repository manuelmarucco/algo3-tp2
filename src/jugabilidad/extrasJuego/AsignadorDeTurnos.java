package jugabilidad.extrasJuego;

import jugabilidad.Jugador;

public class AsignadorDeTurnos {

    private Jugador jugadorUno;
    private Jugador jugadorDos;

    public AsignadorDeTurnos(Jugador jugadorUno, Jugador jugadorDos){

        this.jugadorUno = jugadorUno;

        this.jugadorDos = jugadorDos;

    }

    public Jugador jugadorSiguiente(){

        Jugador jugadorADevolver = this.jugadorUno;

        this.jugadorUno = this.jugadorDos;
        this.jugadorDos =  jugadorADevolver;

        return ( jugadorADevolver );
    }
}
