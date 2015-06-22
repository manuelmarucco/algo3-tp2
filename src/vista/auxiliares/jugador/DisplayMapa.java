package vista.auxiliares.jugador;

import control.vistaMapa.ControladorDeVistaMapa;
import jugabilidad.extrasJuego.CreadorDeMapa;
import jugabilidad.utilidadesMapa.Coordenadas;
import vista.auxiliares.ImagePanel;

import javax.swing.*;
import java.awt.*;

public class DisplayMapa extends JPanel {
    // Si se saca el main va a tener que heredar de JPanel

    private int cantidadTilesVerticales, cantidadTilesHorizontales;
    private JLayeredPane panel;
    private ControladorDeVistaMapa controlador;
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

    private void init(){

        this.cantidadTilesHorizontales = 25 ; // En cantidad de tiles.
        this.cantidadTilesVerticales = 25; // En cantidad de tiles.

        this.panel = new JLayeredPane();
        this.panel.setPreferredSize(new Dimension(1600,1600));
        this.panel.setVisible(true);

        this.armarPaneles();

        this.add(this.panel);
    }

    private void armarPaneles(){

        this.armarPanelTerrestre();
        this.armarPanelDeRecursos();
        this.armarPanelAereo();

    }

    private void armarPanelTerrestre(){

        JPanel panelTerrestre = new JPanel(new GridLayout(25,25));
        panelTerrestre.setPreferredSize(new Dimension(1600,1600));
        panelTerrestre.setBounds(0,0,25*64,25*64);

        for (int j = 0; j < this.cantidadTilesHorizontales; j++ ){

            for (int i = 0; i < this.cantidadTilesVerticales; i++){

                Coordenadas coordenadas = new Coordenadas( i + 1, 25 - j );
                JPanel vista = this.controlador.getVistaTerrestreEnPosicion(coordenadas);

                panelTerrestre.add(vista);

            }

        }

        this.panel.add(panelTerrestre, new Integer(1),1);

    }

    private void armarPanelDeRecursos(){

        JPanel panelDeRecursos = new JPanel(new GridLayout(25,25));
        panelDeRecursos.setPreferredSize(new Dimension(1600,1600));
        panelDeRecursos.setBounds(0,0,1600,1600);
        panelDeRecursos.setOpaque(false);

        for (int j = 0; j < this.cantidadTilesHorizontales; j++ ){

            for (int i = 0; i < this.cantidadTilesVerticales; i++){

                Coordenadas coordenadas = new Coordenadas( i + 1, 25 - j );
                ImagePanel vista = (ImagePanel) this.controlador.getVistaRecursosEnPosicion(coordenadas);

                panelDeRecursos.add(vista);

            }

        }

        this.panel.add(panelDeRecursos, new Integer(2),2);

    }

    private void armarPanelAereo(){

        JPanel panelAereo = new JPanel(new GridLayout(25,25));
        panelAereo.setPreferredSize(new Dimension(1600,1600));
       // panelAereo.setBounds(0,0,25*64,25*64);

        for (int j = 0; j < this.cantidadTilesHorizontales; j++ ){

            for (int i = 0; i < this.cantidadTilesVerticales; i++){

                Coordenadas coordenadas = new Coordenadas( i + 1, 25 - j );
                ImagePanel vista = (ImagePanel) this.controlador.getVistaTerrestreEnPosicion(coordenadas);

                panelAereo.add(vista);

            }

        }

        this.panel.add(panelAereo, new Integer(3),3);

    }

}
