package vista.edificios.terran;

import construcciones.terran.Barraca;
import vista.auxiliares.ImagePanel;

import javax.swing.*;

public class VistaBarraca extends ImagePanel {

    private static final int ANCHO = 1;
    private static final int ALTO = 2;
    private final Barraca edificio;

    public VistaBarraca(Barraca barraca/*TODO aca se pasa el panel del juego*/) {
        super(ANCHO,ALTO,new ImageIcon().getImage());
        this.edificio=barraca;
    }
}
