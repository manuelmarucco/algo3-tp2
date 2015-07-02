package vista.recursos;

import control.BufferImagenes;
import modelo.interfaces.ColocableEnMapa;
import modelo.recursos.Volcan;
import vista.IVista;
import vista.auxiliares.ImagePanel;
import vista.ventanaJugadores.VentanaJugador;

import javax.swing.*;
import java.awt.*;

public class VistaVolcan extends ImagePanel implements IVista {

    private static final int ANCHO = 64;
    private static final int ALTO = 64;
    private static final BufferImagenes BUFFERIMAGENES = BufferImagenes.getInstance();
    private final Volcan recurso;
    private final VentanaJugador ventanaJugador;


    public VistaVolcan(ColocableEnMapa volcan,VentanaJugador ventanaJugador) {
        super(ANCHO,ALTO, BUFFERIMAGENES.obtenerImagen("Volcan").getImage().getScaledInstance(ANCHO, ALTO, Image.SCALE_FAST) );
        this.recurso=(Volcan)volcan;
        this.ventanaJugador=ventanaJugador;
    }

    @Override
    public void actualizarBotonera() {
        ventanaJugador.getPanelAcciones().configurarBotones(recurso);
    }

    @Override
    public void actualizarPanelEstado() {

    }
}