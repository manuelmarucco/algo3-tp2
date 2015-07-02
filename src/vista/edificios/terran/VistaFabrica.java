package vista.edificios.terran;

import modelo.construcciones.terran.Fabrica;
import control.BufferImagenes;
import modelo.interfaces.ColocableEnMapa;
import vista.IVista;
import vista.auxiliares.ImagePanel;
import vista.panelesDeEstado.panelesDeConstruccion.PanelCentroDeEntrenamiento;
import vista.ventanaJugadores.VentanaJugador;

import java.awt.*;

public class VistaFabrica extends ImagePanel implements IVista{

    private static final int ANCHO = 64;
    private static final int ALTO = 64;
    private static final BufferImagenes BUFFERIMAGENES = new BufferImagenes();
    private final Fabrica edificio;
    private final VentanaJugador ventanaJugador;



    public VistaFabrica(ColocableEnMapa fabrica, VentanaJugador ventanaJugador) {
        super(ANCHO, ALTO, BUFFERIMAGENES.obtenerImagen("Fabrica").getImage().getScaledInstance(ANCHO, ALTO, Image.SCALE_FAST));
        super.setBackground( BUFFERIMAGENES.obtenerImagen("Pasto").getImage());
        this.edificio= (Fabrica) fabrica;
        this.ventanaJugador=ventanaJugador;
    }

    @Override
    public void actualizarBotonera() {
        ventanaJugador.getPanelAcciones().configurarBotones(edificio);
    }

    @Override
    public void actualizarPanelEstado() {
        PanelCentroDeEntrenamiento panelDeConstruccion = new PanelCentroDeEntrenamiento();

        ventanaJugador.borrarPanelDeEstadoAnterior();
        this.cargarInfoAlPanelDeEstado(panelDeConstruccion);
        ventanaJugador.mostrarPanelDeEstado(panelDeConstruccion);

    }

    private void cargarInfoAlPanelDeEstado(PanelCentroDeEntrenamiento panelDeConstruccion) {

        panelDeConstruccion.cargarNombre(edificio.getClass().getSimpleName());
        panelDeConstruccion.cargarVida(String.valueOf(edificio.getVida()));
        panelDeConstruccion.cargarDatosDeColaDeEntrenamiento(edificio.getColaDeEntrenamiento());
    }
}
