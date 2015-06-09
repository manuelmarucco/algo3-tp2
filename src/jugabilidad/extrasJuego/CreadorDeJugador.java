package jugabilidad.extrasJuego;

import jugabilidad.RazaDeJugador.JugadorTerran;
import jugabilidad.auxiliares.Recursos;
import recursos.Recurso;

public class CreadorDeJugador {

    public JugadorTerran crearNuevoJugadorTerran(String nombre, String color){

        Recursos recursos = new Recursos(0,0);
        JugadorTerran jugador = new JugadorTerran(recursos);

        jugador.setNombre(nombre);
        jugador.setColor(color);

        return (jugador);
    }

}
