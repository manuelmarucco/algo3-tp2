package control.Actions.accionesMenu;

import vista.CrearJugador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ActionCerrarCreador implements ActionListener {
    private final CrearJugador crearJugador;

    public ActionCerrarCreador(CrearJugador crearJugador) {
        this.crearJugador = crearJugador;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        this.crearJugador.dispose();
    }
}
