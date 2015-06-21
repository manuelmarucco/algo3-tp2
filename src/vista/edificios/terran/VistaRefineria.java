package vista.edificios.terran;

import construcciones.terran.Refineria;
import vista.auxiliares.ImagePanel;
import vista.ventanaJugadores.VentanaJugador;

import javax.swing.*;

public class VistaRefineria extends ImagePanel{

    private static final int ANCHO = 1;
    private static final int ALTO = 2;
    private final Refineria edificio;
    private final VentanaJugador ventanaJugador;

    public VistaRefineria(Refineria refineria, VentanaJugador ventanaJugador) {
        super(ANCHO,ALTO,new ImageIcon().getImage());
        this.edificio=refineria;
        this.ventanaJugador=ventanaJugador;
    }

}