package vista;

import vista.auxiliares.jugador.BotoneraDeConstruccionesTerran;
import vista.auxiliares.jugador.BotoneraDeUnidadesTerran;
import vista.auxiliares.jugador.DisplayRecursos;

import javax.swing.*;
import java.awt.*;

public class JugadorTerran extends JFrame {

    // Atributos ---------------------

    private JPanel contenedor;

    private JPanel panelRecursos;
    private JPanel panelMapa;
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

        this.panelMapa = new JPanel();
        this.panelMapa.add(new DisplayMapa(200,200));
        this.panelMapa.setPreferredSize(new Dimension(700,500));

    }

    private void crearPanelBotonera(){

        this.panelBotonera = new JPanel( new GridLayout(2,2,0,0) );

        this.panelBotonera.add(new JLabel("Construcciones"));
        this.panelBotonera.add(new JLabel("Unidades"));
        this.panelBotonera.add( new BotoneraDeConstruccionesTerran() );
        this.panelBotonera.add( new BotoneraDeUnidadesTerran() );

    }

    private void agregarAlContenedor(){

        this.contenedor.add( this.panelRecursos );
        this.contenedor.add( this.panelMapa );
        this.contenedor.add( this.panelBotonera );

    }

}
