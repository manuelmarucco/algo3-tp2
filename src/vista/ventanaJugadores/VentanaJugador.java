package vista.ventanaJugadores;

import jugabilidad.Jugador;
import jugabilidad.RazaDeJugador.JugadorTerran;
import jugabilidad.utilidadesMapa.Coordenada;
import vista.Actions.accionesConstruir.AccionConstruir;
import vista.Actions.accionesUnidades.AccionUnidad;
import vista.Actions.accionesVentanaJugador.WraperAccionActuar;
import vista.Actions.accionesVentanaJugador.WraperAccionConstruir;
import vista.VentanaJuego;
import vista.auxiliares.jugador.DisplayMapa;
import vista.auxiliares.jugador.DisplayNotificaciones;
import vista.auxiliares.jugador.PanelAcciones;
import vista.auxiliares.jugador.PanelTerminarTurno;
import vista.sonido.Sound;

import javax.swing.*;
import java.awt.*;

public abstract class VentanaJugador extends JFrame {

    // Atributos --------------------- //TODO creo q tiene muchos atributos
    protected VentanaJuego ventanaJuego ;
    protected Coordenada coordenadaDeBase;

    protected DisplayNotificaciones displayNotificaciones;
    private DisplayEstado displayEstado;
    private DisplayMapa displayMapa;
    private DisplaySonido displaySonido;

    private Sound soundtrack;

  //  private JScrollPane panelMapa;
   // private JPanel panelLateral;
    protected JPanel contenedor;
    protected JPanel panelSuperior;
    protected JPanel panelInferior;
    private PanelAcciones panelAcciones;

    protected WraperAccionConstruir accionConstruirEnEspera;
    private WraperAccionActuar accionActuarEnEspera;


    public void setAccionConstruirEnEspera(AccionConstruir accion) {
        this.accionConstruirEnEspera.setAccionConstruir(accion);
    }

    public AccionConstruir getAccionConstruirEnEspera() {
        return accionConstruirEnEspera.getAccionConstruir();
    }

    // Metodos -------------------------
    protected void init(){
        ObservadorEstado.getInstance().agregarVentana(this);
        this.accionConstruirEnEspera = new WraperAccionConstruir();
        this.accionActuarEnEspera = new WraperAccionActuar();
        this.inicializarSonido();
        this.crearPaneles();
        this.add(this.contenedor);


    }

    private void inicializarSonido(){
        this.soundtrack = new Sound("sounds/soundtrack.wav");
    }

    public void activarMusica(){
        this.soundtrack.playLoop();

    }

    public void desactivarMusica(){
        this.soundtrack.stop();
    }

    private void crearPaneles(){

        this.crearContenedor();

        this.crearPanelSuperior();
        this.crearPanelMapa();
        this.crearPanelLateral();
        this.crearPanelInferior();

        //this.agregarAlContenedor();

    }
    private void crearPanelLateral() {
        JPanel panelLateral = new JPanel();
        panelLateral.setLayout(new BoxLayout(panelLateral, BoxLayout.Y_AXIS));
        this.displayNotificaciones = new DisplayNotificaciones();
        this.displayEstado = new DisplayEstado();
       // this.panelLateral.setPreferredSize(displayNotificaciones.getDimension());
       // this.panelLateral.setMaximumSize(displayNotificaciones.getDimension());

        panelLateral.add(displayNotificaciones);
        panelLateral.add(displayEstado);

        this.contenedor.add(panelLateral, "West");
    }

    private void crearContenedor(){

        this.contenedor = new JPanel();
        this.contenedor.setLayout(new BorderLayout());

    }

    protected void crearPanelSuperior(){
        this.panelSuperior = new JPanel();
        this.panelSuperior.setLayout(new BoxLayout(panelSuperior, BoxLayout.X_AXIS));
        this.panelSuperior.setPreferredSize(new Dimension(700, 35));

        this.displaySonido = new DisplaySonido(soundtrack);
        this.panelSuperior.add(displaySonido);
        this.contenedor.add(this.panelSuperior, "North");

    }

    protected void crearPanelInferior(){
        this.panelInferior = new JPanel( new BorderLayout() );

        this.panelAcciones = new PanelAcciones(accionActuarEnEspera);
        DisplayAcciones displayAcciones = new DisplayAcciones();
        displayAcciones.agregarBotonera(panelAcciones);

        this.panelInferior.add(displayAcciones, "Center");

        this.panelInferior.add(new PanelTerminarTurno(ventanaJuego), "East");

        this.contenedor.add(this.panelInferior, "South");

    }

    private void crearPanelMapa(){

        AutoScrollablePanel contenedor = new AutoScrollablePanel();
        this.displayMapa = new DisplayMapa(this);

        contenedor.add(displayMapa);

        JScrollPane panelMapa = new JScrollPane(contenedor);


        Point vistaInicialDeJugador = new Point( ((coordenadaDeBase.getX()-(19/2))*64),((27-coordenadaDeBase.getY()-(16/2))*64));
        panelMapa.getViewport().setViewPosition(vistaInicialDeJugador);

        this.contenedor.add(panelMapa, "Center");

    }


/*
    private void agregarAlContenedor(){

        this.contenedor.add(this.panelSuperior, "North");
        this.contenedor.add(this.panelLateral, "West");
        this.contenedor.add(this.panelMapa, "Center");
        this.contenedor.add(this.panelInferior, "South");

    }
    */
    public void mostrarPanelDeEstado(JPanel panelDeEstado){
        this.displayEstado.mostrarPanel(panelDeEstado);
    }

    public PanelAcciones getPanelAcciones() {
        return panelAcciones;
    }

    public void borrarPanelDeEstadoAnterior() {
        this.displayEstado.limpiarPanel();

    }

    public DisplayNotificaciones getDisplayNotificaciones(){
        return displayNotificaciones;
    }

    @Override
    public void repaint(){
        this.actualizarPanelDeEstado();
        this.actualizarMapa();
    }

    private  void actualizarMapa(){
        this.displayMapa.actualizarDisplayMapa();
    }

    public void actualizarPanelDeEstado() {
        this.displayEstado.repaint();
    }

    public Jugador obtenerJugador(){
        return (new JugadorTerran());
    }

    public AccionUnidad getAccionActuarEnEspera() {
        return accionActuarEnEspera.getAccionActuar();
    }

    public void reactivarSonido() {
        if(this.displaySonido.silenciamientoDeSonidoActivado()){
            this.desactivarMusica();
        }else{
            this.activarMusica();
        }

    }
}

