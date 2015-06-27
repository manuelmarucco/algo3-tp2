package vista.ventanaJugadores;

import jugabilidad.Jugador;
import jugabilidad.RazaDeJugador.JugadorTerran;
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
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.awt.event.MouseMotionListener;

public abstract class VentanaJugador extends JFrame {

    // Atributos ---------------------
    protected VentanaJuego ventanaJuego ;
    protected JPanel contenedor;
    protected DisplayNotificaciones displayNotificaciones;
    private DisplayEstado displayEstado;

    protected JPanel panelRecursos;
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

        //--//this.panelLateral.add(displayNotificaciones);
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

        JPanel contenedor = new JPanel(new GridBagLayout());
       // DisplayMapa displayMapa = new DisplayMapa(this);
        contenedor.add(new DisplayMapa(this));

        this.panelMapa = new JScrollPane(contenedor);
        //this.panelMapa.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        //this.panelMapa.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_NEVER);

        MouseMotionListener doScrollRectToVisible = new MouseMotionAdapter() {
            @Override
            public void mouseMoved(MouseEvent e) {
                Rectangle r = new Rectangle(e.getX()-80, e.getY()-80, 120,120);

                ((JPanel) e.getSource()).scrollRectToVisible(r);

            }

            ///Para que se mueva mas rapido hay que setearle mas grande los limites del rectangulo
            //---------------
            //Se puede hacer con "mouseDragged" y la unica diferencia es que hay que hacer click,mantener apretado
            //y pararte sobre el borde de la imagen y se mueve solo. Para que funcione bien bien va a ver que meterle
            //unos bordes laterales.
        };

        contenedor.addMouseMotionListener(doScrollRectToVisible);
        contenedor.setAutoscrolls(true);

        //this.panelMapa.setPreferredSize(new Dimension(700, 650));

    }


    private void agregarAlContenedor(){

        this.contenedor.add(this.panelRecursos, "North");
        this.contenedor.add(this.panelLateral, "West");
        this.contenedor.add(this.panelMapa, "Center");
        this.contenedor.add(this.panelInferior, "South");

    }
/*
    public void mostrarPanelDeAcciones(JComponent component,String posicion){
        this.panelInferior.add(component,posicion);
    }
*/
    public void mostrarPanelDeEstado(JPanel panelDeEstado){
        this.panelLateral.add(panelDeEstado);
        this.panelLateral.revalidate();
        this.panelLateral.repaint();
    }

    public PanelAcciones getPanelAcciones() {
        return panelAcciones;
    }

    public void borrarPanelDeEstadoAnterior() {
       if(this.panelLateral.getComponents().length == 1) return;
       this.panelLateral.remove(1); //posicion del Panel de Estado

        this.panelLateral.revalidate();
        this.panelLateral.repaint();

    }

    public DisplayNotificaciones getDisplayNotificaciones(){
        return displayNotificaciones;
    }

    public void repaint(){
        this.panelRecursos.revalidate();
        this.panelRecursos.repaint();

        this.panelLateral.revalidate();
        this.panelLateral.repaint();

        this.panelMapa.revalidate();
        this.panelMapa.repaint();
    }

    public Jugador obtenerJugador(){
        return (new JugadorTerran());
    }

    public AccionUnidad getAccionActuarEnEspera() {
        return accionActuarEnEspera.getAccionActuar();
    }

    public void actualizarPanelDeEstado() {

        if(this.panelLateral.getComponents().length == 1) return;
        this.panelLateral.getComponent(1).repaint(); //panel de estado
    }
}

