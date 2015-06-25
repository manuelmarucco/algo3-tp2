package vista.edificios.terran;

import construcciones.terran.Barraca;
import interfaces.ColocableEnMapa;
import vista.IVista;
import vista.auxiliares.ImagePanel;
import vista.panelesDeEstado.panelesDeConstruccion.PanelCentroDeEntrenamiento;
import vista.ventanaJugadores.VentanaJugador;

import javax.swing.*;
import java.awt.*;

public class VistaBarraca extends ImagePanel implements IVista {

    private static final int ANCHO = 64;
    private static final int ALTO = 64;
    private final Barraca barraca;
    private static String pathImagen="images/construcciones/terran/barraca.png";
    private final VentanaJugador ventanaJugador;

    public VistaBarraca(ColocableEnMapa barraca,VentanaJugador ventanaJugador) {
        super(ANCHO,ALTO,new ImageIcon(pathImagen).getImage().getScaledInstance(ANCHO,ALTO, Image.SCALE_FAST));
        super.setBackground(new ImageIcon("src/vista/paisaje/imagenes/pasto.png").getImage());
        this.barraca=(Barraca) barraca;
        this.ventanaJugador=ventanaJugador;
    }

    @Override
    public void actualizarBotonera() {
        ventanaJugador.getPanelAcciones().configurarBotones(barraca);
    }

    @Override
    public void actualizarPanelEstado() {
        PanelCentroDeEntrenamiento panelDeConstruccion = new PanelCentroDeEntrenamiento();

        ventanaJugador.borrarPanelDeEstadoAnterior();
        this.cargarInfoAlPanelDeEstado(panelDeConstruccion);
        ventanaJugador.mostrarPanelDeEstado(panelDeConstruccion);

    }

    private void cargarInfoAlPanelDeEstado(PanelCentroDeEntrenamiento panelDeConstruccion) {

        panelDeConstruccion.setNombre(barraca.getClass().getSimpleName());
        panelDeConstruccion.setVida(String.valueOf(barraca.getVida()));
        panelDeConstruccion.setColaDeEntrenamiento(barraca.getColaDeEntrenamiento());
    }
}
