package vista.auxiliares.jugador;

import modelo.jugabilidad.RazaDeJugador.JugadorTerran;
import control.Actions.accionesConstruir.AccionConstruirEdificiosTerran.*;
import control.Actions.accionesVentanaJugador.WraperAccionConstruir;
import vista.auxiliares.jugador.botones.BotonConInformacionDesplegable;

import javax.swing.*;
import java.awt.*;

public class BotoneraDeConstruccionesTerran extends JPanel {

    private JugadorTerran jugador;
    private WraperAccionConstruir accionConstruirEnEspera;

    // Atributos ---------------------

    private JPanel contenedor;

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

        this.contenedor = new JPanel( new GridLayout(2,3,10,10));
        this.contenedor.setOpaque(false);
        this.crearBotones();
        this.agregarBotonesAlPanel();

        this.add(this.contenedor);

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

        this.contenedor.add(botonCentroDeMineral);
        this.contenedor.add(botonRefineria);
        this.contenedor.add(botonBarraca);
        this.contenedor.add(botonDepositoDeSuministros);
        this.contenedor.add(botonFabrica);
        this.contenedor.add(botonPuertoEstelar);

    }

    public JugadorTerran getJugador() {
        return jugador;
    }
}
