package vista.paisaje;

import interfaces.ColocableEnMapa;
import vista.auxiliares.ImagePanel;
import vista.ventanaJugadores.VentanaJugador;

import javax.swing.*;

public class VistaPasto extends ImagePanel {

    private static final int ANCHO = 64;
    private static final int ALTO = 64;
    private final VentanaJugador ventanaJugador;

    @SuppressWarnings("unused")
    public VistaPasto(ColocableEnMapa parametroFantasma, VentanaJugador ventanaJugador) {

        super(ANCHO,ALTO,new ImageIcon("src/vista/paisaje/imagenes/pasto.png").getImage());
        this.ventanaJugador=ventanaJugador;

    }

}
