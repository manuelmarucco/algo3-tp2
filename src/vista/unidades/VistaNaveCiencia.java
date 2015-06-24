package vista.unidades;

import interfaces.ColocableEnMapa;
import unidades.terrran.NaveCiencia;
import vista.IVista;
import vista.auxiliares.ImagePanel;
import vista.ventanaJugadores.VentanaJugador;

import javax.swing.*;

public class VistaNaveCiencia extends ImagePanel implements IVista{

    private static final int ANCHO = 64;
    private static final int ALTO = 64;
    private final NaveCiencia unidad;
    private static String pathImagen="images/unidades/terrran/naveCiencia.png";
    private VentanaJugador ventanaJugador;

    public VistaNaveCiencia(ColocableEnMapa naveCiencia,VentanaJugador ventanaJugador) {
        super(ANCHO,ALTO,new ImageIcon(pathImagen).getImage().getScaledInstance(ANCHO, ALTO, java.awt.Image.SCALE_SMOOTH));
        this.unidad= (NaveCiencia) naveCiencia;
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
