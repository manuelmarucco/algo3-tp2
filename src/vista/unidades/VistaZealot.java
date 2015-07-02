package vista.unidades;

import control.BufferImagenes;
import modelo.interfaces.ColocableEnMapa;
import modelo.unidades.protoss.Zealot;
import vista.IVista;
import vista.auxiliares.ImagePanel;
import vista.panelesDeEstado.panelesDeUnidad.PanelUnidadGuerrera;
import vista.ventanaJugadores.VentanaJugador;

import java.awt.*;

public class VistaZealot extends ImagePanel implements IVista{

    private static final int ANCHO = 64;
    private static final int ALTO = 64;
    private final Zealot unidad;
    private final VentanaJugador ventanaJugador;
    private static final BufferImagenes BUFFERIMAGENES = new BufferImagenes();

    public VistaZealot(ColocableEnMapa zealot,VentanaJugador ventanaJugador) {
        super(ANCHO, ALTO, BUFFERIMAGENES.obtenerImagen("Zealot").getImage().getScaledInstance(ANCHO, ALTO, Image.SCALE_FAST));
        super.setBackground( BUFFERIMAGENES.obtenerImagen("Pasto").getImage());
        this.unidad=(Zealot)zealot;
        this.ventanaJugador=ventanaJugador;
    }

    @Override
    public void actualizarBotonera() {
        ventanaJugador.getPanelAcciones().configurarBotones(unidad);
    }

    @Override
    public void actualizarPanelEstado() {
        PanelUnidadGuerrera panelDeUnidad = new PanelUnidadGuerrera();

        ventanaJugador.borrarPanelDeEstadoAnterior();
        this.cargarInfoAlPanelDeEstado(panelDeUnidad);
        ventanaJugador.mostrarPanelDeEstado(panelDeUnidad);

    }

    private void cargarInfoAlPanelDeEstado(PanelUnidadGuerrera panelDeUnidad) {

        panelDeUnidad.setNombre(unidad.getClass().getSimpleName());
        panelDeUnidad.setVision(String.valueOf(unidad.getVision()));
        panelDeUnidad.setEscudo(String.valueOf(unidad.getEscudo()));
        panelDeUnidad.cargarDatosActualizables(unidad);
        panelDeUnidad.setDanioTerrestre(String.valueOf(unidad.getDanioTerrestre()));
        panelDeUnidad.setDanioAereo(String.valueOf(unidad.getDanioAereo()));
        panelDeUnidad.setRangoAtaqueTerrestre(String.valueOf(unidad.getRangoTerrestre()));
        panelDeUnidad.setRangoAtaqueAereo(String.valueOf(unidad.getRangoAereo()));
    }
}
