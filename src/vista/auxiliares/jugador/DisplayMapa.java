package vista.auxiliares.jugador;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class DisplayMapa extends JPanel {

    private BufferedImage[] imagenes;
    private int cantidadTilesVerticales, cantidadTilesHorizontales;
    private JPanel panel;
    /*
    public static void main(String[] args){

        DisplayMapa mapa = new DisplayMapa();

        mapa.setVisible(true);

    }
    */
    // Metodos -----

    public DisplayMapa(){

        this.init();

    }

    private void init(){

        this.cantidadTilesHorizontales = 32 ; // En cantidad de tiles.
        this.cantidadTilesVerticales = 32; // En cantidad de tiles.
        this.cargarImagenes();

        this.panel = new JPanel(new GridLayout(this.cantidadTilesHorizontales,this.cantidadTilesVerticales,0,0));
        this.agregarContenidoAlPanel();

        this.add(panel);

    }

    private void cargarImagenes(){

        try{
            this.imagenes = new BufferedImage[1];
            this.imagenes[0] = ImageIO.read(getClass().getResource("imagenesMapa/pasto64x64.png"));
        } catch ( IOException e){
            e.printStackTrace();
        }

    }

    private void agregarContenidoAlPanel(){

        for (int i = 0; i < this.cantidadTilesHorizontales * this.cantidadTilesVerticales; i++ ){

            JLabel label = new JLabel(new ImageIcon( imagenes[0] ) );
            label.setSize(64,64);
            this.panel.add(label);

        }

    }

}
