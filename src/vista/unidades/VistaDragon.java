package vista.unidades;

import interfaces.ColocableEnMapa;
import unidades.protoss.Dragon;
import vista.Actions.MouseActionObtenerInfoDragon;
import vista.auxiliares.ImagePanel;
import vista.ventanaJugadores.VentanaJugador;

import javax.swing.*;

public class VistaDragon extends ImagePanel {
    private static final int ANCHO = 1;
    private static final int ALTO = 2;
    private final Dragon unidad;
    private final VentanaJugador ventanaJugador;

    public VistaDragon(ColocableEnMapa dragon,VentanaJugador ventanaJugador) {
        super(ANCHO, ALTO, new ImageIcon().getImage());
        super.setBackground(new ImageIcon("src/vista/paisaje/imagenes/pasto.png").getImage());
        this.unidad=(Dragon)dragon;
        this.ventanaJugador=ventanaJugador;
        this.addMouseListener(new MouseActionObtenerInfoDragon(unidad,ventanaJugador));
    }

}
