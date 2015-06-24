package vista.recursos;

import interfaces.ColocableEnMapa;
import recursos.Volcan;
import vista.IVista;
import vista.auxiliares.ImagePanel;
import vista.ventanaJugadores.VentanaJugador;

import javax.swing.*;

public class VistaVolcan extends ImagePanel implements IVista {

    private static final int ANCHO = 64;
    private static final int ALTO = 64;
    private final Volcan recurso;
    private static String pathImagen="src/vista/recursos/imagenes/volcan.png";
    private final VentanaJugador ventanaJugador;


    public VistaVolcan(ColocableEnMapa volcan,VentanaJugador ventanaJugador) {
        super(ANCHO,ALTO,new ImageIcon(pathImagen).getImage());
        this.recurso=(Volcan)volcan;
        this.ventanaJugador=ventanaJugador;
    }

    @Override
    public void actualizarBotonera() {
        ventanaJugador.getPanelAcciones().configurarBotones(recurso);
    }

    @Override
    public void actualizarPanelEstado() {

    }
}