package vista.auxiliares.jugador;

import jugabilidad.RazaDeJugador.JugadorProtoss;
import vista.Actions.WraperAccionConstruir;
import vista.Actions.accionesConstruir.AccionConstruirEdificiosProtoss.*;

import javax.swing.*;
import java.awt.*;

public class BotoneraDeConstruccionesProtoss extends JPanel {

    private JugadorProtoss jugador;
    private WraperAccionConstruir accionConstruirEnEspera;

    // Atributos ---------------------

    private JPanel panel;

    private JButton botonNexoMineral;
    private JButton botonAsimilador;
    private JButton botonPilon;
    private JButton botonAcceso;
    private JButton botonPortalEstelar;
    private JButton botonArchivosTemplarios;

    // Metodos -------------------------

    //TODO en la el actionListener del mapa tiene que estar esta linea
    //TODO  if(botonera.getAccionConstruirEnEspera() !=  null){
    //TODO          botonera.getAccionConstruirEnEspera().construirEn(mapa.getCoordenadaDeParsela());
    //TODO          return;
    //TODO  }
    //TODO hacer el try and catch en la sentencia de cosntruirEn de aca arriba para exportar la excepcion
    //TODO al panel de notificaciones
/*
    public BotoneraDeConstruccionesProtoss(JugadorProtoss j, ){
        this.jugador = j;
        this.init();

    }
    */
    public BotoneraDeConstruccionesProtoss(JugadorProtoss jugador, WraperAccionConstruir accionConstruirEnEspera){
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

        this.botonNexoMineral = this.crearBoton("Nexo Mineral" );
      //  this.botonNexoMineral.addActionListener(new AccionConstruirNexoMineral(this));
        this.botonNexoMineral.addActionListener(new AccionConstruirNexoMineral(jugador,accionConstruirEnEspera));

        this.botonAsimilador = this.crearBoton("Asimilador");
       // this.botonAsimilador .addActionListener(new AccionConstruirAsimilador(this));
        this.botonAsimilador.addActionListener(new AccionConstruirAsimilador(jugador,accionConstruirEnEspera));

        this.botonPilon = this.crearBoton("Pilon");
       // this.botonPilon.addActionListener(new AccionConstruirPilon(this));
        this.botonPilon.addActionListener(new AccionConstruirPilon(jugador,accionConstruirEnEspera));

        this.botonAcceso = this.crearBoton("Acceso");
       // this.botonAcceso .addActionListener(new AccionConstruirAcceso(this));
        this.botonAcceso.addActionListener(new AccionConstruirAcceso(jugador,accionConstruirEnEspera));

        this.botonPortalEstelar= this.crearBoton("Portal Estelar");
     //   this.botonPortalEstelar.addActionListener(new AccionConstruirPortalEstelar(this));
        this.botonPortalEstelar.addActionListener(new AccionConstruirPortalEstelar(jugador,accionConstruirEnEspera));

        this.botonArchivosTemplarios = this.crearBoton("Archivos Templarios" );
      //  this.botonArchivosTemplarios.addActionListener(new AccionConstruirArchivosTemplarios(this));
        this.botonArchivosTemplarios.addActionListener(new AccionConstruirArchivosTemplarios(jugador,accionConstruirEnEspera));
    }

    private JButton crearBoton( String nombre ){

        JButton boton = new JButton();
        boton.setText(nombre);

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