package vista.ventanaJugadores;

import jugabilidad.Jugador;
import jugabilidad.RazaDeJugador.JugadorTerran;
import jugabilidad.utilidadesMapa.Coordenada;
import vista.Actions.WraperAccionActuar;
import vista.Actions.WraperAccionConstruir;
import vista.Actions.accionesConstruir.AccionConstruir;
import vista.Actions.accionesUnidades.AccionUnidad;
import vista.VentanaJuego;
import vista.auxiliares.jugador.DisplayMapa;
import vista.auxiliares.jugador.DisplayNotificaciones;
import vista.auxiliares.jugador.PanelAcciones;
import vista.auxiliares.jugador.PanelTerminarTurno;

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

    protected JPanel panelRecursos; //TODO me parece que se podrian sacar estos atributos y ser locales
    private JScrollPane panelMapa;
    private JPanel panelLateral;
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
        this.crearPaneles();
        this.add(this.contenedor);


    }

    private void crearPaneles(){

        this.crearContenedor();

        this.crearPanelRecursos();
        this.crearPanelMapa();
        this.crearPanelLateral();
        this.crearPanelInferior();

        this.agregarAlContenedor();

    }
    private void crearPanelLateral() {
        this.panelLateral = new JPanel();
        this.panelLateral.setLayout(new BoxLayout(panelLateral, BoxLayout.Y_AXIS));
        this.displayNotificaciones = new DisplayNotificaciones();
        this.displayEstado = new DisplayEstado();
       // this.panelLateral.setPreferredSize(displayNotificaciones.getDimension());
       // this.panelLateral.setMaximumSize(displayNotificaciones.getDimension());

        this.panelLateral.add(displayNotificaciones);
        this.panelLateral.add(displayEstado);
    }

    private void crearContenedor(){

        this.contenedor = new JPanel();
        this.contenedor.setLayout(new BorderLayout());

    }

    protected void crearPanelRecursos(){
        this.panelRecursos = new JPanel();
        this.panelRecursos.setPreferredSize(new Dimension(700, 35));
    }

    protected void crearPanelInferior(){
        this.panelAcciones=new PanelAcciones(accionActuarEnEspera);
        this.panelInferior = new JPanel( new BorderLayout() );
        this.panelInferior.add(new PanelTerminarTurno(ventanaJuego), "East");
        this.panelInferior.add(panelAcciones, "Center");

    }

    private void crearPanelMapa(){

        AutoScrollablePanel contenedor = new AutoScrollablePanel();
        this.displayMapa = new DisplayMapa(this);

        contenedor.add(displayMapa);

        this.panelMapa = new JScrollPane(contenedor);


        Point vistaInicialDeJugador = new Point( ((coordenadaDeBase.getX()-(19/2))*64),((27-coordenadaDeBase.getY()-(16/2))*64));


        this.panelMapa.getViewport().setViewPosition(vistaInicialDeJugador);

    }


    private void agregarAlContenedor(){

        this.contenedor.add(this.panelRecursos, "North");
        this.contenedor.add(this.panelLateral, "West");
        this.contenedor.add(this.panelMapa, "Center");
        this.contenedor.add(this.panelInferior, "South");

    }
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

}

