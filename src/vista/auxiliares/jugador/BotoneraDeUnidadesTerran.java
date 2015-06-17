package vista.auxiliares.jugador;

import javax.swing.*;
import java.awt.*;

public class BotoneraDeUnidadesTerran extends JFrame {
    // Atributos ---------------------

    private JPanel panel;

    private JButton botonMarine;
    private JButton botonGolliat;
    private JButton botonEspectro;
    private JButton botonNaveCiencia;
    private JButton botonNaveTransporte;

    // Main ---------------------------

    public static void main(String[] args){

        BotoneraDeUnidadesTerran botonera = new BotoneraDeUnidadesTerran();

        botonera.pack();
        botonera.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        botonera.setVisible(true);

    }

    // Metodos -------------------------

    public BotoneraDeUnidadesTerran(){

        this.init();

    }

    private void init(){

        this.panel = new JPanel( new GridLayout(3,2,1,1));

        this.crearBotones();
        this.agregarBotonesAlPanel();

        this.add(this.panel);

    }

    private void crearBotones(){

        this.botonMarine = this.crearBoton("Marine" );
        this.botonGolliat = this.crearBoton("Golliat");
        this.botonEspectro = this.crearBoton("Espectro");
        this.botonNaveCiencia = this.crearBoton("Nave Ciencia");
        this.botonNaveTransporte = this.crearBoton("Nave Transporte");

    }

    private JButton crearBoton( String nombre ){

        JButton boton = new JButton();
        boton.setText(nombre);
        boton.setSize(90,30);

        return boton;

    }

    private void agregarBotonesAlPanel(){

        this.panel.add(this.botonMarine);
        this.panel.add(this.botonGolliat);
        this.panel.add(this.botonEspectro);
        this.panel.add(this.botonNaveCiencia);
        this.panel.add(this.botonNaveTransporte);

    }
}
