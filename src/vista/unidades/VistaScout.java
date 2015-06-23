package vista.unidades;

import unidades.protoss.Scout;
import vista.auxiliares.ImagePanel;
import vista.ventanaJugadores.VentanaJugador;

import javax.swing.*;

public class VistaScout extends ImagePanel {

    private static final int ANCHO = 1;
    private static final int ALTO = 2;
    private final Scout unidad;
    private final VentanaJugador ventanaJugador;

    public VistaScout(Scout scout,VentanaJugador ventanaJugador) {
        super(ANCHO,ALTO,new ImageIcon().getImage());
        this.unidad=scout;
        this.ventanaJugador=ventanaJugador;
    }
}
