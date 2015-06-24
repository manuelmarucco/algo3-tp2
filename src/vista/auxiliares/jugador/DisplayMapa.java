package vista.auxiliares.jugador;

import control.vistaMapa.ControladorDeVistaMapa;
import control.vistaMapa.ObservadorMapa;
import jugabilidad.Juego;
import jugabilidad.Jugador;
import jugabilidad.RazaDeJugador.JugadorProtoss;
import jugabilidad.RazaDeJugador.JugadorTerran;
import jugabilidad.extrasJuego.CreadorDeMapa;
import jugabilidad.utilidadesMapa.Coordenadas;
import vista.ParselaAccionable;
import vista.VentanaJuego;
import vista.auxiliares.ImagePanel;
import vista.ventanaJugadores.VentanaJugador;
import vista.ventanaJugadores.VentanaJugadorProtoss;
import vista.ventanaJugadores.VentanaJugadorTerran;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class DisplayMapa extends JPanel {
    // Si se saca el main va a tener que heredar de JPanel

    private int cantidadTilesVerticales, cantidadTilesHorizontales;
    private JLayeredPane panel;
    private ControladorDeVistaMapa controlador;
    private VentanaJugador ventana;
    /*
    public static void main(String[] args){
        Juego juego = new Juego(2);
        JugadorProtoss jugador = juego.crearJugadorProtoss("nombre", "color");

        DisplayMapa displayMapa = new DisplayMapa();

        displayMapa.ventana = new VentanaJugadorProtoss(jugador,new VentanaJuego(juego));

        displayMapa.pack();
        displayMapa.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        displayMapa.setExtendedState(JFrame.MAXIMIZED_BOTH);
        displayMapa.setVisible(true);

    }
    */


    // Metodos -----

    public DisplayMapa(){

        this.controlador = new ControladorDeVistaMapa();
        this.init();

    }

    public DisplayMapa(VentanaJugador ventana){

        ObservadorMapa.getInstance().agregarDisplay(this);
        this.ventana = ventana;
        this.controlador = new ControladorDeVistaMapa();
        this.init();

    }

    public void actualizarDisplayMapa(){

        this.panel.removeAll();
        this.armarPaneles();

        this.add(this.panel);

    }

    private void init(){

        this.cantidadTilesHorizontales = 25 ;
        this.cantidadTilesVerticales = 25;

        this.panel = new JLayeredPane();
        this.panel.setPreferredSize(new Dimension(1600, 1600));
        this.panel.setVisible(true);

        this.armarPaneles();

        this.add(this.panel);
    }

    private void armarPaneles(){
        ArrayList<JPanel> paneles = new ArrayList<>();

        paneles.add(controlador.armarPanelAccionable(this.cantidadTilesHorizontales, this.cantidadTilesVerticales, this.ventana));
        paneles.add(controlador.armarPanelDeVisionDisponible(this.cantidadTilesHorizontales, this.cantidadTilesVerticales, this.ventana.obtenerJugador() ));
        paneles.add(controlador.armarPanelAereo(this.cantidadTilesHorizontales, this.cantidadTilesVerticales, this.ventana));
        paneles.add(controlador.armarPanelDeRecursos(this.cantidadTilesHorizontales, this.cantidadTilesVerticales, this.ventana));
        paneles.add(controlador.armarPanelTerrestre(this.cantidadTilesHorizontales, this.cantidadTilesVerticales, this.ventana));

        this.agregarPaneles(paneles);

    }

    private void agregarPaneles(ArrayList<JPanel> paneles){

        for (JPanel panel : paneles){

            this.panel.add(panel);

        }

        //this.panel.add(panelTerrestre, 1,0);
        //this.panel.add(panelDeRecursos, 2,0);
        //this.panel.add(panelAereo, 3,0);
        ///this.panel.add(panelAccionable, 0,0);

    }


}
