package vista.paisaje;

import control.BufferImagenes;
import modelo.interfaces.ColocableEnMapa;
import vista.IVista;
import vista.auxiliares.ImagePanel;
import vista.ventanaJugadores.VentanaJugador;

import javax.swing.*;
import java.awt.*;

public class VistaAire extends ImagePanel implements IVista {

    private static final int ANCHO = 64;
    private static final int ALTO = 64;
    private static final BufferImagenes BUFFERIMAGENES = BufferImagenes.getInstance();
    private final VentanaJugador ventanaJugador;

    @SuppressWarnings("unused")
    public VistaAire(ColocableEnMapa parametroFantasma, VentanaJugador ventanaJugador) {

        super(ANCHO,ALTO,BUFFERIMAGENES.obtenerImagen("Aire").getImage());
        this.ventanaJugador=ventanaJugador;
        this.setVisible(false);

    }

    @Override
    public void actualizarBotonera() {
        ventanaJugador.getPanelAcciones().limpiar();
    }

    @Override
    public void actualizarPanelEstado() {

    }
}
