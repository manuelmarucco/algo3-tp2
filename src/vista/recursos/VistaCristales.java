package vista.recursos;

import control.BufferImagenes;
import modelo.interfaces.ColocableEnMapa;
import modelo.recursos.Cristal;
import vista.IVista;
import vista.auxiliares.ImagePanel;
import vista.ventanaJugadores.VentanaJugador;

import javax.swing.*;
import java.awt.*;

public class VistaCristales extends ImagePanel implements IVista {

    private static final int ANCHO = 64;
    private static final int ALTO = 64;
    private static final BufferImagenes BUFFERIMAGENES = BufferImagenes.getInstance();
    private final Cristal recurso;
    private final VentanaJugador ventanaJugador;

    public VistaCristales(ColocableEnMapa cristal,VentanaJugador ventanaJugador) {
        super(ANCHO,ALTO,BUFFERIMAGENES.obtenerImagen("Cristal").getImage().getScaledInstance(ANCHO, ALTO, Image.SCALE_FAST) );
        this.recurso=(Cristal)cristal;
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
