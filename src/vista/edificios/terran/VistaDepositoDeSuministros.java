package vista.edificios.terran;

import construcciones.CentroDeSuministros;
import construcciones.terran.DepositoDeSuministros;
import interfaces.ColocableEnMapa;
import vista.IVista;
import vista.auxiliares.ImagePanel;
import vista.ventanaJugadores.VentanaJugador;

import javax.swing.*;

public class VistaDepositoDeSuministros extends ImagePanel implements IVista{

    private static final int ANCHO = 1;
    private static final int ALTO = 2;
    private final CentroDeSuministros edificio;
    private static String pathImagen="images/construcciones/terrran/deposito_de_suministros.png";
    private final VentanaJugador ventanaJugador;

    public VistaDepositoDeSuministros(ColocableEnMapa depositoDeSuministros,VentanaJugador ventanaJugador) {
        super(ANCHO,ALTO,new ImageIcon(pathImagen).getImage());
        super.setBackground(new ImageIcon("src/vista/paisaje/imagenes/pasto.png").getImage());
        this.edificio= (DepositoDeSuministros) depositoDeSuministros;
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
