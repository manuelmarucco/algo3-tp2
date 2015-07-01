package vista;

import control.BufferImagenes;
import interfaces.ColocableEnMapa;
import vista.auxiliares.ImagePanel;
import vista.ventanaJugadores.VentanaJugador;

import java.awt.*;

public class VistaTormentaPsionica  extends ImagePanel implements IVista {
    private static final int ANCHO = 64;
    private static final int ALTO = 64;
    private final VentanaJugador ventanaJugador;
    private static final BufferImagenes BUFFERIMAGENES = new BufferImagenes();

    public VistaTormentaPsionica(ColocableEnMapa foo,VentanaJugador ventanaJugador) {
        super(ANCHO, ALTO, BUFFERIMAGENES.obtenerImagen("TormentaPsionica").getImage().getScaledInstance(ANCHO, ALTO, Image.SCALE_FAST));
        this.ventanaJugador=ventanaJugador;
        this.setOpaque(false);
    }

    @Override
    public void actualizarBotonera() {
    }

    @Override
    public void actualizarPanelEstado() {
    }
}
