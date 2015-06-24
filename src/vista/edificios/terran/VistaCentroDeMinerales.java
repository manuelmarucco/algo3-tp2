package vista.edificios.terran;

import construcciones.terran.CentroDeMineral;
import interfaces.ColocableEnMapa;
import vista.IVista;
import vista.auxiliares.ImagePanel;
import vista.ventanaJugadores.VentanaJugador;

import javax.swing.*;

public class VistaCentroDeMinerales extends ImagePanel implements IVista{

    private static final int ANCHO = 1;
    private static final int ALTO = 2;
    private final CentroDeMineral edificio;
    private final VentanaJugador ventanaJugador;

    public VistaCentroDeMinerales(ColocableEnMapa centroDeMineral, VentanaJugador ventanaJugador) {
        super(ANCHO,ALTO,new ImageIcon().getImage());
        this.edificio= (CentroDeMineral) centroDeMineral;
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
