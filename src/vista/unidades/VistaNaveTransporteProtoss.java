package vista.unidades;

import control.BufferImagenes;
import interfaces.ColocableEnMapa;
import unidades.protoss.NaveTransporteProtoss;
import vista.IVista;
import vista.auxiliares.ImagePanel;
import vista.ventanaJugadores.VentanaJugador;

import javax.swing.*;
import java.awt.*;

public class VistaNaveTransporteProtoss extends ImagePanel implements IVista {

    private static final int ANCHO = 64;
    private static final int ALTO = 64;
    private final NaveTransporteProtoss unidad;
    private final VentanaJugador ventanaJugador;
    private static final BufferImagenes BUFFERIMAGENES = new BufferImagenes();

    public VistaNaveTransporteProtoss(ColocableEnMapa nave,VentanaJugador ventanaJugador) {

        super(ANCHO, ALTO, BUFFERIMAGENES.obtenerImagen("NaveTransporteProtoss").getImage().getScaledInstance(ANCHO, ALTO, Image.SCALE_FAST));
        this.unidad = (NaveTransporteProtoss) nave;
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
