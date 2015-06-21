package vista.ventanaJugadores;

import jugabilidad.RazaDeJugador.JugadorProtoss;
import vista.auxiliares.jugador.BotoneraDeConstruccionesProtoss;
import vista.auxiliares.jugador.DisplayRecursos;

import javax.swing.*;
import java.awt.*;

public class VentanaJugadorProtoss extends VentanaJugador {

    private JugadorProtoss jugador;

    // Metodos -------------------------

    public VentanaJugadorProtoss(){
        super.init();
    }

    public VentanaJugadorProtoss(JugadorProtoss jugador){
        super.init();
        this.jugador = jugador;
    }

    @Override
    protected void crearPanelRecursos(){
        super.crearPanelRecursos();
//        this.panelRecursos.add( new DisplayRecursos() );
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
        botoneraConstrucciones.add(new BotoneraDeConstruccionesProtoss());

        this.panelInferior.add(botoneraConstrucciones,"West");
    }
    // Main ---------------------------

    public static void main(String[] args){
        VentanaJugador ventanaJugador = new VentanaJugadorProtoss(new JugadorProtoss());

        ventanaJugador.pack();
        ventanaJugador.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        ventanaJugador.setExtendedState(JFrame.MAXIMIZED_BOTH);
        ventanaJugador.setVisible(true);

    }

}
