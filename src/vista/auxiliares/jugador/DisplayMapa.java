package vista.auxiliares.jugador;

import control.vistaMapa.ControladorDeVistaMapa;
import jugabilidad.utilidadesMapa.Coordenadas;
import vista.ParselaAccionable;
import vista.auxiliares.ImagePanel;
import vista.ventanaJugadores.VentanaJugador;

import javax.swing.*;
import java.awt.*;

public class DisplayMapa extends JPanel {
    // Si se saca el main va a tener que heredar de JPanel

    private int cantidadTilesVerticales, cantidadTilesHorizontales;
    private JLayeredPane panel;
    private ControladorDeVistaMapa controlador;
    private VentanaJugador ventana;
    /*
    public static void main(String[] args){
        CreadorDeMapa creador = new CreadorDeMapa(2);

        DisplayMapa displayMapa = new DisplayMapa();

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

        this.ventana = ventana;
        this.controlador = new ControladorDeVistaMapa();
        this.init();

    }

    public void actualizarDisplayMapa(){

        this.panel = new JLayeredPane();
        this.panel.setPreferredSize(new Dimension(1600, 1600));
        this.panel.setVisible(true);

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

        this.armarPanelTerrestre();
        this.armarPanelDeRecursos();
        this.armarPanelAereo();
        this.armarPanelAccionable();

    }

    private void armarPanelTerrestre(){

        JPanel panelTerrestre = new JPanel(new GridLayout(25,25));
        panelTerrestre.setPreferredSize(new Dimension(1600, 1600));
        panelTerrestre.setBounds(0, 0, 25 * 64, 25 * 64);
        panelTerrestre.setOpaque(false);

        for (int j = 0; j < this.cantidadTilesHorizontales; j++ ){

            for (int i = 0; i < this.cantidadTilesVerticales; i++){

                Coordenadas coordenadas = new Coordenadas( i + 1, this.cantidadTilesHorizontales - j );
                JPanel vista = this.controlador.getVistaTerrestreEnPosicion(coordenadas, this.ventana);
                panelTerrestre.add(vista);

            }

        }

        this.panel.add(panelTerrestre, 1,0);

    }

    private void armarPanelDeRecursos(){

        JPanel panelDeRecursos = new JPanel(new GridLayout(25,25));
        panelDeRecursos.setPreferredSize(new Dimension(1600,1600));
        panelDeRecursos.setBounds(0,0,1600,1600);
        panelDeRecursos.setOpaque(false);

        for (int j = 0; j < this.cantidadTilesHorizontales; j++ ){

            for (int i = 0; i < this.cantidadTilesVerticales; i++){

                Coordenadas coordenadas = new Coordenadas( i + 1, this.cantidadTilesHorizontales - j );
                ImagePanel vista = (ImagePanel) this.controlador.getVistaRecursosEnPosicion(coordenadas, this.ventana);

                vista.setOpaque(false);
                panelDeRecursos.add(vista);

            }

        }

        this.panel.add(panelDeRecursos, 2,0);

    }

    private void armarPanelAereo(){

        JPanel panelAereo = new JPanel(new GridLayout(25,25));
        panelAereo.setPreferredSize(new Dimension(1600,1600));
        panelAereo.setBounds(0,0,1600,1600);
        panelAereo.setOpaque(false);

        for (int j = 0; j < this.cantidadTilesHorizontales; j++ ){

            for (int i = 0; i < this.cantidadTilesVerticales; i++){

                Coordenadas coordenadas = new Coordenadas( i + 1, this.cantidadTilesHorizontales - j );
                ImagePanel vista = (ImagePanel) this.controlador.getVistaAereaEnPosicion(coordenadas, this.ventana);
                vista.setOpaque(false);
                panelAereo.add(vista);

            }

        }

        this.panel.add(panelAereo, 0,0);

    }

    private void armarPanelAccionable(){

        JPanel panelAccionable = new JPanel(new GridLayout(25,25));
        panelAccionable.setPreferredSize(new Dimension(1600,1600));
        panelAccionable.setBounds(0,0,1600,1600);
        panelAccionable.setBackground(new Color(0,0,0,0));
        panelAccionable.setOpaque(false);

        for (int j = 0; j < this.cantidadTilesHorizontales; j++ ) {

            for (int i = 0; i < this.cantidadTilesVerticales; i++) {

                JPanel parsela = new JPanel();
                parsela.setBackground(new Color(0, 0, 0, 0));
                Coordenadas coordenadas = new Coordenadas(i + 1, this.cantidadTilesHorizontales - j);

                parsela.addMouseListener(new ParselaAccionable(ventana, coordenadas));

                panelAccionable.add(parsela);

            }

        }

        this.panel.add(panelAccionable, 0,0);

    }


}
