package vista;

import jugabilidad.Juego;
import vista.ventanaJugadores.VentanaJugador;

import javax.swing.*;
import java.util.ArrayList;

public class VentanaJuego {
    private ArrayList<VentanaJugador> ventanasDeJugadores = new ArrayList<>();
    private Juego juego;
    private VentanaJugador ventanaJugadorActual;
    private int iterador;

    public VentanaJuego(Juego juego){
        this.juego = juego;
        this.iterador = 0;
    }

    public void pasarTurno() {
        if(ventanasDeJugadores.size() == 0) return; // TODO tirar excepcion
        
        this.juego.update();
        
        ventanaJugadorActual.setVisible(false);
        
        if(iterador == ventanasDeJugadores.size()) iterador=0;
        ventanaJugadorActual = ventanasDeJugadores.get(iterador);
        iterador++;
        
        ventanaJugadorActual.setVisible(true);
        ventanaJugadorActual.pack();
        ventanaJugadorActual.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        ventanaJugadorActual.setExtendedState(JFrame.MAXIMIZED_BOTH);
        
    }
    
    public void agregarVentana(VentanaJugador ventana) {
        ventanasDeJugadores.add(ventana);
        if (ventanasDeJugadores.size() == 1) {
            ventanaJugadorActual = ventanasDeJugadores.get(0);
            ventanaJugadorActual.setVisible(true);
            ventanaJugadorActual.pack();
            ventanaJugadorActual.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
            ventanaJugadorActual.setExtendedState(JFrame.MAXIMIZED_BOTH);
        }
    }

    public Juego getJuego() {
        return juego;
    }
}
