package vista.edificios.terran;

import construcciones.terran.Refineria;
import interfaces.ColocableEnMapa;
import vista.IVista;
import vista.auxiliares.ImagePanel;
import vista.ventanaJugadores.VentanaJugador;

import javax.swing.*;

public class VistaRefineria extends ImagePanel implements IVista{

    private static final int ANCHO = 1;
    private static final int ALTO = 2;
    private final Refineria edificio;
    private final VentanaJugador ventanaJugador;

    public VistaRefineria(ColocableEnMapa refineria, VentanaJugador ventanaJugador) {
        super(ANCHO,ALTO,new ImageIcon().getImage());
        this.edificio= (Refineria) refineria;
        this.ventanaJugador=ventanaJugador;
    }

    @Override
    public void actualizarBotonera() {
        ventanaJugador.getPanelAcciones().configurarBotones(edificio);
    }

    @Override
    public void actualizarPanelEstado() {

    }
}
