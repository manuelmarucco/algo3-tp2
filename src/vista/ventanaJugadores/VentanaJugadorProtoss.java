package vista.ventanaJugadores;

import excepciones.Mapa.ExcepcionNoSePudoAgregarAlMapa;
import jugabilidad.Juego;
import jugabilidad.ProxyMapa;
import jugabilidad.RazaDeJugador.JugadorProtoss;
import jugabilidad.auxiliares.Vision;
import jugabilidad.extrasJuego.CreadorDeMapa;
import jugabilidad.utilidadesMapa.Coordenadas;
import unidades.terrran.Marine;
import unidades.terrran.NaveCiencia;
import vista.VentanaJuego;
import vista.auxiliares.jugador.BotoneraDeConstruccionesProtoss;
import vista.auxiliares.jugador.DisplayRecursos;

import javax.swing.*;
import java.awt.*;

public class VentanaJugadorProtoss extends VentanaJugador {

    private JugadorProtoss jugador;

    // Metodos -------------------------


    public VentanaJugadorProtoss(JugadorProtoss jugador, VentanaJuego ventanaJuego){
        this.ventanaJuego = ventanaJuego;
        this.jugador = jugador;
        super.init();
        this.setTitle(jugador.getNombre());
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
       // botoneraConstrucciones.add(new BotoneraDeConstruccionesProtoss(jugador));
        botoneraConstrucciones.add(new BotoneraDeConstruccionesProtoss(jugador,accionConstruirEnEspera));

        this.panelInferior.add(botoneraConstrucciones,"West");
    }
    // Main ---------------------------

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
            proxyMapa.agregar(marine, new Coordenadas(7,8));
            proxyMapa.agregar(nave, new Coordenadas(8,8));
        } catch (ExcepcionNoSePudoAgregarAlMapa excepcionNoSePudoAgregarAlMapa) {
            excepcionNoSePudoAgregarAlMapa.printStackTrace();
        }
        */
        // Mini test fin
        VentanaJuego ventanaJuego = new VentanaJuego(new Juego(2));
        JugadorProtoss jugador = new JugadorProtoss();
        ventanaJuego.getJuego().crearJugadorProtoss("pepe","rojo");
        VentanaJugador ventanaJugador = new VentanaJugadorProtoss(jugador,ventanaJuego);

        ventanaJugador.pack();
        ventanaJugador.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        ventanaJugador.setExtendedState(JFrame.MAXIMIZED_BOTH);
        ventanaJugador.setVisible(true);

    }

    public JugadorProtoss getJugador(){
        return jugador;
    }

}
