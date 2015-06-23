package vista.ventanaJugadores;

import jugabilidad.Juego;
import jugabilidad.RazaDeJugador.JugadorTerran;
import jugabilidad.extrasJuego.CreadorDeMapa;
import vista.VentanaJuego;
import vista.auxiliares.jugador.BotoneraDeConstruccionesTerran;
import vista.auxiliares.jugador.DisplayRecursos;

import javax.swing.*;
import java.awt.*;

public class VentanaJugadorTerran extends VentanaJugador {

    private JugadorTerran jugador;

    // Metodos -------------------------

    public VentanaJugadorTerran(JugadorTerran jugador, VentanaJuego ventanaJuego){
        this.ventanaJuego = ventanaJuego;
        this.jugador = jugador;
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
        VentanaJuego ventanaJuego = new VentanaJuego(new Juego());
        VentanaJugador ventanaJugador = new VentanaJugadorTerran(new JugadorTerran(), ventanaJuego);

        ventanaJugador.pack();
        ventanaJugador.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        ventanaJugador.setExtendedState(JFrame.MAXIMIZED_BOTH);
        ventanaJugador.setVisible(true);

    }

}
