package vista.auxiliares.jugador.displays;

import control.BufferImagenes;
import jugabilidad.auxiliares.Recursos;
import jugabilidad.auxiliares.Suministros;
import vista.auxiliares.jugador.observadores.ObservadorRecursosSuministros;

import javax.swing.*;
import java.awt.*;

public class DisplayRecursos extends JPanel {

    private JPanel panel;
    private Recursos recursosDeJugador;
    private Suministros suministrosDeJugador;
    private BufferImagenes bufferImagenes;

    // Metodos ------------------------------

    public DisplayRecursos(Recursos recursos, Suministros suministros){

        ObservadorRecursosSuministros.getInstance().agregarDisplay(this);
        this.recursosDeJugador = recursos;
        this.suministrosDeJugador = suministros;
        this.init();

    }

    private void init(){

        this.bufferImagenes = new BufferImagenes();

        this.panel = new JPanel( new GridLayout(1,3,0,3));

        this.agregarIndicadores();
        this.add(this.panel);

    }
    public void actualizarDisplayRecursos(){
        this.removeAll();
        this.revalidate();

        this.panel.removeAll();
        this.panel.revalidate();

        this.init();

        this.add(this.panel);

        this.panel.repaint();

    }

    private void agregarIndicadores(){

        this.agregarIndicadorMinerales();
        this.agregarIndicadorGas();
        this.agregarIndicadorSuministros();

    }

    private void agregarIndicadorMinerales(){
        JPanel panelCristal = new JPanel();
        JLabel cristal = new JLabel( this.bufferImagenes.obtenerImagen("iconoCristal") );

        panelCristal.setLayout(new BoxLayout(panelCristal, BoxLayout.X_AXIS));
        cristal.setText("Cristal: ");

        panelCristal.add(cristal);
        panelCristal.add(new JLabel(String.valueOf(recursosDeJugador.getMinerales())));
        this.panel.add(panelCristal);

    }

    private void agregarIndicadorGas(){
        JPanel panelGasVespeno = new JPanel();
        JLabel gasVespeno = new JLabel(this.bufferImagenes.obtenerImagen("iconoGas") );

        panelGasVespeno.setLayout(new BoxLayout(panelGasVespeno, BoxLayout.X_AXIS));
        gasVespeno.setText("Gas vespeno: ");

        panelGasVespeno.add(gasVespeno);
        panelGasVespeno.add(new JLabel(String.valueOf(recursosDeJugador.getGasVespeno())));
        this.panel.add(panelGasVespeno);

    }

    private void agregarIndicadorSuministros(){

        JPanel panelSuministros = new JPanel();
        JLabel suministros = new JLabel(this.bufferImagenes.obtenerImagen("iconoSuministro") );

        panelSuministros.setLayout(new BoxLayout(panelSuministros, BoxLayout.X_AXIS));
        suministros.setText("Suministros: ");


        panelSuministros.add(Box.createRigidArea(new Dimension(9,5)));
        panelSuministros.add(suministros);
        panelSuministros.add(new JLabel(String.valueOf(suministrosDeJugador.getSuministrosUsados()+"/")));
        panelSuministros.add(new JLabel(String.valueOf(suministrosDeJugador.getSuministrosLimiteActuales())));
        this.panel.add(panelSuministros);
    }

}
