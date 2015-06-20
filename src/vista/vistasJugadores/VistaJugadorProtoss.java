package vista.vistasJugadores;

import vista.auxiliares.jugador.BotoneraDeConstruccionesProtoss;

import javax.swing.*;

public class VistaJugadorProtoss extends VistaJugador {


    // Metodos -------------------------

    public VistaJugadorProtoss(){

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

        JLabel tituloConstrucciones = new JLabel("Construcciones");
        tituloConstrucciones.setVerticalAlignment(JLabel.CENTER);
        tituloConstrucciones.setHorizontalAlignment(JLabel.CENTER);

        this.panelInferior.add(tituloConstrucciones,"Center");
        this.panelInferior.add( new BotoneraDeConstruccionesProtoss() ,"Center");

        //this.panelInferior.add()
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
