package vista.vistasJugadores;

import vista.auxiliares.jugador.BotoneraDeConstruccionesProtoss;

import javax.swing.*;
import java.awt.*;

public class VistaJugadorProtoss extends VistaJugador {

    // Atributos ---------------------

    private JPanel panelBotonera;

    // Metodos -------------------------

    public VistaJugadorProtoss(){

        super.init();
        this.crearPanelBotonera();
        this.contenedor.add(panelBotonera,"South");

    }

    private void crearPanelBotonera(){

        this.panelBotonera = new JPanel( new GridLayout(2,2,0,0) );

        JLabel tituloConstrucciones = new JLabel("Construcciones");
        tituloConstrucciones.setVerticalAlignment(JLabel.CENTER);
        tituloConstrucciones.setHorizontalAlignment(JLabel.CENTER);

        this.panelBotonera.add(tituloConstrucciones);
        this.panelBotonera.add( new BotoneraDeConstruccionesProtoss() );

    }

    // Main ---------------------------

    public static void main(String[] args){

        VistaJugador ventanaJugador = new VistaJugadorProtoss();

        ventanaJugador.pack();
        ventanaJugador.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        ventanaJugador.setExtendedState(JFrame.MAXIMIZED_BOTH);
        ventanaJugador.setVisible(true);

    }
}
