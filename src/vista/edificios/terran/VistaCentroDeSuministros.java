package vista.edificios.terran;

import construcciones.CentroDeSuministros;
import vista.auxiliares.ImagePanel;

import javax.swing.*;

public class VistaCentroDeSuministros extends ImagePanel{

    private static final int ANCHO = 1;
    private static final int ALTO = 2;
    private final CentroDeSuministros edificio;

    public VistaCentroDeSuministros(CentroDeSuministros centroDeSuministros/*TODO aca se pasa el panel del juego*/) {
        super(ANCHO,ALTO,new ImageIcon().getImage());
        this.edificio=centroDeSuministros;
    }

}
