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

        this.desactivarVentanaJugadorActual();
        this.activarVentanaJugadorSiguiente();
        
    }

    private void activarVentanaJugadorSiguiente() {
        this.actualizarIterador();
        ventanaJugadorActual = ventanasDeJugadores.get(iterador);
        this.setearParametrosDeVentana(ventanaJugadorActual);
    }

    private void actualizarIterador(){
        iterador++;
        if(iterador == ventanasDeJugadores.size()) iterador=0;
    }

    private void desactivarVentanaJugadorActual() {
        ventanaJugadorActual.setVisible(false);
        ventanaJugadorActual.desactivarMusica();
    }

    public void agregarVentana(VentanaJugador ventana) {
        ventanasDeJugadores.add(ventana);
        if (ventanasDeJugadores.size() == 1) {
            ventanaJugadorActual = ventanasDeJugadores.get(0);
            ventanaJugadorActual.activarMusica();
            this.setearParametrosDeVentana(ventanaJugadorActual);
        }
    }

    public Juego getJuego() {
        return juego;
    }

    public void setearParametrosDeVentana(VentanaJugador ventana) {
        ventana.reactivarSonido();
        ventana.setVisible(true);
        ventana.pack();
        ventana.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        ventana.setExtendedState(JFrame.MAXIMIZED_BOTH);
    }

    public VentanaJugador getVentanaJugadorActual(){
        return ventanaJugadorActual;
    }
}
