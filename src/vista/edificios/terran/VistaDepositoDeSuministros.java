package vista.edificios.terran;

import construcciones.CentroDeSuministros;
import interfaces.ColocableEnMapa;
import vista.auxiliares.ImagePanel;
import vista.ventanaJugadores.VentanaJugador;

import javax.swing.*;

public class VistaDepositoDeSuministros extends ImagePanel{

    private static final int ANCHO = 1;
    private static final int ALTO = 2;
    private final CentroDeSuministros edificio;
    private final VentanaJugador ventanaJugador;

    public VistaDepositoDeSuministros(ColocableEnMapa centroDeSuministros,VentanaJugador ventanaJugador) {
        super(ANCHO,ALTO,new ImageIcon().getImage());
        this.edificio= (CentroDeSuministros) centroDeSuministros;
        this.ventanaJugador=ventanaJugador;
    }

}
