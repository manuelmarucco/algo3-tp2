package vista.menusDePrueba;

import vista.panelesDeEstado.panelesDeUnidad.PanelUnidadGuerrera;
import vista.ventanaJugadores.VentanaJugadorProtoss;

import javax.swing.*;

public class PruebaPanelEstado{
    private JPanel panelLateral;
    private VentanaJugadorProtoss frame;

    public void construyeVentana(){
        frame = new VentanaJugadorProtoss();
        frame.mostrarPanelDeEstado(panelLateral);
        frame.pack();
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setVisible(true);

    }

    public PruebaPanelEstado(){
        panelLateral = new PanelUnidadGuerrera();
        construyeVentana();
    }

    public static void main (String [] inforux){
        new PruebaPanelEstado();
    }
}
