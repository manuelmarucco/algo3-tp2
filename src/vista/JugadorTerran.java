package vista;

import vista.auxiliares.jugador.BotoneraDeConstruccionesTerran;
import vista.auxiliares.jugador.BotoneraDeUnidadesTerran;
import vista.auxiliares.jugador.DisplayMapa;
import vista.auxiliares.jugador.DisplayRecursos;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.awt.event.MouseMotionListener;

public class JugadorTerran extends JFrame {

    // Atributos ---------------------

    private JPanel contenedor;

    private JPanel panelRecursos;
    private JScrollPane panelMapa;
    private JPanel panelBotonera;

    // Main ---------------------------

    public static void main(String[] args){

        JugadorTerran ventanaJugador = new JugadorTerran();

        ventanaJugador.pack();
        ventanaJugador.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        ventanaJugador.setVisible(true);

    }

    // Metodos -------------------------

    public JugadorTerran(){

        this.init();

    }

    private void init(){

        this.crearPaneles();

        this.add(new JScrollPane(this.contenedor));

    }

    private void crearPaneles(){

        this.crearContenedor();

        this.crearPanelRecursos();
        this.crearPanelMapa();
        this.crearPanelBotonera();

        this.agregarAlContenedor();

    }

    private void crearContenedor(){

        this.contenedor = new JPanel();
        this.contenedor.setLayout(new BoxLayout(this.contenedor, BoxLayout.Y_AXIS));

    }

    private void crearPanelRecursos(){

        this.panelRecursos = new JPanel();

        this.panelRecursos.add( new DisplayRecursos() );
        this.panelRecursos.setPreferredSize( new Dimension(700, 25) );

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
                //mousePosition.setLocation(e.getX(),e.getY());
                Rectangle r = new Rectangle(e.getX()-80, e.getY()-80, 120, 120);

                // while(x == e.getX() &&  y == e.getY())
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

        this.panelMapa.setPreferredSize(new Dimension(700,500));

    }

    private void crearPanelBotonera(){

        this.panelBotonera = new JPanel( new GridLayout(2,2,0,0) );

        JLabel tituloConstrucciones = new JLabel("Construcciones");
        tituloConstrucciones.setVerticalAlignment(JLabel.CENTER);
        tituloConstrucciones.setHorizontalAlignment(JLabel.CENTER);

        this.panelBotonera.add(tituloConstrucciones);

        JLabel tituloUnidades = new JLabel("Unidades");
        tituloUnidades.setVerticalAlignment(JLabel.CENTER);
        tituloUnidades.setHorizontalAlignment(JLabel.CENTER);

        this.panelBotonera.add(tituloUnidades);

        this.panelBotonera.add( new BotoneraDeConstruccionesTerran() );
        this.panelBotonera.add( new BotoneraDeUnidadesTerran() );

    }

    private void agregarAlContenedor(){

        this.contenedor.add( this.panelRecursos );
        this.contenedor.add( this.panelMapa );
        this.contenedor.add( this.panelBotonera );

    }

}
