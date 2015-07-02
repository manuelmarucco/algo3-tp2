package vista.paisaje;

import control.BufferImagenes;
import modelo.interfaces.ColocableEnMapa;
import vista.IVista;
import vista.auxiliares.ImagePanel;
import vista.ventanaJugadores.VentanaJugador;

import javax.swing.*;
import java.awt.*;

public class VistaNullPosicionTerrestre extends ImagePanel implements IVista {

    private static final int ANCHO = 64;
    private static final int ALTO = 64;
    private static final BufferImagenes BUFFERIMAGENES = BufferImagenes.getInstance();
    private final VentanaJugador ventanaJugador;

    public VistaNullPosicionTerrestre(ColocableEnMapa parametroFantasma,VentanaJugador ventanaJugador) {
        super(ANCHO,ALTO,BUFFERIMAGENES.obtenerImagen("Rocas").getImage());
        this.ventanaJugador=ventanaJugador;
    }

    @Override
    public void actualizarBotonera() {
        ventanaJugador.getPanelAcciones().limpiar();
    }

    @Override
    public void actualizarPanelEstado() {
        ventanaJugador.borrarPanelDeEstadoAnterior();

    }
}
