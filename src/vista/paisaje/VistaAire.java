package vista.paisaje;

import vista.auxiliares.ImagePanel;
import vista.ventanaJugadores.VentanaJugador;

import javax.swing.*;

public class VistaAire extends ImagePanel {

    private static final int ANCHO = 64;
    private static final int ALTO = 64;
    private final VentanaJugador ventanaJugador;

    @SuppressWarnings("unused")
    public VistaAire(Object parametroFantasma, VentanaJugador ventanaJugador) {

        super(ANCHO,ALTO,new ImageIcon("src/vista/paisaje/imagenes/aire.png").getImage());
        this.ventanaJugador=ventanaJugador;
        this.setVisible(false);

    }

}
