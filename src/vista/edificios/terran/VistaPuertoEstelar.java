package vista.edificios.terran;

import construcciones.terran.PuertoEstelar;
import interfaces.ColocableEnMapa;
import vista.IVista;
import vista.auxiliares.ImagePanel;
import vista.ventanaJugadores.VentanaJugador;

import javax.swing.*;
import java.awt.*;

public class VistaPuertoEstelar extends ImagePanel implements IVista{

    private static final int ANCHO = 64;
    private static final int ALTO = 64;
    private final PuertoEstelar edificio;
    private final VentanaJugador ventanaJugador;
    private static String pathImagen="images/construcciones/terran/puerto_estelar.png";

    public VistaPuertoEstelar(ColocableEnMapa puertoEstelar,VentanaJugador ventanaJugador) {
        super(ANCHO, ALTO, new ImageIcon(pathImagen).getImage().getScaledInstance(ANCHO, ALTO, Image.SCALE_FAST));
        super.setBackground(new ImageIcon("src/vista/paisaje/imagenes/pasto.png").getImage());
        this.edificio= (PuertoEstelar) puertoEstelar;
        this.ventanaJugador=ventanaJugador;
    }

    @Override
    public void actualizarBotonera() {
        ventanaJugador.getPanelAcciones().configurarBotones(edificio);
    }

    @Override
    public void actualizarPanelEstado() {
        ventanaJugador.borrarPanelDeEstadoAnterior();

    }
}
