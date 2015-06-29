package vista.unidades;

import control.BufferImagenes;
import interfaces.ColocableEnMapa;
import unidades.terrran.NaveTransporteTerran;
import vista.IVista;
import vista.auxiliares.ImagePanel;
import vista.panelesDeEstado.panelesDeUnidad.PanelUnidadTransporte;
import vista.ventanaJugadores.VentanaJugador;

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
        PanelUnidadTransporte panelDeUnidad = new PanelUnidadTransporte();

        ventanaJugador.borrarPanelDeEstadoAnterior();
        this.cargarInfoAlPanelDeEstado(panelDeUnidad);
        ventanaJugador.mostrarPanelDeEstado(panelDeUnidad);

    }

    private void cargarInfoAlPanelDeEstado(PanelUnidadTransporte panelDeUnidad) {

        panelDeUnidad.setNombre(unidad.getClass().getSimpleName());
        panelDeUnidad.setVida(String.valueOf(unidad.getVida()));
        panelDeUnidad.setVision(String.valueOf(unidad.getVision()));
        panelDeUnidad.cargarCapacidad(String.valueOf(unidad.getCapacidadMaxima()));
        panelDeUnidad.cargarDatosDeUnidadesCargadas(unidad.getUnidadesCargadas());
    }
}
