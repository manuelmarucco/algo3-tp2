package vista.unidades;

import unidades.protoss.AltoTemplario;
import vista.Actions.MouseActionObtenerInfoAltoTemplario;
import vista.auxiliares.ImagePanel;
import vista.ventanaJugadores.VentanaJugador;

import javax.swing.*;

public class VistaAltoTemplario extends ImagePanel{
    private static final int ANCHO = 1;
    private static final int ALTO = 2;
    private final AltoTemplario unidad;
    private final VentanaJugador ventanaJugador;

    public VistaAltoTemplario(AltoTemplario altoTemplario,VentanaJugador ventanaJugador) {
        super(ANCHO,ALTO,new ImageIcon().getImage());
        this.unidad=altoTemplario;
        this.ventanaJugador=ventanaJugador;
        this.addMouseListener(new MouseActionObtenerInfoAltoTemplario(unidad,ventanaJugador));
    }
}
