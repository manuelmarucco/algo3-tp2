package vista.menusDePrueba;

import jugabilidad.Juego;
import jugabilidad.RazaDeJugador.JugadorProtoss;
import jugabilidad.utilidadesMapa.Coordenada;
import vista.VentanaJuego;
import vista.panelesDeEstado.panelesDeUnidad.PanelUnidadGuerrera;
import vista.ventanaJugadores.VentanaJugador;
import vista.ventanaJugadores.VentanaJugadorProtoss;

import javax.swing.*;

public class PruebaPanelEstado{
    private JPanel panelLateral;
    private VentanaJugador frame;

    public void construyeVentana(){
        frame = new VentanaJugadorProtoss(new JugadorProtoss(),new VentanaJuego(new Juego(2)),new Coordenada(10,10));
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
