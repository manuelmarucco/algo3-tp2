package vista.auxiliares.jugador;

import jugabilidad.RazaDeJugador.JugadorTerran;
import vista.Actions.accionesConstruir.AccionConstruirEdificiosTerran.*;
import vista.Actions.accionesVentanaJugador.WraperAccionConstruir;
import vista.auxiliares.jugador.botones.BotonConInformacionDesplegable;

import javax.swing.*;
import java.awt.*;

public class BotoneraDeConstruccionesTerran extends JPanel {

    private JugadorTerran jugador;
    private WraperAccionConstruir accionConstruirEnEspera;

    // Atributos ---------------------

    private JPanel panel;

    private BotonConInformacionDesplegable botonCentroDeMineral;
    private BotonConInformacionDesplegable botonRefineria;
    private BotonConInformacionDesplegable botonDepositoDeSuministros;
    private BotonConInformacionDesplegable botonBarraca;
    private BotonConInformacionDesplegable botonFabrica;
    private BotonConInformacionDesplegable botonPuertoEstelar;

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

        this.botonCentroDeMineral = this.crearBoton("Centro de mineral", "50", "0");
        this.botonCentroDeMineral.addActionListener(new AccionConstruirCentroDeMineral(jugador,accionConstruirEnEspera));

        this.botonRefineria = this.crearBoton("Refineria", "100", "0");
        this.botonRefineria.addActionListener(new AccionConstruirRefineria(jugador,accionConstruirEnEspera));

        this.botonDepositoDeSuministros = this.crearBoton("Deposito De Suministros", "100", "0");
        this.botonDepositoDeSuministros.addActionListener(new AccionConstruirDepositoDeSuministros(jugador,accionConstruirEnEspera));

        this.botonBarraca = this.crearBoton("Barraca", "150", "0");
        this.botonBarraca.addActionListener(new AccionConstruirBarraca(jugador,accionConstruirEnEspera));

        this.botonFabrica = this.crearBoton("Fabrica", "200", "100");
        this.botonFabrica.addActionListener(new AccionConstruirFabrica(jugador,accionConstruirEnEspera));

        this.botonPuertoEstelar = this.crearBoton("Puerto Estelar" , "150", "100");
        this.botonPuertoEstelar.addActionListener(new AccionConstruirPuertoEstelar(jugador,accionConstruirEnEspera));

    }

    private BotonConInformacionDesplegable crearBoton( String nombre, String mineralNecesario, String gasNecesario ){

        BotonConInformacionDesplegable boton = new BotonConInformacionDesplegable(nombre, mineralNecesario, gasNecesario);

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
