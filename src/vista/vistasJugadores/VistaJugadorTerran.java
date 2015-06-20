package vista.vistasJugadores;

import vista.auxiliares.jugador.BotoneraDeConstruccionesTerran;

import javax.swing.*;
import java.awt.*;

public class VistaJugadorTerran extends VistaJugador {

    // Atributos ---------------------

    private JPanel panelBotonera;

    // Metodos -------------------------

    public VistaJugadorTerran(){

        super.init();
        this.crearPanelBotonera();
        this.contenedor.add(panelBotonera, "South");

    }

    private void crearPanelBotonera(){

        this.panelBotonera = new JPanel( new GridLayout(2,2,0,0) );

        JLabel tituloConstrucciones = new JLabel("Construcciones");
        tituloConstrucciones.setVerticalAlignment(JLabel.CENTER);
        tituloConstrucciones.setHorizontalAlignment(JLabel.CENTER);

        this.panelBotonera.add(tituloConstrucciones);
        this.panelBotonera.add( new BotoneraDeConstruccionesTerran() );

    }

    // Main ---------------------------

    public static void main(String[] args){

        VistaJugador ventanaJugador = new VistaJugadorTerran();

        ventanaJugador.pack();
        ventanaJugador.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        ventanaJugador.setExtendedState(JFrame.MAXIMIZED_BOTH);
        ventanaJugador.setVisible(true);

    }

}
