package vista;

import modelo.jugabilidad.Juego;
import modelo.jugabilidad.Jugador;
import vista.ventanaJugadores.VentanaGanador;
import vista.ventanaJugadores.VentanaJugador;

import javax.swing.*;
import java.util.ArrayList;

public class VentanaJuego {
    private ArrayList<VentanaJugador> ventanasDeJugadores = new ArrayList<>();
    private Juego juego;
    private VentanaJugador ventanaJugadorActual;
    private int iterador;
    private boolean GanoAlguien=false;

    public VentanaJuego(Juego juego){
        this.juego = juego;
        this.iterador = 0;
    }

    public void pasarTurno() {
        this.determinarSiHayGanador();
        if(ventanasDeJugadores.size() == 0) return;
        
        this.juego.update();

        this.desactivarVentanaJugadorActual();
        if(!this.GanoAlguien)
            this.activarVentanaJugadorSiguiente();
        
    }

    private void determinarSiHayGanador() {
        Jugador ganador = juego.getJugadorGanador();
        if(ganador!= null){
            new VentanaGanador(this,ganador.getNombre());
            this.GanoAlguien=true;
        }
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

    public void cerrarVentanas(){
        for(JFrame ventana: ventanasDeJugadores){
            ventana.dispose();
        }

    }
}
