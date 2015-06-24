package vista.auxiliares.jugador;

import jugabilidad.auxiliares.Recursos;
import jugabilidad.auxiliares.Suministros;
import vista.ventanaJugadores.ObservadorRecursosSuministros;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class DisplayRecursos extends JPanel {

    private BufferedImage[] imagenes;
    private JPanel panel;
    private Recursos recursosDeJugador;
    private Suministros suministrosDeJugador;

    // Metodos ------------------------------

    public DisplayRecursos(Recursos recursos, Suministros suministros){

        ObservadorRecursosSuministros.getInstance().agregarDisplay(this);
        this.recursosDeJugador = recursos;
        this.suministrosDeJugador = suministros;
        this.init();

    }

    private void init(){

        this.panel = new JPanel( new GridLayout(1,3,0,3));
        this.cargarImagenes();

        this.agregarIndicadores();
        this.add(this.panel);

    }
    public void actualizarDisplayRecursos(){

        this.panel.removeAll();
        this.init();

        this.add(this.panel);

    }
    private void cargarImagenes(){

        try{

            this.imagenes = new BufferedImage[3];
            this.imagenes[0] = ImageIO.read(getClass().getResource("imagenesRecursos/iconoMineral.png"));
            this.imagenes[1] = ImageIO.read(getClass().getResource("imagenesRecursos/iconoGasVespeno.png"));
            this.imagenes[2] = ImageIO.read(getClass().getResource("imagenesRecursos/man.jpg"));

            imagenes[0] = this.cambiarTamanio(imagenes[0],17,17); // se cambia el tamanio sin que se pixele
            imagenes[1] = this.cambiarTamanio(imagenes[1],17,17);

        } catch ( IOException e){
            e.printStackTrace();
        }

    }

    private void agregarIndicadores(){

        this.agregarIndicadorMinerales();
        this.agregarIndicadorGas();
        this.agregarIndicadorSuministros();

    }

    private void agregarIndicadorMinerales(){
        JPanel panelCristal = new JPanel();
        JLabel cristal = new JLabel(new ImageIcon( imagenes[0] ) );

        panelCristal.setLayout(new BoxLayout(panelCristal, BoxLayout.X_AXIS));
        cristal.setText("Cristal: ");

        panelCristal.add(cristal);
        panelCristal.add(new JLabel(String.valueOf(recursosDeJugador.getMinerales())));
        this.panel.add(panelCristal);

    }

    private void agregarIndicadorGas(){
        JPanel panelGasVespeno = new JPanel();
        JLabel gasVespeno = new JLabel(new ImageIcon( imagenes[1] ) );

        panelGasVespeno.setLayout(new BoxLayout(panelGasVespeno, BoxLayout.X_AXIS));
        gasVespeno.setText("Gas vespeno: ");

        panelGasVespeno.add(gasVespeno);
        panelGasVespeno.add(new JLabel(String.valueOf(recursosDeJugador.getGasVespeno())));
        this.panel.add(panelGasVespeno);

    }

    private void agregarIndicadorSuministros(){

        JPanel panelSuministros = new JPanel();
        JLabel suministros = new JLabel(new ImageIcon( imagenes[2] ) );

        panelSuministros.setLayout(new BoxLayout(panelSuministros, BoxLayout.X_AXIS));
        suministros.setText("Suministros: ");


        panelSuministros.add(suministros);
        panelSuministros.add(new JLabel(String.valueOf(suministrosDeJugador.getSuministrosUsados()+"/")));
        panelSuministros.add(new JLabel(String.valueOf(suministrosDeJugador.getSuministrosLimiteActuales())));
        this.panel.add(panelSuministros);
    }

    private static BufferedImage cambiarTamanio(BufferedImage img, int newW, int newH) {
        Image tmp = img.getScaledInstance(newW, newH, Image.SCALE_SMOOTH);
        BufferedImage dimg = new BufferedImage(newW, newH, BufferedImage.TYPE_INT_ARGB);

        Graphics2D g2d = dimg.createGraphics();
        g2d.drawImage(tmp, 0, 0, null);
        g2d.dispose();

        return dimg;
    }

}
