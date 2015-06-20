package vista.edificios.protoss;

import construcciones.protoss.NexoMineral;
import vista.auxiliares.ImagePanel;
import vista.ventanaJugadores.VentanaJugador;

import javax.swing.*;

public class VistaNexoMineral extends ImagePanel{

    private static final int ANCHO = 1;
    private static final int ALTO = 2;
    private final NexoMineral edificio;
    private final VentanaJugador ventanaJugador;

    public VistaNexoMineral(NexoMineral nexoMineral, VentanaJugador ventanaJugador) {
        super(ANCHO,ALTO,new ImageIcon().getImage());
        this.edificio=nexoMineral;
        this.ventanaJugador=ventanaJugador;
    }

}
