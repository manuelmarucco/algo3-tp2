package vista.unidades;

import control.BufferImagenes;
import interfaces.ColocableEnMapa;
import unidades.terrran.NaveTransporteTerran;
import vista.IVista;
import vista.auxiliares.ImagePanel;
import vista.ventanaJugadores.VentanaJugador;

import javax.swing.*;
import java.awt.*;

public class VistaNaveTransporteTerran extends ImagePanel implements IVista{

    private static final int ANCHO = 64;
    private static final int ALTO = 64;
    private final NaveTransporteTerran unidad;
    private static final BufferImagenes BUFFERIMAGENES = new BufferImagenes();
    private final VentanaJugador ventanaJugador;

    public VistaNaveTransporteTerran(ColocableEnMapa nave,VentanaJugador ventanaJugador) {

        super(ANCHO, ALTO, BUFFERIMAGENES.obtenerImagen("NaveTransporteTerran").getImage().getScaledInstance(ANCHO, ALTO, Image.SCALE_FAST));
        this.unidad = (NaveTransporteTerran) nave;
        this.ventanaJugador = ventanaJugador;

    }

    @Override
    public void actualizarBotonera() {
        ventanaJugador.getPanelAcciones().configurarBotones(unidad);
    }

    @Override
    public void actualizarPanelEstado() {

    }
}
