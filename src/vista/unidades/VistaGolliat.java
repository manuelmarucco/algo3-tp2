package vista.unidades;

import interfaces.ColocableEnMapa;
import unidades.terrran.Golliat;
import vista.auxiliares.ImagePanel;
import vista.ventanaJugadores.VentanaJugador;

import javax.swing.*;

public class VistaGolliat extends ImagePanel {

    private static final int ANCHO = 1;
    private static final int ALTO = 2;
    private final Golliat unidad;
    private final VentanaJugador ventanaJugador;

    public VistaGolliat(ColocableEnMapa golliat,VentanaJugador ventanaJugador) {
        super(ANCHO,ALTO,new ImageIcon().getImage());
        super.setBackground(new ImageIcon("src/vista/paisaje/imagenes/pasto.png").getImage());
        this.unidad= (Golliat) golliat;
        this.ventanaJugador=ventanaJugador;
    }

}