package vista.unidades;

import control.BufferImagenes;
import interfaces.ColocableEnMapa;
import unidades.protoss.Scout;
import vista.IVista;
import vista.auxiliares.ImagePanel;
import vista.panelesDeEstado.panelesDeUnidad.PanelUnidadGuerrera;
import vista.ventanaJugadores.VentanaJugador;

import java.awt.*;

public class VistaScout extends ImagePanel implements IVista{

    private static final int ANCHO = 64;
    private static final int ALTO = 64;
    private final Scout unidad;
    private final VentanaJugador ventanaJugador;
    private static final BufferImagenes BUFFERIMAGENES = new BufferImagenes();

    public VistaScout(ColocableEnMapa scout,VentanaJugador ventanaJugador) {
        
        super(ANCHO, ALTO, BUFFERIMAGENES.obtenerImagen("Scout").getImage().getScaledInstance(ANCHO, ALTO, Image.SCALE_FAST));
        this.unidad = (Scout) scout;
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
        panelDeUnidad.setVida(String.valueOf(unidad.getVida()));
        panelDeUnidad.setVision(String.valueOf(unidad.getVision()));
        panelDeUnidad.setEscudo(String.valueOf(unidad.getEscudo()));
        panelDeUnidad.setDanioTerrestre(String.valueOf(unidad.getDanioTerrestre()));
        panelDeUnidad.setDanioAereo(String.valueOf(unidad.getDanioAereo()));
        panelDeUnidad.setRangoAtaqueTerrestre(String.valueOf(unidad.getRangoTerrestre()));
        panelDeUnidad.setRangoAtaqueAereo(String.valueOf(unidad.getRangoAereo()));
    }
}
