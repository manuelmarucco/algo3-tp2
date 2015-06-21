package vista.ventanaJugadores;

import jugabilidad.RazaDeJugador.JugadorTerran;
import vista.auxiliares.jugador.BotoneraDeConstruccionesTerran;
import vista.auxiliares.jugador.DisplayRecursos;

import javax.swing.*;
import java.awt.*;

public class VentanaJugadorTerran extends VentanaJugador {

    private JugadorTerran jugador;

    // Metodos -------------------------

    public VentanaJugadorTerran(){

        super.init();

    }

    @Override
    protected void crearPanelRecursos() {


        this.panelRecursos = new JPanel();
        this.panelRecursos.add( new DisplayRecursos() );
        this.panelRecursos.setPreferredSize(new Dimension(700, 35));
    }

    public VentanaJugadorTerran(JugadorTerran jugador){

        super.init();
        this.jugador = jugador;

    }

    @Override
    protected void crearPanelInferior(){
        super.crearPanelInferior();
        JPanel botoneraConstrucciones = new JPanel(new GridLayout(2,1));

        JLabel tituloConstrucciones = new JLabel("Construcciones");
        tituloConstrucciones.setVerticalAlignment(JLabel.CENTER);
        tituloConstrucciones.setHorizontalAlignment(JLabel.CENTER);

        botoneraConstrucciones.add(tituloConstrucciones);
        botoneraConstrucciones.add( new BotoneraDeConstruccionesTerran() );

        this.panelInferior.add(botoneraConstrucciones,"West");
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
