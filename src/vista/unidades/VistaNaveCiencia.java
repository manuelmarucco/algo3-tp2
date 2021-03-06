package vista.unidades;

import control.BufferImagenes;
import modelo.interfaces.ColocableEnMapa;
import modelo.unidades.terrran.NaveCiencia;
import vista.IVista;
import vista.auxiliares.ImagePanel;
import vista.panelesDeEstado.panelesDeUnidad.PanelUnidadMagica;
import vista.ventanaJugadores.VentanaJugador;

import java.awt.*;

public class VistaNaveCiencia extends ImagePanel implements IVista{

    private static final int ANCHO = 64;
    private static final int ALTO = 64;
    private final NaveCiencia unidad;
    private static final BufferImagenes BUFFERIMAGENES = BufferImagenes.getInstance();
    private VentanaJugador ventanaJugador;

    public VistaNaveCiencia(ColocableEnMapa naveCiencia,VentanaJugador ventanaJugador) {
        super(ANCHO, ALTO, BUFFERIMAGENES.obtenerImagen("NaveCiencia").getImage().getScaledInstance(ANCHO, ALTO, Image.SCALE_FAST));
        this.unidad= (NaveCiencia) naveCiencia;
        this.ventanaJugador=ventanaJugador;
    }

    @Override
    public void actualizarBotonera() {
        ventanaJugador.getPanelAcciones().configurarBotones(unidad);
    }

    @Override
    public void actualizarPanelEstado() {
        PanelUnidadMagica panelDeUnidad = new PanelUnidadMagica();

        ventanaJugador.borrarPanelDeEstadoAnterior();
        this.cargarInfoAlPanelDeEstado(panelDeUnidad);
        ventanaJugador.mostrarPanelDeEstado(panelDeUnidad);

    }

    private void cargarInfoAlPanelDeEstado(PanelUnidadMagica panelDeUnidad) {

        panelDeUnidad.setNombre(unidad.getClass().getSimpleName());
        panelDeUnidad.setEnergiaTotal(String.valueOf(unidad.getEnergia().getEnergiaTotal()));
        panelDeUnidad.setVision(String.valueOf(unidad.getVision()));
        panelDeUnidad.cargarDatosActualizables(unidad);
    }
}
