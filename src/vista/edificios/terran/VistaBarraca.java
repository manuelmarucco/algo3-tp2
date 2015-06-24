package vista.edificios.terran;

import construcciones.terran.Barraca;
import vista.auxiliares.ImagePanel;
import vista.ventanaJugadores.VentanaJugador;

import javax.swing.*;

public class VistaBarraca extends ImagePanel {

    private static final int ANCHO = 1;
    private static final int ALTO = 2;
    private final Barraca edificio;
    private final VentanaJugador ventanaJugador;

    public VistaBarraca(Barraca barraca,VentanaJugador ventanaJugador) {
        super(ANCHO,ALTO,new ImageIcon().getImage());
        this.edificio=barraca;
        this.ventanaJugador=ventanaJugador;
    }
}
