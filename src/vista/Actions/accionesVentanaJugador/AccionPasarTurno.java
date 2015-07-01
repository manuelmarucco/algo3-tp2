package vista.Actions.accionesVentanaJugador;

import control.ObservadorDeExcepciones;
import control.vistaMapa.ObservadorMapa;
import jugabilidad.Jugador;
import vista.VentanaJuego;
import vista.ventanaJugadores.ObservadorEstado;
import vista.ventanaJugadores.ObservadorRecursosSuministros;
import vista.ventanaJugadores.VentanaGanador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AccionPasarTurno implements ActionListener {
    private VentanaJuego ventanaJuego;

    public AccionPasarTurno(VentanaJuego ventanaJuego) {
        this.ventanaJuego = ventanaJuego;
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        ventanaJuego.pasarTurno();
        Jugador ganador = ventanaJuego.getJuego().getJugadorGanador();
        if(ganador!= null){
            new VentanaGanador(ventanaJuego,ganador.getNombre());
        }
        ventanaJuego.getVentanaJugadorActual().revalidate(); //actualiza la ventana del jugador
        ObservadorDeExcepciones.getInstance().borrarDisplay();
        ObservadorEstado.getInstance().informarCambios();
        ObservadorRecursosSuministros.getInstance().informarCambios();
        ObservadorMapa.getInstance().informarCambios();

    }
}
