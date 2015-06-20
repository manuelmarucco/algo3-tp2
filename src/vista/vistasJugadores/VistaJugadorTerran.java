package vista.vistasJugadores;

import vista.auxiliares.jugador.BotoneraDeConstruccionesTerran;

import javax.swing.*;

public class VistaJugadorTerran extends VistaJugador {

    // Metodos -------------------------

    public VistaJugadorTerran(){

        super.init();

    }

    @Override
    protected void crearPanelInferior(){
        super.crearPanelInferior();

        JLabel tituloConstrucciones = new JLabel("Construcciones");
        tituloConstrucciones.setVerticalAlignment(JLabel.CENTER);
        tituloConstrucciones.setHorizontalAlignment(JLabel.CENTER);

        this.panelInferior.add(tituloConstrucciones);
        this.panelInferior.add( new BotoneraDeConstruccionesTerran() );

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
