package vista.auxiliares.jugador;

import javax.swing.*;
import java.awt.*;

public class BotoneraDeConstruccionesTerran extends JPanel {

    // Atributos ---------------------

    private JPanel panel;

    private JButton botonCentroDeMineral;
    private JButton botonRefineria;
    private JButton botonDepositoDeSuministros;
    private JButton botonBarraca;
    private JButton botonFabrica;
    private JButton botonPuertoEstelar;

    // Main ---------------------------
    /*
    public static void main(String[] args){

        BotoneraDeConstruccionesTerran botonera = new BotoneraDeConstruccionesTerran();

        botonera.setVisible(true);

    }
    */
    // Metodos -------------------------

    public BotoneraDeConstruccionesTerran(){

        this.init();

    }

    private void init(){

        this.panel = new JPanel( new GridLayout(3,2,1,1));

        this.crearBotones();
        this.agregarBotonesAlPanel();

        this.add(this.panel);

    }

    private void crearBotones(){

        this.botonCentroDeMineral = this.crearBoton("Centro de mineral" );
        this.botonRefineria = this.crearBoton("Refineria");
        this.botonDepositoDeSuministros = this.crearBoton("Deposito De Suministros");
        this.botonBarraca = this.crearBoton("Barraca");
        this.botonFabrica = this.crearBoton("Fabrica");
        this.botonPuertoEstelar = this.crearBoton("Puerto Estelar" );

    }

    private JButton crearBoton( String nombre ){

        JButton boton = new JButton();
        boton.setText(nombre);
        boton.setSize(90,30);

        return boton;

    }

    private void agregarBotonesAlPanel(){

        this.panel.add(botonCentroDeMineral);
        this.panel.add(botonRefineria);
        this.panel.add(botonBarraca);
        this.panel.add(botonDepositoDeSuministros);
        this.panel.add(botonFabrica);
        this.panel.add(botonPuertoEstelar);

    }

}
