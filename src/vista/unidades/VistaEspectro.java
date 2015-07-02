package vista.unidades;

import control.BufferImagenes;
import modelo.interfaces.ColocableEnMapa;
import modelo.unidades.terrran.Espectro;
import vista.IVista;
import vista.auxiliares.ImagePanel;
import vista.panelesDeEstado.panelesDeUnidad.PanelUnidadGuerrera;
import vista.ventanaJugadores.VentanaJugador;

import java.awt.*;

public class VistaEspectro extends ImagePanel implements IVista{
    private static final int ANCHO = 64;
    private static final int ALTO = 64;
    private final Espectro unidad;
    private final VentanaJugador ventanaJugador;
    private static final BufferImagenes BUFFERIMAGENES = new BufferImagenes();

    public VistaEspectro(ColocableEnMapa unidad,VentanaJugador ventanaJugador) {
        super(ANCHO, ALTO, BUFFERIMAGENES.obtenerImagen("Espectro").getImage().getScaledInstance(ANCHO, ALTO, Image.SCALE_FAST));
        this.unidad =(Espectro) unidad;
        this.ventanaJugador = ventanaJugador;
    }

    @Override
    public void actualizarBotonera() {
        ventanaJugador.getPanelAcciones().configurarBotones(unidad);
    }

    @Override
    public void actualizarPanelEstado() {
        PanelUnidadGuerrera panelDeUnidad = new PanelUnidadGuerrera();

        this.cargarInfoAlPanelDeEstado(panelDeUnidad);
        ventanaJugador.borrarPanelDeEstadoAnterior();
        ventanaJugador.mostrarPanelDeEstado(panelDeUnidad);
}

    private void cargarInfoAlPanelDeEstado(PanelUnidadGuerrera panelDeUnidad ) {

        panelDeUnidad.setNombre(unidad.getClass().toString());
        panelDeUnidad.setVision(String.valueOf(unidad.getVision()));
        panelDeUnidad.cargarDatosActualizables(unidad);
        panelDeUnidad.setDanioTerrestre(String.valueOf(unidad.getDanioTerrestre()));
        panelDeUnidad.setDanioAereo(String.valueOf(unidad.getDanioAereo()));
        panelDeUnidad.setRangoAtaqueTerrestre(String.valueOf(unidad.getRangoTerrestre()));
        panelDeUnidad.setRangoAtaqueAereo(String.valueOf(unidad.getRangoAereo()));
    }
}
