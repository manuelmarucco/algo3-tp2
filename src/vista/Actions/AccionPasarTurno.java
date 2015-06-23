package vista.Actions;

import vista.VentanaJuego;

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

    }
}
