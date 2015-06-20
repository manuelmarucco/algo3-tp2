package vista.ventanaJugadores;

import vista.auxiliares.jugador.BotoneraDeConstruccionesTerran;

import javax.swing.*;

public class VentanaJugadorTerran extends VentanaJugador {

    // Metodos -------------------------

    public VentanaJugadorTerran(){

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

        VentanaJugador ventanaJugador = new VentanaJugadorTerran();

        ventanaJugador.pack();
        ventanaJugador.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        ventanaJugador.setExtendedState(JFrame.MAXIMIZED_BOTH);
        ventanaJugador.setVisible(true);

    }

}
