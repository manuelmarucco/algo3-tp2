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

    // Metodos -----

    public DisplayMapa(){

        this.controlador = new ControladorDeVistaMapa();
        this.init();

    }

    private void init(){

        this.cantidadTilesHorizontales = 25 ; // En cantidad de tiles.
        this.cantidadTilesVerticales = 25; // En cantidad de tiles.

        this.panel = new JLayeredPane();
        this.armarPaneles();

        this.add(panel);

    }

    private void armarPaneles(){

        this.panel = new JLayeredPane() ;

        this.armarPanelTerrestre();
        this.armarPanelDeRecursos();
        this.armarPanelAereo();

    }

    private void armarPanelTerrestre(){

        JPanel panelTerrestre = new JPanel(new GridLayout());

        for (int j = 0; j < this.cantidadTilesHorizontales; j++ ){

            for (int i = 0; i < this.cantidadTilesVerticales; i++){

                Coordenadas coordenadas = new Coordenadas( i + 1, 25 - j );
                ImagePanel vista = (ImagePanel) this.controlador.getVistaTerrestreEnPosicion(coordenadas);

                panelTerrestre.add(vista);

            }

        }

        this.panel.add(panelTerrestre);

    }

    private void armarPanelDeRecursos(){

        JPanel panelDeRecursos = new JPanel(new GridLayout());

        for (int j = 0; j < this.cantidadTilesHorizontales; j++ ){

            for (int i = 0; i < this.cantidadTilesVerticales; i++){

                Coordenadas coordenadas = new Coordenadas( i + 1, 25 - j );
                ImagePanel vista = (ImagePanel) this.controlador.getVistaTerrestreEnPosicion(coordenadas);

                panelDeRecursos.add(vista);

            }

        }

        this.panel.add(panelDeRecursos);

    }

    private void armarPanelAereo(){

        JPanel panelAereo = new JPanel(new GridLayout());

        for (int j = 0; j < this.cantidadTilesHorizontales; j++ ){

            for (int i = 0; i < this.cantidadTilesVerticales; i++){

                Coordenadas coordenadas = new Coordenadas( i + 1, 25 - j );
                ImagePanel vista = (ImagePanel) this.controlador.getVistaTerrestreEnPosicion(coordenadas);

                panelAereo.add(vista);

            }

        }

        this.panel.add(panelAereo);

    }

}
