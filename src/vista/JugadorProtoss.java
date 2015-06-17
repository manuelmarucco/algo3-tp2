package vista;

import vista.auxiliares.jugador.*;

import javax.swing.*;
import java.awt.*;

public class JugadorProtoss extends JFrame {

    // Atributos ---------------------

    private JPanel contenedor;

    private JPanel panelRecursos;
    private JPanel panelMapa;
    private JPanel panelBotonera;

    // Main ---------------------------

    public static void main(String[] args){

        JugadorProtoss ventanaJugador = new JugadorProtoss();

        ventanaJugador.pack();
        ventanaJugador.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        ventanaJugador.setVisible(true);

    }

    // Metodos -------------------------

    public JugadorProtoss(){

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

        this.panelMapa = new JPanel();
        this.panelMapa.add(new DisplayMapa(200,200));
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

        this.panelBotonera.add( new BotoneraDeConstruccionesProtoss() );
        this.panelBotonera.add( new BotoneraDeUnidadesProtoss() );

    }

    private void agregarAlContenedor(){

        this.contenedor.add( this.panelRecursos );
        this.contenedor.add( this.panelMapa );
        this.contenedor.add( this.panelBotonera );

    }

}
