package vista.auxiliares.jugador;

import control.vistaMapa.ControladorDeVistaMapa;
import jugabilidad.extrasJuego.CreadorDeMapa;
import jugabilidad.utilidadesMapa.Coordenadas;
import vista.Vistas;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class DisplayMapa extends JFrame {
    // Si se saca el main va a tener que heredar de JPanel

    private int cantidadTilesVerticales, cantidadTilesHorizontales;
    private JPanel panel;
    private ControladorDeVistaMapa controlador;

    public static void main(String[] args){

        // Esto esta para ver si funciona.
        // El creador de mapa es para que inicialize el proxy.
        CreadorDeMapa creador = new CreadorDeMapa(2);

        DisplayMapa displayMapa = new DisplayMapa();

        displayMapa.pack();
        displayMapa.setExtendedState(JFrame.MAXIMIZED_BOTH);
        displayMapa.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        displayMapa.setVisible(true);

    }

    // Metodos -----

    public DisplayMapa(){

        this.controlador = new ControladorDeVistaMapa();
        this.init();

    }

    private void init(){

        this.cantidadTilesHorizontales = 25 ; // En cantidad de tiles.
        this.cantidadTilesVerticales = 25; // En cantidad de tiles.

        this.panel = new JPanel(new GridLayout(this.cantidadTilesHorizontales,this.cantidadTilesVerticales,0,0));
        this.agregarContenidoAlPanel();

        this.add(panel);

    }

    private void agregarContenidoAlPanel(){

        for (int j = 0; j < this.cantidadTilesHorizontales; j++ ){

            for (int i = 0; i < this.cantidadTilesVerticales; i++){

                // Para ver si funciona pinto la capa terrestre deberia dibujar el pasto y las rocas.
                // Los numero sumados/restados es para que empiece a dibujar desde arriba a la izquierda hacia abajo a
                // la derecha.

                Coordenadas coordenadas = new Coordenadas( i + 1, 25 - j );
                JPanel vista = this.controlador.getVistaTerrestreEnPosicion(coordenadas);

                this.add(vista);

            }

        }

    }

}
