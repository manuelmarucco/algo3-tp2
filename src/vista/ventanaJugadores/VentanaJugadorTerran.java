package vista.ventanaJugadores;

import jugabilidad.Juego;
import jugabilidad.Jugador;
import jugabilidad.RazaDeJugador.JugadorTerran;
import jugabilidad.extrasJuego.CreadorDeMapa;
import jugabilidad.utilidadesMapa.Coordenada;
import vista.VentanaJuego;
import vista.auxiliares.jugador.BotoneraDeConstruccionesTerran;
import vista.auxiliares.jugador.DisplayRecursos;

import javax.swing.*;

public class VentanaJugadorTerran extends VentanaJugador {

    private JugadorTerran jugador;

    // Metodos -------------------------

    public VentanaJugadorTerran(JugadorTerran jugador, VentanaJuego ventanaJuego,Coordenada coordenadaDeBase){
        this.ventanaJuego = ventanaJuego;
        this.jugador = jugador;
        this.coordenadaDeBase = coordenadaDeBase;
        super.init();
        this.setTitle(jugador.getNombre());

    }


    @Override
    protected void crearPanelSuperior(){
        super.crearPanelSuperior();
        this.panelSuperior.add( new DisplayRecursos(jugador.getRecursos(), jugador.getSuministros() ));
    }

    @Override
    protected void crearPanelInferior(){
        super.crearPanelInferior();

        DisplayConstrucciones botoneraConstrucciones = new DisplayConstrucciones();
        botoneraConstrucciones.agregarBotonera(new BotoneraDeConstruccionesTerran(jugador, accionConstruirEnEspera));

        this.panelInferior.add(botoneraConstrucciones,"West");
    }

    @Override
    public Jugador obtenerJugador(){
        return (this.jugador);
    }

    // Main ---------------------------

    public static void main(String[] args){

        CreadorDeMapa creador = new CreadorDeMapa(2);
        VentanaJuego ventanaJuego = new VentanaJuego(new Juego(2));
        VentanaJugador ventanaJugador = new VentanaJugadorTerran(new JugadorTerran(), ventanaJuego, new Coordenada(10,10));

        ventanaJugador.pack();
        ventanaJugador.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        ventanaJugador.setExtendedState(JFrame.MAXIMIZED_BOTH);
        ventanaJugador.setVisible(true);

    }

}
