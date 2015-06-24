package vista.edificios.protoss;

import construcciones.protoss.Pilon;
import interfaces.ColocableEnMapa;
import vista.IVista;
import vista.auxiliares.ImagePanel;
import vista.ventanaJugadores.VentanaJugador;

import javax.swing.*;

public class VistaPilon extends ImagePanel implements IVista{

    private static final int ANCHO = 1;
    private static final int ALTO = 2;
    private final Pilon edificio;
    private final VentanaJugador ventanaJugador;

    public VistaPilon(ColocableEnMapa pilon, VentanaJugador ventanaJugador) {
        super(ANCHO,ALTO,new ImageIcon().getImage());
        this.edificio= (Pilon) pilon;
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
