package vista.ventanaJugadores;

import vista.auxiliares.jugador.BotoneraDeConstruccionesProtoss;

import javax.swing.*;
import java.awt.*;

public class VentanaJugadorProtoss extends VentanaJugador {


    // Metodos -------------------------

    public VentanaJugadorProtoss(){

        super.init();
      //  this.crearPanelInferior();
      //  this.contenedor.add(panelInferior,"South");

    }
/*
    private void crearPanelInferior(){


       // this.panelInferior = new JPanel( new GridLayout(2,2,0,0) );
        this.panelInferior = new JPanel( new BorderLayout() );

        JLabel tituloConstrucciones = new JLabel("Construcciones");
        tituloConstrucciones.setVerticalAlignment(JLabel.CENTER);
        tituloConstrucciones.setHorizontalAlignment(JLabel.CENTER);

        this.panelInferior.add(tituloConstrucciones,"Center");
        this.panelInferior.add( new BotoneraDeConstruccionesProtoss() ,"Center");

        this.panelInferior.add(new PanelTerminaTurno(),"East");

    }


*/
    @Override
    protected void crearPanelInferior(){
        super.crearPanelInferior();
        JPanel botonera = new JPanel(new BorderLayout());

        JLabel tituloConstrucciones = new JLabel("Construcciones");
        tituloConstrucciones.setVerticalAlignment(JLabel.CENTER);
        tituloConstrucciones.setHorizontalAlignment(JLabel.CENTER);

        botonera.add(tituloConstrucciones,"North");
        botonera.add(new BotoneraDeConstruccionesProtoss(), "Center");

        this.panelInferior.add(botonera);
    }
    // Main ---------------------------

    public static void main(String[] args){

        VentanaJugador ventanaJugador = new VentanaJugadorProtoss();

        ventanaJugador.pack();
        ventanaJugador.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        ventanaJugador.setExtendedState(JFrame.MAXIMIZED_BOTH);
        ventanaJugador.setVisible(true);

    }
}
