package vista.unidades;

import control.BufferImagenes;
import modelo.interfaces.ColocableEnMapa;
import modelo.unidades.terrran.Marine;
import vista.IVista;
import vista.auxiliares.ImagePanel;
import vista.panelesDeEstado.panelesDeUnidad.PanelUnidadGuerrera;
import vista.ventanaJugadores.VentanaJugador;

import java.awt.*;

public class VistaMarine extends ImagePanel implements IVista{

    private static final int ANCHO = 64;
    private static final int ALTO = 64;
    private final Marine unidad;
    private static final BufferImagenes BUFFERIMAGENES = BufferImagenes.getInstance();
    private final VentanaJugador ventanaJugador;

    public VistaMarine(ColocableEnMapa unidad,VentanaJugador ventanaJugador) {
        super(ANCHO, ALTO, BUFFERIMAGENES.obtenerImagen("Marine").getImage().getScaledInstance(ANCHO, ALTO, Image.SCALE_FAST));
        super.setBackground( BUFFERIMAGENES.obtenerImagen("Pasto").getImage());
        this.unidad = (Marine) unidad;
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
        panelDeUnidad.cargarDatosActualizables(unidad);
        panelDeUnidad.setDanioTerrestre(String.valueOf(unidad.getDanioTerrestre()));
        panelDeUnidad.setDanioAereo(String.valueOf(unidad.getDanioAereo()));
        panelDeUnidad.setRangoAtaqueTerrestre(String.valueOf(unidad.getRangoTerrestre()));
        panelDeUnidad.setRangoAtaqueAereo(String.valueOf(unidad.getRangoAereo()));
    }
}