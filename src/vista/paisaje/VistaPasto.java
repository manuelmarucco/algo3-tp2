package vista.paisaje;

import vista.auxiliares.ImagePanel;
import vista.ventanaJugadores.VentanaJugador;

import javax.swing.*;

public class VistaPasto extends ImagePanel {

    private static final int ANCHO = 64;
    private static final int ALTO = 64;
    private final VentanaJugador ventanaJugador;

    public VistaPasto() {
        // Solo para testear.
        super(ANCHO,ALTO,new ImageIcon("src/vista/paisaje/imagenes/pasto.png").getImage());
        this.ventanaJugador= null;
    }

    public VistaPasto(VentanaJugador ventanaJugador) {

        super(ANCHO,ALTO,new ImageIcon("src/vista/paisaje/imagenes/pasto.png").getImage());
        this.ventanaJugador=ventanaJugador;

    }

}
