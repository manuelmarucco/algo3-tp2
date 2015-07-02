package vista.edificios.protoss;

import modelo.construcciones.protoss.EdificioEnInvocacion;
import modelo.interfaces.ColocableEnMapa;
import vista.IVista;
import vista.auxiliares.ImagePanel;
import vista.panelesDeEstado.panelesDeConstruccion.PanelEdificioEnInvocacion;
import vista.ventanaJugadores.VentanaJugador;

import javax.swing.*;

public class VistaEdificioEnInvocacion  extends ImagePanel implements IVista {

    private static final int ANCHO = 64;
    private static final int ALTO = 64;
    private final EdificioEnInvocacion edificio;
    private final VentanaJugador ventanaJugador;
    private static String imagePath="images/construcciones/edificioEnInvocacion.png";

    public VistaEdificioEnInvocacion(ColocableEnMapa edificioEnConstruccion, VentanaJugador ventanaJugador) {
        super(ANCHO,ALTO,new ImageIcon(imagePath).getImage().getScaledInstance(ANCHO, ALTO,  java.awt.Image.SCALE_SMOOTH));
        super.setBackground(new ImageIcon("src/vista/paisaje/imagenes/pasto.png").getImage());
        this.edificio= (EdificioEnInvocacion) edificioEnConstruccion;
        this.ventanaJugador=ventanaJugador;
    }

    @Override
    public void actualizarBotonera() {
        ventanaJugador.getPanelAcciones().limpiar();
    }

    @Override
    public void actualizarPanelEstado() {
        PanelEdificioEnInvocacion panelDeConstruccion = new PanelEdificioEnInvocacion();

        ventanaJugador.borrarPanelDeEstadoAnterior();
        this.cargarInfoAlPanelDeEstado(panelDeConstruccion);
        ventanaJugador.mostrarPanelDeEstado(panelDeConstruccion);

    }

    private void cargarInfoAlPanelDeEstado(PanelEdificioEnInvocacion panelDeConstruccion) {
        panelDeConstruccion.cargarDatosDeEdificioEnConstruccion(edificio);
    }
}
