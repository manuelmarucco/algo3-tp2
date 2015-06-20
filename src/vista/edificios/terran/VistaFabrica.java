package vista.edificios.terran;

import construcciones.terran.Fabrica;
import vista.auxiliares.ImagePanel;
import vista.ventanaJugadores.VentanaJugador;

import javax.swing.*;

public class VistaFabrica extends ImagePanel{

    private static final int ANCHO = 1;
    private static final int ALTO = 2;
    private final Fabrica edificio;
    private final VentanaJugador ventanaJugador;

    public VistaFabrica(Fabrica fabrica, VentanaJugador ventanaJugador) {
        super(ANCHO,ALTO,new ImageIcon().getImage());
        this.edificio=fabrica;
        this.ventanaJugador=ventanaJugador;
    }

}
