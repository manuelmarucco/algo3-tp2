package vista.menusDePrueba;

import vista.panelesDeEstado.panelesDeUnidad.PanelUnidad;
import vista.ventanaJugadores.VentanaJugador;
import vista.ventanaJugadores.VentanaJugadorProtoss;

import javax.swing.*;

public class PruebaPanelEstado {
    VentanaJugador ventanaJugador;

    public PruebaPanelEstado(){
        ventanaJugador = new VentanaJugadorProtoss();
        ventanaJugador.pack();
        ventanaJugador.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        ventanaJugador.setExtendedState(JFrame.MAXIMIZED_BOTH);
        ventanaJugador.setVisible(true);

        ventanaJugador.mostrarPanelDeEstado(new PanelUnidad(),"Center");
    }

    public static void main(String[] args){
        PruebaPanelEstado pruebaPanelEstado = new PruebaPanelEstado();
    }
}
