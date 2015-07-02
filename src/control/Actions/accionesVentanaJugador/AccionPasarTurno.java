package control.Actions.accionesVentanaJugador;

import control.ObservadorDeExcepciones;
import control.vistaMapa.ObservadorMapa;
import vista.VentanaJuego;
import vista.auxiliares.jugador.observadores.ObservadorEstado;
import vista.auxiliares.jugador.observadores.ObservadorRecursosSuministros;

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

        ventanaJuego.getVentanaJugadorActual().revalidate();
        ObservadorDeExcepciones.getInstance().borrarDisplay();
        ObservadorEstado.getInstance().informarCambios();
        ObservadorRecursosSuministros.getInstance().informarCambios();
        ObservadorMapa.getInstance().informarCambios();

    }
}
