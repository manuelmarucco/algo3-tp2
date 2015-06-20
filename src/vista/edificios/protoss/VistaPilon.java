package vista.edificios.protoss;

import construcciones.protoss.Pilon;
import vista.auxiliares.ImagePanel;
import vista.ventanaJugadores.VentanaJugador;

import javax.swing.*;

public class VistaPilon extends ImagePanel{

    private static final int ANCHO = 1;
    private static final int ALTO = 2;
    private final Pilon edificio;
    private final VentanaJugador ventanaJugador;

    public VistaPilon(Pilon pilon, VentanaJugador ventanaJugador) {
        super(ANCHO,ALTO,new ImageIcon().getImage());
        this.edificio=pilon;
        this.ventanaJugador=ventanaJugador;
    }

}
