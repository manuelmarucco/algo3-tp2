package vista.ventanaJugadores;

import jugabilidad.Jugador;
import jugabilidad.RazaDeJugador.JugadorTerran;
import jugabilidad.utilidadesMapa.Coordenada;
import vista.Actions.accionesConstruir.AccionConstruir;
import vista.Actions.accionesUnidades.AccionUnidad;
import vista.Actions.accionesVentanaJugador.WraperAccionActuar;
import vista.Actions.accionesVentanaJugador.WraperAccionConstruir;
import vista.VentanaJuego;
import vista.auxiliares.jugador.AutoScrollablePanel;
import vista.auxiliares.jugador.PanelAcciones;
import vista.auxiliares.jugador.PanelTerminarTurno;
import vista.auxiliares.jugador.displays.*;
import vista.auxiliares.jugador.observadores.ObservadorEstado;
import vista.sonido.Sonido;

import javax.swing.*;
import java.awt.*;

public abstract class VentanaJugador extends JFrame {

    // Atributos ---------------------
    protected VentanaJuego ventanaJuego ;
    protected Coordenada coordenadaDeBase;

    protected JPanel contenedor;
    protected DisplayNotificaciones displayNotificaciones;
    private DisplayEstado displayEstado;
    private DisplayMapa displayMapa;
    private DisplaySonido displaySonido;
    private DisplayAcciones displayAcciones;

    private Sonido soundtrack;

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
        this.accionConstruirEnEspera = new WraperAccionConstruir();
        this.accionActuarEnEspera = new WraperAccionActuar();
        this.inicializarSonido();
        this.crearPaneles();
        this.add(this.contenedor);


       // ObservadorEstado.getInstance().agregarVentana(this);
        ObservadorEstado.getInstance().agregarDisplayEstadoDelJugador(displayEstado);
    }

    private void inicializarSonido(){
        this.soundtrack = new Sonido("sounds/soundtrack.wav");
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


    }
    private void crearPanelLateral() {
        JPanel panelLateral = new JPanel();
        panelLateral.setLayout(new BoxLayout(panelLateral, BoxLayout.Y_AXIS));
        this.displayNotificaciones = new DisplayNotificaciones();
        this.displayEstado = new DisplayEstado();

        panelLateral.add(displayNotificaciones);
        panelLateral.add(displayEstado);

        this.contenedor.add(panelLateral, "West");
    }

    private void crearContenedor(){

        this.contenedor = new JPanel();
        this.contenedor.setLayout(new BorderLayout());

    }
    protected JPanel crearPanelSuperior(){
        JPanel panelSuperior = new JPanel();
        panelSuperior.setLayout(new BoxLayout(panelSuperior, BoxLayout.X_AXIS));
        panelSuperior.setPreferredSize(new Dimension(700, 35));

        this.displaySonido = new DisplaySonido(soundtrack);
        panelSuperior.add(displaySonido);
        this.contenedor.add(panelSuperior, "North");

        return panelSuperior;
    }

    protected JPanel crearPanelInferior(){
        JPanel panelInferior = new JPanel( new BorderLayout() );

        PanelAcciones panelAcciones = new PanelAcciones(accionActuarEnEspera);
        this.displayAcciones = new DisplayAcciones(panelAcciones);

        panelInferior.add(displayAcciones, "Center");

        panelInferior.add(new PanelTerminarTurno(ventanaJuego), "East");

        this.contenedor.add(panelInferior, "South");

        return panelInferior;
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

    public void mostrarPanelDeEstado(JPanel panelDeEstado){
        this.displayEstado.mostrarPanel(panelDeEstado);
    }

    public PanelAcciones getPanelAcciones() {
        return this.displayAcciones.getPanelAcciones();
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

