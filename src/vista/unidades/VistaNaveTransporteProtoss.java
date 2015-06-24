package vista.unidades;

import unidades.protoss.NaveTransporteProtoss;
import vista.IVista;
import vista.auxiliares.ImagePanel;
import vista.ventanaJugadores.VentanaJugador;

import javax.swing.*;

public class VistaNaveTransporteProtoss extends ImagePanel implements IVista {

    private static final int ANCHO = 1;
    private static final int ALTO = 2;
    private final NaveTransporteProtoss unidad;
    private final VentanaJugador ventanaJugador;
    private static String pathImagen="images/unidades/protoss/naveTransporte.png";

    public VistaNaveTransporteProtoss(NaveTransporteProtoss nave,VentanaJugador ventanaJugador) {
        super(ANCHO,ALTO,new ImageIcon(pathImagen).getImage());
        this.unidad=nave;
        this.ventanaJugador=ventanaJugador;
    }

    @Override
    public void actualizarBotonera() {
        ventanaJugador.getPanelAcciones().configurarBotones(unidad);
    }

    @Override
    public void actualizarPanelEstado() {

    }
}
