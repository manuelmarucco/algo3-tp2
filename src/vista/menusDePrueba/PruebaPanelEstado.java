package vista.menusDePrueba;

import jugabilidad.RazaDeJugador.JugadorProtoss;
import vista.panelesDeEstado.panelesDeUnidad.PanelUnidadGuerrera;
import vista.ventanaJugadores.VentanaJugador;
import vista.ventanaJugadores.VentanaJugadorProtoss;

import javax.swing.*;

public class PruebaPanelEstado{
    private JPanel panelLateral;
    private VentanaJugador frame;

    public void construyeVentana(){
        frame = new VentanaJugadorProtoss(new JugadorProtoss());
       // frame = new VentanaJugadorProtoss();
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
