package vista.auxiliares.jugador;

import modelo.jugabilidad.RazaDeJugador.JugadorProtoss;
import vista.Actions.accionesConstruir.AccionConstruirEdificiosProtoss.*;
import vista.Actions.accionesVentanaJugador.WraperAccionConstruir;
import vista.auxiliares.jugador.botones.BotonConInformacionDesplegable;

import javax.swing.*;
import java.awt.*;

public class BotoneraDeConstruccionesProtoss extends JPanel {

    private JugadorProtoss jugador;
    private WraperAccionConstruir accionConstruirEnEspera;

    // Atributos ---------------------

    private JPanel panel;

    private BotonConInformacionDesplegable botonNexoMineral;
    private BotonConInformacionDesplegable botonAsimilador;
    private BotonConInformacionDesplegable botonPilon;
    private BotonConInformacionDesplegable botonAcceso;
    private BotonConInformacionDesplegable botonPortalEstelar;
    private BotonConInformacionDesplegable botonArchivosTemplarios;

    // Metodos -------------------------

    public BotoneraDeConstruccionesProtoss(JugadorProtoss jugador, WraperAccionConstruir accionConstruirEnEspera){
        this.jugador = jugador;
        this.accionConstruirEnEspera=accionConstruirEnEspera;
        this.init();

    }

    private void init(){

        this.panel = new JPanel( new GridLayout(2,3,10,10));
        this.panel.setOpaque(false);

        this.crearBotones();
        this.agregarBotonesAlPanel();

        this.add(this.panel);

    }

    private void crearBotones(){

        this.botonNexoMineral = this.crearBoton("Nexo Mineral", "50", "0" );
        this.botonNexoMineral.addActionListener(new AccionConstruirNexoMineral(jugador,accionConstruirEnEspera));

        this.botonAsimilador = this.crearBoton("Asimilador", "100", "0");
        this.botonAsimilador.addActionListener(new AccionConstruirAsimilador(jugador,accionConstruirEnEspera));

        this.botonPilon = this.crearBoton("Pilon", "100", "0");
        this.botonPilon.addActionListener(new AccionConstruirPilon(jugador,accionConstruirEnEspera));

        this.botonAcceso = this.crearBoton("Acceso", "150", "0");
        this.botonAcceso.addActionListener(new AccionConstruirAcceso(jugador,accionConstruirEnEspera));

        this.botonPortalEstelar= this.crearBoton("Portal Estelar", "150", "150");
        this.botonPortalEstelar.addActionListener(new AccionConstruirPortalEstelar(jugador,accionConstruirEnEspera));

        this.botonArchivosTemplarios = this.crearBoton("Archivos Templarios", "150", "200" );
        this.botonArchivosTemplarios.addActionListener(new AccionConstruirArchivosTemplarios(jugador,accionConstruirEnEspera));
    }

    private BotonConInformacionDesplegable crearBoton( String nombre, String mineralNecesario, String gasNecesario ){

        BotonConInformacionDesplegable boton = new BotonConInformacionDesplegable(nombre, mineralNecesario, gasNecesario);

        return boton;

    }

    private void agregarBotonesAlPanel(){

        this.panel.add(botonNexoMineral);
        this.panel.add(botonAsimilador);
        this.panel.add(botonPilon);
        this.panel.add(botonAcceso);
        this.panel.add(botonPortalEstelar);
        this.panel.add(botonArchivosTemplarios);

    }

//    public void setAccionConstruirEnEspera(AccionConstruir accion) {
  //      this.accionConstruirEnEspera = accion;
  //  }

    public JugadorProtoss getJugador() {
        return jugador;
    }
}