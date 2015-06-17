package vista.auxiliares.jugador;

import javax.swing.*;
import java.awt.*;

public class BotoneraDeConstruccionesProtoss extends JPanel {

    // Atributos ---------------------

    private JPanel panel;

    private JButton botonNexoMineral;
    private JButton botonAsimilador;
    private JButton botonPilon;
    private JButton botonAcceso;
    private JButton botonPuertoEstelar;
    private JButton botonArchivosTemplarios;

    // Metodos -------------------------

    public BotoneraDeConstruccionesProtoss(){

        this.init();

    }

    private void init(){

        this.panel = new JPanel( new GridLayout(2,3,1,1));

        this.crearBotones();
        this.agregarBotonesAlPanel();

        this.add(this.panel);

    }

    private void crearBotones(){

        this.botonNexoMineral = this.crearBoton("Nexo Mineral" );
        this.botonAsimilador = this.crearBoton("Asimilador");
        this.botonPilon = this.crearBoton("Pilon");
        this.botonAcceso = this.crearBoton("Acceso");
        this.botonPuertoEstelar = this.crearBoton("Puerto Estelar");
        this.botonArchivosTemplarios = this.crearBoton("Archivos Templarios" );

    }

    private JButton crearBoton( String nombre ){

        JButton boton = new JButton();
        boton.setText(nombre);
        boton.setSize(90,30);

        return boton;

    }

    private void agregarBotonesAlPanel(){

        this.panel.add(botonNexoMineral);
        this.panel.add(botonAsimilador);
        this.panel.add(botonPilon);
        this.panel.add(botonAcceso);
        this.panel.add(botonPuertoEstelar);
        this.panel.add(botonArchivosTemplarios);

    }

}