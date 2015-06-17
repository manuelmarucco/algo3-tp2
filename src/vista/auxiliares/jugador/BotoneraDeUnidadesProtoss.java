package vista.auxiliares.jugador;

import javax.swing.*;
import java.awt.*;

public class BotoneraDeUnidadesProtoss extends JPanel {

    // Atributos ---------------------

    private JPanel panel;

    private JButton botonZealot;
    private JButton botonDragon;
    private JButton botonScout;
    private JButton botonAltoTemplario;
    private JButton botonNaveTransporte;

    // Main ---------------------------
    /*
    public static void main(String[] args){

        BotoneraDeUnidadesTerran botonera = new BotoneraDeUnidadesTerran();

        botonera.setVisible(true);

    }
    */
    // Metodos -------------------------

    public BotoneraDeUnidadesProtoss(){

        this.init();

    }

    private void init(){

        this.panel = new JPanel( new GridLayout(2,3,1,1));

        this.crearBotones();
        this.agregarBotonesAlPanel();

        this.add(this.panel);

    }

    private void crearBotones(){

        this.botonZealot = this.crearBoton("Zealot" );
        this.botonDragon = this.crearBoton("Dragon");
        this.botonScout = this.crearBoton("Scout");
        this.botonAltoTemplario = this.crearBoton("Alto Templario");
        this.botonNaveTransporte = this.crearBoton("Nave Transporte");

    }

    private JButton crearBoton( String nombre ){

        JButton boton = new JButton();
        boton.setText(nombre);
        boton.setSize(90,30);

        return boton;

    }

    private void agregarBotonesAlPanel(){

        this.panel.add(this.botonZealot);
        this.panel.add(this.botonDragon);
        this.panel.add(this.botonScout);
        this.panel.add(this.botonAltoTemplario);
        this.panel.add(this.botonNaveTransporte);

    }
}