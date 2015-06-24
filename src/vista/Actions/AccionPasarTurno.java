package vista.Actions;

import control.ObservadorDeExcepciones;
import vista.VentanaJuego;
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

        ObservadorDeExcepciones.getInstance().borrarDisplay();
        ventanaJuego.pasarTurno();
        ObservadorRecursosSuministros.getInstance().informarCambios();

    }
}
