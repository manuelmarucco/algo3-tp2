package vista.unidades;

import unidades.protoss.Zealot;
import vista.IVista;
import vista.auxiliares.ImagePanel;
import vista.ventanaJugadores.VentanaJugador;

import javax.swing.*;

public class VistaZealot extends ImagePanel implements IVista{

    private static final int ANCHO = 1;
    private static final int ALTO = 2;
    private final Zealot unidad;
    private final VentanaJugador ventanaJugador;
    private static String pathImagen="images/unidades/protoss/zealot.png";

    public VistaZealot(Zealot zealot,VentanaJugador ventanaJugador) {
        super(ANCHO,ALTO,new ImageIcon(pathImagen).getImage());
        super.setBackground(new ImageIcon("src/vista/paisaje/imagenes/pasto.png").getImage());
        this.unidad=zealot;
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
