package vista.unidades;

import unidades.protoss.Zealot;
import vista.auxiliares.ImagePanel;
import vista.ventanaJugadores.VentanaJugador;

import javax.swing.*;

public class VistaZealot extends ImagePanel{

    private static final int ANCHO = 1;
    private static final int ALTO = 2;
    private final Zealot unidad;
    private final VentanaJugador ventanaJugador;

    public VistaZealot(Zealot zealot,VentanaJugador ventanaJugador) {
        super(ANCHO,ALTO,new ImageIcon().getImage());
        super.setBackground(new ImageIcon("src/vista/paisaje/imagenes/pasto.png").getImage());
        this.unidad=zealot;
        this.ventanaJugador=ventanaJugador;
    }
}
