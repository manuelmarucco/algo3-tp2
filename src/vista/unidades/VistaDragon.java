package vista.unidades;

import unidades.protoss.Dragon;
import vista.Actions.MouseActionObtenerInfoAltoTemplario;
import vista.Actions.MouseActionObtenerInfoDragon;
import vista.auxiliares.ImagePanel;
import vista.ventanaJugadores.VentanaJugador;

import javax.swing.*;

public class VistaDragon extends ImagePanel {
    private static final int ANCHO = 1;
    private static final int ALTO = 2;
    private final Dragon unidad;
    private final VentanaJugador ventanaJugador;

    public VistaDragon(Dragon dragon,VentanaJugador ventanaJugador) {
        super(ANCHO,ALTO,new ImageIcon().getImage());
        this.unidad=dragon;
        this.ventanaJugador=ventanaJugador;
        this.addMouseListener(new MouseActionObtenerInfoDragon(unidad,ventanaJugador));
    }

}
