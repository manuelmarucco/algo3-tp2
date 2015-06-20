package vista.vistasJugadores;

import vista.auxiliares.jugador.DisplayMapa;
import vista.auxiliares.jugador.DisplayNotificaciones;
import vista.auxiliares.jugador.DisplayRecursos;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.awt.event.MouseMotionListener;

public abstract class VistaJugador extends JFrame {

    // Atributos ---------------------

    protected JPanel contenedor;

    private JPanel panelRecursos;
    private JScrollPane panelMapa;
    private JPanel panelNotificaciones;



    // Metodos -------------------------

    public VistaJugador(){

        this.init();

    }

    protected void init(){

        this.crearPaneles();

        this.add(new JScrollPane(this.contenedor));

    }

    private void crearPaneles(){

        this.crearContenedor();

        this.crearPanelRecursos();
        this.crearPanelMapa();
        this.crearPanelDeNotificaciones();

        this.agregarAlContenedor();

    }
    private void crearPanelDeNotificaciones() {
        this.panelNotificaciones = new JPanel();
        this.panelNotificaciones.add(new DisplayNotificaciones());
    }

    private void crearContenedor(){

        this.contenedor = new JPanel();
        this.contenedor.setLayout(new BorderLayout());

    }

    private void crearPanelRecursos(){

        this.panelRecursos = new JPanel();
        this.panelRecursos.add( new DisplayRecursos() );
        this.panelRecursos.setPreferredSize( new Dimension(700, 35) );

    }

    private void crearPanelMapa(){

        JPanel contenedor = new JPanel(new GridBagLayout());
        contenedor.add(new DisplayMapa());

        this.panelMapa = new JScrollPane(contenedor);
        this.panelMapa.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        this.panelMapa.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_NEVER);

        MouseMotionListener doScrollRectToVisible = new MouseMotionAdapter() {
            @Override
            public void mouseMoved(MouseEvent e) {
                Rectangle r = new Rectangle(e.getX()-80, e.getY()-80, 120, 120);

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

        this.panelMapa.setPreferredSize(new Dimension(700,650));

    }


    private void agregarAlContenedor(){

        this.contenedor.add( this.panelRecursos,"North" );
        this.contenedor.add( this.panelNotificaciones,"West" ); //tiene que estar a la izquierda junto con un panel de estado(toco marine aparece estado de marine)
        this.contenedor.add( this.panelMapa ,"Center");
        //this.contenedor.add( this.panelBotonera ,"South");

    }

}

