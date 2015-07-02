package vista.paisaje;

import control.BufferImagenes;
import modelo.interfaces.ColocableEnMapa;
import vista.IVista;
import vista.auxiliares.ImagePanel;
import vista.ventanaJugadores.VentanaJugador;

import javax.swing.*;
import java.awt.*;

public class VistaPasto extends ImagePanel implements IVista {

    private static final int ANCHO = 64;
    private static final int ALTO = 64;
    private static final BufferImagenes BUFFERIMAGENES = BufferImagenes.getInstance();
    private final VentanaJugador ventanaJugador;

    @SuppressWarnings("unused")
    public VistaPasto(ColocableEnMapa parametroFantasma, VentanaJugador ventanaJugador) {

        super(ANCHO,ALTO,BUFFERIMAGENES.obtenerImagen("Pasto").getImage());
        this.ventanaJugador=ventanaJugador;

    }

    @Override
    public void actualizarBotonera() {
        ventanaJugador.getPanelAcciones().limpiar();
    }

    @Override
    public void actualizarPanelEstado() {
        JPanel panelVacio = new JPanel();

        ventanaJugador.borrarPanelDeEstadoAnterior();
        ventanaJugador.mostrarPanelDeEstado(panelVacio);

    }
}
