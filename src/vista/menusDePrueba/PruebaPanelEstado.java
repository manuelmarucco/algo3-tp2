package vista.menusDePrueba;

import vista.panelesDeEstado.panelesDeUnidad.PanelUnidadMagica;

import javax.swing.*;

/*
public class PruebaPanelEstado {
    VentanaJugador ventanaJugador;

    public PruebaPanelEstado(){
        ventanaJugador = new VentanaJugadorProtoss();
        ventanaJugador.pack();
        ventanaJugador.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        ventanaJugador.setExtendedState(JFrame.MAXIMIZED_BOTH);
        ventanaJugador.setVisible(true);

        ventanaJugador.mostrarPanelDeEstado(new PanelUnidad());
    }

    public static void main(String[] args){
        PruebaPanelEstado pruebaPanelEstado = new PruebaPanelEstado();
    }
}
*/

public class PruebaPanelEstado{
    private JPanel panelLateral;
    private JFrame frame;

    public void construyeVentana(){
        frame = new JFrame();
        frame.setLayout(new BoxLayout(frame.getContentPane(), BoxLayout.Y_AXIS) );
        frame.add(panelLateral);
        frame.pack();
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }

    public PruebaPanelEstado(){
        /*
        panelLateral = new JPanel();
        panelLateral.add(new PanelUnidad());
        */
       panelLateral = new PanelUnidadMagica();
      // panelLateral = new PanelUnidadGuerrera();
        construyeVentana();
    }

    public static void main (String [] inforux){
        new PruebaPanelEstado();
    }
}
