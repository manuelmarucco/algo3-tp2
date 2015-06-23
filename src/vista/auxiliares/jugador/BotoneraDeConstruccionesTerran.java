package vista.auxiliares.jugador;

import jugabilidad.RazaDeJugador.JugadorTerran;
import vista.Actions.WraperAccionConstruir;
import vista.Actions.accionesConstruir.AccionConstruirEdificiosTerran.*;

import javax.swing.*;
import java.awt.*;

public class BotoneraDeConstruccionesTerran extends JPanel {

    private JugadorTerran jugador;
    private WraperAccionConstruir accionConstruirEnEspera;

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

    public BotoneraDeConstruccionesTerran(JugadorTerran jugador, WraperAccionConstruir accionConstruirEnEspera){
        this.jugador = jugador;
        this.accionConstruirEnEspera=accionConstruirEnEspera;
        this.init();

    }

    private void init(){

        this.panel = new JPanel( new GridLayout(2,3,10,10));

        this.crearBotones();
        this.agregarBotonesAlPanel();

        this.add(this.panel);

    }

    private void crearBotones(){

        this.botonCentroDeMineral = this.crearBoton("Centro de mineral" );
        this.botonCentroDeMineral.addActionListener(new AccionConstruirCentroDeMineral(jugador,accionConstruirEnEspera));

        this.botonRefineria = this.crearBoton("Refineria");
        this.botonRefineria.addActionListener(new AccionConstruirRefineria(jugador,accionConstruirEnEspera));

        this.botonDepositoDeSuministros = this.crearBoton("Deposito De Suministros");
        this.botonDepositoDeSuministros.addActionListener(new AccionConstruirDepositoDeSuministros(jugador,accionConstruirEnEspera));

        this.botonBarraca = this.crearBoton("Barraca");
        this.botonBarraca.addActionListener(new AccionConstruirBarraca(jugador,accionConstruirEnEspera));

        this.botonFabrica = this.crearBoton("Fabrica");
        this.botonFabrica.addActionListener(new AccionConstruirFabrica(jugador,accionConstruirEnEspera));

        this.botonPuertoEstelar = this.crearBoton("Puerto Estelar" );
        this.botonPuertoEstelar.addActionListener(new AccionConstruirPuertoEstelar(jugador,accionConstruirEnEspera));

    }

    private JButton crearBoton( String nombre ){

        JButton boton = new JButton();
        boton.setText(nombre);

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

    public JugadorTerran getJugador() {
        return jugador;
    }
}
