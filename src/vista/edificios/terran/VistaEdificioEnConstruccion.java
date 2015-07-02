package vista.edificios.terran;

import modelo.construcciones.EdificioEnConstruccion;
import modelo.interfaces.ColocableEnMapa;
import vista.IVista;
import vista.auxiliares.ImagePanel;
import vista.panelesDeEstado.panelesDeConstruccion.PanelEdificioEnConstruccion;
import vista.ventanaJugadores.VentanaJugador;

import javax.swing.*;

public class VistaEdificioEnConstruccion  extends ImagePanel implements IVista {

    private static final int ANCHO = 64;
    private static final int ALTO = 64;
    private final EdificioEnConstruccion edificio;
    private final VentanaJugador ventanaJugador;
    private static String imagePath="images/construcciones/edificioEnConstruccion.png";

    public VistaEdificioEnConstruccion(ColocableEnMapa edificioEnConstruccion, VentanaJugador ventanaJugador) {
        super(ANCHO,ALTO,new ImageIcon(imagePath).getImage().getScaledInstance(ANCHO, ALTO,  java.awt.Image.SCALE_SMOOTH));
        super.setBackground(new ImageIcon("src/vista/paisaje/imagenes/pasto.png").getImage());
        this.edificio= (EdificioEnConstruccion) edificioEnConstruccion;
        this.ventanaJugador=ventanaJugador;
    }

    @Override
    public void actualizarBotonera() {
        ventanaJugador.getPanelAcciones().limpiar();
    }

    @Override
    public void actualizarPanelEstado() {
        PanelEdificioEnConstruccion panelDeConstruccion = new PanelEdificioEnConstruccion();

        ventanaJugador.borrarPanelDeEstadoAnterior();
        this.cargarInfoAlPanelDeEstado(panelDeConstruccion);
        ventanaJugador.mostrarPanelDeEstado(panelDeConstruccion);

    }

    private void cargarInfoAlPanelDeEstado(PanelEdificioEnConstruccion panelDeConstruccion) {
        panelDeConstruccion.cargarDatosDeEdificioEnConstruccion(edificio);
    }
}
