package vista.ventanaJugadores;

import jugabilidad.Jugador;
import jugabilidad.RazaDeJugador.JugadorProtoss;
import jugabilidad.utilidadesMapa.Coordenada;
import vista.VentanaJuego;
import vista.auxiliares.jugador.BotoneraDeConstruccionesProtoss;
import vista.auxiliares.jugador.displays.DisplayConstrucciones;
import vista.auxiliares.jugador.displays.DisplayRecursos;

import javax.swing.*;

public class VentanaJugadorProtoss extends VentanaJugador {

    private JugadorProtoss jugador;

    // Metodos -------------------------


    public VentanaJugadorProtoss(JugadorProtoss jugador, VentanaJuego ventanaJuego,Coordenada coordenadaDeBase){
        this.ventanaJuego = ventanaJuego;
        this.jugador = jugador;
        this.coordenadaDeBase = coordenadaDeBase;
        super.init();

        this.setTitle(jugador.getNombre());
    }

    @Override
    protected JPanel crearPanelSuperior(){
        JPanel panelSuperior = super.crearPanelSuperior();
        panelSuperior.add( new DisplayRecursos(jugador.getRecursos(), jugador.getSuministros() ));
        return panelSuperior;
    }

    @Override
    protected JPanel crearPanelInferior(){
        JPanel panelInferior = super.crearPanelInferior();

        DisplayConstrucciones botoneraConstrucciones = new DisplayConstrucciones();
        botoneraConstrucciones.agregarBotonera(new BotoneraDeConstruccionesProtoss(jugador, accionConstruirEnEspera));

        panelInferior.add(botoneraConstrucciones,"West");

        return panelInferior;
    }

    @Override
    public Jugador obtenerJugador(){
        return (this.jugador);
    }

    // Main ---------------------------
/*
    public static void main(String[] args){
        // Para que se vean los recursos en testeo. despues borrar
        // Mini test
        ProxyMapa.resetear();
        CreadorDeMapa creador = new CreadorDeMapa(2);
        /*
        ProxyMapa proxyMapa = creador.obtenerProxyMapa();
        Vision vision = Vision.VisionCompleta(6,6);
        Marine marine = new Marine(vision);

        NaveCiencia nave = new NaveCiencia();

        try {
            proxyMapa.agregar(marine, new Coordenada(7,8));
            proxyMapa.agregar(nave, new Coordenada(8,8));
        } catch (ExcepcionNoSePudoAgregarAlMapa excepcionNoSePudoAgregarAlMapa) {
            excepcionNoSePudoAgregarAlMapa.printStackTrace();
        }
        *//*
        // Mini test fin
        VentanaJuego ventanaJuego = new VentanaJuego(new Juego(2));
        JugadorProtoss jugador = new JugadorProtoss();
        ventanaJuego.getJuego().crearJugadorProtoss("pepe","rojo");
        VentanaJugador ventanaJugador = new VentanaJugadorProtoss(jugador,ventanaJuego,new Coordenada(10,10));

        ventanaJugador.pack();
        ventanaJugador.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        ventanaJugador.setExtendedState(JFrame.MAXIMIZED_BOTH);
        ventanaJugador.setVisible(true);

    }
*/
}
