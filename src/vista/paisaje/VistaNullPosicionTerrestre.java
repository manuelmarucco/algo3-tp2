package vista.paisaje;

import vista.auxiliares.ImagePanel;
import vista.ventanaJugadores.VentanaJugador;

import javax.swing.*;

public class VistaNullPosicionTerrestre extends ImagePanel {

    private static final int ANCHO = 64;
    private static final int ALTO = 64;
    private final VentanaJugador ventanaJugador;

    public VistaNullPosicionTerrestre() {
        super(ANCHO,ALTO,new ImageIcon("src/vista/paisaje/imagenes/rocas.png").getImage());
        this.ventanaJugador=null;
    }

    public VistaNullPosicionTerrestre(VentanaJugador ventanaJugador) {
        super(ANCHO,ALTO,new ImageIcon("src/vista/paisaje/imagenes/rocas.png").getImage());
        this.ventanaJugador=ventanaJugador;
    }

}
