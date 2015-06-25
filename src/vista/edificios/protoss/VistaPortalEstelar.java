package vista.edificios.protoss;

import construcciones.protoss.PortalEstelar;
import interfaces.ColocableEnMapa;
import vista.IVista;
import vista.auxiliares.ImagePanel;
import vista.panelesDeEstado.panelesDeConstruccion.PanelCentroDeEntrenamiento;
import vista.ventanaJugadores.VentanaJugador;

import javax.swing.*;

public class VistaPortalEstelar extends ImagePanel implements IVista{

    private static final int ANCHO = 64;
    private static final int ALTO = 64;
    private final PortalEstelar edificio;
    private final VentanaJugador ventanaJugador;
    private static String pathImagen="images/construcciones/protoss/portalEstelar.png";


    public VistaPortalEstelar(ColocableEnMapa portalEstelar,VentanaJugador ventanaJugador) {
        super(ANCHO,ALTO,new ImageIcon(pathImagen).getImage().getScaledInstance(ANCHO, ALTO, java.awt.Image.SCALE_SMOOTH));
        super.setBackground(new ImageIcon("src/vista/paisaje/imagenes/pasto.png").getImage());
        this.edificio= (PortalEstelar) portalEstelar;
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

        panelDeConstruccion.setNombre(edificio.getClass().getSimpleName());
        panelDeConstruccion.setVida(String.valueOf(edificio.getVida()));
        panelDeConstruccion.setVida(String.valueOf(edificio.getEscudo()));
        panelDeConstruccion.mostrarColaDeEntrenamiento(edificio.getColaDeEntrenamiento());
    }
}
