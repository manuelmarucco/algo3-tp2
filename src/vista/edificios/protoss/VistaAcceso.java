package vista.edificios.protoss;

import construcciones.protoss.Acceso;
import vista.auxiliares.ImagePanel;
import vista.ventanaJugadores.VentanaJugador;

import javax.swing.*;

public class VistaAcceso extends ImagePanel {

    private static final int ANCHO = 1;
    private static final int ALTO = 2;
    private final Acceso edificio;
    private final VentanaJugador ventanaJugador;

    public VistaAcceso(Acceso acceso,VentanaJugador ventanaJugador) {
        super(ANCHO,ALTO,new ImageIcon().getImage());
        this.edificio=acceso;
        this.ventanaJugador=ventanaJugador;
    }
}
