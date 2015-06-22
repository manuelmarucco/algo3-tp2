package vista.ventanaJugadores;

import jugabilidad.RazaDeJugador.JugadorTerran;
import jugabilidad.extrasJuego.CreadorDeMapa;
import vista.auxiliares.jugador.BotoneraDeConstruccionesTerran;
import vista.auxiliares.jugador.DisplayRecursos;

import javax.swing.*;
import java.awt.*;

public class VentanaJugadorTerran extends VentanaJugador {

    private JugadorTerran jugador;

    // Metodos -------------------------

    public VentanaJugadorTerran(JugadorTerran j){
        this.jugador = j;
        super.init();

    }


    @Override
    protected void crearPanelRecursos(){
        super.crearPanelRecursos();
        this.panelRecursos.add( new DisplayRecursos(jugador.getRecursos(), jugador.getSuministros() ));
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

        CreadorDeMapa creador = new CreadorDeMapa(2);

        VentanaJugador ventanaJugador = new VentanaJugadorTerran(new JugadorTerran());

        ventanaJugador.pack();
        ventanaJugador.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        ventanaJugador.setExtendedState(JFrame.MAXIMIZED_BOTH);
        ventanaJugador.setVisible(true);

    }

}
