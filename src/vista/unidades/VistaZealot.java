package vista.unidades;

import interfaces.ColocableEnMapa;
import unidades.protoss.Zealot;
import vista.IVista;
import vista.auxiliares.ImagePanel;
import vista.ventanaJugadores.VentanaJugador;

import javax.swing.*;
import java.awt.*;

public class VistaZealot extends ImagePanel implements IVista{

    private static final int ANCHO = 64;
    private static final int ALTO = 64;
    private final Zealot unidad;
    private final VentanaJugador ventanaJugador;
    private static String pathImagen="images/unidades/protoss/zealot.png";

    public VistaZealot(ColocableEnMapa zealot,VentanaJugador ventanaJugador) {
        super(ANCHO, ALTO, new ImageIcon(pathImagen).getImage().getScaledInstance(ANCHO, ALTO, Image.SCALE_FAST));
        super.setBackground(new ImageIcon("src/vista/paisaje/imagenes/pasto.png").getImage());
        this.unidad=(Zealot)zealot;
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
