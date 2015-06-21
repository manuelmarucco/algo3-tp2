package vista.ventanaJugadores;

import jugabilidad.RazaDeJugador.JugadorProtoss;
import vista.auxiliares.jugador.BotoneraDeConstruccionesProtoss;

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

        VentanaJugador ventanaJugador = new VentanaJugadorProtoss();

        ventanaJugador.pack();
        ventanaJugador.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        ventanaJugador.setExtendedState(JFrame.MAXIMIZED_BOTH);
        ventanaJugador.setVisible(true);

    }

}
