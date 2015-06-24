package vista.unidades;

import interfaces.ColocableEnMapa;
import unidades.terrran.Espectro;
import vista.Actions.MouseActionObtenerInfoEspectro;
import vista.IVista;
import vista.auxiliares.ImagePanel;
import vista.ventanaJugadores.VentanaJugador;

import javax.swing.*;

public class VistaEspectro extends ImagePanel implements IVista{
    private static final int ANCHO = 64;
    private static final int ALTO = 64;
    private final Espectro unidad;
    private final VentanaJugador ventanaJugador;
    private static String pathImagen="images/unidades/terrran/espectro.png";

    public VistaEspectro(ColocableEnMapa espectro,VentanaJugador ventanaJugador) {
        super(ANCHO,ALTO,new ImageIcon(pathImagen).getImage().getScaledInstance(ANCHO, ALTO, java.awt.Image.SCALE_SMOOTH));
        this.unidad=(Espectro)espectro;
        this.ventanaJugador = ventanaJugador;
        this.addMouseListener(new MouseActionObtenerInfoEspectro(unidad,ventanaJugador));
    }

    @Override
    public void actualizarBotonera() {
        ventanaJugador.getPanelAcciones().configurarBotones(unidad);
    }

    @Override
    public void actualizarPanelEstado() {

    }
}
