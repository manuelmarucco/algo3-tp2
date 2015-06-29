package vista.unidades;

import control.BufferImagenes;
import interfaces.ColocableEnMapa;
import unidades.protoss.ClonGuerrero;
import vista.IVista;
import vista.auxiliares.ImagePanel;
import vista.panelesDeEstado.panelesDeUnidad.PanelUnidadGuerrera;
import vista.ventanaJugadores.VentanaJugador;

import java.awt.*;

public class VistaClonGuerrero extends ImagePanel implements IVista {
    private static final int ANCHO = 64;
    private static final int ALTO = 64;
    private final ClonGuerrero clonGuerrero;
    private final VentanaJugador ventanaJugador;
    private static final BufferImagenes BUFFERIMAGENES = new BufferImagenes();

    public VistaClonGuerrero(ColocableEnMapa clonGuerrero,VentanaJugador ventanaJugador) {
        super(ANCHO, ALTO, BUFFERIMAGENES.obtenerImagen(((ClonGuerrero) clonGuerrero).getUnidad().getClass().getSimpleName()).getImage().getScaledInstance(ANCHO, ALTO, Image.SCALE_FAST));
        super.setBackground( BUFFERIMAGENES.obtenerImagen("Pasto").getImage());
        this.clonGuerrero=(ClonGuerrero)clonGuerrero;
        this.ventanaJugador=ventanaJugador;
    }

    @Override
    public void actualizarBotonera() {
        ventanaJugador.getPanelAcciones().configurarBotones(clonGuerrero);
    }

    @Override
    public void actualizarPanelEstado() {
        PanelUnidadGuerrera panelDeUnidad = new PanelUnidadGuerrera();

        ventanaJugador.borrarPanelDeEstadoAnterior();
        this.cargarInfoAlPanelDeEstado(panelDeUnidad);
        ventanaJugador.mostrarPanelDeEstado(panelDeUnidad);

    }

    private void cargarInfoAlPanelDeEstado(PanelUnidadGuerrera panelDeUnidad) {

        panelDeUnidad.setNombre(clonGuerrero.getClass().getSimpleName()); //TODO me parece que deberia tener el nombre de la unidad clonada y no el nombre "ClonGuerrero"
        panelDeUnidad.setVida(String.valueOf(clonGuerrero.getVida()));
        panelDeUnidad.setVision(String.valueOf(clonGuerrero.getVision()));
        panelDeUnidad.setEscudo(String.valueOf(clonGuerrero.getEscudo()));
    }
}
