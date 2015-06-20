package vista.edificios.terran;

import construcciones.terran.CentroDeMineral;
import vista.auxiliares.ImagePanel;
import vista.ventanaJugadores.VentanaJugador;

import javax.swing.*;

public class VistaCentroDeMinerales extends ImagePanel{

    private static final int ANCHO = 1;
    private static final int ALTO = 2;
    private final CentroDeMineral edificio;
    private final VentanaJugador ventanaJugador;

    public VistaCentroDeMinerales(CentroDeMineral centroDeMineral, VentanaJugador ventanaJugador) {
        super(ANCHO,ALTO,new ImageIcon().getImage());
        this.edificio=centroDeMineral;
        this.ventanaJugador=ventanaJugador;
    }

}
