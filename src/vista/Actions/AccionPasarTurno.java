package vista.Actions;

import control.ObservadorDeExcepciones;
import control.vistaMapa.ObservadorMapa;
import vista.VentanaJuego;
import vista.ventanaJugadores.ObservadorEstado;
import vista.ventanaJugadores.ObservadorRecursosSuministros;

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
        ObservadorDeExcepciones.getInstance().borrarDisplay();
        ObservadorEstado.getInstance().informarCambios();
        ObservadorRecursosSuministros.getInstance().informarCambios();
        ObservadorMapa.getInstance().informarCambios();

    }
}
