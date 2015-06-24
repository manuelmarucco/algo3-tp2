package vista.edificios.terran;

import construcciones.terran.DepositoDeSuministros;
import interfaces.ColocableEnMapa;
import vista.IVista;
import vista.auxiliares.ImagePanel;
import vista.ventanaJugadores.VentanaJugador;

import javax.swing.*;
import java.awt.*;

public class VistaDepositoDeSuministros extends ImagePanel implements IVista{

    private static final int ANCHO = 64;
    private static final int ALTO = 64;
    private final DepositoDeSuministros edificio;
    private static String pathImagen="images/construcciones/terran/deposito_de_suministros.png";
    private final VentanaJugador ventanaJugador;

    public VistaDepositoDeSuministros(ColocableEnMapa depositoDeSuministros,VentanaJugador ventanaJugador) {
        super(ANCHO,ALTO,new ImageIcon(pathImagen).getImage().getScaledInstance(ANCHO, ALTO, Image.SCALE_FAST));
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
